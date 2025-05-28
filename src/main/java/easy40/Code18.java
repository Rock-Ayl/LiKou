package easy40;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2025-05-28
 * LCR 101. 分割等和子集
 * 尝试过
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个非空的正整数数组 nums ，请判断能否将这些数字分成元素和相等的两部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：nums 可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：nums 不可以分为和相等的两部分
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * <p>
 * <p>
 * 注意：本题与主站 416 题相同： https://leetcode-cn.com/problems/partition-equal-subset-sum/
 */
public class Code18 {

    public boolean canPartition(int[] nums) {
        //求和
        int sum = Arrays.stream(nums).sum();
        //如果不是偶数
        if (sum % 2 != 0) {
            //过
            return false;
        }
        //目标值
        int target = sum / 2;
        //递归实现
        return next(new HashSet<>(Collections.singletonList(0)), 0, nums, target);
    }

    //递归实现
    private boolean next(Set<Integer> sumSet, int index, int[] nums, int target) {
        //如果越界
        if (index >= nums.length) {
            //过
            return false;
        }
        //下一个集合
        Set<Integer> nextSumSet = new HashSet<>();
        //循环
        for (Integer sum : sumSet) {
            //计算新和
            int newSum = sum + nums[index];
            //如果是目标值
            if (newSum == target) {
                //返回结果
                return true;
            }
            //如果还小,说明还有机会
            if (newSum < target) {
                //加入到下一个集合
                nextSumSet.add(newSum);
            }
        }
        //加入所有本次集合
        sumSet.addAll(nextSumSet);
        //递归
        return next(sumSet, index + 1, nums, target);
    }

    public static void main(String[] args) {
        System.out.println(new Code18().canPartition(new int[]{1, 5, 11, 5}));
    }

}