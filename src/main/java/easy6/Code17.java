package easy6;

/**
 * Created By Rock-Ayl on 2021-02-15
 * 面试题 08.01. 三步问题
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 * <p>
 * 示例1:
 * <p>
 * 输入：n = 3
 * 输出：4
 * 说明: 有四种走法
 * 示例2:
 * <p>
 * 输入：n = 5
 * 输出：13
 * 提示:
 * <p>
 * n范围在[1, 1000000]之间
 */
public class Code17 {

    public static int arrangeCoins(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        //初始化前三个
        int a = 1, b = 2, c = 4;
        //循环
        while (n > 3) {
            //计算c
            int x = c;
            //计算
            c = ((a + b) % 1000000007 + c) % 1000000007;
            a = b;
            b = x;
            //更新
            n--;
        }
        //返回
        return c;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
    }
}
