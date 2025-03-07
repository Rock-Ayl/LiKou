package easy15;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-11-21
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 * <p>
 * <p>
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
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

    public boolean isPalindrome(ListNode head) {
        //缓存
        List<Integer> list = new ArrayList<>();
        //循环
        while (head != null) {
            //记录
            list.add(head.val);
            //下一个
            head = head.next;
        }
        //左右
        int p1 = 0, p2 = list.size() - 1;
        //循环
        while (p1 <= p2) {
            //如果不同
            if (list.get(p1++) != list.get(p2--)) {
                //不是
                return false;
            }
        }
        //是s
        return true;
    }

}
