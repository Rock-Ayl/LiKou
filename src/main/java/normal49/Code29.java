package normal49;

/**
 * 3648. 覆盖网格的最少传感器数目
 * 算术评级: 3
 * 第 163 场双周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1396
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 n × m 的网格和一个整数 k。
 * <p>
 * 一个放置在单元格 (r, c) 的传感器可以覆盖所有与 (r, c) 的 切比雪夫距离不超过 k 的单元格。
 * <p>
 * 两个单元格 (r1, c1) 和 (r2, c2) 之间的 切比雪夫距离 为 max(|r1 − r2|,|c1 − c2|)。
 * <p>
 * 你的任务是返回覆盖整个网格所需传感器的 最少 数量。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 5, m = 5, k = 1
 * <p>
 * 输出: 4
 * <p>
 * 解释:
 * <p>
 * 在位置 (0, 3)、(1, 0)、(3, 3) 和 (4, 1) 放置传感器可以确保网格中的每个单元格都被覆盖。因此，答案是 4。
 * <p>
 * 示例 2:
 * <p>
 * 输入: n = 2, m = 2, k = 2
 * <p>
 * 输出: 1
 * <p>
 * 解释:
 * <p>
 * 当 k = 2 时，无论传感器放在哪个位置，单个传感器都可以覆盖整个 2 * 2 的网格。因此，答案是 1。
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 103
 * 1 <= m <= 103
 * 0 <= k <= 103
 */
public class Code29 {

    public int minSensors(int n, int m, int k) {
        //计算一个传感器最大长度
        int length = k * 2 + 1;
        //分别计算横纵的数量
        int nCount = n / length + (n % length > 0 ? 1 : 0);
        int mCount = m / length + (m % length > 0 ? 1 : 0);
        //返回
        return nCount * mCount;
    }

    public static void main(String[] args) {
        System.out.println(new Code29().minSensors(5, 5, 1));
    }

}
