package easy29;

/**
 * @Author ayl
 * @Date 2023-04-12
 * 剑指 Offer 55 - II. 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 树的结点个数 <= 10000
 */
public class Code19 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        //判空
        if (root == null) {
            //是
            return true;
        }
        //如果左边不是
        if (isBalanced(root.left) == false) {
            //不是
            return false;
        }
        //如果右边不是
        if (isBalanced(root.right) == false) {
            //不是
            return false;
        }
        //左右深度
        int left = next(root.left);
        int right = next(root.right);
        //如果当前深度超了
        if (Math.abs(left - right) > 1) {
            //过
            return false;
        }
        //默认
        return true;
    }

    public int next(TreeNode root) {
        //如果没有
        if (root == null) {
            //0
            return 0;
        }
        //如果左右都空
        if (root.left == null && root.right == null) {
            //1
            return 1;
        }
        //计算深度
        return Math.max(next(root.left), next(root.right)) + 1;
    }

}
