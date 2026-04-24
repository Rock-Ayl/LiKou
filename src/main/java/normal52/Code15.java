package normal52;

/**
 * LCR 009. 乘积小于 K 的子数组
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * 示例 2：
 * <p>
 * 输入: nums = [1,2,3], k = 0
 * 输出: 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 * <p>
 * <p>
 * 注意：本题与主站 713 题相同： https://leetcode.cn/problems/subarray-product-less-than-k/
 */
public class Code15 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //特殊
        if (k == 0) {
            //过
            return 0;
        }
        //结果
        int count = 0;
        //双指针
        int left = 0;
        int right = -1;
        //和
        int sum = 1;
        //循环
        while (left < nums.length) {
            //如果可以右滑
            while (right + 1 < nums.length && sum < k && sum * nums[right + 1] < k) {
                //右滑
                sum = sum * nums[++right];
            }
            //如果满足
            if (sum < k) {
                //记录本次结果
                count += right - left + 1;
            }
            //左滑
            sum = sum / nums[left++];
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code15().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }

}
