package easy36;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-03-03
 * 100231. 超过阈值的最少操作数 I
 * 简单
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * <p>
 * 一次操作中，你可以删除 nums 中的最小元素。
 * <p>
 * 你需要使数组中的所有元素都大于或等于 k ，请你返回需要的 最少 操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,11,10,1,3], k = 10
 * 输出：3
 * 解释：第一次操作后，nums 变为 [2, 11, 10, 3] 。
 * 第二次操作后，nums 变为 [11, 10, 3] 。
 * 第三次操作后，nums 变为 [11, 10] 。
 * 此时，数组中的所有元素都大于等于 10 ，所以我们停止操作。
 * 使数组中所有元素都大于等于 10 需要的最少操作次数为 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,2,4,9], k = 1
 * 输出：0
 * 解释：数组中的所有元素都大于等于 1 ，所以不需要对 nums 做任何操作。
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,2,4,9], k = 9
 * 输出：4
 * 解释：nums 中只有一个元素大于等于 9 ，所以需要执行 4 次操作。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * 1 <= nums[i] <= 109
 * 1 <= k <= 109
 * 输入保证至少有一个满足 nums[i] >= k 的下标 i 存在。
 */
public class Code12 {

    public int minOperations(int[] nums, int k) {
        //返回结果
        return (int) Arrays.stream(nums)
                .filter(p -> p < k)
                .count();
    }

    public static void main(String[] args) {
        int result = new Code12().minOperations(new int[]{69, 89, 57, 31, 84, 97, 50, 38, 91}, 69);
        System.out.println(result);
    }

}
