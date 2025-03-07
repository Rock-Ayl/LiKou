package normal7;

import java.util.*;

/**
 * @Author ayl
 * @Date 2021-08-31
 * 1695. 删除子数组的最大得分
 * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 * <p>
 * 返回 只删除一个 子数组可获得的 最大得分 。
 * <p>
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,2,4,5,6]
 * 输出：17
 * 解释：最优子数组是 [2,4,5,6]
 * 示例 2：
 * <p>
 * 输入：nums = [5,2,1,2,5,2,1,2,5]
 * 输出：8
 * 解释：最优子数组是 [5,2,1] 或 [1,2,5]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */
public class Code2 {

    public int maximumUniqueSubarray(int[] nums) {
        //最大
        int max = 0;
        //缓存
        Set<Integer> set = new HashSet<>();
        //左右边界
        int left = 0, right = 0;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //当前
            int num = nums[i];
            //如果存在了
            if (set.contains(num)) {
                //和
                int sum = 0;
                //循环
                for (int j = left; j < right; j++) {
                    //记录
                    sum += nums[j];
                }
                //对比刷新记录
                max = Math.max(max, sum);
                //当前
                int next = nums[left++];
                //如果不是节选的
                while (next != num) {
                    //删除缓存
                    set.remove(next);
                    next = nums[left++];
                }
                //删除缓存
                set.remove(next);
            }
            //记录
            set.add(num);
            //记录最后
            right++;
        }
        //和
        int sum = 0;
        //循环
        for (int j = left; j < right; j++) {
            //记录
            sum += nums[j];
        }
        //对比刷新记录
        max = Math.max(max, sum);
        //返回最大值
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}));
    }
}
