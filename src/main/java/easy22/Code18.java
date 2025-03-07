package easy22;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2022-09-14
 * 2299. 强密码检验器 II
 * 如果一个密码满足以下所有条件，我们称它是一个 强 密码：
 * <p>
 * 它有至少 8 个字符。
 * 至少包含 一个小写英文 字母。
 * 至少包含 一个大写英文 字母。
 * 至少包含 一个数字 。
 * 至少包含 一个特殊字符 。特殊字符为："!@#$%^&*()-+" 中的一个。
 * 它 不 包含 2 个连续相同的字符（比方说 "aab" 不符合该条件，但是 "aba" 符合该条件）。
 * 给你一个字符串 password ，如果它是一个 强 密码，返回 true，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：password = "IloveLe3tcode!"
 * 输出：true
 * 解释：密码满足所有的要求，所以我们返回 true 。
 * 示例 2：
 * <p>
 * 输入：password = "Me+You--IsMyDream"
 * 输出：false
 * 解释：密码不包含数字，且包含 2 个连续相同的字符。所以我们返回 false 。
 * 示例 3：
 * <p>
 * 输入：password = "1aB!"
 * 输出：false
 * 解释：密码不符合长度要求。所以我们返回 false 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= password.length <= 100
 * password 包含字母，数字和 "!@#$%^&*()-+" 这些特殊字符。
 */
public class Code18 {

    //小写、大写、数字、特殊符号
    private int small = 0, big = 0, num = 0, sym = 0;

    //允许的特殊符号
    private Set<Character> symSet = new HashSet<>(Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'));

    public boolean strongPasswordCheckerII(String password) {
        //如果太小
        if (password.length() < 8) {
            //不是
            return false;
        }
        //检查第一个
        check(password.charAt(0));
        //循环
        for (int i = 1; i < password.length(); i++) {
            //如果当前和前一个相同
            if (password.charAt(i) == password.charAt(i - 1)) {
                //直接过
                return false;
            }
            //检查当前
            check(password.charAt(i));
        }
        //返回结果
        return small > 0 && big > 0 && num > 0 && sym > 0;
    }

    //记录数量
    private void check(char letter) {
        //如果是特殊符号
        if (symSet.contains(letter)) {
            //记录
            sym++;
            //过
            return;
        }
        //如果是小写
        if (letter <= 122 && letter >= 97) {
            //记录
            small++;
            //过
            return;
        }
        //如果是大写
        if (letter <= 90 && letter >= 65) {
            //记录
            big++;
            //过
            return;
        }
        //如果是数字
        if (letter <= 57 && letter >= 48) {
            //记录
            num++;
            //过
            return;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code18().strongPasswordCheckerII("IloveLe3tcode!"));
    }
}
