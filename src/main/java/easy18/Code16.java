package easy18;

import java.util.*;

/**
 * @Author ayl
 * @Date 2022-05-06
 * 2215. 找出两数组的不同
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，请你返回一个长度为 2 的列表 answer ，其中：
 * <p>
 * answer[0] 是 nums1 中所有 不 存在于 nums2 中的 不同 整数组成的列表。
 * answer[1] 是 nums2 中所有 不 存在于 nums1 中的 不同 整数组成的列表。
 * 注意：列表中的整数可以按 任意 顺序返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3], nums2 = [2,4,6]
 * 输出：[[1,3],[4,6]]
 * 解释：
 * 对于 nums1 ，nums1[1] = 2 出现在 nums2 中下标 0 处，然而 nums1[0] = 1 和 nums1[2] = 3 没有出现在 nums2 中。因此，answer[0] = [1,3]。
 * 对于 nums2 ，nums2[0] = 2 出现在 nums1 中下标 1 处，然而 nums2[1] = 4 和 nums2[2] = 6 没有出现在 nums2 中。因此，answer[1] = [4,6]。
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2,3,3], nums2 = [1,1,2,2]
 * 输出：[[3],[]]
 * 解释：
 * 对于 nums1 ，nums1[2] 和 nums1[3] 没有出现在 nums2 中。由于 nums1[2] == nums1[3] ，二者的值只需要在 answer[0] 中出现一次，故 answer[0] = [3]。
 * nums2 中的每个整数都在 nums1 中出现，因此，answer[1] = [] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * -1000 <= nums1[i], nums2[i] <= 1000
 */
public class Code16 {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        //缓存
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        //循环1
        for (int i : nums1) {
            //记录
            set1.add(i);
        }
        //循环2
        for (int i : nums2) {
            //记录
            set2.add(i);
        }
        //初始化结果
        List<List<Integer>> result = new ArrayList<>(2);
        //初始化1
        LinkedHashSet<Integer> list1 = new LinkedHashSet<>();
        //循环3
        for (int i : nums1) {
            //如果不存在
            if (set2.contains(i) == false) {
                //记录
                list1.add(i);
            }
        }
        //组装
        result.add(new ArrayList<>(list1));
        //初始化2
        LinkedHashSet<Integer> list2 = new LinkedHashSet<>();
        //循环3
        for (int i : nums2) {
            //如果不存在
            if (set1.contains(i) == false) {
                //记录
                list2.add(i);
            }
        }
        //组装
        result.add(new ArrayList<>(list2));
        //返回
        return result;
    }

    public static void main(String[] args) {

    }

}
