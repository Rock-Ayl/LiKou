package easy43;

/**
 * 3903. 最小稳定下标 I
 * 算术评级: 2
 * 第 498 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1235
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums 和一个整数 k。
 * <p>
 * 对于每个下标 i，定义它的 不稳定值 为 max(nums[0..i]) - min(nums[i..n - 1])。
 * <p>
 * 换句话说：
 * <p>
 * max(nums[0..i]) 表示从下标 0 到下标 i 的元素中的 最大值 。
 * min(nums[i..n - 1]) 表示从下标 i 到下标 n - 1 的元素中的 最小值 。
 * 如果某个下标 i 的不稳定值 小于等于 k，则称该下标为 稳定下标 。
 * <p>
 * 返回 最小 的稳定下标。如果不存在这样的下标，则返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [5,0,1,4], k = 3
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 在下标 0 处：[5] 中的最大值是 5，[5, 0, 1, 4] 中的最小值是 0，因此不稳定值为 5 - 0 = 5。
 * 在下标 1 处：[5, 0] 中的最大值是 5，[0, 1, 4] 中的最小值是 0，因此不稳定值为 5 - 0 = 5。
 * 在下标 2 处：[5, 0, 1] 中的最大值是 5，[1, 4] 中的最小值是 1，因此不稳定值为 5 - 1 = 4。
 * 在下标 3 处：[5, 0, 1, 4] 中的最大值是 5，[4] 中的最小值是 4，因此不稳定值为 5 - 4 = 1。
 * 这是第一个不稳定值小于等于 k = 3 的下标，因此答案是 3。
 * 示例 2：
 * <p>
 * 输入： nums = [3,2,1], k = 1
 * <p>
 * 输出： -1
 * <p>
 * 解释：
 * <p>
 * 在下标 0 处，不稳定值为 3 - 1 = 2。
 * 在下标 1 处，不稳定值为 3 - 1 = 2。
 * 在下标 2 处，不稳定值为 3 - 1 = 2。
 * 这些值都不小于等于 k = 1，因此答案是 -1。
 * 示例 3：
 * <p>
 * 输入： nums = [0], k = 0
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 在下标 0 处，不稳定值为 0 - 0 = 0，它小于等于 k = 0。因此答案是 0。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 * 0 <= k <= 109
 */
public class Code3 {

    public int firstStableIndex(int[] nums, int k) {

        /**
         * 统计每个索引最小
         */

        //数组
        int[] minArr = new int[nums.length];
        //最后一个
        minArr[nums.length - 1] = nums[nums.length - 1];
        //循环
        for (int i = nums.length - 2; i >= 0; i--) {
            //刷新最小
            minArr[i] = Math.min(minArr[i + 1], nums[i]);
        }

        /**
         * 初始化第一个
         */

        //最大
        int max = nums[0];
        //不稳定值
        int targetNum = max - minArr[0];
        //如果当前是
        if (targetNum <= k) {
            //返回结果
            return 0;
        }

        /**
         * 计算后续
         */

        //循环
        for (int i = 1; i < nums.length; i++) {
            //刷新最大
            max = Math.max(max, nums[i]);
            //刷新不稳定值
            targetNum = max - minArr[i];
            //判断
            if (targetNum <= k) {
                //返回结果
                return i;
            }
        }
        //默认
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().firstStableIndex(new int[]{5, 0, 1, 4}, 3));
    }

}
