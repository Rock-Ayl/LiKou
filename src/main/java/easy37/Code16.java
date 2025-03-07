package easy37;

/**
 * @Author ayl
 * @Date 2024-06-26
 * 2427. 公因子的数目
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个正整数 a 和 b ，返回 a 和 b 的 公 因子的数目。
 * <p>
 * 如果 x 可以同时整除 a 和 b ，则认为 x 是 a 和 b 的一个 公因子 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 12, b = 6
 * 输出：4
 * 解释：12 和 6 的公因子是 1、2、3、6 。
 * 示例 2：
 * <p>
 * 输入：a = 25, b = 30
 * 输出：2
 * 解释：25 和 30 的公因子是 1、5 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= a, b <= 1000
 */
public class Code16 {

    public int commonFactors(int a, int b) {
        //循环
        int big = Math.max(a, b);
        //结果
        int result = 0;
        //循环,从1开始
        for (int i = 1; i <= big; i++) {
            //如果满足
            if (a % i == 0 && b % i == 0) {
                //+1
                ++result;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code16().commonFactors(12, 6));
    }

}
