package normal15;

/**
 * @Author ayl
 * @Date 2022-08-02
 * 剑指 Offer II 045. 二叉树最底层最左边的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 * <p>
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [1,104]
 * -231 <= Node.val <= 231 - 1
 * <p>
 * <p>
 * 注意：本题与主站 513 题相同： https://leetcode-cn.com/problems/find-bottom-left-tree-value/
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

    //目标
    private TreeNode target = null;
    //最大深度
    private int maxDeep = -1;

    //深度
    private void next(TreeNode root, int deep) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //如果更大
        if (deep > maxDeep) {
            //刷新
            maxDeep = deep;
            //记录
            target = root;
        }
        //下一级
        next(root.left, deep + 1);
        next(root.right, deep + 1);
    }

    public int findBottomLeftValue(TreeNode root) {
        //计算
        next(root, 0);
        //返回
        return target.val;
    }

}
