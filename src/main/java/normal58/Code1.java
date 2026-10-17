package normal58;

/**
 * 1573. 分割字符串的方案数
 * 算术评级: 4
 * 第 34 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1591
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个二进制串 s  （一个只包含 0 和 1 的字符串），我们可以将 s 分割成 3 个 非空 字符串 s1, s2, s3 （s1 + s2 + s3 = s）。
 * <p>
 * 请你返回分割 s 的方案数，满足 s1，s2 和 s3 中字符 '1' 的数目相同。
 * <p>
 * 由于答案可能很大，请将它对 10^9 + 7 取余后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "10101"
 * 输出：4
 * 解释：总共有 4 种方法将 s 分割成含有 '1' 数目相同的三个子字符串。
 * "1|010|1"
 * "1|01|01"
 * "10|10|1"
 * "10|1|01"
 * 示例 2：
 * <p>
 * 输入：s = "1001"
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：s = "0000"
 * 输出：3
 * 解释：总共有 3 种分割 s 的方法。
 * "0|0|00"
 * "0|00|0"
 * "00|0|0"
 * 示例 4：
 * <p>
 * 输入：s = "100100010100110"
 * 输出：12
 * <p>
 * <p>
 * 提示：
 * <p>
 * s[i] == '0' 或者 s[i] == '1'
 * 3 <= s.length <= 10^5
 */
public class Code1 {

    public int numWays(String s) {

        /**
         * 统计全局
         */

        //1的数量
        int oneCount = 0;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //叠加1的数量
            oneCount += s.charAt(i) == '1' ? 1 : 0;
        }
        //特殊情况
        if (oneCount == 0) {
            //长度
            long length = s.length() - 1L;
            //高斯算法
            return (int) (length * (length - 1) / 2 % 1000000007L);
        }
        //如果没办法分割
        if (oneCount % 3 != 0) {
            //返回
            return 0;
        }

        /**
         * 计算第一部分
         */

        //每个部分的数量1的数量
        int partCount = oneCount / 3;
        //第一部分1的数量
        int firstPartOneCount = 0;
        //索引
        int index = 0;
        //如果不够
        while (firstPartOneCount != partCount) {
            //叠加1的数量,索引+1
            firstPartOneCount += s.charAt(index++) == '1' ? 1 : 0;
        }
        //第一部分的情况
        long firstCount = 1L;
        //如果是0
        while (s.charAt(index) == '0') {
            //+1
            index++;
            firstCount++;
        }

        /**
         * 计算第二部分
         */

        //第二部分1的数量
        int secondPartOneCount = 0;
        //如果不够
        while (secondPartOneCount != partCount) {
            //叠加1的数量,索引+1
            secondPartOneCount += s.charAt(index++) == '1' ? 1 : 0;
        }
        //第二部分的情况
        long secondCount = 1L;
        //如果是0
        while (s.charAt(index) == '0') {
            //+1
            index++;
            secondCount++;
        }

        /**
         * 结果
         */

        //返回
        return (int) (firstCount * secondCount % 1000000007L);
    }

    public static void main(String[] args) {
        //
        System.out.println(new Code1().numWays("100100010100110"));
    }

}
