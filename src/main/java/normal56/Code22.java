package normal56;

/**
 * 2186. 制造字母异位词的最小步骤数 II
 * 算术评级: 4
 * 第 282 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1253
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个字符串 s 和 t 。在一步操作中，你可以给 s 或者 t 追加 任一字符 。
 * <p>
 * 返回使 s 和 t 互为 字母异位词 所需的最少步骤数。
 * <p>
 * 字母异位词 指字母相同但是顺序不同（或者相同）的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leetcode", t = "coats"
 * 输出：7
 * 解释：
 * - 执行 2 步操作，将 "as" 追加到 s = "leetcode" 中，得到 s = "leetcodeas" 。
 * - 执行 5 步操作，将 "leede" 追加到 t = "coats" 中，得到 t = "coatsleede" 。
 * "leetcodeas" 和 "coatsleede" 互为字母异位词。
 * 总共用去 2 + 5 = 7 步。
 * 可以证明，无法用少于 7 步操作使这两个字符串互为字母异位词。
 * 示例 2：
 * <p>
 * 输入：s = "night", t = "thing"
 * 输出：0
 * 解释：给出的字符串已经互为字母异位词。因此，不需要任何进一步操作。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 2 * 105
 * s 和 t 由小写英文字符组成
 */
public class Code22 {

    public int minSteps(String s, String t) {
        //数组
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
        //操作结果
        int count = 0;
        //循环
        for (int i = 0; i < arr.length; i++) {
            //叠加本次
            count += Math.abs(arr[i]);
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code22().minSteps("leetcode", "coats"));
    }

}
