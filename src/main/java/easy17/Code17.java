package easy17;

/**
 * @Author ayl
 * @Date 2022-04-08
 * 1084. 销售分析III
 * SQL架构
 * Table: Product
 *
 * +--------------+---------+
 * | Column Name  | Type    |
 * +--------------+---------+
 * | product_id   | int     |
 * | product_name | varchar |
 * | unit_price   | int     |
 * +--------------+---------+
 * Product_id是该表的主键。
 * 该表的每一行显示每个产品的名称和价格。
 * Table: Sales
 *
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | seller_id   | int     |
 * | product_id  | int     |
 * | buyer_id    | int     |
 * | sale_date   | date    |
 * | quantity    | int     |
 * | price       | int     |
 * +------ ------+---------+
 * 这个表没有主键，它可以有重复的行。
 * product_id 是 Product 表的外键。
 * 该表的每一行包含关于一个销售的一些信息。
 *
 *
 * 编写一个SQL查询，报告2019年春季才售出的产品。即仅在2019-01-01至2019-03-31（含）之间出售的商品。
 *
 * 以 任意顺序 返回结果表。
 *
 * 查询结果格式如下所示。
 *
 *
 *
 * 示例 1:
 *
 * 输入：
 * Product table:
 * +------------+--------------+------------+
 * | product_id | product_name | unit_price |
 * +------------+--------------+------------+
 * | 1          | S8           | 1000       |
 * | 2          | G4           | 800        |
 * | 3          | iPhone       | 1400       |
 * +------------+--------------+------------+
 * Sales table:
 * +-----------+------------+----------+------------+----------+-------+
 * | seller_id | product_id | buyer_id | sale_date  | quantity | price |
 * +-----------+------------+----------+------------+----------+-------+
 * | 1         | 1          | 1        | 2019-01-21 | 2        | 2000  |
 * | 1         | 2          | 2        | 2019-02-17 | 1        | 800   |
 * | 2         | 2          | 3        | 2019-06-02 | 1        | 800   |
 * | 3         | 3          | 4        | 2019-05-13 | 2        | 2800  |
 * +-----------+------------+----------+------------+----------+-------+
 * 输出：
 * +-------------+--------------+
 * | product_id  | product_name |
 * +-------------+--------------+
 * | 1           | S8           |
 * +-------------+--------------+
 * 解释:
 * id为1的产品仅在2019年春季销售。
 * id为2的产品在2019年春季销售，但也在2019年春季之后销售。
 * id 3的产品在2019年春季之后销售。
 * 我们只退回产品1，因为它是2019年春季才销售的产品。
 * 通过次数14,342提交次数26,583
 */
public class Code17 {

    public static void main(String[] args) {
        String sql = "select product_id,product_name from Product where product_id in(select product_id from Sales where sale_date >= '2019-01-01' and sale_date <= '2019-03-31' group by product_id) and product_id not in (select product_id from Sales where sale_date < '2019-01-01' or sale_date > '2019-03-31' group by product_id)";
    }
}
