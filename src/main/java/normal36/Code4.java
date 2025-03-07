package normal36;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2024-10-14
 * 1171. 从链表中删去总和值为零的连续节点
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 * <p>
 * 删除完毕后，请你返回最终结果链表的头节点。
 * <p>
 * <p>
 * <p>
 * 你可以返回任何满足题目要求的答案。
 * <p>
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,-3,3,1]
 * 输出：[3,1]
 * 提示：答案 [1,2,1] 也是正确的。
 * 示例 2：
 * <p>
 * 输入：head = [1,2,3,-3,4]
 * 输出：[1,2,4]
 * 示例 3：
 * <p>
 * 输入：head = [1,2,3,-3,-2]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给你的链表中可能有 1 到 1000 个节点。
 * 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.
 */
public class Code4 {

    public static class ListNode {

        private int val;
        private ListNode next;

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

    public ListNode removeZeroSumSublists(ListNode head) {

        /**
         * step 1. 算前缀和,拆分链表为数组,记录前缀和索引
         */

        //初始化节点列表
        List<ListNode> nodeList = new ArrayList<>();
        //初始化前缀和列表
        List<Integer> sumList = new ArrayList<>();
        //最先出现的和索引map
        Map<Integer, Integer> firstSumIndexMap = new HashMap<>();
        //初始化第一个0
        sumList.add(0);
        //节点
        ListNode node = head;
        //如果存在
        while (node != null) {

            //求本次和
            int sum = node.val + sumList.get(sumList.size() - 1);
            //获取下一个节点
            ListNode next = node.next;
            //删除节点关联
            node.next = null;

            //如果没有存在过
            if (firstSumIndexMap.containsKey(sum) == false) {
                //记录索引
                firstSumIndexMap.put(sum, nodeList.size());
            }
            //记录当前和
            sumList.add(sum);
            //记录当前节点
            nodeList.add(node);

            //下一个
            node = next;
        }
        //删除第一个0
        sumList.remove(0);

        /**
         * step 2.整理出新的节点链表
         */

        //初始化一个头节点
        ListNode firstNode = new ListNode(-1);
        //使用头节点
        ListNode newNodeLink = firstNode;
        //循环
        for (int i = nodeList.size() - 1; i >= 0; i--) {
            //获取当前节点
            ListNode thisNode = nodeList.get(i);
            //获取当前和
            int sum = sumList.get(i);
            //获取前面对应该和的索引
            int firstSumIndex = firstSumIndexMap.get(sum);
            //如果是0
            if (sum == 0) {
                //跳出,因为可以删除之前的全部
                break;
            }
            //如果是同一个 or 之后
            if (firstSumIndex >= i) {
                //关联
                newNodeLink.next = thisNode;
                //下一个
                newNodeLink = thisNode;
            } else {
                //删除这之间的节点
                i = firstSumIndex + 1;
            }
        }

        /**
         * step 3.新链表反转
         */

        //初始化结果头
        ListNode result = new ListNode(-1);
        //如果没有结果
        if (firstNode.next == null) {
            //过
            return null;
        }
        //重新来
        newNodeLink = firstNode.next;
        //循环
        while (newNodeLink != null) {
            //获取节点
            ListNode thisNode = newNodeLink;
            ListNode nextNode = newNodeLink.next;
            //取消关联
            newNodeLink.next = null;
            //和结果关联
            thisNode.next = result.next;
            result.next = thisNode;
            //下一个
            newNodeLink = nextNode;
        }

        //返回结果
        return result.next;
    }

    public static void main(String[] args) {

        /*ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(-3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        */

        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(-1);

        node3.next = node4;

        //实现
        ListNode node = new Code4().removeZeroSumSublists(node3);
        System.out.println();

    }

}
