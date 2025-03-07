package easy16;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-12-13
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Code14 {

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

    public List<Integer> postorderTraversal(TreeNode root) {
        //判空
        if (root == null) {
            //初始化
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        //左边
        list.addAll(postorderTraversal(root.left));
        //右边
        list.addAll(postorderTraversal(root.right));
        //中间
        list.add(root.val);
        //返回
        return list;
    }

}
