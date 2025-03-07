package easy11;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2021-08-27
 * 414. 第三大的数
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * 示例 2：
 * <p>
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * 示例 3：
 * <p>
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 */
public class Code9 {

    public int thirdMax(int[] nums) {
        //数据少的时候
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        //前三
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        //用来记录多少数的
        Set<Integer> set = new HashSet<>(nums.length);
        //循环
        for (int num : nums) {
            //记录
            set.add(num);
            //判断老大
            if (num > first) {
                //刷新
                third = second;
                second = first;
                first = num;
                continue;
            }
            //判断老二
            if (num > second && num < first) {
                //刷新
                third = second;
                second = num;
                continue;
            }
            //判断老三
            if (num > third && num < second) {
                //刷新
                third = num;
                continue;
            }
        }
        //如果数据不够
        if (set.size() < 3) {
            //返回最大
            return first;
        }
        //标准结果
        return third;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().thirdMax(new int[]{1, 2, 2, 5, 3, 5}));
    }
}
