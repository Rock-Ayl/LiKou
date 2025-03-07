package normal;

/**
 * Created By Rock-Ayl on 2020-08-03
 * 面试题 08.05. 递归乘法
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 * <p>
 * 示例1:
 * <p>
 * 输入：A = 1, B = 10
 * 输出：10
 * 示例2:
 * <p>
 * 输入：A = 3, B = 4
 * 输出：12
 * 提示:
 * <p>
 * 保证乘法范围不会溢出
 */
public class Code2 {

    public static int multiply(int A, int B) {
        //判0
        if (A == 0 || B == 0) {
            return 0;
        }
        //记录A、B
        int c;
        int d;
        //选一个小一点的数做循环,[隔墙][狗头]一点
        if (A > B) {
            c = B;
            d = A;
        } else {
            c = A;
            d = B;
        }
        //和
        int sum = 0;
        //循环
        while (c > 0) {
            //叠加
            sum = sum + d;
            //次数-1
            c--;
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(multiply(14, 14));
    }
}
