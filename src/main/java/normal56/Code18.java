package normal56;

import java.util.Arrays;

/**
 * 2541. 使数组中所有元素相等的最小操作数 II
 * 算术评级: 4
 * 第 96 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1620
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个整数数组 nums1 和 nums2 ，两个数组长度都是 n ，再给你一个整数 k 。你可以对数组 nums1 进行以下操作：
 * <p>
 * 选择两个下标 i 和 j ，将 nums1[i] 增加 k ，将 nums1[j] 减少 k 。换言之，nums1[i] = nums1[i] + k 且 nums1[j] = nums1[j] - k 。
 * 如果对于所有满足 0 <= i < n 都有 num1[i] == nums2[i] ，那么我们称 nums1 等于 nums2 。
 * <p>
 * 请你返回使 nums1 等于 nums2 的 最少 操作数。如果没办法让它们相等，请你返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [4,3,1,4], nums2 = [1,3,7,1], k = 3
 * 输出：2
 * 解释：我们可以通过 2 个操作将 nums1 变成 nums2 。
 * 第 1 个操作：i = 2 ，j = 0 。操作后得到 nums1 = [1,3,4,4] 。
 * 第 2 个操作：i = 2 ，j = 3 。操作后得到 nums1 = [1,3,7,1] 。
 * 无法用更少操作使两个数组相等。
 * 示例 2：
 * <p>
 * 输入：nums1 = [3,8,5,2], nums2 = [2,4,1,6], k = 1
 * 输出：-1
 * 解释：无法使两个数组相等。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums1.length == nums2.length
 * 2 <= n <= 105
 * 0 <= nums1[i], nums2[j] <= 109
 * 0 <= k <= 105
 */
public class Code18 {

    public long minOperations(int[] nums1, int[] nums2, int k) {
        //特殊情况
        if (k == 0) {
            //返回
            return Arrays.equals(nums1, nums2) ? 0 : -1;
        }
        //增加次数
        long add = 0L;
        //删减次数
        long remove = 0L;
        //循环
        for (int i = 0; i < nums1.length; i++) {
            //如果相同
            if (nums1[i] == nums2[i]) {
                //本轮过
                continue;
            }
            //如果更大
            if (nums1[i] > nums2[i]) {
                //当前差值
                int other = nums1[i] - nums2[i];
                //如果不能
                if (other % k != 0) {
                    //过
                    return -1;
                }
                //叠加本次
                remove += other / k;
            } else {
                //当前差值
                int other = nums2[i] - nums1[i];
                //如果不能
                if (other % k != 0) {
                    //过
                    return -1;
                }
                //叠加本次
                add += other / k;
            }
        }
        //如果不同
        if (add != remove) {
            //过
            return -1;
        }
        //默认
        return add;
    }

    public static void main(String[] args) {
        System.out.println(new Code18().minOperations(new int[]{4, 3, 1, 4}, new int[]{1, 3, 7, 1}, 3));
    }

}
