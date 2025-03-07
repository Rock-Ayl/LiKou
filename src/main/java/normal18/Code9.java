package normal18;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2023-01-03
 * 2487. 从链表中移除节点
 * 给你一个链表的头节点 head 。
 * <p>
 * 对于列表中的每个节点 node ，如果其右侧存在一个具有 严格更大 值的节点，则移除 node 。
 * <p>
 * 返回修改后链表的头节点 head 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [5,2,13,3,8]
 * 输出：[13,8]
 * 解释：需要移除的节点是 5 ，2 和 3 。
 * - 节点 13 在节点 5 右侧。
 * - 节点 13 在节点 2 右侧。
 * - 节点 8 在节点 3 右侧。
 * 示例 2：
 * <p>
 * 输入：head = [1,1,1,1]
 * 输出：[1,1,1,1]
 * 解释：每个节点的值都是 1 ，所以没有需要移除的节点。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定列表中的节点数目在范围 [1, 105] 内
 * 1 <= Node.val <= 105
 */
public class Code9 {

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

        @Override
        public String toString() {
            return val + "";
        }

    }

    public ListNode removeNodes(ListNode head) {
        //初始化栈
        Stack<ListNode> stack = new Stack<>();
        //如果有内容
        while (head != null) {
            //记录
            stack.push(head);
            //替换
            head = head.next;
        }
        //获取节点
        ListNode node = stack.pop();
        //如果还有
        while (stack.isEmpty() == false) {
            //获取下一个节点并删除
            ListNode nextNode = stack.pop();
            //如果现在的比之前的更大
            if (node.val <= nextNode.val) {
                //连接
                nextNode.next = node;
                //替换
                node = nextNode;
            }
        }
        //返回
        return node;
    }

    public static void main(String[] args) {

        ListNode one = new ListNode(5);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(13);
        ListNode four = new ListNode(3);
        ListNode five = new ListNode(8);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        new Code9().removeNodes(one);
    }

}
