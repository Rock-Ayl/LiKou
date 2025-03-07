package easy33;

import java.util.Arrays;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-09-20
 * 2859. 计算 K 置位下标对应元素的和
 * 提示
 * 简单
 * 4
 * 相关企业
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * <p>
 * 请你用整数形式返回 nums 中的特定元素之 和 ，这些特定元素满足：其对应下标的二进制表示中恰存在 k 个置位。
 * <p>
 * 整数的二进制表示中的 1 就是这个整数的 置位 。
 * <p>
 * 例如，21 的二进制表示为 10101 ，其中有 3 个置位。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,10,1,5,2], k = 1
 * 输出：13
 * 解释：下标的二进制表示是：
 * 0 = 0002
 * 1 = 0012
 * 2 = 0102
 * 3 = 0112
 * 4 = 1002
 * 下标 1、2 和 4 在其二进制表示中都存在 k = 1 个置位。
 * 因此，答案为 nums[1] + nums[2] + nums[4] = 13 。
 * 示例 2：
 * <p>
 * 输入：nums = [4,3,2,1], k = 2
 * 输出：1
 * 解释：下标的二进制表示是：
 * 0 = 002
 * 1 = 012
 * 2 = 102
 * 3 = 112
 * 只有下标 3 的二进制表示中存在 k = 2 个置位。
 * 因此，答案为 nums[3] = 1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 105
 * 0 <= k <= 10
 */
public class Code11 {

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        //结果
        int sum = 0;
        //循环
        for (int i = 0; i < nums.size(); i++) {
            //计算
            int bit = Integer.bitCount(i);
            //如果是
            if (bit == k) {
                //叠加
                sum += nums.get(i);
            }
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code11().sumIndicesWithKSetBits(Arrays.asList(5, 10, 1, 5, 2), 1));
    }
}
