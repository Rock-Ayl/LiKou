package normal55;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 971. 翻转二叉树以匹配先序遍历
 * 算术评级: 5
 * 第 118 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1787
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一棵二叉树的根节点 root ，树中有 n 个节点，每个节点都有一个不同于其他节点且处于 1 到 n 之间的值。
 * <p>
 * 另给你一个由 n 个值组成的行程序列 voyage ，表示 预期 的二叉树 先序遍历 结果。
 * <p>
 * 通过交换节点的左右子树，可以 翻转 该二叉树中的任意节点。例，翻转节点 1 的效果如下：
 * <p>
 * <p>
 * 请翻转 最少 的树中节点，使二叉树的 先序遍历 与预期的遍历行程 voyage 相匹配 。
 * <p>
 * 如果可以，则返回 翻转的 所有节点的值的列表。你可以按任何顺序返回答案。如果不能，则返回列表 [-1]。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2], voyage = [2,1]
 * 输出：[-1]
 * 解释：翻转节点无法令先序遍历匹配预期行程。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3], voyage = [1,3,2]
 * 输出：[1]
 * 解释：交换节点 2 和 3 来翻转节点 1 ，先序遍历可以匹配预期行程。
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [1,2,3], voyage = [1,2,3]
 * 输出：[]
 * 解释：先序遍历已经匹配预期行程，所以不需要翻转节点。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数目为 n
 * n == voyage.length
 * 1 <= n <= 100
 * 1 <= Node.val, voyage[i] <= n
 * 树中的所有值 互不相同
 * voyage 中的所有值 互不相同
 */
public class Code18 {

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

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        //初始化结果
        List<Integer> result = new ArrayList<>(voyage.length);
        //递归
        int index = next(root, voyage, 0, result);
        //如果不可能
        if (index == -1) {
            //失败
            return Arrays.asList(-1);
        }
        //返回
        return result;
    }

    //递归
    private int next(TreeNode node, int[] voyage, int voyageIndx, List<Integer> result) {
        //判空 or 已经失败了
        if (node == null || voyageIndx == -1) {
            //直接返回
            return voyageIndx;
        }
        //判断当前节点
        if (voyage[voyageIndx++] != node.val) {
            //失败
            return -1;
        }
        //判断是否需要交换
        if (node.left != null && node.right != null && node.right.val == voyage[voyageIndx] == true) {
            //交换
            TreeNode mid = node.left;
            node.left = node.right;
            node.right = mid;
            //记录本次交换
            result.add(node.val);
        }
        //递归左节点
        voyageIndx = next(node.left, voyage, voyageIndx, result);
        //递归右节点,直接返回
        return next(node.right, voyage, voyageIndx, result);
    }

}
