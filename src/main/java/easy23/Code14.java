package easy23;

/**
 * @Author ayl
 * @Date 2022-09-28
 * 643. 子数组最大平均数 I
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * <p>
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * 示例 2：
 * <p>
 * 输入：nums = [5], k = 1
 * 输出：5.00000
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= k <= n <= 105
 * -104 <= nums[i] <= 104
 */
public class Code14 {

    public double findMaxAverage(int[] nums, int k) {
        //初始化
        int start = 0;
        int end = k;
        //总数
        int count = 0;
        //循环
        while (start < end) {
            //叠加
            count += nums[start++];
        }
        //最大
        int maxCount = count;
        //循环
        for (int i = k; i < nums.length; i++) {
            //移动
            count = count + nums[i] - nums[i - k];
            //记录最大
            maxCount = Math.max(count, maxCount);
        }
        //返回
        return (double) maxCount / (double) k;
    }

    public static void main(String[] args) {
        System.out.println(new Code14().findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }

}
