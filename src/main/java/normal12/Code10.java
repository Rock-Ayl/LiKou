package normal12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author ayl
 * @Date 2022-02-28
 * 1038. 从二叉搜索树到更大和树
 * 给定一个二叉搜索树 root (BST)，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 * <p>
 * 提醒一下， 二叉搜索树 满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * 示例 2：
 * <p>
 * 输入：root = [0,null,1]
 * 输出：[1,null,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在 [1, 100] 范围内。
 * 0 <= Node.val <= 100
 * 树中的所有值均 不重复 。
 */
public class Code10 {

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
    List<TreeNode> nodeList = new ArrayList<>();

    //开始计算
    public void next(TreeNode root) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //组装
        nodeList.add(root);
        //下一级
        next(root.left);
        next(root.right);
    }

    public TreeNode bstToGst(TreeNode root) {
        //开始计算
        next(root);
        //排序
        nodeList.sort(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return o2.val - o1.val;
            }
        });
        //累计和
        int sum = 0;
        //循环
        for (TreeNode treeNode : nodeList) {
            //当前
            int val = treeNode.val;
            //当前计算
            treeNode.val = sum + val;
            //累计和计算
            sum += val;
        }
        //返回
        return root;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(7);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left = two;
        one.right = three;
        new Code10().bstToGst(one);
    }

}
