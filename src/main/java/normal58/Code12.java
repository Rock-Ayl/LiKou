package normal58;

/**
 * 926. 将字符串翻转到单调递增
 * 算术评级: 5
 * 第 107 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1602
 * 相关标签
 * premium lock icon
 * 相关企业
 * 如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。
 * <p>
 * 给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。
 * <p>
 * 返回使 s 单调递增的最小翻转次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "00110"
 * 输出：1
 * 解释：翻转最后一位得到 00111.
 * 示例 2：
 * <p>
 * 输入：s = "010110"
 * 输出：2
 * 解释：翻转得到 011111，或者是 000111。
 * 示例 3：
 * <p>
 * 输入：s = "00011000"
 * 输出：2
 * 解释：翻转得到 00000000。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 为 '0' 或 '1'
 */
public class Code12 {

    public int minFlipsMonoIncr(String s) {
        //二者的数量
        int one = 0;
        int zero = 0;
        //前缀和
        int[] righZeroArr = new int[s.length()];
        //循环
        for (int i = s.length() - 1; i >= 0; i--) {
            //叠加右边0的数量
            righZeroArr[i] = (i < s.length() - 1 ? righZeroArr[i + 1] : 0) + (s.charAt(i) == '0' ? 1 : 0);
            //叠加右边1的数量
            one += s.charAt(i) == '1' ? 1 : 0;
            //叠加左边0的数量
            zero += s.charAt(i) == '0' ? 1 : 0;
        }
        //最小结果
        int min = Math.min(one, zero);
        //左边1的数量
        int left = 0;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //叠加左边1的数量
            left += s.charAt(i) == '1' ? 1 : 0;
            //右边0的数量
            int right = (i + 1 < righZeroArr.length ? righZeroArr[i + 1] : 0);
            //刷新最小
            min = Math.min(left + right, min);
        }
        //返回
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().minFlipsMonoIncr("00110"));
    }

}
