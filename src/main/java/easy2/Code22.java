package easy2;

import java.util.Arrays;

/**
 * Created By Rock-Ayl on 2020-10-11
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * <p>
 * 限制：
 * <p>
 * 1 <= 数组长度 <= 50000
 */
public class Code22 {

    public static int majorityElement(int[] nums) {
        //排序
        Arrays.sort(nums);
        //返回中间数
        return nums[(nums.length / 2)];
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
