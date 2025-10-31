package normal47;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-10-31
 * 3365. 重排子字符串以形成目标字符串
 * 算术评级: 4
 * 第 425 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1514
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个字符串 s 和 t（它们互为字母异位词），以及一个整数 k。
 * <p>
 * 你的任务是判断是否可以将字符串 s 分割成 k 个等长的子字符串，然后重新排列这些子字符串，并以任意顺序连接它们，使得最终得到的新字符串与给定的字符串 t 相匹配。
 * <p>
 * 如果可以做到，返回 true；否则，返回 false。
 * <p>
 * 字母异位词 是指由另一个单词或短语的所有字母重新排列形成的单词或短语，使用所有原始字母恰好一次。
 * <p>
 * 子字符串 是字符串中的一个连续 非空 字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "abcd", t = "cdab", k = 2
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * 将 s 分割成 2 个长度为 2 的子字符串：["ab", "cd"]。
 * 重新排列这些子字符串为 ["cd", "ab"]，然后连接它们得到 "cdab"，与 t 相匹配。
 * 示例 2：
 * <p>
 * 输入： s = "aabbcc", t = "bbaacc", k = 3
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * 将 s 分割成 3 个长度为 2 的子字符串：["aa", "bb", "cc"]。
 * 重新排列这些子字符串为 ["bb", "aa", "cc"]，然后连接它们得到 "bbaacc"，与 t 相匹配。
 * 示例 3：
 * <p>
 * 输入： s = "aabbcc", t = "bbaacc", k = 2
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * <p>
 * 将 s 分割成 2 个长度为 3 的子字符串：["aab", "bcc"]。
 * 这些子字符串无法重新排列形成 t = "bbaacc"，所以输出 false。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length == t.length <= 2 * 105
 * 1 <= k <= s.length
 * s.length 能被 k 整除。
 * s 和 t 仅由小写英文字母组成。
 * 输入保证 s 和 t 互为字母异位词。
 */
public class Code15 {

    public boolean isPossibleToRearrange(String s, String t, int k) {
        //切换缓存
        Map<String, Integer> map = new HashMap<>();
        //计算
        int partLength = s.length() / k;
        //循环
        for (int i = partLength - 1; i < s.length(); i = i + partLength) {
            //计算区间
            int start = i - partLength + 1;
            int end = start + partLength;
            //切割本块
            String part = s.substring(start, end);
            //+1
            map.put(part, map.getOrDefault(part, 0) + 1);
        }
        //循环
        for (int i = partLength - 1; i < s.length(); i = i + partLength) {
            //计算区间
            int start = i - partLength + 1;
            int end = start + partLength;
            //切割本块
            String part = t.substring(start, end);
            //计算数量,-1
            int count = map.getOrDefault(part, 0) - 1;
            //如果不够了
            if (count < 0) {
                //不行
                return false;
            }
            //覆盖缓存
            map.put(part, count);
        }
        //默认可以
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code15().isPossibleToRearrange("aabbcc", "bbaacc", 3));
    }

}
