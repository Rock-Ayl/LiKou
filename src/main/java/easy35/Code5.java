package easy35;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2023-11-19
 * 2932. 找出强数对的最大异或值 I
 * 提示
 * 简单
 * 2
 * 相关企业
 * 给你一个下标从 0 开始的整数数组 nums 。如果一对整数 x 和 y 满足以下条件，则称其为 强数对 ：
 * <p>
 * |x - y| <= min(x, y)
 * 你需要从 nums 中选出两个整数，且满足：这两个整数可以形成一个强数对，并且它们的按位异或（XOR）值是在该数组所有强数对中的 最大值 。
 * <p>
 * 返回数组 nums 所有可能的强数对中的 最大 异或值。
 * <p>
 * 注意，你可以选择同一个整数两次来形成一个强数对。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：7
 * 解释：数组 nums 中有 11 个强数对：(1, 1), (1, 2), (2, 2), (2, 3), (2, 4), (3, 3), (3, 4), (3, 5), (4, 4), (4, 5) 和 (5, 5) 。
 * 这些强数对中的最大异或值是 3 XOR 4 = 7 。
 * 示例 2：
 * <p>
 * 输入：nums = [10,100]
 * 输出：0
 * 解释：数组 nums 中有 2 个强数对：(10, 10) 和 (100, 100) 。
 * 这些强数对中的最大异或值是 10 XOR 10 = 0 ，数对 (100, 100) 的异或值也是 100 XOR 100 = 0 。
 * 示例 3：
 * <p>
 * 输入：nums = [5,6,25,30]
 * 输出：7
 * 解释：数组 nums 中有 6 个强数对：(5, 5), (5, 6), (6, 6), (25, 25), (25, 30) 和 (30, 30) 。
 * 这些强数对中的最大异或值是 25 XOR 30 = 7 ；另一个异或值非零的数对是 (5, 6) ，其异或值是 5 XOR 6 = 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * 1 <= nums[i] <= 100
 */
public class Code5 {

    public int maximumStrongPairXor(int[] nums) {
        //排序
        Arrays.sort(nums);
        //最大结果
        int max = 0;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //循环
            for (int j = i + 1; j < nums.length; j++) {
                //如果不满足
                if (nums[j] - nums[i] > nums[i]) {
                    //本轮过
                    continue;
                }
                //计算
                max = Math.max(max, nums[i] ^ nums[j]);
            }
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().maximumStrongPairXor(new int[]{1, 2, 3, 4, 5}));
    }

}
