package normal19;

import java.util.Random;

/**
 * @Author ayl
 * @Date 2023-03-16
 */
public class Code9 {

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

    private ListNode first;

    public Code9(ListNode head) {
        //记录
        first = head;
    }

    //蓄水池遍历整个
    public int getRandom() {
        //结果
        int result = 0;
        //数量
        int size = 0;
        //循环链表
        for (ListNode node = this.first; node != null; node = node.next) {
            //如果本次是目标(第一次必中,第二次二分之一,第三次三分之一,以此类推)
            if (new Random().nextInt(++size) == 0) {
                //记录本次结果(后面命中会覆盖前面)
                result = node.val;
            }
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {



        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        Code9 code9 = new Code9(one);


        for (int i = 0; i < 100; i++) {
            System.out.println(code9.getRandom());
        }
    }

}
