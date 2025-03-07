package normal2;

import java.util.*;

/**
 * Created By Rock-Ayl on 2021-04-06
 * 面试题 16.24. 数对和
 * 设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,6,5], target = 11
 * 输出: [[5,6]]
 * 示例 2:
 * <p>
 * 输入: nums = [5,6,5,6], target = 11
 * 输出: [[5,6],[5,6]]
 * 提示：
 * <p>
 * nums.length <= 100000
 */
public class Code5 {

    public static List<List<Integer>> pairSums(int[] nums, int target) {
        //结果
        List<List<Integer>> result = new ArrayList<>();
        //缓存2
        Map<Integer, Integer> map = new HashMap<>();
        //循环
        for (int num : nums) {
            //另一个
            int other = target - num;
            //如果存在结果
            if (map.containsKey(other)) {
                //次数
                int size = map.get(other) - 1;
                //如果还存在
                if (size > 0) {
                    //记录
                    map.put(other, size);
                } else {
                    map.remove(other);
                }
                //创建一个结果
                List<Integer> list = new ArrayList<>();
                //组装
                list.add(other);
                list.add(num);
                //记录
                result.add(list);
            } else {
                //如果存在这个值
                if (map.containsKey(num)) {
                    //+1
                    map.put(num, map.get(num) + 1);
                } else {
                    //记录
                    map.put(num, 1);
                }
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(pairSums(new int[]{5, 5, 6, 6}, 11));
    }
}
