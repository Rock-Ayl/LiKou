package normal11;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-02-14
 * 1669. 合并两个链表
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 * <p>
 * 请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。
 * <p>
 * 下图中蓝色边和节点展示了操作后的结果：
 * <p>
 * <p>
 * 请你返回结果链表的头指针。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中下标为 3 和 4 的两个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 * 示例 2：
 * <p>
 * <p>
 * 输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
 * 输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
 * 解释：上图中蓝色的边和节点为答案链表。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= list1.length <= 104
 * 1 <= a <= b < list1.length - 1
 * 1 <= list2.length <= 104
 */
public class Code17 {

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

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        //缓存<子,父>
        Map<Integer, ListNode> map = new HashMap<>();
        //记录节点
        ListNode node = list1;
        ListNode node2 = list2;
        //下标
        int p = 1;
        //循环
        while (node.next != null) {
            //记录子父关系
            map.put(p++, node);
            //下一个
            node = node.next;
        }
        //左
        ListNode left = map.get(a);
        ListNode right = map.get(b).next.next;
        //连接左边
        left.next = list2;
        //循环
        while (node2.next != null) {
            //下一个
            node2 = node2.next;
        }
        //连接右边
        node2.next = right;
        //返回首位节点
        return list1;
    }

}
