package easy24;

/**
 * @Author ayl
 * @Date 2022-11-15
 * 459. 重复的子字符串
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * 示例 2:
 * <p>
 * 输入: s = "aba"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 */
public class Code17 {

    //判断是否满足
    public boolean check(String s, String word) {
        //如果不是等比长度
        if (s.length() % word.length() != 0) {
            //肯定不行
            return false;
        }
        //截取
        int start = 0;
        int end = word.length();
        //如果不是重点
        while (end <= s.length()) {
            //截取
            String space = s.substring(start, end);
            //如果不同
            if (space.equals(word) == false) {
                //不可以
                return false;
            }
            //下一步
            start += word.length();
            end += word.length();
        }
        //默认可以
        return true;
    }

    public boolean repeatedSubstringPattern(String s) {
        //指针
        int p = 1;
        //循环
        while (p <= s.length() / 2) {
            //如果是
            if (check(s, s.substring(0, p++))) {
                //返回结果
                return true;
            }
        }
        //默认不可以
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().repeatedSubstringPattern("abab"));
    }

}
