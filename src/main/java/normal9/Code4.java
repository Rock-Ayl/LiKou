package normal9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-12-30
 * 1305. 两棵二叉搜索树中的所有元素
 * 给你 root1 和 root2 这两棵二叉搜索树。
 * <p>
 * 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 * 示例 2：
 * <p>
 * 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * 输出：[-10,0,0,1,2,5,7,10]
 * 示例 3：
 * <p>
 * 输入：root1 = [], root2 = [5,1,7,0,2]
 * 输出：[0,1,2,5,7]
 * 示例 4：
 * <p>
 * 输入：root1 = [0,-10,10], root2 = []
 * 输出：[-10,0,10]
 * 示例 5：
 * <p>
 * <p>
 * <p>
 * 输入：root1 = [1,null,8], root2 = [8,1]
 * 输出：[1,1,8,8]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每棵树最多有 5000 个节点。
 * 每个节点的值在 [-10^5, 10^5] 之间。
 */
public class Code4 {

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

    List<Integer> list = new ArrayList<>();

    public void next(TreeNode root) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //组装
        list.add(root.val);
        //下一级
        next(root.left);
        next(root.right);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        //记录
        next(root1);
        next(root2);
        //排序
        Collections.sort(list);
        //返回
        return list;
    }

}
