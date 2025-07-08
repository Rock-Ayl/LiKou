package normal44;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2025-07-08
 * 3607. 电网维护
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 c，表示 c 个电站，每个电站有一个唯一标识符 id，从 1 到 c 编号。
 * <p>
 * 这些电站通过 n 条 双向 电缆互相连接，表示为一个二维数组 connections，其中每个元素 connections[i] = [ui, vi] 表示电站 ui 和电站 vi 之间的连接。直接或间接连接的电站组成了一个 电网 。
 * <p>
 * 最初，所有 电站均处于在线（正常运行）状态。
 * <p>
 * 另给你一个二维数组 queries，其中每个查询属于以下 两种类型之一 ：
 * <p>
 * [1, x]：请求对电站 x 进行维护检查。如果电站 x 在线，则它自行解决检查。如果电站 x 已离线，则检查由与 x 同一 电网 中 编号最小 的在线电站解决。如果该电网中 不存在 任何 在线 电站，则返回 -1。
 * <p>
 * [2, x]：电站 x 离线（即变为非运行状态）。
 * <p>
 * 返回一个整数数组，表示按照查询中出现的顺序，所有类型为 [1, x] 的查询结果。
 * <p>
 * 注意：电网的结构是固定的；离线（非运行）的节点仍然属于其所在的电网，且离线操作不会改变电网的连接性。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： c = 5, connections = [[1,2],[2,3],[3,4],[4,5]], queries = [[1,3],[2,1],[1,1],[2,2],[1,2]]
 * <p>
 * 输出： [3,2,3]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 最初，所有电站 {1, 2, 3, 4, 5} 都在线，并组成一个电网。
 * 查询 [1,3]：电站 3 在线，因此维护检查由电站 3 自行解决。
 * 查询 [2,1]：电站 1 离线。剩余在线电站为 {2, 3, 4, 5}。
 * 查询 [1,1]：电站 1 离线，因此检查由电网中编号最小的在线电站解决，即电站 2。
 * 查询 [2,2]：电站 2 离线。剩余在线电站为 {3, 4, 5}。
 * 查询 [1,2]：电站 2 离线，因此检查由电网中编号最小的在线电站解决，即电站 3。
 * 示例 2：
 * <p>
 * 输入： c = 3, connections = [], queries = [[1,1],[2,1],[1,1]]
 * <p>
 * 输出： [1,-1]
 * <p>
 * 解释：
 * <p>
 * 没有连接，因此每个电站是一个独立的电网。
 * 查询 [1,1]：电站 1 在线，且属于其独立电网，因此维护检查由电站 1 自行解决。
 * 查询 [2,1]：电站 1 离线。
 * 查询 [1,1]：电站 1 离线，且其电网中没有其他电站，因此结果为 -1。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= c <= 105
 * 0 <= n == connections.length <= min(105, c * (c - 1) / 2)
 * connections[i].length == 2
 * 1 <= ui, vi <= c
 * ui != vi
 * 1 <= queries.length <= 2 * 105
 * queries[i].length == 2
 * queries[i][0] 为 1 或 2。
 * 1 <= queries[i][1] <= c
 */
public class Code19 {

    //电站节点
    private static class Node {

        //编号
        private int num;

        //分组,默认是编号
        private int group;

        //是否在线,默认是
        private boolean online = true;

        //初始化
        public Node(int num) {
            this.num = num;
            this.group = num;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("num=%s,group=%s,online=%s", this.num, this.group, this.online);
        }

    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {

        /**
         * 构建节点
         */

        //节点数组
        Node[] nodeArr = new Node[c + 1];
        //循环
        for (int i = 1; i < nodeArr.length; i++) {
            //初始化节点
            nodeArr[i] = new Node(i);
        }

        /**
         * 并查集分组
         */

        //循环
        for (int[] connection : connections) {
            //并查集分组
            findAndSet(nodeArr, connection[0], connection[1]);
        }

        /**
         * 修补剩下的
         */

        //循环
        for (int i = 1; i < nodeArr.length; i++) {
            //当前节点分组
            int group = nodeArr[i].group;
            //如果该分组不是主节点
            if (nodeArr[group].group != group) {
                //修补
                findAndSet(nodeArr, nodeArr[i].group, i);
            }
        }

        /**
         * 按照分组,加入优先队列
         */

        //分组优先队列
        PriorityQueue<Node>[] groupQueueArr = new PriorityQueue[c + 1];
        //循环
        for (int i = 1; i < nodeArr.length; i++) {
            //当前节点
            Node node = nodeArr[i];
            //其分组
            int group = node.group;
            //初始化
            if (groupQueueArr[group] == null) {
                //初始化优先队列
                groupQueueArr[group] = new PriorityQueue<>((a, b) -> a.num - b.num);
            }
            //加入节点
            groupQueueArr[group].add(node);
        }

        /**
         * 计算最终结果
         */

        //初始化结果
        List<Integer> result = new ArrayList<>();
        //循环
        for (int i = 0; i < queries.length; i++) {
            //当前查询
            int[] query = queries[i];
            //获取节点
            Node node = nodeArr[query[1]];
            //根据类型处理
            switch (query[0]) {
                //检查
                case 1:
                    //如果在线
                    if (node.online == true) {
                        //自行解决
                        result.add(node.num);
                    }
                    //如果不是在线
                    else {
                        //获取其分组队列
                        PriorityQueue<Node> queue = groupQueueArr[node.group];
                        //最小的如果下线了
                        while (queue.isEmpty() == false && queue.peek().online == false) {
                            //删除
                            queue.poll();
                        }
                        //记录本次结果
                        result.add(queue.isEmpty() ? -1 : queue.peek().num);
                    }
                    break;
                //关闭
                case 2:
                    //关闭
                    node.online = false;
                    break;
            }
        }

        //返回结果
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    //并查集分组
    private int findAndSet(Node[] nodeArr, int left, int right) {
        //主节点
        int root;
        //如果是主节点
        if (nodeArr[left].group == left) {
            //直接使用
            root = left;
        } else {
            //递归
            root = findAndSet(nodeArr, nodeArr[left].group, left);
        }
        //如果右边有分组了
        if (nodeArr[right].group != right) {
            //递归
            findAndSet(nodeArr, root, nodeArr[right].group);
        }
        //修改本次
        nodeArr[right].group = root;
        //返回
        return root;
    }

    public static void main(String[] args) {
        int[] ints = new Code19().processQueries(
                5,
                new int[][]{
                        new int[]{1, 2},
                        new int[]{2, 3},
                        new int[]{3, 4},
                        new int[]{4, 5}
                }, new int[][]{
                        new int[]{1, 3},
                        new int[]{2, 1},
                        new int[]{1, 1},
                        new int[]{2, 2},
                        new int[]{1, 2}
                });
        System.out.println();
    }

}
