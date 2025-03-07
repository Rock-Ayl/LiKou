package easy;

import java.util.Arrays;
import java.util.List;

/**
 * Created By Rock-Ayl on 2020-08-07
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class Code5 {

    public static String reverseWords(String s) {
        StringBuffer result = new StringBuffer();
        //根据空格拆分
        List<String> list = Arrays.asList(s.split(" "));
        for (String anyone : list) {
            //转化为buffer
            StringBuffer buf = new StringBuffer(anyone);
            //倒叙
            buf = buf.reverse();
            //组装
            result.append(buf + " ");
        }
        //删除最后一个空格
        result = result.deleteCharAt(result.length() - 1);
        //返回
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("abc"));
    }

}
