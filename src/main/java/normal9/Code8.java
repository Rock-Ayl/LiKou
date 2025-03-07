package normal9;

/**
 * @Author ayl
 * @Date 2022-01-03
 * 2095. 删除链表的中间节点
 * 给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。
 * <p>
 * 长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。
 * <p>
 * 对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,3,4,7,1,2,6]
 * 输出：[1,3,4,1,2,6]
 * 解释：
 * 上图表示给出的链表。节点的下标分别标注在每个节点的下方。
 * 由于 n = 7 ，值为 7 的节点 3 是中间节点，用红色标注。
 * 返回结果为移除节点后的新链表。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[1,2,4]
 * 解释：
 * 上图表示给出的链表。
 * 对于 n = 4 ，值为 3 的节点 2 是中间节点，用红色标注。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [2,1]
 * 输出：[2]
 * 解释：
 * 上图表示给出的链表。
 * 对于 n = 2 ，值为 1 的节点 1 是中间节点，用红色标注。
 * 值为 2 的节点 0 是移除节点 1 后剩下的唯一一个节点。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [1, 105] 内
 * 1 <= Node.val <= 105
 */
public class Code8 {

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

    public ListNode deleteMiddle(ListNode head) {
        //如果没有 或 只有一个
        if (head == null || head.next == null) {
            //默认
            return null;
        }
        //第一轮
        ListNode link = head;
        //个数,默认1
        int size = 1;
        //循环
        while (link.next != null) {
            //+1
            size++;
            //下一个
            link = link.next;
        }
        //目标
        int point;
        //如果是偶数
        if (size % 2 == 0) {
            //计算
            point = size / 2 + 1;
        } else {
            point = (size + 1) / 2;
        }
        //第二轮
        ListNode link2 = head;
        //计算着要删除节点父亲的位置
        while (point > 2) {
            //+1
            point--;
            //下一个
            link2 = link2.next;
        }
        //要删除的节点
        ListNode delete = link2.next;
        //替换掉链关系(相当于删除)
        link2.next = delete.next;
        //返回
        return head;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        one.next = two;
        two.next = three;
        three.next = four;

        new Code8().deleteMiddle(one);
    }


}
