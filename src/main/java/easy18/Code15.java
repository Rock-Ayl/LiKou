package easy18;

/**
 * @Author ayl
 * @Date 2022-05-05
 * 563. 二叉树的坡度
 * 给你一个二叉树的根节点 root ，计算并返回 整个树 的坡度 。
 * <p>
 * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
 * <p>
 * 整个树 的坡度就是其所有节点的坡度之和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：1
 * 解释：
 * 节点 2 的坡度：|0-0| = 0（没有子节点）
 * 节点 3 的坡度：|0-0| = 0（没有子节点）
 * 节点 1 的坡度：|2-3| = 1（左子树就是左子节点，所以和是 2 ；右子树就是右子节点，所以和是 3 ）
 * 坡度总和：0 + 0 + 1 = 1
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [4,2,9,3,5,null,7]
 * 输出：15
 * 解释：
 * 节点 3 的坡度：|0-0| = 0（没有子节点）
 * 节点 5 的坡度：|0-0| = 0（没有子节点）
 * 节点 7 的坡度：|0-0| = 0（没有子节点）
 * 节点 2 的坡度：|3-5| = 2（左子树就是左子节点，所以和是 3 ；右子树就是右子节点，所以和是 5 ）
 * 节点 9 的坡度：|0-7| = 7（没有左子树，所以和是 0 ；右子树正好是右子节点，所以和是 7 ）
 * 节点 4 的坡度：|(3+5+2)-(9+7)| = |10-16| = 6（左子树值为 3、5 和 2 ，和是 10 ；右子树值为 9 和 7 ，和是 16 ）
 * 坡度总和：0 + 0 + 0 + 2 + 7 + 6 = 15
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [21,7,14,1,1,2,2,3,3]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目的范围在 [0, 104] 内
 * -1000 <= Node.val <= 1000
 */
public class Code15 {

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

    //坡度和
    int slopeSum = 0;

    public int count(TreeNode root) {
        //判空
        if (root == null) {
            //默认
            return 0;
        }
        //左右和
        int leftSum = count(root.left);
        int rightSum = count(root.right);
        //计算坡度
        int slope = Math.abs(rightSum - leftSum);
        //叠加
        slopeSum += slope;
        //返回当前节点和
        return root.val + leftSum + rightSum;
    }

    public int findTilt(TreeNode root) {
        //开始计算
        count(root);
        //返回结果
        return slopeSum;
    }

}
