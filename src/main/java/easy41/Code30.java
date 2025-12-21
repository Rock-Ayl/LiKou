package easy41;

/**
 * @Author ayl
 * @Date 2025-12-21
 * 100942. 整数的镜像距离
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n。
 * <p>
 * 定义它的 镜像距离 为：abs(n - reverse(n))​​​​​​​，其中 reverse(n) 表示将 n 的数字反转后形成的整数。
 * <p>
 * 返回表示 n 的镜像距离的整数。
 * <p>
 * 其中，abs(x) 表示 x 的绝对值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 25
 * <p>
 * 输出： 27
 * <p>
 * 解释：
 * <p>
 * reverse(25) = 52。
 * 因此，答案为 abs(25 - 52) = 27。
 * 示例 2：
 * <p>
 * 输入： n = 10
 * <p>
 * 输出： 9
 * <p>
 * 解释：
 * <p>
 * reverse(10) = 01，即 1。
 * 因此，答案为 abs(10 - 1) = 9。
 * 示例 3：
 * <p>
 * 输入： n = 7
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * reverse(7) = 7。
 * 因此，答案为 abs(7 - 7) = 0。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 */
public class Code30 {

    public int mirrorDistance(int n) {
        //实现
        return Math.abs(n - reverse(n));
    }

    //翻转
    private int reverse(int num) {
        //返回
        int result = 0;
        //循环
        while (num > 9) {
            //叠加本次
            result = result * 10 + (num % 10);
            //下一个
            num = num / 10;
        }
        //收尾
        result = result * 10 + (num % 10);
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code30().mirrorDistance(25));
    }

}
