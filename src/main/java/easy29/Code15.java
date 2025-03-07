package easy29;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-04-08
 * 面试题 02.06. 回文链表
 * 编写一个函数，检查输入的链表是否是回文的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 * <p>
 * 输入： 1->2->2->1
 * 输出： true
 * <p>
 * <p>
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Code15 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        //列表
        List<ListNode> list = new ArrayList<>();
        //节点
        ListNode node = head;
        //如果有节点
        while (node != null) {
            //记录
            list.add(node);
            //下一个
            node = node.next;
        }
        //双指针
        int p = 0;
        int q = list.size() - 1;
        //如果需要对比
        while (p < q) {
            //如果不同
            if (list.get(p++).val != list.get(q--).val) {
                //不是
                return false;
            }
        }
        //默认
        return true;
    }

}
