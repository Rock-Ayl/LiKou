package easy39;

/**
 * @Author ayl
 * @Date 2025-01-03
 * 3345. 最小可整除数位乘积 I
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个整数 n 和 t 。请你返回大于等于 n 的 最小 整数，且该整数的 各数位之积 能被 t 整除。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10, t = 2
 * <p>
 * 输出：10
 * <p>
 * 解释：
 * <p>
 * 10 的数位乘积为 0 ，可以被 2 整除，所以它是大于等于 10 且满足题目要求的最小整数。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 15, t = 3
 * <p>
 * 输出：16
 * <p>
 * 解释：
 * <p>
 * 16 的数位乘积为 6 ，可以被 3 整除，所以它是大于等于 15 且满足题目要求的最小整数。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * 1 <= t <= 10
 */
public class Code13 {

    //计算数字是否满足
    private boolean count(int n, int t) {
        //默认
        int num = 1;
        //循环
        while (n > 9) {
            //叠加本次
            num = num * (n % 10);
            //下一个
            n = n / 10;
        }
        //返回
        return num * n % t == 0;
    }

    public int smallestNumber(int n, int t) {
        //循环
        while (true) {
            //如果满足
            if (count(n, t)) {
                //返回结果
                return n;
            }
            //+1
            n++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code13().smallestNumber(1, 2));
    }

}
