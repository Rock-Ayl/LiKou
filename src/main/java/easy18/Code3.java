package easy18;

/**
 * @Author ayl
 * @Date 2022-04-15
 * 1667. 修复表中的名字
 * SQL架构
 * 表： Users
 *
 * +----------------+---------+
 * | Column Name    | Type    |
 * +----------------+---------+
 * | user_id        | int     |
 * | name           | varchar |
 * +----------------+---------+
 * user_id 是该表的主键。
 * 该表包含用户的 ID 和名字。名字仅由小写和大写字符组成。
 *
 *
 * 编写一个 SQL 查询来修复名字，使得只有第一个字符是大写的，其余都是小写的。
 *
 * 返回按 user_id 排序的结果表。
 *
 * 查询结果格式示例如下。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * Users table:
 * +---------+-------+
 * | user_id | name  |
 * +---------+-------+
 * | 1       | aLice |
 * | 2       | bOB   |
 * +---------+-------+
 * 输出：
 * +---------+-------+
 * | user_id | name  |
 * +---------+-------+
 * | 1       | Alice |
 * | 2       | Bob   |
 * +---------+-------+
 * 通过次数6,220提交次数9,869
 */
public class Code3 {

    public static void main(String[] args) {
        String  sql="SELECT user_id,concat(SUBSTRING(upper(name),1,1), SUBSTRING(lower(name),2)) as name  from Users order by user_id";
    }

}
