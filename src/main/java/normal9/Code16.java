package normal9;

/**
 * @Author ayl
 * @Date 2022-01-11
 * 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * <p>
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
public class Code16 {

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

    public ListNode oddEvenList(ListNode head) {
        //判空
        if (head == null || head.next == null) {
            //返回本身
            return head;
        }
        //记录单双的首节点
        ListNode oneFirst = head;
        ListNode twoFirst = head.next;
        //初始化但双
        ListNode one = oneFirst;
        ListNode two = twoFirst;
        //从第三个开始
        head = two.next;
        //判断本次是单还是双
        boolean single = true;
        //不断循环
        while (head != null) {
            //先记录下一个
            ListNode next = head.next;
            //如果是单
            if (single) {
                //更新
                one.next = head;
                one = one.next;
            } else {
                //更新
                two.next = head;
                two = two.next;
            }
            //单双翻转
            single = !single;
            //下一个
            head = next;
        }
        //置空最后一个
        two.next = null;
        //连接单双
        one.next = twoFirst;
        //返回第一个节点
        return oneFirst;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        new Code16().oddEvenList(one);
    }
}
