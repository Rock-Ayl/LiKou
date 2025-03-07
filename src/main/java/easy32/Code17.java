package easy32;

/**
 * @Author ayl
 * @Date 2023-08-01
 * 2082. 富有客户的数量
 * SQL架构
 * Pandas 架构
 * 表： Store
 *
 * +-------------+------+
 * | Column Name | Type |
 * +-------------+------+
 * | bill_id     | int  |
 * | customer_id | int  |
 * | amount      | int  |
 * +-------------+------+
 * 在 SQL 中，bill_id 是这个表的主键。
 * 每一行包含一个订单的金额及相关客户的信息。
 *
 *
 * 查询至少有一个订单的金额严格大于 500 的客户的数量。
 *
 * 返回结果格式如下示例所示：
 *
 *
 *
 * 示例:
 *
 * 输入：
 * Store 表:
 * +---------+-------------+--------+
 * | bill_id | customer_id | amount |
 * +---------+-------------+--------+
 * | 6       | 1           | 549    |
 * | 8       | 1           | 834    |
 * | 4       | 2           | 394    |
 * | 11      | 3           | 657    |
 * | 13      | 3           | 257    |
 * +---------+-------------+--------+
 * 输出：
 * +------------+
 * | rich_count |
 * +------------+
 * | 2          |
 * +------------+
 * 解释：
 * 客户 1 有 2 个订单金额严格大于 500。
 * 客户 2 没有任何订单金额严格大于 500。
 * 客户 3 有 1 个订单金额严格大于 500。
 * 通过次数2,804提交次数3,775
 */
public class Code17 {

    public static void main(String[] args) {
        String sql="SELECT count(*) as rich_count FROM (SELECT * FROM (SELECT customer_id,MAX(amount) as maxAmount FROM Store GROUP BY customer_id ) A WHERE A.maxAmount > 500) A ";
    }

}
