package normal22;

/**
 * @Author ayl
 * @Date 2023-08-02
 * 面试题 04.12. 求和路径
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * 3
 * 解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
 * 提示：
 * <p>
 * 节点总数 <= 10000
 */
public class Code16 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //结果
    private int sumCount = 0;

    //递归走下去
    private void next(TreeNode node, int sum, int target) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //当前和
        int nextSum = sum + node.val;
        //如果是目标结果
        if (nextSum == target) {
            //记录
            this.sumCount++;
        }
        //递归
        next(node.left, nextSum, target);
        next(node.right, nextSum, target);
    }

    //递归到这里节点时,以这个节点为主节点开始走
    private void findFirstNode(TreeNode node, int target) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //以这个节点为主节点开始走
        next(node, 0, target);
        //继续递归
        findFirstNode(node.left, target);
        findFirstNode(node.right, target);
    }

    public int pathSum(TreeNode root, int sum) {
        //递归实现
        findFirstNode(root, sum);
        //返回结果
        return this.sumCount;
    }

}
