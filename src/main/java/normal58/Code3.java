package normal58;

/**
 * 2370. 最长理想子序列
 * 算术评级: 5
 * 第 305 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 1835
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个由小写字母组成的字符串 s ，和一个整数 k 。如果满足下述条件，则可以将字符串 t 视作是 理想字符串 ：
 * <p>
 * t 是字符串 s 的一个子序列。
 * t 中每两个 相邻 字母在字母表中位次的绝对差值小于或等于 k 。
 * 返回 最长 理想字符串的长度。
 * <p>
 * 字符串的子序列同样是一个字符串，并且子序列还满足：可以经由其他字符串删除某些字符（也可以不删除）但不改变剩余字符的顺序得到。
 * <p>
 * 注意：字母表顺序不会循环。例如，'a' 和 'z' 在字母表中位次的绝对差值是 25 ，而不是 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "acfgbd", k = 2
 * 输出：4
 * 解释：最长理想字符串是 "acbd" 。该字符串长度为 4 ，所以返回 4 。
 * 注意 "acfgbd" 不是理想字符串，因为 'c' 和 'f' 的字母表位次差值为 3 。
 * 示例 2：
 * <p>
 * 输入：s = "abcd", k = 3
 * 输出：4
 * 解释：最长理想字符串是 "abcd" ，该字符串长度为 4 ，所以返回 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * 0 <= k <= 25
 * s 由小写英文字母组成
 */
public class Code3 {

    public int longestIdealString(String s, int k) {
        //数组
        int[] arr = new int[26];
        //结果
        int max = 0;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //获取key
            int key = s.charAt(i) - 'a';
            //上一个最大结果
            int lastMax = 0;
            //循环2
            for (int j = Math.max(0, key - k); j <= Math.min(25, key + k); j++) {
                //刷新最大
                lastMax = Math.max(lastMax, arr[j]);
            }
            //更新本次
            arr[key] = lastMax + 1;
            //刷新最大
            max = Math.max(max, arr[key]);
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        new Code3().longestIdealString("acfgbd", 2);
    }

}
