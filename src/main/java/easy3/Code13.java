package easy3;

/**
 * Created By Rock-Ayl on 2020-11-02
 * 596. 超过5名学生的课
 * SQL架构
 * 有一个courses 表 ，有: student (学生) 和 class (课程)。
 *
 * 请列出所有超过或等于5名学生的课。
 *
 * 例如，表：
 *
 * +---------+------------+
 * | student | class      |
 * +---------+------------+
 * | A       | Math       |
 * | B       | English    |
 * | C       | Math       |
 * | D       | Biology    |
 * | E       | Math       |
 * | F       | Computer   |
 * | G       | Math       |
 * | H       | Math       |
 * | I       | Math       |
 * +---------+------------+
 * 应该输出:
 *
 * +---------+
 * | class   |
 * +---------+
 * | Math    |
 * +---------+
 *
 *
 * 提示：
 *
 * 学生在每个课中不应被重复计算。
 */
public class Code13 {

    public static void main(String[] args) {
        String sql="SELECT a.class FROM (SELECT c.class,COUNT(c.student) size FROM (SELECT*FROM courses GROUP BY class,student) c GROUP BY class HAVING size>=5) a;";
    }
}
