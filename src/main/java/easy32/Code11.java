package easy32;

/**
 * @Author ayl
 * @Date 2023-07-08
 * 2760. 最长奇偶子数组
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 threshold 。
 * <p>
 * 请你从 nums 的子数组中找出以下标 l 开头、下标 r 结尾 (0 <= l <= r < nums.length) 且满足以下条件的 最长子数组 ：
 * <p>
 * nums[l] % 2 == 0
 * 对于范围 [l, r - 1] 内的所有下标 i ，nums[i] % 2 != nums[i + 1] % 2
 * 对于范围 [l, r] 内的所有下标 i ，nums[i] <= threshold
 * 以整数形式返回满足题目要求的最长子数组的长度。
 * <p>
 * 注意：子数组 是数组中的一个连续非空元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,5,4], threshold = 5
 * 输出：3
 * 解释：在这个示例中，我们选择从 l = 1 开始、到 r = 3 结束的子数组 => [2,5,4] ，满足上述条件。
 * 因此，答案就是这个子数组的长度 3 。可以证明 3 是满足题目要求的最大长度。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2], threshold = 2
 * 输出：1
 * 解释：
 * 在这个示例中，我们选择从 l = 1 开始、到 r = 1 结束的子数组 => [2] 。
 * 该子数组满足上述全部条件。可以证明 1 是满足题目要求的最大长度。
 * 示例 3：
 * <p>
 * 输入：nums = [2,3,4,5], threshold = 4
 * 输出：3
 * 解释：
 * 在这个示例中，我们选择从 l = 0 开始、到 r = 2 结束的子数组 => [2,3,4] 。
 * 该子数组满足上述全部条件。
 * 因此，答案就是这个子数组的长度 3 。可以证明 3 是满足题目要求的最大长度。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * 1 <= threshold <= 100
 */
public class Code11 {

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        //如果不满足
        if (nums.length < 3) {
            //过
            return 0;
        }
        //初始化结果
        int maxHit = 0;
        //当前连击
        int hit = 0;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //当前数字
            int num = nums[i];
            //如果超过了
            if (num > threshold) {
                //刷新最大
                maxHit = Math.max(maxHit, hit);
                //重置
                hit = 0;
                //本轮过
                continue;
            }
            //如果是开始
            if (hit == 0) {
                //如果是偶数
                if (num % 2 == 0) {
                    //+1
                    hit++;
                }
                //本轮过
                continue;
            }
            //上一个
            int last = nums[i - 1];
            //如果不满足条件
            if (last % 2 == num % 2) {
                //刷新最大
                maxHit = Math.max(maxHit, hit);
                //重置
                hit = 0;
                //如果是偶数
                if (num % 2 == 0) {
                    //+1
                    hit++;
                }
                //本轮过
                continue;
            }
            //+1
            hit++;
        }
        //返回最大结果
        return Math.max(maxHit, hit);
    }

    public static void main(String[] args) {
        System.out.println(new Code11().longestAlternatingSubarray(new int[]{4, 10, 3}, 10));
    }

}
