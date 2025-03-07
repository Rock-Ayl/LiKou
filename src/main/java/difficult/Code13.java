package difficult;

/**
 * @Author ayl
 * @Date 2022-07-13
 * 剑指 Offer II 051. 节点之和最大的路径
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给定一个二叉树的根节点 root ，返回其 最大路径和，即所有路径上节点值之和的最大值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 * <p>
 * <p>
 * 注意：本题与主站 124 题相同： https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 */
public class Code13 {

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
    int max = Integer.MIN_VALUE;

    //不断计算,并返回最大结果
    public int next(TreeNode node) {
        //判空
        if (node == null) {
            //过
            return 0;
        }
        //当前节点值
        int nodeValue = node.val;
        //先计算左右节点能带来的结果
        int left = next(node.left);
        int right = next(node.right);
        //刷新最大结果
        max = Math.max(left + right + nodeValue, max);
        //返回最大的路线,最小返回0
        return Math.max(nodeValue + Math.max(left, right), 0);
    }

    public int maxPathSum(TreeNode root) {
        //计算
        next(root);
        //返回结果
        return max;
    }

}
