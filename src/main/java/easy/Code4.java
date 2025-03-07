package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2020-08-07
 * 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class Code4 {

    public static int findRepeatNumber(int[] nums) {
        //记录
        Set<Integer> set = new HashSet<>();
        //循环
        for (int num : nums) {
            //如果存在
            if (set.contains(num)) {
                return num;
            }
            //记录
            set.add(num);
        }
        //缺省
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{1, 2, 3, 4, 5}));
    }
}
