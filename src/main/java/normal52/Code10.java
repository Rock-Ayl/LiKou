package normal52;

import java.util.HashMap;
import java.util.Map;

/**
 * 2364. 统计坏数对的数目
 * 算术评级: 5
 * 第 84 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1622
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 。如果 i < j 且 j - i != nums[j] - nums[i] ，那么我们称 (i, j) 是一个 坏数对 。
 * <p>
 * 请你返回 nums 中 坏数对 的总数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,3,3]
 * 输出：5
 * 解释：数对 (0, 1) 是坏数对，因为 1 - 0 != 1 - 4 。
 * 数对 (0, 2) 是坏数对，因为 2 - 0 != 3 - 4, 2 != -1 。
 * 数对 (0, 3) 是坏数对，因为 3 - 0 != 3 - 4, 3 != -1 。
 * 数对 (1, 2) 是坏数对，因为 2 - 1 != 3 - 1, 1 != 2 。
 * 数对 (2, 3) 是坏数对，因为 3 - 2 != 3 - 3, 1 != 0 。
 * 总共有 5 个坏数对，所以我们返回 5 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：0
 * 解释：没有坏数对。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 */
public class Code10 {

    public long countBadPairs(int[] nums) {

        /**
         * 统计分组
         */

        //分组
        Map<Integer, Integer> groupMap = new HashMap<>();
        //循环
        for (int i = 0; i < nums.length; i++) {
            //分组key
            Integer key = nums[i] - i;
            //记录
            groupMap.put(key, groupMap.getOrDefault(key, 0) + 1);
        }

        /**
         * 计算结果
         */

        //如果所有数字都是坏组合的可能
        long result = count(nums.length);
        //循环
        for (Integer count : groupMap.values()) {
            //计算出本分组有多少个好组合,删除之
            result -= count(count);
        }
        //最终结果
        return result;
    }

    //计算分组下,好组合数量(高斯算法)
    private long count(int count) {
        //长度
        long length = count - 1;
        //左右
        long left = (length + 1) * (length / 2);
        long right = length % 2 == 0 ? 0 : ((length + 1) / 2);
        //返回
        return left + right;
    }

    public static void main(String[] args) {
        System.out.println(new Code10().countBadPairs(new int[]{4, 1, 3, 3}));
    }
}
