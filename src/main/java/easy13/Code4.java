package easy13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2021-10-17
 * 2032. 至少在两个数组中出现的值
 * 给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 不同 数组，且由 至少 在 两个 数组中出现的所有值组成。数组中的元素可以按 任意 顺序排列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
 * 输出：[3,2]
 * 解释：至少在两个数组中出现的所有值为：
 * - 3 ，在全部三个数组中都出现过。
 * - 2 ，在数组 nums1 和 nums2 中出现过。
 * 示例 2：
 * <p>
 * 输入：nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
 * 输出：[2,3,1]
 * 解释：至少在两个数组中出现的所有值为：
 * - 2 ，在数组 nums2 和 nums3 中出现过。
 * - 3 ，在数组 nums1 和 nums2 中出现过。
 * - 1 ，在数组 nums1 和 nums3 中出现过。
 * 示例 3：
 * <p>
 * 输入：nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
 * 输出：[]
 * 解释：不存在至少在两个数组中出现的值。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length, nums3.length <= 100
 * 1 <= nums1[i], nums2[j], nums3[k] <= 100
 */
public class Code4 {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>(), set3 = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
            set1.add(i);
        }
        for (int i : nums2) {
            set.add(i);
            set2.add(i);
        }
        for (int i : nums3) {
            set.add(i);
            set3.add(i);
        }
        //循环
        List<Integer> result = new ArrayList<>();
        //循环
        for (Integer integer : set) {
            //次数
            int size = 0;
            if (set1.contains(integer)) {
                size++;
            }
            if (set2.contains(integer)) {
                size++;
            }
            if (set3.contains(integer)) {
                size++;
            }
            //如果至少2个
            if (size > 1) {
                result.add(integer);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().twoOutOfThree(new int[]{3, 1}, new int[]{2, 3}, new int[]{1, 2}));
    }
}
