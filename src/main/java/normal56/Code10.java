package normal56;

import java.util.HashSet;
import java.util.Set;

/**
 * 1615. 最大网络秩
 * 算术评级: 4
 * 第 210 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1522
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * n 座城市和一些连接这些城市的道路 roads 共同组成一个基础设施网络。每个 roads[i] = [ai, bi] 都表示在城市 ai 和 bi 之间有一条双向道路。
 * <p>
 * 两座不同城市构成的 城市对 的 网络秩 定义为：与这两座城市 直接 相连的道路总数。如果存在一条道路直接连接这两座城市，则这条道路只计算 一次 。
 * <p>
 * 整个基础设施网络的 最大网络秩 是所有不同城市对中的 最大网络秩 。
 * <p>
 * 给你整数 n 和数组 roads，返回整个基础设施网络的 最大网络秩 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
 * 输出：4
 * 解释：城市 0 和 1 的网络秩是 4，因为共有 4 条道路与城市 0 或 1 相连。位于 0 和 1 之间的道路只计算一次。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 5, roads = [[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]
 * 输出：5
 * 解释：共有 5 条道路与城市 1 或 2 相连。
 * 示例 3：
 * <p>
 * 输入：n = 8, roads = [[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]
 * 输出：5
 * 解释：2 和 5 的网络秩为 5，注意并非所有的城市都需要连接起来。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 100
 * 0 <= roads.length <= n * (n - 1) / 2
 * roads[i].length == 2
 * 0 <= ai, bi <= n-1
 * ai != bi
 * 每对城市之间 最多只有一条 道路相连
 *
 */
public class Code10 {

    private static class Node {

        //数字
        private int val;

        //关联集合
        private Set<Node> linkSet = new HashSet<>();

        //初始化
        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.format("%s", this.val);
        }

    }

    public int maximalNetworkRank(int n, int[][] roads) {

        /**
         * 初始化节点
         */

        //初始化数组
        Node[] nodeArr = new Node[n];
        //循环
        for (int i = 0; i < n; i++) {
            //初始化节点
            nodeArr[i] = new Node(i);
        }

        /**
         * 构建关联
         */

        //循环
        for (int[] road : roads) {
            //获取节点
            Node node1 = nodeArr[road[0]];
            Node node2 = nodeArr[road[1]];
            //关联
            node1.linkSet.add(node2);
            node2.linkSet.add(node1);
        }

        /**
         * 计算,这里可以优化很多,太懒了
         */

        //最大
        int max = 0;
        //循环1
        for (int i = 0; i < nodeArr.length; i++) {
            //循环2
            for (int j = i + 1; j < nodeArr.length; j++) {
                //本次
                int count = nodeArr[i].linkSet.size()
                        + nodeArr[j].linkSet.size()
                        - (nodeArr[i].linkSet.contains(nodeArr[j]) ? 1 : 0);
                //刷新最大
                max = Math.max(max, count);
            }
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        /*System.out.println(new Code10().maximalNetworkRank(5, new int[][]{
                {0, 1}, {0, 3}, {1, 2}, {1, 3}, {2, 3}, {2, 4}
        }));*/

        //8 [[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]
        /*System.out.println(new Code10().maximalNetworkRank(8, new int[][]{
                {0, 1}, {1, 2}, {2, 3}, {2, 4}, {5, 6}, {5, 7}
        }));*/

        // 5 [[2,3],[0,3],[0,4],[4,1]
        System.out.println(new Code10().maximalNetworkRank(5, new int[][]{
                {2, 3}, {0, 3}, {0, 4}, {4, 1}
        }));

    }

}
