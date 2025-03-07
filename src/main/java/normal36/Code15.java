package normal36;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2024-10-25
 * 134. 加油站
 * 中等
 * 相关标签
 * 相关企业
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2:
 * <p>
 * 输入: gas = [2,3,4], cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 * <p>
 * <p>
 * 提示:
 * <p>
 * gas.length == n
 * cost.length == n
 * 1 <= n <= 105
 * 0 <= gas[i], cost[i] <= 104
 */
public class Code15 {

    //尝试行走
    private boolean walk(int[] gas, int[] cost, int start) {
        //初始化汽油
        int sum = gas[start] - cost[start];
        //如果不够
        if (sum < 0) {
            //不可以
            return false;
        }
        //记录目标、并移动
        int target = start++;
        //循环
        while (start != target) {
            //如果越界了
            if (start >= gas.length) {
                //从0开始
                start = 0;
                //重新来
                continue;
            }
            //叠加
            sum += gas[start] - cost[start];
            //如果不够了
            if (sum < 0) {
                //不可以
                return false;
            }
            //下一个
            start++;
        }
        //返回
        return true;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        //缓存
        int[] arr = new int[gas.length];
        //求和
        int gasSum = 0;
        int costSum = 0;
        //第一个正数的数组
        List<Integer> firstRightIndexList = new ArrayList<>();
        //循环
        for (int i = 0; i < arr.length; i++) {
            //计算差
            arr[i] = gas[i] - cost[i];
            //求和
            gasSum += gas[i];
            costSum += cost[i];
            //如果是非负数 and 如果前一个是负数
            if (arr[i] >= 0 && i > 0 && arr[i - 1] < 0) {
                //记录索引
                firstRightIndexList.add(i);
            }
        }
        //如果花费大于消耗
        if (costSum > gasSum) {
            //不可行
            return -1;
        }
        //默认0要尝试一番
        firstRightIndexList.add(0, 0);
        //循环
        for (Integer start : firstRightIndexList) {
            //如果满足
            if (walk(gas, cost, start)) {
                //返回
                return start;
            }
        }
        //默认不行
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code15().canCompleteCircuit(new int[]{1, 2}, new int[]{2, 1}));
    }

}
