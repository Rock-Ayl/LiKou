package normal47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-11-07
 * 1443. 收集树上所有苹果的最少时间
 * 尝试过
 * 算术评级: 6
 * 第 188 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1683
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一棵有 n 个节点的无向树，节点编号为 0 到 n-1 ，它们中有一些节点有苹果。通过树上的一条边，需要花费 1 秒钟。你从 节点 0 出发，请你返回最少需要多少秒，可以收集到所有苹果，并回到节点 0 。
 * <p>
 * 无向树的边由 edges 给出，其中 edges[i] = [fromi, toi] ，表示有一条边连接 from 和 toi 。除此以外，还有一个布尔数组 hasApple ，其中 hasApple[i] = true 代表节点 i 有一个苹果，否则，节点 i 没有苹果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
 * 输出：8
 * 解释：上图展示了给定的树，其中红色节点表示有苹果。一个能收集到所有苹果的最优方案由绿色箭头表示。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,false,true,false]
 * 输出：6
 * 解释：上图展示了给定的树，其中红色节点表示有苹果。一个能收集到所有苹果的最优方案由绿色箭头表示。
 * 示例 3：
 * <p>
 * 输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,false,false,false,false,false]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^5
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai < bi <= n - 1
 * hasApple.length == n
 */
public class Code21 {

    private static class Node {

        //编号
        private Integer number;

        //是否有苹果
        private Boolean apple;

        //是否走过
        private Boolean walked;

        //关联节点
        private List<Node> nextNodeSet;

        //初始化
        public Node(Integer number, Boolean apple) {
            this.number = number;
            this.apple = apple;
            this.walked = false;
            this.nextNodeSet = new ArrayList<>();
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("number=%s,apple=%s,walked=%s,nextNodeSet=%s", this.number, this.apple, this.walked, this.nextNodeSet.size());
        }

    }

    //统计苹果
    private int result = 0;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        //初始化节点
        Node[] nodeArr = new Node[n];
        //循环
        for (int i = 0; i < n; i++) {
            //初始化节点
            Node node = new Node(i, hasApple.get(i));
            //记录
            nodeArr[i] = node;
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
        //开始节点
        Node root = nodeArr[0];
        //开始收集并返回
        next(root);
        //返回结果
        return this.result > 0 ? this.result - 2 : 0;
    }

    //递归
    private boolean next(Node node) {
        //判空
        if (node == null) {
            //没有
            return false;
        }
        //如果走过了
        if (node.walked == true) {
            //没有
            return false;
        }
        //记录其走过了
        node.walked = true;
        //子级是否有,默认没有
        boolean nextHad = false;
        //递归子级
        for (Node child : node.nextNodeSet) {
            //递归子级
            boolean next = next(child);
            //如果是
            if (next == true) {
                //覆盖
                nextHad = true;
            }
        }
        //如果子级有 or 子级有
        if (nextHad == true || node.apple == true) {
            //叠加
            this.result += 2;
            //有
            return true;
        } else {
            //默认没有
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code21().minTime(
                7,
                new int[][]{
                        new int[]{0, 1},
                        new int[]{0, 2},
                        new int[]{1, 4},
                        new int[]{1, 5},
                        new int[]{2, 3},
                        new int[]{2, 6}
                },
                Arrays.asList(false, false, true, false, true, true, false)
        ));
    }

}
