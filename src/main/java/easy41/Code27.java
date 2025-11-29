package easy41;

/**
 * @Author ayl
 * @Date 2025-11-29
 * 3754. 连接非零数字并乘以其数字和 I
 * 算术评级: 2
 * 第 477 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1248
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n。
 * <p>
 * 将 n 中所有的 非零数字 按照它们的原始顺序连接起来，形成一个新的整数 x。如果不存在 非零数字 ，则 x = 0。
 * <p>
 * sum 为 x 中所有数字的 数字和 。
 * <p>
 * 返回一个整数，表示 x * sum 的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 10203004
 * <p>
 * 输出： 12340
 * <p>
 * 解释：
 * <p>
 * 非零数字是 1、2、3 和 4。因此，x = 1234。
 * 数字和为 sum = 1 + 2 + 3 + 4 = 10。
 * 因此，答案是 x * sum = 1234 * 10 = 12340。
 * 示例 2：
 * <p>
 * 输入： n = 1000
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * 非零数字是 1，因此 x = 1 且 sum = 1。
 * 因此，答案是 x * sum = 1 * 1 = 1。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 109
 */
public class Code27 {

    public long sumAndMultiply(int n) {
        //2个分片
        int left = 0;
        int right = 0;
        //数字
        int hit = 1;
        //循环
        while (n > 9) {
            //解析数字
            int number = n % 10;
            //如果有
            if (number > 0) {
                //分别计算
                left = left + number * hit;
                right += number;
                //下一个hit
                hit = hit * 10;
            }
            //下一个
            n = n / 10;
        }
        //收尾
        if (n > 0) {
            //分别计算
            left = left + n * hit;
            right += n;
        }
        //返回
        return (long) left * right;
    }

    public static void main(String[] args) {
        System.out.println(new Code27().sumAndMultiply(10203004));
    }

}
