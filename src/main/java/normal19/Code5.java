package normal19;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2023-03-03
 * 454. 四数相加 II
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * <p>
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出：2
 * 解释：
 * 两个元组如下：
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 * 示例 2：
 * <p>
 * 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums1.length
 * n == nums2.length
 * n == nums3.length
 * n == nums4.length
 * 1 <= n <= 200
 * -228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
 */
public class Code5 {

    //找到两组内容结果为0的数量
    public int countZero(Map<Integer, Long> map1, Map<Integer, Long> map2) {
        //结果
        int count = 0;
        //循环
        for (Map.Entry<Integer, Long> entry1 : map1.entrySet()) {
            //目标数字
            int target = 0 - entry1.getKey();
            //如果没有
            if (map2.containsKey(target) == false) {
                //本轮过
                continue;
            }
            //叠加本次匹配结果
            count += entry1.getValue() * map2.get(target);
        }
        //返回结果
        return count;
    }

    //计算两组内容结果集
    public Map<Integer, Long> count(Map<Integer, Long> map1, Map<Integer, Long> map2) {
        //本次结果
        Map<Integer, Long> result = new HashMap<>();
        //循环
        for (Map.Entry<Integer, Long> entry1 : map1.entrySet()) {
            //本次
            int num1 = entry1.getKey();
            long count1 = entry1.getValue();
            //循环2
            for (Map.Entry<Integer, Long> entry2 : map2.entrySet()) {
                //和
                int key = num1 + entry2.getKey();
                //记录
                result.put(key, result.getOrDefault(key, 0L) + (count1 * entry2.getValue()));
            }
        }
        //返回
        return result;
    }

    //分组
    public Map<Integer, Long> group(int[] nums) {
        //返回
        return Arrays.stream(nums)
                //装箱
                .boxed()
                //分组统计数量
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()));
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        //计算结果
        return countZero(count(group(nums1), group(nums2)), count(group(nums3), group(nums4)));
    }

    public static void main(String[] args) {
        System.out.println(new Code5().fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }

}
