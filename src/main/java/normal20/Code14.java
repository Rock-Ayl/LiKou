package normal20;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-05-15
 * 2641. 二叉树的堂兄弟节点 II
 * 给你一棵二叉树的根 root ，请你将每个节点的值替换成该节点的所有 堂兄弟节点值的和 。
 * <p>
 * 如果两个节点在树中有相同的深度且它们的父节点不同，那么它们互为 堂兄弟 。
 * <p>
 * 请你返回修改值之后，树的根 root 。
 * <p>
 * 注意，一个节点的深度指的是从树根节点到这个节点经过的边数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,4,9,1,10,null,7]
 * 输出：[0,0,0,7,7,null,11]
 * 解释：上图展示了初始的二叉树和修改每个节点的值之后的二叉树。
 * - 值为 5 的节点没有堂兄弟，所以值修改为 0 。
 * - 值为 4 的节点没有堂兄弟，所以值修改为 0 。
 * - 值为 9 的节点没有堂兄弟，所以值修改为 0 。
 * - 值为 1 的节点有一个堂兄弟，值为 7 ，所以值修改为 7 。
 * - 值为 10 的节点有一个堂兄弟，值为 7 ，所以值修改为 7 。
 * - 值为 7 的节点有两个堂兄弟，值分别为 1 和 10 ，所以值修改为 11 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [3,1,2]
 * 输出：[0,0,0]
 * 解释：上图展示了初始的二叉树和修改每个节点的值之后的二叉树。
 * - 值为 3 的节点没有堂兄弟，所以值修改为 0 。
 * - 值为 1 的节点没有堂兄弟，所以值修改为 0 。
 * - 值为 2 的节点没有堂兄弟，所以值修改为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目的范围是 [1, 105] 。
 * 1 <= Node.val <= 104
 */
public class Code14 {

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

    //深度对应节点和map
    private Map<Integer, Integer> deepSumMap = new HashMap<>();
    //节点深度map
    private Map<TreeNode, Integer> nodeDeepMap = new HashMap<>();
    //节点对应父节点
    private Map<TreeNode, TreeNode> fatherMap = new HashMap<>();
    //每个节点对应修改的值
    private Map<TreeNode, Integer> sumMap = new HashMap<>();

    //递归记录深度
    public void next(TreeNode node, TreeNode father, int deep) {
        //判空
        if (node == null) {
            //过
            return;
        }

        //记录深度和
        deepSumMap.put(deep, deepSumMap.getOrDefault(deep, 0) + node.val);
        //记录节点深度
        nodeDeepMap.put(node, deep);
        //记录子父关系
        fatherMap.put(node, father);

        //子节点
        next(node.left, node, deep + 1);
        next(node.right, node, deep + 1);
    }

    public TreeNode replaceValueInTree(TreeNode root) {

        //记录所有节点
        next(root, null, 0);

        //循环所有节点
        for (TreeNode node : nodeDeepMap.keySet()) {

            //当前节点对应深度的对应和
            int deepSum = deepSumMap.get(nodeDeepMap.get(node));

            //获取其父亲
            TreeNode father = fatherMap.get(node);
            //判空
            if (father == null) {
                //记录
                sumMap.put(node, 0);
                //本轮过
                continue;
            }

            //孩子和
            int childSum = 0;
            //如果有左节点
            if (father.left != null) {
                //叠加
                childSum += father.left.val;
            }
            //如果有右节点
            if (father.right != null) {
                //叠加
                childSum += father.right.val;
            }

            //记录
            sumMap.put(node, deepSum - childSum);

        }

        //最后循环节点
        for (Map.Entry<TreeNode, Integer> entry : sumMap.entrySet()) {
            //覆盖原有
            entry.getKey().val = entry.getValue();
        }

        return root;
    }

    public static void main(String[] args) {


        TreeNode one = new TreeNode(5);
        TreeNode two = new TreeNode(4);
        TreeNode three = new TreeNode(9);

        TreeNode four = new TreeNode(1);
        TreeNode five = new TreeNode(10);
        TreeNode six = new TreeNode(7);

        one.left = two;
        one.right = three;

        two.left = four;
        two.right = five;

        three.right = six;

        new Code14().replaceValueInTree(one);
    }

}
