package normal44;

/**
 * @Author ayl
 * @Date 2025-06-27
 * 2575. 找出字符串的可整除数组
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的字符串 word ，长度为 n ，由从 0 到 9 的数字组成。另给你一个正整数 m 。
 * <p>
 * word 的 可整除数组 div  是一个长度为 n 的整数数组，并满足：
 * <p>
 * 如果 word[0,...,i] 所表示的 数值 能被 m 整除，div[i] = 1
 * 否则，div[i] = 0
 * 返回 word 的可整除数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "998244353", m = 3
 * 输出：[1,1,0,0,0,1,1,0,0]
 * 解释：仅有 4 个前缀可以被 3 整除："9"、"99"、"998244" 和 "9982443" 。
 * 示例 2：
 * <p>
 * 输入：word = "1010", m = 10
 * 输出：[0,1,0,1]
 * 解释：仅有 2 个前缀可以被 10 整除："10" 和 "1010" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * word.length == n
 * word 由数字 0 到 9 组成
 * 1 <= m <= 109
 */
public class Code10 {

    public int[] divisibilityArray(String word, int m) {
        //缓存
        int[] result = new int[word.length()];
        //第一个数字
        long num = (word.charAt(0) - '0') % m;
        //初始化第一个
        result[0] = num == 0L ? 1 : 0;
        //循环
        for (int i = 1; i < word.length(); i++) {
            //计算数字并取余
            num = (num * 10L + (word.charAt(i) - '0')) % m;
            //当前
            result[i] = num == 0L ? 1 : 0;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new Code10().divisibilityArray("998244353", 3);
        System.out.println();
    }

}
