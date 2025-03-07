package normal12;

/**
 * @Author ayl
 * @Date 2022-02-23
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 * <p>
 * <p>
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 */
public class Code5 {

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

    //当前找到的最小元素位置
    int count = 0;
    //目标值
    int target = 0;

    public void find(TreeNode root, int k) {
        //判空 或 找到目标
        if (root == null || this.count == k) {
            //过
            return;
        }
        //先从左边
        find(root.left, k);
        //记录
        count++;
        //如果找到了
        if (this.count == k) {
            //记录目标值
            target = root.val;
            //过
            return;
        }
        //再从右边
        find(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        //开始寻找
        find(root, k);
        //返回
        return target;
    }

}
