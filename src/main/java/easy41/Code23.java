package easy41;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-11-09
 * 100891. 最小操作次数使数组元素相等 III
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。
 * <p>
 * 在一步操作中，你可以将任意单个元素 nums[i] 的值 增加 1。
 * <p>
 * 返回使数组中的所有元素都 相等 所需的 最小总操作次数 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,1,3]
 * <p>
 * 输出: 3
 * <p>
 * 解释:
 * <p>
 * 使所有元素相等的操作如下:
 * <p>
 * 将 nums[0] = 2 增加 1, 变为 3。
 * 将 nums[1] = 1 增加 1, 变为 2。
 * 将 nums[1] = 2 增加 1, 变为 3。
 * 现在，nums 中的所有元素都等于 3。最小总操作次数为 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [4,4,5]
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * <p>
 * 使所有元素相等的操作如下:
 * <p>
 * 将 nums[0] = 4 增加 1, 变为 5。
 * 将 nums[1] = 4 增加 1, 变为 5。
 * 现在，nums 中的所有元素都等于 5。最小总操作次数为 2。
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Code23 {

    public int minMoves(int[] nums) {
        //最大情况
        int max = Arrays.stream(nums).max().getAsInt();
        //返回结果
        return Arrays.stream(nums).map(p -> max - p).sum();
    }

    public static void main(String[] args) {
        System.out.println(new Code23().minMoves(new int[]{2, 1, 3}));
    }

}
