package easy44;

/**
 * 4092. 二进制位得分
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 给你两个整数 a 和 b。
 * <p>
 * 设 s1 和 s2 分别为 a 和 b 的二进制表示中置位的数量。
 * <p>
 * 这两个整数的得分定义如下：
 * <p>
 * 如果 s1 >= s2，则得分为 s1 * s2。
 * 否则，得分为 s2 / s1，其中除法采用整数除法。
 * 返回一个整数，表示 a 和 b 的得分。
 * <p>
 * 置位是指数的二进制表示中值为 1 的位。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： a = 14, b = 6
 * <p>
 * 输出： 6
 * <p>
 * 解释：
 * <p>
 * a = 14 的二进制表示为 "1110"，因此 s1 = 3。
 * b = 6 的二进制表示为 "110"，因此 s2 = 2。
 * 由于 s1 > s2，a 和 b 的得分为 s1 * s2 = 3 * 2 = 6。
 * 示例 2：
 * <p>
 * 输入： a = 5, b = 15
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * a = 5 的二进制表示为 "101"，因此 s1 = 2。
 * b = 15 的二进制表示为 "1111"，因此 s2 = 4。
 * 由于 s1 < s2，a 和 b 的得分为 s2 / s1 = 4 / 2 = 2。
 * 示例 3：
 * <p>
 * 输入： a = 10, b = 12
 * <p>
 * 输出： 4
 * <p>
 * 解释：
 * <p>
 * a = 10 的二进制表示为 "1010"，因此 s1 = 2。
 * b = 12 的二进制表示为 "1100"，因此 s2 = 2。
 * 由于 s1 == s2，a 和 b 的得分为 s1 * s2 = 2 * 2 = 4。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= a, b <= 100
 */
public class Code18 {

    public int calculateScore(int a, int b) {
        //二进制中,1的数量
        int s1 = Integer.bitCount(a);
        int s2 = Integer.bitCount(b);
        //返回得分
        return s1 >= s2 ? s1 * s2 : s2 / s1;
    }

    public static void main(String[] args) {
        System.out.println(new Code18().calculateScore(14, 6));
    }

}
