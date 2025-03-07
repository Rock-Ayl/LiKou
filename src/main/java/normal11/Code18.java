package normal11;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-02-15
 */
public class Code18 {

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

    public void reorderList(ListNode head) {
        //首节点
        ListNode node = head;
        //缓存
        Map<Integer, ListNode> map = new HashMap<>();
        //指针
        int p = 0;
        //如果存在
        while (head != null) {
            //记录
            map.put(p++, head);
            //下一个
            head = head.next;
        }
        //左右指针
        int left = 1, right = p - 1;
        //正负
        boolean plus = false;
        //循环
        while (left <= right) {
            //下一个节点
            ListNode next;
            //如果是正
            if (plus) {
                //下一个节点
                next = map.get(left++);
            } else {
                //下一个节点
                next = map.get(right--);
            }
            //连接
            node.next = next;
            //下一个
            node = node.next;
            //翻转
            plus = !plus;
        }
        //最后置空
        node.next = null;
    }
}
