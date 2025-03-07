package normal28;

/**
 * @Author ayl
 * @Date 2024-01-31
 * LCR 025. 两数相加 II
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * <p>
 * <p>
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * 示例2：
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 * 示例3：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表的长度范围为 [1, 100]
 * 0 <= node.val <= 9
 * 输入数据保证链表代表的数字无前导 0
 * <p>
 * <p>
 * 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 445 题相同：https://leetcode-cn.com/problems/add-two-numbers-ii/
 */
public class Code14 {

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

    //递归返回实体
    private class MergeResult {

        //返回的新节点
        private ListNode newNode;

        //进位
        private int other;

        //初始化
        public MergeResult(ListNode newNode, int other) {
            this.newNode = newNode;
            this.other = other;
        }

    }

    //计算链表长度
    private int nodeCount(ListNode node) {
        //判空
        if (node == null) {
            //过
            return 0;
        }
        //递归
        return 1 + nodeCount(node.next);
    }

    //递归计算加法
    private MergeResult merge(ListNode node1, ListNode node2, int number1, int number2) {

        /**
         * 判空处理
         */

        //都为空
        if (node1 == null && node2 == null) {
            //过
            return new MergeResult(null, 0);
        }
        //如果左边为空
        if (node1 == null) {
            //返回
            return new MergeResult(new ListNode(node2.val), 0);
        }
        //如果右边为空
        if (node2 == null) {
            //返回
            return new MergeResult(new ListNode(node1.val), 0);
        }

        /**
         * 如果层级关系相同,直接递归计算
         */

        //如果层级相同
        if (number1 == number2) {
            //递归子节点和
            MergeResult mergeResult = merge(node1.next, node2.next, number1 - 1, number2 - 1);
            //计算新数字
            int num = node1.val + node2.val + mergeResult.other;
            //新数字的进位
            int other = 0;
            //如果有进位
            if (num > 9) {
                //计算进位
                num -= 10;
                other++;
            }
            //初始化新节点
            ListNode newNode = new ListNode(num);
            //关联
            newNode.next = mergeResult.newNode;
            //返回
            return new MergeResult(newNode, other);
        }

        /**
         * 递归修正层级关系、然后再计算
         */

        //计算和
        int num;
        //默认进位
        int other = 0;
        //返回内容
        MergeResult mergeResult;
        //判断左右谁更长
        if (number1 > number2) {
            //递归子节点和
            mergeResult = merge(node1.next, node2, number1 - 1, number2);
            //计算新数字
            num = node1.val + mergeResult.other;
        } else {
            //递归子节点和
            mergeResult = merge(node1, node2.next, number1, number2 - 1);
            //计算新数字
            num = node2.val + mergeResult.other;
        }
        //如果有进位
        if (num > 9) {
            //计算进位
            num -= 10;
            other++;
        }
        //初始化新节点
        ListNode newNode = new ListNode(num);
        //关联
        newNode.next = mergeResult.newNode;
        //返回
        return new MergeResult(newNode, other);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //计算节点长度
        int nodeCount1 = nodeCount(l1);
        int nodeCount2 = nodeCount(l2);
        //递归实现
        MergeResult mergeResult = merge(l1, l2, nodeCount1, nodeCount2);
        //如果还有进位
        if (mergeResult.other > 0) {
            //再初始化一个首节点
            ListNode firstNode = new ListNode(mergeResult.other);
            //关联
            firstNode.next = mergeResult.newNode;
            //返回
            return firstNode;
        } else {
            //返回的就是首节点
            return mergeResult.newNode;
        }
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(4);

        node5.next = node6;
        node6.next = node7;

        ListNode listNode = new Code14().addTwoNumbers(node1, node5);
        System.out.println();

    }

}
