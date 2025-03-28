package easy32;

/**
 * @Author ayl
 * @Date 2023-06-16
 * 1517. 查找拥有有效邮箱的用户
 * SQL架构
 * 用户表： Users
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | user_id       | int     |
 * | name          | varchar |
 * | mail          | varchar |
 * +---------------+---------+
 * user_id （用户 ID）是该表的主键。
 * 这个表包含用户在某网站上注册的信息。有些邮箱是无效的。
 * <p>
 * <p>
 * 写一条 SQL 语句，查询拥有有效邮箱的用户。
 * <p>
 * 有效的邮箱包含符合下列条件的前缀名和域名：
 * <p>
 * 前缀名是包含字母（大写或小写）、数字、下划线 '_'、句点 '.' 和/或横杠 '-' 的字符串。前缀名必须以字母开头。
 * 域名是 '@leetcode.com' 。
 * 按任意顺序返回结果表。
 * <p>
 * <p>
 * <p>
 * 查询格式如下所示：
 * <p>
 * Users
 * +---------+-----------+-------------------------+
 * | user_id | name      | mail                    |
 * +---------+-----------+-------------------------+
 * | 1       | Winston   | winston@leetcode.com    |
 * | 2       | Jonathan  | jonathanisgreat         |
 * | 3       | Annabelle | bella-@leetcode.com     |
 * | 4       | Sally     | sally.come@leetcode.com |
 * | 5       | Marwan    | quarz#2020@leetcode.com |
 * | 6       | David     | david69@gmail.com       |
 * | 7       | Shapiro   | .shapo@leetcode.com     |
 * +---------+-----------+-------------------------+
 * <p>
 * 结果表：
 * +---------+-----------+-------------------------+
 * | user_id | name      | mail                    |
 * +---------+-----------+-------------------------+
 * | 1       | Winston   | winston@leetcode.com    |
 * | 3       | Annabelle | bella-@leetcode.com     |
 * | 4       | Sally     | sally.come@leetcode.com |
 * +---------+-----------+-------------------------+
 * 2 号用户的邮箱没有域名。
 * 5 号用户的邮箱包含非法字符 #。
 * 6 号用户的邮箱的域名不是 leetcode。
 * 7 号用户的邮箱以句点（.）开头。
 */
public class Code1 {

    private String sql = "SELECT * FROM users WHERE mail REGEXP '^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode\\\\.com$'";

}
