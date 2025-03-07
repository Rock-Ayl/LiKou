package normal13;

/**
 * @Author ayl
 * @Date 2022-05-08
 * 1026. 节点与其祖先之间的最大差值
 * 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 * <p>
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * 输出：7
 * 解释：
 * 我们有大量的节点与其祖先的差值，其中一些如下：
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,null,2,null,0,3]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在 2 到 5000 之间。
 * 0 <= Node.val <= 105
 */
public class Code18 {

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
    int maxMinus = 0;

    //不断进行下去
    public void next(TreeNode root, int min, int max) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //当前值
        int rootValue = root.val;
        //计算当前
        maxMinus = Math.max(maxMinus, Math.max(Math.abs(min - rootValue), Math.abs(max - rootValue)));
        //新最小,最大
        int nextMin = Math.min(min, rootValue);
        int nextMax = Math.max(max, rootValue);
        //下一级
        next(root.left, nextMin, nextMax);
        next(root.right, nextMin, nextMax);
    }

    public int maxAncestorDiff(TreeNode root) {
        //判空
        if (root == null) {
            //无
            return 0;
        }
        //其本身值
        int rootValue = root.val;
        //下一级
        next(root.left, rootValue, rootValue);
        next(root.right, rootValue, rootValue);
        //返回结果
        return maxMinus;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        one.left = two;
        two.right = three;
        three.right = four;
        new Code18().maxAncestorDiff(one);
    }

}
