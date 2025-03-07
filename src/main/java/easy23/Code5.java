package easy23;

/**
 * @Author ayl
 * @Date 2022-09-19
 * 6180. 最小偶倍数
 * 给你一个正整数 n ，返回 2 和 n 的最小公倍数（正整数）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5
 * 输出：10
 * 解释：5 和 2 的最小公倍数是 10 。
 * 示例 2：
 * <p>
 * 输入：n = 6
 * 输出：6
 * 解释：6 和 2 的最小公倍数是 6 。注意数字会是它自身的倍数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 150
 */
public class Code5 {

    public int smallestEvenMultiple(int n) {
        //如果是偶数
        if (n % 2 == 0) {
            //返回其
            return n;
        } else {
            //最小公倍
            return n * 2;
        }
    }

}
