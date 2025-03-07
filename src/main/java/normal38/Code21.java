package normal38;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2024-12-26
 * LCR 011. 连续数组
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 * 示例 2：
 * <p>
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 * <p>
 * <p>
 * 注意：本题与主站 525 题相同： https://leetcode-cn.com/problems/contiguous-array/
 */
public class Code21 {

    public int findMaxLength(int[] nums) {
        //前缀和
        int[] arr = new int[nums.length];
        //第一个
        arr[0] = nums[0] == 1 ? 1 : -1;
        //循环
        for (int i = 1; i < arr.length; i++) {
            //第一个
            arr[i] = arr[i - 1] + (nums[i] == 1 ? 1 : -1);
        }
        //最大
        int max = 0;
        //缓存，记录每种和第一次出现的索引
        Map<Integer, Integer> map = new HashMap<>();
        //循环
        for (int i = 0; i < arr.length; i++) {
            //如果存在
            if (map.containsKey(arr[i])) {
                //计算并刷新
                max = Math.max(max, i - map.get(arr[i]));
            }
            //如果正好
            if (arr[i] == 0) {
                //肯定最大，刷新
                max = i + 1;
            }
            //如果不存在
            if (map.containsKey(arr[i]) == false) {
                //记录
                map.put(arr[i], i);
            }
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code21().findMaxLength(new int[]{0, 1}));
    }

}
