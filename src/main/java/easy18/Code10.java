package easy18;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-04-30
 * 235. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
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

    //记录子父关系
    Map<TreeNode, TreeNode> childFatherMap = new HashMap<>();
    //左右深度
    Integer leftDeep;
    Integer rightDeep;

    //不断遍历
    public void next(TreeNode node, TreeNode father, int deep, TreeNode p, TreeNode q) {
        //判空
        if (node == null || (leftDeep != null && rightDeep != null)) {
            //过
            return;
        }
        //记录子、父关系
        childFatherMap.put(node, father);
        //如果是左节点
        if (node == p) {
            //记录深度
            leftDeep = deep;
        }
        //如果是右节点
        if (node == q) {
            //记录深度
            rightDeep = deep;
        }
        //下一级深度
        int nextDeep = deep + 1;
        //下一级
        next(node.left, node, nextDeep, p, q);
        next(node.right, node, nextDeep, p, q);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //不断遍历
        next(root, new TreeNode(-1), 0, p, q);
        //如果左右深度不同
        while (leftDeep != rightDeep) {
            //如果左节点更深
            if (leftDeep > rightDeep) {
                //向上走
                leftDeep--;
                //找到其父亲
                p = childFatherMap.get(p);
            } else {
                //向上走
                rightDeep--;
                //找到其父亲
                q = childFatherMap.get(q);
            }
        }
        //如果他们都不是同一个父亲
        while (p != q) {
            //找到其各自的父亲
            p = childFatherMap.get(p);
            q = childFatherMap.get(q);
        }
        //返回任意一个
        return q;
    }

}
