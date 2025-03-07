package normal19;

/**
 * @Author ayl
 * @Date 2023-03-15
 * 1080. 根到叶路径上的不足节点
 * 给定一棵二叉树的根 root，请你考虑它所有 从根到叶的路径：从根到任何叶的路径。（所谓一个叶子节点，就是一个没有子节点的节点）
 * <p>
 * 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为「不足节点」，需要被删除。
 * <p>
 * 请你删除所有不足节点，并返回生成的二叉树的根。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1
 * <p>
 * 输出：[1,2,3,4,null,null,7,8,9,null,14]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22
 * <p>
 * 输出：[5,4,8,11,null,17,4,7,null,null,null,5]
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [5,-6,-6], limit = 0
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定的树有 1 到 5000 个节点
 * -10^5 <= node.val <= 10^5
 * -10^9 <= limit <= 10^9
 */
public class Code7 {

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

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        //判空
        if (root == null) {
            //返回
            return null;
        }
        //如果是叶节点
        if (root.left == null && root.right == null) {
            //如果该叶节点和满足要求
            if (limit - root.val <= 0) {
                //返回当前节点
                return root;
            } else {
                //删除该节点
                return null;
            }
        }
        //计算下一次所需limit
        int nextLimit = limit - root.val;
        //递归子计算子节点
        root.left = sufficientSubset(root.left, nextLimit);
        root.right = sufficientSubset(root.right, nextLimit);
        //如果其俩子集都为空
        if (root.left == null && root.right == null) {
            //说明它也不满足,删除之
            return null;
        }
        //返回
        return root;
    }


}
