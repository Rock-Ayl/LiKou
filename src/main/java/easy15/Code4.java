package easy15;

/**
 * @Author ayl
 * @Date 2021-11-19
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * <p>
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class Code4 {

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

    //对比
    public boolean isMirror(TreeNode left, TreeNode right) {
        //判空
        if (left == null && right == null) {
            //一致
            return true;
        }
        //如果有一方不为空
        if ((left == null && right != null) || (left != null && right == null)) {
            //不一致
            return false;
        }
        //如果值不同
        if (left.val != right.val) {
            //不一致
            return false;
        }
        //如果出现问题
        if (isMirror(left.right, right.left) == false) {
            //不一致
            return false;
        }
        //如果出现问题
        if (isMirror(left.left, right.right) == false) {
            //不一致
            return false;
        }
        //默认
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

}
