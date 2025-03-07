package easy4;

import java.util.HashSet;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2020-12-16
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Code {

    public static int[] intersection(int[] nums1, int[] nums2) {
        //缓存
        Set<Integer> a = new HashSet<>();
        //返回结果
        Set<Integer> result = new HashSet<>();
        //循环
        for (int i : nums1) {
            //记录缓存
            a.add(i);
        }
        //循环
        for (int i : nums2) {
            //如果存在
            if (a.contains(i)) {
                //记录结果
                result.add(i);
            }
        }
        //转化并返回
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        for (int i : intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})) {
            System.out.println(i);
        }
    }
}
