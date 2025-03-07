package normal9;

import normal8.Code14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2021-12-31
 * 107. 二叉树的层序遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层序遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * 通过次数177,463提交次数252,825
 */
public class Code5 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    //缓存
    Map<Integer, List<Integer>> map = new HashMap<>();
    //默认深度
    int maxDeep = 0;

    public void next(TreeNode root, int deep) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //如果更深
        if (deep > maxDeep) {
            //刷新
            maxDeep = deep;
        }
        //尝试获取
        List<Integer> list = map.getOrDefault(deep, new ArrayList<>(deep * 2));
        //记录
        list.add(root.val);
        //组装回去
        map.put(deep, list);
        //如果有左边
        if (root.left != null) {
            //下一个
            next(root.left, deep + 1);
        }
        //如果有右边
        if (root.right != null) {
            //下一个
            next(root.right, deep + 1);
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //开始计算
        next(root, 1);
        //初始化
        List<List<Integer>> result = new ArrayList<>();
        //如果没有
        if (maxDeep == 0) {
            //直接返回
            return result;
        }
        //深度从1开始
        int p = maxDeep;
        //循环
        while (p >0) {
            //记录结果
            result.add(map.get(p--));
        }
        //返回
        return result;
    }

}
