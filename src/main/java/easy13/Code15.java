package easy13;

/**
 * @Author ayl
 * @Date 2021-10-28
 * 1290. 二进制链表转整数
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * <p>
 * 请你返回该链表所表示数字的 十进制值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * 示例 2：
 * <p>
 * 输入：head = [0]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 * 示例 5：
 * <p>
 * 输入：head = [0,0]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表不为空。
 * 链表的结点总数不超过 30。
 * 每个结点的值不是 0 就是 1。
 */
public class Code15 {

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

    //默认1
    int num = 1;

    public void next(ListNode head) {
        //判空
        if (head == null) {
            //过
            return;
        }
        //进位叠加
        num = num * 2 + head.val;
        //下一位
        next(head.next);
    }

    public int getDecimalValue(ListNode head) {
        //判0
        while (head.val == 0) {
            //下一位
            head = head.next;
            //判空
            if (head == null) {
                //过
                return 0;
            }
        }
        //下一位
        next(head.next);
        //返回
        return num;
    }


}
