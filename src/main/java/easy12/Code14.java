package easy12;

/**
 * @Author ayl
 * @Date 2021-10-13
 * 925. 长按键入
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 * <p>
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 * 示例 2：
 * <p>
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 * 示例 3：
 * <p>
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：name = "laiden", typed = "laiden"
 * 输出：true
 * 解释：长按名字中的字符并不是必要的。
 * <p>
 * <p>
 * 提示：
 * <p>
 * name.length <= 1000
 * typed.length <= 1000
 * name 和 typed 的字符都是小写字母。
 */
public class Code14 {

    public boolean isLongPressedName(String name, String typed) {
        //如果首位不同
        if (name.charAt(0) != typed.charAt(0)) {
            //过
            return false;
        }
        //双指针
        int p = 1, p2 = 1;
        //循环
        while (p < name.length() && p2 < typed.length()) {
            //分别获取
            char x = name.charAt(p);
            char y = typed.charAt(p2);
            //如果一致
            if (x == y) {
                //全进
                p++;
                p2++;
            } else {
                //左右
                int left = p2 - 1, right = p2 + 1;
                //左右连续次数
                int size = 0;
                //如果左边对
                if (typed.charAt(left) == y) {
                    size++;
                }
                //如果未越界,如果右边对
                if (right < typed.length() && typed.charAt(right) == y) {
                    size++;
                }
                //如果一次都没有
                if (size == 0) {
                    //失败
                    return false;
                }
                //进一位
                p2++;
            }
        }
        //如果全部拥有
        if (p == name.length()) {
            //最后一个
            char last = typed.charAt(p2 - 1);
            //循环剩下的
            for (int i = p2; i < typed.length(); i++) {
                //如果接下来不是连按
                if (typed.charAt(i) != last) {
                    //不是
                    return false;
                }
            }
            //是
            return true;
        } else {
            //不是
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code14().isLongPressedName("zlexya", "aazlllllllllllllleexxxxxxxxxxxxxxxya"));
    }
}
