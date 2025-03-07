package normal18;

/**
 * @Author ayl
 * @Date 2022-12-25
 * 2486. 追加字符以获得子序列
 * 给你两个仅由小写英文字母组成的字符串 s 和 t 。
 * <p>
 * 现在需要通过向 s 末尾追加字符的方式使 t 变成 s 的一个 子序列 ，返回需要追加的最少字符数。
 * <p>
 * 子序列是一个可以由其他字符串删除部分（或不删除）字符但不改变剩下字符顺序得到的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "coaching", t = "coding"
 * 输出：4
 * 解释：向 s 末尾追加字符串 "ding" ，s = "coachingding" 。
 * 现在，t 是 s ("coachingding") 的一个子序列。
 * 可以证明向 s 末尾追加任何 3 个字符都无法使 t 成为 s 的一个子序列。
 * 示例 2：
 * <p>
 * 输入：s = "abcde", t = "a"
 * 输出：0
 * 解释：t 已经是 s ("abcde") 的一个子序列。
 * 示例 3：
 * <p>
 * 输入：s = "z", t = "abcde"
 * 输出：5
 * 解释：向 s 末尾追加字符串 "abcde" ，s = "zabcde" 。
 * 现在，t 是 s ("zabcde") 的一个子序列。
 * 可以证明向 s 末尾追加任何 4 个字符都无法使 t 成为 s 的一个子序列。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 105
 * s 和 t 仅由小写英文字母组成
 */
public class Code5 {

    public int appendCharacters(String s, String t) {
        //指针
        int p = 0;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //如果倒头来
            if (p == t.length()) {
                //直接返回结果
                return 0;
            }
            //如果相同
            if (s.charAt(i) == t.charAt(p)) {
                //进位
                p++;
            }
        }
        //返回结果
        return t.length() - p;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().appendCharacters("coaching", "coding"));
        ;
    }

}
