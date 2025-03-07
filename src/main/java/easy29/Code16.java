package easy29;

/**
 * @Author ayl
 * @Date 2023-04-09
 */
public class Code16 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        //当前节点
        ListNode node = null;
        //循环
        while (head != null) {
            //记录
            ListNode nextHead = head.next;
            //连接
            head.next = node;
            //下一个
            node = head;
            head = nextHead;
        }
        //返回
        return node;
    }

}
