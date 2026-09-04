package normal56;

/**
 * 1347. 制造字母异位词的最小步骤数
 * 算术评级: 4
 * 第 175 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1331
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个长度相等的字符串 s 和 t。每一个步骤中，你可以选择将 t 中的 任一字符 替换为 另一个字符。
 * <p>
 * 返回使 t 成为 s 的字母异位词的最小步骤数。
 * <p>
 * 字母异位词 指字母相同，但排列不同（也可能相同）的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输出：s = "bab", t = "aba"
 * 输出：1
 * 提示：用 'b' 替换 t 中的第一个 'a'，t = "bba" 是 s 的一个字母异位词。
 * 示例 2：
 * <p>
 * 输出：s = "leetcode", t = "practice"
 * 输出：5
 * 提示：用合适的字符替换 t 中的 'p', 'r', 'a', 'i' 和 'c'，使 t 变成 s 的字母异位词。
 * 示例 3：
 * <p>
 * 输出：s = "anagram", t = "mangaar"
 * 输出：0
 * 提示："anagram" 和 "mangaar" 本身就是一组字母异位词。
 * 示例 4：
 * <p>
 * 输出：s = "xxyyzz", t = "xxyyzz"
 * 输出：0
 * 示例 5：
 * <p>
 * 输出：s = "friend", t = "family"
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 50000
 * s.length == t.length
 * s 和 t 只包含小写英文字母
 */
public class Code23 {

    public int minSteps(String s, String t) {
        //次数数组
        int[] arr = new int[26];
        //循环
        for (int i = 0; i < s.length(); i++) {
            //+1
            arr[s.charAt(i) - 'a']++;
        }
        //循环
        for (int i = 0; i < t.length(); i++) {
            //-1
            arr[t.charAt(i) - 'a']--;
        }
        //结果
        int count = 0;
        //循环
        for (int num : arr) {
            //叠加
            count += Math.abs(num);
        }
        //返回
        return count / 2;
    }

    public static void main(String[] args) {
        System.out.println(new Code23().minSteps("leetcode", "practice"));
    }

}
