package normal10;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2022-01-28
 */
public class Code16 {

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

    public int pairSum(ListNode head) {
        //初始化列表
        List<ListNode> list = new ArrayList<>();
        //循环
        while (head != null) {
            //组装
            list.add(head);
            //下一个
            head = head.next;
        }
        //长度
        int n = list.size();
        //最大结果
        int max = 0;
        //循环
        for (int i = 0; i < n / 2; i++) {
            //孪生节点的和
            int sum = list.get(i).val + list.get(n - 1 - i).val;
            //如果有更新
            if (sum > max) {
                //刷新
                max = sum;
            }
        }
        //返回
        return max;
    }
}
