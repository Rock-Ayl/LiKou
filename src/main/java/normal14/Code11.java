package normal14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-06-23
 * 剑指 Offer II 044. 二叉树每层的最大值
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 解释:
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 * 示例2：
 * <p>
 * 输入: root = [1,2,3]
 * 输出: [1,3]
 * 解释:
 * 1
 * / \
 * 2   3
 * 示例3：
 * <p>
 * 输入: root = [1]
 * 输出: [1]
 * 示例4：
 * <p>
 * 输入: root = [1,null,2]
 * 输出: [1,2]
 * 解释:
 * 1
 * \
 * 2
 * 示例5：
 * <p>
 * 输入: root = []
 * 输出: []
 * <p>
 * <p>
 * 提示：
 * <p>
 * 二叉树的节点个数的范围是 [0,104]
 * -231 <= Node.val <= 231 - 1
 * <p>
 * <p>
 * 注意：本题与主站 515 题相同： https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 */
public class Code11 {

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

    //最大深度
    int maxDeep = 0;
    //每层最大节点
    Map<Integer, Integer> deepMaxValMap = new HashMap<>();

    public void next(TreeNode node, int deep) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //刷新最大深度
        maxDeep = Math.max(maxDeep, deep);
        //刷新最大节点
        deepMaxValMap.put(deep, Math.max(deepMaxValMap.getOrDefault(deep, Integer.MIN_VALUE), node.val));
        //下一级
        next(node.left, deep + 1);
        next(node.right, deep + 1);
    }

    public List<Integer> largestValues(TreeNode root) {
        //开始遍历
        next(root, 1);
        //初始化结果
        List<Integer> result = new ArrayList<>(maxDeep);
        //指针
        int p = 1;
        //循环
        while (p <= maxDeep) {
            //组装
            result.add(deepMaxValMap.get(p++));
        }
        //返回
        return result;
    }

}
