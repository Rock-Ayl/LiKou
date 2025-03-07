package easy14;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-11-09
 * 872. 叶子相似的树
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * <p>
 * <p>
 * <p>
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 * <p>
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * <p>
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root1 = [1], root2 = [1]
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：root1 = [1], root2 = [2]
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：root1 = [1,2], root2 = [2,2]
 * 输出：true
 * 示例 5：
 * <p>
 * <p>
 * <p>
 * 输入：root1 = [1,2,3], root2 = [1,3,2]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定的两棵树可能会有 1 到 200 个结点。
 * 给定的两棵树上的值介于 0 到 200 之间。
 */
public class Code10 {

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

    List<Integer> one = new ArrayList<>();
    List<Integer> two = new ArrayList<>();

    public void moveOne(TreeNode root1) {
        //判空
        if (root1 == null) {
            //过
            return;
        }
        //如果左右都是空
        if (root1.left == null && root1.right == null) {
            //记录结果
            one.add(root1.val);
        } else {
            //下一级
            moveOne(root1.left);
            moveOne(root1.right);
        }
    }

    public void moveTwo(TreeNode root2) {
        //判空
        if (root2 == null) {
            //过
            return;
        }
        //如果左右都是空
        if (root2.left == null && root2.right == null) {
            //记录结果
            two.add(root2.val);
        } else {
            //下一级
            moveTwo(root2.left);
            moveTwo(root2.right);
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        moveOne(root1);
        moveTwo(root2);
        return one.equals(two);
    }

}
