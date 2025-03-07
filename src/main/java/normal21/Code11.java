package normal21;

/**
 * @Author ayl
 * @Date 2023-07-03
 * 1907. 按分类统计薪水
 * SQL架构
 * 表: Accounts
 *
 * +-------------+------+
 * | 列名        | 类型  |
 * +-------------+------+
 * | account_id  | int  |
 * | income      | int  |
 * +-------------+------+
 * account_id 是这个表的主键。
 * 每一行都包含一个银行帐户的月收入的信息。
 *
 *
 * 写出一个 SQL 查询，来报告每个工资类别的银行账户数量。 工资类别如下：
 *
 * "Low Salary"：所有工资 严格低于 20000 美元。
 * "Average Salary"： 包含 范围内的所有工资 [$20000, $50000] 。
 * "High Salary"：所有工资 严格大于 50000 美元。
 *
 * 结果表 必须 包含所有三个类别。 如果某个类别中没有帐户，则报告 0 。
 *
 * 按 任意顺序 返回结果表。
 *
 * 查询结果格式如下示例。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * Accounts 表:
 * +------------+--------+
 * | account_id | income |
 * +------------+--------+
 * | 3          | 108939 |
 * | 2          | 12747  |
 * | 8          | 87709  |
 * | 6          | 91796  |
 * +------------+--------+
 * 输出：
 * +----------------+----------------+
 * | category       | accounts_count |
 * +----------------+----------------+
 * | Low Salary     | 1              |
 * | Average Salary | 0              |
 * | High Salary    | 3              |
 * +----------------+----------------+
 * 解释：
 * 低薪: 数量为 2.
 * 中等薪水: 没有.
 * 高薪: 有三个账户，他们是 3, 6和 8.
 */
public class Code11 {

    String sql="SELECT \"Low Salary\" as category ,count(*) as accounts_count FROM Accounts WHERE income <20000 union SELECT \"Average Salary\" as category,count(*) as accounts_count FROM Accounts WHERE income >=20000 and  income <=50000 union SELECT \"High Salary\" as category,count(*) as accounts_count FROM Accounts WHERE income> 50000";
}
