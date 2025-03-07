package easy;

import java.util.*;

/**
 * Created By Rock-Ayl on 2020-09-10
 * 1464. 数组中两元素的最大乘积
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 * <p>
 * 请你计算并返回该式的最大值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,5,2]
 * 输出：12
 * 解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,5,4,5]
 * 输出：16
 * 解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
 * 示例 3：
 * <p>
 * 输入：nums = [3,7]
 * 输出：12
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 500
 * 1 <= nums[i] <= 10^3
 */
public class Code32 {

    public static int maxProduct(int[] nums) {
        //排序
        List<Integer> list = new ArrayList<>();
        //循环
        for (int num : nums) {
            //组装
            list.add(num);
        }
        //排序
        Collections.sort(list);
        //第一个数
        int x = list.get(list.size() - 1) - 1;
        //第二个数
        int y = list.get(list.size() - 2) - 1;
        //返回
        return x * y;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{3, 4, 5, 2}));
    }
}
