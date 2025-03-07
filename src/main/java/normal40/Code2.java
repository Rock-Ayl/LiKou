package normal40;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-02-10
 * 2841. 几乎唯一子数组的最大和
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和两个正整数 m 和 k 。
 * <p>
 * 请你返回 nums 中长度为 k 的 几乎唯一 子数组的 最大和 ，如果不存在几乎唯一子数组，请你返回 0 。
 * <p>
 * 如果 nums 的一个子数组有至少 m 个互不相同的元素，我们称它是 几乎唯一 子数组。
 * <p>
 * 子数组指的是一个数组中一段连续 非空 的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,6,7,3,1,7], m = 3, k = 4
 * 输出：18
 * 解释：总共有 3 个长度为 k = 4 的几乎唯一子数组。分别为 [2, 6, 7, 3] ，[6, 7, 3, 1] 和 [7, 3, 1, 7] 。这些子数组中，和最大的是 [2, 6, 7, 3] ，和为 18 。
 * 示例 2：
 * <p>
 * 输入：nums = [5,9,9,2,4,5,4], m = 1, k = 3
 * 输出：23
 * 解释：总共有 5 个长度为 k = 3 的几乎唯一子数组。分别为 [5, 9, 9] ，[9, 9, 2] ，[9, 2, 4] ，[2, 4, 5] 和 [4, 5, 4] 。这些子数组中，和最大的是 [5, 9, 9] ，和为 23 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,1,2,1,2,1], m = 3, k = 3
 * 输出：0
 * 解释：输入数组中不存在长度为 k = 3 的子数组含有至少  m = 3 个互不相同元素的子数组。所以不存在几乎唯一子数组，最大和为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * 1 <= m <= k <= nums.length
 * 1 <= nums[i] <= 109
 */
public class Code2 {

    public long maxSum(List<Integer> nums, int m, int k) {

        /**
         * 计数器
         */

        //缓存
        Map<Integer, Integer> map = new HashMap<>();
        //不同数量
        int notSameCount = 0;
        //和
        long sum = 0L;
        //最大和
        long maxSum = 0L;

        /**
         * 初始化第一次
         */

        //循环
        for (int i = 0; i < k; i++) {
            //获取数字
            int num = nums.get(i);
            //出现次数
            int count = map.getOrDefault(num, 0) + 1;
            //记录缓存
            map.put(num, count);
            //不同数字数量叠加
            notSameCount += count == 1 ? 1 : 0;
            //求和
            sum += num;
        }
        //如果第一次满足条件
        if (notSameCount >= m) {
            //更新最大
            maxSum = sum;
        }

        /**
         * 后续计算
         */

        //区间
        int start = 0;
        int end = k;
        //如果还有
        while (end < nums.size()) {

            /**
             * 滑动、增加右边数字
             */

            //获取数字
            int endNum = nums.get(end++);
            //出现次数
            int endCount = map.getOrDefault(endNum, 0) + 1;
            //记录缓存
            map.put(endNum, endCount);
            //不同数字数量叠加
            notSameCount += endCount == 1 ? 1 : 0;
            //求和
            sum += endNum;

            /**
             * 滑动、减少左边数字
             */

            //获取数字
            int startNum = nums.get(start++);
            //出现次数
            int startCount = map.getOrDefault(startNum, 0) - 1;
            //记录缓存
            map.put(startNum, startCount);
            //不同数字数量叠加
            notSameCount -= startCount == 0 ? 1 : 0;
            //求和
            sum -= startNum;

            /**
             * 清算本次结果
             */

            //如果第一次满足条件
            if (notSameCount >= m) {
                //更新最大
                maxSum = Math.max(maxSum, sum);
            }

        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().maxSum(Arrays.asList(5, 9, 9, 2, 4, 5, 4), 1, 3));
    }

}
