package normal15;

/**
 * @Author ayl
 * @Date 2022-08-09
 * 面试题 04.10. 检查子树
 * 检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
 * <p>
 * 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
 * <p>
 * 注意：此题相对书上原题略有改动。
 * <p>
 * 示例1:
 * <p>
 * 输入：t1 = [1, 2, 3], t2 = [2]
 * 输出：true
 * 示例2:
 * <p>
 * 输入：t1 = [1, null, 2, 4], t2 = [3, 2]
 * 输出：false
 * 提示：
 * <p>
 * 树的节点数目范围为[0, 20000]。
 */
public class Code18 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //对比,要完全一致
    public boolean check(TreeNode t1, TreeNode t2) {
        //如果当前不是 or 左子树不是 or 右子树不是
        return !(t1.val != t2.val || (t1.left != null && check(t1.left, t2.left) == false) || (t1.right != null && check(t1.right, t2.right) == false));
    }

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        //如果当前是 或 左树是 或 右树是
        return check(t1, t2) || (t1.left != null && checkSubTree(t1.left, t2)) || t1.right != null && checkSubTree(t1.right, t2);
    }

    public static void main(String[] args) {

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        one.left = two;
        one.right = three;

        System.out.println(new Code18().checkSubTree(one, two));
    }

}
