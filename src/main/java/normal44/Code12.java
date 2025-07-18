package normal44;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-06-30
 * 2567. 修改两个元素的最小分数
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 。
 * <p>
 * nums 的 最小 得分是满足 0 <= i < j < nums.length 的 |nums[i] - nums[j]| 的最小值。
 * nums的 最大 得分是满足 0 <= i < j < nums.length 的 |nums[i] - nums[j]| 的最大值。
 * nums 的分数是 最大 得分与 最小 得分的和。
 * 我们的目标是最小化 nums 的分数。你 最多 可以修改 nums 中 2 个元素的值。
 * <p>
 * 请你返回修改 nums 中 至多两个 元素的值后，可以得到的 最小分数 。
 * <p>
 * |x| 表示 x 的绝对值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,4,3]
 * 输出：0
 * 解释：将 nums[1] 和 nums[2] 的值改为 1 ，nums 变为 [1,1,1] 。|nums[i] - nums[j]| 的值永远为 0 ，所以我们返回 0 + 0 = 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,4,7,8,5]
 * 输出：3
 * 解释：
 * 将 nums[0] 和 nums[1] 的值变为 6 ，nums 变为 [6,6,7,8,5] 。
 * 最小得分是 i = 0 且 j = 1 时得到的 |nums[i] - nums[j]| = |6 - 6| = 0 。
 * 最大得分是 i = 3 且 j = 4 时得到的 |nums[i] - nums[j]| = |8 - 5| = 3 。
 * 最大得分与最小得分之和为 3 。这是最优答案。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 */
public class Code12 {

    public int minimizeSum(int[] nums) {
        //排序
        Arrays.sort(nums);
        //三种情况
        int a = nums[nums.length - 1] - nums[2];
        int b = nums[nums.length - 2] - nums[1];
        int c = nums[nums.length - 3] - nums[0];
        //返回
        return Math.min(Math.min(a, b), c);
    }

    public static void main(String[] args) {
        System.out.println(new Code12().minimizeSum(new int[]{58, 42, 8, 75, 28}));
    }

}
