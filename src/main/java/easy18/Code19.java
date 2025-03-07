package easy18;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2022-05-14
 * 1576. 替换所有的问号
 * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 * <p>
 * 注意：你 不能 修改非 '?' 字符。
 * <p>
 * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 * <p>
 * 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "?zs"
 * 输出："azs"
 * 解释：该示例共有 25 种解决方案，从 "azs" 到 "yzs" 都是符合题目要求的。只有 "z" 是无效的修改，因为字符串 "zzs" 中有连续重复的两个 'z' 。
 * 示例 2：
 * <p>
 * 输入：s = "ubv?w"
 * 输出："ubvaw"
 * 解释：该示例共有 24 种解决方案，只有替换成 "v" 和 "w" 不符合题目要求。因为 "ubvvw" 和 "ubvww" 都包含连续重复的字符。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * <p>
 * s 仅包含小写英文字母和 '?' 字符
 */
public class Code19 {

    public String modifyString(String s) {
        //默认
        if (s.length() == 1) {
            //返回
            return "a";
        }
        //初始化
        StringBuilder result = new StringBuilder(s);
        //边界
        int last = result.length() - 1;
        //缓存
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        //循环
        for (int i = 0; i < result.length(); i++) {
            //当前
            char letter = s.charAt(i);
            //如果是问号
            if (letter == '?') {
                //三种情况
                if (i == 0) {
                    //右
                    char right = s.charAt(i + 1);
                    //删除
                    set.remove(right);
                    //随机选一个
                    result.setCharAt(i, set.stream().findFirst().get());
                    //组装
                    set.add(right);
                } else if (i == last) {
                    //左
                    char left = result.charAt(i - 1);
                    //删除
                    set.remove(left);
                    //随机选一个
                    result.setCharAt(i, set.stream().findFirst().get());
                    //组装
                    set.add(left);
                } else {
                    //左右
                    char left = result.charAt(i - 1);
                    char right = s.charAt(i + 1);
                    //删除
                    set.remove(left);
                    set.remove(right);
                    //随机选一个
                    result.setCharAt(i, set.stream().findFirst().get());
                    //组装
                    set.add(left);
                    set.add(right);
                }
            }
        }
        //返回
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code19().modifyString("ubv?w"));
    }

}
