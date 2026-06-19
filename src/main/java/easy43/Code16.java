package easy43;

/**
 * 3959. 判定好整数
 * 算术评级: 2
 * 第 506 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1183
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个正整数 n。
 * <p>
 * 令 digitSum 表示 n 的各位数字之和，令 squareSum 表示 n 的各位数字平方之和。
 * <p>
 * 如果一个整数满足 squareSum - digitSum >= 50，则称它是 好整数 。
 * <p>
 * 如果 n 是好整数，返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 1000
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * <p>
 * 1000 的数字为 1、0、0 和 0。
 * digitSum 为 1 + 0 + 0 + 0 = 1。
 * squareSum 为 12 + 02 + 02 + 02 = 1。
 * squareSum - digitSum 为 1 - 1 = 0。由于 0 小于 50，因此输出 false。
 * 示例 2：
 * <p>
 * 输入： n = 19
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * 19 的数字为 1 和 9。
 * digitSum 为 1 + 9 = 10。
 * squareSum 为 12 + 92 = 1 + 81 = 82。
 * squareSum - digitSum 为 82 - 10 = 72。由于 72 大于等于 50，因此输出 true。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 *
 */
public class Code16 {

    public boolean checkGoodInteger(int n) {
        //结果
        int sum = 0;
        //循环
        while (n > 0) {
            //数字
            int num = n % 10;
            //叠加本次
            sum += num * num - num;
            //返回
            n /= 10;
        }
        //返回
        return sum >= 50;
    }

    public static void main(String[] args) {
        System.out.println(new Code16().checkGoodInteger(1000));
    }

}
