package normal47;

/**
 * @Author ayl
 * @Date 2025-10-29
 * 3705. 寻找黄金时段客户
 * 已解答
 * 算术评级: 5
 *  同步题目状态
 *
 * 中等
 * premium lock icon
 * 相关企业
 * SQL Schema
 * Pandas Schema
 * 表：restaurant_orders
 *
 * +------------------+----------+
 * | Column Name      | Type     |
 * +------------------+----------+
 * | order_id         | int      |
 * | customer_id      | int      |
 * | order_timestamp  | datetime |
 * | order_amount     | decimal  |
 * | payment_method   | varchar  |
 * | order_rating     | int      |
 * +------------------+----------+
 * order_id 是这张表的唯一主键。
 * payment_method 可以是 cash，card 或 app。
 * order_rating 在 1 到 5 之间，其中 5 是最佳（如果没有评分则是 NULL）。
 * order_timestamp 同时包含日期和时间信息。
 * 编写一个解决方案来寻找 黄金时间客户 - 高峰时段持续订购且满意度高的客户。客户若满足以下所有条件，则被视为 黄金时段客户：
 *
 * 进行 至少 3 笔订单。
 * 他们有 至少 60% 的订单在 高峰时间 中（11:00-14:00 或 18:00-21:00）。
 * 他们的 平均评分 至少为 4.0，四舍五入到小数点后 2 位。
 * 已评价至少 50% 的订单。
 * 返回结果表按 average_rating 降序 排序，然后按 customer_id 降序 排序。
 *
 * 结果格式如下所示。
 *
 *
 *
 * 示例：
 *
 * 输入：
 *
 * restaurant_orders 表：
 *
 * +----------+-------------+---------------------+--------------+----------------+--------------+
 * | order_id | customer_id | order_timestamp     | order_amount | payment_method | order_rating |
 * +----------+-------------+---------------------+--------------+----------------+--------------+
 * | 1        | 101         | 2024-03-01 12:30:00 | 25.50        | card           | 5            |
 * | 2        | 101         | 2024-03-02 19:15:00 | 32.00        | app            | 4            |
 * | 3        | 101         | 2024-03-03 13:45:00 | 28.75        | card           | 5            |
 * | 4        | 101         | 2024-03-04 20:30:00 | 41.00        | app            | NULL         |
 * | 5        | 102         | 2024-03-01 11:30:00 | 18.50        | cash           | 4            |
 * | 6        | 102         | 2024-03-02 12:00:00 | 22.00        | card           | 3            |
 * | 7        | 102         | 2024-03-03 15:30:00 | 19.75        | cash           | NULL         |
 * | 8        | 103         | 2024-03-01 19:00:00 | 55.00        | app            | 5            |
 * | 9        | 103         | 2024-03-02 20:45:00 | 48.50        | app            | 4            |
 * | 10       | 103         | 2024-03-03 18:30:00 | 62.00        | card           | 5            |
 * | 11       | 104         | 2024-03-01 10:00:00 | 15.00        | cash           | 3            |
 * | 12       | 104         | 2024-03-02 09:30:00 | 18.00        | cash           | 2            |
 * | 13       | 104         | 2024-03-03 16:00:00 | 20.00        | card           | 3            |
 * | 14       | 105         | 2024-03-01 12:15:00 | 30.00        | app            | 4            |
 * | 15       | 105         | 2024-03-02 13:00:00 | 35.50        | app            | 5            |
 * | 16       | 105         | 2024-03-03 11:45:00 | 28.00        | card           | 4            |
 * +----------+-------------+---------------------+--------------+----------------+--------------+
 * 输出：
 *
 * +-------------+--------------+----------------------+----------------+
 * | customer_id | total_orders | peak_hour_percentage | average_rating |
 * +-------------+--------------+----------------------+----------------+
 * | 103         | 3            | 100                  | 4.67           |
 * | 101         | 4            | 100                  | 4.67           |
 * | 105         | 3            | 100                  | 4.33           |
 * +-------------+--------------+----------------------+----------------+
 * 解释：
 *
 * 客户 101：
 * 总订单数：4（至少 3 笔）
 * 高峰时间订单：4 笔中有 4 笔（12:30，19:15，13:45 和 20:30 在高峰时间）
 * 高峰时间占比：100%（至少 60%）
 * 已评分的订单：4 笔中有 3 笔（75% 评分完成率）
 * 平均评分：(5+4+5)/3 = 4.67（至少 4.0）
 * 结果：黄金时段客户
 * 客户 102:
 * 总订单数：3（至少 3 笔）
 * 高峰时间订单：3 笔中有 2 笔（11:30，12:00 都在高峰时间，但 15:30 不是）
 * 高峰时间占比：2/3 = 66.67%（至少 60%）
 * 已评分的订单：3 笔中有 2 笔（66.67% 评分完成率）
 * 平均评分：(4+3)/2 = 3.5（少于 4.0）
 * 结果：不是黄金时段客户（平均评分太低）
 * 客户 103:
 * 总订单数：3（至少 3 笔）
 * 高峰时间订单：3 笔中有 3 （19:00，20:45，18:30 都在傍晚高峰时间）
 * 高峰时间占比：3/3 = 100%（至少 60%）
 * 已评分的订单：3 笔中有 3 笔（100% 评分完成率）
 * 平均评分：(5+4+5)/3 = 4.67（至少 4.0）
 * 结果：黄金时段客户
 * 客户 104:
 * 总订单数：3（至少 3 笔）
 * 高峰时间订单：3 笔中有 0 笔（10:00，09:30，16:00 都不在高峰时间）
 * 高峰时间占比：0/3 = 0%（至少 60%）
 * 结果：不是黄金时段客户（高峰时段订单不足）
 * 客户 105:
 * 总订单数：3（至少 3 笔）
 * 高峰时间订单：3 笔中有 3 笔（12:15，13:00，11:45 都在中午高峰时间）
 * 高峰时间占比：3/3 = 100%（至少 60%）
 * 已评分的订单：3 笔中有 3 笔（100% 评分完成率）
 * 平均评分：(4+5+4)/3 = 4.33（至少 4.0）
 * 结果：黄金时段客户
 * 结果表按 average_rating 降序排序，然后按 customer_id 降序排序。
 */
public class Code14 {

    private String sql = "SELECT DISTINCT a.customer_id, b.total_orders, c.peak_hour_percentage, d.average_rating FROM restaurant_orders a LEFT JOIN( SELECT customer_id, count(*) AS total_orders FROM restaurant_orders GROUP BY customer_id) b ON a.customer_id = b.customer_id LEFT JOIN ( SELECT a.customer_id, ROUND( a.peak_hour_percentage, 0 ) AS peak_hour_percentage FROM ( SELECT a.customer_id, (( a.peak_hour / a.total_orders ) * 100 ) AS peak_hour_percentage FROM ( SELECT a.customer_id, SUM( IF ( ( a.order_timestamp_hour >= 11 AND a.order_timestamp_hour < 14 ) OR ( a.order_timestamp_hour >= 18 AND a.order_timestamp_hour < 21 ), 1, 0 ) ) AS peak_hour, COUNT(*) AS total_orders FROM ( SELECT customer_id, HOUR ( order_timestamp ) order_timestamp_hour FROM restaurant_orders ) a GROUP BY a.customer_id ) a ) a) c ON a.customer_id = c.customer_id LEFT JOIN ( SELECT a.customer_id, ROUND( a.order_rating_sum / a.total_orders, 2 ) AS average_rating FROM ( SELECT customer_id, sum( order_rating ) AS order_rating_sum, SUM( IF ( order_rating IS NULL, 0, 1 )) AS total_orders FROM restaurant_orders GROUP BY customer_id ) a ) d ON a.customer_id = d.customer_id LEFT JOIN ( SELECT a.customer_id, ( a.no_order_rating / a.total_orders ) AS no_order_rating_percentage FROM ( SELECT customer_id, SUM( IF ( order_rating IS NULL, 1, 0 )) AS no_order_rating, count(*) AS total_orders FROM restaurant_orders GROUP BY customer_id ) a ) e ON a.customer_id = e.customer_id WHERE b.total_orders >= 3 AND c.peak_hour_percentage >= 60 AND d.average_rating >= 4 AND e.no_order_rating_percentage < 0.5 ORDER BY d.average_rating DESC, a.customer_id DESC";

}
