package normal45;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2025-08-16
 * 1110. 删点成林
 * 尝试过
 * 算术评级: 6
 * 第 144 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1511
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 * <p>
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 * <p>
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * 输出：[[1,2,null,4],[6],[7]]
 * 示例 2：
 * <p>
 * 输入：root = [1,2,4,null,3], to_delete = [3]
 * 输出：[[1,2,4]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数最大为 1000。
 * 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
 * to_delete.length <= 1000
 * to_delete 包含一些从 1 到 1000、各不相同的值。
 */
public class Code20 {

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

    //递归删除
    private void delete(TreeNode node, TreeNode father, List<TreeNode> result, Set<Integer> deleteSet) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //先递归子节点
        delete(node.left, node, result, deleteSet);
        delete(node.right, node, result, deleteSet);
        //如果本节点是删除的节点
        if (deleteSet.contains(node.val) == true) {
            //如果有左边
            if (node.left != null) {
                //记录结果
                result.add(node.left);
            }
            //如果有右边
            if (node.right != null) {
                //记录结果
                result.add(node.right);
            }
            //如果有父节点
            if (father != null) {
                //如果左边是
                if (father.left == node) {
                    //置空
                    father.left = null;
                }
                //如果右边是
                if (father.right == node) {
                    //置空
                    father.right = null;
                }
            }
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        //结果
        List<TreeNode> result = new ArrayList<>();
        //要删除的节点
        Set<Integer> deleteSet = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        //特殊
        deleteSet.add(-1);
        //初始化空节点
        TreeNode none = new TreeNode(-1);
        //记录
        none.left = root;
        //递归
        delete(none, null, result, deleteSet);
        //返回结果
        return result;
    }

}
