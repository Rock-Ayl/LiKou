package easy41;

/**
 * @Author ayl
 * @Date 2025-11-23
 * 100901. 最少反转次数得到翻转二进制字符串
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 正 整数 n。
 * <p>
 * 令 s 为 n 的 二进制表示（不含前导零）。
 * <p>
 * 二进制字符串 s 的 反转 是指将 s 中的字符按相反顺序排列得到的字符串。
 * <p>
 * 你可以翻转 s 中的任意一位（将 0 → 1 或 1 → 0）。每次翻转 仅 影响一位。
 * <p>
 * 请返回使 s 等于其原始形式的反转所需的 最少 翻转次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 7
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 7 的二进制表示为 "111"。其反转也是 "111"，两者相同。因此，不需要翻转。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 10
 * <p>
 * 输出： 4
 * <p>
 * 解释：
 * <p>
 * 10 的二进制表示为 "1010"。其反转为 "0101"。必须翻转所有四位才能使它们相等。因此，所需的最少翻转次数为 4。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 */
public class Code26 {

    public int minimumFlips(int n) {
        //结果
        int result = 0;
        //转为二进制
        String nStr = Integer.toBinaryString(n);
        //循环
        for (int i = 0; i < nStr.length(); i++) {
            //当前字符
            char letter = nStr.charAt(i);
            //目标字符
            char target = nStr.charAt(nStr.length() - i - 1);
            //如果不同
            if (letter != target) {
                //+1
                result++;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code26().minimumFlips(10));
    }

}
