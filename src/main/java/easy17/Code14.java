package easy17;

/**
 * @Author ayl
 * @Date 2022-04-05
 * 1050. 合作过至少三次的演员和导演
 * SQL架构
 * ActorDirector 表：
 * <p>
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | actor_id    | int     |
 * | director_id | int     |
 * | timestamp   | int     |
 * +-------------+---------+
 * timestamp 是这张表的主键.
 * <p>
 * <p>
 * 写一条SQL查询语句获取合作过至少三次的演员和导演的 id 对 (actor_id, director_id)
 * <p>
 * 示例：
 * <p>
 * ActorDirector 表：
 * +-------------+-------------+-------------+
 * | actor_id    | director_id | timestamp   |
 * +-------------+-------------+-------------+
 * | 1           | 1           | 0           |
 * | 1           | 1           | 1           |
 * | 1           | 1           | 2           |
 * | 1           | 2           | 3           |
 * | 1           | 2           | 4           |
 * | 2           | 1           | 5           |
 * | 2           | 1           | 6           |
 * +-------------+-------------+-------------+
 * <p>
 * Result 表：
 * +-------------+-------------+
 * | actor_id    | director_id |
 * +-------------+-------------+
 * | 1           | 1           |
 * +-------------+-------------+
 * 唯一的 id 对是 (1, 1)，他们恰好合作了 3 次。
 */
public class Code14 {

    public static void main(String[] args) {
        String sql = "SELECT actor_id,director_id FROM ActorDirector GROUP BY actor_id,director_id HAVING COUNT('timestamp')>2";
    }

}
