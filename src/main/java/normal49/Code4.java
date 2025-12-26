package normal49;

/**
 * @Author ayl
 * @Date 2025-12-26
 * 1749. 任意子数组和的绝对值的最大值
 * 算术评级: 4
 * 第 45 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1542
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。
 * <p>
 * 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。
 * <p>
 * abs(x) 定义如下：
 * <p>
 * 如果 x 是负整数，那么 abs(x) = -x 。
 * 如果 x 是非负整数，那么 abs(x) = x 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,-3,2,3,-4]
 * 输出：5
 * 解释：子数组 [2,3] 和的绝对值最大，为 abs(2+3) = abs(5) = 5 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,-5,1,-4,3,-2]
 * 输出：8
 * 解释：子数组 [-5,1,-4] 和的绝对值最大，为 abs(-5+1-4) = abs(-8) = 8 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class Code4 {

    public int maxAbsoluteSum(int[] nums) {
        //循环
        for (int i = 1; i < nums.length; i++) {
            //叠加前缀和
            nums[i] = nums[i - 1] + nums[i];
        }
        //最小最大值
        int min = 0;
        int max = 0;
        //结果
        int result = 0;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //计算本次最大
            result = Math.max(result, Math.abs(nums[i] - max));
            result = Math.max(result, Math.abs(nums[i] - min));
            //刷新最小最大
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().maxAbsoluteSum(new int[]{2, -5, 1, -4, 3, -2}));
    }

}
