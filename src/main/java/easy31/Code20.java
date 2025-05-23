package easy31;

/**
 * @Author ayl
 * @Date 2023-06-13
 * 1251. 平均售价
 * SQL架构
 * Table: Prices
 *
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | product_id    | int     |
 * | start_date    | date    |
 * | end_date      | date    |
 * | price         | int     |
 * +---------------+---------+
 * (product_id，start_date，end_date) 是 Prices 表的主键。
 * Prices 表的每一行表示的是某个产品在一段时期内的价格。
 * 每个产品的对应时间段是不会重叠的，这也意味着同一个产品的价格时段不会出现交叉。
 *
 *
 * Table: UnitsSold
 *
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | product_id    | int     |
 * | purchase_date | date    |
 * | units         | int     |
 * +---------------+---------+
 * UnitsSold 表没有主键，它可能包含重复项。
 * UnitsSold 表的每一行表示的是每种产品的出售日期，单位和产品 id。
 *
 *
 * 编写SQL查询以查找每种产品的平均售价。
 * average_price 应该四舍五入到小数点后两位。
 * 查询结果格式如下例所示：
 *
 * Prices table:
 * +------------+------------+------------+--------+
 * | product_id | start_date | end_date   | price  |
 * +------------+------------+------------+--------+
 * | 1          | 2019-02-17 | 2019-02-28 | 5      |
 * | 1          | 2019-03-01 | 2019-03-22 | 20     |
 * | 2          | 2019-02-01 | 2019-02-20 | 15     |
 * | 2          | 2019-02-21 | 2019-03-31 | 30     |
 * +------------+------------+------------+--------+
 *
 * UnitsSold table:
 * +------------+---------------+-------+
 * | product_id | purchase_date | units |
 * +------------+---------------+-------+
 * | 1          | 2019-02-25    | 100   |
 * | 1          | 2019-03-01    | 15    |
 * | 2          | 2019-02-10    | 200   |
 * | 2          | 2019-03-22    | 30    |
 * +------------+---------------+-------+
 *
 * Result table:
 * +------------+---------------+
 * | product_id | average_price |
 * +------------+---------------+
 * | 1          | 6.96          |
 * | 2          | 16.96         |
 * +------------+---------------+
 * 平均售价 = 产品总价 / 销售的产品数量。
 * 产品 1 的平均售价 = ((100 * 5)+(15 * 20) )/ 115 = 6.96
 * 产品 2 的平均售价 = ((200 * 15)+(30 * 30) )/ 230 = 16.96
 * 通过次数23,126提交次数30,682
 */
public class Code20 {

    String sql="SELECT a.product_id,ROUND(SUM(a.priceSum) / SUM(a.units),2) as average_price FROM ( SELECT a.product_id,(a.units * b.price) as priceSum,a.units FROM UnitsSold a LEFT JOIN Prices b on a.product_id = b.product_id and a.purchase_date >= b.start_date and a.purchase_date <= b.end_date ) a GROUP BY a.product_id";
}
