package easy20;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-06-26
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * 注意：本题与主站 236 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class Code12 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //缓存<子,父>
    Map<TreeNode, TreeNode> map = new HashMap<>();
    //缓存<node,深度>
    Map<TreeNode, Integer> deepMap = new HashMap<>();

    public void next(TreeNode node, TreeNode father, int deep) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //记录
        map.put(node, father);
        deepMap.put(node, deep);
        //下一级
        next(node.left, node, deep + 1);
        next(node.right, node, deep + 1);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //开始计算
        next(root, new TreeNode(-1), 0);
        //获取深度
        int pd = deepMap.get(p);
        int qd = deepMap.get(q);
        //如果深度不同
        while (pd != qd) {
            //对比
            if (pd > qd) {
                //往上走
                pd--;
                p = map.get(p);
            } else {
                //往上走
                qd--;
                q = map.get(q);
            }
        }
        //循环,直至找到同一节点
        while (p != q) {
            //循环
            p = map.get(p);
            q = map.get(q);
        }
        //返回
        return p;
    }

}
