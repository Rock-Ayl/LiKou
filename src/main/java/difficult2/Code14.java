package difficult2;

/**
 * @Author ayl
 * @Date 2024-05-09
 * 1373. 二叉搜索子树的最大键值和
 * 尝试过
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
 * <p>
 * 二叉搜索树的定义如下：
 * <p>
 * 任意节点的左子树中的键值都 小于 此节点的键值。
 * 任意节点的右子树中的键值都 大于 此节点的键值。
 * 任意节点的左子树和右子树都是二叉搜索树。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
 * 输出：20
 * 解释：键值为 3 的子树是和最大的二叉搜索树。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [4,3,null,1,2]
 * 输出：2
 * 解释：键值为 2 的单节点子树是和最大的二叉搜索树。
 * 示例 3：
 * <p>
 * 输入：root = [-4,-2,-5]
 * 输出：0
 * 解释：所有节点键值都为负数，和最大的二叉搜索树为空。
 * 示例 4：
 * <p>
 * 输入：root = [2,1,3]
 * 输出：6
 * 示例 5：
 * <p>
 * 输入：root = [5,4,8,3,null,6,3]
 * 输出：7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每棵树有 1 到 40000 个节点。
 * 每个节点的键值在 [-4 * 10^4 , 4 * 10^4] 之间。
 */
public class Code14 {

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

    //最大结果
    private int maxNodeSum = 0;

    //默认非二叉树返回
    private static final int[] NOT_BINARY_SEARCH_TREE = new int[]{0, 0, 0, -1};

    //递归实现
    private int[] next(TreeNode node) {
        //判空
        if (node == null) {
            //过
            return null;
        }
        //无论如何,都要先递归子级
        int[] leftResult = next(node.left);
        int[] rightResult = next(node.right);
        //如果存在
        if (leftResult != null) {
            //如果右边不是二叉搜索树
            if (leftResult[3] == -1) {
                //过
                return NOT_BINARY_SEARCH_TREE;
            }
            //如果不满足二叉搜索树
            if (leftResult[1] >= node.val) {
                //过
                return NOT_BINARY_SEARCH_TREE;
            }
        }
        //如果存在
        if (rightResult != null) {
            //如果右边不是二叉搜索树
            if (rightResult[3] == -1) {
                //过
                return NOT_BINARY_SEARCH_TREE;
            }
            //如果不满足二叉搜索树
            if (rightResult[0] <= node.val) {
                //过
                return NOT_BINARY_SEARCH_TREE;
            }
        }
        //初始化本次节点结果
        int[] nodeResult = new int[]{
                leftResult == null ? node.val : leftResult[0],
                rightResult == null ? node.val : rightResult[1],
                (leftResult == null ? 0 : leftResult[2]) + node.val + (rightResult == null ? 0 : rightResult[2]),
                1};
        //刷新最大情况
        this.maxNodeSum = Math.max(this.maxNodeSum, nodeResult[2]);
        //返回
        return nodeResult;
    }

    public int maxSumBST(TreeNode root) {
        //递归实现
        next(root);
        //返回最大结果
        return this.maxNodeSum;
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);

        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);

        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(2);
        TreeNode node7 = new TreeNode(5);

        TreeNode node8 = new TreeNode(4);
        TreeNode node9 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node7.left = node8;
        node7.right = node9;

        System.out.println(new Code14().maxSumBST(node1));

    }

}
