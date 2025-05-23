package easy18;

/**
 * @Author ayl
 * @Date 2022-04-17
 * SQL架构
 * 表: Employees
 *
 * +-------------+------+
 * | Column Name | Type |
 * +-------------+------+
 * | emp_id      | int  |
 * | event_day   | date |
 * | in_time     | int  |
 * | out_time    | int  |
 * +-------------+------+
 * (emp_id, event_day, in_time) 是这个表的主键。
 * 该表显示了员工在办公室的出入情况。
 * event_day 是此事件发生的日期，in_time 是员工进入办公室的时间，而 out_time 是他们离开办公室的时间。
 * in_time 和 out_time 的取值在1到1440之间。
 * 题目保证同一天没有两个事件在时间上是相交的，并且保证 in_time 小于 out_time。
 *
 *
 * 编写一个SQL查询以计算每位员工每天在办公室花费的总时间（以分钟为单位）。 请注意，在一天之内，同一员工是可以多次进入和离开办公室的。 在办公室里一次进出所花费的时间为out_time 减去 in_time。
 *
 * 返回结果表单的顺序无要求。
 * 查询结果的格式如下：
 *
 * Employees table:
 * +--------+------------+---------+----------+
 * | emp_id | event_day  | in_time | out_time |
 * +--------+------------+---------+----------+
 * | 1      | 2020-11-28 | 4       | 32       |
 * | 1      | 2020-11-28 | 55      | 200      |
 * | 1      | 2020-12-03 | 1       | 42       |
 * | 2      | 2020-11-28 | 3       | 33       |
 * | 2      | 2020-12-09 | 47      | 74       |
 * +--------+------------+---------+----------+
 * Result table:
 * +------------+--------+------------+
 * | day        | emp_id | total_time |
 * +------------+--------+------------+
 * | 2020-11-28 | 1      | 173        |
 * | 2020-11-28 | 2      | 30         |
 * | 2020-12-03 | 1      | 41         |
 * | 2020-12-09 | 2      | 27         |
 * +------------+--------+------------+
 * 雇员 1 有三次进出: 有两次发生在 2020-11-28 花费的时间为 (32 - 4) + (200 - 55) = 173, 有一次发生在 2020-12-03 花费的时间为 (42 - 1) = 41。
 * 雇员 2 有两次进出: 有一次发生在 2020-11-28 花费的时间为 (33 - 3) = 30,  有一次发生在 2020-12-09 花费的时间为 (74 - 47) = 27。
 * 通过次数4,563提交次数5,393
 */
public class Code5 {

    public static void main(String[] args) {
        String sql = "select a.day,a.emp_id,sum(a.total_time) as total_time from (select event_day as day,emp_id,(out_time - in_time) as total_time from Employees) a group by a.day,a.emp_id";
    }

}
