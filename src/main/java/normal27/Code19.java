package normal27;

/**
 * @Author ayl
 * @Date 2024-01-12
 * 2074. 反转偶数长度组的节点
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个链表的头节点 head 。
 * <p>
 * 链表中的节点 按顺序 划分成若干 非空 组，这些非空组的长度构成一个自然数序列（1, 2, 3, 4, ...）。一个组的 长度 就是组中分配到的节点数目。换句话说：
 * <p>
 * 节点 1 分配给第一组
 * 节点 2 和 3 分配给第二组
 * 节点 4、5 和 6 分配给第三组，以此类推
 * 注意，最后一组的长度可能小于或者等于 1 + 倒数第二组的长度 。
 * <p>
 * 反转 每个 偶数 长度组中的节点，并返回修改后链表的头节点 head 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [5,2,6,3,9,1,7,3,8,4]
 * 输出：[5,6,2,3,9,1,4,8,3,7]
 * 解释：
 * - 第一组长度为 1 ，奇数，没有发生反转。
 * - 第二组长度为 2 ，偶数，节点反转。
 * - 第三组长度为 3 ，奇数，没有发生反转。
 * - 最后一组长度为 4 ，偶数，节点反转。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,1,0,6]
 * 输出：[1,0,1,6]
 * 解释：
 * - 第一组长度为 1 ，没有发生反转。
 * - 第二组长度为 2 ，节点反转。
 * - 最后一组长度为 1 ，没有发生反转。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [2,1]
 * 输出：[2,1]
 * 解释：
 * - 第一组长度为 1 ，没有发生反转。
 * - 最后一组长度为 1 ，没有发生反转。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目范围是 [1, 105]
 * 0 <= Node.val <= 105
 */
public class Code19 {

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

    //递归、翻转
    private ListNode nextLeft(ListNode node, int count) {
        //判空
        if (node == null) {
            //过
            return null;
        }
        //初始化翻转节点
        ListNode reversalNode = null;
        //最后一个节点
        ListNode lastNode = node;
        //指针
        int p = 0;
        //循环
        while (node != null && p < count) {

            //获取下一级节点
            ListNode nextNode = node.next;

            //与翻转节点关联
            node.next = reversalNode;
            reversalNode = node;

            //+1
            p++;
            //下一级
            node = nextNode;

        }
        //如果到最后了
        if (p != count) {
            //如果是哦书
            if (p % 2 == 0) {
                //返回首节点
                return reversalNode;
            } else {
                //翻转并返回
                return reversal(reversalNode);
            }
        }
        //如果还有
        if (node != null) {
            //继续递归并关联
            lastNode.next = nextRight(node, count + 1);
        }
        //返回首节点
        return reversalNode;
    }

    //递归、不翻转
    private ListNode nextRight(ListNode node, int count) {
        //判空
        if (node == null) {
            //过
            return null;
        }
        //记录第一个节点
        ListNode firstNode = new ListNode();
        //当前节点
        ListNode head = firstNode;
        //指针
        int p = 0;
        //循环
        while (node != null && p < count) {

            //获取下一级节点
            ListNode nextNode = node.next;
            //取消关联
            node.next = null;

            //记录
            head.next = node;
            head = node;

            //+1
            p++;
            //下一级
            node = nextNode;

        }
        //如果到最后了
        if (p != count) {
            //如果是奇数
            if (p % 2 != 0) {
                //返回首节点
                return firstNode.next;
            } else {
                //翻转并返回
                return reversal(firstNode.next);
            }
        }
        //如果还有
        if (node != null) {
            //继续递归并关联
            head.next = nextLeft(node, count + 1);
        }
        //返回首节点
        return firstNode.next;
    }

    //翻转节点
    private ListNode reversal(ListNode node) {
        //判空
        if (node == null) {
            //过
            return null;
        }
        //首节点
        ListNode first = null;
        //循环
        while (node != null) {

            //下一个节点
            ListNode nextNode = node.next;

            //关联
            node.next = first;
            first = node;

            //下一个
            node = nextNode;

        }
        //返回
        return first;
    }

    public ListNode reverseEvenLengthGroups(ListNode head) {
        //实现
        return nextRight(head, 1);
    }

    public static void main(String[] args) {
        //5,2,6,3,9,1,7,3,8,4
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(1);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(3);
        ListNode node9 = new ListNode(8);
        ListNode node10 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;

        ListNode listNode = new Code19().reverseEvenLengthGroups(node1);
        System.out.println();


    }

}
