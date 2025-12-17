package normal48;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2025-12-17
 * 523. 连续的子数组和
 * 尝试过
 * 算术评级: 5
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个整数数组 nums 和一个整数 k ，如果 nums 有一个 好的子数组 返回 true ，否则返回 false：
 * <p>
 * 一个 好的子数组 是：
 * <p>
 * 长度 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 注意：
 * <p>
 * 子数组 是数组中 连续 的部分。
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终 视为 k 的一个倍数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [23,2,6,4,7], k = 6
 * 输出：true
 * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
 * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 * 示例 3：
 * <p>
 * 输入：nums = [23,2,6,4,7], k = 13
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= sum(nums[i]) <= 231 - 1
 * 1 <= k <= 231 - 1
 */
public class Code26 {

    public boolean checkSubarraySum(int[] nums, int k) {
        //前缀和数组
        int[] arr = new int[nums.length];
        //循环
        for (int i = 0; i < arr.length; i++) {
            //求和
            arr[i] = ((i > 0 ? arr[i - 1] : 0) + nums[i]) % k;
        }
        //缓存
        Set<Integer> startSet = new HashSet<>();
        //默认有0这种情况
        startSet.add(0);
        //循环1
        for (int i = 1; i < arr.length; i++) {
            //如果可以
            if (i - 2 >= 0) {
                //要加入缓存的
                int start = arr[i - 2];
                //加入缓存
                startSet.add(start);
            }
            //如果存在
            if (startSet.contains(arr[i])) {
                //可以
                return true;
            }
        }
        //默认不行
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code26().checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));
    }

}
