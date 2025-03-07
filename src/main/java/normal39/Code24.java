package normal39;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-02-04
 * LCR 015. 找到字符串中所有字母异位词
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 变位词 指字母相同，但排列不同的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
 * 示例 2：
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的变位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的变位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的变位词。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 * <p>
 * <p>
 * 注意：本题与主站 438 题相同： https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class Code24 {

    public List<Integer> findAnagrams(String s, String p) {

        //初始化结果
        List<Integer> resultList = new ArrayList<>();
        //如果不够
        if (s.length() < p.length()) {
            //过
            return resultList;
        }

        /**
         * 计算 p 的数量
         */

        //缓存
        Map<Character, Integer> targetMap = new HashMap<>();
        //循环
        for (char c : p.toCharArray()) {
            //+1
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        /**
         * 初始化第一次
         */

        //滑动缓存
        Map<Character, Integer> thisMap = new HashMap<>();
        //循环1
        for (int i = 0; i < p.length(); i++) {
            //当前
            char c = s.charAt(i);
            //+1
            thisMap.put(c, thisMap.getOrDefault(c, 0) + 1);
        }
        //如果第一个相同
        if (thisMap.equals(targetMap)) {
            //默认
            resultList.add(0);
        }

        /**
         * 滑动
         */

        for (int i = p.length(); i < s.length(); i++) {
            //当前
            char c = s.charAt(i);
            //+1
            thisMap.put(c, thisMap.getOrDefault(c, 0) + 1);
            //需要删除的
            char q = s.charAt(i - p.length());
            //-1
            thisMap.put(q, thisMap.getOrDefault(q, 0) - 1);
            //如果是0
            if (thisMap.get(q) == 0) {
                //删除
                thisMap.remove(q);
            }
            //如果第一个相同
            if (thisMap.equals(targetMap)) {
                //默认
                resultList.add(i - p.length() + 1);
            }
        }

        //返回
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new Code24().findAnagrams("cbaebabacd", "abc"));
    }

}
