package normal25;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2023-10-24
 * 1048. 最长字符串链
 * 提示
 * 中等
 * 313
 * 相关企业
 * 给出一个单词数组 words ，其中每个单词都由小写英文字母组成。
 * <p>
 * 如果我们可以 不改变其他字符的顺序 ，在 wordA 的任何地方添加 恰好一个 字母使其变成 wordB ，那么我们认为 wordA 是 wordB 的 前身 。
 * <p>
 * 例如，"abc" 是 "abac" 的 前身 ，而 "cba" 不是 "bcad" 的 前身
 * 词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word1 是 word2 的前身，word2 是 word3 的前身，依此类推。一个单词通常是 k == 1 的 单词链 。
 * <p>
 * 从给定单词列表 words 中选择单词组成词链，返回 词链的 最长可能长度 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["a","b","ba","bca","bda","bdca"]
 * 输出：4
 * 解释：最长单词链之一为 ["a","ba","bda","bdca"]
 * 示例 2:
 * <p>
 * 输入：words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
 * 输出：5
 * 解释：所有的单词都可以放入单词链 ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
 * 示例 3:
 * <p>
 * 输入：words = ["abcd","dbqca"]
 * 输出：1
 * 解释：字链["abcd"]是最长的字链之一。
 * ["abcd"，"dbqca"]不是一个有效的单词链，因为字母的顺序被改变了。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 16
 * words[i] 仅由小写英文字母组成。
 */
public class Code12 {

    //单词对应下一组单词map
    private Map<String, Set<String>> wordNextMap;
    //最大链长
    private int maxLinkLength;
    //最大单词长度
    private int maxWordLength;
    //已经走过的单词
    private Set<String> walkSet;

    public int longestStrChain(String[] words) {
        //初始化
        this.wordNextMap = new HashMap<>();
        this.maxLinkLength = 0;
        this.walkSet = new HashSet<>();
        //按照长度对单词分组分组
        Map<Integer, Set<String>> lengthWordMap = Arrays
                .stream(words)
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        //循环单词
        for (String word : words) {
            //初始化
            this.wordNextMap.put(word, new HashSet<>());
            //刷新最大单词长度
            this.maxWordLength = Math.max(this.maxWordLength, word.length());
            //获取可行的单词组
            Set<String> nextLengthWordSet = lengthWordMap.getOrDefault(word.length() + 1, new HashSet<>());
            //循环
            for (String nextWord : nextLengthWordSet) {
                //如果是
                if (check(word, nextWord)) {
                    //记录
                    this.wordNextMap.get(word).add(nextWord);
                }
            }
        }
        //按照长度从小到大循环
        for (Integer length : lengthWordMap.keySet().stream().sorted().collect(Collectors.toList())) {
            //循环对应长度的单词
            for (String word : lengthWordMap.get(length)) {
                //如果之前路过了 or 如果当前单词到最后也不会比现有最大值大
                if (this.walkSet.contains(word) || this.maxLinkLength > this.maxWordLength - word.length()) {
                    //本轮过
                    continue;
                }
                //递归
                next(word, 1);
            }
        }
        //返回
        return maxLinkLength;
    }

    //递归到链底
    private void next(String word, int linkLength) {
        //获取下一级集合
        Set<String> nextSet = this.wordNextMap.get(word);
        //如果没有了
        if (nextSet.isEmpty()) {
            //刷新记录
            this.maxLinkLength = Math.max(this.maxLinkLength, linkLength);
            //过
            return;
        }
        //循环
        for (String nextWord : nextSet) {
            //记录
            this.walkSet.add(nextWord);
            //递归
            next(nextWord, linkLength + 1);
        }
    }

    //检查单词是否为下一个链
    private boolean check(String word, String nextWord) {
        //双指针
        int p1 = 0;
        int p2 = 0;
        //错误
        int error = 0;
        //循环
        while (p1 < word.length() && p2 < nextWord.length()) {
            //如果对
            if (word.charAt(p1) == nextWord.charAt(p2++)) {
                //左边正常进位
                p1++;
            } else {
                //计算错误
                if (++error > 1) {
                    //不是
                    return false;
                }
            }
        }
        //默认是
        return true;
    }

    /**
     * 推荐的方案
     *
     * @param words
     * @return
     */
    public int start(String[] words) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int res = 0;
        for (String word : words) {
            cnt.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                if (cnt.containsKey(prev)) {
                    cnt.put(word, Math.max(cnt.get(word), cnt.get(prev) + 1));
                }
            }
            res = Math.max(res, cnt.get(word));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().start(new String[]{"ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh", "zczvh", "gr", "grukmj", "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru"}));
        System.out.println(new Code12().longestStrChain(new String[]{"ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh", "zczvh", "gr", "grukmj", "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru"}));
    }

}
