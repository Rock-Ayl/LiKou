package normal;

/**
 * Created By Rock-Ayl on 2020-12-07
 * 184. 部门工资最高的员工
 * SQL架构
 * Employee 表包含所有员工信息，每个员工有其对应的 Id, salary 和 department Id。
 * <p>
 * +----+-------+--------+--------------+
 * | Id | Name  | Salary | DepartmentId |
 * +----+-------+--------+--------------+
 * | 1  | Joe   | 70000  | 1            |
 * | 2  | Jim   | 90000  | 1            |
 * | 3  | Henry | 80000  | 2            |
 * | 4  | Sam   | 60000  | 2            |
 * | 5  | Max   | 90000  | 1            |
 * +----+-------+--------+--------------+
 * Department 表包含公司所有部门的信息。
 * <p>
 * +----+----------+
 * | Id | Name     |
 * +----+----------+
 * | 1  | IT       |
 * | 2  | Sales    |
 * +----+----------+
 * 编写一个 SQL 查询，找出每个部门工资最高的员工。对于上述表，您的 SQL 查询应返回以下行（行的顺序无关紧要）。
 * <p>
 * +------------+----------+--------+
 * | Department | Employee | Salary |
 * +------------+----------+--------+
 * | IT         | Max      | 90000  |
 * | IT         | Jim      | 90000  |
 * | Sales      | Henry    | 80000  |
 * +------------+----------+--------+
 * 解释：
 * <p>
 * Max 和 Jim 在 IT 部门的工资都是最高的，Henry 在销售部的工资最高。
 */
public class Code10 {

    public static void main(String[] args) {
        String sql = "SELECT C.`Name` AS Department,b.`Name` AS Employee,b.Salary FROM (SELECT a.`Name`,a.Salary,a.DepartmentId FROM (SELECT `Name`,Salary,DepartmentId,rank () over (PARTITION BY DepartmentId ORDER BY Salary DESC) AS 'rank' FROM Employee) a WHERE a.rank=1) b,Department c WHERE b.DepartmentId=c.Id";
    }

}
