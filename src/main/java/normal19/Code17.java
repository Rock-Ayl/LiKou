package normal19;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-03-26
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: head = [-10,-3,0,5,9]
 * 输出: [0,-3,9,-10,null,5]
 * 解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
 * 示例 2:
 * <p>
 * 输入: head = []
 * 输出: []
 * <p>
 * <p>
 * 提示:
 * <p>
 * head 中的节点数在[0, 2 * 104] 范围内
 * -105 <= Node.val <= 105
 */
public class Code17 {

    public static class ListNode {
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

    public TreeNode next(List<Integer> list, int left, int right) {
        //如果过大
        if (left > right) {
            //过
            return null;
        }
        //如果只有一个
        if (left == right) {
            //初始化节点并返回
            return new TreeNode(list.get(left));
        }
        //计算中间节点
        int mid = left + ((right - left + 1) / 2);
        //初始化中间节点
        TreeNode midNode = new TreeNode(list.get(mid));
        //左子节点
        midNode.left = next(list, left, mid - 1);
        //右子节点
        midNode.right = next(list, mid + 1, right);
        //返回结果
        return midNode;
    }

    public TreeNode sortedListToBST(ListNode head) {
        //初始化结果
        List<Integer> list = new ArrayList<>();
        //记录节点
        ListNode node = head;
        //如果有
        while (node != null) {
            //记录本次值
            list.add(node.val);
            //下一个
            node = node.next;
        }
        //递归实现
        return next(list, 0, list.size() - 1);
    }

    public static void main(String[] args) {

        ListNode one = new ListNode(-10);
        ListNode two = new ListNode(-3);
        ListNode three = new ListNode(0);
        ListNode four = new ListNode(5);
        ListNode five = new ListNode(9);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        TreeNode node = new Code17().sortedListToBST(one);
        System.out.println();

    }

}
