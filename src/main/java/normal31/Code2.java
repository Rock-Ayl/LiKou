package normal31;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2024-04-19
 * 889. 根据前序和后序遍历构造二叉树
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。
 * <p>
 * 如果存在多个答案，您可以返回其中 任何 一个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 * 示例 2:
 * <p>
 * 输入: preorder = [1], postorder = [1]
 * 输出: [1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= preorder.length <= 30
 * 1 <= preorder[i] <= preorder.length
 * preorder 中所有值都 不同
 * postorder.length == preorder.length
 * 1 <= postorder[i] <= postorder.length
 * postorder 中所有值都 不同
 * 保证 preorder 和 postorder 是同一棵二叉树的前序遍历和后序遍历
 */
public class Code2 {

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

    //递归实现
    private TreeNode next(int[] preorder, int[] postorder, int oneLeft, int oneRight, int twoLeft, int twoRight, Map<Integer, Integer> preorderMap) {
        //如果越界
        if (oneLeft > oneRight) {
            //过
            return null;
        }
        //初始化当前主节点
        TreeNode node = new TreeNode(preorder[oneLeft]);
        //如果只有一个节点
        if (oneLeft == oneRight) {
            //初始化并返回
            return node;
        }
        //如果没有右节点
        if (postorder[twoRight - 1] == preorder[oneLeft + 1]) {
            //递归左节点
            node.left = next(preorder, postorder, oneLeft + 1, oneRight, twoLeft, twoRight - 1, preorderMap);
            //返回
            return node;
        }
        //获取右树主节点的数字
        int rightNumber = postorder[twoRight - 1];
        //获取其对应索引
        Integer rightNumberIndex = preorderMap.get(rightNumber);
        //左节点数量
        int leftNodeCount = (rightNumberIndex - 1) - (oneLeft + 1) + 1;
        //右节点数量
        int rightNodeCount = oneRight - oneLeft - leftNodeCount;
        //如果有
        if (leftNodeCount > 0) {
            //递归左节点
            node.left = next(preorder, postorder, oneLeft + 1, rightNumberIndex - 1, twoLeft, twoLeft + leftNodeCount - 1, preorderMap);
        }
        //如果有
        if (rightNodeCount > 0) {
            //递归右节点
            node.right = next(preorder, postorder, rightNumberIndex, oneRight, twoLeft + leftNodeCount, twoRight - 1, preorderMap);
        }
        //返回当前节点
        return node;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        //索引缓存
        Map<Integer, Integer> preorderMap = new HashMap<>();
        //勋魂
        for (int i = 0; i < preorder.length; i++) {
            //记录索引
            preorderMap.put(preorder[i], i);
        }
        //递归
        return next(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1, preorderMap);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new Code2().constructFromPrePost(
                new int[]{9, 5, 4, 10, 3, 1, 2, 8, 7, 6},
                new int[]{4, 5, 7, 8, 6, 2, 1, 3, 10, 9}
        );
        System.out.println();
    }


}
