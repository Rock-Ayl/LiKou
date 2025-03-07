package easy17;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2021-12-19
 * 993. 二叉树的堂兄弟节点
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * <p>
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * <p>
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * <p>
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 */
public class Code1 {

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

    //父子缓存
    Map<Integer, TreeNode> childWithFather = new HashMap<>();
    //二者深度
    int xDeep = 0;
    int yDeep = 0;

    public void deep(TreeNode root, int deep, int x, int y) {
        //如果是左右
        if (root.val == x) {
            //记录当前深度
            xDeep = deep;
        }
        if (root.val == y) {
            //记录当前深度
            yDeep = deep;
        }
        //如果存在左边
        if (root.left != null) {
            //记录父亲节点
            childWithFather.put(root.left.val, root);
            //下一级
            deep(root.left, deep + 1, x, y);
        }
        //如果存在右边
        if (root.right != null) {
            //记录父亲节点
            childWithFather.put(root.right.val, root);
            //下一级
            deep(root.right, deep + 1, x, y);
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        //如果顶级不存
        if (root == null) {
            //肯定
            return true;
        }
        //顶级默认
        childWithFather.put(root.val, null);
        //开始计算
        deep(root, 0, x, y);
        //如果是同一父亲
        if (childWithFather.get(x) == childWithFather.get(y)) {
            //不是
            return false;
        }
        //如果深度不同
        if (xDeep != yDeep) {
            //不是
            return false;
        }
        //默认
        return true;
    }

}
