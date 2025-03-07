package normal35;

/**
 * @Author ayl
 * @Date 2024-09-14
 * 3220. 奇数和偶数交易
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * SQL Schema
 * Pandas Schema
 * 表：transactions
 *
 * +------------------+------+
 * | Column Name      | Type |
 * +------------------+------+
 * | transaction_id   | int  |
 * | amount           | int  |
 * | transaction_date | date |
 * +------------------+------+
 * transactions_id 列唯一标识了表中的每一行。
 * 这张表的每一行包含交易 id，金额总和和交易日期。
 * 编写一个解决方案来查找每天 奇数 交易金额和 偶数 交易金额的 总和。如果某天没有奇数或偶数交易，显示为 0。
 *
 * 返回结果表以 transaction_date 升序 排序。
 *
 * 结果格式如下所示。
 *
 *
 *
 * 示例：
 *
 * 输入：
 *
 * transactions 表：
 *
 * +----------------+--------+------------------+
 * | transaction_id | amount | transaction_date |
 * +----------------+--------+------------------+
 * | 1              | 150    | 2024-07-01       |
 * | 2              | 200    | 2024-07-01       |
 * | 3              | 75     | 2024-07-01       |
 * | 4              | 300    | 2024-07-02       |
 * | 5              | 50     | 2024-07-02       |
 * | 6              | 120    | 2024-07-03       |
 * +----------------+--------+------------------+
 *
 * 输出：
 *
 * +------------------+---------+----------+
 * | transaction_date | odd_sum | even_sum |
 * +------------------+---------+----------+
 * | 2024-07-01       | 75      | 350      |
 * | 2024-07-02       | 0       | 350      |
 * | 2024-07-03       | 0       | 120      |
 * +------------------+---------+----------+
 *
 * 解释：
 *
 * 对于交易日期：
 * 2024-07-01:
 * 奇数交易金额总和：75
 * 偶数交易金额总和：150 + 200 = 350
 * 2024-07-02:
 * 奇数交易金额总和：0
 * 偶数交易金额总和：300 + 50 = 350
 * 2024-07-03:
 * 奇数交易金额总和：0
 * 偶数交易金额总和：120
 * 注意：输出表以 transaction_date 升序排序。
 */
public class Code4 {

    public static void main(String[] args) {
        String sql = "SELECT a.transaction_date, SUM( odd_amount ) AS odd_sum, SUM( even_amount ) AS even_sum FROM ( SELECT transaction_id, transaction_date, IF ( amount % 2 = 0, 0, amount ) AS odd_amount, IF( amount % 2 = 0, amount, 0 ) AS even_amount  FROM transactions ) a GROUP BY a.transaction_date ORDER BY a.transaction_date ASC";
    }

}
