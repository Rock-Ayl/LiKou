package easy2;

import java.util.HashSet;

/**
 * Created By Rock-Ayl on 2020-10-14
 * 剑指 Offer 57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * <p>
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 */
public class Code25 {

    public static int[] twoSum(int[] nums, int target) {
        //初始化set
        HashSet<Integer> set = new HashSet();
        //循环
        for (int num : nums) {
            //差是多少
            int x = target - num;
            //如果存在
            if (set.contains(x)) {
                //返回
                return new int[]{x, num};
            } else {
                //记录
                set.add(num);
            }
        }
        //缺省
        return new int[]{};
    }

    public static void main(String[] args) {
        for (int i : twoSum(new int[]{10, 26, 30, 31, 47, 60}, 40)) {
            System.out.println(i);
        }
    }

}
