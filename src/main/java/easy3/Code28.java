package easy3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2024-07-12
 * 2913. 子数组不同元素数目的平方和 I
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 。
 * <p>
 * 定义 nums 一个子数组的 不同计数 值如下：
 * <p>
 * 令 nums[i..j] 表示 nums 中所有下标在 i 到 j 范围内的元素构成的子数组（满足 0 <= i <= j < nums.length ），那么我们称子数组 nums[i..j] 中不同值的数目为 nums[i..j] 的不同计数。
 * 请你返回 nums 中所有子数组的 不同计数 的 平方 和。
 * <p>
 * 由于答案可能会很大，请你将它对 109 + 7 取余 后返回。
 * <p>
 * 子数组指的是一个数组里面一段连续 非空 的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,1]
 * 输出：15
 * 解释：六个子数组分别为：
 * [1]: 1 个互不相同的元素。
 * [2]: 1 个互不相同的元素。
 * [1]: 1 个互不相同的元素。
 * [1,2]: 2 个互不相同的元素。
 * [2,1]: 2 个互不相同的元素。
 * [1,2,1]: 2 个互不相同的元素。
 * 所有不同计数的平方和为 12 + 12 + 12 + 22 + 22 + 22 = 15 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,2]
 * 输出：3
 * 解释：三个子数组分别为：
 * [2]: 1 个互不相同的元素。
 * [2]: 1 个互不相同的元素。
 * [2,2]: 1 个互不相同的元素。
 * 所有不同计数的平方和为 12 + 12 + 12 = 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Code28 {

    public int sumCounts(List<Integer> nums) {
        //结果
        int result = 0;
        //本次数量缓存
        Set<Integer> set = new HashSet<>();
        //循环1
        for (int i = 0; i < nums.size(); i++) {
            //重新来
            set.clear();
            //循环2
            for (int j = i; j < nums.size(); j++) {
                //记录本次
                set.add(nums.get(j));
                //叠加本次结果
                result += set.size() * set.size();
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code28().sumCounts(Arrays.asList(1, 2, 1)));
    }
}
