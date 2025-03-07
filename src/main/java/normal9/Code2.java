package normal9;

/**
 * @Author ayl
 * @Date 2021-12-28
 * 222. 完全二叉树的节点个数
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目范围是[0, 5 * 104]
 * 0 <= Node.val <= 5 * 104
 * 题目数据保证输入的树是 完全二叉树
 * <p>
 * <p>
 * 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
 */
public class Code2 {

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

    //是否已经到底
    boolean isMaxDeep = false;
    //最大深度
    int maxDeep = 0;
    //最大深度总个数
    int maxDeepSize = 0;

    public boolean next(TreeNode root, int deep) {
        //判空
        if (root == null) {
            //继续执行
            return true;
        }
        //当前深度
        int thisDeep = deep + 1;
        //判断当前深度是否刷新记录，又或者叠加记录
        if (thisDeep > maxDeep) {
            //刷新
            maxDeep = thisDeep;
            maxDeepSize = 1;
        } else if (thisDeep == maxDeep) {
            //记录
            maxDeepSize++;
        } else {
            //无价值
        }
        //如果找到了最大深度(第一个没有孩子的节点视为最大深度,因为是完全二叉树)
        if (isMaxDeep == false && root.left == null && root.right == null) {
            //是最大深度
            isMaxDeep = true;
            //继续执行
            return true;
        }
        //如果当前是最大深度的父级
        if (isMaxDeep == true && thisDeep + 1 == maxDeep) {
            //如果到头了
            if (root.left == null || root.right == null) {
                //如果左边有
                if (root.left != null) {
                    //+1
                    maxDeepSize++;
                }
                //不再继续执行
                return false;
            }
        }
        //左右
        if (next(root.left, thisDeep) == false) {
            //不再执行
            return false;
        }
        if (next(root.right, thisDeep) == false) {
            //不再执行
            return false;
        }
        //继续执行
        return true;
    }

    public int countNodes(TreeNode root) {
        //开始计算
        next(root, 0);
        //如果最大为0
        if (maxDeep == 0) {
            //不存在
            return 0;
        }
        //如果是1
        if (maxDeep == 1) {
            //不存在
            return 1;
        }
        //如果是1
        if (maxDeep == 2) {
            //返回
            return 1 + maxDeepSize;
        }
        //初始次数
        int up = 3;
        //初始倍数
        int mul = 2;
        //循环
        while (maxDeep-- > 3) {
            //加倍
            mul = mul * 2;
            //计算
            up += mul;
        }
        //默认计算
        return maxDeepSize + up;
    }

    public static void main(String[] args) {

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left = two;
        one.right = three;

        TreeNode five = new TreeNode(4);
        TreeNode four = new TreeNode(5);
        two.left = five;
        two.right = four;

        TreeNode six = new TreeNode(6);
        three.left = six;


        System.out.println(new Code2().countNodes(one));
    }

}
