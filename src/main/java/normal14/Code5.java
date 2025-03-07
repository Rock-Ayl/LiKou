package normal14;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-06-13
 * 792. 匹配子序列的单词数
 * 给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。
 * <p>
 * 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
 * <p>
 * 例如， “ace” 是 “abcde” 的子序列。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcde", words = ["a","bb","acd","ace"]
 * 输出: 3
 * 解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
 * Example 2:
 * <p>
 * 输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * 输出: 2
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 5 * 104
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 50
 * words[i]和 s 都只由小写字母组成。
 */
public class Code5 {

    public boolean contrast(String s, String word) {
        //指针
        int sp = 0;
        int wp = 0;
        //循环
        while (sp < s.length() && wp < word.length()) {
            //判断是否一致,左边无论如何都进位
            if (s.charAt(sp++) == word.charAt(wp)) {
                //额外进位
                wp++;
            }
        }
        //返回结果
        return wp == word.length();
    }

    public int numMatchingSubseq(String s, String[] words) {
        //数量
        int count = 0;
        //缓存<key,count>
        Map<String, Integer> map = new HashMap<>();
        //循环
        for (String word : words) {
            //叠加
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        //循环
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            //如果是
            if (contrast(s, entry.getKey())) {
                //叠加
                count += entry.getValue();
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"}));
    }

}
