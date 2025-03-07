package easy31;

/**
 * @Author ayl
 * @Date 2023-05-28
 * 2356. 每位教师所教授的科目种类的数量
 * SQL架构
 * 表: Teacher
 *
 * +-------------+------+
 * | Column Name | Type |
 * +-------------+------+
 * | teacher_id  | int  |
 * | subject_id  | int  |
 * | dept_id     | int  |
 * +-------------+------+
 * (subject_id, dept_id) 是该表的主键。
 * 该表中的每一行都表示带有 teacher_id 的教师在系 dept_id 中教授科目 subject_id。
 *
 *
 * 写一个 SQL 来查询每位老师在大学里教授的科目种类的数量。
 *
 * 以 任意顺序 返回结果表。
 *
 * 查询结果格式示例如下。
 *
 *
 *
 * 示例 1:
 *
 * 输入:
 * Teacher 表:
 * +------------+------------+---------+
 * | teacher_id | subject_id | dept_id |
 * +------------+------------+---------+
 * | 1          | 2          | 3       |
 * | 1          | 2          | 4       |
 * | 1          | 3          | 3       |
 * | 2          | 1          | 1       |
 * | 2          | 2          | 1       |
 * | 2          | 3          | 1       |
 * | 2          | 4          | 1       |
 * +------------+------------+---------+
 * 输出:
 * +------------+-----+
 * | teacher_id | cnt |
 * +------------+-----+
 * | 1          | 2   |
 * | 2          | 4   |
 * +------------+-----+
 * 解释:
 * 教师 1:
 *   - 他在 3、4 系教科目 2。
 *   - 他在 3 系教科目 3。
 * 教师 2:
 *   - 他在 1 系教科目 1。
 *   - 他在 1 系教科目 2。
 *   - 他在 1 系教科目 3。
 *   - 他在 1 系教科目 4。
 */
public class Code7 {

    String sql="SELECT a.teacher_id,count(*) as cnt FROM (SELECT * FROM teacher GROUP BY teacher_id,subject_id) a GROUP BY a.teacher_id";
}
