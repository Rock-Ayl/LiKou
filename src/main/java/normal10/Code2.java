package normal10;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2022-01-14
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * <p>
 * <p>
 * 进阶： 你可以使用一趟扫描完成反转吗？
 */
public class Code2 {

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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        //开始节点(不一定有)
        ListNode first;
        //开始节点的结束节点(不一定有,只有开始有多个节点时才存在)
        ListNode firstEnd = null;
        //中间
        ListNode mid;
        //指针
        int p;
        //如果从1开始
        if (left == 1) {
            p = 1;
            //没有开始
            first = null;
            //中间就是开始
            mid = head;
        } else {
            //开始为fist
            first = head;
            //初始化中间
            mid = head.next;
            //指针
            p = 2;
            //循环
            while (p < left) {
                //下一级
                p++;
                //如果是开始的结束节点(first有多个节点)
                if (p == left) {
                    //记录最后一位节点
                    firstEnd = mid;
                }
                mid = mid.next;
            }
        }
        //如果到头了
        if (p == right) {
            //判空
            if (first != null) {
                //直接返回首位
                return first;
            } else {
                //中间就是首位
                return mid;
            }
        }
        //开始记录中间
        List<ListNode> list = new ArrayList<>(right - left + 1);
        //循环
        while (p < right) {
            //记录
            list.add(mid);
            //下一个
            mid = mid.next;
            p++;
        }
        //记录后面
        ListNode end = mid.next;
        //如果没有首节点
        if (first == null) {
            //中间就是首节点
            first = mid;
        } else {
            //如果首位有多个节点
            if (firstEnd != null) {
                //连接
                firstEnd.next = mid;
            } else {
                first.next = mid;
            }
        }
        //循环
        for (int i = list.size() - 1; i >= 0; i--) {
            //翻转
            mid.next = list.get(i);
            //下一个
            mid = mid.next;
        }
        //连接尾部
        mid.next = end;
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
        System.out.println(new Code2().reverseBetween(one, 3, 4));
    }

}
