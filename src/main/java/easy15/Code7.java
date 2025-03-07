package easy15;

/**
 * @Author ayl
 * @Date 2021-11-22
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 */
public class Code7 {

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

    //最小深度
    public int minDeep = Integer.MAX_VALUE;

    public void nextDeep(TreeNode root, int deep) {
        //如果已经不需要比了
        if (deep >= minDeep) {
            //过
            return;
        }
        //左右
        TreeNode left = root.left;
        TreeNode right = root.right;
        //如果到边距了
        if (left == null && right == null) {
            //记录结果
            minDeep = deep;
            //过
            return;
        }
        //如果左边不为空
        if (left != null) {
            //下一级
            nextDeep(left, deep + 1);
        }
        //如果右边不为空
        if (right != null) {
            //下一级
            nextDeep(right, deep + 1);
        }
    }

    public int minDepth(TreeNode root) {
        //判空
        if (root == null) {
            //过
            return 0;
        }
        //计算
        nextDeep(root, 1);
        //返回
        return minDeep;
    }

}
