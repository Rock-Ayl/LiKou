package normal29;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2024-03-13
 * LCR 022. 环形链表 II
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个链表，返回链表开始入环的第一个节点。 从链表的头节点开始沿着 next 指针进入环的第一个节点为环的入口节点。如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围在范围 [0, 104] 内
 * -105 <= Node.val <= 105
 * pos 的值为 -1 或者链表中的一个有效索引
 * <p>
 * <p>
 * 进阶：是否可以使用 O(1) 空间解决此题？
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 142 题相同： https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class Code20 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        //判空
        if (head == null) {
            //过
            return null;
        }
        //缓存
        Set<ListNode> nodeSet = new HashSet<>();
        //当前节点
        ListNode node = head;
        //如果有节点
        while (node != null) {
            //如果存在
            if (nodeSet.contains(node)) {
                //返回目标结果
                return node;
            }
            //记录
            nodeSet.add(node);
            //下一级
            node = node.next;
        }
        //默认
        return null;
    }

}
