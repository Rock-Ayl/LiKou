package normal33;

/**
 * @Author ayl
 * @Date 2024-07-29
 * 979. 在二叉树中分配硬币
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个有 n 个结点的二叉树的根结点 root ，其中树中每个结点 node 都对应有 node.val 枚硬币。整棵树上一共有 n 枚硬币。
 * <p>
 * 在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。移动可以是从父结点到子结点，或者从子结点移动到父结点。
 * <p>
 * 返回使每个结点上 只有 一枚硬币所需的 最少 移动次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,0,0]
 * 输出：2
 * 解释：一枚硬币从根结点移动到左子结点，一枚硬币从根结点移动到右子结点。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [0,3,0]
 * 输出：3
 * 解释：将两枚硬币从根结点的左子结点移动到根结点（两次移动）。然后，将一枚硬币从根结点移动到右子结点。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目为 n
 * 1 <= n <= 100
 * 0 <= Node.val <= n
 * 所有 Node.val 的值之和是 n
 */
public class Code20 {

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

    //移动金币的次数
    private int count = 0;

    //递归
    private int next(TreeNode node) {
        //判空
        if (node == null) {
            //过
            return 0;
        }
        //当前节点 提交/所需 金币的数量,由于最后该节点需要1枚金币,所以默认-1,并优先递归子节点
        int thisCount = node.val - 1 + next(node.left) + next(node.right);
        //计算本节点 提交/所需 金币移动次数,无论提交、所需,均算移动
        this.count += Math.abs(thisCount);
        //返回需要/提交的金币数量
        return thisCount;
    }

    public int distributeCoins(TreeNode root) {
        //递归
        next(root);
        //返回结果
        return this.count;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(0);
        TreeNode two = new TreeNode(3);
        TreeNode three = new TreeNode(0);


        one.left = two;
        one.right = three;

        System.out.println(new Code20().distributeCoins(one));
    }

}
