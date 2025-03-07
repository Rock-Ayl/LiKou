package easy7;

/**
 * Created By Rock-Ayl on 2021-03-15
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 * 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
 * <p>
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "bank", s2 = "kanb"
 * 输出：true
 * 解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
 * 示例 2：
 * <p>
 * 输入：s1 = "attack", s2 = "defend"
 * 输出：false
 * 解释：一次字符串交换无法使两个字符串相等
 * 示例 3：
 * <p>
 * 输入：s1 = "kelb", s2 = "kelb"
 * 输出：true
 * 解释：两个字符串已经相等，所以不需要进行字符串交换
 * 示例 4：
 * <p>
 * 输入：s1 = "abcd", s2 = "dcba"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s1.length, s2.length <= 100
 * s1.length == s2.length
 * s1 和 s2 仅由小写英文字母组成
 * 通过次数4,996提交次数10,950
 */
public class Code19 {

    public static boolean areAlmostEqual(String s1, String s2) {
        //长度不一致
        if (s1.length() != s2.length()) {
            //返回
            return false;
        }
        //不同的字符
        Character x = null, y = null;
        //移动过了
        boolean isMove = false;
        //循环
        for (int i = 0; i < s1.length(); i++) {
            //左右当前字符
            char a = s1.charAt(i), b = s2.charAt(i);
            //如果ab一致
            if (a == b) {
                //过
                continue;
            } else if (isMove == false) {
                //如果未出现不同的字符
                if (x == null) {
                    //记录
                    x = a;
                    y = b;
                } else {
                    //如果是移动的
                    if (x == b && y == a) {
                        //记录
                        isMove = true;
                    } else {
                        //不符合条件
                        return false;
                    }
                }
            } else {
                //不符合条件
                return false;
            }
        }
        //如果仅有一个不同的
        if (x != null && y != null && isMove == false) {
            //不符合
            return false;
        }
        //默认
        return true;
    }

    public static void main(String[] args) {
        System.out.println(areAlmostEqual("bank", "kanb"));
    }
}
