package easy32;

/**
 * @Author ayl
 * @Date 2023-07-09
 * 6913. 最长交替子序列
 * 给你一个下标从 0 开始的整数数组 nums 。如果 nums 中长度为 m 的子数组 s 满足以下条件，我们称它是一个交替子序列：
 * <p>
 * m 大于 1 。
 * s1 = s0 + 1 。
 * 下标从 0 开始的子数组 s 与数组 [s0, s1, s0, s1,...,s(m-1) % 2] 一样。也就是说，s1 - s0 = 1 ，s2 - s1 = -1 ，s3 - s2 = 1 ，s4 - s3 = -1 ，以此类推，直到 s[m - 1] - s[m - 2] = (-1)m 。
 * 请你返回 nums 中所有 交替 子数组中，最长的长度，如果不存在交替子数组，请你返回 -1 。
 * <p>
 * 子数组是一个数组中一段连续 非空 的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,4,3,4]
 * 输出：4
 * 解释：交替子数组有 [3,4] ，[3,4,3] 和 [3,4,3,4] 。最长的子数组为 [3,4,3,4] ，长度为4 。
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6]
 * 输出：2
 * 解释：[4,5] 和 [5,6] 是仅有的两个交替子数组。它们长度都为 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 100
 * 1 <= nums[i] <= 104
 */
public class Code12 {

    public int alternatingSubarray(int[] nums) {
        //最大连击
        int maxHit = 0;
        //逊汗
        for (int i = 0; i < nums.length - 1; i++) {
            //当前数字
            int first = nums[i];
            int second = nums[i + 1];
            //如果不是
            if (first + 1 != second) {
                //本轮过
                continue;
            }
            //默认连击
            int hit = 2;
            //初始化指针
            int p = i + 2;
            //如果满足
            while (p < nums.length && nums[p] == first && (nums[p] + 1 == second || nums[p] - 1 == second)) {
                //进位
                hit++;
                first = second;
                second = nums[p];
                p++;
            }
            //刷新最大
            maxHit = Math.max(maxHit, hit);
        }
        //如果是默认
        if (maxHit == 0) {
            //默认
            return -1;
        }
        //返回结果
        return maxHit;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().alternatingSubarray(new int[]{2, 3, 4, 3, 4}));
    }

}
