package normal15;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2022-08-05
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 示例 2：
 * <p>
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
 * 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
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

    //初始化结果
    List<List<Integer>> result = new ArrayList<>();

    //不断走
    public void next(TreeNode node, List<Integer> list, int sum, int target) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //当前值
        int num = node.val;
        //当前和
        int thisSum = num + sum;
        //如果大于目标了
        if (thisSum > target) {
            //过
            return;
        }
        //组装当前链表
        list.add(num);
        //判断是不是叶子
        if (node.left != null || node.right != null) {
            //下一级
            next(node.left, list, thisSum, target);
            next(node.right, list, thisSum, target);
        } else {
            //如果是目标
            if (thisSum == target) {
                //记录结果
                result.add(new ArrayList<>(list));
            }
        }
        //回溯
        list.remove(list.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        //计算
        next(root, new ArrayList<>(), 0, target);
        //返回
        return result;
    }

}
