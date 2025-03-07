package normal18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-01-13
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 示例 2:
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 */
public class Code12 {

    public List<Integer> findAnagrams(String s, String p) {
        //如果太大了
        if (p.length() > s.length()) {
            //过
            return new ArrayList<>();
        }
        //初始化结果
        List<Integer> result = new ArrayList<>();
        //缓存
        Map<Character, Integer> pMap = new HashMap<>();
        //循环
        for (char c : p.toCharArray()) {
            //记录缓存
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }
        //缓存2
        Map<Character, Integer> thisMap = new HashMap<>();
        //指针
        int point = 0;
        //循环
        while (point < p.length()) {
            //获取
            char space = s.charAt(point++);
            //记录缓存
            thisMap.put(space, thisMap.getOrDefault(space, 0) + 1);
        }
        //如果默认的相同
        if (pMap.equals(thisMap)) {
            //记录第一个
            result.add(0);
        }
        //循环,滑动
        while (point < s.length()) {
            //新的字符
            char newLetter = s.charAt(point);
            //旧的字符
            char oldLetter = s.charAt(point - p.length());
            //新的插入
            thisMap.put(newLetter, thisMap.getOrDefault(newLetter, 0) + 1);
            //如果还有
            if (thisMap.get(oldLetter) > 1) {
                //减少
                thisMap.put(oldLetter, thisMap.get(oldLetter) - 1);
            } else {
                //直接删除
                thisMap.remove(oldLetter);
            }
            //进位
            point++;
            //如果二者完全相同相同
            if (pMap.equals(thisMap)) {
                //记录结果
                result.add(point - p.length());
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        new Code12().findAnagrams("cbaebabacd", "abc");
    }

}
