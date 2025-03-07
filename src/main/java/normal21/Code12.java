package normal21;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-07-04
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Code12 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //递归实现
    public TreeNode buildTree(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        //如果越界
        if (pl > pr) {
            //过
            return null;
        }
        //当前值
        int rootValue = preorder[pl];
        //当前节点
        TreeNode root = new TreeNode(rootValue);
        //如果只有一个节点
        if (pl == pr) {
            //直接返回
            return root;
        }
        //从缓存中中拿中旭遍历的对应中间点,也就是当前节点的坐标
        int iMid = this.inorderIndexMap.get(rootValue);
        //计算出前序遍历中间节点(左树最后一个节点的位置)
        int pMid = iMid - il + pl;
        //递归实现子节点
        root.left = buildTree(preorder, inorder, pl + 1, pMid, il, iMid - 1);
        root.right = buildTree(preorder, inorder, pMid + 1, pr, iMid + 1, ir);
        //返回结果
        return root;
    }

    //中旭遍历坐标缓存(消耗空间提升时间)
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //初始化
        this.inorderIndexMap = new HashMap<>();
        //循环
        for (int i = 0; i < inorder.length; i++) {
            //记录中旭遍历每个点坐标
            this.inorderIndexMap.put(inorder[i], i);
        }
        //实现
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static void main(String[] args) {
        TreeNode node = new Code12().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println();
    }

}
