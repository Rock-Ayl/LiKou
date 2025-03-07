package easy;

/**
 * Created By Rock-Ayl on 2020-08-21
 * 剑指 Offer 58 - II. 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 * <p>
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 * <p>
 * 限制：
 * <p>
 * 1 <= k < s.length <= 10000
 */
public class Code13 {

    public static String reverseLeftWords(String s, int n) {
        //创建个buffer
        StringBuffer value = new StringBuffer(s);
        //获取要转移的字符
        String a = value.substring(0, n);
        //获取已经切除的字符
        String b = value.substring(n, s.length());
        //返回
        return b + a;
    }

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
    }
}
