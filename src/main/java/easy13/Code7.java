package easy13;

/**
 * @Author ayl
 * @Date 2021-10-20
 * 1979. 找出数组的最大公约数
 * 给你一个整数数组 nums ，返回数组中最大数和最小数的 最大公约数 。
 * <p>
 * 两个数的 最大公约数 是能够被两个数整除的最大正整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,6,9,10]
 * 输出：2
 * 解释：
 * nums 中最小的数是 2
 * nums 中最大的数是 10
 * 2 和 10 的最大公约数是 2
 * 示例 2：
 * <p>
 * 输入：nums = [7,5,6,8,3]
 * 输出：1
 * 解释：
 * nums 中最小的数是 3
 * nums 中最大的数是 8
 * 3 和 8 的最大公约数是 1
 * 示例 3：
 * <p>
 * 输入：nums = [3,3]
 * 输出：3
 * 解释：
 * nums 中最小的数是 3
 * nums 中最大的数是 3
 * 3 和 3 的最大公约数是 3
 */
public class Code7 {

    public int findGCD(int[] nums) {
        //最大最小
        int max = nums[0], min = nums[0];
        //循环
        for (int num : nums) {
            //最大
            if (num > max) {
                max = num;
            }
            //最小
            if (num < min) {
                min = num;
            }
        }
        //如果正好
        if (max % min == 0) {
            //返回
            return min;
        }
        //循环
        while (min > 0) {
            int temp = max % min;
            max = min;
            min = temp;
        }
        //默认
        return Math.max(max, 1);
    }

    public static void main(String[] args) {
        System.out.println(new Code7().findGCD(new int[]{6, 9, 10}));
    }
}
