package normal36;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2024-11-02
 * 2342. 数位和相等数对的最大和
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。请你选出两个下标 i 和 j（i != j），且 nums[i] 的数位和 与  nums[j] 的数位和相等。
 * <p>
 * 请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [18,43,36,13,7]
 * 输出：54
 * 解释：满足条件的数对 (i, j) 为：
 * - (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
 * - (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
 * 所以可以获得的最大和是 54 。
 * 示例 2：
 * <p>
 * 输入：nums = [10,12,19,14]
 * 输出：-1
 * 解释：不存在满足条件的数对，返回 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 */
public class Code21 {

    //计算位数和
    private int countSum(int number) {
        //和
        int sum = 0;
        //循环
        while (number > 0) {
            //计算和
            sum += number % 10;
            //下一个
            number = number / 10;
        }
        //返回
        return sum;
    }

    public int maximumSum(int[] nums) {
        //分组Map
        Map<Integer, PriorityQueue<Integer>> groupMap = new HashMap<>();
        //循环
        for (int i = 0; i < nums.length; i++) {
            //计算分组
            int group = countSum(nums[i]);
            //如果不存在
            if (groupMap.containsKey(group) == false) {
                //初始化优先队列
                groupMap.put(group, new PriorityQueue<>((a, b) -> b - a));
            }
            //记录数字
            groupMap.get(group).add(nums[i]);
        }
        //最大可能
        int max = -1;
        //循环
        for (PriorityQueue<Integer> queue : groupMap.values()) {
            //如果不够
            if (queue.size() < 2) {
                //本轮过
                continue;
            }
            //获取本次和
            int thisSum = queue.poll() + queue.peek();
            //刷新
            max = Math.max(max, thisSum);
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code21().maximumSum(new int[]{18, 43, 36, 13, 7}));;
    }

}
