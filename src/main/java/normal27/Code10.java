package normal27;

/**
 * @Author ayl
 * @Date 2023-12-25
 * LCR 026. 重排链表
 * 中等
 * 138
 * 相关企业
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0 → L1 → … → Ln-1 → Ln
 * 请将其重新排列后变为：
 * <p>
 * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 * <p>
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: head = [1,2,3,4]
 * 输出: [1,4,2,3]
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,5,2,4,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表的长度范围为 [1, 5 * 104]
 * 1 <= node.val <= 1000
 * <p>
 * <p>
 * 注意：本题与主站 143 题相同：https://leetcode-cn.com/problems/reorder-list/
 */
public class Code10 {

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
            return this.val + "";
        }
    }

    public void reorderList(ListNode head) {

        /**
         * step 1 链表长度
         */

        //长度
        int nodeCount = 0;
        //初始化
        ListNode node = head;
        //循环
        while (node != null) {
            //下一级
            node = node.next;
            //+1
            nodeCount++;
        }

        /**
         * step 2 找到中间节点,分为两个链表 left mid
         */

        //计算中间节点索引
        int midIndex = nodeCount / 2 + nodeCount % 2;
        //初始化中间节点
        ListNode midNode = head;
        //循环
        while (--midIndex > 0) {
            //下一级
            midNode = midNode.next;
        }
        //取消关联
        ListNode midFather = midNode;
        midNode = midNode.next;
        midFather.next = null;

        /**
         * step 3 mid节点翻转为 right节点
         */

        //初始化右链表
        ListNode rightNode = new ListNode(-1);
        //循环
        while (midNode != null) {
            //当前节点
            ListNode thisMidNode = midNode;
            //下一级
            midNode = midNode.next;
            //组装至右节点
            thisMidNode.next = rightNode.next;
            rightNode.next = thisMidNode;
        }
        //取消第一个
        rightNode = rightNode.next;

        /**
         * step 4 左右合并为新节点
         */

        //合并后的节点
        ListNode mixNode = head;
        //本次是否为右节点
        boolean right = true;
        //左链表
        ListNode leftNode = head.next;
        //主节点取消任何关联
        mixNode.next = null;
        //循环
        while (leftNode != null || rightNode != null) {
            //如果本次是右节点
            if (right) {
                //当前节点
                ListNode thisRightNode = rightNode;
                //下一级
                rightNode = rightNode.next;
                //取消关联
                thisRightNode.next = null;
                //合并
                mixNode.next = thisRightNode;
                mixNode = mixNode.next;
            } else {
                //当前节点
                ListNode thisLeftNode = leftNode;
                //下一级
                leftNode = leftNode.next;
                //取消关联
                thisLeftNode.next = null;
                //合并
                mixNode.next = thisLeftNode;
                mixNode = mixNode.next;
            }
            //切换左右节点
            right = !right;
        }

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        new Code10().reorderList(node1);

        System.out.println();
    }

}
