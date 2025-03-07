package easy33;

import java.util.Arrays;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-08-26
 * 2824. 统计和小于目标的下标对数目
 * 提示
 * 简单
 * 3
 * 相关企业
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 target ，请你返回满足 0 <= i < j < n 且 nums[i] + nums[j] < target 的下标对 (i, j) 的数目。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,1,2,3,1], target = 2
 * 输出：3
 * 解释：总共有 3 个下标对满足题目描述：
 * - (0, 1) ，0 < 1 且 nums[0] + nums[1] = 0 < target
 * - (0, 2) ，0 < 2 且 nums[0] + nums[2] = 1 < target
 * - (0, 4) ，0 < 4 且 nums[0] + nums[4] = 0 < target
 * 注意 (0, 3) 不计入答案因为 nums[0] + nums[3] 不是严格小于 target 。
 * 示例 2：
 * <p>
 * 输入：nums = [-6,2,5,-2,-7,-1,3], target = -2
 * 输出：10
 * 解释：总共有 10 个下标对满足题目描述：
 * - (0, 1) ，0 < 1 且 nums[0] + nums[1] = -4 < target
 * - (0, 3) ，0 < 3 且 nums[0] + nums[3] = -8 < target
 * - (0, 4) ，0 < 4 且 nums[0] + nums[4] = -13 < target
 * - (0, 5) ，0 < 5 且 nums[0] + nums[5] = -7 < target
 * - (0, 6) ，0 < 6 且 nums[0] + nums[6] = -3 < target
 * - (1, 4) ，1 < 4 且 nums[1] + nums[4] = -5 < target
 * - (3, 4) ，3 < 4 且 nums[3] + nums[4] = -9 < target
 * - (3, 5) ，3 < 5 且 nums[3] + nums[5] = -3 < target
 * - (4, 5) ，4 < 5 且 nums[4] + nums[5] = -8 < target
 * - (4, 6) ，4 < 6 且 nums[4] + nums[6] = -4 < target
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length == n <= 50
 * -50 <= nums[i], target <= 50
 */
public class Code4 {

    public int countPairs(List<Integer> nums, int target) {
        //结果
        int result = 0;
        //循环1
        for (int i = 0; i < nums.size(); i++) {
            //左边
            int left = nums.get(i);
            //循环2
            for (int j = i + 1; j < nums.size(); j++) {
                //右边
                int right = nums.get(j);
                //如果满足
                if (left + right < target) {
                    //记录
                    result++;
                }
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().countPairs(Arrays.asList(-6, 2, 5, -2, -7, -1, 3), -2));
    }

}
