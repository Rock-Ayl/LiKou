package easy3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2020-10-27
 * 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * 通过次数179,491提交次数337,608
 */
public class Code7 {

    public static boolean containsDuplicate(int[] nums) {
        //用set
        Set<Integer> set = new HashSet<>();
        //循环
        for (int num : nums) {
            //如果存在
            if (set.contains(num)) {
                //相同
                return true;
            }
            //记录
            set.add(num);
        }
        //缺省
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
    }
}
