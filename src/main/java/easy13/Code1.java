package easy13;

import java.util.*;

/**
 * @Author ayl
 * @Date 2021-10-14
 * 1636. 按照频率将数组升序排序
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 * <p>
 * 请你返回排序后的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2,2,2,3]
 * 输出：[3,1,1,2,2,2]
 * 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,1,3,2]
 * 输出：[1,3,3,2,2]
 * 解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
 * 示例 3：
 * <p>
 * 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
 * 输出：[5,-1,4,4,-6,-6,1,1,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 */
public class Code1 {

    public int[] frequencySort(int[] nums) {
        //缓存
        Map<Integer, Integer> map = new HashMap<>();
        //循环
        for (int num : nums) {
            //获得并组装
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //缓存2
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        //排序set
        HashSet<Integer> set = new HashSet<>();
        //循环
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //value
            Integer value = entry.getValue();
            //列表
            List<Integer> list = map2.getOrDefault(value, new ArrayList<>());
            //组装
            list.add(entry.getKey());
            map2.put(value, list);
            //记录
            set.add(value);
        }
        //排序sor
        List<Integer> sortList = new ArrayList<>(set);
        //排序
        Collections.sort(sortList);
        //结果
        int[] arr = new int[nums.length];
        //指针
        int p = 0;
        //循环
        for (Integer sort : sortList) {
            //列表
            List<Integer> list = map2.get(sort);
            //排序
            Collections.sort(list);
            //循环
            for (int i = list.size() - 1; i > -1; i--) {
                //次数
                int size = sort;
                //循环
                while (size > 0) {
                    //当前
                    arr[p++] = list.get(i);
                    //减少
                    size--;
                }
            }
        }
        //返回
        return arr;
    }

    public static void main(String[] args) {
        for (int i : new Code1().frequencySort(new int[]{-53, -53, 52, 52, 52, 52, -53, -53, 52, -53, 52, 52, 52, -53, 52, 52, -53, 52, -53, 52, -53, 52, 52, 52, 52, 52, 52, 52, 52, 52, -53, 52, -53, 52, -53, 52, 52, 52, -53, -53, 52, -53, 52, 52, 52, 52, -53, -53, -53, -53, -53, 52, 52, -53, 52, -53, 52, 52, 52})) {
            System.out.println(i);
        }
    }
}
