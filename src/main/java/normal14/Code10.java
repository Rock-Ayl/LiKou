package normal14;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-06-22
 * 662. 二叉树最大宽度
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * <p>
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 3     2
 * / \     \
 * 5   3     9
 * <p>
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * /
 * 3
 * / \
 * 5   3
 * <p>
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 * 示例 3:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * /
 * 5
 * <p>
 * 输出: 2
 * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 * 示例 4:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * /     \
 * 5       9
 * /         \
 * 6           7
 * 输出: 8
 * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 * 注意: 答案在32位有符号整数的表示范围内。
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

    //记录每层第一个节点
    Map<Integer, TreeNode> firstMap = new HashMap<>();
    //记录每层最后一个节点
    Map<Integer, TreeNode> lastMap = new HashMap<>();
    //每个节点所处的位置
    Map<TreeNode, Integer> nodeCountMap = new HashMap<>();

    public void next(TreeNode root, int deep, int site) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //如果不存在
        if (firstMap.containsKey(deep) == false) {
            //记录第一个节点
            firstMap.put(deep, root);
        }
        //当前节点暂时为最后一个节点
        lastMap.put(deep, root);
        //记录当前节点的位置
        nodeCountMap.put(root, site);
        //下一级
        next(root.left, deep + 1, site * 2 - 1);
        next(root.right, deep + 1, site * 2);
    }

    public int widthOfBinaryTree(TreeNode root) {
        //先遍历,寻找每层最后一个节点
        next(root, 1, 1);
        //最大
        int max = 0;
        //循环
        for (Integer deep : lastMap.keySet()) {
            //根据深度,最后节点减去最开始节点,计算出中间长度
            int length = nodeCountMap.get(lastMap.get(deep)) - nodeCountMap.get(firstMap.get(deep)) + 1;
            //对比最大
            max = Math.max(length, max);
        }
        //返回
        return max;
    }

}
