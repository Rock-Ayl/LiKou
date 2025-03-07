package easy24;

/**
 * @Author ayl
 * @Date 2022-11-08
 * 给你一个由正整数组成的整数数组 nums ，返回其中可被 3 整除的所有偶数的平均值。
 * <p>
 * 注意：n 个元素的平均值等于 n 个元素 求和 再除以 n ，结果 向下取整 到最接近的整数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,6,10,12,15]
 * 输出：9
 * 解释：6 和 12 是可以被 3 整除的偶数。(6 + 12) / 2 = 9 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,4,7,10]
 * 输出：0
 * 解释：不存在满足题目要求的整数，所以返回 0 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/average-value-of-even-numbers-that-are-divisible-by-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code15 {

    public int averageValue(int[] nums) {
        //和
        int sum = 0;
        //次数
        int count = 0;
        //循环
        for (int num : nums) {
            //如果是目标
            if (num % 2 == 0 && num % 3 == 0) {
                //记录
                count++;
                sum += num;
            }
        }
        //如果没有
        if (sum == 0) {
            //返回
            return 0;
        }
        //返回
        return sum / count;
    }

    public static void main(String[] args) {
        System.out.println(new Code15().averageValue(new int[]{1, 3, 6, 10, 12, 15}));
    }
}
