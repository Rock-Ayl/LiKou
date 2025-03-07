package easy5;

/**
 * Created By Rock-Ayl on 2021-01-23
 * 剑指 Offer 58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * <p>
 * 注意：此题对比原题有改动
 */
public class Code23 {

    public static String reverseWords(String s) {
        //分割
        String[] words = s.split(" ");
        //初始化返回值
        StringBuffer result = new StringBuffer();
        //循环
        for (int i = words.length - 1; i >= 0; i--) {
            //单词
            String word = words[i];
            //如果不是空
            if (word.length() > 0) {
                //组装
                result.append(word + " ");
            }
        }
        //判空
        if (result.length() > 0) {
            //删除最后一个
            result.deleteCharAt(result.length() - 1);
        }
        //返回
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }
}
