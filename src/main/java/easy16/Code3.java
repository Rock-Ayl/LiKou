package easy16;

/**
 * @Author ayl
 * @Date 2021-12-05
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
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

    public void change(TreeNode root) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //记录左
        TreeNode left = root.left;
        //左变右
        root.left = root.right;
        //右变左
        root.right = left;
        //下一级
        change(root.left);
        change(root.right);
    }

    public TreeNode invertTree(TreeNode root) {
        //改变
        change(root);
        //返回
        return root;
    }

}
