package easy20;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2022-06-09
 * 2248. 多个数组求交集
 * 给你一个二维整数数组 nums ，其中 nums[i] 是由 不同 正整数组成的一个非空数组，按 升序排列 返回一个数组，数组中的每个元素在 nums 所有数组 中都出现过。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
 * 输出：[3,4]
 * 解释：
 * nums[0] = [3,1,2,4,5]，nums[1] = [1,2,3,4]，nums[2] = [3,4,5,6]，在 nums 中每个数组中都出现的数字是 3 和 4 ，所以返回 [3,4] 。
 * 示例 2：
 * <p>
 * 输入：nums = [[1,2,3],[4,5,6]]
 * 输出：[]
 * 解释：
 * 不存在同时出现在 nums[0] 和 nums[1] 的整数，所以返回一个空列表 [] 。
 */
public class Code4 {

    public List<Integer> intersection(int[][] nums) {
        //缓存
        Set<Integer> allSet = new HashSet<>();
        //循环
        for (int i : nums[0]) {
            //组装
            allSet.add(i);
        }
        //循环
        for (int i = 1; i < nums.length; i++) {
            //当前
            int[] arr = nums[i];
            //缓存
            Set<Integer> set = new HashSet<>();
            //循环
            for (int i1 : arr) {
                //组装
                set.add(i1);
            }
            //交集
            allSet.retainAll(set);
        }
        //返回
        return new ArrayList<>(allSet).stream().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        new Code4().intersection(new int[][]{
                new int[]{3, 1, 2, 4, 5},
                new int[]{1, 2, 3, 4},
                new int[]{3, 4, 5, 6}
        });
    }

}
