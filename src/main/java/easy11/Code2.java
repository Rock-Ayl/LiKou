package easy11;

/**
 * @Author ayl
 * @Date 2021-08-08
 * 541. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 * <p>
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由小写英文组成
 * 1 <= k <= 104
 */
public class Code2 {

    public String reverseStr(String s, int k) {
        //初始化
        StringBuffer str = new StringBuffer();
        //指针
        int p = 0;
        //如果可以直接处理
        while ((p + 2 * k) <= s.length()) {
            //循环1
            for (int i = p + k - 1; i >= p; i--) {
                //倒叙
                str.append(s.charAt(i));
            }
            //循环2
            for (int i = p + k; i < p + 2 * k; i++) {
                //正序
                str.append(s.charAt(i));
            }
            //+2k
            p = p + 2 * k;
        }
        //最后处理
        if (s.length() - p < k) {
            //循环
            for (int i = s.length() - 1; i >= p; i--) {
                //全部倒叙
                str.append(s.charAt(i));
            }
        } else {
            //循环1
            for (int i = p + k - 1; i >= p; i--) {
                //倒叙
                str.append(s.charAt(i));
            }
            //循环2
            for (int i = p + k; i < s.length(); i++) {
                //正序
                str.append(s.charAt(i));
            }
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code2().reverseStr("abcdefg", 2));
    }
}
