package normal36;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-10-21
 * 2592. 最大化数组的伟大值
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 。你需要将 nums 重新排列成一个新的数组 perm 。
 * <p>
 * 定义 nums 的 伟大值 为满足 0 <= i < nums.length 且 perm[i] > nums[i] 的下标数目。
 * <p>
 * 请你返回重新排列 nums 后的 最大 伟大值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,5,2,1,3,1]
 * 输出：4
 * 解释：一个最优安排方案为 perm = [2,5,1,3,3,1,1] 。
 * 在下标为 0, 1, 3 和 4 处，都有 perm[i] > nums[i] 。因此我们返回 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：最优排列为 [2,3,4,1] 。
 * 在下标为 0, 1 和 2 处，都有 perm[i] > nums[i] 。因此我们返回 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 */
public class Code11 {

    public int maximizeGreatness(int[] nums) {
        //排序
        Arrays.sort(nums);
        //双指针
        int leftIndex = 0;
        int rightIndex = 0;
        //循环
        while (rightIndex < nums.length) {
            //如果正好大
            if (nums[rightIndex++] > nums[leftIndex]) {
                //左边也移动
                leftIndex++;
            }
        }
        //返回
        return leftIndex;
    }

    public static void main(String[] args) {
        System.out.println(new Code11().maximizeGreatness(new int[]{1, 3, 5, 2, 1, 3, 1}));
    }

}
