package normal33;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-07-05
 * 2740. 找出分区值
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 正 整数数组 nums 。
 * <p>
 * 将 nums 分成两个数组：nums1 和 nums2 ，并满足下述条件：
 * <p>
 * 数组 nums 中的每个元素都属于数组 nums1 或数组 nums2 。
 * 两个数组都 非空 。
 * 分区值 最小 。
 * 分区值的计算方法是 |max(nums1) - min(nums2)| 。
 * <p>
 * 其中，max(nums1) 表示数组 nums1 中的最大元素，min(nums2) 表示数组 nums2 中的最小元素。
 * <p>
 * 返回表示分区值的整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,2,4]
 * 输出：1
 * 解释：可以将数组 nums 分成 nums1 = [1,2] 和 nums2 = [3,4] 。
 * - 数组 nums1 的最大值等于 2 。
 * - 数组 nums2 的最小值等于 3 。
 * 分区值等于 |2 - 3| = 1 。
 * 可以证明 1 是所有分区方案的最小值。
 * 示例 2：
 * <p>
 * 输入：nums = [100,1,10]
 * 输出：9
 * 解释：可以将数组 nums 分成 nums1 = [10] 和 nums2 = [100,1] 。
 * - 数组 nums1 的最大值等于 10 。
 * - 数组 nums2 的最小值等于 1 。
 * 分区值等于 |10 - 1| = 9 。
 * 可以证明 9 是所有分区方案的最小值。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 */
public class Code4 {

    public int findValueOfPartition(int[] nums) {
        //排序
        Arrays.sort(nums);
        //最小结果初始化
        int min = nums[1] - nums[0];
        //循环
        for (int i = 2; i < nums.length; i++) {
            //刷新最小结果
            min = Math.min(nums[i] - nums[i - 1], min);
        }
        //返回
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().findValueOfPartition(new int[]{78, 36, 2, 70, 64, 24, 34, 63, 21, 49}));
    }

}
