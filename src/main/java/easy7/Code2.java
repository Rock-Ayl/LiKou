package easy7;

/**
 * Created By Rock-Ayl on 2021-02-26
 * 342. 4的幂
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 16
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= n <= 231 - 1
 */
public class Code2 {

    public static boolean isPowerOfFour(int n) {
        //缺省
        if (n == 1) {
            return true;
        }
        //循环
        while (n > 4) {
            //如果能整除4
            if (n % 4 == 0) {
                //视为可能
                n = n / 4;
            } else {
                //直接不是
                return false;
            }
        }
        //如果是4
        if (n == 4) {
            //是
            return true;
        } else {
            //不是
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
    }
}
