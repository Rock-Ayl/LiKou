package normal49;

import java.util.HashSet;
import java.util.Set;

/**
 * 1466. 重新规划路线
 * 算术评级: 6
 * 第 191 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1634
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
 * <p>
 * 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
 * <p>
 * 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
 * <p>
 * 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
 * <p>
 * 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * 输出：3
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * 输出：2
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 * 示例 3：
 * <p>
 * 输入：n = 3, connections = [[1,0],[2,0]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 5 * 10^4
 * connections.length == n-1
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] <= n-1
 * connections[i][0] != connections[i][1]
 */
public class Code19 {

    //节点
    private static class Node {

        //编号
        private int number;

        //是否走过,默认没有
        private boolean walked = false;

        //下一个节点
        private Set<Node> nextSet = new HashSet<>();

        //上一个节点
        private Set<Node> lastSet = new HashSet<>();

        //初始化节点
        public Node(int value) {
            this.number = value;
        }

        @Override
        public String toString() {
            return String.format("number=%s,walked=%s,next=%s,last=%s", this.number, this.walked, nextSet.size(), lastSet.size());
        }

    }

    public int minReorder(int n, int[][] connections) {
        //初始化节点数组
        Node[] arr = new Node[n];
        //循环
        for (int i = 0; i < arr.length; i++) {
            //初始化
            arr[i] = new Node(i);
        }
        for (int[] connection : connections) {
            //获取开始结束节点
            Node start = arr[connection[0]];
            Node end = arr[connection[1]];
            //关联
            start.nextSet.add(end);
            end.lastSet.add(start);
        }
        //递归并返回
        return count(arr[0]);
    }

    //递归路径
    private int count(Node node) {
        //如果走过了
        if (node.walked == true) {
            //过
            return 0;
        }
        //标记走过
        node.walked = true;
        //当前结果
        int count = 0;
        //循环方向不对的
        for (Node lastNode : node.nextSet) {
            //如果走过了
            if (lastNode.walked == true) {
                //本轮过
                continue;
            }
            //叠加
            count += count(lastNode);
            //+1
            count++;
        }
        //循环
        for (Node child : node.lastSet) {
            //如果走过了
            if (child.walked == true) {
                //本轮过
                continue;
            }
            //叠加
            count += count(child);
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code19().minReorder(6, new int[][]{
                new int[]{0, 1},
                new int[]{1, 3},
                new int[]{2, 3},
                new int[]{4, 0},
                new int[]{4, 5}
        }));
    }

}
