package normal20;

/**
 * @Author ayl
 * @Date 2023-05-04
 * 剑指 Offer II 021. 删除链表的倒数第 n 个结点
 * 给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * <p>
 * 进阶：能尝试使用一趟扫描实现吗？
 */
public class Code7 {

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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //默认节点
        ListNode first = new ListNode(-1);
        //连接
        first.next = head;
        //数量
        int count = 0;
        //节点
        ListNode node = first;
        //循环
        while (node != null) {
            //下一个
            node = node.next;
            //记录
            count++;
        }
        //目标节点
        int target = count - n + 1;
        //重新来
        node = first;
        //循环
        while (node != null) {
            //记录
            if (--target == 1) {
                //删除
                node.next = node.next.next;
                break;
            }
            //下一个
            node = node.next;
        }
        //连接
        return first.next;
    }

    public static void main(String[] args) {


        ListNode one = new ListNode(1);

        ListNode result = new Code7().removeNthFromEnd(one, 1);
        System.out.println();

    }

}
