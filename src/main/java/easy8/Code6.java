package easy8;

import java.util.HashSet;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2021-06-02
 * 1805. 字符串中不同整数的数目
 * 给你一个字符串 word ，该字符串由数字和小写英文字母组成。
 * <p>
 * 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。注意，剩下的这些整数为（相邻彼此至少有一个空格隔开）："123"、"34"、"8" 和 "34" 。
 * <p>
 * 返回对 word 完成替换后形成的 不同 整数的数目。
 * <p>
 * 只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "a123bc34d8ef34"
 * 输出：3
 * 解释：不同的整数有 "123"、"34" 和 "8" 。注意，"34" 只计数一次。
 * 示例 2：
 * <p>
 * 输入：word = "leet1234code234"
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：word = "a1b01c001"
 * 输出：1
 * 解释："1"、"01" 和 "001" 视为同一个整数的十进制表示，因为在比较十进制值时会忽略前导零的存在。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 1000
 * word 由数字和小写英文字母组成
 */
public class Code6 {

    public int numDifferentIntegers(String word) {
        //返回
        Set<String> set = new HashSet<>();
        //组合
        StringBuilder num = new StringBuilder();
        //循环
        for (int i = 0; i < word.length(); i++) {
            //当前字符
            int space = word.charAt(i) - '0';
            //如果是数组
            if (space > -1 & space < 10) {
                //如果是0
                if (space == 0) {
                    //如果有首位首位是0
                    if (num.length() == 1 && num.charAt(0) == '0') {
                        //不算
                        continue;
                    }
                }
                //如果不是0
                if (space != 0 && num.length() == 1 && num.charAt(0) == '0') {
                    //重写
                    num = new StringBuilder();
                }
                //组装
                num.append(space);
            } else {
                //如果有长度
                if (num.length() > 0) {
                    //组装
                    set.add(num.toString());
                }
                //刷新
                num = new StringBuilder();
            }
        }
        //如果有长度
        if (num.length() > 0) {
            //组装
            set.add(num.toString());
        }
        //返回
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(new Code6().numDifferentIntegers("a1b01c001"));
    }

}
