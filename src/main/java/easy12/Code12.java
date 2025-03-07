package easy12;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-10-11
 * 1417. 重新格式化字符串
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * <p>
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * <p>
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "a0b1c2"
 * 输出："0a1b2c"
 * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 * 示例 2：
 * <p>
 * 输入：s = "leetcode"
 * 输出：""
 * 解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
 * 示例 3：
 * <p>
 * 输入：s = "1229857369"
 * 输出：""
 * 解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
 * 示例 4：
 * <p>
 * 输入：s = "covid2019"
 * 输出："c2o0v1i9d"
 * 示例 5：
 * <p>
 * 输入：s = "ab123"
 * 输出："1a2b3"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s 仅由小写英文字母和/或数字组成。
 */
public class Code12 {

    public String reformat(String s) {
        //分组缓存
        List<Character> num = new ArrayList<>(), letter = new ArrayList<>();
        //循环
        for (char c : s.toCharArray()) {
            //如果是数字
            if (c > 122 || c < 97) {
                //记录
                num.add(c);
            } else {
                //记录
                letter.add(c);
            }
        }
        //计算差
        int minus = num.size() - letter.size();
        //结果
        StringBuilder str = new StringBuilder();
        //如果可能
        if (Math.abs(minus) < 2) {
            //如果数字比字母多
            if (minus > 0) {
                //指针
                int p = 0;
                //循环
                while (p < num.size() && p < letter.size()) {
                    //组装
                    str.append(num.get(p));
                    str.append(letter.get(p++));
                }
                //如果还多一个
                if (p < num.size()) {
                    //组装
                    str.append(num.get(p));
                }
            } else {
                //指针
                int p = 0;
                //循环
                while (p < num.size() && p < letter.size()) {
                    //组装
                    str.append(letter.get(p));
                    str.append(num.get(p++));

                }
                //如果还多一个
                if (p < letter.size()) {
                    //组装
                    str.append(letter.get(p));
                }
            }
        }
        //默认
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code12().reformat("a0b1c2"));
    }

}
