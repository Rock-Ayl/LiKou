package easy25;

/**
 * @Author ayl
 * @Date 2022-12-08
 * 125. 验证回文串
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * <p>
 * 字母和数字都属于字母数字字符。
 * <p>
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * 示例 2：
 * <p>
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * 示例 3：
 * <p>
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 2 * 105
 * s 仅由可打印的 ASCII 字符组成
 */
public class Code13 {

    public boolean isPalindrome(String s) {
        //双指针
        int p = 0;
        int q = s.length() - 1;
        //循环
        while (p <= q) {
            //获取左边字母,并小写
            char left = letter(s.charAt(p));
            //如果不是字母
            if (left == ' ') {
                //移动
                p++;
                //本轮过
                continue;
            }
            //获取右边字母,并小写
            char right = letter(s.charAt(q));
            //如果不是字母
            if (right == ' ') {
                //移动
                q--;
                //本轮过
                continue;
            }
            //如果相同
            if (left == right) {
                //移动
                p++;
                q--;
                //本轮过
                continue;
            }
            //不是,直接返回
            return false;
        }
        //返回结果
        return true;
    }

    //判断是否为字母,如果是,转化为小写并返回
    private char letter(char space) {
        //如果是小写
        if (space >= 97 && space <= 122) {
            //返回本身
            return space;
        }
        //如果是大写
        if (space <= 90 && space >= 65) {
            //转化为小写并返回
            return (char) (space + 32);
        }
        //如果是数字
        if (space > 47 && space < 58) {
            //返回本身
            return space;
        }
        //默认
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(new Code13().isPalindrome("A man, a plan, a canal: Panama"));
    }

}
