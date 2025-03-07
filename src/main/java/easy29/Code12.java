package easy29;

/**
 * @Author ayl
 * @Date 2023-04-06
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 */
public class Code12 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        //数量
        int count = 0;
        //节点
        ListNode node = head;
        //如果有节点
        while (node != null) {
            //记录
            count++;
            //下一个
            node = node.next;
        }
        //重新来
        node = head;
        //初始化
        int[] result = new int[count];
        //指针
        int p = result.length - 1;
        //如果有节点
        while (node != null) {
            //记录结果
            result[p--] = node.val;
            //下一个
            node = node.next;
        }
        //返回
        return result;
    }

}
