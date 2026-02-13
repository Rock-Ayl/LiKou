package normal50;

import java.util.*;

/**
 * 3180. 执行操作可获得的最大总奖励 I
 * 算术评级: 5
 * 第 401 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1849
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 rewardValues，长度为 n，代表奖励的值。
 * <p>
 * 最初，你的总奖励 x 为 0，所有下标都是 未标记 的。你可以执行以下操作 任意次 ：
 * <p>
 * 从区间 [0, n - 1] 中选择一个 未标记 的下标 i。
 * 如果 rewardValues[i] 大于 你当前的总奖励 x，则将 rewardValues[i] 加到 x 上（即 x = x + rewardValues[i]），并 标记 下标 i。
 * 以整数形式返回执行最优操作能够获得的 最大 总奖励。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：rewardValues = [1,1,3,3]
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * 依次标记下标 0 和 2，总奖励为 4，这是可获得的最大值。
 * <p>
 * 示例 2：
 * <p>
 * 输入：rewardValues = [1,6,4,3,2]
 * <p>
 * 输出：11
 * <p>
 * 解释：
 * <p>
 * 依次标记下标 0、2 和 1。总奖励为 11，这是可获得的最大值。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= rewardValues.length <= 2000
 * 1 <= rewardValues[i] <= 2000
 *
 */
public class Code12 {

    public int maxTotalReward(int[] rewardValues) {

        /**
         * 处理集合
         */

        //去重集合
        Set<Integer> partSet = new HashSet<>();
        //最大值
        int maxNumber = 0;
        //循环
        for (int num : rewardValues) {
            //刷新最大
            maxNumber = Math.max(num, maxNumber);
            //记录去重
            partSet.add(num);
        }
        //转为列表
        List<Integer> partList = new ArrayList<>(partSet);
        //排序
        partList.sort(Comparator.reverseOrder());

        /**
         * 动态规划
         */

        //最大结果
        int max = partList.get(0);
        //动态规划
        int[] arr = new int[maxNumber * 2 + 1];
        //开始情况
        for (Integer first : partList) {
            //初始化开始
            arr[first] = 1;
        }
        //循环
        for (int i = 0; i < arr.length; i++) {
            //如果没有值
            if (arr[i] == 0) {
                //本轮过
                continue;
            }
            //循环
            for (Integer part : partList) {
                //如果不够大
                if (part <= i) {
                    //跳出
                    break;
                }
                //本次
                int target = part + i;
                //记录
                arr[target] = 1;
                //刷新最大
                max = Math.max(max, target);
            }
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        //System.out.println(new Code12().maxTotalReward(new int[]{1, 6, 4, 3, 2}));
        //System.out.println(new Code12().maxTotalReward(new int[]{1, 1, 3, 3}));
        System.out.println(new Code12().maxTotalReward(new int[]{3, 3}));
    }

}
