package normal29;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2024-03-16
 * 2958. 最多 K 个重复元素的最长子数组
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k 。
 * <p>
 * 一个元素 x 在数组中的 频率 指的是它在数组中的出现次数。
 * <p>
 * 如果一个数组中所有元素的频率都 小于等于 k ，那么我们称这个数组是 好 数组。
 * <p>
 * 请你返回 nums 中 最长好 子数组的长度。
 * <p>
 * 子数组 指的是一个数组中一段连续非空的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1,2,3,1,2], k = 2
 * 输出：6
 * 解释：最长好子数组是 [1,2,3,1,2,3] ，值 1 ，2 和 3 在子数组中的频率都没有超过 k = 2 。[2,3,1,2,3,1] 和 [3,1,2,3,1,2] 也是好子数组。
 * 最长好子数组的长度为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,1,2,1,2,1,2], k = 1
 * 输出：2
 * 解释：最长好子数组是 [1,2] ，值 1 和 2 在子数组中的频率都没有超过 k = 1 。[2,1] 也是好子数组。
 * 最长好子数组的长度为 2 。
 * 示例 3：
 * <p>
 * 输入：nums = [5,5,5,5,5,5,5], k = 4
 * 输出：4
 * 解释：最长好子数组是 [5,5,5,5] ，值 5 在子数组中的频率没有超过 k = 4 。
 * 最长好子数组的长度为 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= nums.length
 */
public class Code23 {

    public int maxSubarrayLength(int[] nums, int k) {
        //缓存
        Map<Integer, Integer> map = new HashMap<>();
        //初始化队列
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        //最大长度
        int maxLength = 0;
        //循环
        for (int num : nums) {
            //如果太多了
            while (arrayDeque.isEmpty() == false && map.getOrDefault(num, 0) + 1 > k) {
                //删除最前面的
                Integer last = arrayDeque.pollLast();
                //记录
                map.put(last, map.getOrDefault(last, 0) - 1);
            }
            //记录本次
            arrayDeque.push(num);
            //记录本次
            map.put(num, map.getOrDefault(num, 0) + 1);
            //刷新最大结果
            maxLength = Math.max(maxLength, arrayDeque.size());
        }
        //返回
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Code23().maxSubarrayLength(new int[]{1, 4, 4, 3}, 1));
    }

}
