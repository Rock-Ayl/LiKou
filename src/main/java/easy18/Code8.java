package easy18;

/**
 * @Author ayl
 * @Date 2022-04-19
 * 1795. 每个产品在不同商店的价格
 * SQL架构
 * 表：Products
 *
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | product_id  | int     |
 * | store1      | int     |
 * | store2      | int     |
 * | store3      | int     |
 * +-------------+---------+
 * 这张表的主键是product_id（产品Id）。
 * 每行存储了这一产品在不同商店store1, store2, store3的价格。
 * 如果这一产品在商店里没有出售，则值将为null。
 *
 *
 * 请你重构 Products 表，查询每个产品在不同商店的价格，使得输出的格式变为(product_id, store, price) 。如果这一产品在商店里没有出售，则不输出这一行。
 *
 * 输出结果表中的 顺序不作要求 。
 *
 * 查询输出格式请参考下面示例。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * Products table:
 * +------------+--------+--------+--------+
 * | product_id | store1 | store2 | store3 |
 * +------------+--------+--------+--------+
 * | 0          | 95     | 100    | 105    |
 * | 1          | 70     | null   | 80     |
 * +------------+--------+--------+--------+
 * 输出：
 * +------------+--------+-------+
 * | product_id | store  | price |
 * +------------+--------+-------+
 * | 0          | store1 | 95    |
 * | 0          | store2 | 100   |
 * | 0          | store3 | 105   |
 * | 1          | store1 | 70    |
 * | 1          | store3 | 80    |
 * +------------+--------+-------+
 * 解释：
 * 产品0在store1，store2,store3的价格分别为95,100,105。
 * 产品1在store1，store3的价格分别为70,80。在store2无法买到。
 */
public class Code8 {

    public static void main(String[] args) {
        String sql = "select product_id,'store1' as store,store1 as price from Products  where store1 is not null union select product_id,'store2' as store,store2 as price from Products  where store2 is not null union select product_id,'store3' as store,store3 as price from Products where store3 is not null";
    }

}
