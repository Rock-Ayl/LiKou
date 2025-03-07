package normal25;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2023-11-02
 * 142. 环形链表 II
 * 中等
 * 2.4K
 * 相关企业
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 不允许修改 链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围在范围 [0, 104] 内
 * -105 <= Node.val <= 105
 * pos 的值为 -1 或者链表中的一个有效索引
 * <p>
 * <p>
 * 进阶：你是否可以使用 O(1) 空间解决此题？
 */
public class Code16 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        //缓存
        Set<ListNode> set = new HashSet<>();
        //判空
        while (head != null) {
            //如果之前走过,说明是环
            if (set.contains(head)) {
                //返回结果
                return head;
            }
            //记录
            set.add(head);
            //下一个
            head = head.next;
        }
        //默认
        return null;
    }

    //快慢指针
    public ListNode star(ListNode head) {
        //判空
        if (head == null) {
            //过
            return null;
        }
        //快慢指针
        ListNode slow = head;
        ListNode fast = head;
        //如果快指针不为空
        while (fast != null) {
            //二者继续走
            slow = slow.next;
            fast = fast.next.next;
            //如果找到对方了
            if (fast == slow) {
                //跳出
                break;
            }
        }
        //第三个节点
        ListNode ptr = head;
        //如果不同
        while (ptr != slow) {
            //二者走
            ptr = ptr.next;
            slow = slow.next;
        }
        //返回
        return ptr;
    }

    public static void main(String[] args) {

        ListNode node0 = new ListNode(1);
        ListNode node00 = new ListNode(2);
        ListNode node000 = new ListNode(3);
        ListNode node0000 = new ListNode(4);
        ListNode node1 = new ListNode(5);

        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(8);
        ListNode node5 = new ListNode(9);

        node0.next = node00;
        node00.next = node000;
        node000.next = node0000;
        node0000.next = node1;

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;


        ListNode star = new Code16().star(node0);
        System.out.println();
    }

}
