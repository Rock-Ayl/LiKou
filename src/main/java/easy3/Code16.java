package easy3;

/**
 * Created By Rock-Ayl on 2020-11-05
 * 176. 第二高的薪水
 * SQL架构
 * 编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。
 * <p>
 * +----+--------+
 * | Id | Salary |
 * +----+--------+
 * | 1  | 100    |
 * | 2  | 200    |
 * | 3  | 300    |
 * +----+--------+
 * 例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。
 * <p>
 * +---------------------+
 * | SecondHighestSalary |
 * +---------------------+
 * | 200                 |
 * +---------------------+
 */
public class Code16 {

    public static void main(String[] args) {
        String sql = "select (select distinct salary from Employee order by salary desc limit 1,1) as SecondHighestSalary ";
    }
}
