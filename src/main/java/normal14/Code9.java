package normal14;

/**
 * @Author ayl
 * @Date 2022-06-21
 * 面试题 04.06. 后继者
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * <p>
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [2,1,3], p = 1
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 * <p>
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * <p>
 * 输出: null
 */
public class Code9 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //上一个节点
    TreeNode lastNode = null;
    //结果节点
    TreeNode resultNode = null;

    public boolean find(TreeNode root, TreeNode p) {
        //判空
        if (root == null) {
            //没找到
            return false;
        }
        //后续遍历,先找右节点,判断是否找到
        if (find(root.right, p)) {
            //找到了
            return true;
        }
        //后续遍历,再找中间节点,判断是否找到
        if (root.val == p.val) {
            //记录结果
            resultNode = lastNode;
            //找到了
            return true;
        }
        //后续遍历,最后再找左节点,判断是否找到
        lastNode = root;
        //继续寻找
        if (find(root.left, p)) {
            //找到了
            return true;
        }
        //默认未找到
        return false;
    }

    //本质上就是后续遍历,找到目标,返回上一个节点
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //寻找
        find(root, p);
        //返回目标
        return resultNode;
    }

}
