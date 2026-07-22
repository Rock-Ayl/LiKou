package normal55;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1546. 和为目标值且不重叠的非空子数组的最大数目
 * 算术评级: 6
 * 第 201 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1855
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个数组 nums 和一个整数 target 。
 * <p>
 * 请你返回 非空不重叠 子数组的最大数目，且每个子数组中数字和都为 target 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,1,1], target = 2
 * 输出：2
 * 解释：总共有 2 个不重叠子数组（加粗数字表示） [1,1,1,1,1] ，它们的和为目标值 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [-1,3,5,1,4,2,-9], target = 6
 * 输出：2
 * 解释：总共有 3 个子数组和为 6 。
 * ([5,1], [4,2], [3,5,1,4,2,-9]) 但只有前 2 个是不重叠的。
 * 示例 3：
 * <p>
 * 输入：nums = [-2,6,6,3,5,4,1,2,8], target = 10
 * 输出：3
 * 示例 4：
 * <p>
 * 输入：nums = [0,0,0], target = 0
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 0 <= target <= 10^6
 */
public class Code12 {

    public int maxNonOverlapping(int[] nums, int target) {

        /**
         * 前缀和 、 hash索引、计算所有区间
         */

        //所有区间列表
        List<int[]> groupList = new ArrayList<>();
        //和最后出现的索引map
        Map<Integer, Integer> lastSumIndexMap = new HashMap<>();
        //默认开始索引
        lastSumIndexMap.put(0, -1);
        //当前和(前缀和)
        int sum = 0;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //叠加本次前缀和
            sum = nums[i] + sum;
            //需要减去多少
            int targetSum = sum - target;
            //获取索引
            Integer lastSumIndex = lastSumIndexMap.get(targetSum);
            //如果有
            if (lastSumIndex != null) {
                //记录
                groupList.add(new int[]{lastSumIndex + 1, i});
            }
            //结束、覆盖
            lastSumIndexMap.put(sum, i);
        }

        /**
         * 计算出最大可能
         */

        //结果,默认视为全部可以组合成一个
        int count = groupList.size();
        //上一个索引
        int lastIndex = 0;
        //循环
        for (int i = 1; i < groupList.size(); i++) {
            //当前区间
            int[] thisSpaceArr = groupList.get(i);
            //上一个区间
            int[] lastSpaceArr = groupList.get(lastIndex);
            //如果当前区间不重叠
            if (thisSpaceArr[0] > lastSpaceArr[1]) {
                //更新
                lastIndex = i;
                //本轮过
                continue;
            }
            //如果新的被老的完全包含
            if (thisSpaceArr[1] <= lastSpaceArr[1]) {
                //更新
                lastIndex = i;
            }
            //删除一个
            count--;
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().maxNonOverlapping(new int[]{1, 1, 1, 1, 1}, 2));
    }

}
