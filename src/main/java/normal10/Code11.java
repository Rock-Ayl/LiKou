package normal10;

/**
 * @Author ayl
 * @Date 2022-01-23
 * 82. 删除排序链表中的重复元素 II
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 返回同样按升序排列的结果链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 */
public class Code11 {

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

    public ListNode deleteDuplicates(ListNode head) {
        //判空
        if (head == null || head.next == null) {
            //返回
            return head;
        }
        //如果不相同
        if (head.val != head.next.val) {
            //递归
            head.next = deleteDuplicates(head.next);
            //返回
            return head;
        } else {
            //循环
            while (head.val == head.next.val) {
                ///下一级
                head = head.next;
                //判空
                if (head.next == null) {
                    //过
                    break;
                }
            }
            //返回
            return deleteDuplicates(head.next);
        }
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(1);
        one.next = two;
        ListNode result = new Code11().deleteDuplicates(one);
        System.out.println(123);
    }

}
