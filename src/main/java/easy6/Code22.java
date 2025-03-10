package easy6;

/**
 * Created By Rock-Ayl on 2021-02-20
 * 1413. 逐步求和得到正数的最小值
 * 给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。
 * <p>
 * 你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。
 * <p>
 * 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-3,2,-3,4,2]
 * 输出：5
 * 解释：如果你选择 startValue = 4，在第三次累加时，和小于 1 。
 * 累加求和
 * startValue = 4 | startValue = 5 | nums
 * (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
 * (1 +2 ) = 3  | (2 +2 ) = 4    |   2
 * (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
 * (0 +4 ) = 4  | (1 +4 ) = 5    |   4
 * (4 +2 ) = 6  | (5 +2 ) = 7    |   2
 * 示例 2：
 * <p>
 * 输入：nums = [1,2]
 * 输出：1
 * 解释：最小的 startValue 需要是正数。
 * 示例 3：
 * <p>
 * 输入：nums = [1,-2,-3]
 * 输出：5
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 */
public class Code22 {

    public static int minStartValue(int[] nums) {
        //最小值
        int startValue = 0;
        //和
        int sum = 0;
        //循环
        for (int num : nums) {
            //加
            sum += num;
            //如果小于1
            if (sum < 1) {
                //叠加start
                startValue += 1 - sum;
                //更新
                sum = 1;
            }
        }
        //如果结果不是正数
        if (startValue == 0) {
            //改为最小正
            startValue = 1;
        }
        //返回
        return startValue;
    }

    public static void main(String[] args) {
        System.out.println(minStartValue(new int[]{1, 2}));
    }
}
