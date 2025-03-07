package difficult;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2022-04-22
 * 25. K 个一组翻转链表
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * <p>
 * <p>
 * 提示：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 * <p>
 * <p>
 * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 */
public class Code5 {

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

    public ListNode reverseKGroup(ListNode head, int k) {
        //判空
        if (head == null) {
            //返回
            return null;
        }
        //初始化列表
        List<ListNode> node = new ArrayList<>(k);
        //判空
        while (head != null && node.size() < k) {
            //组装
            node.add(head);
            //下一个
            head = head.next;
        }
        //如果不满足
        if (node.size() < k) {
            //直接原路返回
            return node.get(0);
        } else {
            //倒叙绑定
            for (int i = node.size() - 1; i > 0; i--) {
                //绑定
                node.get(i).next = node.get(i - 1);
            }
            //递归
            node.get(0).next = reverseKGroup(head, k);
            //返回最后一个
            return node.get(node.size() - 1);
        }
    }

}
