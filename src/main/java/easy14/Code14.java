package easy14;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-11-14
 * 257. 二叉树的所有路径
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：["1"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [1, 100] 内
 * -100 <= Node.val <= 100
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

    //结果
    List<String> result = new ArrayList<>();

    public void count(TreeNode root, StringBuilder str) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //当前
        int num = root.val;
        //组装
        str.append(num);
        //如果到底了
        if (root.left == null && root.right == null) {
            //记录结果
            result.add(str.toString());
        } else {
            //下一级
            str.append("->");
            //继续计算
            count(root.left, new StringBuilder(str));
            count(root.right, new StringBuilder(str));
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        //计算
        count(root, new StringBuilder());
        //返回
        return result;
    }

}
