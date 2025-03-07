package easy14;

/**
 * @Author ayl
 * @Date 2021-11-15
 * 404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 * <p>
 * 示例：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * <p>
 * <p>
 * 通过次数106,512提交次数181,666
 */
public class Code15 {

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

    //结果
    int sum = 0;

    public void add(TreeNode root) {
        //判空
        if (root == null) {
            //发过
            return;
        }
        //如果存在左叶子
        if (root.left != null && root.left.left == null && root.left.right == null) {
            //叠加
            sum += root.left.val;
        }
        //下面
        add(root.left);
        add(root.right);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        //计算
        add(root);
        //返回
        return sum;
    }

}
