package normal45;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2025-07-25
 * 3249. 统计好节点的数目
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 现有一棵 无向 树，树中包含 n 个节点，按从 0 到 n - 1 标记。树的根节点是节点 0 。给你一个长度为 n - 1 的二维整数数组 edges，其中 edges[i] = [ai, bi] 表示树中节点 ai 与节点 bi 之间存在一条边。
 * <p>
 * 如果一个节点的所有子节点为根的 子树 包含的节点数相同，则认为该节点是一个 好节点。
 * <p>
 * 返回给定树中 好节点 的数量。
 * <p>
 * 子树 指的是一个节点以及它所有后代节点构成的一棵树。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]
 * <p>
 * 输出：7
 * <p>
 * 说明：
 * <p>
 * <p>
 * 树的所有节点都是好节点。
 * <p>
 * 示例 2：
 * <p>
 * 输入：edges = [[0,1],[1,2],[2,3],[3,4],[0,5],[1,6],[2,7],[3,8]]
 * <p>
 * 输出：6
 * <p>
 * 说明：
 * <p>
 * <p>
 * 树中有 6 个好节点。上图中已将这些节点着色。
 * <p>
 * 示例 3：
 * <p>
 * 输入：edges = [[0,1],[1,2],[1,3],[1,4],[0,5],[5,6],[6,7],[7,8],[0,9],[9,10],[9,12],[10,11]]
 * <p>
 * 输出：12
 * <p>
 * 解释：
 * <p>
 * <p>
 * 除了节点 9 以外其他所有节点都是好节点。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * 输入确保 edges 总表示一棵有效的树。
 */
public class Code8 {

    private static class Node {

        //可以去的节点
        private Set<Node> nextNodeSet = new HashSet<>();

    }

    //总消费
    private int costSum = 0;
    //走过的节点
    private Set<Node> walkedSet = new HashSet<>();

    public int countGoodNodes(int[][] edges) {
        //节点数组
        Node[] nodeArr = new Node[edges.length + 1];
        //循环
        for (int i = 0; i < nodeArr.length; i++) {
            //初始化
            nodeArr[i] = new Node();
        }
        //循环
        for (int[] edge : edges) {
            //获取两个节点
            Node node1 = nodeArr[edge[0]];
            Node node2 = nodeArr[edge[1]];
            //关联
            node1.nextNodeSet.add(node2);
            node2.nextNodeSet.add(node1);
        }
        //从节点0开始
        next(nodeArr[0]);
        //返回总消费
        return this.costSum;
    }

    //递归
    private int next(Node node) {

        /**
         * 判断节点是否合法
         */

        //判空
        if (node == null) {
            //过
            return 0;
        }
        //如果走过了
        if (this.walkedSet.contains(node)) {
            //过
            return 0;
        }
        //记录其已经走过了
        this.walkedSet.add(node);

        /**
         * 递归子节点
         */

        //节点和,默认它自己
        int sum = 1;
        //子节点的花费
        Set<Integer> resultSet = new HashSet<>();
        //循环子节点
        for (Node child : node.nextNodeSet) {
            //先递归子节点
            int result = next(child);
            //如果不是
            if (result == 0) {
                //本轮过
                continue;
            }
            //记录
            resultSet.add(result);
            //叠加节点和
            sum += result;
        }

        /**
         * 当前是否为好节点
         */

        //如果没有子节点
        if (resultSet.isEmpty()) {
            //是
            this.costSum++;
        }
        //如果只有一种结果
        else if (resultSet.size() == 1) {
            //是
            this.costSum++;
        }

        /**
         * 结束
         */

        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().countGoodNodes(new int[][]{new int[]{0, 1},
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{1, 4},
                new int[]{0, 5},
                new int[]{5, 6},
                new int[]{6, 7},
                new int[]{7, 8},
                new int[]{0, 9},
                new int[]{9, 10},
                new int[]{9, 12},
                new int[]{10, 11}}));
    }

}
