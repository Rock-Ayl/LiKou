package normal15;

/**
 * @Author ayl
 * @Date 2022-08-06
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 B：
 * <p>
 * 4
 * /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 10000
 */
public class Code15 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean contain(TreeNode A, TreeNode B) {
        //判空
        if (B == null) {
            //是
            return true;
        }
        //判空
        if (A == null) {
            //不是
            return false;
        }
        //如果当前不是
        if (A.val != B.val) {
            //不是
            return false;
        }
        //如果B左边还有,并且不是
        if (B.left != null && contain(A.left, B.left) == false) {
            //不是
            return false;
        }
        //如果B右边还有,并且不是
        if (B.right != null && contain(A.right, B.right) == false) {
            //不是
            return false;
        }
        //默认是
        return true;
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //判空
        if (A == null || B == null) {
            //不是
            return false;
        }
        //如果当前就是
        if (contain(A, B)) {
            //是
            return true;
        }
        //如果有左树,并且左是
        if (A.left != null && isSubStructure(A.left, B)) {
            //是
            return true;
        }
        //如果有右树,并且又是
        if (A.right != null && isSubStructure(A.right, B)) {
            //是
            return true;
        }
        //默认不是
        return false;
    }

}
