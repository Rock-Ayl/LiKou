package easy43;

/**
 * 3931. 检查相邻数字差
 * 算术评级: 1
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个由数字组成的字符串 s。
 * <p>
 * 如果每一对 相邻 数字之间的 绝对差 都至多为 2，则返回 true；否则返回 false。
 * <p>
 * a 和 b 之间的绝对差定义为 abs(a - b)。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "132"
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * s[0] 和 s[1] 处数字的绝对差为 abs(1 - 3) = 2。
 * s[1] 和 s[2] 处数字的绝对差为 abs(3 - 2) = 1。
 * 由于两个差值都至多为 2，因此答案为 true。
 * 示例 2：
 * <p>
 * 输入： s = "129"
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * <p>
 * s[0] 和 s[1] 处数字的绝对差为 abs(1 - 2) = 1。
 * s[1] 和 s[2] 处数字的绝对差为 abs(2 - 9) = 7，大于 2。
 * 因此，答案为 false。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= s.length <= 100
 * s 仅由数字组成。
 */
public class Code11 {

    public boolean isAdjacentDiffAtMostTwo(String s) {
        //循环
        for (int i = 1; i < s.length(); i++) {
            //如果不是
            if (Math.abs(s.charAt(i) - s.charAt(i - 1)) > 2) {
                //不是
                return false;
            }
        }
        //默认是
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code11().isAdjacentDiffAtMostTwo("132"));
    }

}
