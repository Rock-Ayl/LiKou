package normal24;

/**
 * @Author ayl
 * @Date 2023-09-27
 * 1341. 电影评分
 * 中等
 * 49
 * 相关企业
 * SQL Schema
 * 表：Movies
 *
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | movie_id      | int     |
 * | title         | varchar |
 * +---------------+---------+
 * movie_id 是这个表的主键(具有唯一值的列)。
 * title 是电影的名字。
 * 表：Users
 *
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | user_id       | int     |
 * | name          | varchar |
 * +---------------+---------+
 * user_id 是表的主键(具有唯一值的列)。
 * 表：MovieRating
 *
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | movie_id      | int     |
 * | user_id       | int     |
 * | rating        | int     |
 * | created_at    | date    |
 * +---------------+---------+
 * (movie_id, user_id) 是这个表的主键(具有唯一值的列的组合)。
 * 这个表包含用户在其评论中对电影的评分 rating 。
 * created_at 是用户的点评日期。
 *
 *
 * 请你编写一个解决方案：
 *
 * 查找评论电影数量最多的用户名。如果出现平局，返回字典序较小的用户名。
 * 查找在 February 2020 平均评分最高 的电影名称。如果出现平局，返回字典序较小的电影名称。
 * 字典序 ，即按字母在字典中出现顺序对字符串排序，字典序较小则意味着排序靠前。
 *
 * 返回结果格式如下例所示。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * Movies 表：
 * +-------------+--------------+
 * | movie_id    |  title       |
 * +-------------+--------------+
 * | 1           | Avengers     |
 * | 2           | Frozen 2     |
 * | 3           | Joker        |
 * +-------------+--------------+
 * Users 表：
 * +-------------+--------------+
 * | user_id     |  name        |
 * +-------------+--------------+
 * | 1           | Daniel       |
 * | 2           | Monica       |
 * | 3           | Maria        |
 * | 4           | James        |
 * +-------------+--------------+
 * MovieRating 表：
 * +-------------+--------------+--------------+-------------+
 * | movie_id    | user_id      | rating       | created_at  |
 * +-------------+--------------+--------------+-------------+
 * | 1           | 1            | 3            | 2020-01-12  |
 * | 1           | 2            | 4            | 2020-02-11  |
 * | 1           | 3            | 2            | 2020-02-12  |
 * | 1           | 4            | 1            | 2020-01-01  |
 * | 2           | 1            | 5            | 2020-02-17  |
 * | 2           | 2            | 2            | 2020-02-01  |
 * | 2           | 3            | 2            | 2020-03-01  |
 * | 3           | 1            | 3            | 2020-02-22  |
 * | 3           | 2            | 4            | 2020-02-25  |
 * +-------------+--------------+--------------+-------------+
 * 输出：
 * Result 表：
 * +--------------+
 * | results      |
 * +--------------+
 * | Daniel       |
 * | Frozen 2     |
 * +--------------+
 * 解释：
 * Daniel 和 Monica 都点评了 3 部电影（"Avengers", "Frozen 2" 和 "Joker"） 但是 Daniel 字典序比较小。
 * Frozen 2 和 Joker 在 2 月的评分都是 3.5，但是 Frozen 2 的字典序比较小。
 */
public class Code11 {

    String sql="(SELECT b.`name` AS results FROM (SELECT a.user_id, count(*) AS ratingCount FROM (SELECT * FROM MovieRating GROUP BY user_id, movie_id) a GROUP BY a.user_id ) a, Users b WHERE a.user_id = b.user_id ORDER BY a.ratingCount DESC, b.`name` ASC LIMIT 1 ) UNION ALL (SELECT b.title AS results FROM (SELECT a.movie_id, ( SUM( a.rating ) / count(*) ) AS avgRating FROM (SELECT * FROM (SELECT *, YEAR ( created_at ) AS YEAR, MONTH ( created_at ) AS MONTH FROM MovieRating ) a WHERE a.YEAR = 2020 AND a.MONTH = 2 ) a GROUP BY movie_id ) a, Movies b WHERE a.movie_id = b.movie_id ORDER BY a.avgRating DESC, b.title ASC LIMIT 1)";
}
