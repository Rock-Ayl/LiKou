package difficult;

/**
 * @Author ayl
 * @Date 2022-04-28
 * 124. 二叉树中的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
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
 */
public class Code11 {

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

    //不断从底向上计算
    public int count(TreeNode root) {
        //判空
        if (root == null) {
            //直接返回
            return 0;
        }
        //当前
        int num = root.val;
        //左右,并且最小为0
        int left = Math.max(count(root.left), 0);
        int right = Math.max(count(root.right), 0);
        //本次可以左右连接
        max = Math.max(max, num + left + right);
        //如果要返回上级,则只能选择一个路径的,并且要大于0
        return num + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        //计算
        count(root);
        //返回最大结果
        return max;
    }

}
