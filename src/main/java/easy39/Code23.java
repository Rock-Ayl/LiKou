package easy39;

/**
 * @Author ayl
 * @Date 2025-03-05
 * 3461. 判断操作后字符串中的数字是否相等 I
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个由数字组成的字符串 s 。重复执行以下操作，直到字符串恰好包含 两个 数字：
 * <p>
 * 从第一个数字开始，对于 s 中的每一对连续数字，计算这两个数字的和 模 10。
 * 用计算得到的新数字依次替换 s 的每一个字符，并保持原本的顺序。
 * 如果 s 最后剩下的两个数字 相同 ，返回 true 。否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "3902"
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * 一开始，s = "3902"
 * 第一次操作：
 * (s[0] + s[1]) % 10 = (3 + 9) % 10 = 2
 * (s[1] + s[2]) % 10 = (9 + 0) % 10 = 9
 * (s[2] + s[3]) % 10 = (0 + 2) % 10 = 2
 * s 变为 "292"
 * 第二次操作：
 * (s[0] + s[1]) % 10 = (2 + 9) % 10 = 1
 * (s[1] + s[2]) % 10 = (9 + 2) % 10 = 1
 * s 变为 "11"
 * 由于 "11" 中的数字相同，输出为 true。
 * 示例 2：
 * <p>
 * 输入： s = "34789"
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * <p>
 * 一开始，s = "34789"。
 * 第一次操作后，s = "7157"。
 * 第二次操作后，s = "862"。
 * 第三次操作后，s = "48"。
 * 由于 '4' != '8'，输出为 false。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= s.length <= 100
 * s 仅由数字组成。
 */
public class Code23 {

    public boolean hasSameDigits(String s) {
        //字符串
        StringBuilder str = new StringBuilder();
        //循环
        for (int i = 1; i < s.length(); i++) {
            //组装本次
            str.append(((s.charAt(i) - '0') + (s.charAt(i - 1) - '0')) % 10);
        }
        //如果足够大
        if (str.length() > 2) {
            //下一步
            return hasSameDigits(str.toString());
        }
        //返回
        return str.charAt(0) == str.charAt(1);
    }

    public static void main(String[] args) {
        System.out.println(new Code23().hasSameDigits("3902"));
    }

}
