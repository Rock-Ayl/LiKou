package easy14;

/**
 * @Author ayl
 * @Date 2021-11-06
 * 572. 另一棵树的子树
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,4,5,1,2], subRoot = [4,1,2]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * root 树上的节点数量范围是 [1, 2000]
 * subRoot 树上的节点数量范围是 [1, 1000]
 * -104 <= root.val <= 104
 * -104 <= subRoot.val <= 104
 */
public class Code7 {

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

    public boolean isSame(TreeNode root, TreeNode subRoot) {
        //如果大家都是空
        if (root == null && subRoot == null) {
            //算相同
            return true;
        }
        //如果存在空的 或者内容不同
        if ((root == null && subRoot != null) || (root != null && subRoot == null) || root.val != subRoot.val) {
            //不同
            return false;
        }
        //判断左右两边是否相同,一个不同算不同
        if (isSame(root.left, subRoot.left) == false || isSame(root.right, subRoot.right) == false) {
            //不同
            return false;
        }
        //默认
        return true;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //判空
        if (root != null) {
            //如果可以尝试找
            if (root.val == subRoot.val) {
                //如果相同
                if (isSame(root, subRoot)) {
                    //直接返回
                    return true;
                }
            }
            //左右
            if (isSubtree(root.left, subRoot)) {
                //直接返回
                return true;
            }
            //左右
            if (isSubtree(root.right, subRoot)) {
                //直接返回
                return true;
            }
        }
        //默认不是
        return false;
    }

}
