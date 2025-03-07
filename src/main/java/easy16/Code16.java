package easy16;

/**
 * @Author ayl
 * @Date 2021-12-18
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 */
public class Code16 {

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

    //计算高度
    public int deep(TreeNode root) {
        //判空
        if (root == null) {
            //返回
            return 0;
        }
        //计算两边最大
        return Math.max(deep(root.right), deep(root.left)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        //判空
        if (root == null) {
            //默认
            return true;
        }
        //左右高度
        int left = deep(root.left);
        int right = deep(root.right);
        //如果不平衡
        if (Math.abs(left - right) > 1) {
            //不是
            return false;
        }
        //如果子节点存在不满足
        if (isBalanced(root.left) == false || isBalanced(root.right) == false) {
            //不是
            return false;
        }
        //默认
        return true;
    }

}
