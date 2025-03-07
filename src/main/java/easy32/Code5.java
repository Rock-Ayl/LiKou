package easy32;

/**
 * @Author ayl
 * @Date 2023-06-24
 * 1633. 各赛事的用户注册率
 * SQL架构
 * 用户表： Users
 *
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | user_id     | int     |
 * | user_name   | varchar |
 * +-------------+---------+
 * user_id 是该表的主键。
 * 该表中的每行包括用户 ID 和用户名。
 *
 *
 * 注册表： Register
 *
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | contest_id  | int     |
 * | user_id     | int     |
 * +-------------+---------+
 * (contest_id, user_id) 是该表的主键。
 * 该表中的每行包含用户的 ID 和他们注册的赛事。
 *
 *
 * 写一条 SQL 语句，查询各赛事的用户注册百分率，保留两位小数。
 *
 * 返回的结果表按 percentage 的 降序 排序，若相同则按 contest_id 的 升序 排序。
 *
 * 查询结果如下示例所示。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * Users 表：
 * +---------+-----------+
 * | user_id | user_name |
 * +---------+-----------+
 * | 6       | Alice     |
 * | 2       | Bob       |
 * | 7       | Alex      |
 * +---------+-----------+
 *
 * Register 表：
 * +------------+---------+
 * | contest_id | user_id |
 * +------------+---------+
 * | 215        | 6       |
 * | 209        | 2       |
 * | 208        | 2       |
 * | 210        | 6       |
 * | 208        | 6       |
 * | 209        | 7       |
 * | 209        | 6       |
 * | 215        | 7       |
 * | 208        | 7       |
 * | 210        | 2       |
 * | 207        | 2       |
 * | 210        | 7       |
 * +------------+---------+
 * 输出：
 * +------------+------------+
 * | contest_id | percentage |
 * +------------+------------+
 * | 208        | 100.0      |
 * | 209        | 100.0      |
 * | 210        | 100.0      |
 * | 215        | 66.67      |
 * | 207        | 33.33      |
 * +------------+------------+
 * 解释：
 * 所有用户都注册了 208、209 和 210 赛事，因此这些赛事的注册率为 100% ，我们按 contest_id 的降序排序加入结果表中。
 * Alice 和 Alex 注册了 215 赛事，注册率为 ((2/3) * 100) = 66.67%
 * Bob 注册了 207 赛事，注册率为 ((1/3) * 100) = 33.33%
 */
public class Code5 {

    public static void main(String[] args) {
        String sql="SELECT contest_id,  ROUND(count(*) / (select count(*) FROM Users) * 100,2 ) as percentage  FROM Register GROUP BY contest_id  ORDER BY percentage DESC,contest_id";
    }
}
