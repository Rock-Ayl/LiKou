package easy;

/**
 * Created By Rock-Ayl on 2020-09-02
 * 182. 查找重复的电子邮箱
 * SQL架构
 * 编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。
 * <p>
 * 示例：
 * <p>
 * +----+---------+
 * | Id | Email   |
 * +----+---------+
 * | 1  | a@b.com |
 * | 2  | c@d.com |
 * | 3  | a@b.com |
 * +----+---------+
 * 根据以上输入，你的查询应返回以下结果：
 * <p>
 * +---------+
 * | Email   |
 * +---------+
 * | a@b.com |
 * +---------+
 * 说明：所有电子邮箱都是小写字母。
 */
public class Code25 {

    public static void main(String[] args) {
        //Sql
        String sql = "SELECT a.email FROM Person a,Person b WHERE a.email=b.email AND a.id !=b.id GROUP BY a.email";
    }
}
