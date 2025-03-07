package easy5;

/**
 * Created By Rock-Ayl on 2021-01-06
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 进阶：
 * <p>
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * 致谢：
 * <p>
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 */
public class Code7 {

    public static boolean isSubsequence(String s, String t) {
        //判空
        if (s.length() == 0) {
            //缺省
            return true;
        }
        //字母位置
        int p = 0;
        //初始化当前字母
        char thisLetter = s.charAt(p);
        //循环
        for (char c : t.toCharArray()) {
            //如果是当前字母
            if (c == thisLetter) {
                //如果结尾了
                if (p == s.length() - 1) {
                    //视为可以
                    return true;
                }
                //位置叠加
                p++;
                //重置当前字母
                thisLetter = s.charAt(p);
            }
        }
        //默认不可以
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }
}
