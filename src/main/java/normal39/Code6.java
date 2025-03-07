package normal39;

/**
 * @Author ayl
 * @Date 2025-01-13
 * LCR 016. 无重复字符的最长子串
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
 * 示例 2：
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子字符串是 "b"，所以其长度为 1。
 * 示例 3：
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4：
 * <p>
 * 输入: s = ""
 * 输出: 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * <p>
 * 注意：本题与主站 3 题相同： https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Code6 {

    public int lengthOfLongestSubstring(String s) {
        //计数器
        int[] arr = new int[127];
        //重复数量
        int count = 0;
        //开始、结束索引
        int start = 0;
        int end = 0;
        //最大可能结果
        int maxResult = 0;
        //循环
        while (end < s.length()) {
            //计算key、+1、如果有重复
            if (++arr[s.charAt(end++)] == 2) {
                //记录重复
                count++;
            }
            //如果还是有重复的
            while (start < s.length() && count > 0) {
                //计算key、-1、如果没有重复
                if (--arr[s.charAt(start++)] == 1) {
                    //记录取消重复
                    count--;
                }
            }
            //计算最大可能
            maxResult = Math.max(maxResult, end - start);
        }
        //返回
        return maxResult;
    }

    public static void main(String[] args) {
        System.out.println(new Code6().lengthOfLongestSubstring("azAZ019 "));
    }

}
