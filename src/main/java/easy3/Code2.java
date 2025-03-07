package easy3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2020-10-22
 * 1207. 独一无二的出现次数
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * <p>
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 */
public class Code2 {

    public static boolean uniqueOccurrences(int[] arr) {
        //记录次数缓存
        Map<Integer, Integer> map = new HashMap<>();
        //循环
        for (int i : arr) {
            //如果存在
            if (map.containsKey(i)) {
                //+1
                map.put(i, (map.get(i) + 1));
            } else {
                //记录
                map.put(i, 1);
            }
        }
        //初始化计算缓存
        Set<Integer> set = new HashSet<>();
        //循环
        for (Map.Entry<Integer, Integer> thisObject : map.entrySet()) {
            //如果有相同的次数
            if (set.contains(thisObject.getValue())) {
                //返回
                return false;
            } else {
                //记录
                set.add(thisObject.getValue());
            }
        }
        //缺省
        return true;
    }

    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    }
}
