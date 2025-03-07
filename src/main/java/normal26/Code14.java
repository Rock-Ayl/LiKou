package normal26;

/**
 * @Author ayl
 * @Date 2023-12-02
 * 2240. 买钢笔和铅笔的方案数
 * 提示
 * 中等
 * 90
 * 相关企业
 * 给你一个整数 total ，表示你拥有的总钱数。同时给你两个整数 cost1 和 cost2 ，分别表示一支钢笔和一支铅笔的价格。你可以花费你部分或者全部的钱，去买任意数目的两种笔。
 * <p>
 * 请你返回购买钢笔和铅笔的 不同方案数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：total = 20, cost1 = 10, cost2 = 5
 * 输出：9
 * 解释：一支钢笔的价格为 10 ，一支铅笔的价格为 5 。
 * - 如果你买 0 支钢笔，那么你可以买 0 ，1 ，2 ，3 或者 4 支铅笔。
 * - 如果你买 1 支钢笔，那么你可以买 0 ，1 或者 2 支铅笔。
 * - 如果你买 2 支钢笔，那么你没法买任何铅笔。
 * 所以买钢笔和铅笔的总方案数为 5 + 3 + 1 = 9 种。
 * 示例 2：
 * <p>
 * 输入：total = 5, cost1 = 10, cost2 = 10
 * 输出：1
 * 解释：钢笔和铅笔的价格都为 10 ，都比拥有的钱数多，所以你没法购买任何文具。所以只有 1 种方案：买 0 支钢笔和 0 支铅笔。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= total, cost1, cost2 <= 106
 */
public class Code14 {

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        //对比大小
        int big = Math.max(cost1, cost2);
        int small = Math.min(cost1, cost2);
        //结果
        long count = 0L;
        //大的数量
        int bigCount = -1;
        //如果未越界
        while (++bigCount * big <= total) {
            //计算本次数量
            count += (total - bigCount * big) / small + 1;
        }
        //返回
        return count;
    }

    //背包问题
    public long starr(int total, int cost1, int cost2) {
        //dp[i]表示：总数为 i 的金额，能够购买的最多方案数为 dp[i]
        long[] result = new long[total + 1];


        for (int i = cost1; i <= total; i++) {
            result[i] += result[i - cost1] + 1;
        }

        System.out.println();

        for (int i = cost2; i <= total; i++) {
            result[i] += result[i - cost2] + 1;
        }


        //没法购买也算一种方案，需要加上 1
        return result[total] + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Code14().starr(10, 2, 5));
    }

}
