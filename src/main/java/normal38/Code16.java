package normal38;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2024-12-17
 * 560. 和为 K 的子数组
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * <p>
 * 子数组是数组中元素的连续非空序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
public class Code16 {

    public int subarraySum(int[] nums, int k) {
        //初始化数组
        int[] arr = new int[nums.length];
        //前缀和数量缓存
        Map<Integer, Integer> map = new HashMap<>();
        //第一个
        arr[0] = nums[0];
        //初始化第一个
        map.put(arr[0], 1);
        //数量
        int count = arr[0] == k ? 1 : 0;
        //循环
        for (int i = 1; i < nums.length; i++) {
            //叠加和
            arr[i] = arr[i - 1] + nums[i];
            //叠加所有匹配的数量 = 自身就是 + 和前置互补
            count += (arr[i] == k ? 1 : 0) + map.getOrDefault(arr[i] - k, 0);
            //记录缓存
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code16().subarraySum(new int[]{1, 2, 3}, 3));
    }

}
