package normal15;

/**
 * @Author ayl
 * @Date 2022-07-04
 * 面试题 04.05. 合法二叉搜索树
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 * <p>
 * 示例 1:
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 */
public class Code2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //上一个值
    Integer last = null;

    //逻辑,后续遍历
    public boolean isValidBST(TreeNode root) {
        //判空
        if (root == null) {
            //是
            return true;
        }
        //先从右开始
        if (isValidBST(root.right) == false) {
            //返回
            return false;
        }
        //如果存在上一个值 and 上一个值小于等于当前
        if (last != null && last <= root.val) {
            //不是
            return false;
        }
        //赋予上一个值
        last = root.val;
        //最后是从左边
        if (isValidBST(root.left) == false) {
            //不是
            return false;
        }
        //默认
        return true;
    }

}
