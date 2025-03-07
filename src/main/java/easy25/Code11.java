package easy25;

/**
 * @Author ayl
 * @Date 2022-12-01
 * 196. 删除重复的电子邮箱
 * SQL架构
 * 表: Person
 * <p>
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | id          | int     |
 * | email       | varchar |
 * +-------------+---------+
 * id是该表的主键列。
 * 该表的每一行包含一封电子邮件。电子邮件将不包含大写字母。
 * <p>
 * <p>
 * 编写一个 SQL 删除语句来 删除 所有重复的电子邮件，只保留一个id最小的唯一电子邮件。
 * <p>
 * 以 任意顺序 返回结果表。 （注意： 仅需要写删除语句，将自动对剩余结果进行查询）
 * <p>
 * 查询结果格式如下所示。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * Person 表:
 * +----+------------------+
 * | id | email            |
 * +----+------------------+
 * | 1  | john@example.com |
 * | 2  | bob@example.com  |
 * | 3  | john@example.com |
 * +----+------------------+
 * 输出:
 * +----+------------------+
 * | id | email            |
 * +----+------------------+
 * | 1  | john@example.com |
 * | 2  | bob@example.com  |
 * +----+------------------+
 * 解释: john@example.com重复两次。我们保留最小的Id = 1。
 * 通过次数182,924提交次数267,152
 */
public class Code11 {

    public static void main(String[] args) {
        String sql = "DELETE FROM Person WHERE id NOT IN (SELECT a.* FROM (SELECT MIN(id) as id FROM Person GROUP BY email) a)";
    }

}
