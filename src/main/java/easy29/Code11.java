package easy29;

/**
 * @Author ayl
 * @Date 2023-04-05
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 * <p>
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * <p>
 * 说明：
 * <p>
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 */
public class Code11 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        //判空
        if (head == null) {
            //过
            return null;
        }
        //如果当前是
        if (head.val == val) {
            //过
            return head.next;
        }
        //判空
        if (head.next == null) {
            //过
            return head;
        }
        //如果下个节点是目标节点
        if (head.next.val == val) {
            //删除下一个节点
            head.next = head.next.next;
        }
        //递归
        deleteNode(head.next, val);
        //返回当前节点
        return head;
    }

}
