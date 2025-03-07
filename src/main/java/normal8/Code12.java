package normal8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Author ayl
 * @Date 2021-12-23
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * <p>
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 */
public class Code12 {

    public class ListNode {
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

    public ListNode sortList(ListNode head) {
        //判空
        if (head == null) {
            //返回
            return null;
        }
        //如果只有一个
        if (head.next == null) {
            //返回
            return head;
        }
        //初始化
        List<Integer> list = new ArrayList<>();
        //循环
        while (head != null) {
            //组装
            list.add(head.val);
            //下一个
            head = head.next;
        }
        //排序
        Collections.sort(list);
        //初始化开始
        ListNode first = new ListNode(list.get(0));
        ListNode next = new ListNode(list.get(1));
        //记录二者关系
        first.next = next;
        //循环
        for (int i = 2; i < list.size(); i++) {
            //关系
            next.next = new ListNode(list.get(i));
            //下一个
            next = next.next;
        }
        //返回
        return first;
    }

}
