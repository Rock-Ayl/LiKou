package easy41;

/**
 * @Author ayl
 * @Date 2025-10-16
 * 3707. 相等子字符串分数
 * 算术评级: 1
 * 第 167 场双周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1262
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个由小写英文字母组成的字符串 s。
 * <p>
 * 一个字符串的 得分 是其字符在字母表中的位置之和，其中 'a' = 1，'b' = 2，...，'z' = 26。
 * <p>
 * 请你判断是否存在一个下标 i，使得该字符串可以被拆分成两个 非空子字符串 s[0..i] 和 s[(i + 1)..(n - 1)]，且它们的得分 相等 。
 * <p>
 * 如果存在这样的拆分，则返回 true，否则返回 false。
 * <p>
 * 一个 子字符串 是字符串中 非空 的连续字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "adcb"
 * <p>
 * 输出: true
 * <p>
 * 解释:
 * <p>
 * 在下标 i = 1 处拆分：
 * <p>
 * 左子字符串 = s[0..1] = "ad"，得分 = 1 + 4 = 5
 * 右子字符串 = s[2..3] = "cb"，得分 = 3 + 2 = 5
 * 两个子字符串的得分相等，因此输出为 true。
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "bace"
 * <p>
 * 输出: false
 * <p>
 * 解释:​​​​​​
 * <p>
 * 没有拆分能产生相等的得分，因此输出为 false。
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * 2 <= s.length <= 100
 * s 由小写英文字母组成。
 */
public class Code19 {

    public boolean scoreBalance(String s) {
        //和
        int sum = -(s.length() * '`');
        //循环
        for (int i = 0; i < s.length(); i++) {
            //叠加
            sum += s.charAt(i);
        }
        //如果是奇数
        if (sum % 2 != 0) {
            //过
            return false;
        }
        //目标结果
        sum = sum / 2;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //减去
            sum -= (s.charAt(i) - '`');
            //如果是目标结果
            if (sum == 0) {
                //是
                return true;
            }
            //如果不可能
            if (sum < 0) {
                //过
                return false;
            }
        }
        //过
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code19().scoreBalance("adcb"));
    }

}
