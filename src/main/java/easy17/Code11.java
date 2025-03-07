package easy17;

/**
 * @Author ayl
 * @Date 2022-04-02
 * 题目描述
 * 评论 (36)
 * 题解 (28)
 * 提交记录
 * 1965. 丢失信息的雇员
 * SQL架构
 * 表: Employees
 * <p>
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | employee_id | int     |
 * | name        | varchar |
 * +-------------+---------+
 * employee_id 是这个表的主键。
 * 每一行表示雇员的id 和他的姓名。
 * 表: Salaries
 * <p>
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | employee_id | int     |
 * | salary      | int     |
 * +-------------+---------+
 * employee_id is 这个表的主键。
 * 每一行表示雇员的id 和他的薪水。
 * <p>
 * <p>
 * 写出一个查询语句，找到所有 丢失信息 的雇员id。当满足下面一个条件时，就被认为是雇员的信息丢失：
 * <p>
 * 雇员的 姓名 丢失了，或者
 * 雇员的 薪水信息 丢失了，或者
 * 返回这些雇员的id  employee_id ， 从小到大排序 。
 * <p>
 * 查询结果格式如下面的例子所示。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * Employees table:
 * +-------------+----------+
 * | employee_id | name     |
 * +-------------+----------+
 * | 2           | Crew     |
 * | 4           | Haven    |
 * | 5           | Kristian |
 * +-------------+----------+
 * Salaries table:
 * +-------------+--------+
 * | employee_id | salary |
 * +-------------+--------+
 * | 5           | 76071  |
 * | 1           | 22517  |
 * | 4           | 63539  |
 * +-------------+--------+
 * 输出：
 * +-------------+
 * | employee_id |
 * +-------------+
 * | 1           |
 * | 2           |
 * +-------------+
 * 解释：
 * 雇员1，2，4，5 都工作在这个公司。
 * 1号雇员的姓名丢失了。
 * 2号雇员的薪水信息丢失了。
 */
public class Code11 {

    public static void main(String[] args) {
        String sql = "select a.employee_id from (select employee_id from Employees union select employee_id from Salaries) a where  a.employee_id not in (select a.employee_id from Employees a, Salaries b where a.employee_id=b.employee_id) order by a.employee_id asc";
    }

}
