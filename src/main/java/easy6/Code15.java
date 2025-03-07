package easy6;

/**
 * Created By Rock-Ayl on 2021-02-12
 * 509. 斐波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 示例 3：
 * <p>
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 30
 */
public class Code15 {

    public static int fib(int N) {
        //判空
        if (N < 2) {
            return N;
        }
        //初始化
        int a = 0, b = 1;
        //如果没到结尾
        while (N != 1) {
            //计算当前
            int c = a + b;
            //更新
            a = b;
            b = c;
            //递减
            N--;
        }
        //返回//判空
        //        if (N < 2) {
        //            return N;
        //        }
        //        //初始化
        //        int a = 0, b = 1;
        //        //如果没到结尾
        //        while (N != 1) {
        //            //计算当前
        //            int c = a + b;
        //            //更新
        //            a = b;
        //            b = c;
        //            //递减
        //            N--;
        //        }
        //        //返回
        //        return b;
        return b;
    }

    public static void main(String[] args) {
        System.out.println(fib(4));
    }
}
