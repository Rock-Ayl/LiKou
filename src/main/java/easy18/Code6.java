package easy18;

/**
 * @Author ayl
 * @Date 2022-04-18
 * 1693. 每天的领导和合伙人
 * SQL架构
 * 表：DailySales
 *
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | date_id     | date    |
 * | make_name   | varchar |
 * | lead_id     | int     |
 * | partner_id  | int     |
 * +-------------+---------+
 * 该表没有主键。
 * 该表包含日期、产品的名称，以及售给的领导和合伙人的编号。
 * 名称只包含小写英文字母。
 *
 *
 * 写一条 SQL 语句，使得对于每一个 date_id 和 make_name，返回不同的 lead_id 以及不同的 partner_id 的数量。
 *
 * 按 任意顺序 返回结果表。
 *
 * 查询结果格式如下示例所示。
 *
 *
 *
 * 示例 1:
 *
 * 输入：
 * DailySales 表：
 * +-----------+-----------+---------+------------+
 * | date_id   | make_name | lead_id | partner_id |
 * +-----------+-----------+---------+------------+
 * | 2020-12-8 | toyota    | 0       | 1          |
 * | 2020-12-8 | toyota    | 1       | 0          |
 * | 2020-12-8 | toyota    | 1       | 2          |
 * | 2020-12-7 | toyota    | 0       | 2          |
 * | 2020-12-7 | toyota    | 0       | 1          |
 * | 2020-12-8 | honda     | 1       | 2          |
 * | 2020-12-8 | honda     | 2       | 1          |
 * | 2020-12-7 | honda     | 0       | 1          |
 * | 2020-12-7 | honda     | 1       | 2          |
 * | 2020-12-7 | honda     | 2       | 1          |
 * +-----------+-----------+---------+------------+
 * 输出：
 * +-----------+-----------+--------------+-----------------+
 * | date_id   | make_name | unique_leads | unique_partners |
 * +-----------+-----------+--------------+-----------------+
 * | 2020-12-8 | toyota    | 2            | 3               |
 * | 2020-12-7 | toyota    | 1            | 2               |
 * | 2020-12-8 | honda     | 2            | 2               |
 * | 2020-12-7 | honda     | 3            | 2               |
 * +-----------+-----------+--------------+-----------------+
 * 解释：
 * 在 2020-12-8，丰田（toyota）有领导者 = [0, 1] 和合伙人 = [0, 1, 2] ，同时本田（honda）有领导者 = [1, 2] 和合伙人 = [1, 2]。
 * 在 2020-12-7，丰田（toyota）有领导者 = [0] 和合伙人 = [1, 2] ，同时本田（honda）有领导者 = [0, 1, 2] 和合伙人 = [1, 2]。
 */
public class Code6 {

    public static void main(String[] args) {
        String sql="select a.date_id,a.make_name,a.unique_leads,b.unique_partners from (select a.date_id,a.make_name,count(*) unique_leads from (select DISTINCT date_id,make_name,lead_id from DailySales group by date_id,make_name,lead_id) a GROUP BY a.date_id,a.make_name) a,(select a.date_id,a.make_name,count(*) unique_partners from (select DISTINCT date_id,make_name,partner_id from DailySales group by date_id,make_name,partner_id) a GROUP BY a.date_id,a.make_name) b where a.date_id=b.date_id and a.make_name=b.make_name";
    }

}
