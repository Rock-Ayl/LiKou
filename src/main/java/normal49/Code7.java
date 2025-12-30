package normal49;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-12-30
 * 3788. 分割的最大得分
 * 算术评级: 3
 * 同步题目状态
 * <p>
 * 中等
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums。
 * <p>
 * 请你选出一个下标 i 以分割数组，该下标满足 0 <= i < n - 1。
 * <p>
 * 对于选择的分割下标 i：
 * <p>
 * 令 prefixSum(i) 表示数组前缀的和，即 nums[0] + nums[1] + ... + nums[i]。
 * 令 suffixMin(i) 表示数组后缀的最小值，即 nums[i + 1], nums[i + 2], ..., nums[n - 1] 中的最小值。
 * 在下标 i 的 分割得分 定义为：
 * <p>
 * score(i) = prefixSum(i) - suffixMin(i)
 * <p>
 * 返回所有有效分割下标中 最大 的分割得分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [10,-1,3,-4,-5]
 * <p>
 * 输出： 17
 * <p>
 * 解释：
 * <p>
 * 最优的分割下标是 i = 2，score(2) = prefixSum(2) - suffixMin(2) = (10 + (-1) + 3) - (-5) = 17。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [-7,-5,3]
 * <p>
 * 输出： -2
 * <p>
 * 解释：
 * <p>
 * 最优的分割下标是 i = 0，score(0) = prefixSum(0) - suffixMin(0) = (-7) - (-5) = -2。
 * <p>
 * 示例 3：
 * <p>
 * 输入： nums = [1,1]
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 唯一有效分割下标是 i = 0，score(0) = prefixSum(0) - suffixMin(0) = 1 - 1 = 0。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * -109​​​​​​​ <= nums[i] <= 109
 */
public class Code7 {

    public long maximumScore(int[] nums) {
        //前缀和
        int[] sumArr = new int[nums.length];
        //填充
        Arrays.fill(sumArr, nums[nums.length - 1]);
        //循环
        for (int i = nums.length - 2; i >= 0; i--) {
            //刷新最小
            sumArr[i] = Math.min(sumArr[i + 1], nums[i]);
        }
        //结果
        long result = Long.MIN_VALUE;
        //和
        long sum = 0L;
        //循环
        for (int i = 0; i < nums.length - 1; i++) {
            //叠加前缀和
            sum += nums[i];
            //目标值
            long target = sum - ((i + 1 < nums.length) ? sumArr[i + 1] : 0);
            //刷新最大
            result = Math.max(result, target);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().maximumScore(new int[]{1, 1}));
    }

}
