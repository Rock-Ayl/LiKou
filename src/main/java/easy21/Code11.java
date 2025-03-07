package easy21;

/**
 * @Author ayl
 * @Date 2022-07-22
 * 1221. 分割平衡字符串
 * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 * <p>
 * 给你一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 * <p>
 * 注意：分割得到的每个字符串都必须是平衡字符串，且分割得到的平衡字符串是原平衡字符串的连续子串。
 * <p>
 * 返回可以通过分割得到的平衡字符串的 最大数量 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL"、"RRLL"、"RL"、"RL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 * 示例 2：
 * <p>
 * 输入：s = "RLLLLRRRLR"
 * 输出：3
 * 解释：s 可以分割为 "RL"、"LLLRRR"、"LR" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 * 示例 3：
 * <p>
 * 输入：s = "LLLLRRRR"
 * 输出：1
 * 解释：s 只能保持原样 "LLLLRRRR".
 * 示例 4：
 * <p>
 * 输入：s = "RLRRRLLRLL"
 * 输出：2
 * 解释：s 可以分割为 "RL"、"RRRLLRLL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s[i] = 'L' 或 'R'
 * s 是一个 平衡 字符串
 */
public class Code11 {

    public int balancedStringSplit(String s) {
        //分割的数量
        int result = 0;
        //左边的
        Character left = null;
        //左边的数量
        int count = 0;
        //循环
        for (char letter : s.toCharArray()) {
            //如果是一个
            if (left == null) {
                //初始化
                left = letter;
                count = 1;
                //本轮过
                continue;
            }
            //如果和之前的一致
            if (left == letter) {
                //+1
                count++;
                //本轮过
                continue;
            }
            //-1
            count--;
            //如果彻底结束了
            if (count == 0) {
                //+1
                result++;
                //置空
                left = null;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code11().balancedStringSplit("RLLLLRRRLR"));
    }

}
