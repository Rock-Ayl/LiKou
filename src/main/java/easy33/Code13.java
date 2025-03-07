package easy33;

/**
 * @Author ayl
 * @Date 2023-09-24
 * 1179. 重新格式化部门表
 * 简单
 * 235
 * 相关企业
 * SQL Schema
 * 表 Department：
 *
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | id            | int     |
 * | revenue       | int     |
 * | month         | varchar |
 * +---------------+---------+
 * 在 SQL 中，(id, month) 是表的联合主键。
 * 这个表格有关于每个部门每月收入的信息。
 * 月份（month）可以取下列值 ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"]。
 *
 *
 * 重新格式化表格，使得 每个月 都有一个部门 id 列和一个收入列。
 *
 * 以 任意顺序 返回结果表。
 *
 * 结果格式如以下示例所示。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * Department table:
 * +------+---------+-------+
 * | id   | revenue | month |
 * +------+---------+-------+
 * | 1    | 8000    | Jan   |
 * | 2    | 9000    | Jan   |
 * | 3    | 10000   | Feb   |
 * | 1    | 7000    | Feb   |
 * | 1    | 6000    | Mar   |
 * +------+---------+-------+
 * 输出：
 * +------+-------------+-------------+-------------+-----+-------------+
 * | id   | Jan_Revenue | Feb_Revenue | Mar_Revenue | ... | Dec_Revenue |
 * +------+-------------+-------------+-------------+-----+-------------+
 * | 1    | 8000        | 7000        | 6000        | ... | null        |
 * | 2    | 9000        | null        | null        | ... | null        |
 * | 3    | null        | 10000       | null        | ... | null        |
 * +------+-------------+-------------+-------------+-----+-------------+
 * 解释：四月到十二月的收入为空。
 */
public class Code13 {

    public static void main(String[] args) {
       String  sql="SELECT a.id, b.revenue AS Jan_Revenue, c.revenue AS Feb_Revenue , d.revenue AS Mar_Revenue , e.revenue AS Apr_Revenue , f.revenue AS May_Revenue, g.revenue AS Jun_Revenue, h.revenue AS Jul_Revenue, i.revenue AS Aug_Revenue, j.revenue AS Sep_Revenue, k.revenue AS Oct_Revenue, o.revenue AS Nov_Revenue, p.revenue AS Dec_Revenue FROM(SELECT a.id FROM Department a GROUP BY id) a LEFT JOIN Department b ON a.id = b.id AND b.`month` = 'Jan' LEFT JOIN Department c ON a.id = c.id AND c.`month` = 'Feb' LEFT JOIN Department d ON a.id = d.id AND d.`month` = 'Mar' LEFT JOIN Department e ON a.id = e.id AND e.`month` = 'Apr' LEFT JOIN Department f ON a.id = f.id AND f.`month` = 'May' LEFT JOIN Department g ON a.id = g.id AND g.`month` = 'Jun' LEFT JOIN Department h ON a.id = h.id AND h.`month` = 'Jul' LEFT JOIN Department i ON a.id = i.id AND i.`month` = 'Aug' LEFT JOIN Department j ON a.id = j.id AND j.`month` = 'Sep' LEFT JOIN Department k ON a.id = k.id AND k.`month` = 'Oct' LEFT JOIN Department o ON a.id = o.id AND o.`month` = 'Nov' LEFT JOIN Department p ON a.id = p.id AND p.`month` = 'Dec' ORDER BY a.id";
    }
}
