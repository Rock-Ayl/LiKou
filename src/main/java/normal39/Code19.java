package normal39;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-01-29
 * 2090. 半径为 k 的子数组平均值
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的数组 nums ，数组中有 n 个整数，另给你一个整数 k 。
 * <p>
 * 半径为 k 的子数组平均值 是指：nums 中一个以下标 i 为 中心 且 半径 为 k 的子数组中所有元素的平均值，即下标在 i - k 和 i + k 范围（含 i - k 和 i + k）内所有元素的平均值。如果在下标 i 前或后不足 k 个元素，那么 半径为 k 的子数组平均值 是 -1 。
 * <p>
 * 构建并返回一个长度为 n 的数组 avgs ，其中 avgs[i] 是以下标 i 为中心的子数组的 半径为 k 的子数组平均值 。
 * <p>
 * x 个元素的 平均值 是 x 个元素相加之和除以 x ，此时使用截断式 整数除法 ，即需要去掉结果的小数部分。
 * <p>
 * 例如，四个元素 2、3、1 和 5 的平均值是 (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75，截断后得到 2 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：nums = [7,4,3,9,1,8,5,2,6], k = 3
 * 输出：[-1,-1,-1,5,4,4,-1,-1,-1]
 * 解释：
 * - avg[0]、avg[1] 和 avg[2] 是 -1 ，因为在这几个下标前的元素数量都不足 k 个。
 * - 中心为下标 3 且半径为 3 的子数组的元素总和是：7 + 4 + 3 + 9 + 1 + 8 + 5 = 37 。
 * 使用截断式 整数除法，avg[3] = 37 / 7 = 5 。
 * - 中心为下标 4 的子数组，avg[4] = (4 + 3 + 9 + 1 + 8 + 5 + 2) / 7 = 4 。
 * - 中心为下标 5 的子数组，avg[5] = (3 + 9 + 1 + 8 + 5 + 2 + 6) / 7 = 4 。
 * - avg[6]、avg[7] 和 avg[8] 是 -1 ，因为在这几个下标后的元素数量都不足 k 个。
 * 示例 2：
 * <p>
 * 输入：nums = [100000], k = 0
 * 输出：[100000]
 * 解释：
 * - 中心为下标 0 且半径 0 的子数组的元素总和是：100000 。
 * avg[0] = 100000 / 1 = 100000 。
 * 示例 3：
 * <p>
 * 输入：nums = [8], k = 100000
 * 输出：[-1]
 * 解释：
 * - avg[0] 是 -1 ，因为在下标 0 前后的元素数量均不足 k 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * 0 <= nums[i], k <= 105
 */
public class Code19 {

    public int[] getAverages(int[] nums, int k) {

        /**
         * 特殊情况
         */

        //每个结果的长度
        int length = k * 2 + 1;
        //如果不可能
        if (length > nums.length) {
            //初始化
            int[] ints = new int[nums.length];
            //填充
            Arrays.fill(ints, -1);
            //返回
            return ints;
        }

        /**
         * 前缀和
         */

        //前缀和
        long[] sumArr = new long[nums.length];
        //初始化第一个
        sumArr[0] = nums[0];
        //循环
        for (int i = 1; i < sumArr.length; i++) {
            //求和
            sumArr[i] = sumArr[i - 1] + nums[i];
        }

        /**
         * 初始化 -1 结果
         */

        //有结果的结束位置
        int rightIndex = nums.length - k;
        //初始化结果
        int[] result = new int[nums.length];
        //循环
        for (int i = 0; i < k; i++) {
            //默认
            result[i] = -1;
        }
        //循环
        for (int i = rightIndex; i < nums.length; i++) {
            //默认
            result[i] = -1;
        }

        /**
         * 计算存在结果的值
         */

        //循环
        for (int i = k; i < rightIndex; i++) {
            //计算本次开始、结束的索引
            int start = i - k - 1;
            int end = i + k;
            //求和、计算平均
            result[i] = (int) ((sumArr[end] - (start >= 0 ? sumArr[start] : 0)) / length);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[] averages = new Code19().getAverages(new int[]{18334, 25764, 19780, 92480, 69842, 73255, 89893}, 0);
        System.out.println();
    }

}
