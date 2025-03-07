package normal24;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-10-07
 * LCR 077. 排序链表
 * 中等
 * 133
 * 相关企业
 * 给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 * <p>
 * <p>
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 148 题相同：https://leetcode-cn.com/problems/sort-list/
 */
public class Code16 {

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

    public ListNode sortList(ListNode head) {
        //判空
        if (head == null) {
            //过
            return null;
        }
        //节点列表
        List<ListNode> nodeList = new ArrayList<>();
        //判空
        while (head != null) {
            //组装
            nodeList.add(head);
            //下一个
            head = head.next;
            //置空
            nodeList.get(nodeList.size() - 1).next = null;
        }
        //排序
        nodeList.sort(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        //初始化第一个节点
        ListNode node = nodeList.get(0);
        //循环
        for (int i = 1; i < nodeList.size(); i++) {
            //链接
            node.next = nodeList.get(i);
            //下一个
            node = node.next;
        }
        //返回
        return nodeList.get(0);
    }


}
