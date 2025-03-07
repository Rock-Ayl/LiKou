package normal19;

/**
 * @Author ayl
 * @Date 2023-03-25
 * 106. 从中序与后序遍历序列构造二叉树
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder 和 postorder 都由 不同 的值组成
 * postorder 中每一个值都在 inorder 中
 * inorder 保证是树的中序遍历
 * postorder 保证是树的后序遍历
 */
public class Code16 {

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

    //递归
    public TreeNode next(int[] inorder, int[] postorder, int il, int ir, int pl, int pr) {
        //初始化当前主节点
        TreeNode root = new TreeNode(postorder[pr]);
        //如果只有一个节点
        if (il == ir || pl == pr) {
            //过
            return root;
        }
        //要寻找的主节点在i列表的坐标
        int p = il;
        //如果不是主节点(这里肯定能找到)
        while (inorder[p] != root.val) {
            //进位
            p++;
        }
        //本次左右子树的数量
        int leftTreeCount = p - il;
        int rightTreeCount = ir - p;
        //如果有左子树
        if (leftTreeCount > 0) {
            //计算左子树
            root.left = next(inorder, postorder, il, p - 1, pl, pl + leftTreeCount - 1);
        }
        //如果有右子树
        if (rightTreeCount > 0) {
            //计算右子树
            root.right = next(inorder, postorder, p + 1, ir, pr - rightTreeCount, pr - 1);
        }
        //返回
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //递归实现
        return next(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public static void main(String[] args) {
        TreeNode node = new Code16().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println();
    }

}
