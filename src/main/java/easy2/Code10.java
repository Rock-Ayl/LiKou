package easy2;

/**
 * Created By Rock-Ayl on 2020-09-28
 * 181. 超过经理收入的员工
 * SQL架构
 * Employee 表包含所有员工，他们的经理也属于员工。每个员工都有一个 Id，此外还有一列对应员工的经理的 Id。
 * <p>
 * +----+-------+--------+-----------+
 * | Id | Name  | Salary | ManagerId |
 * +----+-------+--------+-----------+
 * | 1  | Joe   | 70000  | 3         |
 * | 2  | Henry | 80000  | 4         |
 * | 3  | Sam   | 60000  | NULL      |
 * | 4  | Max   | 90000  | NULL      |
 * +----+-------+--------+-----------+
 * 给定 Employee 表，编写一个 SQL 查询，该查询可以获取收入超过他们经理的员工的姓名。在上面的表格中，Joe 是唯一一个收入超过他的经理的员工。
 * <p>
 * +----------+
 * | Employee |
 * +----------+
 * | Joe      |
 * +----------+
 */
public class Code10 {

    public static void main(String[] args) {
        String sql = "SELECT a.Name as Employee FROM Employee a,Employee b WHERE a.ManagerId = b.id AND a.Salary>b.Salary";
    }
}
