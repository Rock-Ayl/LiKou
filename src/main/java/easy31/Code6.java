package easy31;

/**
 * @Author ayl
 * @Date 2023-05-27
 * 1068. 产品销售分析 I
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
 * (sale_id, year) 是销售表 Sales 的主键.
 * product_id 是关联到产品表 Product 的外键.
 * 注意: price 表示每单位价格
 * 产品表 Product：
 *
 * +--------------+---------+
 * | Column Name  | Type    |
 * +--------------+---------+
 * | product_id   | int     |
 * | product_name | varchar |
 * +--------------+---------+
 * product_id 是表的主键.
 *
 *
 * 写一条SQL 查询语句获取 Sales 表中所有产品对应的 产品名称 product_name 以及该产品的所有 售卖年份 year 和 价格 price 。
 *
 * 查询结果中的顺序无特定要求。
 *
 * 查询结果格式示例如下：
 *
 *
 *
 * Sales 表：
 * +---------+------------+------+----------+-------+
 * | sale_id | product_id | year | quantity | price |
 * +---------+------------+------+----------+-------+
 * | 1       | 100        | 2008 | 10       | 5000  |
 * | 2       | 100        | 2009 | 12       | 5000  |
 * | 7       | 200        | 2011 | 15       | 9000  |
 * +---------+------------+------+----------+-------+
 *
 * Product 表：
 * +------------+--------------+
 * | product_id | product_name |
 * +------------+--------------+
 * | 100        | Nokia        |
 * | 200        | Apple        |
 * | 300        | Samsung      |
 * +------------+--------------+
 *
 * Result 表：
 * +--------------+-------+-------+
 * | product_name | year  | price |
 * +--------------+-------+-------+
 * | Nokia        | 2008  | 5000  |
 * | Nokia        | 2009  | 5000  |
 * | Apple        | 2011  | 9000  |
 * +--------------+-------+-------+
 */
public class Code6 {

    public static void main(String[] args) {
        String sql="select b.product_name,a.year,a.price from Sales a left join Product b on a.product_id=b.product_id";
    }
}
