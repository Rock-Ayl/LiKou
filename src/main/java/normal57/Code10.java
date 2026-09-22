package normal57;

import java.util.Arrays;

/**
 * 1508. 子数组和排序后的区间和
 * 算术评级: 4
 * 第 30 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1402
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个数组 nums ，它包含 n 个正整数。你需要计算所有非空连续子数组的和，并将它们按升序排序，得到一个新的包含 n * (n + 1) / 2 个数字的数组。
 * <p>
 * 请你返回在新数组中下标为 left 到 right （下标从 1 开始）的所有数字和（包括左右端点）。由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4], n = 4, left = 1, right = 5
 * 输出：13
 * 解释：所有的子数组和为 1, 3, 6, 10, 2, 5, 9, 3, 7, 4 。将它们升序排序后，我们得到新的数组 [1, 2, 3, 3, 4, 5, 6, 7, 9, 10] 。下标从 le = 1 到 ri = 5 的和为 1 + 2 + 3 + 3 + 4 = 13 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4], n = 4, left = 3, right = 4
 * 输出：6
 * 解释：给定数组与示例 1 一样，所以新数组为 [1, 2, 3, 3, 4, 5, 6, 7, 9, 10] 。下标从 le = 3 到 ri = 4 的和为 3 + 3 = 6 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,4], n = 4, left = 1, right = 10
 * 输出：50
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^3
 * nums.length == n
 * 1 <= nums[i] <= 100
 * 1 <= left <= right <= n * (n + 1) / 2
 *
 */
public class Code10 {

    public int rangeSum(int[] nums, int n, int left, int right) {
        //数组
        int[] arr = new int[n * (n + 1) / 2];
        //索引
        int index = 0;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //和
            int sum = 0;
            //循环2
            for (int j = i; j < nums.length; j++) {
                //叠加本次
                sum += nums[j];
                //记录本次和
                arr[index++] = sum;
            }
        }
        //排序
        Arrays.sort(arr);
        //结果
        int sum = 0;
        //循环
        for (int i = left - 1; i <= right - 1; i++) {
            //叠加
            sum = (arr[i] + sum) % 1000000007;
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {

    }

}
