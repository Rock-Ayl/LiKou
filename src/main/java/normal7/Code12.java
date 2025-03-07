package normal7;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2021-09-10
 * 1877. 数组中最大数对和的最小值
 * 一个数对 (a,b) 的 数对和 等于 a + b 。最大数对和 是一个数对数组中最大的 数对和 。
 * <p>
 * 比方说，如果我们有数对 (1,5) ，(2,3) 和 (4,4)，最大数对和 为 max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8 。
 * 给你一个长度为 偶数 n 的数组 nums ，请你将 nums 中的元素分成 n / 2 个数对，使得：
 * <p>
 * nums 中每个元素 恰好 在 一个 数对中，且
 * 最大数对和 的值 最小 。
 * 请你在最优数对划分的方案下，返回最小的 最大数对和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,5,2,3]
 * 输出：7
 * 解释：数组中的元素可以分为数对 (3,3) 和 (5,2) 。
 * 最大数对和为 max(3+3, 5+2) = max(6, 7) = 7 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,5,4,2,4,6]
 * 输出：8
 * 解释：数组中的元素可以分为数对 (3,5)，(4,4) 和 (6,2) 。
 * 最大数对和为 max(3+5, 4+4, 6+2) = max(8, 8, 8) = 8 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 2 <= n <= 105
 * n 是 偶数 。
 * 1 <= nums[i] <= 105
 */
public class Code12 {

    public int minPairSum(int[] nums) {
        //排序
        Arrays.sort(nums);
        //最大值
        int max = nums[0];
        //循环
        int x = 0, y = nums.length - 1;
        //循环
        while (x < y) {
            //计算
            int sum = nums[x++] + nums[y--];
            //如果是
            if (sum > max) {
                //赋予
                max = sum;
            }
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().minPairSum(new int[]{3, 5, 4, 2, 4, 6}));
    }
}
