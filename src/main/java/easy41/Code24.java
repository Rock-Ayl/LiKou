package easy41;

/**
 * @Author ayl
 * @Date 2025-11-16
 * 3745. 三元素表达式的最大值
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。
 * <p>
 * 从 nums 中选择三个元素 a、b 和 c，它们的下标需 互不相同 ，使表达式 a + b - c 的值最大化。
 * <p>
 * 返回该表达式可能的 最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,4,2,5]
 * <p>
 * 输出： 8
 * <p>
 * 解释：
 * <p>
 * 可以选择 a = 4，b = 5，c = 1。表达式的值为 4 + 5 - 1 = 8，这是可能的最大值。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [-2,0,5,-2,4]
 * <p>
 * 输出： 11
 * <p>
 * 解释：
 * <p>
 * 可以选择 a = 5，b = 4，c = -2。表达式的值为 5 + 4 - (-2) = 11，这是可能的最大值。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 */
public class Code24 {

    public int maximizeExpressionOfThree(int[] nums) {
        //最大结果
        int max = Integer.MIN_VALUE;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //循环2
            for (int j = i + 1; j < nums.length; j++) {
                //循环3
                for (int k = 0; k < nums.length; k++) {
                    //刷新最大
                    max = Math.max(nums[i] + nums[j] - nums[k], max);
                }
            }
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code24().maximizeExpressionOfThree(new int[]{-2, 0, 5, -2, 4}));
    }

}
