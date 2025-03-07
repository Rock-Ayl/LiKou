package normal21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-07-05
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 */
public class Code13 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //结果
    private List<List<Integer>> list = new ArrayList<>();

    //递归是实现
    public void next(TreeNode node, int deep) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //获取层级对应列表
        LinkedList<Integer> linkedList;
        //如果数量与深度相同
        if (list.size() == deep) {
            //初始化一个
            linkedList = new LinkedList<>();
            //组装
            list.add(linkedList);
        } else {
            //获取当前
            linkedList = (LinkedList<Integer>) list.get(deep);
        }
        //如果是偶数
        if (deep % 2 == 0) {
            //组装结果
            linkedList.addFirst(node.val);
        } else {
            //组装结果
            linkedList.addLast(node.val);
        }
        //递归子节点
        next(node.right, deep + 1);
        next(node.left, deep + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        //递归实现
        next(root, 0);
        //返回结果
        return list;
    }

}
