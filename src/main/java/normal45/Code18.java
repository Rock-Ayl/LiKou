package normal45;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-08-05
 * 3634. 使数组平衡的最少移除数目
 * 中等
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k。
 * <p>
 * 如果一个数组的 最大 元素的值 至多 是其 最小 元素的 k 倍，则该数组被称为是 平衡 的。
 * <p>
 * 你可以从 nums 中移除 任意 数量的元素，但不能使其变为 空 数组。
 * <p>
 * 返回为了使剩余数组平衡，需要移除的元素的 最小 数量。
 * <p>
 * 注意：大小为 1 的数组被认为是平衡的，因为其最大值和最小值相等，且条件总是成立。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：nums = [2,1,5], k = 2
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 移除 nums[2] = 5 得到 nums = [2, 1]。
 * 现在 max = 2, min = 1，且 max <= min * k，因为 2 <= 1 * 2。因此，答案是 1。
 * 示例 2:
 * <p>
 * 输入：nums = [1,6,2,9], k = 3
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 移除 nums[0] = 1 和 nums[3] = 9 得到 nums = [6, 2]。
 * 现在 max = 6, min = 2，且 max <= min * k，因为 6 <= 2 * 3。因此，答案是 2。
 * 示例 3:
 * <p>
 * 输入：nums = [4,6], k = 2
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 由于 nums 已经平衡，因为 6 <= 4 * 2，所以不需要移除任何元素。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= 105
 */
public class Code18 {

    public int minRemoval(int[] nums, int k) {
        //排序
        Arrays.sort(nums);
        //如果不需要删除
        if (nums[0] * k >= nums[nums.length - 1]) {
            //过
            return 0;
        }
        //双指针
        int left = 0;
        int right = 0;
        //最大保留数量
        int max = 0;
        //循环
        while (right < nums.length) {
            //如果可以右移
            while (right + 1 < nums.length && (long) nums[left] * k >= nums[right + 1]) {
                //+1
                right++;
            }
            //刷新最大
            max = Math.max(max, right - left);
            //如果到头了
            if (right + 1 == nums.length) {
                //跳出
                break;
            }
            //+1
            left++;
        }
        //返回
        return nums.length - max - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Code18().minRemoval(new int[]{1, 6, 2, 9}, 3));
    }

}
