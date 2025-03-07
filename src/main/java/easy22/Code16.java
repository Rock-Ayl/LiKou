package easy22;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-09-12
 * 2404. 出现最频繁的偶数元素
 * 给你一个整数数组 nums ，返回出现最频繁的偶数元素。
 * <p>
 * 如果存在多个满足条件的元素，只需要返回 最小 的一个。如果不存在这样的元素，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2,2,4,4,1]
 * 输出：2
 * 解释：
 * 数组中的偶数元素为 0、2 和 4 ，在这些元素中，2 和 4 出现次数最多。
 * 返回最小的那个，即返回 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [4,4,4,9,2,4]
 * 输出：4
 * 解释：4 是出现最频繁的偶数元素。
 * 示例 3：
 * <p>
 * 输入：nums = [29,47,21,41,13,37,25,7]
 * 输出：-1
 * 解释：不存在偶数元素。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2000
 * 0 <= nums[i] <= 105
 */
public class Code16 {

    public int mostFrequentEven(int[] nums) {
        //缓存
        Map<Integer, Integer> map = new HashMap<>();
        //循环
        for (int num : nums) {
            //如果不是偶数
            if (num % 2 != 0) {
                //本轮过
                continue;
            }
            //记录count
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //如果没有结果
        if (map.size() < 1) {
            //默认
            return -1;
        }
        //获取最大count
        int maxCount = map.entrySet().stream()
                .map(p -> p.getValue())
                .max(Comparator.comparing(Integer::intValue))
                .get();
        //返回结果
        return map.entrySet().stream()
                //先保留最大count的
                .filter(p -> p.getValue().equals(maxCount))
                //根据key排序
                .sorted(new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return o1.getKey() - o2.getKey();
                    }
                })
                //找到第一个对象
                .findFirst().get()
                //返回其key
                .getKey();
    }

    public static void main(String[] args) {
        System.out.println(new Code16().mostFrequentEven(new int[]{29, 47, 21, 41, 13, 37, 25, 7}));
    }

}
