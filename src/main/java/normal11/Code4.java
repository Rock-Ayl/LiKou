package normal11;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-02-01
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 * <p>
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 */
public class Code4 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //父子缓存<子,父>
    Map<TreeNode, TreeNode> map = new HashMap<>();
    //两个目标节点及深度
    TreeNode p = null;
    TreeNode q = null;
    int pp = Integer.MIN_VALUE;
    int qp = Integer.MIN_VALUE;

    public void next(TreeNode root, int deep, TreeNode father, int p, int q) {
        //如果本身不存在,或者都找到了
        if (root == null || (this.p != null && this.q != null)) {
            //过
            return;
        }
        //记录父子级关系
        map.put(root, father);
        //如果是目标之一
        if (root.val == p) {
            //记录
            this.p = root;
            this.pp = deep;
        } else if (root.val == q) {
            //记录
            this.q = root;
            this.qp = deep;
        }
        //下一级
        next(root.left, deep + 1, root, p, q);
        next(root.right, deep + 1, root, p, q);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //先遍历一遍,找到目标节点,并记录所有父子关系
        next(root, 0, null, p.val, q.val);
        //判断谁更深,将更深的拉平
        if (pp > qp) {
            //循环
            while (pp > qp) {
                //变更为上一级
                this.p = map.get(this.p);
                pp--;
            }
        } else {
            //循环
            while (qp > pp) {
                //变更为上一级
                this.q = map.get(this.q);
                qp--;
            }
        }
        //如果二者节点是一个
        if (this.q != this.p) {
            //不断递归
            while (this.p != this.q) {
                //各自寻找上一级
                this.p = map.get(this.p);
                this.q = map.get(this.q);
            }
        }
        //返回二者本身
        return this.q;
    }

}
