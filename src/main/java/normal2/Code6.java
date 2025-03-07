package normal2;

/**
 * Created By Rock-Ayl on 2021-04-07
 * 397. 整数替换
 * 给定一个正整数 n ，你可以做如下操作：
 * <p>
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 231 - 1
 */
public class Code6 {

    public static int integerReplacement(int n) {
        //如果最大(越界)
        if (n == Integer.MAX_VALUE) {
            //直接返回
            return 32;
        }
        //次数
        int size = 0;
        //循环
        while (n != 1) {
            //首先补全
            if (n % 2 == 0) {
                //除以
                n = n / 2;
            } else if (n != 3 && (n + 1) % 4 == 0) {
                //递增
                n++;
            } else {
                //递减
                n--;
            }
            //记录
            size++;
        }
        //返回
        return size;
    }

    public static void main(String[] args) {
        System.out.println(integerReplacement(2147483647));
    }
}
