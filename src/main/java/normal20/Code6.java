package normal20;

/**
 * @Author ayl
 * @Date 2023-05-03
 * 面试题 02.04. 分割链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你不需要 保留 每个分区中各节点的初始相对位置。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */
public class Code6 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        //初始化前置节点
        ListNode smallFirst = new ListNode(-1);
        ListNode bigFirst = new ListNode(-1);
        //记录
        ListNode small = smallFirst;
        ListNode big = bigFirst;
        //准备循环
        ListNode node = head;
        //循环
        while (node != null) {
            //先记录下一个节点
            ListNode nextNode = node.next;
            //置空
            node.next = null;
            //如果是小
            if (node.val < x) {
                //连接
                small.next = node;
                //下一个
                small = small.next;
            } else {
                //连接
                big.next = node;
                //下一个
                big = big.next;
            }
            //下一个
            node = nextNode;
        }
        //连接
        small.next = bigFirst.next;
        //返回
        return smallFirst.next;
    }

    public static void main(String[] args) {

    }

}
