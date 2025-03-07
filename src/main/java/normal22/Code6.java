package normal22;

/**
 * @Author ayl
 * @Date 2023-07-19
 * 1070. 产品销售分析 III
 * SQL架构
 * 销售表 Sales：
 *
 * +-------------+-------+
 * | Column Name | Type  |
 * +-------------+-------+
 * | sale_id     | int   |
 * | product_id  | int   |
 * | year        | int   |
 * | quantity    | int   |
 * | price       | int   |
 * +-------------+-------+
 * (sale_id, year) 是这张表的主键。
 * product_id 是产品表的外键。
 * 这张表的每一行都表示：编号 product_id 的产品在某一年的销售额。
 * 请注意，价格是按每单位计的。
 *
 *
 * 产品表 Product：
 *
 * +--------------+---------+
 * | Column Name  | Type    |
 * +--------------+---------+
 * | product_id   | int     |
 * | product_name | varchar |
 * +--------------+---------+
 * product_id 是这张表的主键。
 * 这张表的每一行都标识：每个产品的 id 和 产品名称。
 *
 *
 * 编写一个 SQL 查询，选出每个销售产品 第一年 销售的 产品 id、年份、数量 和 价格。
 *
 * 结果表中的条目可以按 任意顺序 排列。
 *
 * 查询结果格式如下例所示：
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * Sales 表：
 * +---------+------------+------+----------+-------+
 * | sale_id | product_id | year | quantity | price |
 * +---------+------------+------+----------+-------+
 * | 1       | 100        | 2008 | 10       | 5000  |
 * | 2       | 100        | 2009 | 12       | 5000  |
 * | 7       | 200        | 2011 | 15       | 9000  |
 * +---------+------------+------+----------+-------+
 * Product 表：
 * +------------+--------------+
 * | product_id | product_name |
 * +------------+--------------+
 * | 100        | Nokia        |
 * | 200        | Apple        |
 * | 300        | Samsung      |
 * +------------+--------------+
 * 输出：
 * +------------+------------+----------+-------+
 * | product_id | first_year | quantity | price |
 * +------------+------------+----------+-------+
 * | 100        | 2008       | 10       | 5000  |
 * | 200        | 2011       | 15       | 9000  |
 * +------------+------------+----------+-------+
 */
public class Code6 {

    public static void main(String[] args) {
        String sql="SELECT a.product_id,a.year as first_year,a.quantity,a.price FROM (SELECT a.* FROM Sales a,(SELECT product_id,min(year) as firstYear FROM Sales GROUP BY product_id) b WHERE a.product_id = b.product_id and a.year = b.firstYear) a";
    }
}
