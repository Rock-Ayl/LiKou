package easy13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-10-24
 * 783. 二叉搜索树节点最小距离
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 示例 2：
 *
 *
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 */
public class Code11 {

    public class TreeNode {
        int val;
        Code10.TreeNode left;
        Code10.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, Code10.TreeNode left, Code10.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    //值
    List<Integer> list = new ArrayList<>();

    public void next(Code10.TreeNode root) {
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

    public int minDiffInBST(Code10.TreeNode root) {
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

}
