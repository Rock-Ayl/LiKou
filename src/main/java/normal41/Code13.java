package normal41;

/**
 * 3421. 查找进步的学生
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * SQL Schema
 * Pandas Schema
 * 表：Scores
 *
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | student_id  | int     |
 * | subject     | varchar |
 * | score       | int     |
 * | exam_date   | varchar |
 * +-------------+---------+
 * (student_id, subject, exam_date) 是这张表的主键。
 * 每一行包含有关学生在特定考试日期特定科目成绩的信息。分数范围从 0 到 100（包括边界）。
 * 编写一个解决方案来查找 进步的学生。如果 同时 满足以下两个条件，则该学生被认为是进步的：
 *
 * 在 同一科目 至少参加过两个不同日期的考试。
 * 他们在该学科 最近的分数 比他们 第一次该学科考试的分数更高。
 * 返回结果表以 student_id，subject 升序 排序。
 *
 * 结果格式如下所示。
 *
 *
 *
 * 示例：
 *
 * 输入：
 *
 * Scores 表：
 *
 * +------------+----------+-------+------------+
 * | student_id | subject  | score | exam_date  |
 * +------------+----------+-------+------------+
 * | 101        | Math     | 70    | 2023-01-15 |
 * | 101        | Math     | 85    | 2023-02-15 |
 * | 101        | Physics  | 65    | 2023-01-15 |
 * | 101        | Physics  | 60    | 2023-02-15 |
 * | 102        | Math     | 80    | 2023-01-15 |
 * | 102        | Math     | 85    | 2023-02-15 |
 * | 103        | Math     | 90    | 2023-01-15 |
 * | 104        | Physics  | 75    | 2023-01-15 |
 * | 104        | Physics  | 85    | 2023-02-15 |
 * +------------+----------+-------+------------+
 * 出：
 *
 * +------------+----------+-------------+--------------+
 * | student_id | subject  | first_score | latest_score |
 * +------------+----------+-------------+--------------+
 * | 101        | Math     | 70          | 85           |
 * | 102        | Math     | 80          | 85           |
 * | 104        | Physics  | 75          | 85           |
 * +------------+----------+-------------+--------------+
 * 解释：
 *
 * 学生 101 的数学：从 70 分进步到 85 分。
 * 学生 101 的物理：没有进步（从 65 分退步到 60分）
 * 学生 102 的数学：从 80 进步到 85 分。
 * 学生 103 的数学：只有一次考试，不符合资格。
 * 学生 104 的物理：从 75 分进步到 85 分。
 * 结果表以 student_id，subject 升序排序。
 * @Author ayl
 * @Date 2025-03-31
 */
public class Code13 {

    private String sql = "SELECT a.student_id,a.subject,a.first_score,a.latest_score FROM (SELECT *,FIRST_VALUE(score) OVER w as first_score, LAST_VALUE(score) OVER w as latest_score FROM scores WINDOW w AS (PARTITION BY student_id,subject ORDER BY exam_date asc ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING)) a WHERE a.first_score < a.latest_score GROUP BY a.student_id,a.subject  ORDER BY a.student_id,a.subject";

}
