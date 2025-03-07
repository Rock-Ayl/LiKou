package normal10;

/**
 * @Author ayl
 * @Date 2022-01-27
 * 437. 路径总和 III
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
 */
public class Code15 {

    public static class TreeNode {
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

    //次数
    int count = 0;

    public void next(TreeNode root, int sum, int targetSum) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //当前结果
        int thisSum = sum + root.val;
        //如果是目标值
        if (thisSum == targetSum) {
            //记录
            count++;
        }
        //继续计算
        next(root.left, thisSum, targetSum);
        next(root.right, thisSum, targetSum);
    }

    public void next(TreeNode root, int targetSum) {
        //循环
        if (root != null) {
            //开始计算
            next(root, 0, targetSum);
            //下一级
            next(root.left, targetSum);
            next(root.right, targetSum);
        }
    }

    public int pathSum(TreeNode root, int targetSum) {
        //每个节点都遍历一次
        next(root, targetSum);
        //返回
        return count;
    }

    public static void main(String[] args) {

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        one.right = two;
        two.right = three;
        three.right = four;
        four.right = five;

        System.out.println(new Code15().pathSum(one, 3));
    }

}
