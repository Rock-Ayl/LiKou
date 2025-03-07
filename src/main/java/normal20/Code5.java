package normal20;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-05-02
 * 面试题 04.03. 特定深度节点链表
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[1,2,3,4,5,null,7,8]
 * <p>
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * /
 * 8
 * <p>
 * 输出：[[1],[2,3],[4,5,7],[8]]
 * 通过次数34,628提交次数42,887
 */
public class Code5 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //深度
    private int deep = 0;
    //结果
    private List<ListNode> listNodeList = new ArrayList<>();

    private void next(TreeNode node, int deep) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //刷新最大深度
        this.deep = Math.max(this.deep, deep);

        //如果没有
        if (this.listNodeList.size() == deep) {
            //初始化
            this.listNodeList.add(new ListNode(node.val));
        } else {
            //初始化
            ListNode nextNode = new ListNode(node.val);
            //关联
            nextNode.next = this.listNodeList.get(deep);
            //下一个
            this.listNodeList.set(deep, nextNode);
        }

        //继续走,先右后左
        next(node.right, deep + 1);
        next(node.left, deep + 1);
    }

    public ListNode[] listOfDepth(TreeNode tree) {
        //遍历整个树,找深度
        next(tree, 0);
        //返回
        return listNodeList.toArray(new ListNode[]{});
    }

}
