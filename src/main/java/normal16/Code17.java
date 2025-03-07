package normal16;

/**
 * @Author ayl
 * @Date 2022-10-08
 * LCP 67. 装饰树
 * 力扣嘉年华上的 DIY 手工展位准备了一棵缩小版的 二叉 装饰树 root 和灯饰，你需要将灯饰逐一插入装饰树中，要求如下：
 * <p>
 * 完成装饰的二叉树根结点与 root 的根结点值相同
 * 若一个节点拥有父节点，则在该节点和他的父节点之间插入一个灯饰（即插入一个值为 -1 的节点）。具体地：
 * 在一个 父节点 x 与其左子节点 y 之间添加 -1 节点， 节点 -1、节点 y 为各自父节点的左子节点，
 * 在一个 父节点 x 与其右子节点 y 之间添加 -1 节点， 节点 -1、节点 y 为各自父节点的右子节点，
 * 现给定二叉树的根节点 root ，请返回完成装饰后的树的根节点。
 * 示例 1：
 * <p>
 * 输入：
 * root = [7,5,6]
 * <p>
 * 输出：[7,-1,-1,5,null,null,6]
 * <p>
 * 解释：如下图所示，
 * image.png
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * root = [3,1,7,3,8,null,4]
 * <p>
 * 输出：[3,-1,-1,1,null,null,7,-1,-1,null,-1,3,null,null,8,null,4]
 * <p>
 * 解释：如下图所示
 * image.png
 * <p>
 * 提示：
 * <p>
 * 0 <= root.Val <= 1000
 * root 节点数量范围为 [1, 10^5]
 */
public class Code17 {

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

    public TreeNode expandBinaryTree(TreeNode root) {
        //判空
        if (root == null) {
            //过
            return null;
        }
        //如果有左节点
        if (root.left != null) {
            //继续走
            TreeNode left = expandBinaryTree(root.left);
            //初始化中间节点
            TreeNode midNode = new TreeNode(-1);
            //嫁接当前的
            root.left = midNode;
            midNode.left = left;
        }
        //如果有右节点
        if (root.right != null) {
            //继续走
            TreeNode right = expandBinaryTree(root.right);
            //初始化中间节点
            TreeNode midNode = new TreeNode(-1);
            //嫁接当前的
            root.right = midNode;
            midNode.right = right;
        }
        //返回
        return root;
    }

}
