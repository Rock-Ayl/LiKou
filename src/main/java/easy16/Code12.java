package easy16;

/**
 * @Author ayl
 * @Date 2021-12-14
 * 617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * 输出:
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 */
public class Code12 {

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

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //判空左
        if (root1 != null) {
            //判空右
            if (root2 != null) {
                //初始化
                TreeNode mix = new TreeNode();
                //值
                mix.val = root1.val + root2.val;
                //左右
                mix.left = mergeTrees(root1.left, root2.left);
                mix.right = mergeTrees(root1.right, root2.right);
                //返回
                return mix;
            } else {
                //初始化
                TreeNode mix = new TreeNode();
                //值
                mix.val = root1.val;
                //左右
                mix.left = mergeTrees(root1.left, null);
                mix.right = mergeTrees(root1.right, null);
                //返回
                return mix;
            }
        } else {
            //判空右
            if (root2 != null) {
                //初始化
                TreeNode mix = new TreeNode();
                //值
                mix.val = root2.val;
                //左右
                mix.left = mergeTrees(null, root2.left);
                mix.right = mergeTrees(null, root2.right);
                //返回
                return mix;
            } else {
                //不作处理
                return null;
            }
        }
    }


}
