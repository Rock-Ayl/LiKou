package normal42;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-04-27
 * 3107. 使数组中位数等于 K 的最少操作数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个 非负 整数 k 。一次操作中，你可以选择任一元素 加 1 或者减 1 。
 * <p>
 * 请你返回将 nums 中位数 变为 k 所需要的 最少 操作次数。
 * <p>
 * 一个数组的中位数指的是数组按非递减顺序排序后最中间的元素。如果数组长度为偶数，我们选择中间两个数的较大值为中位数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,6,8,5], k = 4
 * <p>
 * 输出：2
 * <p>
 * 解释：我们将 nums[1] 和 nums[4] 减 1 得到 [2, 4, 6, 8, 4] 。现在数组的中位数等于 k 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,5,6,8,5], k = 7
 * <p>
 * 输出：3
 * <p>
 * 解释：我们将 nums[1] 增加 1 两次，并且将 nums[2] 增加 1 一次，得到 [2, 7, 7, 8, 5] 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,4,5,6], k = 4
 * <p>
 * 输出：0
 * <p>
 * 解释：数组中位数已经等于 k 了。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= 109
 */
public class Code8 {


    public long minOperationsToMakeMedianK(int[] nums, int k) {
        //排序
        Arrays.sort(nums);
        //计算目标节点索引
        int mid = nums.length / 2;
        //先将中间的数字变为目标数字
        long count = Math.abs(nums[mid] - k);
        //变更
        nums[mid] = k;
        //先到左边
        for (int i = mid - 1; i >= 0; i--) {
            //如果更大
            if (nums[i] > nums[i + 1]) {
                //叠加
                count += nums[i] - nums[i + 1];
                //变更
                nums[i] = nums[i + 1];
            } else {
                //如果没动作,说明后续也不用看了
                break;
            }
        }
        //再到右边
        for (int i = mid + 1; i < nums.length; i++) {
            //如果更小
            if (nums[i] < nums[i - 1]) {
                //叠加
                count += nums[i - 1] - nums[i];
                //变更
                nums[i] = nums[i - 1];
            } else {
                //如果没动作,说明后续也不用看了
                break;
            }
        }
        //返回结果
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().minOperationsToMakeMedianK(new int[]{2, 5, 6, 8, 5}, 7));
    }

}
