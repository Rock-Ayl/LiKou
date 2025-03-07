package easy33;

/**
 * @Author ayl
 * @Date 2023-09-06
 * 2839. 判断通过操作能否让字符串相等 I
 * 提示
 * 简单
 * 1
 * 相关企业
 * 给你两个字符串 s1 和 s2 ，两个字符串的长度都为 4 ，且只包含 小写 英文字母。
 * <p>
 * 你可以对两个字符串中的 任意一个 执行以下操作 任意 次：
 * <p>
 * 选择两个下标 i 和 j 且满足 j - i = 2 ，然后 交换 这个字符串中两个下标对应的字符。
 * 如果你可以让字符串 s1 和 s2 相等，那么返回 true ，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "abcd", s2 = "cdab"
 * 输出：true
 * 解释： 我们可以对 s1 执行以下操作：
 * - 选择下标 i = 0 ，j = 2 ，得到字符串 s1 = "cbad" 。
 * - 选择下标 i = 1 ，j = 3 ，得到字符串 s1 = "cdab" = s2 。
 * 示例 2：
 * <p>
 * 输入：s1 = "abcd", s2 = "dacb"
 * 输出：false
 * 解释：无法让两个字符串相等。
 * <p>
 * <p>
 * 提示：
 * <p>
 * s1.length == s2.length == 4
 * s1 和 s2 只包含小写英文字母。
 */
public class Code8 {

    public boolean canBeEqual(String s1, String s2) {
        //第一个
        boolean one = (s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2)) || (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0));
        //第二个
        boolean two = (s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3)) || (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1));
        //判断
        return one && two;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().canBeEqual("abcd", "cdab"));
    }

}
