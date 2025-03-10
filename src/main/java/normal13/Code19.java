package normal13;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2022-05-10
 * 817. 链表组件
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。同时给定列表 nums，该列表是上述链表中整型值的一个子集。
 * <p>
 * 返回列表 nums 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 nums 中）构成的集合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入: head = [0,1,2,3], nums = [0,1,3]
 * 输出: 2
 * 解释: 链表中,0 和 1 是相连接的，且 nums 中不包含 2，所以 [0, 1] 是 nums 的一个组件，同理 [3] 也是一个组件，故返回 2。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入: head = [0,1,2,3,4], nums = [0,3,1,4]
 * 输出: 2
 * 解释: 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数为n
 * 1 <= n <= 104
 * 0 <= Node.val < n
 * Node.val 中所有值 不同
 * 1 <= nums.length <= n
 * 0 <= nums[i] < n
 * nums 中所有值 不同
 * 通过次数15,384提交次数25,895
 */
public class Code19 {

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

    public int numComponents(ListNode head, int[] nums) {
        //缓存
        Set<Integer> set = new HashSet<>(nums.length);
        //循环
        for (int num : nums) {
            //组装
            set.add(num);
        }
        //组件数
        int count = 0;
        //当前连击
        int hit = 0;
        //循环
        while (head != null) {
            //当前
            int num = head.val;
            //如果连击
            if (set.contains(num)) {
                //连击
                hit++;
            } else {
                //如果处于连击中被中断
                if (hit > 0) {
                    //连击清0
                    hit = 0;
                    //组件+1
                    count++;
                }
            }
            //下一个
            head = head.next;
        }
        //如果结尾组件没有清算
        if (hit > 0) {
            //+1
            return count + 1;
        } else {
            //返回
            return count;
        }
    }

}
