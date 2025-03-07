package difficult2;

/**
 * @Author ayl
 * @Date 2023-10-27
 * LCR 078. 合并 K 个升序链表
 * 困难
 * 95
 * 相关企业
 * 给定一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 * <p>
 * <p>
 * 注意：本题与主站 23 题相同： https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class Code5 {

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

    //合并
    public ListNode merge(ListNode node1, ListNode node2) {
        //初始化首节点
        ListNode first = new ListNode(-1);
        //准备
        ListNode node = first;
        //循环
        while (node1 != null && node2 != null) {
            //如果左边更大
            if (node1.val > node2.val) {
                //关联
                node.next = node2;
                //下一个节点
                ListNode nextNode = node2.next;
                //删除关联
                node2.next = null;
                //下一个节点
                node2 = nextNode;
            } else {
                //关联
                node.next = node1;
                //下一个节点
                ListNode nextNode = node1.next;
                //删除关联
                node1.next = null;
                //下一个节点
                node1 = nextNode;
            }
            //下一个
            node = node.next;
        }
        //循环单个
        while (node1 != null) {
            //关联
            node.next = node1;
            //下一个节点
            ListNode nextNode = node1.next;
            //删除关联
            node1.next = null;
            //下一个节点
            node1 = nextNode;
            //下一个
            node = node.next;
        }
        //循环单个
        while (node2 != null) {
            //关联
            node.next = node2;
            //下一个节点
            ListNode nextNode = node2.next;
            //删除关联
            node2.next = null;
            //下一个节点
            node2 = nextNode;
            //下一个
            node = node.next;
        }
        //返回
        return first.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        //判空
        if (lists == null || lists.length == 0) {
            //过
            return null;
        }
        //第一个节点
        ListNode node = lists[0];
        //循环
        for (int i = 1; i < lists.length; i++) {
            //合并
            node = merge(node, lists[i]);
        }
        //返回
        return node;
    }

}
