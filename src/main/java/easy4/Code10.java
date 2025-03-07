package easy4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2020-12-13
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class Code10 {

    public static int[] exchange(int[] nums) {
        //单
        List<Integer> one = new ArrayList<>();
        //双
        List<Integer> bath = new ArrayList<>();
        //循环
        for (int num : nums) {
            //如果是双
            if (num % 2 == 0) {
                //记录单
                bath.add(num);
            } else {
                //记录单
                one.add(num);
            }
        }
        //返回值
        List<Integer> list = new ArrayList<>();
        //循环
        for (Integer integer : one) {
            //组装
            list.add(integer);
        }
        //循环
        for (Integer integer : bath) {
            //组装
            list.add(integer);
        }
        //返回
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        for (int i : exchange(new int[]{1, 2, 3, 4})) {
            System.out.println(i);
        }
    }
}
