package easy39;

/**
 * @Author ayl
 * @Date 2025-02-19
 * 3456. 找出长度为 K 的特殊子字符串
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s 和一个整数 k。
 * <p>
 * 判断是否存在一个长度 恰好 为 k 的子字符串，该子字符串需要满足以下条件：
 * <p>
 * 该子字符串 只包含一个唯一字符（例如，"aaa" 或 "bbb"）。
 * 如果该子字符串的 前面 有字符，则该字符必须与子字符串中的字符不同。
 * 如果该子字符串的 后面 有字符，则该字符也必须与子字符串中的字符不同。
 * 如果存在这样的子串，返回 true；否则，返回 false。
 * <p>
 * 子字符串 是字符串中的连续、非空字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "aaabaaa", k = 3
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * 子字符串 s[4..6] == "aaa" 满足条件：
 * <p>
 * 长度为 3。
 * 所有字符相同。
 * 子串 "aaa" 前的字符是 'b'，与 'a' 不同。
 * 子串 "aaa" 后没有字符。
 * 示例 2：
 * <p>
 * 输入： s = "abc", k = 2
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * <p>
 * 不存在长度为 2 、仅由一个唯一字符组成且满足所有条件的子字符串。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= s.length <= 100
 * s 仅由小写英文字母组成。
 */
public class Code22 {

    public boolean hasSpecialSubstring(String s, int k) {

        //如果超过
        if (s.length() < k) {
            //过
            return false;
        }
        //如果只有一个
        if (s.length() == 1) {
            //可以
            return true;
        }

        /**
         * 初始化第一次
         */

        //滑动双指针
        int start = 0;
        int end = 0;
        //不同
        int noSame = 0;
        //统计
        int[] arr = new int[127];
        //循环
        while (end < k) {
            //+1,如果新增
            if (++arr[s.charAt(end++)] == 1) {
                //+1
                noSame++;
            }
        }
        //如果只有一种 and 后面的不同
        if (noSame == 1 && (s.length() == k || s.charAt(k) != s.charAt(k - 1))) {
            //是
            return true;
        }

        /**
         * 开始计算
         */

        //循环
        while (end < s.length()) {
            //+1,如果新增
            if (++arr[s.charAt(end++)] == 1) {
                //+1
                noSame++;
            }
            //-1,如果删除
            if (--arr[s.charAt(start++)] == 0) {
                //-1
                noSame--;
            }
            //如果相同 and 满足
            if (noSame == 1 && s.charAt(start) != s.charAt(start - 1) && (end == s.length() || s.charAt(end) != s.charAt(end - 1))) {
                //可以
                return true;
            }
        }

        //默认不存在
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code22().hasSpecialSubstring("ii", 2));
    }

}
