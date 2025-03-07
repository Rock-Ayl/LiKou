package easy14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-11-03
 * 897. 递增顺序搜索树
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
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

    //集合
    List<TreeNode> list = new ArrayList<>();

    public void next(TreeNode root) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //记录
        list.add(root);
        //下一级
        next(root.left);
        next(root.right);
        //清空关系
        root.left = null;
        root.right = null;
    }

    public TreeNode increasingBST(TreeNode root) {
        //计算出来
        next(root);
        //排序
        list.sort(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return o1.val - o2.val;
            }
        });
        //循环
        for (int i = 0; i < list.size() - 1; i++) {
            //计算
            list.get(i).right = list.get(i + 1);
        }
        //返回第一个
        return list.get(0);
    }

}
