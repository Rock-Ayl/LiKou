package normal33;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-07-31
 * 3217. 从链表中移除在数组中存在的节点
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个链表的头节点 head。从链表中移除所有存在于 nums 中的节点后，返回修改后的链表的头节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,2,3], head = [1,2,3,4,5]
 * <p>
 * 输出： [4,5]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 移除数值为 1, 2 和 3 的节点。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1], head = [1,2,1,2,1,2]
 * <p>
 * 输出： [2,2,2]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 移除数值为 1 的节点。
 * <p>
 * 示例 3：
 * <p>
 * 输入： nums = [5], head = [1,2,3,4]
 * <p>
 * 输出： [1,2,3,4]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 链表中不存在值为 5 的节点。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * nums 中的所有元素都是唯一的。
 * 链表中的节点数在 [1, 105] 的范围内。
 * 1 <= Node.val <= 105
 * 输入保证链表中至少有一个值没有在 nums 中出现过。
 */
public class Code21 {

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

    //递归删除
    private ListNode next(Set<Integer> numSet, ListNode node) {
        //判空
        if (node == null) {
            //过
            return null;
        }
        //如果当前节点需要删除
        if (numSet.contains(node.val)) {
            //递归子节点
            return next(numSet, node.next);
        } else {
            //递归子节点
            node.next = next(numSet, node.next);
            //返回
            return node;
        }
    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        //转为集合
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        //返回
        return next(numSet, head);
    }

    public static void main(String[] args) {

    }

}
