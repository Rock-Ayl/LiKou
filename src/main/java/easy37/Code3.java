package easy37;

/**
 * @Author ayl
 * @Date 2024-06-02
 * 3162. 优质数对的总数 I
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个整数数组 nums1 和 nums2，长度分别为 n 和 m。同时给你一个正整数 k。
 * <p>
 * 如果 nums1[i] 可以被 nums2[j] * k 整除，则称数对 (i, j) 为 优质数对（0 <= i <= n - 1, 0 <= j <= m - 1）。
 * <p>
 * 返回 优质数对 的总数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3,4], nums2 = [1,3,4], k = 1
 * <p>
 * 输出：5
 * <p>
 * 解释：
 * <p>
 * 5个优质数对分别是 (0, 0), (1, 0), (1, 1), (2, 0), 和 (2, 2)。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2,4,12], nums2 = [2,4], k = 3
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 2个优质数对分别是 (3, 0) 和 (3, 1)。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n, m <= 50
 * 1 <= nums1[i], nums2[j] <= 50
 * 1 <= k <= 50
 */
public class Code3 {

    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        //结果
        int count = 0;
        //循环1
        for (int num1 : nums1) {
            //循环2
            for (int num2 : nums2) {
                //如果是目标结果
                if (num1 % (num2 * k) == 0) {
                    //+1
                    ++count;
                }
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().numberOfPairs(new int[]{1, 3, 4}, new int[]{1, 3, 4}, 1));
    }

}
