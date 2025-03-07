package easy14;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-11-05
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * <p>
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 */
public class Code6 {

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

    List<ListNode> list = new ArrayList<>();

    public ListNode removeElements(ListNode head, int val) {
        //判空
        if (head == null) {
            //过
            return null;
        }
        //循环
        while (head != null) {
            //如果是需要的
            if (head.val != val) {
                //记录
                list.add(head);
            }
            //下一个
            ListNode next = head.next;
            //清空
            head.next = null;
            //重置为下一个
            head = next;
        }
        //如果是空
        if (list.isEmpty()) {
            //过z
            return null;
        }
        //循环
        for (int i = 0; i < list.size() - 1; i++) {
            //链
            list.get(i).next = list.get(i + 1);
        }
        //返回头
        return list.get(0);
    }


}
