package easy26;

import java.util.*;

/**
 * @Author ayl
 * @Date 2022-12-19
 * 2506. 统计相似字符串对的数目
 * 给你一个下标从 0 开始的字符串数组 words 。
 * <p>
 * 如果两个字符串由相同的字符组成，则认为这两个字符串 相似 。
 * <p>
 * 例如，"abca" 和 "cba" 相似，因为它们都由字符 'a'、'b'、'c' 组成。
 * 然而，"abacba" 和 "bcfd" 不相似，因为它们不是相同字符组成的。
 * 请你找出满足字符串 words[i] 和 words[j] 相似的下标对 (i, j) ，并返回下标对的数目，其中 0 <= i < j <= word.length - 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["aba","aabb","abcd","bac","aabc"]
 * 输出：2
 * 解释：共有 2 对满足条件：
 * - i = 0 且 j = 1 ：words[0] 和 words[1] 只由字符 'a' 和 'b' 组成。
 * - i = 3 且 j = 4 ：words[3] 和 words[4] 只由字符 'a'、'b' 和 'c' 。
 * 示例 2：
 * <p>
 * 输入：words = ["aabb","ab","ba"]
 * 输出：3
 * 解释：共有 3 对满足条件：
 * - i = 0 且 j = 1 ：words[0] 和 words[1] 只由字符 'a' 和 'b' 组成。
 * - i = 0 且 j = 2 ：words[0] 和 words[2] 只由字符 'a' 和 'b' 组成。
 * - i = 1 且 j = 2 ：words[1] 和 words[2] 只由字符 'a' 和 'b' 组成。
 * 示例 3：
 * <p>
 * 输入：words = ["nba","cba","dba"]
 * 输出：0
 * 解释：不存在满足条件的下标对，返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] 仅由小写英文字母组成
 */
public class Code5 {

    public int similarPairs(String[] words) {
        //缓存1
        Map<Integer, List<Set<Character>>> map = new HashMap<>();
        //循环
        for (String word : words) {
            //缓存2
            Set<Character> set = new HashSet<>();
            //循环2
            for (char c : word.toCharArray()) {
                //组装
                set.add(c);
            }
            //组装至缓存1
            List<Set<Character>> list = map.getOrDefault(set.size(), new ArrayList<>());
            list.add(set);
            map.put(set.size(), list);
        }
        //结果
        int count = 0;
        //循环
        for (Map.Entry<Integer, List<Set<Character>>> entry : map.entrySet()) {
            //当前
            List<Set<Character>> list = entry.getValue();
            //循环1
            for (int i = 0; i < list.size(); i++) {
                //循环2
                for (int j = i + 1; j < list.size(); j++) {
                    //如果相同
                    if (list.get(i).equals(list.get(j))) {
                        //记录结果
                        count++;
                    }
                }
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().similarPairs(new String[]{"aba", "aabb", "abcd", "bac", "aabc"}));
    }

}
