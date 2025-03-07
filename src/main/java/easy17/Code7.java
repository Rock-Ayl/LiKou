package easy17;

/**
 * @Author ayl
 * @Date 2022-03-31
 * 584. 寻找用户推荐人
 * SQL架构
 * 给定表 customer ，里面保存了所有客户信息和他们的推荐人。
 * <p>
 * +------+------+-----------+
 * | id   | name | referee_id|
 * +------+------+-----------+
 * |    1 | Will |      NULL |
 * |    2 | Jane |      NULL |
 * |    3 | Alex |         2 |
 * |    4 | Bill |      NULL |
 * |    5 | Zack |         1 |
 * |    6 | Mark |         2 |
 * +------+------+-----------+
 * 写一个查询语句，返回一个客户列表，列表中客户的推荐人的编号都 不是 2。
 * <p>
 * 对于上面的示例数据，结果为：
 * <p>
 * +------+
 * | name |
 * +------+
 * | Will |
 * | Jane |
 * | Bill |
 * | Zack |
 * +------+
 * 通过次数20,338提交次数26,446
 */
public class Code7 {

    public static void main(String[] args) {
        String sql = "SELECT name FROM customer where referee_id != 2 or referee_id is null";
    }

}
