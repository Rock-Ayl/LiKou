package normal36;

import java.util.ArrayDeque;

/**
 * @Author ayl
 * @Date 2024-10-10
 * LCR 008. 长度最小的子数组
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 * <p>
 * <p>
 * 注意：本题与主站 209 题相同：https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class Code1 {

    public int minSubArrayLen(int target, int[] nums) {
        //双端队列
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        //目标结果
        int min = Integer.MAX_VALUE;
        //当前和
        int sum = 0;
        //循环
        for (int num : nums) {
            //加入本次
            deque.addLast(num);
            //当前和
            sum += num;
            //如果超了
            while (sum >= target) {
                //刷新最小情况
                min = Math.min(min, deque.size());
                //删除最后一个
                sum -= deque.pollFirst();
            }
        }
        //返回结果
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        System.out.println(new Code1().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

}
