package easy;

import java.util.Arrays;

/**
 * Created By Rock-Ayl on 2020-07-28
 * 三个数的最大乘积
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 * <p>
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 */
public class Code2 {

    /**
     * 推荐
     *
     * @param nums
     * @return
     */
    public static int recommend(int[] nums) {
        //排序
        Arrays.sort(nums);
        //计算并返回
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }

    /**
     * 我的
     *
     * @param nums
     * @return
     */
    public static int maximumProduct(int[] nums) {
        //排序
        Arrays.sort(nums);
        //长度
        int size = nums.length;
        //如果第一位是正数或0
        if (nums[0] >= 0) {
            //计算最后三个之和
            int result = nums[size - 1] * nums[size - 2] * nums[size - 3];
            //返回
            return result;
        }
        //如果第一位是负数
        else {
            //负数乘
            int x = nums[0] * nums[1];
            //正数乘
            int y = nums[size - 2] * nums[size - 3];
            //判断谁大
            if (x > y) {
                //返回
                return (x * nums[size - 1]);
            } else {
                //返回
                return (y * nums[size - 1]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{4, 3, 9, 11, 31, 23}));
        System.out.println(maximumProduct(new int[]{-5, -1, 1, 3, 3, 4, -3, 9, -4}));
    }

}
