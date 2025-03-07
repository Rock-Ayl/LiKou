package normal12;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-03-07
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
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
 * 进阶：你能尝试使用一趟扫描实现吗？
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //缓存
        Map<Integer, ListNode> map = new HashMap<>();
        //初始化第0个节点
        ListNode zero = new ListNode(0);
        //连接
        zero.next = head;
        //指针
        int p = 0;
        //循环
        while (zero != null) {
            //记录
            map.put(p++, zero);
            //下一个
            zero = zero.next;
        }
        //要删除的节点的父亲节点
        ListNode node = map.get(map.size() - n - 1);
        //删除其孩子
        node.next = node.next.next;
        //返回结果
        return map.get(0).next;
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
        ListNode node = new Code16().removeNthFromEnd(one, 2);
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
    }

}
