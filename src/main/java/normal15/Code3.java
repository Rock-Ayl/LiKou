package normal15;

/**
 * @Author ayl
 * @Date 2022-07-05
 * 剑指 Offer II 047. 二叉树剪枝
 * 给定一个二叉树 根节点 root ，树的每个节点的值要么是 0，要么是 1。请剪除该二叉树中所有节点的值为 0 的子树。
 * <p>
 * 节点 node 的子树为 node 本身，以及所有 node 的后代。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,null,0,0,1]
 * 输出: [1,null,0,null,1]
 * 解释:
 * 只有红色节点满足条件“所有不包含 1 的子树”。
 * 右图为返回的答案。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1,0,1,0,0,0,1]
 * 输出: [1,null,1,null,1]
 * 解释:
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * 输入: [1,1,0,1,1,0,1,0]
 * 输出: [1,1,0,1,1,null,1]
 * 解释:
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [1,200]
 * 二叉树节点的值只会是 0 或 1
 * <p>
 * <p>
 * 注意：本题与主站 814 题相同：https://leetcode-cn.com/problems/binary-tree-pruning/
 */
public class Code3 {

    public class TreeNode {
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

    public int prune(TreeNode root) {
        //判空
        if (root == null) {
            //返回
            return 0;
        }
        //先修剪子树
        int left = prune(root.left);
        int right = prune(root.right);
        //如果左边是0
        if (left == 0) {
            //断开连接
            root.left = null;
        }
        //如果右边是0
        if (right == 0) {
            //断开连接
            root.right = null;
        }
        //返回
        return root.val + left + right;
    }

    public TreeNode pruneTree(TreeNode root) {
        //修剪
        int count = prune(root);
        //如果全是0
        if (count == 0) {
            //返回空
            return null;
        }
        //返回结果
        return root;
    }

}
