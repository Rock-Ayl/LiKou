package normal55;

/**
 * 998. 最大二叉树 II
 * 算术评级: 5
 * 第 125 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1498
 * 相关标签
 * premium lock icon
 * 相关企业
 * 最大树 定义：一棵树，并满足：其中每个节点的值都大于其子树中的任何其他值。
 * <p>
 * 给你最大树的根节点 root 和一个整数 val 。
 * <p>
 * 就像  之前的问题 那样，给定的树是利用 Construct(a) 例程从列表 a（root = Construct(a)）递归地构建的：
 * <p>
 * 如果 a 为空，返回 null 。
 * 否则，令 a[i] 作为 a 的最大元素。创建一个值为 a[i] 的根节点 root 。
 * root 的左子树将被构建为 Construct([a[0], a[1], ..., a[i - 1]]) 。
 * root 的右子树将被构建为 Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]]) 。
 * 返回 root 。
 * 请注意，题目没有直接给出 a ，只是给出一个根节点 root = Construct(a) 。
 * <p>
 * 假设 b 是 a 的副本，并在末尾附加值 val。题目数据保证 b 中的值互不相同。
 * <p>
 * 返回 Construct(b) 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [4,1,3,null,null,2], val = 5
 * 输出：[5,4,null,1,3,null,null,2]
 * 解释：a = [1,4,2,3], b = [1,4,2,3,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,2,4,null,1], val = 3
 * 输出：[5,2,4,null,1,null,3]
 * 解释：a = [2,1,5,4], b = [2,1,5,4,3]
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [5,2,3,null,1], val = 4
 * 输出：[5,2,4,null,1,3]
 * 解释：a = [2,1,5,3], b = [2,1,5,3,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 100] 内
 * 1 <= Node.val <= 100
 * 树中的所有值 互不相同
 * 1 <= val <= 100
 *
 */
public class Code13 {

    private static class TreeNode {
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

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        //如果 没有节点 or 新值最大
        if (root == null || root.val < val) {
            //初始化新节点,并关联
            return new TreeNode(val, root, null);
        }
        //递归实现
        return excute(root, val);
    }

    //递归实现
    public TreeNode excute(TreeNode root, int val) {
        //如果右边没有节点
        if (root.right == null) {
            //初始化新节点,并关联
            TreeNode newRight = new TreeNode(val, null, null);
            //关联
            root.right = newRight;
            //返回
            return root;
        }
        //如果右边小上边大
        if (root.right.val < val) {
            //初始化新节点,并关联
            TreeNode newRight = new TreeNode(val, null, null);
            //插入
            newRight.left = root.right;
            root.right = newRight;
            //返回
            return root;
        }
        //递归右边
        excute(root.right, val);
        //返回
        return root;
    }

}
