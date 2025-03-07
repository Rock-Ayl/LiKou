package normal26;

/**
 * @Author ayl
 * @Date 2023-12-12
 * 445. 两数相加 II
 * 中等
 * 695
 * 相关企业
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * <p>
 * <p>
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * 示例2：
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 * 示例3：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表的长度范围为 [1, 100]
 * 0 <= node.val <= 9
 * 输入数据保证链表代表的数字无前导 0
 * <p>
 * <p>
 * 进阶：如果输入链表不能翻转该如何解决？
 */
public class Code22 {

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

    //翻转节点
    private ListNode reverse(ListNode node) {
        //判空
        if (node == null || node.next == null) {
            //直接返回
            return node;
        }
        //第一个节点
        ListNode first = node;
        //下一个
        node = node.next;
        //置空
        first.next = null;
        //循环
        while (node != null) {
            //下一个节点
            ListNode next = node.next;
            //替换为新的
            node.next = first;
            //替换首节点
            first = node;
            //下一个
            node = next;
        }
        //返回主节点
        return first;
    }

    //递归叠加
    private ListNode add(ListNode left, ListNode right, int other) {
        //判空
        if (left == null && right == null) {
            //如果还有
            if (other > 0) {
                //返回节点
                return new ListNode(other);
            } else {
                //无o
                return null;
            }
        }
        //左右节点子级
        ListNode leftNext = null;
        ListNode rightNext = null;
        //初始化结果节点
        ListNode newNode = new ListNode(other);
        //如果左边有
        if (left != null) {
            //叠加
            newNode.val += left.val;
            //记录子节点
            leftNext = left.next;
        }
        //如果右边有
        if (right != null) {
            //叠加
            newNode.val += right.val;
            //记录子节点
            rightNext = right.next;
        }
        //进位,默认0
        int nextOther = 0;
        //如果有进位
        if (newNode.val > 9) {
            //计算进位
            nextOther++;
            newNode.val -= 10;
        }
        //计算下一级,并关联
        newNode.next = add(leftNext, rightNext, nextOther);
        //返回
        return newNode;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //1.翻转两个节点,2.递归做加法,3.再翻转回来
        return reverse(add(reverse(l1), reverse(l2), 0));
    }

}
