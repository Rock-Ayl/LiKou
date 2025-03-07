package normal8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2021-12-25
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * <p>
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层序遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * 通过次数446,991提交次数696,037
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

    public List<List<Integer>> levelOrder(TreeNode root) {
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
        int p = 1;
        //循环
        while (p <= maxDeep) {
            //记录结果
            result.add(map.get(p++));
        }
        //返回
        return result;
    }

}
