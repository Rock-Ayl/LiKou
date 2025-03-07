package easy8;

import java.util.Stack;

/**
 * @Author 安永亮
 * @Date 2021-06-09
 * @Description 1876. 长度为三且各字符不同的子字符串
 * 如果一个字符串不含有任何重复字符，我们称这个字符串为 好 字符串。
 * <p>
 * 给你一个字符串 s ，请你返回 s 中长度为 3 的 好子字符串 的数量。
 * <p>
 * 注意，如果相同的好子字符串出现多次，每一次都应该被记入答案之中。
 * <p>
 * 子字符串 是一个字符串中连续的字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "xyzzaz"
 * 输出：1
 * 解释：总共有 4 个长度为 3 的子字符串："xyz"，"yzz"，"zza" 和 "zaz" 。
 * 唯一的长度为 3 的好子字符串是 "xyz" 。
 * 示例 2：
 * <p>
 * 输入：s = "aababcabc"
 * 输出：4
 * 解释：总共有 7 个长度为 3 的子字符串："aab"，"aba"，"bab"，"abc"，"bca"，"cab" 和 "abc" 。
 * 好子字符串包括 "abc"，"bca"，"cab" 和 "abc" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s​​​​​​ 只包含小写英文字母。
 */
public class Code13 {

    public int countGoodSubstrings(String s) {
        //好字符串数量
        int size = 0;
        //循环
        for (int i = 2; i < s.length(); i++) {
            //三个
            char a = s.charAt(i - 2);
            char b = s.charAt(i - 1);
            char c = s.charAt(i);
            //如果是好
            if (a != b && b != c && a != c) {
                //记录
                size++;
            }
        }
        //返回
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().countGoodSubstrings("aababcabc"));
    }

}
