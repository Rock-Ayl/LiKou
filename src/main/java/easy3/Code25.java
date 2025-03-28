package easy3;

import java.util.*;

/**
 * Created By Rock-Ayl on 2020-11-17
 * 819. 最常见的单词
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 * <p>
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 * <p>
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 * <p>
 * 示例：
 * <p>
 * 输入:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * 输出: "ball"
 * 解释:
 * "hit" 出现了3次，但它是一个禁用的单词。
 * "ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
 * 注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
 * "hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= 段落长度 <= 1000
 * 0 <= 禁用单词个数 <= 100
 * 1 <= 禁用单词长度 <= 10
 * 答案是唯一的, 且都是小写字母 (即使在 paragraph 里是大写的，即使是一些特定的名词，答案都是小写的。)
 * paragraph 只包含字母、空格和下列标点符号!?',;.
 * 不存在没有连字符或者带有连字符的单词。
 * 单词里只包含字母，不会出现省略号或者其他标点符号。
 */
public class Code25 {

    public static String mostCommonWord(String paragraph, String[] banned) {
        //单词出现次数缓存
        Map<String, Integer> map = new HashMap<>();
        //禁止单词缓存
        Set<String> stop = new HashSet<>(Arrays.asList(banned));
        //符号组缓存
        Set<Character> sym = new HashSet<>(Arrays.asList(' ', '!', '?', '\'', ',', ';', '.'));
        //全小写转化,
        char[] sentence = paragraph.toLowerCase().toCharArray();
        //当前单词缓存
        StringBuffer thisWord = new StringBuffer();
        //循环
        for (char c : sentence) {
            //如果之前是一个单词
            if (sym.contains(c)) {
                //如果当前单词的长度大于0
                if (thisWord.length() > 0) {
                    //转化为str
                    String word = thisWord.toString();
                    //如果单词不被禁止
                    if (!stop.contains(word)) {
                        //如果单词已经被记录
                        if (map.containsKey(word)) {
                            //+1
                            map.put(word, map.get(word) + 1);
                        } else {
                            //初始化
                            map.put(word, 1);
                        }
                    }
                    //无论如何,都清除单词缓存
                    thisWord = new StringBuffer();
                }
            } else {
                //组装
                thisWord.append(c + "");
            }
        }
        //如果最后的单词的长度大于0
        if (thisWord.length() > 0) {
            //转化为str
            String word = thisWord.toString();
            //如果单词不被禁止
            if (!stop.contains(word)) {
                //如果单词已经被记录
                if (map.containsKey(word)) {
                    //+1
                    map.put(word, map.get(word) + 1);
                } else {
                    //初始化
                    map.put(word, 1);
                }
            }
        }
        //最大次数
        int maxCount = 0;
        //最大次数的单词
        String maxStr = "";
        //循环
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            //如果大于
            if (entry.getValue() > maxCount) {
                //记录
                maxCount = entry.getValue();
                //记录单词
                maxStr = entry.getKey();
            }
        }
        //缺省
        return maxStr;
    }

    public static void main(String[] args) {
        System.out.println(mostCommonWord("a.", new String[]{"hit"}));
    }
}
