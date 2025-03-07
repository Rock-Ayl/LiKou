package normal14;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-06-27
 * 2265. 统计值等于子树平均值的节点数
 * 给你一棵二叉树的根节点 root ，找出并返回满足要求的节点数，要求节点的值等于其 子树 中值的 平均值 。
 * <p>
 * 注意：
 * <p>
 * n 个元素的平均值可以由 n 个元素 求和 然后再除以 n ，并 向下舍入 到最近的整数。
 * root 的 子树 由 root 和它的所有后代组成。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [4,8,5,0,1,null,6]
 * 输出：5
 * 解释：
 * 对值为 4 的节点：子树的平均值 (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4 。
 * 对值为 5 的节点：子树的平均值 (5 + 6) / 2 = 11 / 2 = 5 。
 * 对值为 0 的节点：子树的平均值 0 / 1 = 0 。
 * 对值为 1 的节点：子树的平均值 1 / 1 = 1 。
 * 对值为 6 的节点：子树的平均值 6 / 1 = 6 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1]
 * 输出：1
 * 解释：对值为 1 的节点：子树的平均值 1 / 1 = 1。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 1000] 内
 * 0 <= Node.val <= 1000
 */
public class code13 {

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

    //当前节点拥有的节点数
    Map<TreeNode, Integer> nodeCountMap = new HashMap<>();
    //当前节点拥有的和
    Map<TreeNode, Integer> nodeSumMap = new HashMap<>();
    //结果
    int result = 0;

    //开始计算
    public void next(TreeNode root) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //先计算子节点
        next(root.left);
        next(root.right);
        //尝试获取
        int leftCount = nodeCountMap.getOrDefault(root.left, 0);
        int rightCount = nodeCountMap.getOrDefault(root.right, 0);
        //当前
        int thisCount = leftCount + rightCount + 1;
        //记录当前
        nodeCountMap.put(root, thisCount);
        //尝试获取
        int leftSum = nodeSumMap.getOrDefault(root.left, 0);
        int rightSum = nodeSumMap.getOrDefault(root.right, 0);
        //当前和
        int thisSum = leftSum + rightSum + root.val;
        //记录当前
        nodeSumMap.put(root, thisSum);
        //如果满足条件
        if (thisSum / thisCount == root.val) {
            //记录
            result++;
        }
    }

    public int averageOfSubtree(TreeNode root) {
        //开始计算
        next(root);
        //返回结果
        return result;
    }

}
