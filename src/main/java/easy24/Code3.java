package easy24;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2022-10-17
 * 6204. 与对应负数同时存在的最大正整数
 * 给你一个 不包含 任何零的整数数组 nums ，找出自身与对应的负数都在数组中存在的最大正整数 k 。
 * <p>
 * 返回正整数 k ，如果不存在这样的整数，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,2,-3,3]
 * 输出：3
 * 解释：3 是数组中唯一一个满足题目要求的 k 。
 * 示例 2：
 * <p>
 * 输入：nums = [-1,10,6,7,-7,1]
 * 输出：7
 * 解释：数组中存在 1 和 7 对应的负数，7 的值更大。
 * 示例 3：
 * <p>
 * 输入：nums = [-10,8,6,7,-2,-3]
 * 输出：-1
 * 解释：不存在满足题目要求的 k ，返回 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * nums[i] != 0
 */
public class Code3 {

    public int findMaxK(int[] nums) {
        //正数、负数
        Set<Integer> one = new HashSet<>();
        Set<Integer> two = new HashSet<>();
        //循环
        for (int num : nums) {
            //如果是正数
            if (num > 0) {
                //记录
                one.add(num);
            } else {
                //记录
                two.add(Math.abs(num));
            }
        }
        //排序并转化为列表
        List<Integer> list = one.stream()
                .sorted()
                .collect(Collectors.toList());
        //倒序循环
        for (int i = list.size() - 1; i >= 0; i--) {
            //如果找到了
            if (two.contains(list.get(i))) {
                //返回
                return list.get(i);
            }
        }
        //默认-1
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().findMaxK(new int[]{-1, 10, 6, 7, -7, 1}));
    }

}
