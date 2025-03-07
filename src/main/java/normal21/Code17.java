package normal21;

/**
 * @Author ayl
 * @Date 2023-07-11
 * 面试题 02.05. 链表求和
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * <p>
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * <p>
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
 * <p>
 * 示例：
 * <p>
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 */
public class Code17 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int other) {
        //判空
        if (l1 == null && l2 == null && other == 0) {
            //返回
            return null;
        }
        //计算和
        int sum = other;
        //尝试获取下一个子节点
        ListNode l1Next = null;
        ListNode l2Next = null;
        //判空
        if (l1 != null) {
            //叠加
            sum += l1.val;
            //下一个子节点
            l1Next = l1.next;
        }
        //判空
        if (l2 != null) {
            //叠加
            sum += l2.val;
            //下一个子节点
            l2Next = l2.next;
        }
        //计算下一个进位
        int nextOther = sum / 10;
        //和删除进位
        sum = sum % 10;
        //初始化新节点
        ListNode newNode = new ListNode(sum);
        //递归
        newNode.next = addTwoNumbers(l1Next, l2Next, nextOther);
        //返回解雇
        return newNode;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //实现
        return addTwoNumbers(l1, l2, 0);
    }

    public static void main(String[] args) {

        ListNode one = new ListNode(5);
        ListNode two = new ListNode(5);

        ListNode listNode = new Code17().addTwoNumbers(one, two);
        System.out.println();
    }

}
