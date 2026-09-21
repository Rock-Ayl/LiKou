package normal57;

/**
 * 2104. 子数组范围和
 * 算术评级: 3
 * 第 271 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1504
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。
 * <p>
 * 返回 nums 中 所有 子数组范围的 和 。
 * <p>
 * 子数组是数组中一个连续 非空 的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：4
 * 解释：nums 的 6 个子数组如下所示：
 * [1]，范围 = 最大 - 最小 = 1 - 1 = 0
 * [2]，范围 = 2 - 2 = 0
 * [3]，范围 = 3 - 3 = 0
 * [1,2]，范围 = 2 - 1 = 1
 * [2,3]，范围 = 3 - 2 = 1
 * [1,2,3]，范围 = 3 - 1 = 2
 * 所有范围的和是 0 + 0 + 0 + 1 + 1 + 2 = 4
 * 示例 2：
 * <p>
 * 输入：nums = [1,3,3]
 * 输出：4
 * 解释：nums 的 6 个子数组如下所示：
 * [1]，范围 = 最大 - 最小 = 1 - 1 = 0
 * [3]，范围 = 3 - 3 = 0
 * [3]，范围 = 3 - 3 = 0
 * [1,3]，范围 = 3 - 1 = 2
 * [3,3]，范围 = 3 - 3 = 0
 * [1,3,3]，范围 = 3 - 1 = 2
 * 所有范围的和是 0 + 0 + 0 + 2 + 0 + 2 = 4
 * 示例 3：
 * <p>
 * 输入：nums = [4,-2,-3,4,1]
 * 输出：59
 * 解释：nums 中所有子数组范围的和是 59
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * -109 <= nums[i] <= 109
 * <p>
 * <p>
 * 进阶：你可以设计一种时间复杂度为 O(n) 的解决方案吗？
 */
public class Code9 {

    public long subArrayRanges(int[] nums) {
        //结果
        long result = 0L;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //最大最小
            long min = nums[i];
            long max = nums[i];
            //虚幻
            for (int j = i; j < nums.length; j++) {
                //最大最小
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                //结果
                result += max - min;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        long res = new Code9().subArrayRanges(new int[]{1, 2, 3});
        System.out.println(res);
    }

}
