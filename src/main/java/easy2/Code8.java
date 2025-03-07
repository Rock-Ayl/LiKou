package easy2;

import java.util.Arrays;

/**
 * Created By Rock-Ayl on 2020-09-26
 * 561. 数组拆分 I
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,4,3,2]
 * <p>
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 * 提示:
 * <p>
 * n 是正整数,范围在 [1, 10000].
 * 数组中的元素范围在 [-10000, 10000].
 */
public class Code8 {

    public static int arrayPairSum(int[] nums) {
        //排序
        Arrays.sort(nums);
        //总数
        int num = 0;
        //循环
        for (int i = 0; i < nums.length; i = i + 2) {
            //第一个数
            int a = nums[i];
            //取最小的数叠加
            num = num + a;
        }
        //返回
        return num;
    }

    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{1, 4, 3, 2}));
    }
}
