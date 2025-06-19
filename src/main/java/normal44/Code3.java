package normal44;

/**
 * @Author ayl
 * @Date 2025-06-19
 * 3564. 季节性销售分析
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * SQL Schema
 * Pandas Schema
 * 表：sales
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | sale_id       | int     |
 * | product_id    | int     |
 * | sale_date     | date    |
 * | quantity      | int     |
 * | price         | decimal |
 * +---------------+---------+
 * sale_id 是这张表的唯一主键。
 * 每一行包含一件产品的销售信息，包括 product_id，销售日期，销售数量，以及单价。
 * 表：products
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | product_id    | int     |
 * | product_name  | varchar |
 * | category      | varchar |
 * +---------------+---------+
 * product_id 是这张表的唯一主键。
 * 每一行包含一件产品的信息，包括它的名字和分类。
 * 编写一个解决方案来找到每个季节最受欢迎的产品分类。季节定义如下：
 * <p>
 * 冬季：十二月，一月，二月
 * 春季：三月，四月，五月
 * 夏季：六月，七月，八月
 * 秋季：九月，十月，十一月
 * 一个 分类 的 受欢迎度 由某个 季节 的 总销售量 决定。如果有并列，选择总收入最高的类别 (quantity × price)。
 * <p>
 * 返回结果表以季节 升序 排序。
 * <p>
 * 结果格式如下所示。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * sales 表：
 * <p>
 * +---------+------------+------------+----------+-------+
 * | sale_id | product_id | sale_date  | quantity | price |
 * +---------+------------+------------+----------+-------+
 * | 1       | 1          | 2023-01-15 | 5        | 10.00 |
 * | 2       | 2          | 2023-01-20 | 4        | 15.00 |
 * | 3       | 3          | 2023-03-10 | 3        | 18.00 |
 * | 4       | 4          | 2023-04-05 | 1        | 20.00 |
 * | 5       | 1          | 2023-05-20 | 2        | 10.00 |
 * | 6       | 2          | 2023-06-12 | 4        | 15.00 |
 * | 7       | 5          | 2023-06-15 | 5        | 12.00 |
 * | 8       | 3          | 2023-07-24 | 2        | 18.00 |
 * | 9       | 4          | 2023-08-01 | 5        | 20.00 |
 * | 10      | 5          | 2023-09-03 | 3        | 12.00 |
 * | 11      | 1          | 2023-09-25 | 6        | 10.00 |
 * | 12      | 2          | 2023-11-10 | 4        | 15.00 |
 * | 13      | 3          | 2023-12-05 | 6        | 18.00 |
 * | 14      | 4          | 2023-12-22 | 3        | 20.00 |
 * | 15      | 5          | 2024-02-14 | 2        | 12.00 |
 * +---------+------------+------------+----------+-------+
 * products 表：
 * <p>
 * +------------+-----------------+----------+
 * | product_id | product_name    | category |
 * +------------+-----------------+----------+
 * | 1          | Warm Jacket     | Apparel  |
 * | 2          | Designer Jeans  | Apparel  |
 * | 3          | Cutting Board   | Kitchen  |
 * | 4          | Smart Speaker   | Tech     |
 * | 5          | Yoga Mat        | Fitness  |
 * +------------+-----------------+----------+
 * 输出：
 * <p>
 * +---------+----------+----------------+---------------+
 * | season  | category | total_quantity | total_revenue |
 * +---------+----------+----------------+---------------+
 * | Fall    | Apparel  | 10             | 120.00        |
 * | Spring  | Kitchen  | 3              | 54.00         |
 * | Summer  | Tech     | 5              | 100.00        |
 * | Winter  | Apparel  | 9              | 110.00        |
 * +---------+----------+----------------+---------------+
 * 解释：
 * <p>
 * 秋季（九月，十月，十一月）：
 * 服装：售出 10 件商品（在 9 月有 6 件夹克，在 11 月 有 4 条牛仔裤），收入 $120.00（6×$10.00 + 4×$15.00）
 * 健身: 9 月售出 3 张瑜伽垫，收入 $36.00
 * 最受欢迎：服装总数量最多（10）
 * 春季（三月，四月，五月）：
 * 厨房：5 月 售出 3 张菜板，收入 $54.00
 * 科技：4 月 售出 1 台智能音箱，收入 $20.00
 * 服装: 五月售出 2 件保暖夹克，收入 $20.00
 * 最受欢迎：厨房总数量最多（3）且收入最多（$54.00）
 * 夏季（六月，七月，八月）：
 * 服装：六月售出 4 件名牌牛仔裤，收入 $60.00
 * 健身：六月售出 5 张瑜伽垫，收入 $60.00
 * 厨房：七月售出 2 张菜板，收入 $36.00
 * 科技：八月售出 5 台智能音箱，收入 $100.00
 * 最受欢迎：科技和健身都有 5 件商品，但科技收入更多（$100.00 vs $60.00）
 * 冬季（十二月，一月，二月）：
 * 服装：售出 9 件商品（一月有 5 件夹克和 4 条牛仔裤），收入 $110.00
 * 厨房：十二月售出 6 张菜板，收入 $108.00
 * 科技：十二月售出 3 台智能音箱，收入 $60.00
 * 健身：二月售出 2 张瑜伽垫，收入 $24.00
 * 最受欢迎：服装总数量最多（9）且收入最多（$110.00）
 * 结果表以季节升序排序。
 */
public class Code3 {

    private String sql = "SELECT * FROM ( SELECT IF ( a.sale_group = 1, 'Winter', IF ( a.sale_group = 2, 'Spring', IF ( a.sale_group = 3, 'Summer', 'Fall' ))) AS season, a.category,a.total_quantity,a.total_price AS total_revenue FROM ( SELECT a.sale_group,a.category,a.total_price, a.total_quantity, RANK() OVER w AS 'rank' FROM ( SELECT a.sale_group, a.category, SUM( a.total_price ) AS total_price, SUM( a.quantity ) AS total_quantity  FROM ( SELECT a.sale_id,a.product_id,a.sale_date,a.quantity,a.price,a.sale_month,( a.quantity * a.price ) AS total_price, IF ( a.sale_month IN ( 12, 1, 2 ), 1, IF (a.sale_month IN ( 3, 4, 5 ),2,IF( a.sale_month IN ( 6, 7, 8 ), 3, 4 ))) AS sale_group,b.category FROM ( SELECT sale_id, product_id, sale_date, quantity, price, MONTH ( sale_date ) AS sale_month FROM sales ) a LEFT JOIN products b ON a.product_id = b.product_id ) a GROUP BY a.sale_group,a.category ) a WINDOW w AS ( PARTITION BY sale_group ORDER BY total_quantity DESC, total_price DESC )) a WHERE a.rank = 1 ) a ORDER BY a.season ASC";

}
