package easy32;

/**
 * @Author ayl
 * @Date 2023-06-29
 * 剑指 Offer II 019. 最多删除一个字符得到回文
 * 给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "aba"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "abca"
 * 输出: true
 * 解释: 可以删除 "c" 字符 或者 "b" 字符
 * 示例 3:
 * <p>
 * 输入: s = "abc"
 * 输出: false
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 105
 * s 由小写英文字母组成
 * <p>
 * <p>
 * 注意：本题与主站 680 题相同： https://leetcode-cn.com/problems/valid-palindrome-ii/
 */
public class Code9 {

    public boolean validPalindrome(String s, int left, int right) {
        //循环
        while (left <= right) {
            //如果不是同一个
            if (s.charAt(left++) != s.charAt(right--)) {
                //不可以
                return false;
            }
        }
        //默认可以
        return true;
    }

    public boolean validPalindrome(String s) {
        //双指针
        int left = 0;
        int right = s.length() - 1;
        //循环
        while (left <= right) {
            //如果是同一个
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                //本轮过
                continue;
            }
            //删除一个,对比
            return validPalindrome(s, left + 1, right) || validPalindrome(s, left, right - 1);
        }
        //默认可以
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().validPalindrome("abc"));
    }

}
