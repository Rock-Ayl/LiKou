package normal47;

/**
 * @Author ayl
 * @Date 2025-11-06
 * 687. 最长同值路径
 * 尝试过
 * 算术评级: 4
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
 * <p>
 * 两个节点之间的路径长度 由它们之间的边数表示。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,4,5,1,1,5]
 * 输出：2
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,4,5,4,4,5]
 * 输出：2
 * <p>
 * <p>
 * 提示:
 * <p>
 * 树的节点数的范围是 [0, 104]
 * -1000 <= Node.val <= 1000
 * 树的深度将不超过 1000
 */
public class Code20 {

    private static class TreeNode {
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

    public int longestUnivaluePath(TreeNode root) {
        //递归实现
        find(root);
        //返回
        return this.max > 0 ? this.max - 1 : 0;
    }

    //最大结果
    private int max = 0;

    //递归
    private int find(TreeNode node) {
        //判空
        if (node == null) {
            //过
            return 0;
        }
        //递归子级
        int leftCount = find(node.left);
        int rightCount = find(node.right);
        //当前节点数量
        int nodeCount = 1;
        //左右是否关联
        boolean linkLeft = node.left != null && node.left.val == node.val;
        boolean linkRight = node.right != null && node.right.val == node.val;
        //如果左边和节点相同
        if (linkLeft) {
            //计算当前最大路径
            nodeCount = Math.max(nodeCount, 1 + leftCount);
        }
        //如果右边和节点相同
        if (linkRight) {
            //计算当前最大路径
            nodeCount = Math.max(nodeCount, 1 + rightCount);
        }
        //刷新本次最大
        this.max = Math.max(this.max, nodeCount);
        //如果左右都相同
        if (linkLeft && linkRight) {
            //额外刷新最大
            this.max = Math.max(this.max, leftCount + rightCount + 1);
        }
        //返回
        return nodeCount;
    }

}
