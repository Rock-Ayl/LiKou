package normal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2020-11-19
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 * <p>
 * 限制：
 * <p>
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 */
public class Code5 {

    public static int singleNumber(int[] nums) {
        //缓存
        Map<Integer, Integer> map = new HashMap<>();
        //循环
        for (int num : nums) {
            //如果存在
            if (map.containsKey(num)) {
                //叠加
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        //循环
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            //如果只出现一次
            if (integerIntegerEntry.getValue() == 1) {
                //返回
                return integerIntegerEntry.getKey();
            }
        }
        //缺省
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{5, 2, 2, 2, 5, 5, 4}));
    }
}
