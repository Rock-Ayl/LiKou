package normal2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-04-21
 * <p>
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 * <p>
 * 输入："  hello world!  "
 * 输出："world! hello"
 * 解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入："a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 示例 4：
 * <p>
 * 输入：s = "  Bob    Loves  Alice   "
 * 输出："Alice Loves Bob"
 * 示例 5：
 * <p>
 * 输入：s = "Alice does not even like bob"
 * 输出："bob like even not does Alice"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 请尝试使用 O(1) 额外空间复杂度的原地解法。
 */
public class Code18 {

    public String reverseWords(String s) {
        //切割
        List<String> arr = Arrays.asList(s.split(" "));
        //倒叙
        Collections.reverse(arr);
        //结果
        StringBuffer str = new StringBuffer();
        //循环
        for (String s1 : arr) {
            //如果有长度
            if (s1.length() > 0) {
                //组装
                str.append(s1 + " ");
            }
        }
        //删除最后一个
        str.deleteCharAt(str.length() - 1);
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code18().reverseWords("Alice does not even like bob"));
    }
}
