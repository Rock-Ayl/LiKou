package easy16;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-12-13
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * <p>
 * <p>
 * 输入：root = [1,2]
 * 输出：[2,1]
 * 示例 5：
 * <p>
 * <p>
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Code11 {

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

    public List<Integer> inorderTraversal(TreeNode root) {
        //判空
        if (root == null) {
            //初始化
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        //左边
        list.addAll(inorderTraversal(root.left));
        //中间
        list.add(root.val);
        //右边
        list.addAll(inorderTraversal(root.right));
        //返回
        return list;
    }

}
