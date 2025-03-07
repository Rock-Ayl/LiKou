package normal39;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-01-07
 * LCR 010. 和为 K 的子数组
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2
 * 解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
 * 示例 2：
 * <p>
 * 输入:nums = [1,2,3], k = 3
 * 输出: 2
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 560 题相同： https://leetcode-cn.com/problems/subarray-sum-equals-k/
 */
public class Code2 {

    public int subarraySum(int[] nums, int k) {
        //前缀和
        int[] sumArr = new int[nums.length];
        //初始化
        sumArr[0] = nums[0];
        //循环
        for (int i = 1; i < nums.length; i++) {
            //前缀和
            sumArr[i] = sumArr[i - 1] + nums[i];
        }
        //结果
        int count = 0;
        //缓存
        Map<Integer, Integer> map = new HashMap<>();
        //开始地址情况
        map.put(0, 1);
        //循环
        for (int i = 0; i < sumArr.length; i++) {
            //叠加本次结果
            count += map.getOrDefault(sumArr[i] - k, 0);
            //存入缓存
            map.put(sumArr[i], map.getOrDefault(sumArr[i], 0) + 1);
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().subarraySum(new int[]{1, 2, 3}, 3));
    }

}
