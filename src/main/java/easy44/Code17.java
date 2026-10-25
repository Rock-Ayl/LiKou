package easy44;

/**
 * 4088. 峰值与谷值的差
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 给你一个长度为 n 的整数数组 nums。
 * <p>
 * 如果满足以下 所有 条件，则下标志 i 被称为 峰值 ：
 * <p>
 * 0 < i < n - 1
 * nums[i] > nums[i - 1]
 * nums[i] > nums[i + 1]
 * 如果满足以下 所有 条件，则下标志 i 被称为 谷值 ：
 * <p>
 * 0 < i < n - 1
 * nums[i] < nums[i - 1]
 * nums[i] < nums[i + 1]
 * 返回一个整数，表示所有峰值之和与所有谷值之和的 差值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,5,2,4,1,3,0]
 * <p>
 * 输出： 9
 * <p>
 * 解释：
 * <p>
 * 峰值分别是 nums[1] = 5、nums[3] = 4 和 nums[5] = 3。
 * 谷值分别是 nums[2] = 2 和 nums[4] = 1。
 * 峰值之和与谷值之和的差值为 (5 + 4 + 3) - (2 + 1) = 9。因此，答案是 9。
 * 示例 2：
 * <p>
 * 输入： nums = [-5,-6,-1,-2,5,3,2]
 * <p>
 * 输出： 12
 * <p>
 * 解释：
 * <p>
 * 峰值分别是 nums[2] = -1 和 nums[4] = 5。
 * 谷值分别是 nums[1] = -6 和 nums[3] = -2。
 * 峰值之和与谷值之和的差值为 (-1 + 5) - (-6 + (-2)) = 12。因此，答案是 12。
 * 示例 3：
 * <p>
 * 输入： nums = [6,5,2,5,5,3,6]
 * <p>
 * 输出： -5
 * <p>
 * 解释：
 * <p>
 * 数组中没有峰值。
 * 谷值分别是 nums[2] = 2 和 nums[5] = 3。
 * 峰值之和与谷值之和的差值为 (0) - (2 + 3) = -5。因此，答案是 -5。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= n == nums.length <= 100
 * -100 <= nums[i] <= 100
 */
public class Code17 {

    public int peakValleyDifference(int[] nums) {
        //和
        int sum = 0;
        //循环
        for (int i = 1; i < nums.length - 1; i++) {
            //如果是峰值
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                //+
                sum += nums[i];
            }
            //如果是谷值
            if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                //-
                sum -= nums[i];
            }
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().peakValleyDifference(new int[]{1, 5, 2, 4, 1, 3, 0}));
    }

}
