package normal43;

/**
 * @Author ayl
 * @Date 2025-05-22
 * 1663. 具有给定数值的最小字符串
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 小写字符 的 数值 是它在字母表中的位置（从 1 开始），因此 a 的数值为 1 ，b 的数值为 2 ，c 的数值为 3 ，以此类推。
 * <p>
 * 字符串由若干小写字符组成，字符串的数值 为各字符的数值之和。例如，字符串 "abe" 的数值等于 1 + 2 + 5 = 8 。
 * <p>
 * 给你两个整数 n 和 k 。返回 长度 等于 n 且 数值 等于 k 的 字典序最小 的字符串。
 * <p>
 * 注意，如果字符串 x 在字典排序中位于 y 之前，就认为 x 字典序比 y 小，有以下两种情况：
 * <p>
 * x 是 y 的一个前缀；
 * 如果 i 是 x[i] != y[i] 的第一个位置，且 x[i] 在字母表中的位置比 y[i] 靠前。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, k = 27
 * 输出："aay"
 * 解释：字符串的数值为 1 + 1 + 25 = 27，它是数值满足要求且长度等于 3 字典序最小的字符串。
 * 示例 2：
 * <p>
 * 输入：n = 5, k = 73
 * 输出："aaszz"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * n <= k <= 26 * n
 */
public class Code6 {

    public String getSmallestString(int n, int k) {
        //字符
        StringBuilder str = new StringBuilder();
        //减去每个a
        k -= n;
        //如果不够
        while (k > 0) {
            //差值,一次最多26
            int other = Math.min(k, 25);
            //叠加字符
            str.append((char) ('a' + other));
            //叠加和
            k -= other;
        }
        //如果不够
        while (str.length() < n) {
            //补充完整
            str.append('a');
        }
        //翻转、并返回
        return str.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code6().getSmallestString(3, 27));
    }

}
