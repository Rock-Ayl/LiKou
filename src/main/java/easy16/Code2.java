package easy16;

/**
 * @Author ayl
 * @Date 2021-12-04
 * 1022. 从根到叶的二进制数之和
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * <p>
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * <p>
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * 示例 2：
 * <p>
 * 输入：root = [0]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：root = [1,1]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的结点数介于 1 和 1000 之间。
 * Node.val 为 0 或 1 。
 */
public class Code2 {

    public class TreeNode {
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

    //和
    int sum = 0;

    public void next(TreeNode root, StringBuilder str) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //组装
        str.append(root.val);
        //如果都为空
        if (root.left == null && root.right == null) {
            //转为10进制并叠加
            sum += Integer.valueOf(str.toString(), 2);
            //删除最后一个
            str.deleteCharAt(str.length() - 1);
            //过
            return;
        } else {
            //下一级
            next(root.left, str);
            next(root.right, str);
            //删除最后一个
            str.deleteCharAt(str.length() - 1);
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        //计算
        next(root, new StringBuilder());
        //返回
        return sum;
    }

}
