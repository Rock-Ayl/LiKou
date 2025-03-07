package normal34;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2024-09-03
 * 2477. 到达首都的最少油耗
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一棵 n 个节点的树（一个无向、连通、无环图），每个节点表示一个城市，编号从 0 到 n - 1 ，且恰好有 n - 1 条路。0 是首都。给你一个二维整数数组 roads ，其中 roads[i] = [ai, bi] ，表示城市 ai 和 bi 之间有一条 双向路 。
 * <p>
 * 每个城市里有一个代表，他们都要去首都参加一个会议。
 * <p>
 * 每座城市里有一辆车。给你一个整数 seats 表示每辆车里面座位的数目。
 * <p>
 * 城市里的代表可以选择乘坐所在城市的车，或者乘坐其他城市的车。相邻城市之间一辆车的油耗是一升汽油。
 * <p>
 * 请你返回到达首都最少需要多少升汽油。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：roads = [[0,1],[0,2],[0,3]], seats = 5
 * 输出：3
 * 解释：
 * - 代表 1 直接到达首都，消耗 1 升汽油。
 * - 代表 2 直接到达首都，消耗 1 升汽油。
 * - 代表 3 直接到达首都，消耗 1 升汽油。
 * 最少消耗 3 升汽油。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：roads = [[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]], seats = 2
 * 输出：7
 * 解释：
 * - 代表 2 到达城市 3 ，消耗 1 升汽油。
 * - 代表 2 和代表 3 一起到达城市 1 ，消耗 1 升汽油。
 * - 代表 2 和代表 3 一起到达首都，消耗 1 升汽油。
 * - 代表 1 直接到达首都，消耗 1 升汽油。
 * - 代表 5 直接到达首都，消耗 1 升汽油。
 * - 代表 6 到达城市 4 ，消耗 1 升汽油。
 * - 代表 4 和代表 6 一起到达首都，消耗 1 升汽油。
 * 最少消耗 7 升汽油。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：roads = [], seats = 1
 * 输出：0
 * 解释：没有代表需要从别的城市到达首都。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * roads.length == n - 1
 * roads[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * roads 表示一棵合法的树。
 * 1 <= seats <= 105
 */
public class Code22 {

    //节点
    private static class Node {

        //每个节点人数,默认1
        private int userCount = 1;

        //该节点可以走的节点集合
        private Set<Node> nextNodeSet = new HashSet<>();

    }

    //消耗的总油量
    private long resultCount = 0L;

    public long minimumFuelCost(int[][] roads, int seats) {
        //节点数量
        int n = roads.length + 1;
        //节点缓存
        Map<Integer, Node> nodeMap = new HashMap<>();
        //父节点集合
        Set<Node> fatherNodeSet = new HashSet<>();
        //循环
        for (int i = 0; i < n; i++) {
            //初始化节点
            Node node = new Node();
            //记录缓存
            nodeMap.put(i, node);
            //暂定为父节点
            fatherNodeSet.add(node);
        }
        //循环
        for (int[] road : roads) {
            //获取两个节点
            Node node1 = nodeMap.get(road[0]);
            Node node2 = nodeMap.get(road[1]);
            //互相关联
            node1.nextNodeSet.add(node2);
            node2.nextNodeSet.add(node1);
            //如果路径超过1条
            if (node1.nextNodeSet.size() > 1) {
                //不是父节点了
                fatherNodeSet.remove(node1);
            }
            //如果路径超过1条
            if (node2.nextNodeSet.size() > 1) {
                //不是父节点了
                fatherNodeSet.remove(node2);
            }
        }
        //获取首都节点
        Node zeroNode = nodeMap.get(0);
        //首都不作为父节点
        fatherNodeSet.remove(zeroNode);
        //循环
        for (Node firstNode : fatherNodeSet) {
            //递归到首都
            next(zeroNode, new Node(), firstNode, 0, seats);
        }
        //返回
        return this.resultCount;
    }

    //递归到首都
    private void next(Node zeroNode, Node fatherNode, Node node, int otherCount, int seats) {
        //判空 or 是首都
        if (node == null || node == zeroNode) {
            //过
            return;
        }
        //尝试删除父节点的路径
        node.nextNodeSet.remove(fatherNode);
        //叠加人数
        node.userCount += otherCount;
        //如果还有其他未到的节点
        if (node.nextNodeSet.size() > 1) {
            //暂时不递归下一步
            return;
        }
        //计算本次消耗的油,并叠加到结果
        this.resultCount += (node.userCount / seats) + (node.userCount % seats == 0 ? 0 : 1);
        //循环(虽然只有一个)
        for (Node nextNode : node.nextNodeSet) {
            //如果是首都
            if (nextNode == zeroNode) {
                //本轮过
                continue;
            }
            //递归
            next(zeroNode, node, nextNode, node.userCount, seats);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code22().minimumFuelCost(new int[][]{
                new int[]{1, 0},
                new int[]{0, 2},
                new int[]{3, 1},
                new int[]{1, 4},
                new int[]{5, 0}
        }, 1));
    }

}
