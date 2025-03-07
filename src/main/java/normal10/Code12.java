package normal10;

/**
 * @Author ayl
 * @Date 2022-01-24
 * 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 */
public class Code12 {

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

    public TreeNode unfold(TreeNode root) {
        //判空
        if (root == null) {
            //返回
            return null;
        }
        //先获取左右
        TreeNode left = root.left;
        TreeNode right = root.right;
        //开始衔接
        root.left = null;
        //如果左边有
        if (left != null) {
            //先连接左边
            root.right = left;
        } else if (right != null) {
            //直接连接右边
            root.right = right;
        } else {
            //如果左右为空,返回本身
            return root;
        }
        //计算
        TreeNode leftEnd = unfold(left);
        TreeNode rightEnd = unfold(right);
        //如果左边结尾不为空
        if (leftEnd != null) {
            //左尾连接右首
            leftEnd.right = right;
        }
        //返回最后一级
        return rightEnd != null ? rightEnd : leftEnd;
    }

    public void flatten(TreeNode root) {
        //开始计算
        unfold(root);
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(5);
        one.left = two;
        one.right = three;

        TreeNode five = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        two.left = five;
        two.right = four;

        TreeNode six = new TreeNode(6);
        three.right = six;

        new Code12().flatten(one);

    }


}
