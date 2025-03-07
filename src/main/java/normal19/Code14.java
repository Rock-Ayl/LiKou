package normal19;

/**
 * @Author ayl
 * @Date 2023-03-23
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 */
public class Code14 {

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

    //递归,用区间处理左右子树的范围
    public TreeNode next(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        //如果任意左大于右
        if (pl > pr || il > ir) {
            //空过
            return null;
        }
        //当前节点是前序遍历的区间的第一个
        TreeNode root = new TreeNode(preorder[pl]);
        //如果任意左右相等
        if (pl == pr || il == ir) {
            //直接返回
            return root;
        }
        //指针
        int p = il;
        //如果不是目标(这个循环肯定有)
        while (inorder[p] != root.val) {
            //+1
            p++;
        }
        //计算该父节点左树的节点数
        int leftCount = p - il;
        //计算左子树结构
        root.left = next(preorder, inorder, pl + 1, pl + 1 + leftCount, il, p - 1);
        //计算右子树结构
        root.right = next(preorder, inorder, pl + 1 + leftCount, pr, p + 1, ir);
        //返回当前节点
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //递归实现
        return next(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static void main(String[] args) {
        TreeNode node = new Code14().buildTree(
                new int[]{3, 9, 20, 15, 7},
                new int[]{9, 3, 15, 20, 7}
        );
        System.out.println();
    }

}
