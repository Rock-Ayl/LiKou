package normal57;

/**
 * 3138. 同位字符串连接的最小长度
 * 算术评级: 5
 * 第 396 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1979
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 s ，它由某个字符串 t 和若干 t  的 同位字符串 连接而成。
 * <p>
 * 请你返回字符串 t 的 最小 可能长度。
 * <p>
 * 同位字符串 指的是重新排列一个字符串的字母得到的另外一个字符串。例如，"aab"，"aba" 和 "baa" 是 "aab" 的同位字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abba"
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 一个可能的字符串 t 为 "ba" 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "cdef"
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * 一个可能的字符串 t 为 "cdef" ，注意 t 可能等于 s 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "abcbcacabbaccba"
 * <p>
 * 输出：3
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 只包含小写英文字母。
 */
public class Code19 {

    public int minAnagramLength(String s) {
        //循环
        for (int part = 1; part <= s.length() / 2; part++) {
            //如果无法整除
            if (s.length() % part != 0) {
                //失败
                continue;
            }
            //如果当前分片满足
            if (check(s, part)) {
                //返回
                return part;
            }
        }
        //默认
        return s.length();
    }

    //是否可行
    private boolean check(String s, int part) {
        //初始化第一个
        int[] firstArr = new int[26];
        //循环
        for (int j = 0; j < part; j++) {
            //+1
            firstArr[s.charAt(j) - 'a']++;
        }
        //循环
        for (int i = part; i < s.length(); i += part) {
            //当前
            int[] thisArr = firstArr.clone();
            //循环
            for (int j = i; j < i + part; j++) {
                //-1,如果不符合
                if (--thisArr[s.charAt(j) - 'a'] < 0) {
                    //失败
                    return false;
                }
            }
        }
        //成功
        return true;
    }

    public static void main(String[] args) {
        //abcbcacabbaccba
        //System.out.println(new Code19().minAnagramLength("abcbcacabbaccba"));

        //abba
        System.out.println(new Code19().minAnagramLength("abba"));

    }

}
