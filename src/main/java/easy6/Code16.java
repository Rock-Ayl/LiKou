package easy6;

/**
 * Created By Rock-Ayl on 2021-02-14
 * 面试题 01.09. 字符串轮转
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 * <p>
 * 示例1:
 * <p>
 * 输入：s1 = "waterbottle", s2 = "erbottlewat"
 * 输出：True
 * 示例2:
 * <p>
 * 输入：s1 = "aa", s2 = "aba"
 * 输出：False
 * 提示：
 * <p>
 * 字符串长度在[0, 100000]范围内。
 * 说明:
 * <p>
 * 你能只调用一次检查子串的方法吗？
 */
public class Code16 {

    public static boolean isFlipedString(String s1, String s2) {
        //判空
        if (s1.length() == 0) {
            //右边是否为空
            if (s2.length() == 0) {
                //可以
                return true;
            } else {
                //不可以
                return false;
            }
        } else if (s2.length() == 0) {
            return false;
        }
        //叠加一倍
        s1 = s1 + s1;
        //如果存在
        if (s1.contains(s2)) {
            //可以
            return true;
        }
        //缺省
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isFlipedString("waterbottle", "erbottlewat"));
    }
}
