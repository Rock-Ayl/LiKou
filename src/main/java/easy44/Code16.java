package easy44;

/**
 * 4078. 连续三项斐波那契数之和
 * 算术评级: 2
 * 第 523 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1134
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n。
 * <p>
 * 斐波那契数列 以 0 和 1 开始，之后的每个数都是前两个数之和。它的前几项为 0, 1, 1, 2, 3, 5, 8, 13, ...。
 * <p>
 * 如果 n 可以表示为斐波那契数列中 连续三项之和，则返回 true；否则返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 16
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * 连续三项 3、5 和 8 的和为 3 + 5 + 8 = 16。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 8
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * <p>
 * 虽然 1 + 2 + 5 = 8，但这三项在斐波那契数列中并不连续。不存在连续三项的和等于 8。
 * <p>
 * 示例 3：
 * <p>
 * 输入： n = 2
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * 斐波那契数列的前三项之和为 0 + 1 + 1 = 2。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 */
public class Code16 {

    public boolean threeFibonacciSum(int n) {
        //如果不是偶数
        if (n % 2 != 0) {
            //过
            return false;
        }
        //第一个数字+第二个数字为多少
        int part = n / 2;
        //连个数字
        int one = 0;
        int two = 1;
        //循环
        while (one + two <= part) {
            //如果是
            if (one + two == part) {
                //返回
                return true;
            }
            //第三个数字
            int three = one + two;
            //下一个
            one = two;
            two = three;
        }
        //默认返回false
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code16().threeFibonacciSum(16));
    }
}
