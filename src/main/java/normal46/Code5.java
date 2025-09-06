package normal46;

/**
 * @Author ayl
 * @Date 2025-09-06
 * 2256. 最小平均差
 * 算术评级: 4
 * 第 77 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1395
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 。
 * <p>
 * 下标 i 处的 平均差 指的是 nums 中 前 i + 1 个元素平均值和 后 n - i - 1 个元素平均值的 绝对差 。两个平均值都需要 向下取整 到最近的整数。
 * <p>
 * 请你返回产生 最小平均差 的下标。如果有多个下标最小平均差相等，请你返回 最小 的一个下标。
 * <p>
 * 注意：
 * <p>
 * 两个数的 绝对差 是两者差的绝对值。
 * n 个元素的平均值是 n 个元素之 和 除以（整数除法） n 。
 * 0 个元素的平均值视为 0 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,3,9,5,3]
 * 输出：3
 * 解释：
 * - 下标 0 处的平均差为：|2 / 1 - (5 + 3 + 9 + 5 + 3) / 5| = |2 / 1 - 25 / 5| = |2 - 5| = 3 。
 * - 下标 1 处的平均差为：|(2 + 5) / 2 - (3 + 9 + 5 + 3) / 4| = |7 / 2 - 20 / 4| = |3 - 5| = 2 。
 * - 下标 2 处的平均差为：|(2 + 5 + 3) / 3 - (9 + 5 + 3) / 3| = |10 / 3 - 17 / 3| = |3 - 5| = 2 。
 * - 下标 3 处的平均差为：|(2 + 5 + 3 + 9) / 4 - (5 + 3) / 2| = |19 / 4 - 8 / 2| = |4 - 4| = 0 。
 * - 下标 4 处的平均差为：|(2 + 5 + 3 + 9 + 5) / 5 - 3 / 1| = |24 / 5 - 3 / 1| = |4 - 3| = 1 。
 * - 下标 5 处的平均差为：|(2 + 5 + 3 + 9 + 5 + 3) / 6 - 0| = |27 / 6 - 0| = |4 - 0| = 4 。
 * 下标 3 处的平均差为最小平均差，所以返回 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：0
 * 解释：
 * 唯一的下标是 0 ，所以我们返回 0 。
 * 下标 0 处的平均差为：|0 / 1 - 0| = |0 - 0| = 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 */
public class Code5 {

    public int minimumAverageDifference(int[] nums) {

        /**
         * 前缀和
         */

        //前缀和
        long[] sumArr = new long[nums.length];
        //第一个
        sumArr[0] = nums[0];
        //循环
        for (int i = 1; i < sumArr.length; i++) {
            //得加当前
            sumArr[i] = sumArr[i - 1] + nums[i];
        }

        /**
         * 计算
         */

        //结果
        long minResult = Long.MAX_VALUE;
        //结果索引
        int minIndex = -1;
        //循环
        for (int i = 0; i < sumArr.length; i++) {
            //左右和
            long left = sumArr[i] / (i + 1);
            long a = (sumArr[sumArr.length - 1] - sumArr[i]);
            long b = (sumArr.length - (i + 1));
            long right = b > 0 ? a / b : 0;
            //本次结果
            long target = Math.abs(left - right);
            //如果更小
            if (target < minResult) {
                //更新
                minResult = target;
                minIndex = i;
            }
        }
        //返回
        return minIndex;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().minimumAverageDifference(new int[]{2, 5, 3, 9, 5, 3}));
    }

}