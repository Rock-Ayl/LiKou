package normal9;

/**
 * @Author ayl
 * @Date 2021-12-27
 * 513. 找树左下角的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 * <p>
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [1,104]
 * -231 <= Node.val <= 231 - 1
 */
public class Code1 {

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

    //默认深度
    int deep = 0;
    //默认深度的值
    int num = 0;

    public void next(TreeNode root, int deep) {
        //判空
        if (root == null) {
            //返回
            return;
        }
        //如果深度更深
        if (deep > this.deep) {
            //刷新
            this.deep = deep;
            this.num = root.val;
        }
        //下一级
        next(root.left, deep + 1);
        next(root.right, deep + 1);
    }

    public int findBottomLeftValue(TreeNode root) {
        //默认
        num = root.val;
        //开始计算
        next(root, 1);
        //返回
        return num;
    }

}
