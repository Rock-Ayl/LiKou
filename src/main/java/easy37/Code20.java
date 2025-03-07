package easy37;

/**
 * @Author ayl
 * @Date 2024-07-15
 * 3216. 交换后字典序最小的字符串
 * 简单
 * 相关企业
 * 提示
 * 给你一个仅由数字组成的字符串 s，在最多交换一次 相邻 且具有相同 奇偶性 的数字后，返回可以得到的
 * 字典序最小的字符串
 * 。
 * <p>
 * 如果两个数字都是奇数或都是偶数，则它们具有相同的奇偶性。例如，5 和 9、2 和 4 奇偶性相同，而 6 和 9 奇偶性不同。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "45320"
 * <p>
 * 输出： "43520"
 * <p>
 * 解释：
 * <p>
 * s[1] == '5' 和 s[2] == '3' 都具有相同的奇偶性，交换它们可以得到字典序最小的字符串。
 * <p>
 * 示例 2：
 * <p>
 * 输入： s = "001"
 * <p>
 * 输出： "001"
 * <p>
 * 解释：
 * <p>
 * 无需进行交换，因为 s 已经是字典序最小的。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= s.length <= 100
 * s 仅由数字组成。
 */
public class Code20 {

    public String getSmallestString(String s) {
        //循环
        for (int i = 1; i < s.length(); i++) {
            //获取左右字符
            char left = s.charAt(i - 1);
            char right = s.charAt(i);
            //如果不可以交换
            if (left <= right) {
                //本轮过
                continue;
            }
            //如果奇偶不同
            if (left % 2 != right % 2) {
                //本轮过
                continue;
            }
            //初始化结果
            StringBuilder str = new StringBuilder(s);
            //交换
            str.setCharAt(i, left);
            str.setCharAt(i - 1, right);
            //返回
            return str.toString();
        }
        //默认
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Code20().getSmallestString("45320"));
    }

}
