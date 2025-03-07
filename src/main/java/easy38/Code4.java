package easy38;

/**
 * @Author ayl
 * @Date 2024-08-19
 * 3258. 统计满足 K 约束的子字符串数量 I
 * 简单
 * 相关企业
 * 提示
 * 给你一个 二进制 字符串 s 和一个整数 k。
 * <p>
 * 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：
 * <p>
 * 字符串中 0 的数量最多为 k。
 * 字符串中 1 的数量最多为 k。
 * 返回一个整数，表示 s 的所有满足 k 约束 的
 * 子字符串
 * 的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "10101", k = 1
 * <p>
 * 输出：12
 * <p>
 * 解释：
 * <p>
 * s 的所有子字符串中，除了 "1010"、"10101" 和 "0101" 外，其余子字符串都满足 k 约束。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "1010101", k = 2
 * <p>
 * 输出：25
 * <p>
 * 解释：
 * <p>
 * s 的所有子字符串中，除了长度大于 5 的子字符串外，其余子字符串都满足 k 约束。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "11111", k = 1
 * <p>
 * 输出：15
 * <p>
 * 解释：
 * <p>
 * s 的所有子字符串都满足 k 约束。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 50
 * 1 <= k <= s.length
 * s[i] 是 '0' 或 '1'。
 */
public class Code4 {

    public int countKConstraintSubstrings(String s, int k) {
        //结果数量
        int count = 0;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //两种情况的数量
            int zero = 0;
            int one = 0;
            //循环
            for (int j = i; j < s.length(); j++) {
                //判断并计算当前
                if (s.charAt(j) == '0') {
                    //+1
                    zero++;
                } else {
                    //+1
                    one++;
                }
                //如果不满足了
                if (zero > k && one > k) {
                    //跳出
                    break;
                }
                //+1
                count++;
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().countKConstraintSubstrings("1010101",2));
    }

}
