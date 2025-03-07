package normal8;

/**
 * @Author ayl
 * @Date 2021-12-20
 * 1302. 层数最深叶子节点的和
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 * 示例 2：
 * <p>
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：19
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 104] 之间。
 * 1 <= Node.val <= 100
 */
public class Code9 {

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

    //最深节点
    int maxDeep = -1;
    //最深深度和
    int sum = 0;

    public void next(TreeNode root, int deep) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //下一级
        next(root.left, deep + 1);
        next(root.right, deep + 1);
        //如果当前节点超过最高记录或是其本身
        if (deep > this.maxDeep) {
            //刷新记录,重新计算
            this.maxDeep = deep;
            this.sum = root.val;
        } else if (deep == this.maxDeep) {
            //叠加
            this.sum += root.val;
        }
    }

    public int deepestLeavesSum(TreeNode root) {
        //开始计算
        next(root, 0);
        //返回
        return sum;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left = two;
        one.right = three;

        TreeNode five = new TreeNode(4);
        TreeNode four = new TreeNode(5);
        three.left = five;
        three.right = four;

        TreeNode six = new TreeNode(6);
        two.left = six;

        TreeNode seven = new TreeNode(7);
        six.left = seven;

        TreeNode eight = new TreeNode(8);
        four.right = eight;


        System.out.println(new Code9().deepestLeavesSum(one));
    }

}
