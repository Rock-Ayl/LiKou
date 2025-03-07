package easy13;

/**
 * @Author ayl
 * @Date 2021-10-30
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 */
public class Code17 {

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

    public int next(TreeNode root, int deep) {
        //如果是空
        if (root == null) {
            //返回
            return deep;
        }
        //左深度
        int left = next(root.left, deep + 1);
        //右深度
        int right = next(root.right, deep + 1);
        //最大
        return Math.max(left, right);
    }

    public int maxDepth(TreeNode root) {
        return next(root, 0);
    }

}
