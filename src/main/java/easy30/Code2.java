package easy30;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2023-04-14
 * 剑指 Offer II 056. 二叉搜索树中两个节点之和
 * 给定一个二叉搜索树的 根节点 root 和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: root = [8,6,10,5,7,9,11], k = 12
 * 输出: true
 * 解释: 节点 5 和节点 7 之和等于 12
 * 示例 2：
 * <p>
 * 输入: root = [8,6,10,5,7,9,11], k = 22
 * 输出: false
 * 解释: 不存在两个节点值之和为 22 的节点
 * <p>
 * <p>
 * 提示：
 * <p>
 * 二叉树的节点个数的范围是  [1, 104].
 * -104 <= Node.val <= 104
 * root 为二叉搜索树
 * -105 <= k <= 105
 * <p>
 * <p>
 * 注意：本题与主站 653 题相同： https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 */
public class Code2 {

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

    //默认没有
    private boolean had = false;
    //需要的
    private Set<Integer> needSet = new HashSet<>();

    //不断走
    public void next(TreeNode root, int k) {
        //如果有
        if (had == true) {
            //过
            return;
        }
        //判空
        if (root == null) {
            //过
            return;
        }
        //如果有该值
        if (needSet.contains(root.val)) {
            //有
            had = true;
            //过
            return;
        }
        //记录需要它
        needSet.add(k - root.val);
        //子树
        next(root.left, k);
        next(root.right, k);
    }

    public boolean findTarget(TreeNode root, int k) {
        //走下去
        next(root, k);
        //返回结果
        return had;
    }

}
