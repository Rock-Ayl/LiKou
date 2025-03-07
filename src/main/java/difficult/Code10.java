package difficult;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-04-27
 * 1028. 从先序遍历还原二叉树
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。
 * <p>
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 * <p>
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 * <p>
 * 给出遍历输出 S，还原树并返回其根节点 root。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入："1-2--3---4-5--6---7"
 * 输出：[1,2,5,3,null,6,null,4,null,7]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入："1-401--349---90--88"
 * 输出：[1,401,null,349,88,90]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 原始树中的节点数介于 1 和 1000 之间。
 * 每个节点的值介于 1 和 10 ^ 9 之间。
 */
public class Code10 {

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

    //首节点
    public TreeNode first = null;
    //缓存,里面记录了节点的每个深度的先后顺序
    Map<Integer, TreeNode> map = new HashMap<>();

    public TreeNode recoverFromPreorder(String traversal) {
        //转化为char
        char[] arr = traversal.toCharArray();
        //当前数字
        int num = 0;
        //深度,默认0
        int deep = 0;
        //当前是否寻找数字 true=找数字,false=找深度
        boolean isNum = true;
        //循环1,寻找首节点
        for (int i = 0; i < arr.length; i++) {
            //当前
            char space = arr[i];
            //如果是找数字
            if (isNum) {
                //如果不是- 视为数字
                if (space != '-') {
                    //叠加
                    num = (space - '0') + num * 10;
                } else {
                    //初始化当前节点
                    TreeNode node = new TreeNode(num);
                    //绑定其父节点
                    link(node, deep);
                    //记录
                    map.put(deep, node);
                    //重置
                    deep = 1;
                    isNum = false;
                }
            } else {
                //如果是-
                if (space == '-') {
                    //叠加深度
                    deep++;
                } else {
                    //开始找数字了
                    isNum = true;
                    //重置数字
                    num = space - '0';
                }
            }
        }
        //初始化当前节点,并绑定其父节点
        link(new TreeNode(num), deep);
        //返回首节点
        return first;
    }

    //与上一级节点绑定
    private void link(TreeNode node, int deep) {
        //如果深度是0
        if (deep == 0) {
            //仅记录首节点
            first = node;
        } else {
            //上一个节点
            TreeNode last = map.get(deep - 1);
            //判空
            if (last.left == null) {
                //用左边
                last.left = node;
            } else {
                //用右边
                last.right = node;
            }
        }
    }

    public static void main(String[] args) {
        new Code10().recoverFromPreorder("1-401--349---90--88");
    }

}
