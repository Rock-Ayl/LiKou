package easy4;

/**
 * Created By Rock-Ayl on 2020-12-05
 * 180. 连续出现的数字
 * SQL架构
 * 编写一个 SQL 查询，查找所有至少连续出现三次的数字。
 * <p>
 * +----+-----+
 * | Id | Num |
 * +----+-----+
 * | 1  |  1  |
 * | 2  |  1  |
 * | 3  |  1  |
 * | 4  |  2  |
 * | 5  |  1  |
 * | 6  |  2  |
 * | 7  |  2  |
 * +----+-----+
 * 例如，给定上面的 Logs 表， 1 是唯一连续出现至少三次的数字。
 * <p>
 * +-----------------+
 * | ConsecutiveNums |
 * +-----------------+
 * | 1               |
 * +-----------------+
 */
public class Code5 {

    public static void main(String[] args) {
        String sql = "SELECT a.Num as ConsecutiveNums FROM Logs a,Logs b,Logs c WHERE a.Id+1=b.Id AND b.Id+1=c.Id AND a.Num=b.Num AND b.Num=c.Num GROUP BY a.Num";
    }
}
