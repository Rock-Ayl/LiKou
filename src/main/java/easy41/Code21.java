package easy41;

/**
 * @Author ayl
 * @Date 2025-11-02
 * 3726. 移除十进制表示中的所有零
 * 算术评级: 2
 * 第 473 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1176
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个正整数n。
 * <p>
 * 返回一个整数，该整数是将 n 的十进制表示中所有的零都移除后得到的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 1020030
 * <p>
 * 输出： 123
 * <p>
 * 解释：
 * <p>
 * 从 1020030 中移除所有的零后，得到 123。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 1
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * 1 的十进制表示中没有零，因此结果为 1。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1015
 */
public class Code21 {

    public long removeZeros(long n) {
        //结果
        long result = 0L;
        //倍率
        long hit = 1L;
        //循环
        while (n > 9L) {
            //本次数字
            long num = n % 10L;
            //如果有内容
            if (num != 0L) {
                //叠加本次
                result += (num * hit);
                //倍率递增
                hit *= 10L;
            }
            //下一个
            n = n / 10L;
        }
        //结尾
        result = result + (n * hit);
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code21().removeZeros(1020030L));
    }

}
