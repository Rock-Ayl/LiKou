package easy5;

import java.math.BigInteger;

/**
 * Created By Rock-Ayl on 2021-01-20
 * 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 100
 */
public class Code20 {

    public static int fib(int n) {
        //默认
        if (n == 0) {
            //默认值
            return 0;
        }
        //默认
        if (n == 1) {
            //默认值
            return 1;
        }
        //n-2
        int a = 0;
        //n-1
        int b = 1;
        //循环体,从n=22开始
        int x = 2;
        //循环
        while (x <= n) {
            //求n,取模
            int y = (a + b) % 1000000007;
            //更新
            a = b;
            b = y;
            //叠加
            x++;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(fib(45));
    }
}
