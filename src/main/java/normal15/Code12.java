package normal15;

/**
 * @Author ayl
 * @Date 2022-08-03
 * 剑指 Offer II 053. 二叉搜索树中的中序后继
 * 给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。
 * <p>
 * 节点 p 的后继是值比 p.val 大的节点中键值最小的节点，即按中序遍历的顺序节点 p 的下一个节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [2,1,3], p = 1
 * 输出：2
 * 解释：这里 1 的中序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,null,1], p = 6
 * 输出：null
 * 解释：因为给出的节点没有中序后继，所以答案就返回 null 了。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [1, 104] 内。
 * -105 <= Node.val <= 105
 * 树中各节点的值均保证唯一。
 * <p>
 * <p>
 * 注意：本题与主站 285 题相同： https://leetcode-cn.com/problems/inorder-successor-in-bst/
 */
public class Code12 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //结果
    TreeNode target = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //判空
        if (root == null) {
            //过
            return null;
        }
        //如果可能是目标节点
        if (root.val > p.val) {
            //如果没有
            if (target == null) {
                //直接记录
                target = root;
            } else {
                //如果更小
                if (target.val > root.val) {
                    //刷新
                    target = root;
                }
            }
        }
        //下一级
        inorderSuccessor(root.left, p);
        inorderSuccessor(root.right, p);
        //返回目标结果
        return target;
    }

}
