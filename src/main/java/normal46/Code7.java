package normal46;

/**
 * @Author ayl
 * @Date 2025-09-09
 * 1318. 或运算的最小翻转次数
 * 算术评级: 4
 * 第 171 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1383
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你三个正整数 a、b 和 c。
 * <p>
 * 你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c  成立的最小翻转次数。
 * <p>
 * 「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：a = 2, b = 6, c = 5
 * 输出：3
 * 解释：翻转后 a = 1 , b = 4 , c = 5 使得 a OR b == c
 * 示例 2：
 * <p>
 * 输入：a = 4, b = 2, c = 7
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：a = 1, b = 2, c = 3
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= a <= 10^9
 * 1 <= b <= 10^9
 * 1 <= c <= 10^9
 */
public class Code7 {

    public int minFlips(int a, int b, int c) {
        //结果
        int result = 0;
        //循环
        while (c > 0 || a > 0 || b > 0) {
            //本次
            int one = a % 2;
            int two = b % 2;
            int three = c % 2;
            //如果需要1
            if (three == 1) {
                //如果没有1
                if (one == 0 && two == 0) {
                    //翻转+1
                    result++;
                }
            } else {
                //结果+对应翻转次数
                result += one + two;
            }
            //下一个
            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().minFlips(8, 3, 5));
    }

}
