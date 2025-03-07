package normal40;

/**
 * @Author ayl
 * @Date 2025-02-24
 * 2606. 找到最大开销的子字符串
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s ，一个字符 互不相同 的字符串 chars 和一个长度与 chars 相同的整数数组 vals 。
 * <p>
 * 子字符串的开销 是一个子字符串中所有字符对应价值之和。空字符串的开销是 0 。
 * <p>
 * 字符的价值 定义如下：
 * <p>
 * 如果字符不在字符串 chars 中，那么它的价值是它在字母表中的位置（下标从 1 开始）。
 * 比方说，'a' 的价值为 1 ，'b' 的价值为 2 ，以此类推，'z' 的价值为 26 。
 * 否则，如果这个字符在 chars 中的位置为 i ，那么它的价值就是 vals[i] 。
 * 请你返回字符串 s 的所有子字符串中的最大开销。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "adaa", chars = "d", vals = [-1000]
 * 输出：2
 * 解释：字符 "a" 和 "d" 的价值分别为 1 和 -1000 。
 * 最大开销子字符串是 "aa" ，它的开销为 1 + 1 = 2 。
 * 2 是最大开销。
 * 示例 2：
 * <p>
 * 输入：s = "abc", chars = "abc", vals = [-1,-1,-1]
 * 输出：0
 * 解释：字符 "a" ，"b" 和 "c" 的价值分别为 -1 ，-1 和 -1 。
 * 最大开销子字符串是 "" ，它的开销为 0 。
 * 0 是最大开销。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 只包含小写英文字母。
 * 1 <= chars.length <= 26
 * chars 只包含小写英文字母，且 互不相同 。
 * vals.length == chars.length
 * -1000 <= vals[i] <= 1000
 */
public class Code12 {

    public int maximumCostSubstring(String s, String chars, int[] vals) {

        /**
         * 计算 每个字母的分数
         */

        //分数数组
        int[] rankArr = new int[26];
        //循环
        for (int i = 0; i < rankArr.length; i++) {
            //默认分数
            rankArr[i] = i + 1;
        }
        //循环
        for (int i = 0; i < chars.length(); i++) {
            //记录字母对应分数
            rankArr[chars.charAt(i) - 'a'] = vals[i];
        }

        /**
         * 计算、分数 前缀和，同时计算结果
         */

        //长度
        int[] sumArr = new int[s.length()];
        //默认分数
        sumArr[0] = rankArr[s.charAt(0) - 'a'];
        //最小可能
        int min = Math.min(0, sumArr[0]);
        //最大分数
        int max = Math.max(0, sumArr[0]);
        //循环
        for (int i = 1; i < sumArr.length; i++) {
            //叠加本次分数
            sumArr[i] = sumArr[i - 1] + (rankArr[s.charAt(i) - 'a']);
            //刷新本次最大结果
            max = Math.max(max, sumArr[i] - min);
            //刷新最小值
            min = Math.min(sumArr[i], min);
        }

        //返回结果
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().maximumCostSubstring("kqqqqqkkkq", "kq", new int[]{-6, 6}));
    }

}
