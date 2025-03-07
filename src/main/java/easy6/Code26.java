package easy6;

/**
 * Created By Rock-Ayl on 2021-02-24
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：1
 * 提示：
 * <p>
 * 0 <= n <= 100
 */
public class Code26 {

    public static int numWays(int n) {
        //默认
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        //前两级台阶
        int a = 1, b = 2;
        //循环
        while (n > 2) {
            //交换
            int c = b;
            //更新
            b = (a + c) % 1000000007;
            a = c;
            //递减
            n--;
        }
        //返回
        return b;
    }

    public static void main(String[] args) {
        System.out.println(numWays(7));
    }
}
