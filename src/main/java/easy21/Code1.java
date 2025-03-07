package easy21;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2022-07-09
 * 面试题 02.01. 移除重复节点
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * 示例2:
 * <p>
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 * 提示：
 * <p>
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 * <p>
 * 如果不得使用临时缓冲区，该怎么解决？
 */
public class Code1 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        //判空
        if (head == null) {
            //过
            return null;
        }
        //记录首节点
        ListNode firstNode = head;
        //缓存,记录存在过的node
        Set<Integer> set = new HashSet<>();
        //第一个节点肯定不重复
        set.add(head.val);
        //循环,判断下一个是否存在,如果存在继续
        while (head.next != null) {
            //如果之前没有
            if (set.contains(head.next.val) == false) {
                //记录
                set.add(head.next.val);
                //这个可以,下一个
                head = head.next;
            } else {
                //这个节点忽略
                head.next = head.next.next;
            }
        }
        //返回
        return firstNode;
    }

}
