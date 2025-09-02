package normal46;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-09-02
 * 1170. 比较字符串最小字母出现频次
 * 算术评级: 3
 * 第 151 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1432
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 定义一个函数 f(s)，统计 s  中（按字典序比较）最小字母的出现频次 ，其中 s 是一个非空字符串。
 * <p>
 * 例如，若 s = "dcce"，那么 f(s) = 2，因为字典序最小字母是 "c"，它出现了 2 次。
 * <p>
 * 现在，给你两个字符串数组待查表 queries 和词汇表 words 。对于每次查询 queries[i] ，需统计 words 中满足 f(queries[i]) < f(W) 的 词的数目 ，W 表示词汇表 words 中的每个词。
 * <p>
 * 请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是第 i 次查询的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：queries = ["cbd"], words = ["zaaaz"]
 * 输出：[1]
 * 解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
 * 示例 2：
 * <p>
 * 输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * 输出：[1,2]
 * 解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j]、words[i][j] 都由小写英文字母组成
 */
public class Code1 {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        //单词频次数组
        int[] wordCountArr = new int[words.length];
        //循环
        for (int i = 0; i < words.length; i++) {
            //当前单词的频次
            wordCountArr[i] = count(words[i]);
        }
        //排序
        Arrays.sort(wordCountArr);
        //初始化结果
        int[] result = new int[queries.length];
        //循环
        for (int i = 0; i < queries.length; i++) {
            //当前单词数量
            int count = count(queries[i]);
            //寻找结果并组装
            result[i] = find(wordCountArr, count);
        }
        //返回
        return result;
    }

    //寻找结果并组装
    private int find(int[] wordCountArr, int count) {
        //如果没有严格比它大的
        if (wordCountArr[wordCountArr.length - 1] <= count) {
            //过
            return 0;
        }
        //如果所有的都比它大
        if (wordCountArr[0] > count) {
            //返回
            return wordCountArr.length;
        }
        //递归实现
        return findExecute(wordCountArr, count, 0, wordCountArr.length - 1);
    }

    //递归实现
    private int findExecute(int[] wordCountArr, int count, int left, int right) {
        //如果过了
        if (left > right) {
            //返回
            return -1;
        }
        //如果相等
        if (left == right) {
            //返回结果
            return wordCountArr.length - left;
        }
        //如果无法缩小了
        if (left + 1 == right) {
            //如果是左边
            if (wordCountArr[left] > count) {
                //返回左边
                return wordCountArr.length - left;
            } else {
                //返回右边
                return wordCountArr.length - right;
            }
        }
        //计算中间
        int mid = (right - left) / 2 + left;
        //如果更小
        if (wordCountArr[mid] <= count) {
            //右边
            return findExecute(wordCountArr, count, mid + 1, right);
        } else {
            //左边
            return findExecute(wordCountArr, count, left, mid);
        }
    }

    //计算单词频次
    private int count(String word) {
        //数组
        int[] arr = new int[26];
        //循环
        for (int i = 0; i < word.length(); i++) {
            //+1
            arr[word.charAt(i) - 'a']++;
        }
        //循环
        for (int i = 0; i < arr.length; i++) {
            //如果大于
            if (arr[i] > 0) {
                //返回结果
                return arr[i];
            }
        }
        //默认
        return 0;
    }

    public static void main(String[] args) {
        //int[] ints = new Code1().numSmallerByFrequency(new String[]{"bbb", "cc"}, new String[]{"a", "aaaa", "aa", "aaa"});
        int[] ints = new Code1().numSmallerByFrequency(
                new String[]{"bba"},
                new String[]{"aaabbb", "aab", "babbab", "babbbb", "b", "bbbbbbbbab", "a", "bbbbbbbbbb", "baaabbaab", "aa"});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

}
