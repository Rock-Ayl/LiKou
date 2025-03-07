package easy18;

/**
 * @Author ayl
 * @Date 2022-04-21
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * 通过次数975,396提交次数1,463,214
 */
public class Code9 {

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


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //判空
        if (list1 == null) {
            //返回
            return list2;
        } else if (list2 == null) {
            //返回
            return list1;
        }
        //如果左边小
        if (list1.val < list2.val) {
            //下一个
            list1.next = mergeTwoLists(list1.next, list2);
            //返回
            return list1;
        } else {
            //下一个
            list2.next = mergeTwoLists(list1, list2.next);
            //返回
            return list2;
        }
    }

}
