package normal11;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-02-12
 * 1372. 二叉树中的最长交错路径
 * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
 * <p>
 * 选择二叉树中 任意 节点和一个方向（左或者右）。
 * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 * 改变前进方向：左变右或者右变左。
 * 重复第二步和第三步，直到你在树中无法继续移动。
 * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
 * <p>
 * 请你返回给定树中最长 交错路径 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
 * 输出：3
 * 解释：蓝色节点为树中最长交错路径（右 -> 左 -> 右）。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,1,1,null,1,null,null,1,1,null,1]
 * 输出：4
 * 解释：蓝色节点为树中最长交错路径（左 -> 右 -> 左 -> 右）。
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每棵树最多有 50000 个节点。
 * 每个节点的值在 [1, 100] 之间。
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

    //缓存
    Map<String, Integer> map = new HashMap<>();

    public int longestZigZag(TreeNode root) {
        //判空
        if (root == null) {
            //默认
            return 0;
        }
        //当前最大
        int thisMax = 0;
        //如果有左边
        if (root.left != null) {
            //先从子节点计算,这样就有缓存了
            int one = longestZigZag(root.left);
            //拿去左边右树的最大值并计算
            int two = map.getOrDefault(root.left.toString() + "r", 0) + 1;
            //记录缓存
            map.put(root.toString() + "l", two);
            //刷新最大记录
            thisMax = Math.max(thisMax, one);
            thisMax = Math.max(thisMax, two);
        }
        //如果有右边
        if (root.right != null) {
            //先从子节点计算,这样就有缓存了
            int one = longestZigZag(root.right);
            //拿去右边左树的最大值并计算
            int two = map.getOrDefault(root.right.toString() + "l", 0) + 1;
            //记录缓存
            map.put(root.toString() + "r", two);
            //刷新最大记录
            thisMax = Math.max(thisMax, one);
            thisMax = Math.max(thisMax, two);
        }
        //返回最大
        return thisMax;
    }

    public static void main(String[] args) {
        TreeNode zero = new TreeNode(1);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(1);
        TreeNode three = new TreeNode(1);
        TreeNode four = new TreeNode(1);
        zero.left = one;
        one.left = two;
        two.right = three;
        three.left = four;
        System.out.println(new Code15().longestZigZag(zero));
    }

}
