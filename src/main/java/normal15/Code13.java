package normal15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-08-04
 * 剑指 Offer II 046. 二叉树的右侧视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * 示例 2:
 * <p>
 * 输入: [1,null,3]
 * 输出: [1,3]
 * 示例 3:
 * <p>
 * 输入: []
 * 输出: []
 * <p>
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [0,100]
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * 注意：本题与主站 199 题相同：https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */
public class Code13 {

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
    Map<Integer, TreeNode> map = new HashMap<>();

    public void next(TreeNode node, int deep) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //如果不存在
        if (map.containsKey(deep) == false) {
            //记录
            map.put(deep, node);
        }
        //下一级
        next(node.right, deep + 1);
        next(node.left, deep + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        //计算
        next(root, 0);
        //初始化
        List<Integer> result = new ArrayList<>(map.size());
        //指针
        int p = 0;
        //如果存在
        while (map.containsKey(p)) {
            //记录
            result.add(map.get(p++).val);
        }
        //返回
        return result;
    }

}
