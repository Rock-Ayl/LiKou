package easy39;

import java.util.Arrays;
import java.util.List;

/**
 * @Author ayl
 * @Date 2024-12-16
 * 3364. 最小正和子数组
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和 两个 整数 l 和 r。你的任务是找到一个长度在 l 和 r 之间（包含）且和大于 0 的 子数组 的 最小 和。
 * <p>
 * 返回满足条件的子数组的 最小 和。如果不存在这样的子数组，则返回 -1。
 * <p>
 * 子数组 是数组中的一个连续 非空 元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [3, -2, 1, 4], l = 2, r = 3
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * 长度在 l = 2 和 r = 3 之间且和大于 0 的子数组有：
 * <p>
 * [3, -2] 和为 1
 * [1, 4] 和为 5
 * [3, -2, 1] 和为 2
 * [-2, 1, 4] 和为 3
 * 其中，子数组 [3, -2] 的和为 1，是所有正和中最小的。因此，答案为 1。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [-2, 2, -3, 1], l = 2, r = 3
 * <p>
 * 输出： -1
 * <p>
 * 解释：
 * <p>
 * 不存在长度在 l 和 r 之间且和大于 0 的子数组。因此，答案为 -1。
 * <p>
 * 示例 3：
 * <p>
 * 输入： nums = [1, 2, 3, 4], l = 2, r = 4
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 子数组 [1, 2] 的长度为 2，和为 3，是所有正和中最小的。因此，答案为 3。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= l <= r <= nums.length
 * -1000 <= nums[i] <= 1000
 */
public class Code5 {

    //计算区间和
    private int count(int[] arr, int start, int end) {
        //默认和
        int sum = arr[end];
        //如果需要减
        if (start - 1 >= 0) {
            //减
            sum -= arr[start - 1];
        }
        //返回
        return sum;
    }

    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        //前缀和
        int[] arr = new int[nums.size()];
        //第一个
        arr[0] = nums.get(0);
        //循环
        for (int i = 1; i < nums.size(); i++) {
            //叠加
            arr[i] = arr[i - 1] + nums.get(i);
        }
        //最小结果
        int min = Integer.MAX_VALUE;
        //循环1
        for (int start = 0; start < nums.size(); start++) {
            //循环2
            for (int end = start + l - 1; end < Math.min(start + r, nums.size()); end++) {
                //计算
                int count = count(arr, start, end);
                //如果满足
                if (count > 0) {
                    //计算并刷新最小值
                    min = Math.min(min, count);
                }
            }
        }
        //返回
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().minimumSumSubarray(Arrays.asList(3, -2, 1, 4), 2, 3));
    }

}
