package easy41;

/**
 * @Author ayl
 * @Date 2025-07-23
 * 3622. 判断整除性
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个正整数 n。请判断 n 是否可以被以下两值之和 整除：
 * <p>
 * n 的 数字和（即其各个位数之和）。
 * <p>
 * n 的 数字积（即其各个位数之积）。
 * <p>
 * 如果 n 能被该和整除，返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 99
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * 因为 99 可以被其数字和 (9 + 9 = 18) 与数字积 (9 * 9 = 81) 之和 (18 + 81 = 99) 整除，因此输出为 true。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 23
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * <p>
 * 因为 23 无法被其数字和 (2 + 3 = 5) 与数字积 (2 * 3 = 6) 之和 (5 + 6 = 11) 整除，因此输出为 false。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 106
 */
public class Code1 {

    public boolean checkDivisibility(int n) {
        //和
        int sum = 0;
        int div = 1;
        //数字
        int num = n;
        //循环
        while (num > 9) {
            //最后一个数字
            int last = num % 10;
            //叠加
            sum += last;
            div = div * last;
            //下一个
            num = num / 10;
        }
        //计算最后一个数字、计算结果
        return n % (sum + num + div * num) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Code1().checkDivisibility(99));
    }

}
