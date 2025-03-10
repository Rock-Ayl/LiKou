package easy31;

/**
 * @Author ayl
 * @Date 2023-06-05
 * 1075. 项目员工 I
 * SQL架构
 * 项目表 Project：
 *
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | project_id  | int     |
 * | employee_id | int     |
 * +-------------+---------+
 * 主键为 (project_id, employee_id)。
 * employee_id 是员工表 Employee 表的外键。
 * 员工表 Employee：
 *
 * +------------------+---------+
 * | Column Name      | Type    |
 * +------------------+---------+
 * | employee_id      | int     |
 * | name             | varchar |
 * | experience_years | int     |
 * +------------------+---------+
 * 主键是 employee_id。
 *
 *
 * 请写一个 SQL 语句，查询每一个项目中员工的 平均 工作年限，精确到小数点后两位。
 *
 * 查询结果的格式如下：
 *
 * Project 表：
 * +-------------+-------------+
 * | project_id  | employee_id |
 * +-------------+-------------+
 * | 1           | 1           |
 * | 1           | 2           |
 * | 1           | 3           |
 * | 2           | 1           |
 * | 2           | 4           |
 * +-------------+-------------+
 *
 * Employee 表：
 * +-------------+--------+------------------+
 * | employee_id | name   | experience_years |
 * +-------------+--------+------------------+
 * | 1           | Khaled | 3                |
 * | 2           | Ali    | 2                |
 * | 3           | John   | 1                |
 * | 4           | Doe    | 2                |
 * +-------------+--------+------------------+
 *
 * Result 表：
 * +-------------+---------------+
 * | project_id  | average_years |
 * +-------------+---------------+
 * | 1           | 2.00          |
 * | 2           | 2.50          |
 * +-------------+---------------+
 * 第一个项目中，员工的平均工作年限是 (3 + 2 + 1) / 3 = 2.00；第二个项目中，员工的平均工作年限是 (3 + 2) / 2 = 2.50
 * 通过次数20,341提交次数28,986
 */
public class Code14 {

    String sql="SELECT a.project_id,(ROUND( a.yearSum / a.count, 2 )) AS average_years FROM (SELECT a.project_id,count( a.employee_id ) AS count,SUM( a.experience_years ) AS yearSum FROM ( SELECT a.project_id, a.employee_id, b.experience_years FROM project a, Employee b WHERE a.employee_id = b.employee_id ) a GROUP BY a.project_id ) a";

}
