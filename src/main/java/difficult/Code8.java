package difficult;

/**
 * @Author ayl
 * @Date 2022-04-25
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
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
 */
public class Code8 {

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

    //合并两个
    public ListNode merge(ListNode left, ListNode right) {
        //分别
        if (left == null) {
            //返回
            return right;
        } else if (right == null) {
            //返回
            return left;
        }
        //比较,决定当前最小节点
        if (left.val > right.val) {
            //继续
            right.next = merge(left, right.next);
            //返回最小
            return right;
        } else {
            //继续
            left.next = merge(left.next, right);
            //返回最小
            return left;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        //判空
        if (lists.length < 1) {
            //返回
            return null;
        }
        //第一个节点
        ListNode node = lists[0];
        //循环
        for (int i = 1; i < lists.length; i++) {
            //下一个节点
            ListNode nextNode = lists[i];
            //合并二者
            node = merge(node, nextNode);
        }
        //返回
        return node;
    }

}
