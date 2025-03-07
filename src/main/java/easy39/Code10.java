package easy39;

/**
 * @Author ayl
 * @Date 2024-12-30
 * 3392. 统计符合条件长度为 3 的子数组数目
 * 简单
 * 相关企业
 * 提示
 * 给你一个整数数组 nums ，请你返回长度为 3 的
 * 子数组
 * ，满足第一个数和第三个数的和恰好为第二个数的一半。
 * <p>
 * 子数组 指的是一个数组中连续 非空 的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,1,4,1]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 只有子数组 [1,4,1] 包含 3 个元素且第一个和第三个数字之和是中间数字的一半。number.
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * [1,1,1] 是唯一长度为 3 的子数组，但第一个数和第三个数的和不是第二个数的一半。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 */
public class Code10 {

    public int countSubarrays(int[] nums) {
        //结果
        int count = 0;
        //循环
        for (int i = 2; i < nums.length; i++) {
            //计算并叠加
            count += (nums[i] + nums[i - 2]) * 2 == nums[i - 1] ? 1 : 0;
        }
        //返回
        return count;
    }

    public static void main(String[] args) {

    }
}
