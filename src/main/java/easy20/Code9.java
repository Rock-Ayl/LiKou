package easy20;

/**
 * @Author ayl
 * @Date 2022-06-19
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * <p>
 * <p>
 * <p>
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * <p>
 * <p>
 * <p>
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class Code9 {

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

    //最大结果
    int max = 0;

    public int next(TreeNode root) {
        //判空
        if (root == null) {
            //返回
            return 0;
        }
        //左右最大可能
        int left = next(root.left);
        int right = next(root.right);
        //刷新最大
        max = Math.max(left + right, max);
        //返回该数组提供的最大距离
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        //开始计算
        next(root);
        //返回结果
        return max;
    }

}
