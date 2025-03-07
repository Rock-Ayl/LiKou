package normal35;

/**
 * @Author ayl
 * @Date 2024-09-27
 * 3084. 统计以给定字符开头和结尾的子字符串总数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s 和一个字符 c 。返回在字符串 s 中并且以 c 字符开头和结尾的
 * 非空子字符串
 * 的总数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abada", c = "a"
 * <p>
 * 输出：6
 * <p>
 * 解释：以 "a" 开头和结尾的子字符串有： "abada"、"abada"、"abada"、"abada"、"abada"、"abada"。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "zzz", c = "z"
 * <p>
 * 输出：6
 * <p>
 * 解释：字符串 s 中总共有 6 个子字符串，并且它们都以 "z" 开头和结尾。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 和 c 均由小写英文字母组成。
 */
public class Code14 {

    public long countSubstrings(String s, char c) {
        //有多少个目标值
        long right = 0L;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //判断是否为目标值,如果是+1
            right += s.charAt(i) == c ? 1 : 0;
        }
        //高斯算法,计算出本次结果
        return (right + 1) * (right / 2) + (right % 2 == 0 ? 0 : (right + 1) / 2);
    }

    public static void main(String[] args) {
        System.out.println(new Code14().countSubstrings("abada", 'a'));
    }

}
