package normal35;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-09-21
 * 3002. 移除后集合的最多元素数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，它们的长度都是偶数 n 。
 * <p>
 * 你必须从 nums1 中移除 n / 2 个元素，同时从 nums2 中也移除 n / 2 个元素。移除之后，你将 nums1 和 nums2 中剩下的元素插入到集合 s 中。
 * <p>
 * 返回集合 s可能的 最多 包含多少元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,1,2], nums2 = [1,1,1,1]
 * 输出：2
 * 解释：从 nums1 和 nums2 中移除两个 1 。移除后，数组变为 nums1 = [2,2] 和 nums2 = [1,1] 。因此，s = {1,2} 。
 * 可以证明，在移除之后，集合 s 最多可以包含 2 个元素。
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2,3,4,5,6], nums2 = [2,3,2,3,2,3]
 * 输出：5
 * 解释：从 nums1 中移除 2、3 和 6 ，同时从 nums2 中移除两个 3 和一个 2 。移除后，数组变为 nums1 = [1,4,5] 和 nums2 = [2,3,2] 。因此，s = {1,2,3,4,5} 。
 * 可以证明，在移除之后，集合 s 最多可以包含 5 个元素。
 * 示例 3：
 * <p>
 * 输入：nums1 = [1,1,2,2,3,3], nums2 = [4,4,5,5,6,6]
 * 输出：6
 * 解释：从 nums1 中移除 1、2 和 3 ，同时从 nums2 中移除 4、5 和 6 。移除后，数组变为 nums1 = [1,2,3] 和 nums2 = [4,5,6] 。因此，s = {1,2,3,4,5,6} 。
 * 可以证明，在移除之后，集合 s 最多可以包含 6 个元素。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums1.length == nums2.length
 * 1 <= n <= 2 * 104
 * n是偶数。
 * 1 <= nums1[i], nums2[i] <= 109
 */
public class Code8 {

    public int maximumSetSize(int[] nums1, int[] nums2) {
        //转为集合
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        //初始化新集合
        Set<Integer> newSet1 = new HashSet<>();
        Set<Integer> newSet2 = new HashSet<>();
        //循环
        for (Integer num : set1) {
            //如果不存在
            if (set2.contains(num) == false) {
                //优先加入
                newSet1.add(num);
            }
        }
        //循环
        for (Integer num : set2) {
            //如果不存在
            if (set1.contains(num) == false) {
                //优先加入
                newSet2.add(num);
            }
        }
        //删除这些已经被使用的
        set1.removeAll(newSet1);
        set2.removeAll(newSet2);
        //一半n
        int mid = nums1.length / 2;
        //计算出现有数量
        int count1 = Math.min(newSet1.size(), mid);
        int count2 = Math.min(newSet2.size(), mid);
        //如果还有可能
        while (count1 < mid || count2 < mid) {
            //如果左边小
            if (count1 < count2) {
                //如果没了
                if (set1.isEmpty()) {
                    //跳出
                    break;
                }
                //随机获取一个
                Integer num = set1.stream().findFirst().get();
                //二者均删除
                set1.remove(num);
                set2.remove(num);
                //+1
                count1++;
            } else {
                //如果没了
                if (set2.isEmpty()) {
                    //跳出
                    break;
                }
                //随机获取一个
                Integer num = set2.stream().findFirst().get();
                //二者均删除
                set1.remove(num);
                set2.remove(num);
                //+1
                count2++;
            }
        }
        //返回结果
        return count1 + count2;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().maximumSetSize(new int[]{1, 2, 3, 4, 5, 6}, new int[]{2, 3, 2, 3, 2, 3}));
    }

}
