package difficult3;

import java.util.*;

/**
 * @Author ayl
 * @Date 2025-05-31
 * 127. 单词接龙
 * 尝试过
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 字典 wordList 中从单词 beginWord 到 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
 * <p>
 * 每一对相邻的单词只差一个字母。
 * 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * 示例 2：
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有字符串 互不相同
 */
public class Code11 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        /**
         * 计算路径
         */

        //路径缓存
        Map<String, Set<String>> nextMap = new HashMap<>();
        //所有单词对应模糊匹配缓存
        Map<String, Set<String>> wordRangeMap = new HashMap<>();
        //循环
        for (String word : wordList) {
            //初始化缓存
            wordRangeMap.put(word, new HashSet<>());
            //转为可修改对象
            StringBuilder wordStrBuilder = new StringBuilder(word);
            //循环
            for (int i = 0; i < wordStrBuilder.length(); i++) {
                //当前字符
                char oldChar = wordStrBuilder.charAt(i);
                //修改为通用字符
                wordStrBuilder.setCharAt(i, '*');
                //转化为key
                String key = wordStrBuilder.toString();
                //记录
                wordRangeMap.get(word).add(key);
                //初始化
                nextMap.putIfAbsent(key, new HashSet<>());
                //记录结果
                nextMap.get(key).add(word);
                //回溯
                wordStrBuilder.setCharAt(i, oldChar);
            }
        }
        //如果没有结尾
        if (wordRangeMap.containsKey(endWord) == false) {
            //不存在
            return 0;
        }

        /**
         * 开始结束计入缓存
         */

        //初始化缓存
        wordRangeMap.put(beginWord, new HashSet<>());
        //转为可修改对象
        StringBuilder beginWordStrBuilder = new StringBuilder(beginWord);
        //循环
        for (int i = 0; i < beginWordStrBuilder.length(); i++) {
            //当前字符
            char oldChar = beginWordStrBuilder.charAt(i);
            //修改为通用字符
            beginWordStrBuilder.setCharAt(i, '*');
            //转化为key
            String key = beginWordStrBuilder.toString();
            //记录
            wordRangeMap.get(beginWord).add(key);
            //回溯
            beginWordStrBuilder.setCharAt(i, oldChar);
        }

        /**
         * 广度搜索
         */

        //走过的路径,默认自己
        Set<String> walkSet = new HashSet<>(Arrays.asList(beginWord));
        //递归实现
        return next(new HashSet<>(Collections.singletonList(beginWord)), endWord, 0, nextMap, wordRangeMap, walkSet);
    }

    //递归
    public int next(Set<String> beginWordSet, String endWord, int count,
                    Map<String, Set<String>> nextMap, Map<String, Set<String>> wordRangeMap, Set<String> walkSet) {

        //本轮结果集
        Set<String> nextBeginSet = new HashSet<>();
        //循环所有
        for (String beginWord : beginWordSet) {
            //如果不存在
            if (wordRangeMap.containsKey(beginWord) == false) {
                //本轮过
                continue;
            }
            //获取其模糊匹配结果
            Set<String> beginWordRange = wordRangeMap.get(beginWord);
            //循环
            for (String range : beginWordRange) {
                //如果不存在
                if (nextMap.containsKey(range) == false) {
                    //本轮过
                    continue;
                }
                //获取下一步单词
                Set<String> nextSet = nextMap.get(range);
                //循环
                for (String next : nextSet) {
                    //如果是结果
                    if (next.equals(endWord)) {
                        //返回
                        return count + 2;
                    }
                    //如果存在,说明走过了
                    if (walkSet.contains(next)) {
                        //本轮过
                        continue;
                    }
                    //记录走过了
                    walkSet.add(next);
                    //记录
                    nextBeginSet.add(next);
                }
            }
        }

        //如果没有
        if (nextBeginSet.isEmpty()) {
            //过
            return 0;
        }

        //递归下一个深度
        return next(nextBeginSet, endWord, count + 1, nextMap, wordRangeMap, walkSet);
    }

    public static void main(String[] args) {
        System.out.println(new Code11().ladderLength("hot", "dog", Arrays.asList("hot", "dog")));
        ;
    }

}
