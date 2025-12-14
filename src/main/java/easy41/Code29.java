package easy41;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-12-14
 * 100933. 最大和最小 K 个元素的绝对差
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k。
 * <p>
 * 请计算以下两者的绝对差值：
 * <p>
 * 数组中 k 个 最大 元素的总和；
 * 数组中 k 个 最小 元素的总和。
 * 返回表示此差值的整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [5,2,2,4], k = 2
 * <p>
 * 输出： 5
 * <p>
 * 解释：
 * <p>
 * k = 2 个最大的元素是 4 和 5。它们的总和是 4 + 5 = 9。
 * k = 2 个最小的元素是 2 和 2。它们的总和是 2 + 2 = 4。
 * 绝对差值是 abs(9 - 4) = 5。
 * 示例 2：
 * <p>
 * 输入： nums = [100], k = 1
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 最大的元素是 100。
 * 最小的元素是 100。
 * 绝对差值是 abs(100 - 100) = 0。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == nums.length <= 100
 * 1 <= nums[i] <= 100
 * 1 <= k <= n
 */
public class Code29 {

    public int absDifference(int[] nums, int k) {
        //排序
        Arrays.sort(nums);
        //结果
        int sum = 0;
        //循环
        for (int i = Math.max(nums.length - k, 0); i < nums.length; i++) {
            //叠加
            sum += nums[i];
        }
        //循环
        for (int i = 0; i < Math.min(nums.length, k); i++) {
            //减去
            sum -= nums[i];
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code29().absDifference(new int[]{5, 2, 2, 4}, 2));
    }

}
