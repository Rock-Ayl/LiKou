package easy43;

/**
 * 3945. 计算数字频率得分
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n。
 * <p>
 * n 的 得分 定义为：对所有 不同 数字 d，计算 d * freq(d) 的总和，其中 freq(d) 表示数字 d 在 n 中出现的次数。
 * <p>
 * 返回一个整数，表示 n 的得分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 122
 * <p>
 * 输出： 5
 * <p>
 * 解释：
 * <p>
 * 数字 1 出现 1 次，贡献为 1 * 1 = 1。
 * 数字 2 出现 2 次，贡献为 2 * 2 = 4。
 * 因此，n 的得分为 1 + 4 = 5。
 * 示例 2：
 * <p>
 * 输入： n = 101
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 数字 0 出现 1 次，贡献为 0 * 1 = 0。
 * 数字 1 出现 2 次，贡献为 1 * 2 = 2。
 * 因此，n 的得分为 2。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 */
public class Code13 {

    public int digitFrequencyScore(int n) {
        //和
        int sum = 0;
        //循环
        while (n != 0) {
            //取最后一位,求和
            sum += n % 10;
            //下一个
            n /= 10;
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().digitFrequencyScore(122));
    }

}
