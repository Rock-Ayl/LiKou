package normal55;

import java.awt.*;

/**
 * 450. 删除二叉搜索树中的节点
 * 算术评级: 5
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * 输出：[5,4,6,2,null,null,7]
 * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], key = 0
 * 输出: [5,3,6,2,4,null,7]
 * 解释: 二叉树不包含值为 0 的节点
 * 示例 3:
 * <p>
 * 输入: root = [], key = 0
 * 输出: []
 * <p>
 * <p>
 * 提示:
 * <p>
 * 节点数的范围 [0, 104].
 * -105 <= Node.val <= 105
 * 节点值唯一
 * root 是合法的二叉搜索树
 * -105 <= key <= 105
 * <p>
 * <p>
 * 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。
 *
 *
 */
public class Code17 {

    private static class TreeNode {
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

    public TreeNode deleteNode(TreeNode root, int key) {
        //判空
        if (root == null) {
            //过
            return null;
        }
        //两种情况 是 or 不是
        if (root.val == key) {
            //返回合并的子节点
            return merge(root.left, root.right);
        } else {
            //递归子节点
            root.left = deleteNode(root.left, key);
            root.right = deleteNode(root.right, key);
            //返回
            return root;
        }
    }

    //合并子节点
    private TreeNode merge(TreeNode left, TreeNode right) {
        //判空
        if (left == null) {
            //返回
            return right;
        }
        //判空
        if (right == null) {
            //返回
            return left;
        }
        //插入节点
        insert(left, right);
        //返回更大的
        return right;
    }

    //插入节点
    private void insert(TreeNode left, TreeNode right) {
        //判空
        if (right.left == null) {
            //插入
            right.left = left;
            //结束
            return;
        } else {
            //递归
            insert(left, right.left);
        }
    }

}
