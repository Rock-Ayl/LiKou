package easy33;

/**
 * @Author ayl
 * @Date 2023-09-26
 * 1280. 学生们参加各科测试的次数
 * 简单
 * 186
 * 相关企业
 * SQL Schema
 * Pandas Schema
 * 学生表: Students
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | student_id    | int     |
 * | student_name  | varchar |
 * +---------------+---------+
 * 在 SQL 中，主键为 student_id（学生ID）。
 * 该表内的每一行都记录有学校一名学生的信息。
 * <p>
 * <p>
 * 科目表: Subjects
 * <p>
 * +--------------+---------+
 * | Column Name  | Type    |
 * +--------------+---------+
 * | subject_name | varchar |
 * +--------------+---------+
 * 在 SQL 中，主键为 subject_name（科目名称）。
 * 每一行记录学校的一门科目名称。
 * <p>
 * <p>
 * 考试表: Examinations
 * <p>
 * +--------------+---------+
 * | Column Name  | Type    |
 * +--------------+---------+
 * | student_id   | int     |
 * | subject_name | varchar |
 * +--------------+---------+
 * 这个表可能包含重复数据（换句话说，在 SQL 中，这个表没有主键）。
 * 学生表里的一个学生修读科目表里的每一门科目。
 * 这张考试表的每一行记录就表示学生表里的某个学生参加了一次科目表里某门科目的测试。
 * <p>
 * <p>
 * 查询出每个学生参加每一门科目测试的次数，结果按 student_id 和 subject_name 排序。
 * <p>
 * 查询结构格式如下所示。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * Students table:
 * +------------+--------------+
 * | student_id | student_name |
 * +------------+--------------+
 * | 1          | Alice        |
 * | 2          | Bob          |
 * | 13         | John         |
 * | 6          | Alex         |
 * +------------+--------------+
 * Subjects table:
 * +--------------+
 * | subject_name |
 * +--------------+
 * | Math         |
 * | Physics      |
 * | Programming  |
 * +--------------+
 * Examinations table:
 * +------------+--------------+
 * | student_id | subject_name |
 * +------------+--------------+
 * | 1          | Math         |
 * | 1          | Physics      |
 * | 1          | Programming  |
 * | 2          | Programming  |
 * | 1          | Physics      |
 * | 1          | Math         |
 * | 13         | Math         |
 * | 13         | Programming  |
 * | 13         | Physics      |
 * | 2          | Math         |
 * | 1          | Math         |
 * +------------+--------------+
 * 输出：
 * +------------+--------------+--------------+----------------+
 * | student_id | student_name | subject_name | attended_exams |
 * +------------+--------------+--------------+----------------+
 * | 1          | Alice        | Math         | 3              |
 * | 1          | Alice        | Physics      | 2              |
 * | 1          | Alice        | Programming  | 1              |
 * | 2          | Bob          | Math         | 1              |
 * | 2          | Bob          | Physics      | 0              |
 * | 2          | Bob          | Programming  | 1              |
 * | 6          | Alex         | Math         | 0              |
 * | 6          | Alex         | Physics      | 0              |
 * | 6          | Alex         | Programming  | 0              |
 * | 13         | John         | Math         | 1              |
 * | 13         | John         | Physics      | 1              |
 * | 13         | John         | Programming  | 1              |
 * +------------+--------------+--------------+----------------+
 * 解释：
 * 结果表需包含所有学生和所有科目（即便测试次数为0）：
 * Alice 参加了 3 次数学测试, 2 次物理测试，以及 1 次编程测试；
 * Bob 参加了 1 次数学测试, 1 次编程测试，没有参加物理测试；
 * Alex 啥测试都没参加；
 * John  参加了数学、物理、编程测试各 1 次。
 */
public class Code15 {

    public static void main(String[] args) {
        String sql = "SELECT a.*, IF(c.attended_exams is null, 0, c.attended_exams) AS attended_exams FROM(SELECT * FROM Students a, Subjects b) a LEFT JOIN (SELECT student_id, subject_name, COUNT(*) AS attended_exams FROM Examinations GROUP BY student_id, subject_name ) c ON a.student_id = c.student_id AND a.subject_name = c.subject_name ORDER BY a.student_id, a.student_name, a.subject_name, c.attended_exams";
    }

}
