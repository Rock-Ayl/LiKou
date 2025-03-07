package normal36;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2024-10-19
 * 1456. 定长子串中元音的最大数目
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你字符串 s 和整数 k 。
 * <p>
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * <p>
 * 英文中的 元音字母 为（a, e, i, o, u）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abciiidef", k = 3
 * 输出：3
 * 解释：子字符串 "iii" 包含 3 个元音字母。
 * 示例 2：
 * <p>
 * 输入：s = "aeiou", k = 2
 * 输出：2
 * 解释：任意长度为 2 的子字符串都包含 2 个元音字母。
 * 示例 3：
 * <p>
 * 输入：s = "leetcode", k = 3
 * 输出：2
 * 解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
 * 示例 4：
 * <p>
 * 输入：s = "rhythms", k = 4
 * 输出：0
 * 解释：字符串 s 中不含任何元音字母。
 * 示例 5：
 * <p>
 * 输入：s = "tryhard", k = 4
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * s 由小写英文字母组成
 * 1 <= k <= s.length
 */
public class Code9 {

    public int maxVowels(String s, int k) {
        //元音集合
        Set<Character> targetSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        //最大数量
        int maxCount = 0;
        //当前数量
        int count = 0;
        //起点
        int start = 0;
        //终点
        int end = 0;
        //循环
        while (end < s.length()) {
            //叠加本次
            count += targetSet.contains(s.charAt(end++)) == true ? 1 : 0;
            //如果多了
            if (end - start > k) {
                //删减本次
                count -= targetSet.contains(s.charAt(start++)) == true ? 1 : 0;
            }
            //刷新最大
            maxCount = Math.max(maxCount, count);
        }
        //返回最大
        return maxCount;
    }

    public static void main(String[] args) {

    }

}
