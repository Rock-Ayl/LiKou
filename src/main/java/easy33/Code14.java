package easy33;

/**
 * @Author ayl
 * @Date 2023-09-25
 * 2864. 最大二进制奇数
 * 提示
 * 简单
 * 2
 * 相关企业
 * 给你一个 二进制 字符串 s ，其中至少包含一个 '1' 。
 * <p>
 * 你必须按某种方式 重新排列 字符串中的位，使得到的二进制数字是可以由该组合生成的 最大二进制奇数 。
 * <p>
 * 以字符串形式，表示并返回可以由给定组合生成的最大二进制奇数。
 * <p>
 * 注意 返回的结果字符串 可以 含前导零。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "010"
 * 输出："001"
 * 解释：因为字符串 s 中仅有一个 '1' ，其必须出现在最后一位上。所以答案是 "001" 。
 * 示例 2：
 * <p>
 * 输入：s = "0101"
 * 输出："1001"
 * 解释：其中一个 '1' 必须出现在最后一位上。而由剩下的数字可以生产的最大数字是 "100" 。所以答案是 "1001" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 仅由 '0' 和 '1' 组成
 * s 中至少包含一个 '1'
 */
public class Code14 {

    public String maximumOddBinaryNumber(String s) {
        //初始化结果
        StringBuilder str = new StringBuilder();
        //1的数量
        int oneCount = 0;
        //勋魂
        for (char c : s.toCharArray()) {
            //如果是0
            if (c == '0') {
                //组装0
                str.append(c);
            } else {
                //记录1
                oneCount++;
            }
        }
        //如果有额外的1
        if (oneCount > 1) {
            //循环
            while (oneCount-- > 1) {
                //组装1
                str.append('1');
            }
            //最后反转
            str.reverse();
        }
        //组装最后一个,保证奇数
        str.append('1');
        //记录
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code14().maximumOddBinaryNumber("0101"));
    }

}
