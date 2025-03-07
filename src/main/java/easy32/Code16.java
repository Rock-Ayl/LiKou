package easy32;

/**
 * @Author ayl
 * @Date 2023-07-30
 * 1173. 即时食物配送 I
 * SQL架构
 * Pandas 架构
 * 配送表: Delivery
 *
 * +-----------------------------+---------+
 * | Column Name                 | Type    |
 * +-----------------------------+---------+
 * | delivery_id                 | int     |
 * | customer_id                 | int     |
 * | order_date                  | date    |
 * | customer_pref_delivery_date | date    |
 * +-----------------------------+---------+
 * 在 SQL 中，delivery_id 是表的主键。
 * 该表保存着顾客的食物配送信息，顾客在某个日期下了订单，并指定了一个期望的配送日期（和下单日期相同或者在那之后）。
 *
 *
 * 如果顾客期望的配送日期和下单日期相同，则该订单称为 「即时订单」，否则称为「计划订单」。
 *
 * 查询即时订单所占的百分比， 保留两位小数。
 *
 * 查询结果如下所示。
 *
 *
 *
 * 示例 1:
 *
 * 输入：
 * Delivery 表:
 * +-------------+-------------+------------+-----------------------------+
 * | delivery_id | customer_id | order_date | customer_pref_delivery_date |
 * +-------------+-------------+------------+-----------------------------+
 * | 1           | 1           | 2019-08-01 | 2019-08-02                  |
 * | 2           | 5           | 2019-08-02 | 2019-08-02                  |
 * | 3           | 1           | 2019-08-11 | 2019-08-11                  |
 * | 4           | 3           | 2019-08-24 | 2019-08-26                  |
 * | 5           | 4           | 2019-08-21 | 2019-08-22                  |
 * | 6           | 2           | 2019-08-11 | 2019-08-13                  |
 * +-------------+-------------+------------+-----------------------------+
 * 输出：
 * +----------------------+
 * | immediate_percentage |
 * +----------------------+
 * | 33.33                |
 * +----------------------+
 * 解释：2 和 3 号订单为即时订单，其他的为计划订单。
 * 通过次数19,692提交次数25,766
 */
public class Code16 {

    public static void main(String[] args) {
       String Sql="SELECT ROUND(a.count / b.count  *100,2) as immediate_percentage FROM (SELECT  count(*) as count FROM Delivery WHERE order_date = customer_pref_delivery_date) a,(SELECT  COUNT(*) as count FROM Delivery)b";
    }
}
