package normal16;

import java.util.*;

/**
 * @Author ayl
 * @Date 2022-08-16
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
public class Code4 {

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

    //缓存
    private Set<List<TreeNode>> set = new HashSet<>();

    //不断走
    public void next(TreeNode node, int sum, int target, List<TreeNode> list) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //如果是结果
        if (node.val == target) {
            //记录
            set.add(Arrays.asList(node));
        }
        //组装当前
        list.add(node);
        //当前
        int thisSum = sum + node.val;
        //如果是结果
        if (thisSum == target) {
            //记录
            set.add(new ArrayList<>(list));
        }
        //继续走
        next(node.left, thisSum, target, list);
        next(node.right, thisSum, target, list);
        //它当首节点走
        next(node.left, node.val, target, list);
        next(node.right, node.val, target, list);
        //回溯
        list.remove(list.size() - 1);
    }

    public int pathSum(TreeNode root, int targetSum) {
        //走
        next(root, 0, targetSum, new ArrayList<>());
        //返回
        return set.size();
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three2 = new TreeNode(3);
        TreeNode three1 = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode ten = new TreeNode(10);
        TreeNode eleven = new TreeNode(11);
        TreeNode mug2 = new TreeNode(-2);
        TreeNode mug3 = new TreeNode(-3);

        ten.left = five;
        ten.right = mug3;

        mug3.right = eleven;

        five.left = three1;
        five.right = two;

        three1.left = three2;
        three1.right = mug2;

        two.right = one;

        System.out.println(new Code4().pathSum(ten, 8));

    }

}
