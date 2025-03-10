package easy30;

/**
 * @Author ayl
 * @Date 2023-04-20
 * 2644. 找出可整除性得分最大的整数
 * 给你两个下标从 0 开始的整数数组 nums 和 divisors 。
 * <p>
 * divisors[i] 的 可整除性得分 等于满足 nums[j] 能被 divisors[i] 整除的下标 j 的数量。
 * <p>
 * 返回 可整除性得分 最大的整数 divisors[i] 。如果有多个整数具有最大得分，则返回数值最小的一个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,7,9,3,9], divisors = [5,2,3]
 * 输出：3
 * 解释：divisors 中每个元素的可整除性得分为：
 * divisors[0] 的可整除性得分为 0 ，因为 nums 中没有任何数字能被 5 整除。
 * divisors[1] 的可整除性得分为 1 ，因为 nums[0] 能被 2 整除。
 * divisors[2] 的可整除性得分为 3 ，因为 nums[2]、nums[3] 和 nums[4] 都能被 3 整除。
 * 因此，返回 divisors[2] ，它的可整除性得分最大。
 * 示例 2：
 * <p>
 * 输入：nums = [20,14,21,10], divisors = [5,7,5]
 * 输出：5
 * 解释：divisors 中每个元素的可整除性得分为：
 * divisors[0] 的可整除性得分为 2 ，因为 nums[0] 和 nums[3] 都能被 5 整除。
 * divisors[1] 的可整除性得分为 2 ，因为 nums[1] 和 nums[2] 都能被 7 整除。
 * divisors[2] 的可整除性得分为 2 ，因为 nums[0] 和 nums[3] 都能被5整除。
 * 由于 divisors[0]、divisors[1] 和 divisors[2] 的可整除性得分都是最大的，因此，我们返回数值最小的一个，即 divisors[2] 。
 * 示例 3：
 * <p>
 * 输入：nums = [12], divisors = [10,16]
 * 输出：10
 * 解释：divisors 中每个元素的可整除性得分为：
 * divisors[0] 的可整除性得分为 0 ，因为 nums 中没有任何数字能被 10 整除。
 * divisors[1] 的可整除性得分为 0 ，因为 nums 中没有任何数字能被 16 整除。
 * 由于 divisors[0] 和 divisors[1] 的可整除性得分都是最大的，因此，我们返回数值最小的一个，即 divisors[0] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length, divisors.length <= 1000
 * 1 <= nums[i], divisors[i] <= 109
 */
public class Code7 {

    public int maxDivScore(int[] nums, int[] divisors) {
        //最大可能
        int maxCount = -1;
        int max = -1;
        //循环
        for (int divisor : divisors) {
            //次数
            int count = 0;
            //循环2
            for (int num : nums) {
                //如果满足
                if (num % divisor == 0) {
                    //+1
                    count++;
                }
            }
            //如果最大
            if (count > maxCount) {
                //记录
                max = divisor;
                maxCount = count;
            } else if (count == maxCount) {
                //返回最小
                max = Math.min(divisor, max);
            }
        }
        //返回
        return max;
    }

    public static void main(String[] args) {

        System.out.println(new Code7().maxDivScore(new int[]{73, 13, 20, 6}, new int[]{56, 75, 83, 26, 24, 53, 56, 61}));
    }
}
