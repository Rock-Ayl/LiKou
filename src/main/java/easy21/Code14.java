package easy21;

/**
 * @Author ayl
 * @Date 2022-07-26
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *  
 * <p>
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code14 {

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

    //最后一个节点
    ListNode last;

    public ListNode reverseList(ListNode head) {
        //判空
        if (head == null) {
            //过
            return null;
        }
        //判空
        if (head.next == null) {
            //记录
            last = head;
            //返回本身
            return head;
        }
        //下一个节点
        ListNode nextNode = head.next;
        //置空
        head.next = null;
        //计算下一个节点
        ListNode next = reverseList(nextNode);
        //连接
        last.next = head;
        last = head;
        //返回
        return next;
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
        ListNode result = new Code14().reverseList(one);
        System.out.println();
    }

}
