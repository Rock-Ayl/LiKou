package easy41;

/**
 * @Author ayl
 * @Date 2025-09-13
 * 3674. 数组元素相等的最小操作次数
 * 算术评级: 2
 * 第 466 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1369
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums。
 * <p>
 * 在一次操作中，可以选择任意子数组 nums[l...r] （0 <= l <= r < n），并将该子数组中的每个元素 替换 为所有元素的 按位与（bitwise AND）结果。
 * <p>
 * 返回使数组 nums 中所有元素相等所需的最小操作次数。
 * <p>
 * 子数组 是数组中连续的、非空的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,2]
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * 选择 nums[0...1]：(1 AND 2) = 0，因此数组变为 [0, 0]，所有元素在一次操作后相等。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [5,5,5]
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * nums 本身是 [5, 5, 5]，所有元素已经相等，因此不需要任何操作。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == nums.length <= 100
 * 1 <= nums[i] <= 105
 */
public class Code9 {

    public int minOperations(int[] nums) {
        //数字
        int num = nums[0];
        //循环
        for (int i = 1; i < nums.length; i++) {
            //如果不是
            if (num != nums[i]) {
                //返回
                return 1;
            }
        }
        //默认
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(18 & 95 & 77);
        System.out.println(new Code9().minOperations(new int[]{18, 95, 77}));
    }

}
