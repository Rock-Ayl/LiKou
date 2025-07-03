package normal44;

/**
 * @Author ayl
 * @Date 2025-07-03
 * 2745. 构造最长的新字符串
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你三个整数 x ，y 和 z 。
 * <p>
 * 这三个整数表示你有 x 个 "AA" 字符串，y 个 "BB" 字符串，和 z 个 "AB" 字符串。你需要选择这些字符串中的部分字符串（可以全部选择也可以一个都不选择），将它们按顺序连接得到一个新的字符串。新字符串不能包含子字符串 "AAA" 或者 "BBB" 。
 * <p>
 * 请你返回 新字符串的最大可能长度。
 * <p>
 * 子字符串 是一个字符串中一段连续 非空 的字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2, y = 5, z = 1
 * 输出：12
 * 解释： 我们可以按顺序连接 "BB" ，"AA" ，"BB" ，"AA" ，"BB" 和 "AB" ，得到新字符串 "BBAABBAABBAB" 。
 * 字符串长度为 12 ，无法得到一个更长的符合题目要求的字符串。
 * 示例 2：
 * <p>
 * 输入：x = 3, y = 2, z = 2
 * 输出：14
 * 解释：我们可以按顺序连接 "AB" ，"AB" ，"AA" ，"BB" ，"AA" ，"BB" 和 "AA" ，得到新字符串 "ABABAABBAABBAA" 。
 * 字符串长度为 14 ，无法得到一个更长的符合题目要求的字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= x, y, z <= 50
 */
public class Code15 {

    public int longestString(int x, int y, int z) {
        //数量
        int result = 0;
        //如果有x
        if (x > 0) {
            //如果y管够跟x兑
            if (y + 1 >= x) {
                //一共使用多少x
                int count = x;
                //删除x,y
                x = 0;
                y = y - (count - 1);
                //叠加次数
                result += (count + count - 1) * 2;
            }
            //y不够兑的
            else {
                //一共使用多少y
                int count = y;
                //删除x,y
                x = x - count - 1;
                y = 0;
                //叠加次数
                result += (count + count + 1) * 2;
            }
        }
        //y 还可以 前后各补一个,z可以无限自己叠加
        return result + Math.min(y, 2) * 2 + z * 2;
    }

    public static void main(String[] args) {
        // x = aa
        // y = bb
        // z = ab
        // 不能连续3个
        // x 接 y
        // y 接 x,z
        // z 接 x,z
        System.out.println(new Code15().longestString(2, 5, 1));
    }

}