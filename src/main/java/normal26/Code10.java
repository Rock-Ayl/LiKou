package normal26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-11-27
 * 133. 克隆图
 * 中等
 * 663
 * 相关企业
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * <p>
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * <p>
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * }
 * <p>
 * <p>
 * 测试用例格式：
 * <p>
 * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
 * <p>
 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 * <p>
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
 * 输出：[[2,4],[1,3],[2,4],[1,3]]
 * 解释：
 * 图中有 4 个节点。
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：adjList = [[]]
 * 输出：[[]]
 * 解释：输入包含一个空列表。该图仅仅只有一个值为 1 的节点，它没有任何邻居。
 * 示例 3：
 * <p>
 * 输入：adjList = []
 * 输出：[]
 * 解释：这个图是空的，它不含任何节点。
 * 示例 4：
 * <p>
 * <p>
 * <p>
 * 输入：adjList = [[2],[1]]
 * 输出：[[2],[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点数不超过 100 。
 * 每个节点值 Node.val 都是唯一的，1 <= Node.val <= 100。
 * 无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
 * 由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
 * 图是连通图，你可以从给定节点访问到所有节点。
 */
public class Code10 {

    public static class Node {

        //值
        public int val;
        //列表
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

    }

    //缓存,复制前、复制后的节点关系
    private Map<Node, Node> nodeMap;

    //收集所有节点,并复制关系
    private Node collectNodeAndClone(Node node) {
        //如果存在了
        if (this.nodeMap.containsKey(node)) {
            //获取复制后的节点并返回
            return this.nodeMap.get(node);
        }
        //复制节点
        Node cloneNode = new Node(node.val);
        //先记录二者关系
        this.nodeMap.put(node, cloneNode);
        //如果没有关系节点
        if (node.neighbors.isEmpty()) {
            //返回复制后的节点
            return cloneNode;
        }
        //循环
        for (Node neighbor : node.neighbors) {
            //先复制起本身,并记录克隆的关系
            cloneNode.neighbors.add(collectNodeAndClone(neighbor));
        }
        //返回复制后的节点
        return cloneNode;
    }

    public Node cloneGraph(Node node) {
        //初始化缓存
        this.nodeMap = new HashMap<>();
        //判空
        if (node == null) {
            //过
            return null;
        }
        //递归收集所有节点,并复制节点本身,返回
        return collectNodeAndClone(node);
    }

}
