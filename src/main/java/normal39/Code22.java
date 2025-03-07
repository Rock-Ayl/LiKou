package normal39;

/**
 * @Author ayl
 * @Date 2025-02-02
 * 2918. 数组的最小相等和
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个由正整数和 0 组成的数组 nums1 和 nums2 。
 * <p>
 * 你必须将两个数组中的 所有 0 替换为 严格 正整数，并且满足两个数组中所有元素的和 相等 。
 * <p>
 * 返回 最小 相等和 ，如果无法使两数组相等，则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [3,2,0,1,0], nums2 = [6,5,0]
 * 输出：12
 * 解释：可以按下述方式替换数组中的 0 ：
 * - 用 2 和 4 替换 nums1 中的两个 0 。得到 nums1 = [3,2,2,1,4] 。
 * - 用 1 替换 nums2 中的一个 0 。得到 nums2 = [6,5,1] 。
 * 两个数组的元素和相等，都等于 12 。可以证明这是可以获得的最小相等和。
 * 示例 2：
 * <p>
 * 输入：nums1 = [2,0,2,0], nums2 = [1,4]
 * 输出：-1
 * 解释：无法使两个数组的和相等。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 105
 * 0 <= nums1[i], nums2[i] <= 106
 */
public class Code22 {

    public long minSum(int[] nums1, int[] nums2) {

        /**
         * 统计数据
         */

        //两边 和
        long sum1 = 0L;
        long sum2 = 0L;
        //两边 0的数量
        int zeroCount1 = 0;
        int zeroCount2 = 0;

        //循环
        for (int num : nums1) {
            //叠加
            sum1 += num;
            //计算0
            zeroCount1 += num == 0 ? 1 : 0;
        }
        //循环
        for (int num : nums2) {
            //叠加
            sum2 += num;
            //计算0
            zeroCount2 += num == 0 ? 1 : 0;
        }

        /**
         * 分别 计算2边、最大最小情况
         */

        //最小情况
        long minSum1 = sum1 + zeroCount1;
        long minSum2 = sum2 + zeroCount2;

        //如果最小结果相同
        if (minSum1 == minSum2) {
            //直接返回
            return minSum1;
        }

        //最大情况
        long maxSum1 = sum1 + (MAX_NUMBER * zeroCount1);
        long maxSum2 = sum2 + (MAX_NUMBER * zeroCount2);

        /**
         * 求取最小情况
         */

        //如果区间不重叠
        if (maxSum1 < minSum2 || maxSum2 < minSum1) {
            //返回
            return -1L;
        }
        //返回二者最小结果
        return Math.max(minSum1, minSum2);
    }

    //单个数字最大值
    private static final long MAX_NUMBER = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(new Code22().minSum(
                new int[]{1000000, 0, 0, 1000000},
                new int[]{0}
        ));
    }

}
