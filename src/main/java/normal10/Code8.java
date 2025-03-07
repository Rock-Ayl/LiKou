package normal10;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-01-20
 * 61. 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 */
public class Code8 {

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

    public ListNode rotateRight(ListNode head, int k) {
        //判空
        if (k == 0 || head == null || head.next == null) {
            //直接返回
            return head;
        }
        //缓存
        Map<Integer, ListNode> map = new HashMap<>();
        //指针
        int p = 0;
        //循环
        while (head != null) {
            //记录
            map.put(++p, head);
            //下一个
            head = head.next;
        }
        //如果一轮以上
        if (k > p) {
            //计算到一轮及以下
            k = k % p;
        }
        //如果相等或正好一轮
        if (k == p || k == 0) {
            //返回
            return map.get(1);
        }
        //找到结尾节点
        ListNode end = map.get(p - k);
        //找到起始节点
        ListNode first = end.next;
        //结尾置空
        end.next = null;
        //首位相连
        map.get(p).next = map.get(1);
        //返回
        return first;
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
        new Code8().rotateRight(one, 10);
    }

}
