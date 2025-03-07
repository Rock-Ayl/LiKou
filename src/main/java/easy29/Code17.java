package easy29;

/**
 * @Author ayl
 * @Date 2023-04-10
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 1000
 * <p>
 * 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class Code17 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //判空
        if (l1 == null) {
            //用l2
            return l2;
        }
        //判空
        if (l2 == null) {
            //用l1
            return l1;
        }
        //如果左边大
        if (l1.val > l2.val) {
            //递归
            ListNode node = mergeTwoLists(l1, l2.next);
            //连接
            l2.next = node;
            //返回
            return l2;
        } else {
            //递归
            ListNode node = mergeTwoLists(l1.next, l2);
            //连接
            l1.next = node;
            //返回
            return l1;
        }
    }

}
