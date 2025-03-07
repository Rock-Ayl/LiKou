package normal20;

/**
 * @Author ayl
 * @Date 2023-05-25
 * 剑指 Offer II 050. 向下的路径节点之和
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * 示例 2：
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 * <p>
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [0,1000]
 * -109 <= Node.val <= 109
 * -1000 <= targetSum <= 1000
 * <p>
 * <p>
 * 注意：本题与主站 437 题相同：https://leetcode-cn.com/problems/path-sum-iii/
 */
public class Code17 {

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

    //数量
    private int count = 0;

    //走下去
    public void next(TreeNode node, int targetSum, long num) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //当前和
        long thisNum = num + node.val;
        //如果是目标
        if (thisNum == targetSum) {
            //路径+1
            count++;
        }
        //走下去
        next(node.left, targetSum, thisNum);
        next(node.right, targetSum, thisNum);
    }

    public int pathSum(TreeNode root, int targetSum) {
        //判空
        if (root == null) {
            //过
            return count;
        }
        //从这个节点开始走
        next(root, targetSum, 0L);
        //递归子级
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        //返回结果
        return count;
    }

}
