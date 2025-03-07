package normal13;

/**
 * @Author ayl
 * @Date 2022-04-20
 * 608. 树节点
 * SQL架构
 * 给定一个表 tree，id 是树节点的编号， p_id 是它父节点的 id 。
 * <p>
 * +----+------+
 * | id | p_id |
 * +----+------+
 * | 1  | null |
 * | 2  | 1    |
 * | 3  | 1    |
 * | 4  | 2    |
 * | 5  | 2    |
 * +----+------+
 * 树中每个节点属于以下三种类型之一：
 * <p>
 * 叶子：如果这个节点没有任何孩子节点。
 * 根：如果这个节点是整棵树的根，即没有父节点。
 * 内部节点：如果这个节点既不是叶子节点也不是根节点。
 * <p>
 * <p>
 * 写一个查询语句，输出所有节点的编号和节点的类型，并将结果按照节点编号排序。上面样例的结果为：
 * <p>
 * <p>
 * <p>
 * +----+------+
 * | id | Type |
 * +----+------+
 * | 1  | Root |
 * | 2  | Inner|
 * | 3  | Leaf |
 * | 4  | Leaf |
 * | 5  | Leaf |
 * +----+------+
 * <p>
 * <p>
 * 解释
 * <p>
 * 节点 '1' 是根节点，因为它的父节点是 NULL ，同时它有孩子节点 '2' 和 '3' 。
 * 节点 '2' 是内部节点，因为它有父节点 '1' ，也有孩子节点 '4' 和 '5' 。
 * 节点 '3', '4' 和 '5' 都是叶子节点，因为它们都有父节点同时没有孩子节点。
 * 样例中树的形态如下：
 * <p>
 * <p>
 * 1
 * /   \
 * 2       3
 * /   \
 * 4       5
 * <p>
 * <p>
 * 注意
 * <p>
 * 如果树中只有一个节点，你只需要输出它的根属性。
 */
public class Code17 {

    public static void main(String[] args) {
        String sql = "select a.id,IFNULL(b.type,'Inner') as type from (select id from tree group by id) a left join (select id,'Root' as type from tree where p_id is null union select id,'Leaf' as type from tree where id not in (select p_id from tree where p_id is not null group by p_id) and p_id is not null) b on a.id = b.id ";
    }

}
