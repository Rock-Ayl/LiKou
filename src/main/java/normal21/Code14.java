package normal21;

/**
 * @Author ayl
 * @Date 2023-07-06
 * 1045. 买下所有产品的客户
 * SQL架构
 * Customer 表：
 * <p>
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | customer_id | int     |
 * | product_key | int     |
 * +-------------+---------+
 * product_key 是 Customer 表的外键。
 * Product 表：
 * <p>
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | product_key | int     |
 * +-------------+---------+
 * product_key 是这张表的主键。
 * <p>
 * <p>
 * 写一条 SQL 查询语句，从 Customer 表中查询购买了 Product 表中所有产品的客户的 id。
 * <p>
 * 示例：
 * <p>
 * Customer 表：
 * +-------------+-------------+
 * | customer_id | product_key |
 * +-------------+-------------+
 * | 1           | 5           |
 * | 2           | 6           |
 * | 3           | 5           |
 * | 3           | 6           |
 * | 1           | 6           |
 * +-------------+-------------+
 * <p>
 * Product 表：
 * +-------------+
 * | product_key |
 * +-------------+
 * | 5           |
 * | 6           |
 * +-------------+
 * <p>
 * Result 表：
 * +-------------+
 * | customer_id |
 * +-------------+
 * | 1           |
 * | 3           |
 * +-------------+
 * 购买了所有产品（5 和 6）的客户的 id 是 1 和 3 。
 */
public class Code14 {

    public static void main(String[] args) {
        String sql = "SELECT a.customer_id FROM (SELECT a.customer_id,count(*) as count FROM (SELECT customer_id,product_key as count FROM Customer WHERE product_key in(SELECT product_key FROM Product) GROUP BY customer_id,product_key) a GROUP BY a.customer_id ) a  WHERE a.count in (SELECT count(*) FROM Product)";
    }
}
