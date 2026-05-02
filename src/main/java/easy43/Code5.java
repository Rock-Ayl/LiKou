package easy43;

/**
 * 3908. 有效数字整数
 * 算术评级: 2
 * 第 181 场双周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1319
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n 和一个数字 x。
 * <p>
 * 如果一个数字满足以下条件，则认为它是 有效 的：
 * <p>
 * 它包含 至少一个 数字 x，并且
 * 它 不以 数字 x 开头。
 * 如果 n 是 有效 的，请返回 true，否则返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 101, x = 0
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * 该数字在下标 1 处包含数字 0。它不以 0 开头，因此满足两个条件。所以，答案是 true。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 232, x = 2
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * <p>
 * 该数字以 2 开头，违反了条件。所以，答案是 false。
 * <p>
 * 示例 3：
 * <p>
 * 输入： n = 5, x = 1
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * <p>
 * 该数字不包含数字 1。所以，答案是 false。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 105
 * 0 <= x <= 9
 */
public class Code5 {

    public boolean validDigit(int n, int x) {
        //如果太小
        if (n < 10) {
            //过
            return false;
        }
        //是否有x
        boolean had = false;
        //循环
        while (n > 9) {
            //如果当前数字是x
            if ((n % 10) == x) {
                //有
                had = true;
            }
            //下一个
            n = n / 10;
        }
        //返回结果
        return n != x && had;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().validDigit(101, 0));
    }

}
