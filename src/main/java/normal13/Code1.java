package normal13;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2022-03-10
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class Code1 {

    public int lengthOfLongestSubstring(String s) {
        //最大,结果
        int max = 0;
        //滑动窗口
        int left = 0, right = 0;
        //对应字母
        char leftLetter, rightLetter;
        //缓存
        Set<Character> set = new HashSet<>();
        //循环
        while (right < s.length()) {
            //当前
            rightLetter = s.charAt(right);
            //如果可以继续
            if (set.contains(rightLetter) == false) {
                //记录缓存
                set.add(rightLetter);
            } else {
                //刷新最大结果
                max = Math.max(right - left, max);
                //获取左边
                leftLetter = s.charAt(left);
                //如果不是
                while (leftLetter != rightLetter) {
                    //删除缓存
                    set.remove(leftLetter);
                    //滑动
                    leftLetter = s.charAt(++left);
                }
                //滑动
                left++;
            }
            //下一个
            right++;
        }
        //刷新最大结果
        max = Math.max(right - left, max);
        //返回
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code1().lengthOfLongestSubstring("bpfbhmipx"));
    }

}
