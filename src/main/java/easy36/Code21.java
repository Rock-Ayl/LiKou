package easy36;

/**
 * @Author ayl
 * @Date 2024-04-14
 * 100270. 字符串的分数
 * 简单
 * 相关企业
 * 提示
 * 给你一个字符串 s 。一个字符串的 分数 定义为相邻字符 ASCII 码差值绝对值的和。
 * <p>
 * 请你返回 s 的 分数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "hello"
 * <p>
 * 输出：13
 * <p>
 * 解释：
 * <p>
 * s 中字符的 ASCII 码分别为：'h' = 104 ，'e' = 101 ，'l' = 108 ，'o' = 111 。所以 s 的分数为 |104 - 101| + |101 - 108| + |108 - 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "zaz"
 * <p>
 * 输出：50
 * <p>
 * 解释：
 * <p>
 * s 中字符的 ASCII 码分别为：'z' = 122 ，'a' = 97 。所以 s 的分数为 |122 - 97| + |97 - 122| = 25 + 25 = 50 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= s.length <= 100
 * s 只包含小写英文字母。
 */
public class Code21 {

    public int scoreOfString(String s) {
        //结果
        int sum = 0;
        //循环
        for (int i = 1; i < s.length(); i++) {
            //计算并叠加
            sum += Math.abs(s.charAt(i - 1) - s.charAt(i));
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code21().scoreOfString("hello"));
    }

}
