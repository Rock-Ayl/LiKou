package normal24;

/**
 * @Author ayl
 * @Date 2023-09-08
 * 2816. 翻倍以链表形式表示的数字
 * 提示
 * 中等
 * 12
 * 相关企业
 * 给你一个 非空 链表的头节点 head ，表示一个不含前导零的非负数整数。
 * <p>
 * 将链表 翻倍 后，返回头节点 head 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,8,9]
 * 输出：[3,7,8]
 * 解释：上图中给出的链表，表示数字 189 。返回的链表表示数字 189 * 2 = 378 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [9,9,9]
 * 输出：[1,9,9,8]
 * 解释：上图中给出的链表，表示数字 999 。返回的链表表示数字 999 * 2 = 1998 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [1, 104] 内
 * 0 <= Node.val <= 9
 * 生成的输入满足：链表表示一个不含前导零的数字，除了数字 0 本身。
 */
public class Code2 {

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

    //递归实现
    public int next(ListNode node) {
        //判空
        if (node == null) {
            //过
            return 0;
        }
        //先递归子节点,获取进位
        int other = next(node.next);
        //本次节点真实值
        int num = node.val * 2 + other;
        //删除进位然后记录本节点值
        node.val = num % 10;
        //返回进位
        return num / 10;
    }

    public ListNode doubleIt(ListNode head) {
        //递归,获取结果
        int other = next(head);
        //如果没有进位
        if (other == 0) {
            //返回结果
            return head;
        }
        //初始化首节点
        ListNode first = new ListNode();
        first.val = other;
        first.next = head;
        //返回
        return first;
    }

}
