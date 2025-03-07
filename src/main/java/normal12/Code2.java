package normal12;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2022-02-20
 * 1509. 三次操作后最大值与最小值的最小差
 * 给你一个数组 nums ，每次操作你可以选择 nums 中的任意一个元素并将它改成任意值。
 * <p>
 * 请你返回三次操作后， nums 中最大值与最小值的差的最小值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,3,2,4]
 * 输出：0
 * 解释：将数组 [5,3,2,4] 变成 [2,2,2,2].
 * 最大值与最小值的差为 2-2 = 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,5,0,10,14]
 * 输出：1
 * 解释：将数组 [1,5,0,10,14] 变成 [1,1,0,1,1] 。
 * 最大值与最小值的差为 1-0 = 1 。
 * 示例 3：
 * <p>
 * 输入：nums = [6,6,0,1,1,4,6]
 * 输出：2
 * 示例 4：
 * <p>
 * 输入：nums = [1,5,6,14,15]
 * 输出：1
 */
public class Code2 {

    public int minDifference(int[] nums) {
        //如果太小
        if (nums.length < 4) {
            //默认
            return 0;
        }
        //先排序
        Arrays.sort(nums);
        //最小结果
        int min = Integer.MAX_VALUE;
        //左右
        int left = 0, right = nums.length - 4;
        //循环
        while (right < nums.length) {
            //当前
            int thisNum = nums[right++] - nums[left++];
            //如果更小
            if (thisNum < min) {
                //刷新
                min = thisNum;
            }
        }
        //返回
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().minDifference(new int[]{1, 5, 0, 10, 14}));
    }

}
