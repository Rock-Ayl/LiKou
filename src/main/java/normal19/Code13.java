package normal19;

/**
 * @Author ayl
 * @Date 2023-03-22
 * 1008. 前序遍历构造二叉搜索树
 * 给定一个整数数组，它表示BST(即 二叉搜索树 )的 先序遍历 ，构造树并返回其根。
 * <p>
 * 保证 对于给定的测试用例，总是有可能找到具有给定需求的二叉搜索树。
 * <p>
 * 二叉搜索树 是一棵二叉树，其中每个节点， Node.left 的任何后代的值 严格小于 Node.val , Node.right 的任何后代的值 严格大于 Node.val。
 * <p>
 * 二叉树的 前序遍历 首先显示节点的值，然后遍历Node.left，最后遍历Node.right。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：preorder = [8,5,1,7,10,12]
 * 输出：[8,5,10,1,7,null,12]
 * 示例 2:
 * <p>
 * 输入: preorder = [1,3]
 * 输出: [1,null,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= preorder.length <= 100
 * 1 <= preorder[i] <= 10^8
 * preorder 中的值 互不相同
 */
public class Code13 {

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

    //递归实现,不断缩小边距
    public TreeNode next(int[] preorder, int left, int right) {
        //如果越界 或 左边超过了右边
        if (left == preorder.length || left > right) {
            //过
            return null;
        }
        //当前数字
        int num = preorder[left];
        //初始化当前节点
        TreeNode root = new TreeNode(num);
        //如果只有一个主节点
        if (left == right) {
            //直接返回
            return root;
        }
        //开始节点
        int startP = left + 1;
        //如果有左子树
        if (preorder[startP] < num) {
            //结束节点
            int endP = startP;
            //如果还是左树的
            while (endP < preorder.length - 1 && preorder[endP + 1] < num) {
                //进位
                endP++;
            }
            //计算左子树
            root.left = next(preorder, startP, endP);
            //计算右子树
            root.right = next(preorder, endP + 1, right);
        } else {
            //直接计算右子树
            root.right = next(preorder, startP, right);
        }
        //返回主节点
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        //递归实现
        return next(preorder, 0, preorder.length - 1);
    }

    public static void main(String[] args) {
        TreeNode node = new Code13().bstFromPreorder(new int[]{4, 2});
        System.out.println();
    }

}
