package normal11;

/**
 * @Author ayl
 * @Date 2022-02-10
 * 86. 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */
public class Code13 {

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

    public ListNode partition(ListNode head, int x) {
        //初始化左右
        ListNode left = null;
        ListNode right = null;
        //左右节点第一个节点
        ListNode leftFirst = null;
        ListNode rightFirst = null;
        //循环
        while (head != null) {
            //判断是左还是右
            if (head.val < x) {
                //如果是第一个
                if (left == null) {
                    //初始化
                    leftFirst = head;
                } else {
                    //连接
                    left.next = head;
                }
                //下一个
                left = head;
            } else {
                //如果是第一个
                if (right == null) {
                    //初始化
                    rightFirst = head;
                } else {
                    //连接
                    right.next = head;
                }
                //下一个
                right = head;
            }
            //下一个
            head = head.next;
        }
        //如果存在右边
        if (right != null) {
            //去尾
            right.next = null;
        }
        //如果有左边
        if (left != null) {
            //连接中间
            left.next = rightFirst;
            //返回左边
            return leftFirst;
        } else {
            //直接返回右边
            return rightFirst;
        }
    }

}