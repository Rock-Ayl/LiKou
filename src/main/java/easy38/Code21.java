package easy38;

/**
 * @Author ayl
 * @Date 2024-11-04
 * 3340. 检查平衡字符串
 * 简单
 * 相关企业
 * 给你一个仅由数字 0 - 9 组成的字符串 num。如果偶数下标处的数字之和等于奇数下标处的数字之和，则认为该数字字符串是一个 平衡字符串。
 * <p>
 * 如果 num 是一个 平衡字符串，则返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = "1234"
 * <p>
 * 输出：false
 * <p>
 * 解释：
 * <p>
 * 偶数下标处的数字之和为 1 + 3 = 4，奇数下标处的数字之和为 2 + 4 = 6。
 * 由于 4 不等于 6，num 不是平衡字符串。
 * 示例 2：
 * <p>
 * 输入：num = "24123"
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * 偶数下标处的数字之和为 2 + 1 + 3 = 6，奇数下标处的数字之和为 4 + 2 = 6。
 * 由于两者相等，num 是平衡字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= num.length <= 100
 * num 仅由数字 0 - 9 组成。
 */
public class Code21 {

    public boolean isBalanced(String num) {
        //单双
        int singleSum = 0;
        int doubleSum = 0;
        //循环
        for (int i = 0; i < num.length(); i++) {
            //叠加
            singleSum += i % 2 != 0 ? num.charAt(i) - '0' : 0;
            doubleSum += i % 2 == 0 ? num.charAt(i) - '0' : 0;
        }
        //返回
        return singleSum == doubleSum;
    }

    public static void main(String[] args) {
        System.out.println(new Code21().isBalanced("24123"));
    }

}
