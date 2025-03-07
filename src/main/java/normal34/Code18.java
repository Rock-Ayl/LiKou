package normal34;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-08-28
 * 2673. 使二叉树所有路径值相等的最小代价
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数 n 表示一棵 满二叉树 里面节点的数目，节点编号从 1 到 n 。根节点编号为 1 ，树中每个非叶子节点 i 都有两个孩子，分别是左孩子 2 * i 和右孩子 2 * i + 1 。
 * <p>
 * 树中每个节点都有一个值，用下标从 0 开始、长度为 n 的整数数组 cost 表示，其中 cost[i] 是第 i + 1 个节点的值。每次操作，你可以将树中 任意 节点的值 增加 1 。你可以执行操作 任意 次。
 * <p>
 * 你的目标是让根到每一个 叶子结点 的路径值相等。请你返回 最少 需要执行增加操作多少次。
 * <p>
 * 注意：
 * <p>
 * 满二叉树 指的是一棵树，它满足树中除了叶子节点外每个节点都恰好有 2 个子节点，且所有叶子节点距离根节点距离相同。
 * 路径值 指的是路径上所有节点的值之和。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 7, cost = [1,5,2,2,3,3,1]
 * 输出：6
 * 解释：我们执行以下的增加操作：
 * - 将节点 4 的值增加一次。
 * - 将节点 3 的值增加三次。
 * - 将节点 7 的值增加两次。
 * 从根到叶子的每一条路径值都为 9 。
 * 总共增加次数为 1 + 3 + 2 = 6 。
 * 这是最小的答案。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 3, cost = [5,3,3]
 * 输出：0
 * 解释：两条路径已经有相等的路径值，所以不需要执行任何增加操作。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= n <= 105
 * n + 1 是 2 的幂
 * cost.length == n
 * 1 <= cost[i] <= 104
 */
public class Code18 {

    //节点对象
    public static class Node {

        //值
        private Integer value;

        //左子节点
        private Node left;

        //右子节点
        private Node right;

        //初始化
        public Node(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value.toString();
        }
    }

    public int minIncrements(int n, int[] cost) {
        //转化为节点列表
        List<Node> nodeList = Arrays.stream(cost).boxed().map(Node::new).collect(Collectors.toList());
        //每行节点数量
        int nodeCount = 1;
        //节点指针
        int nodeIndex = 0;
        //初始化节点树
        List<List<Node>> nodeTreeList = new ArrayList<>();
        //如果还有
        while (nodeIndex < nodeList.size()) {
            //初始化本行
            List<Node> thisNodeList = new ArrayList<>();
            //组装本次
            thisNodeList.addAll(nodeList.stream().skip(nodeIndex).limit(nodeCount).collect(Collectors.toList()));
            //组装到树
            nodeTreeList.add(thisNodeList);
            //计算下一行
            nodeIndex += nodeCount;
            nodeCount = nodeCount * 2;
        }
        //循环
        for (int i = 1; i < nodeTreeList.size(); i++) {
            //获取父子节点列表
            List<Node> fatherList = nodeTreeList.get(i - 1);
            List<Node> childList = nodeTreeList.get(i);
            //循环
            for (int j = 0; j < childList.size(); j++) {
                //当前子节点
                Node child = childList.get(j);
                //对应父节点
                Node father = fatherList.get(j / 2);
                //判断左右
                if (j % 2 == 0) {
                    //左边
                    father.left = child;
                } else {
                    //右边
                    father.right = child;
                }
            }
        }
        //主节点
        Node root = nodeTreeList.get(0).get(0);
        //递归并返回
        return next(root);
    }

    //递归并计算修补
    private int next(Node node) {
        //判空
        if (node == null) {
            //过
            return 0;
        }
        //如果没有子级
        if (node.left == null) {
            //过
            return 0;
        }
        //先递归子级
        int leftResult = next(node.left);
        int rightResult = next(node.right);
        //取子级最大数字
        int max = Math.max(node.left.value, node.right.value);
        //需要补充的
        int other = max * 2 - node.left.value - node.right.value;
        //修改对应
        node.left.value = max;
        node.right.value = max;
        //修改本节点
        node.value += max;
        //返回
        return leftResult + rightResult + other;
    }

    public static void main(String[] args) {
        System.out.println(new Code18().minIncrements(7, new int[]{1, 5, 2, 2, 3, 3, 1}));
    }

}
