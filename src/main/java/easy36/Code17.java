package easy36;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2024-03-24
 * 3083. 字符串及其反转中是否存在同一子字符串
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s ，请你判断字符串 s 是否存在一个长度为 2 的子字符串，在其反转后的字符串中也出现。
 * <p>
 * 如果存在这样的子字符串，返回 true；如果不存在，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leetcode"
 * <p>
 * 输出：true
 * <p>
 * 解释：子字符串 "ee" 的长度为 2，它也出现在 reverse(s) == "edocteel" 中。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "abcba"
 * <p>
 * 输出：true
 * <p>
 * 解释：所有长度为 2 的子字符串 "ab"、"bc"、"cb"、"ba" 也都出现在 reverse(s) == "abcba" 中。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "abcd"
 * <p>
 * 输出：false
 * <p>
 * 解释：字符串 s 中不存在满足「在其反转后的字符串中也出现」且长度为 2 的子字符串。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * 字符串 s 仅由小写英文字母组成。
 */
public class Code17 {

    public boolean isSubstringPresent(String s) {
        //集合
        Set<String> set = new HashSet<>();
        //循环
        for (int i = 1; i < s.length(); i++) {
            //获取前后
            char left = s.charAt(i - 1);
            char right = s.charAt(i);
            //如果相同
            if (left == right) {
                //直接返回
                return true;
            }
            //记录
            set.add("" + left + right);
        }
        //循环
        for (int i = 1; i < s.length(); i++) {
            //获取前后
            char left = s.charAt(i - 1);
            char right = s.charAt(i);
            //如果存在
            if (set.contains(right + "" + left)) {
                //是
                return true;
            }
        }
        //默认
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().isSubstringPresent("leetcode"));
    }

}
