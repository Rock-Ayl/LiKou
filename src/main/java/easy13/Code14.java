package easy13;

/**
 * @Author ayl
 * @Date 2021-10-27
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 2 * 104] 内
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * 所有 Node.val 互不相同
 */
public class Code14 {

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
    //大小边界
    int low, high;

    public void next(TreeNode root) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //值
        int num = root.val;
        //如果满足条件
        if (num <= high && num >= low) {
            //记录
            sum += num;
        }
        //如果过大了
        if (num >= high) {
            //只往小找
            next(root.left);
        } else if (num <= low) {
            //只往大找
            next(root.right);
        } else {
            //大小都都找
            next(root.left);
            next(root.right);
        }
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        next(root);
        //返回
        return sum;
    }

}
