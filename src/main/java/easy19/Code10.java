package easy19;

/**
 * @Author ayl
 * @Date 2022-05-26
 * 2119. 反转两次的数字
 * 反转 一个整数意味着倒置它的所有位。
 * <p>
 * 例如，反转 2021 得到 1202 。反转 12300 得到 321 ，不保留前导零 。
 * 给你一个整数 num ，反转 num 得到 reversed1 ，接着反转 reversed1 得到 reversed2 。如果 reversed2 等于 num ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 526
 * 输出：true
 * 解释：反转 num 得到 625 ，接着反转 625 得到 526 ，等于 num 。
 * 示例 2：
 * <p>
 * 输入：num = 1800
 * 输出：false
 * 解释：反转 num 得到 81 ，接着反转 81 得到 18 ，不等于 num 。
 * 示例 3：
 * <p>
 * 输入：num = 0
 * 输出：true
 * 解释：反转 num 得到 0 ，接着反转 0 得到 0 ，等于 num 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= num <= 106
 */
public class Code10 {

    public boolean isSameAfterReversals(int num) {
        //如果是10以上 并且最后一位是0
        if (num % 10 == 0 && num > 9) {
            //不是
            return false;
        }
        //是
        return true;
    }

}
