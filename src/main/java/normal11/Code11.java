package normal11;

/**
 * @Author ayl
 * @Date 2022-02-08
 * 623. 在二叉树中增加一行
 * 给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行。
 * <p>
 * 注意，根节点 root 位于深度 1 。
 * <p>
 * 加法规则如下:
 * <p>
 * 给定整数 depth，对于深度为 depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
 * cur 原来的左子树应该是新的左子树根的左子树。
 * cur 原来的右子树应该是新的右子树根的右子树。
 * 如果 depth == 1 意味着 depth - 1 根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: root = [4,2,6,3,1,5], val = 1, depth = 2
 * 输出: [4,1,1,2,null,null,6,3,1,5]
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: root = [4,2,null,3,1], val = 1, depth = 3
 * 输出:  [4,2,null,1,1,3,null,null,1]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 节点数在 [1, 104] 范围内
 * 树的深度在 [1, 104]范围内
 * -100 <= Node.val <= 100
 * -105 <= val <= 105
 * 1 <= depth <= the depth of tree + 1
 */
public class Code11 {

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

    public void add(TreeNode root, int val, int depth) {
        //如果还没有找到
        if (depth > 2) {
            //判空
            if (root == null) {
                //过
                return;
            }
            //下一级深度
            int nextDepth = depth - 1;
            //进入下一级
            add(root.left, val, nextDepth);
            add(root.right, val, nextDepth);
        } else {
            //判空
            if (root == null) {
                //过
                return;
            }
            //先记录左右
            TreeNode oldLeft = root.left;
            TreeNode oldRight = root.right;
            //初始化新一层
            root.left = new TreeNode(val);
            root.right = new TreeNode(val);
            //嫁接
            root.left.left = oldLeft;
            root.right.right = oldRight;
        }
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        //如果是首位,特殊对待
        if (depth < 2) {
            //初始化
            TreeNode first = new TreeNode(val);
            //固定左边
            first.left = root;
            //返回
            return first;
        }
        //增加
        add(root, val, depth);
        //返回
        return root;
    }

}
