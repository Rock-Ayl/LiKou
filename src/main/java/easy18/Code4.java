package easy18;

/**
 * @Author ayl
 * @Date 2022-04-16
 * 1484. 按日期分组销售产品
 * SQL架构
 * 表 Activities：
 * <p>
 * +-------------+---------+
 * | 列名         | 类型    |
 * +-------------+---------+
 * | sell_date   | date    |
 * | product     | varchar |
 * +-------------+---------+
 * 此表没有主键，它可能包含重复项。
 * 此表的每一行都包含产品名称和在市场上销售的日期。
 * <p>
 * <p>
 * 编写一个 SQL 查询来查找每个日期、销售的不同产品的数量及其名称。
 * 每个日期的销售产品名称应按词典序排列。
 * 返回按 sell_date 排序的结果表。
 * 查询结果格式如下例所示。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：
 * Activities 表：
 * +------------+-------------+
 * | sell_date  | product     |
 * +------------+-------------+
 * | 2020-05-30 | Headphone   |
 * | 2020-06-01 | Pencil      |
 * | 2020-06-02 | Mask        |
 * | 2020-05-30 | Basketball  |
 * | 2020-06-01 | Bible       |
 * | 2020-06-02 | Mask        |
 * | 2020-05-30 | T-Shirt     |
 * +------------+-------------+
 * 输出：
 * +------------+----------+------------------------------+
 * | sell_date  | num_sold | products                     |
 * +------------+----------+------------------------------+
 * | 2020-05-30 | 3        | Basketball,Headphone,T-shirt |
 * | 2020-06-01 | 2        | Bible,Pencil                 |
 * | 2020-06-02 | 1        | Mask                         |
 * +------------+----------+------------------------------+
 * 解释：
 * 对于2020-05-30，出售的物品是 (Headphone, Basketball, T-shirt)，按词典序排列，并用逗号 ',' 分隔。
 * 对于2020-06-01，出售的物品是 (Pencil, Bible)，按词典序排列，并用逗号分隔。
 * 对于2020-06-02，出售的物品是 (Mask)，只需返回该物品名。
 */
public class Code4 {

    public static void main(String[] args) {
        String sql = "select a.sell_date,count(*) as num_sold,group_concat(a.product ORDER BY product ) as products from (select sell_date,product from Activities group by sell_date,product ) a group by a.sell_date ";
    }

}
