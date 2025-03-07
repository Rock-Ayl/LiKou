package easy32;

/**
 * @Author ayl
 * @Date 2023-06-28
 * 面试题 17.12. BiNode
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 * <p>
 * 返回转换后的单向链表的头节点。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 * 提示：
 * <p>
 * 节点数量不会超过 100000。
 */
public class Code8 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode convertBiNode(TreeNode root) {
        //判空
        if (root == null) {
            //过
            return null;
        }
        //递归左右节点
        TreeNode leftNode = convertBiNode(root.left);
        TreeNode rightNode = convertBiNode(root.right);
        //置空
        root.left = null;
        //连接
        root.right = rightNode;
        //如果没有更小的
        if (leftNode == null) {
            //返回本身
            return root;
        }
        //先记录首节点
        TreeNode firstNode = leftNode;
        //如果还有
        while (leftNode.right != null) {
            //下一个
            leftNode = leftNode.right;
        }
        //连接
        leftNode.right = root;
        //返回左节点
        return firstNode;
    }

}
