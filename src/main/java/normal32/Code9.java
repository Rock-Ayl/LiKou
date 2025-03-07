package normal32;

/**
 * @Author ayl
 * @Date 2024-05-31
 * 2414. 最长的字母序连续子字符串的长度
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 字母序连续字符串 是由字母表中连续字母组成的字符串。换句话说，字符串 "abcdefghijklmnopqrstuvwxyz" 的任意子字符串都是 字母序连续字符串 。
 * <p>
 * 例如，"abc" 是一个字母序连续字符串，而 "acb" 和 "za" 不是。
 * 给你一个仅由小写英文字母组成的字符串 s ，返回其 最长 的 字母序连续子字符串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abacaba"
 * 输出：2
 * 解释：共有 4 个不同的字母序连续子字符串 "a"、"b"、"c" 和 "ab" 。
 * "ab" 是最长的字母序连续子字符串。
 * 示例 2：
 * <p>
 * 输入：s = "abcde"
 * 输出：5
 * 解释："abcde" 是最长的字母序连续子字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 由小写英文字母组成
 */
public class Code9 {

    public int longestContinuousSubstring(String s) {
        //最大长度
        int maxLength = 0;
        //指针
        int p = 0;
        //循环
        while (p < s.length()) {
            //默认长度为1
            int length = 1;
            //当前字符
            char letter = s.charAt(p);
            //如果下一个是连续的
            while (p + 1 < s.length() && s.charAt(p + 1) - letter == 1) {
                //进位
                letter = s.charAt(++p);
                //+1
                ++length;
            }
            //刷新最大情况
            maxLength = Math.max(maxLength, length);
            //下一个
            ++p;
        }
        //返回
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().longestContinuousSubstring("abacaba"));
    }

}
