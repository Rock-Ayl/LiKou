package easy29;

/**
 * @Author ayl
 * @Date 2023-04-06
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 */
public class Code13 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        //数量
        int count = 0;
        //节点
        ListNode node = head;
        //如果有节点
        while (node != null) {
            //记录
            count++;
            //下一个
            node = node.next;
        }
        //重新来
        node = head;
        //指针
        int p = 0;
        //目标节点
        int target = count - k + 1;
        //如果有节点
        while (node != null) {
            //如果是目标节点
            if (++p == target) {
                //返回
                return node;
            }
            //下一个
            node = node.next;
        }
        //默认
        return null;
    }

}
