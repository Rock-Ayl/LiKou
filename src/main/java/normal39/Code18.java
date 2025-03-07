package normal39;

/**
 * @Author ayl
 * @Date 2025-01-28
 * 3254. 长度为 K 的子数组的能量值 I
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums 和一个正整数 k 。
 * <p>
 * 一个数组的 能量值 定义为：
 * <p>
 * 如果 所有 元素都是依次 连续 且 上升 的，那么能量值为 最大 的元素。
 * 否则为 -1 。
 * 你需要求出 nums 中所有长度为 k 的
 * 子数组
 * 的能量值。
 * <p>
 * 请你返回一个长度为 n - k + 1 的整数数组 results ，其中 results[i] 是子数组 nums[i..(i + k - 1)] 的能量值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,3,2,5], k = 3
 * <p>
 * 输出：[3,4,-1,-1,-1]
 * <p>
 * 解释：
 * <p>
 * nums 中总共有 5 个长度为 3 的子数组：
 * <p>
 * [1, 2, 3] 中最大元素为 3 。
 * [2, 3, 4] 中最大元素为 4 。
 * [3, 4, 3] 中元素 不是 连续的。
 * [4, 3, 2] 中元素 不是 上升的。
 * [3, 2, 5] 中元素 不是 连续的。
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], k = 4
 * <p>
 * 输出：[-1,-1]
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,3,2,3,2], k = 2
 * <p>
 * 输出：[-1,3,-1,3,-1]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == nums.length <= 500
 * 1 <= nums[i] <= 105
 * 1 <= k <= n
 */
public class Code18 {

    public int[] resultsArray(int[] nums, int k) {

        /**
         * 计算递增 前缀和
         */

        //前缀和数组
        int[] sumArr = new int[nums.length];
        //默认
        sumArr[0] = 1;
        //循环
        for (int i = 1; i < sumArr.length; i++) {
            //如果不是连续上升
            if (nums[i] - 1 == nums[i - 1]) {
                //叠加
                sumArr[i] = sumArr[i - 1] + 1;
            } else {
                //默认
                sumArr[i] = 1;
            }
        }

        /**
         * 计算结果
         */

        //初始化结果数组
        int[] result = new int[nums.length - k + 1];
        //循环
        for (int i = 0; i < result.length; i++) {
            //计算索引
            int index = i + k - 1;
            //如果满足
            if (sumArr[index] >= k) {
                //记录结果
                result[i] = nums[index];
            } else {
                //不是
                result[i] = -1;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new Code18().resultsArray(new int[]{1, 3, 4}, 2);
    }

}
