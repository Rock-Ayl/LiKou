package normal15;

/**
 * @Author ayl
 * @Date 2022-07-30
 */
public class Code8 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //第一、第二节点
    Integer deep1 = null;
    TreeNode node1 = null;
    Integer deep2 = null;
    TreeNode node2 = null;
    //父亲
    TreeNode father = null;

    //遍历
    public TreeNode next(TreeNode root, TreeNode p, TreeNode q, int deep) {
        //判空
        if (root == null) {
            //过
            return null;
        }
        //左右节点
        TreeNode left = next(root.left, p, q, deep + 1);
        TreeNode right = next(root.right, p, q, deep + 1);
        //如果当前左右正好是父子
        if ((left == q && right == p) || (left == p && right == q)) {
            //记录父节点
            father = root;
            //过
            return null;
        }
        //如果是1
        if (root.val == p.val) {
            //记录
            deep1 = deep;
            node1 = root;
            //返回
            return root;
        }
        //如果是2
        if (root.val == q.val) {
            //记录
            deep2 = deep;
            node2 = root;
            //返回
            return root;
        }
        //如果左边是任意一个
        if (left == p || left == q) {
            //返回
            return left;
        }
        //如果右边是任意一个
        if (right == p || right == q) {
            //返回
            return right;
        }
        //默认
        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //判空
        if (root == null) {
            //过
            return null;
        }
        //计算
        next(root, p, q, 0);
        //如果有父亲
        if (father != null) {
            //直接返回
            return father;
        }
        //如果左大于右
        if (deep1 >= deep2) {
            //返回1
            return node2;
        } else {
            //返回2
            return node1;
        }
    }

    public static void main(String[] args) {

        TreeNode zero = new TreeNode(0);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);

        three.left = five;
        three.right = one;

        one.left = zero;
        one.right = eight;

        five.left = six;
        five.right = two;

        two.left = seven;
        two.right = four;

        System.out.println(new Code8().lowestCommonAncestor(three, five, four).val);

    }

}
