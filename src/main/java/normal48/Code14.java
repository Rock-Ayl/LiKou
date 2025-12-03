package normal48;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-12-03
 * 916. 单词子集
 * 算术评级: 4
 * 第 104 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1624
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你两个字符串数组 words1 和 words2。
 * <p>
 * 现在，如果 b 中的每个字母都出现在 a 中，包括重复出现的字母，那么称字符串 b 是字符串 a 的 子集 。
 * <p>
 * 例如，"wrr" 是 "warrior" 的子集，但不是 "world" 的子集。
 * 如果对 words2 中的每一个单词 b，b 都是 a 的子集，那么我们称 words1 中的单词 a 是 通用单词 。
 * <p>
 * 以数组形式返回 words1 中所有的 通用 单词。你可以按 任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
 * <p>
 * 输出：["facebook","google","leetcode"]
 * <p>
 * 示例 2：
 * <p>
 * 输入：words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["lc","eo"]
 * <p>
 * 输出：["leetcode"]
 * <p>
 * 示例 3：
 * <p>
 * 输入：words1 = ["acaac","cccbb","aacbb","caacc","bcbbb"], words2 = ["c","cc","b"]
 * <p>
 * 输出：["cccbb"]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words1.length, words2.length <= 104
 * 1 <= words1[i].length, words2[i].length <= 10
 * words1[i] 和 words2[i] 仅由小写英文字母组成
 * words1 中的所有字符串 互不相同
 */
public class Code14 {

    public List<String> wordSubsets(String[] words1, String[] words2) {
        //缓存
        int[] allWordArr = new int[26];
        //循环
        for (int i = 0; i < words2.length; i++) {
            //获取对应单词
            String word = words2[i];
            //计数器
            int[] wordArr = new int[26];
            //循环
            for (char letter : word.toCharArray()) {
                //+1
                wordArr[letter - 'a']++;
            }
            //循环所有
            for (int j = 0; j < wordArr.length; j++) {
                //刷新最大
                allWordArr[j] = Math.max(allWordArr[j], wordArr[j]);
            }
        }
        //结果列表
        List<String> result = new ArrayList<>();
        //跳出标记
        out:
        //循环
        for (int i = 0; i < words1.length; i++) {
            //单词
            String word = words1[i];
            //计数器
            int[] wordArr = new int[26];
            //循环
            for (char letter : word.toCharArray()) {
                //+1
                wordArr[letter - 'a']++;
            }
            //循环所有
            for (int j = 0; j < wordArr.length; j++) {
                //如果不够
                if (wordArr[j] < allWordArr[j]) {
                    //本轮过
                    continue out;
                }
            }
            //记录单词
            result.add(word);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        List<String> strings = new Code14().wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"lc", "eo"});
        System.out.println();
    }

}
