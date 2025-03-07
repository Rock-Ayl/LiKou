package easy14;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-11-02
 * 83. 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * <p>
 * 返回同样按升序排列的结果链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 */
public class Code3 {

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

    //集合
    List<ListNode> list = new ArrayList<>();

    public ListNode deleteDuplicates(ListNode head) {
        //判空
        if (head == null) {
            //过
            return null;
        }
        //记录当前
        list.add(head);
        //下一级
        ListNode next = head.next;
        //如果后面的和前面的
        while (next != null && next.val == head.val) {
            //下一级
            next = next.next;
        }
        //如果到头了,结算
        if (next == null) {
            //最后一个清空
            list.get(list.size() - 1).next = null;
            //循环
            for (int i = list.size() - 1; i > 0; i--) {
                //计算
                list.get(i - 1).next = list.get(i);
            }
            //返回第一个
            return list.get(0);
        }
        //返回
        return deleteDuplicates(next);
    }

    public static void main(String[] args) {
        ListNode one = new ListNode();
        one.val = 1;
        ListNode two = new ListNode();
        two.val = 1;
        ListNode three = new ListNode();
        three.val = 2;
        ListNode four = new ListNode();
        four.val = 3;
        ListNode five = new ListNode();
        five.val = 3;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        new Code3().deleteDuplicates(one);
    }

}
