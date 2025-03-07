package difficult2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-06-14
 * 1255. 得分最高的单词集合
 * 你将会得到一份单词表 words，一个字母表 letters （可能会有重复字母），以及每个字母对应的得分情况表 score。
 * <p>
 * 请你帮忙计算玩家在单词拼写游戏中所能获得的「最高得分」：能够由 letters 里的字母拼写出的 任意 属于 words 单词子集中，分数最高的单词集合的得分。
 * <p>
 * 单词拼写游戏的规则概述如下：
 * <p>
 * 玩家需要用字母表 letters 里的字母来拼写单词表 words 中的单词。
 * 可以只使用字母表 letters 中的部分字母，但是每个字母最多被使用一次。
 * 单词表 words 中每个单词只能计分（使用）一次。
 * 根据字母得分情况表score，字母 'a', 'b', 'c', ... , 'z' 对应的得分分别为 score[0], score[1], ..., score[25]。
 * 本场游戏的「得分」是指：玩家所拼写出的单词集合里包含的所有字母的得分之和。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["dog","cat","dad","good"], letters = ["a","a","c","d","d","d","g","o","o"], score = [1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0]
 * 输出：23
 * 解释：
 * 字母得分为  a=1, c=9, d=5, g=3, o=2
 * 使用给定的字母表 letters，我们可以拼写单词 "dad" (5+1+5)和 "good" (3+2+2+5)，得分为 23 。
 * 而单词 "dad" 和 "dog" 只能得到 21 分。
 * 示例 2：
 * <p>
 * 输入：words = ["xxxz","ax","bx","cx"], letters = ["z","a","b","c","x","x","x"], score = [4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10]
 * 输出：27
 * 解释：
 * 字母得分为  a=4, b=4, c=4, x=5, z=10
 * 使用给定的字母表 letters，我们可以组成单词 "ax" (4+5)， "bx" (4+5) 和 "cx" (4+5) ，总得分为 27 。
 * 单词 "xxxz" 的得分仅为 25 。
 * 示例 3：
 * <p>
 * 输入：words = ["leetcode"], letters = ["l","e","t","c","o","d"], score = [0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0]
 * 输出：0
 * 解释：
 * 字母 "e" 在字母表 letters 中只出现了一次，所以无法组成单词表 words 中的单词。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 14
 * 1 <= words[i].length <= 15
 * 1 <= letters.length <= 100
 * letters[i].length == 1
 * score.length == 26
 * 0 <= score[i] <= 10
 * words[i] 和 letters[i] 只包含小写的英文字母。
 */
public class Code3 {

    //最大分数
    private int maxScore = 0;

    //走下去
    public void next(int p, int score, int[] arr, int[] wordScoreArr, List<Map<Integer, Integer>> wordMapList) {
        //如果越级了
        if (p == wordMapList.size()) {
            //刷新分数
            this.maxScore = Math.max(maxScore, score);
            //过
            return;
        }
        //先忽略本次计算,直接走下去
        next(p + 1, score, arr, wordScoreArr, wordMapList);
        //当前单词消耗
        Map<Integer, Integer> wordMap = wordMapList.get(p);
        //是否有下一级,默认有
        boolean haveNext = true;
        //循环
        for (Map.Entry<Integer, Integer> wordEntry : wordMap.entrySet()) {
            //递减
            arr[wordEntry.getKey()] -= wordEntry.getValue();
            //如果超了
            if (arr[wordEntry.getKey()] < 0) {
                //本次不行
                haveNext = false;
            }
        }
        //如果有下一级
        if (haveNext) {
            //递归走下去
            next(p + 1, score + wordScoreArr[p], arr, wordScoreArr, wordMapList);
        }
        //循环回溯
        for (Map.Entry<Integer, Integer> wordEntry : wordMap.entrySet()) {
            //递增
            arr[wordEntry.getKey()] += wordEntry.getValue();
        }
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        //当前拥有的字母
        int[] arr = new int[26];
        //循环1
        for (char letter : letters) {
            //记录拥有的字母
            arr[letter - 'a']++;
        }
        //每个单词对应分数
        int[] wordScoreArr = new int[words.length];
        //初始化单词对应map
        List<Map<Integer, Integer>> wordMapList = new ArrayList<>(words.length);
        //循环
        for (int i = 0; i < words.length; i++) {
            //单词字母缓存
            Map<Integer, Integer> wordMap = new HashMap<>();
            //循环单词字母
            for (char c : words[i].toCharArray()) {
                //对应坐标
                Integer num = c - 'a';
                //叠加单词分数
                wordScoreArr[i] += score[num];
                //记录
                wordMap.put(num, wordMap.getOrDefault(num, 0) + 1);
            }
            //组装map
            wordMapList.add(wordMap);
        }
        //从一开始走
        next(0, 0, arr, wordScoreArr, wordMapList);
        //返回结果
        return this.maxScore;
    }

    public static void main(String[] args) {

        // 21 21 18 12 21
        System.out.println(new Code3().maxScoreWords(
                new String[]{"add", "dda", "bb", "ba", "add"},
                new char[]{'a', 'a', 'a', 'a', 'b', 'b', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'd', 'd', 'd'},
                new int[]{3, 9, 8, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        ));
    }

}
