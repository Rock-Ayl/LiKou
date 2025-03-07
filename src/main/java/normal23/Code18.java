package normal23;

/**
 * @Author ayl
 * @Date 2023-09-02
 * 1164. 指定日期的产品价格
 * 中等
 * 131
 * 相关企业
 * SQL Schema
 * 产品数据表: Products
 *
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | product_id    | int     |
 * | new_price     | int     |
 * | change_date   | date    |
 * +---------------+---------+
 * 这张表的主键是 (product_id, change_date)。
 * 这张表的每一行分别记录了 某产品 在某个日期 更改后 的新价格。
 *
 *
 * 写一段 SQL来查找在 2019-08-16 时全部产品的价格，假设所有产品在修改前的价格都是 10 。
 *
 * 以 任意顺序 返回结果表。
 *
 * 查询结果格式如下例所示。
 *
 *
 *
 * 示例 1:
 *
 * 输入：
 * Products 表:
 * +------------+-----------+-------------+
 * | product_id | new_price | change_date |
 * +------------+-----------+-------------+
 * | 1          | 20        | 2019-08-14  |
 * | 2          | 50        | 2019-08-14  |
 * | 1          | 30        | 2019-08-15  |
 * | 1          | 35        | 2019-08-16  |
 * | 2          | 65        | 2019-08-17  |
 * | 3          | 20        | 2019-08-18  |
 * +------------+-----------+-------------+
 * 输出：
 * +------------+-------+
 * | product_id | price |
 * +------------+-------+
 * | 2          | 50    |
 * | 1          | 35    |
 * | 3          | 10    |
 * +------------+-------+
 */
public class Code18 {

    public static void main(String[] args) {
       String Sql="SELECT a.product_id,a.new_price as price FROM Products a, (SELECT a.product_id,MAX(a.change_date) as max_date FROM (SELECT * FROM Products WHERE change_date <='2019-08-16') a GROUP BY a.product_id) b WHERE a.product_id = b.product_id and a.change_date = b.max_date union SELECT product_id,10 as price FROM Products WHERE product_id not IN (SELECT product_id FROM Products WHERE change_date <='2019-08-16' GROUP BY product_id)";
    }

}
