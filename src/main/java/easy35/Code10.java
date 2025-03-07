package easy35;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2023-12-23
 * 2956. 找到两个数组中的公共元素
 * 提示
 * 简单
 * 4
 * 相关企业
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，它们分别含有 n 和 m 个元素。
 * <p>
 * 请你计算以下两个数值：
 * <p>
 * 统计 0 <= i < n 中的下标 i ，满足 nums1[i] 在 nums2 中 至少 出现了一次。
 * 统计 0 <= i < m 中的下标 i ，满足 nums2[i] 在 nums1 中 至少 出现了一次。
 * 请你返回一个长度为 2 的整数数组 answer ，按顺序 分别为以上两个数值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [4,3,2,3,1], nums2 = [2,2,5,2,3,6]
 * 输出：[3,4]
 * 解释：分别计算两个数值：
 * - nums1 中下标为 1 ，2 和 3 的元素在 nums2 中至少出现了一次，所以第一个值为 3 。
 * - nums2 中下标为 0 ，1 ，3 和 4 的元素在 nums1 中至少出现了一次，所以第二个值为 4 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [3,4,2,3], nums2 = [1,5]
 * 输出：[0,0]
 * 解释：两个数组中没有公共元素，所以两个值都为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums1.length
 * m == nums2.length
 * 1 <= n, m <= 100
 * 1 <= nums1[i], nums2[i] <= 100
 */
public class Code10 {

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        //转化为列表(由于结构要重复的情况,所以用列表)
        List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        //交集
        list2.retainAll(new HashSet<>(list1));
        list1.retainAll(new HashSet<>(list2));
        //返回
        return new int[]{list1.size(), list2.size()};
    }

    public static void main(String[] args) {

    }

}
