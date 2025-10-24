package normal47;

/**
 * @Author ayl
 * @Date 2025-10-24
 * 3716. 寻找流失风险客户
 * 已解答
 *  同步题目状态
 *
 * 中等
 * premium lock icon
 * 相关企业
 * SQL Schema
 * Pandas Schema
 * 表：subscription_events
 *
 * +------------------+---------+
 * | Column Name      | Type    |
 * +------------------+---------+
 * | event_id         | int     |
 * | user_id          | int     |
 * | event_date       | date    |
 * | event_type       | varchar |
 * | plan_name        | varchar |
 * | monthly_amount   | decimal |
 * +------------------+---------+
 * event_id 是这张表的唯一主键。
 * event_type 可以是 start，upgrade，downgrade 或 cancel。
 * plan_name 可以是 basic，standard，premium 或 NULL（当 event_type 是 cancel）。
 * monthly_amount 表示此次事件后的月度订阅费用。
 * 对于 cancel 的事件，monthly_amount 为 0。
 * 编写一个解决方案来 寻找流失风险用户 - 出现预流失信号的用户。如果用户符合以下所有条件，则被视为 有流失风险 的客户：
 *
 * 目前有 有效的订阅（他们的最后事件不是 cancel）。
 * 已在其订阅历史中 至少进行过一次 降级。
 * 他们 目前的订阅费用 低于历史最高订阅费用的 50%。
 * 已订阅 至少 60 天。
 * 返回结果表按 days_as_subscriber 降序 排序，然后按 user_id 升序 排序。
 *
 * 结果格式如下所示。
 *
 *
 *
 * 示例：
 *
 * 输入：
 *
 * subscription_events 表：
 *
 * +----------+---------+------------+------------+-----------+----------------+
 * | event_id | user_id | event_date | event_type | plan_name | monthly_amount |
 * +----------+---------+------------+------------+-----------+----------------+
 * | 1        | 501     | 2024-01-01 | start      | premium   | 29.99          |
 * | 2        | 501     | 2024-02-15 | downgrade  | standard  | 19.99          |
 * | 3        | 501     | 2024-03-20 | downgrade  | basic     | 9.99           |
 * | 4        | 502     | 2024-01-05 | start      | standard  | 19.99          |
 * | 5        | 502     | 2024-02-10 | upgrade    | premium   | 29.99          |
 * | 6        | 502     | 2024-03-15 | downgrade  | basic     | 9.99           |
 * | 7        | 503     | 2024-01-10 | start      | basic     | 9.99           |
 * | 8        | 503     | 2024-02-20 | upgrade    | standard  | 19.99          |
 * | 9        | 503     | 2024-03-25 | upgrade    | premium   | 29.99          |
 * | 10       | 504     | 2024-01-15 | start      | premium   | 29.99          |
 * | 11       | 504     | 2024-03-01 | downgrade  | standard  | 19.99          |
 * | 12       | 504     | 2024-03-30 | cancel     | NULL      | 0.00           |
 * | 13       | 505     | 2024-02-01 | start      | basic     | 9.99           |
 * | 14       | 505     | 2024-02-28 | upgrade    | standard  | 19.99          |
 * | 15       | 506     | 2024-01-20 | start      | premium   | 29.99          |
 * | 16       | 506     | 2024-03-10 | downgrade  | basic     | 9.99           |
 * +----------+---------+------------+------------+-----------+----------------+
 * 输出：
 *
 * +----------+--------------+------------------------+-----------------------+--------------------+
 * | user_id  | current_plan | current_monthly_amount | max_historical_amount | days_as_subscriber |
 * +----------+--------------+------------------------+-----------------------+--------------------+
 * | 501      | basic        | 9.99                   | 29.99                 | 79                 |
 * | 502      | basic        | 9.99                   | 29.99                 | 69                 |
 * +----------+--------------+------------------------+-----------------------+--------------------+
 * 解释：
 *
 * 用户 501：
 * 当前订阅有效：最近一次事件是降级到基础（未取消）
 * 有降级记录：是，历史上有 2 次降级
 * 当前订阅（9.99）vs 最大订阅（29.99）：9.99/29.99 = 33.3%（少于 50%）
 * 订阅天数：1 月 1 日到 5 月 20 日 = 79 天（至少 60 天）
 * 结果：流失风险客户
 * 用户 502：
 * 当前订阅有效：最近一次事件是降级到基础（未取消）
 * 有降级记录：是，历史上有 1 次降级
 * 当前订阅（9.99）vs 最大订阅（29.99）：9.99/29.99 = 33.3%（少于 50%）
 * 订阅天数：1 月 5 日到 5 月 15 日 = 70 天（至少 60 天）
 * 结果：流失风险客户
 * 用户 503：
 * 当前订阅有效：最近一次事件是升级到高级（未取消）
 * 有降级记录：历史上没有降级
 * 结果：无风险客户（没有降级历史）
 * 用户 504：
 * 当前订阅有效：最近一次事件是取消
 * 结果：无风险客户（已取消订阅）
 * 用户 505：
 * 当前订阅有效：最近一次事件是升级到标准（未取消）
 * 有降级记录：历史上没有降级
 * 结果：无风险客户（没有降级历史）
 * 用户 506：
 * 当前订阅有效：最近一次事件是降级到标准（未取消）
 * 有降级记录：是，历史上有 1 次降级
 * 当前订阅（9.99）vs 最大订阅（29.99）：9.99/29.99 = 33.3%（少于 50%）
 * 订阅天数：1 月 20 日到 5 月 10 日 = 50 天（少于 60 天）
 * 结果：无风险客户（订阅时长不足）
 * 结果表按 days_as_subscriber 降序排序，然后按 user_id 升序排序。
 *
 * 注意：days_as_subscriber 按照每个用户的第一个事件日期到最后一个事件日期进行计算。
 *
 *
 */
public class Code10 {

    private String sql="SELECT a.user_id, a.current_plan, a.current_monthly_amount, b.max_historical_amount, c.days_as_subscriber FROM( SELECT a.user_id, b.plan_name AS current_plan, b.monthly_amount AS current_monthly_amount FROM ( SELECT user_id, MAX( event_date) AS last_date FROM subscription_events GROUP BY user_id ) a, subscription_events b WHERE a.user_id = b.user_id AND a.last_date = b.event_date ) a LEFT JOIN ( SELECT user_id, MAX( monthly_amount ) AS max_historical_amount FROM subscription_events GROUP BY user_id ) b ON a.user_id = b.user_id LEFT JOIN ( SELECT a.user_id, DATEDIFF( a.last_date, a.first_date ) AS days_as_subscriber FROM ( SELECT user_id, min( event_date ) AS first_date, max( event_date ) AS last_date FROM subscription_events GROUP BY user_id ) a ) c ON a.user_id = c.user_id WHERE a.current_monthly_amount * 2 < b.max_historical_amount AND c.days_as_subscriber >= 60 AND a.user_id IN ( SELECT user_id FROM subscription_events WHERE event_type = 'downgrade' ) AND a.user_id IN ( SELECT a.user_id FROM ( SELECT user_id, MAX( event_date ) AS last_date FROM subscription_events GROUP BY user_id ) a, subscription_events b WHERE a.user_id = b.user_id AND a.last_date = b.event_date AND b.event_type != 'cancel' ) ORDER BY c.days_as_subscriber DESC, a.user_id ASC";

}
