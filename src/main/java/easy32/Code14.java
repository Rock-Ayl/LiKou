package easy32;

/**
 * @Author ayl
 * @Date 2023-07-21
 * 剑指 Offer II 018. 有效的回文
 * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 本题中，将空字符串定义为有效的 回文串 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 * <p>
 * 输入: s = "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 2 * 105
 * 字符串 s 由 ASCII 字符组成
 * <p>
 * <p>
 * 注意：本题与主站 125 题相同： https://leetcode-cn.com/problems/valid-palindrome/
 */
public class Code14 {

    public boolean isPalindrome(String s) {
        //双指针
        int left = 0;
        int right = s.length() - 1;
        //循环
        while (left < right) {
            //获取左
            char one = s.charAt(left);
            //如果可能是小写
            if (one > 96) {
                //变为大写
                one -= 32;
            }
            //如果不是数字、大写字母
            if ((one <= 90 && one >= 65) == false && (one <= 57 && one >= 48) == false) {
                //进位
                left++;
                //本轮过
                continue;
            }
            //获取右
            char two = s.charAt(right);
            //如果可能是小写
            if (two > 96) {
                //变为大写
                two -= 32;
            }
            //如果不是数字、大写字母
            if ((two <= 90 && two >= 65) == false && (two <= 57 && two >= 48) == false) {
                //进位
                right--;
                //本轮过
                continue;
            }
            //如果不是
            if (one != two) {
                //结束
                return false;
            }
            //移动
            left++;
            right--;
        }
        //默认
        return true;
    }

    public static void main(String[] args) {
        System.out.println((byte) 'a');
        System.out.println((byte) 'z');
        System.out.println((byte) 'A');
        System.out.println((byte) 'Z');
        System.out.println((byte) 0);
        System.out.println((byte) 9);
        System.out.println(new Code14().isPalindrome("A man, a plan, a canal: Panama"));
    }

}
