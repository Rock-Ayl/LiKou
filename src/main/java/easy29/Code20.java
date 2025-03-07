package easy29;

/**
 * @Author ayl
 * @Date 2023-04-13
 * 面试题 04.04. 检查平衡性
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 *
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *       1
 *      / \
 *     2   2
 *    / \
 *   3   3
 *  / \
 * 4   4
 * 返回 false 。
 * 通过次数44,807提交次数75,089
 */
public class Code20 {

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
