package normal9;

/**
 * @Author ayl
 * @Date 2022-01-08
 * 1367. 二叉树中的列表
 * 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
 * <p>
 * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
 * <p>
 * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * 输出：true
 * 解释：树中蓝色的节点构成了与链表对应的子路径。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * 输出：false
 * 解释：二叉树中不存在一一对应链表的路径。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 二叉树和链表中的每个节点的值都满足 1 <= node.val <= 100 。
 * 链表包含的节点数目在 1 到 100 之间。
 * 二叉树包含的节点数目在 1 到 2500 之间。
 */
public class Code13 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

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

    ListNode firstNode;

    //只计算连击
    public boolean comb(ListNode head, TreeNode root) {
        //如果节点不存在了
        if (head == null) {
            //是
            return true;
        }
        //如果树不存在
        if (root == null) {
            //不是
            return false;
        }
        //如果当前可能是
        if (head.val == root.val) {
            //如果以后有一个是
            if (comb(head.next, root.left) == true || comb(head.next, root.right) == true) {
                //是
                return true;
            }
        }
        //默认不是
        return false;
    }

    //找到首个+下一个节点
    public boolean next(ListNode head, TreeNode root) {
        //如果节点不存在了
        if (head == null) {
            //是
            return true;
        }
        //如果树不存在
        if (root == null) {
            //不是
            return false;
        }
        //如果当前可能是
        if (head.val == root.val) {
            //如果以后有一个是
            if (comb(head.next, root.left) == true || comb(head.next, root.right) == true) {
                //是
                return true;
            }
        }
        //下一个节点重新来
        if (next(firstNode, root.left) == true || next(firstNode, root.right) == true) {
            //是
            return true;
        }
        //默认不是
        return false;
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        //记录首节点
        firstNode = head;
        //计算并返回结果
        return next(head, root);
    }

}
