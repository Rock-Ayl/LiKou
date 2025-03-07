package normal18;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author ayl
 * @Date 2023-01-02
 * 1019. 链表中的下一个更大节点
 * 给定一个长度为 n 的链表 head
 * <p>
 * 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
 * <p>
 * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，设置 answer[i] = 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [2,1,5]
 * 输出：[5,5,0]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数为 n
 * 1 <= n <= 104
 * 1 <= Node.val <= 109
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

    public int[] nextLargerNodes(ListNode head) {
        //栈
        List<Integer> list = new ArrayList<>();
        //循环
        while (head != null) {
            //组装
            list.add(head.val);
            //下一个
            head = head.next;
        }
        //初始化结果
        int[] result = new int[list.size()];
        //缓存
        Stack<Integer> stack = new Stack<>();
        //循环
        for (int i = list.size() - 1; i >= 0; i--) {
            //当前数字
            int num = list.get(i);
            //如果当前数字更大
            while (stack.isEmpty() == false && num >= stack.peek()) {
                //删除最后
                stack.pop();
            }
            //如果有内容
            if (stack.isEmpty() == false) {
                //使用
                result[i] = stack.peek();
            }
            //push
            stack.push(num);
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(1);
        ListNode three = new ListNode(5);

        one.next = two;
        two.next = three;

        new Code8().nextLargerNodes(one);
    }


}
