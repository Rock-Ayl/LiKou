package easy41;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2025-11-08
 * 3731. 找出缺失的元素
 * 算术评级: 2
 * 第 474 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1217
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums ，数组由若干 互不相同 的整数组成。
 * <p>
 * 数组 nums 原本包含了某个范围内的 所有整数 。但现在，其中可能 缺失 部分整数。
 * <p>
 * 该范围内的 最小 整数和 最大 整数仍然存在于 nums 中。
 * <p>
 * 返回一个 有序 列表，包含该范围内缺失的所有整数，并 按从小到大排序。如果没有缺失的整数，返回一个 空 列表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,4,2,5]
 * <p>
 * 输出： [3]
 * <p>
 * 解释：
 * <p>
 * 最小整数为 1，最大整数为 5，因此完整的范围应为 [1,2,3,4,5]。其中只有 3 缺失。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [7,8,6,9]
 * <p>
 * 输出： []
 * <p>
 * 解释：
 * <p>
 * 最小整数为 6，最大整数为 9，因此完整的范围为 [6,7,8,9]。所有整数均已存在，因此没有缺失的整数。
 * <p>
 * 示例 3：
 * <p>
 * 输入： nums = [5,1]
 * <p>
 * 输出： [2,3,4]
 * <p>
 * 解释：
 * <p>
 * 最小整数为 1，最大整数为 5，因此完整的范围应为 [1,2,3,4,5]。缺失的整数为 2、3 和 4。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Code22 {

    public List<Integer> findMissingElements(int[] nums) {
        //已存在集合
        Set<Integer> set = new HashSet<>();
        //区间
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        //循环
        for (int num : nums) {
            //记录
            set.add(num);
            //最小
            start = Math.min(start, num);
            //最大
            end = Math.max(end, num);
        }
        //结果
        List<Integer> result = new ArrayList<>(end - start + 1 - set.size());
        //循环
        for (int i = start; i < end; i++) {
            //如果不存在
            if (set.contains(i) == false) {
                //组装
                result.add(i);
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code22().findMissingElements(new int[]{5, 1}));
    }
}
