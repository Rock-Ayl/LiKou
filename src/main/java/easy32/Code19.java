package easy32;

/**
 * @Author ayl
 * @Date 2023-08-05
 * 2778. 特殊元素平方和
 * 给你一个下标从 1 开始、长度为 n 的整数数组 nums 。
 * <p>
 * 对 nums 中的元素 nums[i] 而言，如果 n 能够被 i 整除，即 n % i == 0 ，则认为 num[i] 是一个 特殊元素 。
 * <p>
 * 返回 nums 中所有 特殊元素 的 平方和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：21
 * 解释：nums 中共有 3 个特殊元素：nums[1] ，因为 4 被 1 整除；nums[2] ，因为 4 被 2 整除；以及 nums[4] ，因为 4 被 4 整除。
 * 因此，nums 中所有元素的平方和等于 nums[1] * nums[1] + nums[2] * nums[2] + nums[4] * nums[4] = 1 * 1 + 2 * 2 + 4 * 4 = 21 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,7,1,19,18,3]
 * 输出：63
 * 解释：nums 中共有 4 个特殊元素：nums[1] ，因为 6 被 1 整除；nums[2] ，因为 6 被 2 整除；nums[3] ，因为 6 被 3 整除；以及 nums[6] ，因为 6 被 6 整除。
 * 因此，nums 中所有元素的平方和等于 nums[1] * nums[1] + nums[2] * nums[2] + nums[3] * nums[3] + nums[6] * nums[6] = 2 * 2 + 7 * 7 + 1 * 1 + 3 * 3 = 63 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length == n <= 50
 * 1 <= nums[i] <= 50
 */
public class Code19 {

    public int sumOfSquares(int[] nums) {
        //和
        int sum = 0;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //如果不是
            if (nums.length % (i + 1) != 0) {
                //本轮过
                continue;
            }
            //计算
            sum += nums[i] * nums[i];
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code19().sumOfSquares(new int[]{2, 7, 1, 19, 18, 3}));
    }

}
