package normal2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2021-04-18
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * s.length <= 40000
 * 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Code15 {

    public int lengthOfLongestSubstring(String s) {
        //判空
        if (s.length() == 0) {
            //返回
            return 0;
        }
        //当前不重复字符缓存
        Set<Character> set = new HashSet<>(s.length());
        //最大结果
        int maxSize = 0;
        //当前结果
        int thisSize = 0;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //当前字符
            char x = s.charAt(i);
            //如果和之前的重复了
            if (set.contains(x)) {
                //更新最大记录
                maxSize = Math.max(maxSize, thisSize);
                //清空set
                set.clear();
                //刷新当前
                thisSize = 1;
                //记录当前
                set.add(x);
                //当前位置
                int p = i - 1;
                //循环
                while (p >= 0) {
                    //当前左边字符,用完递减
                    char y = s.charAt(p--);
                    //如果到头了
                    if (set.contains(y)) {
                        //结束
                        break;
                    } else {
                        //记录
                        set.add(y);
                        //叠加
                        thisSize++;
                    }
                }
            } else {
                //递增
                thisSize++;
                //记录
                set.add(x);
            }
        }
        //返回最大的结果
        return Math.max(maxSize, thisSize);
    }

    public static void main(String[] args) {
        System.out.println(new Code15().lengthOfLongestSubstring("anviaj"));
    }
}
