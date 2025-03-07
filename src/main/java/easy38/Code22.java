package easy38;

import java.util.Arrays;
import java.util.List;

/**
 * @Author ayl
 * @Date 2024-11-11
 * 3349. 检测相邻递增子数组 I
 * 简单
 * 相关企业
 * 提示
 * 给你一个由 n 个整数组成的数组 nums 和一个整数 k，请你确定是否存在 两个 相邻 且长度为 k 的 严格递增 子数组。具体来说，需要检查是否存在从下标 a 和 b (a < b) 开始的 两个 子数组，并满足下述全部条件：
 * <p>
 * 这两个子数组 nums[a..a + k - 1] 和 nums[b..b + k - 1] 都是 严格递增 的。
 * 这两个子数组必须是 相邻的，即 b = a + k。
 * 如果可以找到这样的 两个 子数组，请返回 true；否则返回 false。
 * <p>
 * 子数组 是数组中的一个连续 非空 的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,7,8,9,2,3,4,3,1], k = 3
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * 从下标 2 开始的子数组为 [7, 8, 9]，它是严格递增的。
 * 从下标 5 开始的子数组为 [2, 3, 4]，它也是严格递增的。
 * 两个子数组是相邻的，因此结果为 true。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,4,4,4,5,6,7], k = 5
 * <p>
 * 输出：false
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 100
 * 1 <= 2 * k <= nums.length
 * -1000 <= nums[i] <= 1000
 */
public class Code22 {

    //尝试检测
    private boolean check(int[] arr, List<Integer> nums, int start, int end) {
        //如果之前存在 && 之前是递增数组 && 本次最后一个大于之前的最后一个
        if (start - 1 >= 0 && arr[start - 1] == 1 && nums.get(end) > nums.get(end - 1)) {
            //直接返回
            return true;
        }
        //循环
        for (int i = start + 1; i <= end; i++) {
            //如果不是严格递增
            if (nums.get(i) <= nums.get(i - 1)) {
                //过
                return false;
            }
        }
        //返回
        return true;
    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        //初始化检查数组
        int[] arr = new int[nums.size()];
        //循环
        for (int i = 0; i <= nums.size() - k; i++) {
            //检测本次是否为递增数组
            if (check(arr, nums, i, i + k - 1)) {
                //记录
                arr[i] = 1;
            }
            //如果本次是 and 之前的也是
            if (i - k >= 0 && arr[i] == 1 && arr[i - k] == 1) {
                //返回结果
                return true;
            }
        }
        //默认不行
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code22().hasIncreasingSubarrays(Arrays.asList(2, 5, 7, 8, 9, 2, 3, 4, 3, 1), 3));
    }

}
