package easy8;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author 安永亮
 * @Date 2021-06-10
 * @Description 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 */
public class Code14 {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (Integer i : nums1) {
            stack.add(i);
        }
        for (Integer i : nums2) {
            if (stack.contains(i)) {
                stack.remove(i);
                list.add(i);
            }
        }
        int[] arr = new int[list.size()];
        int p = 0;
        while (p < list.size()) {
            arr[p] = list.get(p);
            p++;
        }
        return arr;
    }

    public static void main(String[] args) {
        for (int i : new Code14().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})) {
            System.out.println(i);
        }
    }

}
