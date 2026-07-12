package easy43;

/**
 * 3982. 最大数字范围的整数之和
 * 算术评级: 2
 * 第 509 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1200
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。
 * <p>
 * 一个整数的 数字范围 定义为其 最大 数字与 最小 数字之间的差。
 * <p>
 * 例如，5724 的数字范围为 7 - 2 = 5。
 * <p>
 * 返回 nums 中所有 数字范围 等于数组中 最大数字范围 的整数之和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [5724,111,350]
 * <p>
 * 输出： 6074
 * <p>
 * 解释：
 * <p>
 * i	nums[i]	最大数字	最小数字	数字范围
 * 0	5724	7	2	5
 * 1	111	1	1	0
 * 2	350	5	0	5
 * 最大数字范围为 5。数字范围为 5 的整数是 5724 和 350，因此答案为 5724 + 350 = 6074。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [90,900]
 * <p>
 * 输出： 990
 * <p>
 * 解释：
 * <p>
 * i	nums[i]	最大数字	最小数字	数字范围
 * 0	90	9	0	9
 * 1	900	9	0	9
 * 最大数字范围为 9。两个整数的数字范围都是 9 ，因此答案为 90 + 900 = 990。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 10 <= nums[i] <= 105
 */
public class Code20 {

    public int maxDigitRange(int[] nums) {
        //最大范围
        int maxRange = 0;
        //范围
        int[] rangeArr = new int[nums.length];
        //循环
        for (int i = 0; i < rangeArr.length; i++) {
            //计算范围
            int range = count(nums[i]);
            //记录
            rangeArr[i] = range;
            //更新最大范围
            maxRange = Math.max(maxRange, range);
        }
        //和
        int sum = 0;
        //循环
        for (int i = 0; i < rangeArr.length; i++) {
            //如果范围等于最大范围
            if (rangeArr[i] == maxRange) {
                //累加
                sum += nums[i];
            }
        }
        //返回
        return sum;
    }

    //计算范围
    private int count(int num) {
        //最大数字
        int max = 0;
        //最小数字
        int min = 9;
        //循环
        while (num != 0) {
            //获取当前数字
            int cur = num % 10;
            //更新最大数字
            max = Math.max(max, cur);
            //更新最小数字
            min = Math.min(min, cur);
            //更新num
            num /= 10;
        }
        //返回范围
        return max - min;
    }

    public static void main(String[] args) {
        System.out.println(new Code20().maxDigitRange(new int[]{5724, 111, 350}));
    }

}
