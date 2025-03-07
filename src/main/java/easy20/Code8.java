package easy20;

/**
 * @Author ayl
 * @Date 2022-06-16
 * 100. 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * 示例 3：
 * <p>
 * <p>
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 */
public class Code8 {

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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //如果都空
        if (p == null && q == null) {
            //是
            return true;
        }
        //如果任一空
        if ((p == null && q != null) || (p != null && q == null)) {
            //不是
            return false;
        }
        //先判断主体
        if (p.val != q.val) {
            //不是
            return false;
        }
        //如果左右子树有不同
        if (isSameTree(p.left, q.left) == false || isSameTree(p.right, q.right) == false) {
            //不是
            return false;
        }
        //默认
        return true;
    }

}
