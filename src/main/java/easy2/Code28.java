package easy2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created By Rock-Ayl on 2020-10-17
 * 1287. 有序数组中出现次数超过25%的元素
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 * <p>
 * 请你找到并返回这个整数
 * <p>
 * 示例：
 * <p>
 * 输入：arr = [1,2,2,6,6,6,6,7,10]
 * 输出：6
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^5
 */
public class Code28 {

    public static int findSpecialInteger(int[] arr) {
        //要超过的个数
        int num = arr.length / 4;
        //缓存
        HashMap<Integer, Integer> map = new HashMap<>();
        //循环
        for (int i : arr) {
            //当前个数
            int a;
            //如果存在
            if (map.containsKey(i)) {
                //个数+1
                a = map.get(i) + 1;
            } else {
                //初始为1
                a = 1;
            }
            //记录
            map.put(i, a);
        }
        //循环
        for (Map.Entry<Integer, Integer> thisObject : map.entrySet()) {
            //超过个数
            if (thisObject.getValue() > num) {
                //返回
                return thisObject.getKey();
            }
        }
        //缺省
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findSpecialInteger(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10}));
    }

}