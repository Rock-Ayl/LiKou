package normal40;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-02-21
 * 1296. 划分数组为连续数字的集合
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。
 * 如果可以，请返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,3,4,4,5,6], k = 4
 * 输出：true
 * 解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
 * 输出：true
 * 解释：数组可以分成 [1,2,3] , [2,3,4] , [3,4,5] 和 [9,10,11]。
 * 示例 4：
 * <p>
 * 输入：nums = [1,2,3,4], k = 3
 * 输出：false
 * 解释：数组不能分成几个大小为 3 的子数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * <p>
 * <p>
 * 注意：此题目与 846 重复：https://leetcode-cn.com/problems/hand-of-straights/
 */
public class Code9 {

    public boolean isPossibleDivide(int[] nums, int k) {
        //缓存
        Map<Integer, Integer> map = new HashMap<>();
        //最大最小
        int min = nums[0];
        int max = nums[0];
        //循环
        for (int num : nums) {
            //+1
            map.put(num, map.getOrDefault(num, 0) + 1);
            //刷新最大最小
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        //循环
        while (min <= max) {
            //如果没有
            if (map.getOrDefault(min, 0) == 0) {
                //+1
                min++;
                //本轮过
                continue;
            }
            //循环
            for (int i = min; i < min + k; i++) {
                //-1,计算新数字
                int count = map.getOrDefault(i, 0) - 1;
                //如果不够
                if (count < 0) {
                    //不行
                    return false;
                }
                //覆盖
                map.put(i, count);
            }
        }
        //默认可以
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().isPossibleDivide(new int[]{3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11}, 3));
    }

}
