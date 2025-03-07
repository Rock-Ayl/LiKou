package normal8;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2021-12-21
 * 1315. 祖父节点值为偶数的节点和
 * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 * <p>
 * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 * 如果不存在祖父节点值为偶数的节点，那么返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：18
 * 解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 */
public class Code10 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //结果节点缓存
    Set<TreeNode> set = new HashSet<>();

    public void countChild(TreeNode root) {
        //两个儿子
        TreeNode father1 = root.left;
        TreeNode father2 = root.right;
        //判空
        if (father1 != null) {
            //孙子
            TreeNode child1 = father1.left;
            //如果存在
            if (child1 != null) {
                //记录
                set.add(child1);
            }
            TreeNode child2 = father1.right;
            //如果存在
            if (child2 != null) {
                //记录
                set.add(child2);
            }
        }
        //判空
        if (father2 != null) {
            //孙子
            TreeNode child1 = father2.left;
            //如果存在
            if (child1 != null) {
                //记录
                set.add(child1);
            }
            TreeNode child2 = father2.right;
            //如果存在
            if (child2 != null) {
                //记录
                set.add(child2);
            }
        }
    }

    public void next(TreeNode root) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //如果是偶数
        if (root.val % 2 == 0) {
            //记录这个祖父的所有孙子
            countChild(root);
        }
        //下一级
        next(root.left);
        next(root.right);
    }

    public int sumEvenGrandparent(TreeNode root) {
        //开始计算
        next(root);
        //如果没有
        if (set.size() == 0) {
            //默认
            return 0;
        }
        //和
        int sum = 0;
        //循环
        for (TreeNode treeNode : set) {
            //叠加
            sum += treeNode.val;
        }
        //返回
        return sum;
    }

}
