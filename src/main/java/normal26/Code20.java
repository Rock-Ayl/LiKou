package normal26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-12-08
 * 2583. 二叉树中的第 K 大层和
 * 提示
 * 中等
 * 13
 * 相关企业
 * 给你一棵二叉树的根节点 root 和一个正整数 k 。
 * <p>
 * 树中的 层和 是指 同一层 上节点值的总和。
 * <p>
 * 返回树中第 k 大的层和（不一定不同）。如果树少于 k 层，则返回 -1 。
 * <p>
 * 注意，如果两个节点与根节点的距离相同，则认为它们在同一层。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,8,9,2,1,3,7,4,6], k = 2
 * 输出：13
 * 解释：树中每一层的层和分别是：
 * - Level 1: 5
 * - Level 2: 8 + 9 = 17
 * - Level 3: 2 + 1 + 3 + 7 = 13
 * - Level 4: 4 + 6 = 10
 * 第 2 大的层和等于 13 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,null,3], k = 1
 * 输出：3
 * 解释：最大的层和是 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数为 n
 * 2 <= n <= 105
 * 1 <= Node.val <= 106
 * 1 <= k <= n
 */
public class Code20 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //缓存
    private List<Long> list;

    //递归
    private void next(TreeNode node, int deep) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //判断有没有该深度
        if (this.list.size() == deep) {
            //直接加入
            this.list.add((long) node.val);
        } else {
            //累加
            this.list.set(deep, this.list.get(deep) + node.val);
        }
        //下一级索引
        int nextDeep = deep + 1;
        //下一级
        next(node.left, nextDeep);
        next(node.right, nextDeep);
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        //初始化
        this.list = new ArrayList<>();
        //递归
        next(root, 0);
        //索引
        int index = this.list.size() - k;
        //如果越界了
        if (index < 0) {
            //过
            return -1;
        }
        //排序
        Collections.sort(this.list);
        //返回
        return this.list.get(index);
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        System.out.println(new Code20().kthLargestLevelSum(node1, 4));

    }

}
