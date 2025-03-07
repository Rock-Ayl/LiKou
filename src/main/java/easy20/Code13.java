package easy20;

/**
 * @Author ayl
 * @Date 2022-06-28
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 1000
 * <p>
 * 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
 */
public class Code13 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //对比节点
    public boolean isNodeSymmetric(TreeNode left, TreeNode right) {
        //判空
        if (left == null) {
            //返回结果
            return right == null;
        }
        //判空
        if (right == null) {
            //不是
            return left == null;
        }
        //对比节点 && 子节点结果
        return left.val == right.val && isNodeSymmetric(left.right, right.left) && isNodeSymmetric(left.left, right.right);
    }

    public boolean isSymmetric(TreeNode root) {
        //判空
        if (root == null) {
            //是
            return true;
        }
        //对比
        return isNodeSymmetric(root.left, root.right);
    }

}
