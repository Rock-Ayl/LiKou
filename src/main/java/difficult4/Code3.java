package difficult4;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2025-08-25
 * 2872. 可以被 K 整除连通块的最大数目
 * 算术评级: 6
 * 第 114 场双周赛
 * Q4
 * 同步题目状态
 * <p>
 * 1968
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一棵 n 个节点的无向树，节点编号为 0 到 n - 1 。给你整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 有一条边。
 * <p>
 * 同时给你一个下标从 0 开始长度为 n 的整数数组 values ，其中 values[i] 是第 i 个节点的 值 。再给你一个整数 k 。
 * <p>
 * 你可以从树中删除一些边，也可以一条边也不删，得到若干连通块。一个 连通块的值 定义为连通块中所有节点值之和。如果所有连通块的值都可以被 k 整除，那么我们说这是一个 合法分割 。
 * <p>
 * 请你返回所有合法分割中，连通块数目的最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 5, edges = [[0,2],[1,2],[1,3],[2,4]], values = [1,8,1,4,4], k = 6
 * 输出：2
 * 解释：我们删除节点 1 和 2 之间的边。这是一个合法分割，因为：
 * - 节点 1 和 3 所在连通块的值为 values[1] + values[3] = 12 。
 * - 节点 0 ，2 和 4 所在连通块的值为 values[0] + values[2] + values[4] = 6 。
 * 最多可以得到 2 个连通块的合法分割。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 7, edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]], values = [3,0,6,1,5,2,1], k = 3
 * 输出：3
 * 解释：我们删除节点 0 和 2 ，以及节点 0 和 1 之间的边。这是一个合法分割，因为：
 * - 节点 0 的连通块的值为 values[0] = 3 。
 * - 节点 2 ，5 和 6 所在连通块的值为 values[2] + values[5] + values[6] = 9 。
 * - 节点 1 ，3 和 4 的连通块的值为 values[1] + values[3] + values[4] = 6 。
 * 最多可以得到 3 个连通块的合法分割。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 3 * 104
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * values.length == n
 * 0 <= values[i] <= 109
 * 1 <= k <= 109
 * values 之和可以被 k 整除。
 * 输入保证 edges 是一棵无向树。
 */
public class Code3 {

    private static class Node {

        //索引
        private int index;

        //值
        private long value;

        //下一级节点集合
        private Set<Node> nextNodeSet = new HashSet<>();

        //初始化
        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("index=%s,value=%s,nextSize=%s", this.index, this.value, this.nextNodeSet.size());
        }

    }

    //本次结果
    private int result = 0;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {

        /**
         * 构造节点
         */

        //节点缓存
        Node[] nodeArr = new Node[n];
        //循环
        for (int i = 0; i < nodeArr.length; i++) {
            //初始化
            nodeArr[i] = new Node(i, values[i]);
        }

        /**
         * 构造节点关系
         */

        //循环
        for (int[] edge : edges) {
            //获取节点
            Node node1 = nodeArr[edge[0]];
            Node node2 = nodeArr[edge[1]];
            //关联
            node1.nextNodeSet.add(node2);
            node2.nextNodeSet.add(node1);
        }

        /**
         * 递归统计结果
         */

        //把0当为主节点吧
        Node root = nodeArr[0];
        //走过的节点
        Set<Node> walkedSet = new HashSet<>();
        //递归实现
        next(root, walkedSet, k);

        /**
         * 返回结果
         */

        //返回本次结果
        return this.result;
    }

    //递归
    private long next(Node node, Set<Node> walkedSet, int target) {

        /**
         * 校验该节点是否允许执行
         */

        //判空
        if (node == null) {
            //过
            return 0L;
        }
        //如果走过了
        if (walkedSet.contains(node) == true) {
            //过
            return 0L;
        }
        //记录已经走过了
        walkedSet.add(node);

        /**
         * 递归子节点
         */

        //结果求和
        long sum = node.value;
        //循环子节点
        for (Node child : node.nextNodeSet) {
            //递归子节点,返回数量
            long count = next(child, walkedSet, target);
            //叠加
            sum += count;
        }
        //如果是目标结果
        if (sum % target == 0) {
            //+1
            this.result++;
            //使用掉了
            sum = 0;
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().maxKDivisibleComponents(
                7,
                new int[][]{
                        new int[]{0, 1},
                        new int[]{0, 2},
                        new int[]{1, 3},
                        new int[]{1, 4},
                        new int[]{2, 5},
                        new int[]{2, 6}
                },
                new int[]{3, 0, 6, 1, 5, 2, 1},
                3)
        );
    }

}
