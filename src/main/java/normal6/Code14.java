package normal6;

import java.util.*;

/**
 * @Author ayl
 * @Date 2021-08-21
 * 229. 求众数 II
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,2,3]
 * 输出：[3]
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 */
public class Code14 {

    public List<Integer> majorityElement(int[] nums) {
        //结果
        List<Integer> list = new ArrayList<>(2);
        //需要
        int need = nums.length / 3 + 1;
        //树
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        //循环
        for (int num : nums) {
            //当前
            int size = map.getOrDefault(num, 0) + 1;
            //如果满足
            if (size == need) {
                //记录
                list.add(num);
            }
            //记录
            map.put(num, size);
        }
        //返回
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Code14().majorityElement(new int[]{3, 2, 3}));
    }

}
