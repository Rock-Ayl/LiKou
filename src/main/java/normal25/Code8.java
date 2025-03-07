package normal25;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2023-10-19
 * 面试题 02.08. 环路检测
 * 提示
 * 中等
 * 124
 * 相关企业
 * 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。若环不存在，请返回 null。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你是否可以不用额外空间解决此题？
 */
public class Code8 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        //缓存
        Set<ListNode> set = new HashSet<>();
        //如果还有
        while (head != null) {
            //如果走过了
            if (set.contains(head)) {
                //返回结果
                return head;
            }
            //记录走过
            set.add(head);
            //下一个
            head = head.next;
        }
        //默认
        return null;
    }

}
