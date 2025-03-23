package easy40;

/**
 * @Author ayl
 * @Date 2025-03-23
 * 3492. 船上可以装载的最大集装箱数量
 * 简单
 * 相关企业
 * 提示
 * 给你一个正整数 n，表示船上的一个 n x n 的货物甲板。甲板上的每个单元格可以装载一个重量 恰好 为 w 的集装箱。
 * <p>
 * 然而，如果将所有集装箱装载到甲板上，其总重量不能超过船的最大承载重量 maxWeight。
 * <p>
 * 请返回可以装载到船上的 最大 集装箱数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 2, w = 3, maxWeight = 15
 * <p>
 * 输出： 4
 * <p>
 * 解释：
 * <p>
 * 甲板有 4 个单元格，每个集装箱的重量为 3。将所有集装箱装载后，总重量为 12，未超过 maxWeight。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 3, w = 5, maxWeight = 20
 * <p>
 * 输出： 4
 * <p>
 * 解释：
 * <p>
 * 甲板有 9 个单元格，每个集装箱的重量为 5。可以装载的最大集装箱数量为 4，此时总重量不超过 maxWeight。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * 1 <= w <= 1000
 * 1 <= maxWeight <= 109
 */
public class Code9 {

    public int maxContainers(int n, int w, int maxWeight) {
        //返回
        return Math.min(n * n, maxWeight / w);
    }

    public static void main(String[] args) {
        System.out.println(new Code9().maxContainers(2, 3, 15));
    }

}
