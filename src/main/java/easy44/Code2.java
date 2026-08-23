package easy44;

/**
 * 4030. 判断 ASCII 值回文
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个由小写英文字母组成的字符串 s。
 * <p>
 * 将 s 中的每个字符替换为其 ASCII 值对应的 8 位二进制表示，包括前导零，并保持字符原有顺序，从而构造一个二进制字符串。
 * <p>
 * 如果得到的二进制字符串是一个 回文串 ，则返回 true；否则返回 false。
 * <p>
 * 二进制字符串 是指仅由字符 '0' 和 '1' 组成的字符串。
 * <p>
 * 回文串 是指正着读和反着读都相同的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "ff"
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * 字符 f 的 ASCII 值为 102，其 8 位二进制表示为 01100110。
 * 因此，得到的二进制字符串为 0110011001100110。
 * 由于该二进制字符串是一个 回文串 ，因此输出为 true。
 * 示例 2：
 * <p>
 * 输入： s = "leet"
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * <p>
 * 字符 l、e、e 和 t 的 ASCII 值分别为 108、101、101 和 116 。
 * 它们对应的 8 位二进制表示分别为 01101100、01100101、01100101 和 01110100。
 * 因此，得到的二进制字符串为 01101100011001010110010101110100。
 * 由于该二进制字符串不是一个 回文串 ，因此输出为 false。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 仅由小写英文字母组成。
 */
public class Code2 {

    public boolean isPalindromic(String s) {
        //字符串
        StringBuilder str = new StringBuilder();
        //循环
        for (int i = 0; i < s.length(); i++) {
            //转为数字
            int num = s.charAt(i);
            //二进制
            String binaryString = Integer.toBinaryString(num);
            //组装8位
            str.append(String.format("%08d", Integer.parseInt(binaryString)));
        }
        //双指针
        int left = 0;
        int right = str.length() - 1;
        //如果还有
        while (left < right) {
            //如果不是
            if (str.charAt(left++) != str.charAt(right--)) {
                //不是
                return false;
            }
        }
        //默认是
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().isPalindromic("ff"));
    }

}
