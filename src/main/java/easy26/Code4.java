package easy26;

/**
 * @Author ayl
 * @Date 2022-12-17
 * 1758. 生成交替二进制字符串的最少操作数
 * 给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
 * <p>
 * 交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
 * <p>
 * 返回使 s 变成 交替字符串 所需的 最少 操作数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "0100"
 * 输出：1
 * 解释：如果将最后一个字符变为 '1' ，s 就变成 "0101" ，即符合交替字符串定义。
 * 示例 2：
 * <p>
 * 输入：s = "10"
 * 输出：0
 * 解释：s 已经是交替字符串。
 * 示例 3：
 * <p>
 * 输入：s = "1111"
 * 输出：2
 * 解释：需要 2 步操作得到 "0101" 或 "1010" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s[i] 是 '0' 或 '1'
 */
public class Code4 {

    public int minOperations(String s) {
        //结果
        int firstZeroCount = 0;
        int firstOneCount = 0;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //如果是偶数
            if (i % 2 == 0) {
                //如果是1
                if (s.charAt(i) == '0') {
                    //叠加
                    firstZeroCount++;
                } else {
                    //叠加
                    firstOneCount++;
                }
            } else {
                //如果是0
                if (s.charAt(i) == '1') {
                    //叠加
                    firstZeroCount++;
                } else {
                    //叠加
                    firstOneCount++;
                }
            }
        }
        //返回结果
        return Math.min(firstZeroCount, firstOneCount);
    }

    public static void main(String[] args) {
        System.out.println(new Code4().minOperations("0100"));
    }

}
