package normal8;

/**
 * @Author ayl
 * @Date 2021-12-24
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class Code13 {

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

    public ListNode next(ListNode l1, ListNode l2, int other) {
        //如果都为空
        if (l1 == null && l2 == null) {
            //如果有进位
            if (other > 0) {
                //如果是额外进位
                if (other > 9) {
                    //初始化
                    ListNode node = new ListNode(other % 10);
                    //下一级
                    node.next = next(null, null, other / 10);
                    //返回
                    return node;
                } else {
                    //特殊对待
                    return new ListNode(other);
                }
            } else {
                //到此为止
                return null;
            }
        }
        //左右数字
        int left = l1 == null ? 0 : l1.val;
        int right = l2 == null ? 0 : l2.val;
        //计算数
        int num = left + right + other;
        //初始化进位
        int nextOther = 0;
        //如果越界
        if (num > 9) {
            //进位
            nextOther += num / 10;
            //进位后
            num = num % 10;
        }
        //初始化
        ListNode node = new ListNode(num);
        //判空
        if (l1 == null) {
            //记录
            node.next = next(null, l2.next, nextOther);
        } else if (l2 == null) {
            //记录
            node.next = next(l1.next, null, nextOther);
        } else {
            //记录
            node.next = next(l1.next, l2.next, nextOther);
        }
        //返回
        return node;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //返回
        return next(l1, l2, 0);
    }


}
