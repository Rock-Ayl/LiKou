package easy21;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2022-07-18
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * <p>
 * <p>
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 * 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class Code7 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //初始化
    List<List<Integer>> result = new ArrayList<>();

    //不断走下去,打印
    public void next(TreeNode node, int deep) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //获取列表
        List<Integer> list;
        //判断列表存不存在
        if (result.size() == deep) {
            //初始化
            list = new ArrayList<>();
            //组装
            result.add(list);
        } else {
            //获取
            list = result.get(deep);
        }
        //打印
        list.add(node.val);
        //下一级
        next(node.left, deep + 1);
        next(node.right, deep + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        //走下去
        next(root, 0);
        //返回结果
        return result;
    }

}
