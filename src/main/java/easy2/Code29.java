package easy2;

import java.util.*;

/**
 * Created By Rock-Ayl on 2020-10-18
 * 448. 找到所有数组中消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 */
public class Code29 {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        //缓存...
        HashMap<Integer, Boolean> map = new HashMap<>();
        //次数
        int size = nums.length;
        //循环
        while (size > 0) {
            //初始化未出现
            map.put(size, false);
            //递减
            size--;
        }
        //循环
        for (int num : nums) {
            //记录已出现
            map.put(num, true);
        }
        //初始化返回值
        List<Integer> list = new ArrayList<>();
        //循环
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            //如果还未出现
            if (entry.getValue() == false) {
                //记录它
                list.add(entry.getKey());
            }
        }
        //返回
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
