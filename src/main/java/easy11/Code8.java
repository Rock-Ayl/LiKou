package easy11;

/**
 * @Author ayl
 * @Date 2021-08-25
 * 1961. 检查字符串是否为数组前缀
 * 给你一个字符串 s 和一个字符串数组 words ，请你判断 s 是否为 words 的 前缀字符串 。
 * <p>
 * 字符串 s 要成为 words 的 前缀字符串 ，需要满足：s 可以由 words 中的前 k（k 为 正数 ）个字符串按顺序相连得到，且 k 不超过 words.length 。
 * <p>
 * 如果 s 是 words 的 前缀字符串 ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "iloveleetcode", words = ["i","love","leetcode","apples"]
 * 输出：true
 * 解释：
 * s 可以由 "i"、"love" 和 "leetcode" 相连得到。
 * 示例 2：
 * <p>
 * 输入：s = "iloveleetcode", words = ["apples","i","love","leetcode"]
 * 输出：false
 * 解释：
 * 数组的前缀相连无法得到 s 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * 1 <= s.length <= 1000
 * words[i] 和 s 仅由小写英文字母组成
 */
public class Code8 {

    public boolean isPrefixString(String s, String[] words) {
        //初始化
        StringBuffer str = new StringBuffer();
        //循环1
        for (String word : words) {
            //循环2
            for (char c : word.toCharArray()) {
                //组装当前
                str.append(c);
            }
            //如果正好满足
            if (s.length() == str.length()) {
                //结束,尝试判一致
                break;
            } else if (s.length() < str.length()) {
                //不可以
                return false;
            }
        }
        //判断
        return str.toString().equals(s);
    }

    public static void main(String[] args) {
        System.out.println(new Code8().isPrefixString("iloveleetcode", new String[]{"i", "love", "leetcode", "apples"}));
    }
}
