package easy3;

import java.util.*;

/**
 * Created By Rock-Ayl on 2020-10-26
 * 1408. 数组中的字符串匹配
 * 给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。
 * <p>
 * 如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 word[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["mass","as","hero","superhero"]
 * 输出：["as","hero"]
 * 解释："as" 是 "mass" 的子字符串，"hero" 是 "superhero" 的子字符串。
 * ["hero","as"] 也是有效的答案。
 * 示例 2：
 * <p>
 * 输入：words = ["leetcode","et","code"]
 * 输出：["et","code"]
 * 解释："et" 和 "code" 都是 "leetcode" 的子字符串。
 * 示例 3：
 * <p>
 * 输入：words = ["blue","green","bu"]
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 30
 * words[i] 仅包含小写英文字母。
 * 题目数据 保证 每个 words[i] 都是独一无二的。
 */
public class Code6 {

    public static List<String> stringMatching(String[] words) {
        //初始化结果
        List<String> result = new ArrayList<>();
        //words大小
        int wordSize = words.length;
        //排序
        for (int i = 0; i < wordSize - 1; i++) {
            for (int j = i + 1; j < wordSize; j++) {
                if (words[i].length() > words[j].length()) {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
        //小循环数
        int size = words.length - 1;
        //循环
        for (int i = 0; i < wordSize; i++) {
            //当前str
            String thisStr = words[i];
            //记录当前i
            int x = i;
            //如果没有到头
            while (x < size) {
                //叠加
                x++;
                //如果存在
                if (words[x].contains(thisStr)) {
                    //记录
                    result.add(thisStr);
                    //中断
                    break;
                }
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (String s : stringMatching(new String[]{"leetcoder", "leetcode", "od", "hamlet", "am"})) {
            System.out.println(s);
        }
    }
}
