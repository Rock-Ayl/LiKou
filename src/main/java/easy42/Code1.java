package easy42;

/**
 * @Author ayl
 * @Date 1/6/26
 * 3794. 反转字符串前缀
 * 同步题目状态
 * <p>
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 s 和一个整数 k。
 * <p>
 * 反转 s 的前 k 个字符，并返回结果字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcd", k = 2
 * <p>
 * 输出: "bacd"
 * <p>
 * 解释:
 * <p>
 * 前 k = 2 个字符 "ab" 反转为 "ba"。最终得到的结果字符串为 "bacd"。
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "xyz", k = 3
 * <p>
 * 输出: "zyx"
 * <p>
 * 解释:
 * <p>
 * 前 k = 3 个字符 "xyz" 反转为 "zyx"。最终得到的结果字符串为 "zyx"。
 * <p>
 * 示例 3:
 * <p>
 * 输入: s = "hey", k = 1
 * <p>
 * 输出: "hey"
 * <p>
 * 解释:
 * <p>
 * 前 k = 1 个字符 "h" 在反转后保持不变。最终得到的结果字符串为 "hey"。
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 100
 * s 仅由小写英文字母组成。
 * 1 <= k <= s.length
 */
public class Code1 {

    public String reversePrefix(String s, int k) {
        //如果无需
        if (k < 2) {
            //返回
            return s;
        }
        //返回
        return new StringBuilder(s.substring(0, k)).reverse().append(s.substring(k)).toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code1().reversePrefix("abcd", 2));
    }

}
