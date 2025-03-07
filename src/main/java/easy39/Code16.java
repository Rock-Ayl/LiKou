package easy39;

/**
 * @Author ayl
 * @Date 2025-01-30
 * 3423. 循环数组中相邻元素的最大差值
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 循环 数组 nums ，请你找出相邻元素之间的 最大 绝对差值。
 * <p>
 * 注意：一个循环数组中，第一个元素和最后一个元素是相邻的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,4]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 由于 nums 是循环的，nums[0] 和 nums[2] 是相邻的，它们之间的绝对差值是最大值 |4 - 1| = 3 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [-5,-10,-5]
 * <p>
 * 输出：5
 * <p>
 * 解释：
 * <p>
 * 相邻元素 nums[0] 和 nums[1] 之间的绝对差值为最大值 |-5 - (-10)| = 5 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 */
public class Code16 {

    public int maxAdjacentDistance(int[] nums) {
        //初始化最大
        int max = Math.abs(nums[0] - nums[nums.length - 1]);
        //循环
        for (int i = 1; i < nums.length; i++) {
            //刷新本次最大
            max = Math.max(Math.abs(nums[i] - nums[i - 1]), max);
        }
        //返回
        return max;
    }

    public static void main(String[] args) {

    }

}
