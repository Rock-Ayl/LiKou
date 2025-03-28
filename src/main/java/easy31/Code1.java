package easy31;

/**
 * @Author ayl
 * @Date 2023-05-21
 * 1683. 无效的推文
 * SQL架构
 * 表：Tweets
 * <p>
 * +----------------+---------+
 * | Column Name    | Type    |
 * +----------------+---------+
 * | tweet_id       | int     |
 * | content        | varchar |
 * +----------------+---------+
 * tweet_id 是这个表的主键。
 * 这个表包含某社交媒体 App 中所有的推文。
 * <p>
 * <p>
 * 写一条 SQL 语句，查询所有无效推文的编号（ID）。当推文内容中的字符数严格大于 15 时，该推文是无效的。
 * <p>
 * 以任意顺序返回结果表。
 * <p>
 * 查询结果格式如下示例所示：
 * <p>
 * <p>
 * <p>
 * Tweets 表：
 * +----------+----------------------------------+
 * | tweet_id | content                          |
 * +----------+----------------------------------+
 * | 1        | Vote for Biden                   |
 * | 2        | Let us make America great again! |
 * +----------+----------------------------------+
 * <p>
 * 结果表：
 * +----------+
 * | tweet_id |
 * +----------+
 * | 2        |
 * +----------+
 * 推文 1 的长度 length = 14。该推文是有效的。
 * 推文 2 的长度 length = 32。该推文是无效的。
 */
public class Code1 {

    public static void main(String[] args) {
        String sql = "SELECT a.tweet_id FROM (SELECT tweet_id,content,length(content) as count FROM Tweets )a where a.count >15";
    }
}
