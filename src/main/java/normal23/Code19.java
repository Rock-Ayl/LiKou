package normal23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-09-04
 * 2415. 反转二叉树的奇数层
 * 提示
 * 中等
 * 25
 * 相关企业
 * 给你一棵 完美 二叉树的根节点 root ，请你反转这棵树中每个 奇数 层的节点值。
 * <p>
 * 例如，假设第 3 层的节点值是 [2,1,3,4,7,11,29,18] ，那么反转后它应该变成 [18,29,11,7,4,3,1,2] 。
 * 反转后，返回树的根节点。
 * <p>
 * 完美 二叉树需满足：二叉树的所有父节点都有两个子节点，且所有叶子节点都在同一层。
 * <p>
 * 节点的 层数 等于该节点到根节点之间的边数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [2,3,5,8,13,21,34]
 * 输出：[2,5,3,8,13,21,34]
 * 解释：
 * 这棵树只有一个奇数层。
 * 在第 1 层的节点分别是 3、5 ，反转后为 5、3 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [7,13,11]
 * 输出：[7,11,13]
 * 解释：
 * 在第 1 层的节点分别是 13、11 ，反转后为 11、13 。
 * 示例 3：
 * <p>
 * 输入：root = [0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]
 * 输出：[0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]
 * 解释：奇数层由非零值组成。
 * 在第 1 层的节点分别是 1、2 ，反转后为 2、1 。
 * 在第 3 层的节点分别是 1、1、1、1、2、2、2、2 ，反转后为 2、2、2、2、1、1、1、1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数目在范围 [1, 214] 内
 * 0 <= Node.val <= 105
 * root 是一棵 完美 二叉树
 */
public class Code19 {

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

    //缓存
    private Map<Integer, List<TreeNode>> map = new HashMap<>();

    //递归
    public void next(TreeNode node, Integer deep) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //如果是目标层
        if (deep % 2 == 1) {
            //如果不存在
            if (map.containsKey(deep) == false) {
                //默认
                map.put(deep, new ArrayList<>());
            }
            //记录节点
            map.get(deep).add(node);
        }
        //递归
        Integer nextDeep = deep + 1;
        //递归
        next(node.left, nextDeep);
        next(node.right, nextDeep);
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        //递归所有节点
        next(root, 0);
        //循环奇数层
        for (List<TreeNode> nodeList : map.values()) {
            //双指针
            int left = 0;
            int right = nodeList.size() - 1;
            //循环
            while (left < right) {
                //获取左右节点
                TreeNode leftNode = nodeList.get(left++);
                TreeNode rightNode = nodeList.get(right--);
                //交换二者的值
                int midValue = leftNode.val;
                leftNode.val = rightNode.val;
                rightNode.val = midValue;
            }
        }
        //返回结果
        return root;
    }

}
