package normal52;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3350. 检测相邻递增子数组 II
 * 算术评级: 4
 * 第 423 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1600
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个由 n 个整数组成的数组 nums ，请你找出 k 的 最大值，使得存在 两个 相邻 且长度为 k 的 严格递增 子数组。具体来说，需要检查是否存在从下标 a 和 b (a < b) 开始的 两个 子数组，并满足下述全部条件：
 * <p>
 * 这两个子数组 nums[a..a + k - 1] 和 nums[b..b + k - 1] 都是 严格递增 的。
 * 这两个子数组必须是 相邻的，即 b = a + k。
 * 返回 k 的 最大可能 值。
 * <p>
 * 子数组 是数组中的一个连续 非空 的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,7,8,9,2,3,4,3,1]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 从下标 2 开始的子数组是 [7, 8, 9]，它是严格递增的。
 * 从下标 5 开始的子数组是 [2, 3, 4]，它也是严格递增的。
 * 这两个子数组是相邻的，因此 3 是满足题目条件的 最大 k 值。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,4,4,4,5,6,7]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 从下标 0 开始的子数组是 [1, 2]，它是严格递增的。
 * 从下标 2 开始的子数组是 [3, 4]，它也是严格递增的。
 * 这两个子数组是相邻的，因此 2 是满足题目条件的 最大 k 值。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 2 * 105
 * -109 <= nums[i] <= 109
 */
public class Code8 {

    public int maxIncreasingSubarrays(List<Integer> nums) {

        /**
         * 构建递增数组
         */

        //递增hit数组
        int[] hitArrr = new int[nums.size()];
        //默认
        hitArrr[0] = 1;
        //循环
        for (int i = 1; i < hitArrr.length; i++) {
            //如果递增
            if (nums.get(i) > nums.get(i - 1)) {
                //+1
                hitArrr[i] = hitArrr[i - 1] + 1;
            } else {
                //初始化
                hitArrr[i] = 1;
            }
        }

        /**
         * 分组
         */

        //列表
        List<Integer> groupList = new ArrayList<>();
        //循环
        for (int i = 0; i < hitArrr.length; i++) {
            //如果是最后一个
            if (i == hitArrr.length - 1 || hitArrr[i + 1] == 1) {
                //记录
                groupList.add(hitArrr[i]);
            }
        }

        /**
         * 计算
         */

        //最大结果
        int max = groupList.get(0);
        //循环
        for (int i = 1; i < groupList.size(); i++) {
            //本次组合
            int lenght = Math.min(groupList.get(i), groupList.get(i - 1)) * 2;
            //刷新最大
            max = Math.max(max, lenght);
            //刷新最大2
            max = Math.max(max, groupList.get(i));
        }
        //返回结果
        return max / 2;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().maxIncreasingSubarrays(Arrays.asList(1, 2, 3, 4, 4, 4, 4, 5, 6, 7)));
        ;
    }

}