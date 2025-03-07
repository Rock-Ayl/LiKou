package easy36;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-04-22
 * 2389. 和有限的最长子序列
 * 尝试过
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums ，和一个长度为 m 的整数数组 queries 。
 * <p>
 * 返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中 元素之和小于等于 queries[i] 的 子序列 的 最大 长度  。
 * <p>
 * 子序列 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,2,1], queries = [3,10,21]
 * 输出：[2,3,4]
 * 解释：queries 对应的 answer 如下：
 * - 子序列 [2,1] 的和小于或等于 3 。可以证明满足题目要求的子序列的最大长度是 2 ，所以 answer[0] = 2 。
 * - 子序列 [4,5,1] 的和小于或等于 10 。可以证明满足题目要求的子序列的最大长度是 3 ，所以 answer[1] = 3 。
 * - 子序列 [4,5,2,1] 的和小于或等于 21 。可以证明满足题目要求的子序列的最大长度是 4 ，所以 answer[2] = 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,4,5], queries = [1]
 * 输出：[0]
 * 解释：空子序列是唯一一个满足元素和小于或等于 1 的子序列，所以 answer[0] = 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * m == queries.length
 * 1 <= n, m <= 1000
 * 1 <= nums[i], queries[i] <= 106
 */
public class Code22 {

    private int findSumCount(int[] nums, int target) {
        //获取左右边界
        int left = 0;
        int right = nums.length - 1;
        //如果比所有的都小
        if (nums[left] > target) {
            //过
            return 0;
        }
        //如果正好是1
        if (nums[left] == target) {
            //过
            return 1;
        }
        //如果比所有都大
        if (nums[right] <= target) {
            //过
            return nums.length;
        }
        //如果需要递归
        while (left + 1 < right) {
            //计算中间点
            int mid = (right - left) / 2 + left;
            //如果找到目标结果
            if (nums[mid] <= target && nums[mid + 1] > target) {
                //返回
                return mid + 1;
            }
            //根据大小
            if (nums[mid] < target) {
                //缩短范围
                left = mid;
            } else {
                //缩短范围
                right = mid;
            }
        }
        //如果找到头还没找到
        if (left + 1 == right) {
            //返回
            return right;
        }
        //默认
        return 0;
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        //排序
        Arrays.sort(nums);
        //循环
        for (int i = 1; i < nums.length; i++) {
            //求和
            nums[i] = nums[i - 1] + nums[i];
        }
        //初始化结果
        int[] result = new int[queries.length];
        //循环
        for (int i = 0; i < queries.length; i++) {
            //寻找
            result[i] = findSumCount(nums, queries[i]);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        new Code22().answerQueries(new int[]{736411, 184882, 914641, 37925, 214915}, new int[]{331244, 273144, 118983, 118252, 305688, 718089, 665450});
    }

}
