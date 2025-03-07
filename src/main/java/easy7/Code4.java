package easy7;

/**
 * Created By Rock-Ayl on 2021-02-28
 * 9. 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 * <p>
 * 输入：x = -101
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 * <p>
 * <p>
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 */
public class Code4 {

    public static boolean isPalindrome(int x) {
        //如果是负数
        if (x < 0) {
            //肯定不是
            return false;
        }
        //如果是0
        if (x == 0) {
            //是
            return true;
        }
        //如果最后一位为0
        if (x % 10 == 0) {
            return false;
        }
        //如果10以内
        if (x < 10) {
            //是
            return true;
        }
        //初始化转化
        int y = 0;
        //记录
        int xx = x;
        //循环
        while (x > 0) {
            //除
            int num = x % 10;
            //叠加
            y = y * 10 + num;
            //更新
            x = x / 10;
        }
        //如果相同
        if (xx == y) {
            //是
            return true;
        } else {
            //不是
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
