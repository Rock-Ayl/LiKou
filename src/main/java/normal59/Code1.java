package normal59;

import java.util.*;

/**
 * 4112. 将子树置零后的最大得分
 * 同步题目状态
 * <p>
 * 中等
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 parent，表示一棵节点编号从 0 到 n - 1 的有根树，其中 parent[i] 表示节点 i 的父节点。树的根节点为节点 0，因此 parent[0] = -1。
 * <p>
 * 另给你两个长度均为 n 的整数数组 op 和 score，其中 op[i] 决定节点 i 允许执行的操作，score[i] 表示该节点的分数。
 * <p>
 * 你需要按照以下规则处理每个 非叶节点 i：
 * <p>
 * 如果 op[i] = 0，你可以选择节点 i 的 至多 一个子节点，并将以该子节点为根的 子树 中所有节点的分数设为 0。
 * 如果 op[i] = 1，你必须选择节点 i 的 恰好 一个子节点，并将以该子节点为根的子树中所有节点的分数设为 0。
 * 每个非叶节点都必须恰好处理一次。你可以按任意顺序处理这些节点。
 * <p>
 * 返回执行这些操作后，所有节点分数之和的 最大可能值。
 * <p>
 * 叶节点 是没有子节点的节点。
 * <p>
 * 以某个节点为根的 子树 由该节点及其所有后代节点组成。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * ​​​​​​​
 * <p>
 * 输入： parent = [-1,0,0,0,1,2,3,3], op = [1,1,0,0,1,1,0,1], score = [5,6,1,2,3,2,3,-3]
 * <p>
 * 输出： 16
 * <p>
 * 解释：
 * <p>
 * 一种最优方案是按以下顺序处理节点：
 * <p>
 * 节点 4、5、6 和 7：它们都是叶节点，因此不对它们执行任何操作。
 * 节点 1：由于 op[1] = 1，我们必须选择它的一个子节点。选择节点 4，将以它为根的子树中所有节点（节点 4）的分数设为 0。
 * 节点 2：由于 op[2] = 0，我们可以选择一个子节点，也可以不执行任何操作。对于该节点，我们不执行任何操作。
 * 节点 3：由于 op[3] = 0，我们可以选择一个子节点，也可以不执行任何操作。选择节点 7，将以它为根的子树中所有节点（节点 7）的分数设为 0。
 * 节点 0：由于 op[0] = 1，我们必须选择它的一个子节点。选择节点 2，将以它为根的子树中所有节点（节点 2 和 5）的分数设为 0。
 * 执行这些操作后，各节点的分数为 [5, 6, 0, 2, 0, 0, 3, 0]，总和为 16。
 * <p>
 * 不存在能够得到更大分数总和的合法操作序列。因此，答案为 16。
 * <p>
 * 示例 2：
 * <p>
 * ​​​​​​​
 * <p>
 * 输入： parent = [-1,0,0], op = [0,0,0], score = [1,2,3]
 * <p>
 * 输出： 6
 * <p>
 * 解释：
 * <p>
 * 我们只需要处理节点 0，因为节点 1 和节点 2 都是叶节点。
 * 由于 op[0] = 0，我们可以选择不执行任何操作。
 * 因此，所有节点的分数都得以保留，得到的最大分数总和为 6。
 * 示例 3：
 * <p>
 * ​​​​​​​
 * <p>
 * 输入： parent = [-1], op = [1], score = [-10]
 * <p>
 * 输出： -10
 * <p>
 * 解释：
 * <p>
 * 树中唯一的节点是叶节点，因此无法对任何节点执行操作。
 * 因此，最大分数总和为 -10。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * n == parent.length == op.length == score.length
 * parent[0] == -1
 * 对于所有 i 在 [1, n - 1] 范围内，均有 0 <= parent[i] <= n - 1
 * 0 <= op[i] <= 1
 * -104 <= score[i] <= 104
 * 输入保证数组 parent 表示一棵以节点 0 为根的合法树。
 */
public class Code1 {

    //节点
    private static class Node {

        //节点编号
        private int num;

        //节点操作
        private int op;

        //节点分数
        private int score;

        //最大分数和
        private int maxScoreSum = 0;

        //子节点
        private List<Node> children = new ArrayList<>();

        //初始化
        public Node(int num, int op, int score) {
            this.num = num;
            this.op = op;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", op=" + op +
                    ", score=" + score +
                    ", maxScoreSum=" + maxScoreSum +
                    ", children=" + children.size() +
                    '}';
        }

    }

    public int maxScore(int[] parent, int[] op, int[] score) {
        //初始化节点数组
        Node[] nodeArr = new Node[parent.length];
        //循环
        for (int i = 0; i < nodeArr.length; i++) {
            //初始化节点
            nodeArr[i] = new Node(i, op[i], score[i]);
        }
        //循环
        for (int i = 1; i < nodeArr.length; i++) {
            //关联子节点
            nodeArr[parent[i]].children.add(nodeArr[i]);
        }
        //递归调用
        maxScore(nodeArr[0]);
        //返回最大分数
        return nodeArr[0].maxScoreSum;
    }

    //递归
    private void maxScore(Node node) {
        //循环
        for (Node child : node.children) {
            //递归调用
            maxScore(child);
        }
        //如果下面没有子节点
        if (node.children.isEmpty()) {
            //默认是自己
            node.maxScoreSum = node.score;
            //结束
            return;
        }
        //排序
        Collections.sort(node.children, (a, b) -> a.maxScoreSum - b.maxScoreSum);
        //获取节点
        Node minNode = node.children.get(0);
        //根据操作判断最大分数
        switch (node.op) {
            //可以选择一个节点
            case 0:
                //如果是负数
                if (minNode.maxScoreSum < 0) {
                    //重置为0
                    minNode.maxScoreSum = 0;
                }
                break;
            //必须选择一个节点
            case 1:
                //强行重置为0
                minNode.maxScoreSum = 0;
                break;
        }
        //计算最大分数和
        node.maxScoreSum = node.score + node.children.stream().mapToInt(p -> p.maxScoreSum).sum();
    }

    public static void main(String[] args) {
        Code1 code1 = new Code1();
        int[] parent = {-1, 0, 0, 0, 1, 2, 3, 3};
        int[] op = {1, 1, 0, 0, 1, 1, 0, 1};
        int[] score = {5, 6, 1, 2, 3, 2, 3, -3};
        System.out.println(code1.maxScore(parent, op, score));
    }

}
