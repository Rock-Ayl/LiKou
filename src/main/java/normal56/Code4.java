package normal56;

/**
 * 2457. 美丽整数的最小增量
 * 算术评级: 5
 * 第 317 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1680
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个正整数 n 和 target 。
 * <p>
 * 如果某个整数每一位上的数字相加小于或等于 target ，则认为这个整数是一个 美丽整数 。
 * <p>
 * 找出并返回满足 n + x 是 美丽整数 的最小非负整数 x 。生成的输入保证总可以使 n 变成一个美丽整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 16, target = 6
 * 输出：4
 * 解释：最初，n 是 16 ，且其每一位数字的和是 1 + 6 = 7 。在加 4 之后，n 变为 20 且每一位数字的和变成 2 + 0 = 2 。可以证明无法加上一个小于 4 的非负整数使 n 变成一个美丽整数。
 * 示例 2：
 * <p>
 * 输入：n = 467, target = 6
 * 输出：33
 * 解释：最初，n 是 467 ，且其每一位数字的和是 4 + 6 + 7 = 17 。在加 33 之后，n 变为 500 且每一位数字的和变成 5 + 0 + 0 = 5 。可以证明无法加上一个小于 33 的非负整数使 n 变成一个美丽整数。
 * 示例 3：
 * <p>
 * 输入：n = 1, target = 1
 * 输出：0
 * 解释：最初，n 是 1 ，且其每一位数字的和是 1 ，已经小于等于 target 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1012
 * 1 <= target <= 150
 * 生成的输入保证总可以使 n 变成一个美丽整数。
 */
public class Code4 {

    public long makeIntegerBeautiful(long n, int target) {

        /**
         * 不断的往前推
         */

        //默认往上移动一次
        long up = 10;
        //初始化数字
        long num = n;
        //如果不是,循环
        while (check(num, target) == false) {
            //数字往上移动n次
            num = num - num % up + up;
            //下一个
            up = up * 10;
        }
        //返回
        return num - n;
    }

    //判断
    private boolean check(long num, int target) {
        //和
        int sum = 0;
        //循环
        while (num > 0) {
            //叠加
            sum += num % 10;
            //下一个
            num /= 10;
        }
        //返回结果
        return sum <= target;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().makeIntegerBeautiful(467, 6));
    }

}
