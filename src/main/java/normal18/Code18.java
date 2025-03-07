package normal18;

/**
 * @Author ayl
 * @Date 2023-01-27
 * 413. 等差数列划分
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * <p>
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * <p>
 * 子数组 是数组中的一个连续序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 */
public class Code18 {

    public int numberOfArithmeticSlices(int[] nums) {
        //结果
        int count = 0;
        //如果不够
        if (nums.length < 3) {
            //直接过
            return count;
        }
        //循环1
        for (int i = 0; i <= nums.length - 3; i++) {
            //差
            int min = nums[i + 1] - nums[i];
            //如果不是等差数列
            if (min != nums[i + 2] - nums[i + 1]) {
                //本轮过
                continue;
            }
            //本次等差数列数量,默认1
            int thisCount = 1;
            //循环2
            for (int j = i + 3; j < nums.length; j++) {
                //如果没有继续连击
                if (nums[j] - nums[j - 1] != min) {
                    //本次结束
                    break;
                }
                //记录
                thisCount++;
            }
            //记录结果
            count += thisCount;
        }
        //返回结果
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code18().numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    }

}
