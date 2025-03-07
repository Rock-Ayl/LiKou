package normal14;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-06-14
 * 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [2,1,3]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围在[1, 104] 内
 * -231 <= Node.val <= 231 - 1
 */
public class Code6 {

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

    //缓存,当前节点最大、最小
    Map<TreeNode, Integer> max = new HashMap<>();
    Map<TreeNode, Integer> min = new HashMap<>();

    public boolean isValidBST(TreeNode root) {
        //判空
        if (root == null) {
            //是
            return true;
        }
        //当前
        int num = root.val;
        //如果有左边
        if (root.left != null) {
            //如果左边不是平衡或有更大的
            if (isValidBST(root.left) == false || max.get(root.left) >= num) {
                //不是
                return false;
            }
            //记录
            min.put(root, min.get(root.left));
        } else {
            //记录
            min.put(root, num);
        }
        //如果有右边
        if (root.right != null) {
            //如果右边不是平衡或有更小的
            if (isValidBST(root.right) == false || min.get(root.right) <= num) {
                //不是
                return false;
            }
            //记录
            max.put(root, max.get(root.right));
        } else {
            //记录
            max.put(root, num);
        }
        //默认是
        return true;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        two.left = one;
        two.right = three;

        System.out.println(new Code6().isValidBST(two));
        ;
    }

}
