package easy2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created By Rock-Ayl on 2020-10-05
 * 1394. 找出数组中的幸运数
 * 在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。
 * <p>
 * 给你一个整数数组 arr，请你从中找出并返回一个幸运数。
 * <p>
 * 如果数组中存在多个幸运数，只需返回 最大 的那个。
 * 如果数组中不含幸运数，则返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,2,3,4]
 * 输出：2
 * 解释：数组中唯一的幸运数是 2 ，因为数值 2 的出现频次也是 2 。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,2,3,3,3]
 * 输出：3
 * 解释：1、2 以及 3 都是幸运数，只需要返回其中最大的 3 。
 * 示例 3：
 * <p>
 * 输入：arr = [2,2,2,3,3]
 * 输出：-1
 * 解释：数组中不存在幸运数。
 * 示例 4：
 * <p>
 * 输入：arr = [5]
 * 输出：-1
 * 示例 5：
 * <p>
 * 输入：arr = [7,7,7,7,7,7,7]
 * 输出：7
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 500
 * 1 <= arr[i] <= 500
 */
public class Code16 {

    public static int findLucky(int[] arr) {
        //幸运数,默认为-1
        int num = -1;
        //记录缓存
        Map<Integer, Integer> map = new HashMap<>();
        //循环
        for (int i : arr) {
            //如果存在
            if (map.containsKey(i)) {
                //+1
                map.put(i, (map.get(i) + 1));
            } else {
                //初始化
                map.put(i, 1);
            }
        }
        //循环
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            //获取key
            int key = integerIntegerEntry.getKey();
            //如果是幸运数
            if (integerIntegerEntry.getValue() == key) {
                //如果是最大的幸运数
                if (key > num) {
                    //覆盖
                    num = key;
                }
            }
        }
        //返回
        return num;
    }

    public static void main(String[] args) {
        System.out.println(findLucky(new int[]{2, 2, 3, 4}));
    }

}
