package normal13;

/**
 * @Author ayl
 * @Date 2022-03-18
 * 814. 二叉树剪枝
 * 给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。
 * <p>
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * <p>
 * 节点 node 的子树为 node 本身加上所有 node 的后代。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,0,0,1]
 * 输出：[1,null,0,null,1]
 * 解释：
 * 只有红色节点满足条件“所有不包含 1 的子树”。 右图为返回的答案。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,0,1,0,0,0,1]
 * 输出：[1,null,1,null,1]
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [1,1,0,1,1,0,1,0]
 * 输出：[1,1,0,1,1,null,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [1, 200] 内
 * Node.val 为 0 或 1
 */
public class Code8 {

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

    public TreeNode pruneTree(TreeNode root) {
        //判空
        if (root == null) {
            //返回
            return null;
        }
        //修剪左右
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        //如果左右都没有,并且当前为0
        if (root.left == null && root.right == null && root.val == 0) {
            //空
            return null;
        }
        //默认
        return root;
    }

}
