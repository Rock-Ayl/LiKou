package normal33;

/**
 * @Author ayl
 * @Date 2024-08-02
 * 2840. 判断通过操作能否让字符串相等 II
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个字符串 s1 和 s2 ，两个字符串长度都为 n ，且只包含 小写 英文字母。
 * <p>
 * 你可以对两个字符串中的 任意一个 执行以下操作 任意 次：
 * <p>
 * 选择两个下标 i 和 j ，满足 i < j 且 j - i 是 偶数，然后 交换 这个字符串中两个下标对应的字符。
 * <p>
 * <p>
 * 如果你可以让字符串 s1 和 s2 相等，那么返回 true ，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "abcdba", s2 = "cabdab"
 * 输出：true
 * 解释：我们可以对 s1 执行以下操作：
 * - 选择下标 i = 0 ，j = 2 ，得到字符串 s1 = "cbadba" 。
 * - 选择下标 i = 2 ，j = 4 ，得到字符串 s1 = "cbbdaa" 。
 * - 选择下标 i = 1 ，j = 5 ，得到字符串 s1 = "cabdab" = s2 。
 * 示例 2：
 * <p>
 * 输入：s1 = "abe", s2 = "bea"
 * 输出：false
 * 解释：无法让两个字符串相等。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == s1.length == s2.length
 * 1 <= n <= 105
 * s1 和 s2 只包含小写英文字母。
 */
public class Code22 {

    public boolean checkStrings(String s1, String s2) {
        //缓存数组
        int[] cacheArr = new int[26];
        //循环
        for (int i = 1; i < s1.length(); i = i + 2) {
            //+1
            cacheArr[s1.charAt(i) - 'a']++;
            //-1
            cacheArr[s2.charAt(i) - 'a']--;
        }
        //循环1
        for (int i = 0; i < cacheArr.length; i++) {
            //如果不是
            if (cacheArr[i] != 0) {
                //不可以
                return false;
            }
        }
        //循环
        for (int i = 0; i < s1.length(); i = i + 2) {
            //+1
            cacheArr[s1.charAt(i) - 'a']++;
            //-1
            cacheArr[s2.charAt(i) - 'a']--;
        }
        //循环1
        for (int i = 0; i < cacheArr.length; i++) {
            //如果不是
            if (cacheArr[i] != 0) {
                //不可以
                return false;
            }
        }
        //默认可以
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code22().checkStrings("abe", "bea"));
    }

}
