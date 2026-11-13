package normal58;

/**
 * 5. 最长回文子串
 * 算术评级: 5
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 */
public class Code22 {

    public String longestPalindrome(String s) {
        //最大结果
        int maxStart = 0;
        int maxEnd = 0;
        int maxLength = 1;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //第一种情况
            int left = i;
            int right = i;
            //如果下一个是回文
            while (left - 1 >= 0 && right + 1 < s.length() && s.charAt(left - 1) == s.charAt(right + 1)) {
                //下一个
                left--;
                right++;
            }
            //长度
            int length = right - left + 1;
            //如果更大
            if (length > maxLength) {
                //刷新
                maxStart = left;
                maxEnd = right;
                maxLength = length;
            }
            //第二种情况
            left = i;
            right = i + 1;
            //如果第二种情况有可能
            if (right < s.length() && s.charAt(left) == s.charAt(right)) {
                //如果下一个是回文
                while (left - 1 >= 0 && right + 1 < s.length() && s.charAt(left - 1) == s.charAt(right + 1)) {
                    //下一个
                    left--;
                    right++;
                }
                //长度
                length = right - left + 1;
                //如果更大
                if (length > maxLength) {
                    //刷新
                    maxStart = left;
                    maxEnd = right;
                    maxLength = length;
                }
            }
        }
        //返回结果
        return s.substring(maxStart, maxEnd + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Code22().longestPalindrome("babad"));
    }

}
