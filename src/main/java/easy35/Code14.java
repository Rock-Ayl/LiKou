package easy35;

/**
 * @Author ayl
 * @Date 2024-01-01
 * 2937. 使三个字符串相等
 * 提示
 * 简单
 * 9
 * 相关企业
 * 给你三个字符串 s1、s2 和 s3。 你可以根据需要对这三个字符串执行以下操作 任意次数 。
 * <p>
 * 在每次操作中，你可以选择其中一个长度至少为 2 的字符串 并删除其 最右位置上 的字符。
 * <p>
 * 如果存在某种方法能够使这三个字符串相等，请返回使它们相等所需的 最小 操作次数；否则，返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "abc"，s2 = "abb"，s3 = "ab"
 * 输出：2
 * 解释：对 s1 和 s2 进行一次操作后，可以得到三个相等的字符串。
 * 可以证明，不可能用少于两次操作使它们相等。
 * 示例 2：
 * <p>
 * 输入：s1 = "dac"，s2 = "bac"，s3 = "cac"
 * 输出：-1
 * 解释：因为 s1 和 s2 的最左位置上的字母不相等，所以无论进行多少次操作，它们都不可能相等。因此答案是 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s1.length, s2.length, s3.length <= 100
 * s1、s2 和 s3 仅由小写英文字母组成。
 */
public class Code14 {

    public int findMinimumOperations(String s1, String s2, String s3) {
        //最小长度
        int min = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        //指针
        int p = -1;
        //循环
        while (p < min - 1) {
            //如果不满足
            if (s1.charAt(p + 1) != s2.charAt(p + 1) || s2.charAt(p + 1) != s3.charAt(p + 1)) {
                //跳出
                break;
            }
            //进位
            p++;
        }
        //如果没有
        if (p == -1) {
            //过
            return -1;
        }
        //返回
        return (s1.length() + s2.length() + s3.length()) - ((p + 1) * 3);
    }

    public static void main(String[] args) {
        System.out.println(new Code14().findMinimumOperations("abc", "abb", "ab"));
    }

}
