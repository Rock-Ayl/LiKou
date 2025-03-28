package easy18;

/**
 * @Author ayl
 * @Date 2022-04-14
 * 1729. 求关注者的数量
 * SQL架构
 * 表： Followers
 * <p>
 * +-------------+------+
 * | Column Name | Type |
 * +-------------+------+
 * | user_id     | int  |
 * | follower_id | int  |
 * +-------------+------+
 * (user_id, follower_id) 是这个表的主键。
 * 该表包含一个关注关系中关注者和用户的编号，其中关注者关注用户。
 * <p>
 * <p>
 * 写出 SQL 语句，对于每一个用户，返回该用户的关注者数量。
 * <p>
 * 按 user_id 的顺序返回结果表。
 * <p>
 * 查询结果的格式如下示例所示。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * Followers 表：
 * +---------+-------------+
 * | user_id | follower_id |
 * +---------+-------------+
 * | 0       | 1           |
 * | 1       | 0           |
 * | 2       | 0           |
 * | 2       | 1           |
 * +---------+-------------+
 * 输出：
 * +---------+----------------+
 * | user_id | followers_count|
 * +---------+----------------+
 * | 0       | 1              |
 * | 1       | 1              |
 * | 2       | 2              |
 * +---------+----------------+
 * 解释：
 * 0 的关注者有 {1}
 * 1 的关注者有 {0}
 * 2 的关注者有 {0,1}
 * 通过次数4,481提交次数7,102
 */
public class Code2 {

    public static void main(String[] args) {
        String sql = "select user_id,count(*) as followers_count from Followers group by user_id order by user_id";
    }

}
