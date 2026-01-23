package normal49;

/**
 * 3808. 寻找情绪一致的用户
 * 已解答
 *  同步题目状态
 *
 * 中等
 * premium lock icon
 * 相关企业
 * SQL Schema
 * Pandas Schema
 * 表：reactions
 *
 * +--------------+---------+
 * | Column Name  | Type    |
 * +--------------+---------+
 * | user_id      | int     |
 * | content_id   | int     |
 * | reaction     | varchar |
 * +--------------+---------+
 * (user_id, content_id) 是这张表的主键（值互不相同）。
 * 每一行代表用户对某条内容的反应。
 * 根据以下要求编写一个解决方案，以识别 情绪一致的用户：
 *
 * 为每个用户统计他们发送的总反应次数。
 * 仅包含 至少对 5 个不同内容项 作出反应的用户。
 * 如果用户 至少 60% 的反应属于 同一种类型，则认为其 情绪一致。
 * 返回结果表按 reaction_ratio 降序 排序，然后按 user_id 升序 排序。
 *
 * 注意：
 *
 * reaction_ratio 应该舍入到 2 位小数
 * 结果格式如下所示。
 *
 *
 *
 * 示例：
 *
 * 输入：
 *
 * reactions 表：
 *
 * +---------+------------+----------+
 * | user_id | content_id | reaction |
 * +---------+------------+----------+
 * | 1       | 101        | like     |
 * | 1       | 102        | like     |
 * | 1       | 103        | like     |
 * | 1       | 104        | wow      |
 * | 1       | 105        | like     |
 * | 2       | 201        | like     |
 * | 2       | 202        | wow      |
 * | 2       | 203        | sad      |
 * | 2       | 204        | like     |
 * | 2       | 205        | wow      |
 * | 3       | 301        | love     |
 * | 3       | 302        | love     |
 * | 3       | 303        | love     |
 * | 3       | 304        | love     |
 * | 3       | 305        | love     |
 * +---------+------------+----------+
 * 输出：
 *
 * +---------+-------------------+----------------+
 * | user_id | dominant_reaction | reaction_ratio |
 * +---------+-------------------+----------------+
 * | 3       | love              | 1.00           |
 * | 1       | like              | 0.80           |
 * +---------+-------------------+----------------+
 * 解释：
 *
 * 用户 1：
 * 总反应数 = 5
 * 'like' 出现了 4 次
 * reaction_ratio = 4 / 5 = 0.80
 * 满足 60% 一致的要求
 * 用户 2：
 * 总反应数 = 5
 * 出现最多的反应只出现了 2 次
 * reaction_ratio = 2 / 5 = 0.40
 * 不满足一致的要求
 * 用户 3：
 * 总反应数 = 5
 * 'love' 出现了 5 次
 * reaction_ratio = 5 / 5 = 1.00
 * 满足一致的要求
 * 结果表按 reaction_ratio 降序排序，然后按 user_id 升序排序。
 */
public class Code25 {

    private String sql = "SELECT t.user_id, t.reaction AS dominant_reaction, ROUND(t.reaction_total / s.total, 2) AS reaction_ratio FROM(SELECT user_id, reaction, COUNT(*) AS reaction_total FROM reactions GROUP BY user_id, reaction) t JOIN ( SELECT user_id, SUM(cnt) AS total, MAX(cnt) AS max_cnt FROM (SELECT user_id, reaction, COUNT(*) AS cnt FROM reactions GROUP BY user_id, reaction) x GROUP BY user_id) s ON t.user_id = s.user_id AND t.reaction_total = s.max_cnt WHERE s.max_cnt / s.total >= 0.6 AND s.total >= 5 ORDER BY reaction_ratio DESC, user_id ASC";

}