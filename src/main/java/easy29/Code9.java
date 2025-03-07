package easy29;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2023-04-03
 * 2605. 从两个数字数组里生成最小数字
 * 给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，每个数组中的元素 互不相同 ，请你返回 最小 的数字，两个数组都 至少 包含这个数字的某个数位。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [4,1,3], nums2 = [5,7]
 * 输出：15
 * 解释：数字 15 的数位 1 在 nums1 中出现，数位 5 在 nums2 中出现。15 是我们能得到的最小数字。
 * 示例 2：
 * <p>
 * 输入：nums1 = [3,5,2,6], nums2 = [3,1,7]
 * 输出：3
 * 解释：数字 3 的数位 3 在两个数组中都出现了。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 9
 * 1 <= nums1[i], nums2[i] <= 9
 * 每个数组中，元素 互不相同 。
 */
public class Code9 {

    public int minNumber(int[] nums1, int[] nums2) {
        //最小唯一值
        Integer minOnly = null;
        //转化为set
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        //循环
        for (int i : nums2) {
            //如果有
            if (set.contains(i)) {
                //判空
                if (minOnly == null) {
                    //默认
                    minOnly = i;
                } else {
                    //如果更小
                    if (minOnly.compareTo(i) > 0) {
                        //记录
                        minOnly = i;
                    }
                }
            }
        }
        //获取最小数字
        int min1 = Arrays.stream(nums1).min().getAsInt();
        int min2 = Arrays.stream(nums2).min().getAsInt();
        //对比大小
        int small = Math.min(min1, min2);
        int big = Math.max(min1, min2);
        //组合数字
        int mix = small * 10 + big;
        //如果只有组合数字
        if (minOnly == null) {
            //直接
            return mix;
        } else {
            //对比
            return Math.min(minOnly, mix);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code9().minNumber(new int[]{4, 1, 3}, new int[]{5, 7}));
        ;
    }

}
