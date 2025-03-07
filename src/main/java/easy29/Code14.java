package easy29;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-04-07
 * 剑指 Offer II 027. 回文链表
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 * <p>
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入: head = [1,2,3,3,2,1]
 * 输出: true
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入: head = [1,2]
 * 输出: false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表 L 的长度范围为 [1, 105]
 * 0 <= node.val <= 9
 * <p>
 * <p>
 * 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 234 题相同：https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class Code14 {

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

    public boolean isPalindrome(ListNode head) {
        //长度
        List<Integer> list = new ArrayList<>();
        //记录
        ListNode node = head;
        //如果有
        while (node != null) {
            //记录
            list.add(node.val);
            //下一个
            node = node.next;
        }
        //坐标
        int p = 0;
        int q = list.size() - 1;
        //如果需要对比
        while (p < q) {
            //如果不同
            if (list.get(p++).equals(list.get(q--)) == false) {
                //不是
                return false;
            }
        }
        //默认
        return true;
    }

}
