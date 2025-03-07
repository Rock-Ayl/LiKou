package easy;

import java.util.*;

/**
 * Created By Rock-Ayl on 2020-08-10
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class Code8 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        //记录
        Map<Integer, List<Integer>> map = new HashMap<>();
        //循环
        for (int v = 0; v < nums.length; v++) {
            //如果存在该内容
            if (map.containsKey(nums[v])) {
                //获取已存在的
                List<Integer> numberList = map.get(nums[v]);
                //循环
                for (Integer number : numberList) {
                    //获取差
                    int x = number.intValue() - v;
                    //绝对值
                    if (x < 0) {
                        x = x * -1;
                    }
                    //如果至多为K
                    if (x <= k) {
                        //返回
                        return true;
                    }
                }
                //记录该坐标
                numberList.add(v);
                //记录map
                map.put(nums[v], numberList);
            } else {
                //初始化List
                List<Integer> list = new ArrayList<>();
                //记录该参数
                list.add(v);
                //不存在就加入
                map.put(nums[v], list);
            }
        }
        //缺省
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }
}
