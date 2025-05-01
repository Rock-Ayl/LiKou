package normal42;

/**
 * @Author ayl
 * @Date 2025-05-01
 * 3521. 查找推荐产品对
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * SQL Schema
 * Pandas Schema
 * 表：ProductPurchases
 *
 * +-------------+------+
 * | Column Name | Type |
 * +-------------+------+
 * | user_id     | int  |
 * | product_id  | int  |
 * | quantity    | int  |
 * +-------------+------+
 * (user_id, product_id) 是这张表的唯一主键。
 * 每一行代表用户以特定数量购买的产品。
 * 表：ProductInfo
 *
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | product_id  | int     |
 * | category    | varchar |
 * | price       | decimal |
 * +-------------+---------+
 * product_id 是这张表的唯一主键。
 * 每一行表示一个产品的类别和价格。
 * 亚马逊希望根据 共同购买模式 实现 “购买此商品的用户还购买了...” 功能。编写一个解决方案以实现：
 *
 * 识别 被同一客户一起频繁购买的 不同 产品对（其中 product1_id < product2_id）
 * 对于 每个产品对，确定有多少客户购买了这两种产品
 * 如果 至少有 3 位不同的 客户同时购买了这两种产品，则认为该 产品对 适合推荐。
 *
 * 返回结果表以 customer_count  降序 排序，并且为了避免排序持平，以 product1_id 升序 排序，并以 product2_id 升序 排序。
 *
 * 结果格式如下所示。
 *
 *
 *
 * 示例：
 *
 * 输入：
 *
 * ProductPurchases 表：
 *
 * +---------+------------+----------+
 * | user_id | product_id | quantity |
 * +---------+------------+----------+
 * | 1       | 101        | 2        |
 * | 1       | 102        | 1        |
 * | 1       | 103        | 3        |
 * | 2       | 101        | 1        |
 * | 2       | 102        | 5        |
 * | 2       | 104        | 1        |
 * | 3       | 101        | 2        |
 * | 3       | 103        | 1        |
 * | 3       | 105        | 4        |
 * | 4       | 101        | 1        |
 * | 4       | 102        | 1        |
 * | 4       | 103        | 2        |
 * | 4       | 104        | 3        |
 * | 5       | 102        | 2        |
 * | 5       | 104        | 1        |
 * +---------+------------+----------+
 * ProductInfo 表：
 *
 * +------------+-------------+-------+
 * | product_id | category    | price |
 * +------------+-------------+-------+
 * | 101        | Electronics | 100   |
 * | 102        | Books       | 20    |
 * | 103        | Clothing    | 35    |
 * | 104        | Kitchen     | 50    |
 * | 105        | Sports      | 75    |
 * +------------+-------------+-------+
 * 输出：
 *
 * +-------------+-------------+-------------------+-------------------+----------------+
 * | product1_id | product2_id | product1_category | product2_category | customer_count |
 * +-------------+-------------+-------------------+-------------------+----------------+
 * | 101         | 102         | Electronics       | Books             | 3              |
 * | 101         | 103         | Electronics       | Clothing          | 3              |
 * | 102         | 104         | Books             | Kitchen           | 3              |
 * +-------------+-------------+-------------------+-------------------+----------------+
 * 解释：
 *
 * 产品对 (101, 102)：
 * 被用户 1，2 和 4 购买（3 个消费者）
 * 产品 101 属于电子商品类别
 * 产品 102 属于图书类别
 * 产品对 (101, 103)：
 * 被用户 1，3 和 4 购买（3 个消费者）
 * 产品 101 属于电子商品类别
 * 产品 103 属于服装类别
 * 产品对 (102, 104)：
 * 被用户 2，4 和 5 购买（3 个消费者）
 * 产品 102 属于图书类别
 * 产品 104 属于厨房用品类别
 * 结果以 customer_count 降序排序。对于有相同 customer_count 的产品对，将它们以 product1_id 升序排序，然后以 product2_id 升序排序。
 */
public class Code12 {

    String sql="SELECT a.product1_id,a.product2_id,b.category as product1_category,c.category as product2_category,a.customer_count FROM ( SELECT a.product1_id,a.product2_id,a.customer_count FROM ( SELECT a.product1_id,a.product2_id,count(*) as customer_count FROM ( SELECT a.product_id as product1_id,b.product_id as product2_id FROM ( SELECT user_id,product_id,SUM(quantity) as quantity FROM ProductPurchases GROUP BY user_id,product_id ) a,( SELECT user_id,product_id,SUM(quantity) as quantity FROM ProductPurchases GROUP BY user_id,product_id ) b WHERE a.product_id < b.product_id AND a.user_id = b.user_id ) a GROUP BY a.product1_id,a.product2_id ) a   WHERE a.customer_count > 2 ) a  LEFT JOIN ProductInfo b ON a.product1_id =  b.product_id LEFT JOIN ProductInfo c ON a.product2_id =  c.product_id ORDER BY a.customer_count DESC,a.product1_id ASC ,a.product2_id ASC ";

}
