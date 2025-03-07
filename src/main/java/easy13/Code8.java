package easy13;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2021-10-21
 * 653. 两数之和 IV - 输入 BST
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], k = 9
 * 输出: true
 * 示例 2：
 * <p>
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], k = 28
 * 输出: false
 * 示例 3：
 * <p>
 * 输入: root = [2,1,3], k = 4
 * 输出: true
 * 示例 4：
 * <p>
 * 输入: root = [2,1,3], k = 1
 * 输出: false
 * 示例 5：
 * <p>
 * 输入: root = [2,1,3], k = 3
 * 输出: true
 * <p>
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是  [1, 104].
 * -104 <= Node.val <= 104
 * root 为二叉搜索树
 * -105 <= k <= 105
 */
public class Code8 {

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

    //缓存
    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        //当前
        int num = root.val;
        //需要
        int need = k - num;
        //如果存在
        if (set.contains(need)) {
            //返回
            return true;
        }
        //记录当前
        set.add(num);
        //如果存在
        if (root.left != null) {
            //尝试
            boolean success = findTarget(root.left, k);
            //如果成功
            if (success) {
                //返回
                return true;
            }
        }
        //如果存在
        if (root.right != null) {
            //尝试
            boolean success = findTarget(root.right, k);
            //如果成功
            if (success) {
                //返回
                return true;
            }
        }
        //默认
        return false;
    }

}
