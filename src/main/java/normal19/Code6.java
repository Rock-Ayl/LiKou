package normal19;

/**
 * @Author ayl
 * @Date 2023-03-14
 * 1721. 交换链表中的节点
 * 给你链表的头节点 head 和一个整数 k 。
 * <p>
 * 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * <p>
 * 输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * 输出：[7,9,6,6,8,7,3,0,9,5]
 * 示例 3：
 * <p>
 * 输入：head = [1], k = 1
 * 输出：[1]
 * 示例 4：
 * <p>
 * 输入：head = [1,2], k = 1
 * 输出：[2,1]
 * 示例 5：
 * <p>
 * 输入：head = [1,2,3], k = 2
 * 输出：[1,2,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目是 n
 * 1 <= k <= n <= 105
 * 0 <= Node.val <= 100
 */
public class Code6 {

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

    public ListNode swapNodes(ListNode head, int k) {
        //当前节点
        ListNode node = head;
        //数量
        int length = 0;
        //循环
        while (node != null) {
            //进位
            length++;
            //下一个
            node = node.next;
        }
        //两个节点坐标
        int left = length - k;
        int right = k - 1;
        //如果是一个节点
        if (left == right) {
            //直接返回即可
            return head;
        }
        //重新一轮
        node = head;
        //第一个节点
        ListNode leftNode = null;
        //指针
        int p = 0;
        //循环
        while (node != null) {
            //如果是目标
            if (p == left || p == right) {
                //如果是第一个
                if (leftNode == null) {
                    //记录
                    leftNode = node;
                } else {
                    //交换值
                    int num = leftNode.val;
                    leftNode.val = node.val;
                    node.val = num;
                    //返回结果
                    return head;
                }
            }
            //进位
            p++;
            //下一个
            node = node.next;
        }
        //返回结果
        return head;
    }

    public static void main(String[] args) {
        Code6 code6 = new Code6();

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        code6.swapNodes(one, 3);
    }


}
