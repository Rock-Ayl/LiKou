package normal19;

/**
 * @Author ayl
 * @Date 2023-02-23
 * 680. 验证回文串 II
 * 给你一个字符串 s，最多 可以从中删除一个字符。
 * <p>
 * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aba"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "abca"
 * 输出：true
 * 解释：你可以删除字符 'c' 。
 * 示例 3：
 * <p>
 * 输入：s = "abc"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 由小写英文字母组成
 */
public class Code2 {

    //彻底删除
    public boolean delete(String s) {
        //边界
        int left = 0;
        int right = s.length() - 1;
        //如果有
        while (left < right) {
            //如果相同
            if (s.charAt(left) == s.charAt(right)) {
                //进位
                left++;
                right--;
                //本轮过
                continue;
            }
            //不可以
            return false;
        }
        //默认可以
        return true;
    }

    //寻找那一个
    public boolean validPalindrome(String s) {
        //边界
        int left = 0;
        int right = s.length() - 1;
        //如果有
        while (left < right) {
            //如果相同
            if (s.charAt(left) == s.charAt(right)) {
                //进位
                left++;
                right--;
                //本轮过
                continue;
            }
            //截取并继续彻底删除
            return delete(s.substring(left + 1, right + 1)) || delete(s.substring(left, right));
        }
        //默认可以
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().validPalindrome("abc"));
        ;
    }

}
