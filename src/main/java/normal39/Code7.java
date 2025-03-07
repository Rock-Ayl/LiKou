package normal39;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-01-14
 * 1382. 将二叉搜索树变平衡
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。如果有多种构造方法，请你返回任意一种。
 * <p>
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,2,null,3,null,4,null,null]
 * 输出：[2,1,3,null,null,null,4]
 * 解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入: root = [2,1,3]
 * 输出: [2,1,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树节点的数目在 [1, 104] 范围内。
 * 1 <= Node.val <= 105
 */
public class Code7 {

    public static class TreeNode {

        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    //节点列表
    private List<TreeNode> nodeList = new ArrayList<>();

    //递归收集、并解除节点关系
    private void collect(TreeNode node) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //先左
        collect(node.left);
        //当前
        this.nodeList.add(node);
        //再右
        collect(node.right);
        //取消关系
        node.left = null;
        node.right = null;
    }

    //递归构建
    private TreeNode build(int left, int right) {
        //如果越界
        if (left > right) {
            //过
            return null;
        }
        //计算中间节点
        int mid = ((right - left) / 2) + left;
        //获取当前节点
        TreeNode treeNode = this.nodeList.get(mid);
        //递归左右
        treeNode.left = build(left, mid - 1);
        treeNode.right = build(mid + 1, right);
        //返回
        return treeNode;
    }

    public TreeNode balanceBST(TreeNode root) {
        //step 1. 收集所有节点
        collect(root);
        //step 2. 构建节点
        return build(0, this.nodeList.size() - 1);
    }

    public static void main(String[] args) {
        Code7 code7 = new Code7();


        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node1.right = node2;
        node2.right = node3;
        node3.right = node4;

        TreeNode node = code7.balanceBST(node1);
        System.out.println();

    }

}
