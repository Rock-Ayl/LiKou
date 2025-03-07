package easy2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created By Rock-Ayl on 2020-10-16
 * 面试题 17.10. 主要元素
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * <p>
 * 示例 2：
 * <p>
 * 输入：[3,2]
 * 输出：-1
 * <p>
 * 示例 3：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * 说明：
 * 你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？
 */
public class Code27 {

    public static int majorityElement(int[] nums) {
        //初始化缓存
        Map<Integer, Integer> map = new HashMap<>();
        //循环
        for (int num : nums) {
            //如果存在
            if (map.containsKey(num)) {
                //获取当前次数+1
                int x = map.get(num) + 1;
                //记录
                map.put(num, x);
            } else {
                //初始化1
                map.put(num, 1);
            }
        }
        //循环
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            //如果是
            if (integerIntegerEntry.getValue() > (nums.length / 2)) {
                //返回
                return integerIntegerEntry.getKey();
            }
        }
        //缺省
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
    }
}
