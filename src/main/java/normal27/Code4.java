package normal27;

/**
 * @Author ayl
 * @Date 2023-12-16
 * 1339. 分裂二叉树的最大乘积
 * 提示
 * 中等
 * 98
 * 相关企业
 * 给你一棵二叉树，它的根为 root 。请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。
 * <p>
 * 由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6]
 * 输出：110
 * 解释：删除红色的边，得到 2 棵子树，和分别为 11 和 10 。它们的乘积是 110 （11*10）
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,2,3,4,null,null,5,6]
 * 输出：90
 * 解释：移除红色的边，得到 2 棵子树，和分别是 15 和 6 。它们的乘积为 90 （15*6）
 * 示例 3：
 * <p>
 * 输入：root = [2,3,9,10,7,8,6,5,4,11,1]
 * 输出：1025
 * 示例 4：
 * <p>
 * 输入：root = [1,1]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每棵树最多有 50000 个节点，且至少有 2 个节点。
 * 每个节点的值在 [1, 10000] 之间。
 */
public class Code4 {

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

    //所有节点和
    private long sum;
    //最大结果
    private long maxCount;

    //step1. 递归求和
    private void nextSum(TreeNode node) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //叠加
        sum += node.val;
        //下一级
        nextSum(node.left);
        nextSum(node.right);
    }

    //step2. 递归计算最大结果
    private int nextCount(TreeNode node) {
        //判空
        if (node == null) {
            //默认
            return 0;
        }
        //先计算左右节点
        int leftSum = nextCount(node.left);
        int rightSum = nextCount(node.right);
        //当前和
        int sum = node.val + leftSum + rightSum;
        //计算本次结果,刷新最大结果
        this.maxCount = Math.max(this.maxCount, sum * (this.sum - sum));
        //返回当前和
        return sum;
    }

    public int maxProduct(TreeNode root) {
        //初始化和
        this.sum = 0L;
        //step1. 递归求和
        nextSum(root);
        //初始化最大结果
        this.maxCount = 0L;
        //step2. 递归计算最大结果
        nextCount(root);
        //返回
        return (int) (this.maxCount % 1000000007L);
    }

}
