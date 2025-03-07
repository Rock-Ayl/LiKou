package easy27;

/**
 * @Author ayl
 * @Date 2023-01-16
 * 2535. 数组元素和与数字和的绝对差
 * 给你一个正整数数组 nums 。
 * <p>
 * 元素和 是 nums 中的所有元素相加求和。
 * 数字和 是 nums 中每一个元素的每一数位（重复数位需多次求和）相加求和。
 * 返回 元素和 与 数字和 的绝对差。
 * <p>
 * 注意：两个整数 x 和 y 的绝对差定义为 |x - y| 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,15,6,3]
 * 输出：9
 * 解释：
 * nums 的元素和是 1 + 15 + 6 + 3 = 25 。
 * nums 的数字和是 1 + 1 + 5 + 6 + 3 = 16 。
 * 元素和与数字和的绝对差是 |25 - 16| = 9 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 解释：
 * nums 的元素和是 1 + 2 + 3 + 4 = 10 。
 * nums 的数字和是 1 + 2 + 3 + 4 = 10 。
 * 元素和与数字和的绝对差是 |10 - 10| = 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2000
 * 1 <= nums[i] <= 2000
 */
public class Code3 {

    public int differenceOfSum(int[] nums) {
        //两个和
        int sum = 0;
        int otherSum = 0;
        //循环
        for (int num : nums) {
            //叠加
            sum += num;
            //元素
            int other = num;
            //如果偶结果
            while (other > 0) {
                //计算
                otherSum += other % 10;
                //下一个
                other = other / 10;
            }
        }
        //返回结果
        return Math.abs(sum - otherSum);
    }

    public static void main(String[] args) {
        System.out.println(new Code3().differenceOfSum(new int[]{1, 15, 6, 3}));
    }

}
