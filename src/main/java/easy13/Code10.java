package easy13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-10-23
 * 530. 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 1
 * \
 * 3
 * /
 * 2
 * <p>
 * 输出：
 * 1
 * <p>
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 * 通过次数80,128提交次数128,944
 */
public class Code10 {

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


    //值
    List<Integer> list = new ArrayList<>();

    public void next(TreeNode root) {
        //记录
        list.add(root.val);
        //如果有左边
        if (root.left != null) {
            //下一级
            next(root.left);
        }
        //如果有右边
        if (root.right != null) {
            //下一级
            next(root.right);
        }
    }

    public int getMinimumDifference(TreeNode root) {
        //开始记录
        next(root);
        //排序
        Collections.sort(list);
        //最小绝对差
        int min = Integer.MAX_VALUE;
        //循环
        for (int i = 1; i < list.size(); i++) {
            //绝对差
            int minus = Math.abs(list.get(i) - list.get(i - 1));
            //如果更小
            if (min > minus) {
                //记录
                min = minus;
            }
        }
        //返回
        return min;
    }

    public static void main(String[] args) {

    }
}
