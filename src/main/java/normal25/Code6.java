package normal25;

/**
 * @Author ayl
 * @Date 2023-10-17
 * 147. 对链表进行插入排序
 * 中等
 * 636
 * 相关企业
 * 给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
 * <p>
 * 插入排序 算法的步骤:
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * 下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，从输入数据中删除一个元素(红色)，并就地插入已排序的列表中。
 * <p>
 * 对链表进行插入排序。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入: head = [4,2,1,3]
 * 输出: [1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入: head = [-1,5,3,4,0]
 * 输出: [-1,0,3,4,5]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 列表中的节点数在 [1, 5000]范围内
 * -5000 <= Node.val <= 5000
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

    public ListNode insertionSortList(ListNode head) {
        //初始化一个最小的首节点
        ListNode first = new ListNode(Integer.MIN_VALUE);
        //循环
        while (head != null) {
            //从头开始
            ListNode node = first;
            //如果比下一个大
            while (node.next != null && node.next.val <= head.val) {
                //下一个
                node = node.next;
            }
            //先记录下一个节点
            ListNode nextHead = head.next;
            //插入节点
            head.next = node.next;
            node.next = head;
            //下一个
            head = nextHead;
        }
        //返回结果
        return first.next;
    }

    public static void main(String[] args) {

        ListNode four = new ListNode(4);
        ListNode two = new ListNode(2);
        ListNode one = new ListNode(1);
        ListNode three = new ListNode(3);

        four.next = two;
        two.next = one;
        one.next = three;

        Code6 code6 = new Code6();
        ListNode listNode = code6.insertionSortList(four);
        System.out.println();

    }

}
