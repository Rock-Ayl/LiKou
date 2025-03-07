package normal32;

/**
 * @Author ayl
 * @Date 2024-06-01
 * 848. 字母移位
 * 中等
 * 相关标签
 * 相关企业
 * 有一个由小写字母组成的字符串 s，和一个长度相同的整数数组 shifts。
 * <p>
 * 我们将字母表中的下一个字母称为原字母的 移位 shift() （由于字母表是环绕的， 'z' 将会变成 'a'）。
 * <p>
 * 例如，shift('a') = 'b', shift('t') = 'u', 以及 shift('z') = 'a'。
 * 对于每个 shifts[i] = x ， 我们会将 s 中的前 i + 1 个字母移位 x 次。
 * <p>
 * 返回 将所有这些移位都应用到 s 后最终得到的字符串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc", shifts = [3,5,9]
 * 输出："rpl"
 * 解释：
 * 我们以 "abc" 开始。
 * 将 S 中的第 1 个字母移位 3 次后，我们得到 "dbc"。
 * 再将 S 中的前 2 个字母移位 5 次后，我们得到 "igc"。
 * 最后将 S 中的这 3 个字母移位 9 次后，我们得到答案 "rpl"。
 * 示例 2:
 * <p>
 * 输入: s = "aaa", shifts = [1,2,3]
 * 输出: "gfd"
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 105
 * s 由小写英文字母组成
 * shifts.length == s.length
 * 0 <= shifts[i] <= 109
 */
public class Code10 {

    public String shiftingLetters(String s, int[] shifts) {
        //字母数组
        char[] arr = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        //循环
        for (int i = shifts.length - 2; i >= 0; i--) {
            //叠加
            shifts[i] += shifts[i + 1] % 26;
        }
        //初始化结果
        StringBuilder str = new StringBuilder();
        //循环
        for (int i = 0; i < s.length(); i++) {
            //计算移位后的索引
            int index = (s.charAt(i) - 'a' + shifts[i]) % 26;
            //组装本次结果
            str.append(arr[index]);
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code10().shiftingLetters("ruu", new int[]{26, 9, 17}));
    }
}
