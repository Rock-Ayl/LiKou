package easy20;

/**
 * @Author ayl
 * @Date 2022-07-07
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 ≤ k ≤ 二叉搜索树元素个数
 */
public class Code18 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //目标
    int target;
    //当前第几
    int site = 0;
    //目标位
    int k;

    //后续遍历
    public void next(TreeNode root) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //后
        next(root.right);
        //如果找到了
        if (site == k) {
            //过
            return;
        }
        //+1,如果是
        if (++site == k) {
            //记录结果
            target = root.val;
            //过
            return;
        }
        //左
        next(root.left);
    }

    public int kthLargest(TreeNode root, int k) {
        //全局
        this.k = k;
        //后续遍历
        next(root);
        //返回结果
        return target;
    }

}
