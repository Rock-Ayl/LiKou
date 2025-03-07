package normal34;

/**
 * @Author ayl
 * @Date 2024-09-02
 * 3271. 哈希分割字符串
 * 中等
 * 相关企业
 * 提示
 * 给你一个长度为 n 的字符串 s 和一个整数 k ，n 是 k 的 倍数 。你的任务是将字符串 s 哈希为一个长度为 n / k 的新字符串 result 。
 * <p>
 * 首先，将 s 分割成 n / k 个
 * 子字符串
 * ，每个子字符串的长度都为 k 。然后，将 result 初始化为一个 空 字符串。
 * <p>
 * 我们依次从前往后处理每一个 子字符串 ：
 * <p>
 * 一个字符的 哈希值 是它在 字母表 中的下标（也就是 'a' → 0 ，'b' → 1 ，... ，'z' → 25）。
 * 将子字符串中字幕的 哈希值 求和。
 * 将和对 26 取余，将结果记为 hashedChar 。
 * 找到小写字母表中 hashedChar 对应的字符。
 * 将该字符添加到 result 的末尾。
 * 返回 result 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", k = 2
 * <p>
 * 输出："bf"
 * <p>
 * 解释：
 * <p>
 * 第一个字符串为 "ab" ，0 + 1 = 1 ，1 % 26 = 1 ，result[0] = 'b' 。
 * <p>
 * 第二个字符串为： "cd" ，2 + 3 = 5 ，5 % 26 = 5 ，result[1] = 'f' 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "mxz", k = 3
 * <p>
 * 输出："i"
 * <p>
 * 解释：
 * <p>
 * 唯一的子字符串为 "mxz" ，12 + 23 + 25 = 60 ，60 % 26 = 8 ，result[0] = 'i' 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 100
 * k <= s.length <= 1000
 * s.length 能被 k 整除。
 * s 只含有小写英文字母。
 */
public class Code21 {

    public String stringHash(String s, int k) {
        //初始化返回结果
        StringBuilder result = new StringBuilder();
        //循环1
        for (int i = 0; i < s.length(); i = i + k) {
            //和
            int sum = 0;
            //循环2
            for (int j = i; j < i + k; j++) {
                //叠加本次
                sum += s.charAt(j) - 'a';
            }
            //去除无用,并加回来,组装本次结果
            result.append((char) ((sum % 26) + 'a'));
        }
        //返回最终结果
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code21().stringHash("abcd", 2));
    }
}
