package easy15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2021-12-02
 * 2085. 统计出现过一次的公共字符串
 * 给你两个字符串数组 words1 和 words2 ，请你返回在两个字符串数组中 都恰好出现一次 的字符串的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]
 * 输出：2
 * 解释：
 * - "leetcode" 在两个数组中都恰好出现一次，计入答案。
 * - "amazing" 在两个数组中都恰好出现一次，计入答案。
 * - "is" 在两个数组中都出现过，但在 words1 中出现了 2 次，不计入答案。
 * - "as" 在 words1 中出现了一次，但是在 words2 中没有出现过，不计入答案。
 * 所以，有 2 个字符串在两个数组中都恰好出现了一次。
 * 示例 2：
 * <p>
 * 输入：words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]
 * 输出：0
 * 解释：没有字符串在两个数组中都恰好出现一次。
 * 示例 3：
 * <p>
 * 输入：words1 = ["a","ab"], words2 = ["a","a","a","ab"]
 * 输出：1
 * 解释：唯一在两个数组中都出现一次的字符串是 "ab" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words1.length, words2.length <= 1000
 * 1 <= words1[i].length, words2[j].length <= 30
 * words1[i] 和 words2[j] 都只包含小写英文字母。
 */
public class Code17 {

    public int countWords(String[] words1, String[] words2) {
        //缓存
        Map<String, Integer> map = new HashMap<>();
        //循环
        for (String word : words1) {
            //+1
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        //缓存
        Set<String> set = new HashSet<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            //如果是
            if (entry.getValue() == 1) {
                //记录
                set.add(entry.getKey());
            }
        }
        //缓存
        Map<String, Integer> map2 = new HashMap<>();
        //循环
        for (String word : words2) {
            //+1
            map2.put(word, map2.getOrDefault(word, 0) + 1);
        }
        //缓存
        Set<String> set2 = new HashSet<>();
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            //如果是
            if (entry.getValue() == 1) {
                //记录
                set2.add(entry.getKey());
            }
        }
        //交集
        set.retainAll(set2);
        //数量
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(new Code17().countWords(new String[]{"leetcode", "is", "amazing", "as", "is"}, new String[]{"amazing", "leetcode", "is"}));
    }


}
