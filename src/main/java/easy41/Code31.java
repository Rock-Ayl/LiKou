package normal49;

/**
 * @Author ayl
 * @Date 1/4/26
 * 3798. 最大的偶数
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个仅由字符'1'和'2'组成的字符串s。
 * <p>
 * 你可以删除字符串s中的任意数量的字符，但必须保持剩余字符的顺序不变。
 * <p>
 * 返回可以表示 偶数 整数的 最大结果字符串 。如果不存在这样的字符串，则返回空字符串""。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "1112"
 * <p>
 * 输出: "1112"
 * <p>
 * 解释:
 * <p>
 * 该字符串已经表示了最大的偶数，因此不需要删除任何字符。
 * <p>
 * 示例 2：
 * <p>
 * 输入: s = "221"
 * <p>
 * 输出: "22"
 * <p>
 * 解释:
 * <p>
 * 删除'1'后，可以得到最大的偶数，即 22。
 * <p>
 * 示例 3：
 * <p>
 * 输入: s = "1"
 * <p>
 * 输出: ""
 * <p>
 * 解释:
 * <p>
 * 无法通过删除字符得到偶数。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 仅由字符 '1' 和 '2' 组成。
 */
public class Code31 {

    public String largestEven(String s) {
        //最后一个偶数索引,返回
        return s.substring(0, s.lastIndexOf('2') + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Code31().largestEven("111211111"));
    }

}
