package easy21;

/**
 * @Author ayl
 * @Date 2022-07-12
 * 剑指 Offer II 052. 展平二叉搜索树
 * 给你一棵二叉搜索树，请 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数的取值范围是 [1, 100]
 * 0 <= Node.val <= 1000
 * <p>
 * <p>
 * 注意：本题与主站 897 题相同： https://leetcode-cn.com/problems/increasing-order-search-tree/
 */
public class Code3 {

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

    //要返回的节点
    TreeNode result;
    TreeNode node;

    public void next(TreeNode root) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //先记录左右节点
        TreeNode left = root.left;
        TreeNode right = root.right;
        //置空
        root.left = null;
        root.right = null;
        //先左节点
        next(left);
        //连接
        node.right = root;
        //下一个
        node = node.right;
        //再右节点
        next(right);
    }

    public TreeNode increasingBST(TreeNode root) {
        //判空
        if (root == null) {
            //过
            return null;
        }
        //初始化0节点
        result = new TreeNode(-1);
        node = result;
        //开始计算
        next(root);
        //返回结果
        return result.right;
    }

    public static void main(String[] args) {
        new Code3().increasingBST(new TreeNode(1));
    }

}
