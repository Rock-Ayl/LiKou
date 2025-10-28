package normal47;

/**
 * @Author ayl
 * @Date 2025-10-28
 * 3657. 寻找忠实客户
 * 已解答
 * 算术评级: 4
 *  同步题目状态
 *
 * 中等
 * premium lock icon
 * 相关企业
 * SQL Schema
 * Pandas Schema
 * 表：customer_transactions
 *
 * +------------------+---------+
 * | Column Name      | Type    |
 * +------------------+---------+
 * | transaction_id   | int     |
 * | customer_id      | int     |
 * | transaction_date | date    |
 * | amount           | decimal |
 * | transaction_type | varchar |
 * +------------------+---------+
 * transaction_id 是这张表的唯一主键。
 * transaction_type 可以是 “purchase” 或 “refund”。
 * 编写一个解决方案来查找 忠实客户。如果满足下述所有条件，可以认为该客户是 忠实 客户：
 *
 * 进行了 至少 3 次购买交易。
 * 活跃了 至少 30 天。
 * 他们的 退款率 少于 20%。
 * 退款率是退款交易占交易总数（购买加退款）的比例，计算公式为退款交易数量除以总交易数量。
 *
 * 返回结果表以 customer_id 升序 排序。
 *
 * 结果格式如下所示。
 *
 *
 *
 * 示例：
 *
 * 输入：
 *
 * customer_transactions 表：
 *
 * +----------------+-------------+------------------+--------+------------------+
 * | transaction_id | customer_id | transaction_date | amount | transaction_type |
 * +----------------+-------------+------------------+--------+------------------+
 * | 1              | 101         | 2024-01-05       | 150.00 | purchase         |
 * | 2              | 101         | 2024-01-15       | 200.00 | purchase         |
 * | 3              | 101         | 2024-02-10       | 180.00 | purchase         |
 * | 4              | 101         | 2024-02-20       | 250.00 | purchase         |
 * | 5              | 102         | 2024-01-10       | 100.00 | purchase         |
 * | 6              | 102         | 2024-01-12       | 120.00 | purchase         |
 * | 7              | 102         | 2024-01-15       | 80.00  | refund           |
 * | 8              | 102         | 2024-01-18       | 90.00  | refund           |
 * | 9              | 102         | 2024-02-15       | 130.00 | purchase         |
 * | 10             | 103         | 2024-01-01       | 500.00 | purchase         |
 * | 11             | 103         | 2024-01-02       | 450.00 | purchase         |
 * | 12             | 103         | 2024-01-03       | 400.00 | purchase         |
 * | 13             | 104         | 2024-01-01       | 200.00 | purchase         |
 * | 14             | 104         | 2024-02-01       | 250.00 | purchase         |
 * | 15             | 104         | 2024-02-15       | 300.00 | purchase         |
 * | 16             | 104         | 2024-03-01       | 350.00 | purchase         |
 * | 17             | 104         | 2024-03-10       | 280.00 | purchase         |
 * | 18             | 104         | 2024-03-15       | 100.00 | refund           |
 * +----------------+-------------+------------------+--------+------------------+
 * 输出：
 *
 * +-------------+
 * | customer_id |
 * +-------------+
 * | 101         |
 * | 104         |
 * +-------------+
 * 解释：
 *
 * 客户 101:
 * 购买交易：4 (IDs: 1, 2, 3, 4)
 * 退款交易：0
 * 退款率：0/4 = 0%（少于 20%）
 * 活跃时期：1 月 5 日到 2 月 20 日 = 46 天（至少 30 天）
 * 符合忠诚客户条件
 * 客户 102:
 * 购买交易：3 (IDs: 5, 6, 9)
 * 退款交易：2 (IDs: 7, 8)
 * 退款率：2/5 = 40% (超过 20%)
 * 不符合忠诚客户条件
 * 客户 103:
 * 购买交易：3 (IDs: 10, 11, 12)
 * 退款交易：0
 * 退款率：0/3 = 0%（少于 20%）
 * 活跃时期：1 月 1 日到 1 月 3 日 = 2 天（少于 30 天）
 * 不符合忠诚客户条件
 * 客户 104:
 * 购买交易：5 (IDs: 13, 14, 15, 16, 17)
 * 退款交易：1 (ID: 18)
 * 退款率：1/6 = 16.67%（少于 20%）
 * 活跃时期：1 月 1 日到 3 月 15 日 = 73 天（至少 30 天）
 * 符合忠诚客户条件
 * 结果表以 customer_id 升序排序。
 */
public class Code13 {

    private String sql="SELECT DISTINCT customer_id FROM customer_transactions WHERE customer_id IN( SELECT a.customer_id FROM ( SELECT customer_id, SUM( IF ( transaction_type = 'purchase', 1, 0)) AS pay_count FROM customer_transactions GROUP BY customer_id ) a WHERE a.pay_count >= 3 ) AND customer_id IN ( SELECT a.customer_id FROM ( SELECT a.customer_id, DATEDIFF( a.max_date, a.min_date ) AS day_count FROM ( SELECT customer_id, MIN( transaction_date ) AS min_date, MAX( transaction_date ) AS max_date FROM customer_transactions GROUP BY customer_id ) a ) a WHERE a.day_count >= 30 ) AND customer_id IN ( SELECT a.customer_id FROM ( SELECT a.customer_id, ( a.refund_count / a.all_count ) AS refund_ratio FROM ( SELECT customer_id, count(*) AS all_count, SUM( IF ( transaction_type = 'refund', 1, 0 )) AS refund_count FROM customer_transactions GROUP BY customer_id ) a ) a WHERE a.refund_ratio < 0.2)";

}
