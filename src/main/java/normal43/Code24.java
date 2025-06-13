package normal43;

/**
 * @Author ayl
 * @Date 2025-06-13
 * 2425. 所有数对的异或和
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个下标从 0 开始的数组 nums1 和 nums2 ，两个数组都只包含非负整数。请你求出另外一个数组 nums3 ，包含 nums1 和 nums2 中 所有数对 的异或和（nums1 中每个整数都跟 nums2 中每个整数 恰好 匹配一次）。
 * <p>
 * 请你返回 nums3 中所有整数的 异或和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [2,1,3], nums2 = [10,2,5,0]
 * 输出：13
 * 解释：
 * 一个可能的 nums3 数组是 [8,0,7,2,11,3,4,1,9,1,6,3] 。
 * 所有这些数字的异或和是 13 ，所以我们返回 13 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：0
 * 解释：
 * 所有数对异或和的结果分别为 nums1[0] ^ nums2[0] ，nums1[0] ^ nums2[1] ，nums1[1] ^ nums2[0] 和 nums1[1] ^ nums2[1] 。
 * 所以，一个可能的 nums3 数组是 [2,5,1,6] 。
 * 2 ^ 5 ^ 1 ^ 6 = 0 ，所以我们返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 105
 * 0 <= nums1[i], nums2[j] <= 109
 */
public class Code24 {

    public int xorAllNums(int[] nums1, int[] nums2) {
        //如果都是偶数
        if (nums1.length % 2 == 0 && nums2.length % 2 == 0) {
            //过
            return 0;
        }
        //情况1
        else if (nums2.length % 2 == 0) {
            //返回自己的
            return count(nums2);
        }
        //情况2
        else if (nums1.length % 2 == 0) {
            //返回自己的
            return count(nums1);
        }
        //情况3
        else {
            //返回二者的
            return count(nums2) ^ count(nums1);
        }
    }

    //异或计算
    private int count(int[] nums) {
        int other = 0;
        //循环
        for (int num : nums) {
            //异或
            other = other ^ num;
        }
        //返回
        return other;
    }

    public static void main(String[] args) {
        System.out.println(new Code24().xorAllNums(new int[]{2, 1, 3}, new int[]{10, 2, 5, 0}));
    }

}
