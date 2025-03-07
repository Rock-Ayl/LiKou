package normal;

import java.util.Arrays;

/**
 * Created By Rock-Ayl on 2021-03-16
 * 1433. 检查一个字符串是否可以打破另一个字符串
 * 给你两个字符串 s1 和 s2 ，它们长度相等，请你检查是否存在一个 s1  的排列可以打破 s2 的一个排列，或者是否存在一个 s2 的排列可以打破 s1 的一个排列。
 * <p>
 * 字符串 x 可以打破字符串 y （两者长度都为 n ）需满足对于所有 i（在 0 到 n - 1 之间）都有 x[i] >= y[i]（字典序意义下的顺序）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "abc", s2 = "xya"
 * 输出：true
 * 解释："ayx" 是 s2="xya" 的一个排列，"abc" 是字符串 s1="abc" 的一个排列，且 "ayx" 可以打破 "abc" 。
 * 示例 2：
 * <p>
 * 输入：s1 = "abe", s2 = "acd"
 * 输出：false
 * 解释：s1="abe" 的所有排列包括："abe"，"aeb"，"bae"，"bea"，"eab" 和 "eba" ，s2="acd" 的所有排列包括："acd"，"adc"，"cad"，"cda"，"dac" 和 "dca"。然而没有任何 s1 的排列可以打破 s2 的排列。也没有 s2 的排列能打破 s1 的排列。
 * 示例 3：
 * <p>
 * 输入：s1 = "leetcodee", s2 = "interview"
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * s1.length == n
 * s2.length == n
 * 1 <= n <= 10^5
 * 所有字符串都只包含小写英文字母。
 */
public class Code11 {

    /**
     * 增加空间很大
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkIfCanBreak(String s1, String s2) {
        //序列
        int[] a = new int[s1.length()], b = new int[s2.length()];
        //循环
        for (int i = 0; i < s1.length(); i++) {
            //记录值
            a[i] = s1.charAt(i);
            b[i] = s2.charAt(i);
        }
        //排序
        Arrays.sort(a);
        Arrays.sort(b);
        //正负
        Boolean isPlus = null;
        //循环
        for (int i = 0; i < a.length; i++) {
            //获取值
            int x = a[i], y = b[i];
            //如果是空
            if (isPlus == null) {
                //如果确定了正负
                if (x > y) {
                    //正
                    isPlus = true;
                } else if (x < y) {
                    //负
                    isPlus = false;
                } else {
                    //过
                }
            } else if (isPlus == true) {
                //如果是负的倾向了
                if (y > x) {
                    //不可以
                    return false;
                }
            } else {
                //如果是正的倾向了
                if (x > y) {
                    //不可以
                    return false;
                }
            }
        }
        //默认
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkIfCanBreak("abe", "acd"));
    }
}
