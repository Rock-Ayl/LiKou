package easy3;

/**
 * Created By Rock-Ayl on 2020-10-28
 * 197. 上升的温度
 * SQL架构
 * 表 Weather
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | id            | int     |
 * | recordDate    | date    |
 * | temperature   | int     |
 * +---------------+---------+
 * id 是这个表的主键
 * 该表包含特定日期的温度信息
 * <p>
 * <p>
 * 编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 id 。
 * <p>
 * 返回结果 不要求顺序 。
 * <p>
 * 查询结果格式如下例：
 * <p>
 * Weather
 * +----+------------+-------------+
 * | id | recordDate | Temperature |
 * +----+------------+-------------+
 * | 1  | 2015-01-01 | 10          |
 * | 2  | 2015-01-02 | 25          |
 * | 3  | 2015-01-03 | 20          |
 * | 4  | 2015-01-04 | 30          |
 * +----+------------+-------------+
 * <p>
 * Result table:
 * +----+
 * | id |
 * +----+
 * | 2  |
 * | 4  |
 * +----+
 * 2015-01-02 的温度比前一天高（10 -> 25）
 * 2015-01-04 的温度比前一天高（30 -> 20）
 */
public class Code8 {

    public static void main(String[] args) {
        String sql = "SELECT b.id FROM `Weather` a,`Weather` b WHERE to_days(b.recorddate) -to_days(a.recorddate)=1 AND a.Temperature< b.Temperature";
    }

}
