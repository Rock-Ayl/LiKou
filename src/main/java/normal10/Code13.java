package normal10;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2022-01-25
 * 113. 路径总和 II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class Code13 {

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

    //全局结果
    List<List<Integer>> result = new ArrayList<>();
    //全局目标
    int targetSum;

    public void next(TreeNode root, int sum, List<Integer> list) {
        //当前和
        int thisSum = sum + root.val;
        //记录
        list.add(root.val);
        //如果等于,并且是最终节点
        if (thisSum == targetSum && root.left == null && root.right == null) {
            //记录
            result.add(new ArrayList<>(list));
        }
        //判空
        if (root.left != null) {
            //下一个
            next(root.left, thisSum, list);
        }
        //判空
        if (root.right != null) {
            //下一个
            next(root.right, thisSum, list);
        }
        //回溯
        list.remove(list.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //判空
        if (root == null) {
            //返回
            return result;
        }
        //全局
        this.targetSum = targetSum;
        //开始进行
        next(root, 0, new ArrayList<>());
        //返回
        return result;
    }

    public static void main(String[] args) {

        TreeNode one = new TreeNode(-2);
        TreeNode three = new TreeNode(-5);
        one.right = three;

        new Code13().pathSum(one, -5);
    }

}
