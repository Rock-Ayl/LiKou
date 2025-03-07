package normal37;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author ayl
 * @Date 2024-11-14
 * 1680. 连接连续二进制数字
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数 n ，请你将 1 到 n 的二进制表示连接起来，并返回连接结果对应的 十进制 数字对 109 + 7 取余的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：1
 * 解释：二进制的 "1" 对应着十进制的 1 。
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：27
 * 解释：二进制下，1，2 和 3 分别对应 "1" ，"10" 和 "11" 。
 * 将它们依次连接，我们得到 "11011" ，对应着十进制的 27 。
 * 示例 3：
 * <p>
 * 输入：n = 12
 * 输出：505379714
 * 解释：连接结果为 "1101110010111011110001001101010111100" 。
 * 对应的十进制数字为 118505380540 。
 * 对 109 + 7 取余后，结果为 505379714 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 */
public class Code10 {

    public int concatenatedBinary(int n) {
        //和
        int sum = 1;
        //指针
        int p = 2;
        //循环
        while (p <= n) {
            //当前数字
            int num = p;
            //循环
            while (num >= 1) {
                //位移
                num = num >> 1;
                //位移并取余
                sum = (sum << 1) % 1000000007;
            }
            //叠加、取余、并进位
            sum = sum + p++ % 1000000007;
        }
        //返回
        return sum;
    }

    public int star(int n) {
        //结果
        int res = 0;
        //位移进位数
        int shift = 0;
        //循环
        for (int i = 1; i <= n; i++) {
            //如果是说明是2的幂
            if ((i & (i - 1)) == 0) {
                //进位+1
                shift++;
            }
            //位移
            res = (int) ((((long) res << shift) + i) % 1000000007);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(4 & 3);
        System.out.println(new Code10().star(12));
    }

}
