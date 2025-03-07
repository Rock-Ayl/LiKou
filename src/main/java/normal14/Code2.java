package normal14;

/**
 * @Author ayl
 * @Date 2022-05-12
 * 725. 分隔链表
 * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
 * <p>
 * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
 * <p>
 * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
 * <p>
 * 返回一个由上述 k 部分组成的数组。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3], k = 5
 * 输出：[[1],[2],[3],[],[]]
 * 解释：
 * 第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
 * 最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
 * 输出：[[1,2,3,4],[5,6,7],[8,9,10]]
 * 解释：
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过 1 。前面部分的长度大于等于后面部分的长度。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 1000]
 * 0 <= Node.val <= 1000
 * 1 <= k <= 50
 */
public class Code2 {

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

    public ListNode[] splitListToParts(ListNode head, int k) {
        //初始化结果
        ListNode[] result = new ListNode[k];
        //长度
        int length = 0;
        //准备开始计算长度
        ListNode next = head;
        //循环
        while (next != null) {
            //记录长度
            length++;
            //下一个
            next = next.next;
        }
        //准备把节点当栈
        ListNode node = head;
        //如果有空的
        if (length < k) {
            //指针
            int p = 0;
            //循环
            while (p < length) {
                //下一个节点
                ListNode nextNode = node.next;
                //断开连接
                node.next = null;
                //放入
                result[p++] = node;
                //下一个
                node = nextNode;
            }
        } else {
            //计算出一般长度
            int normal = length / k;
            //计算出补充的个数
            int other = length % k;
            //指针
            int p = 0;
            //循环
            while (p < k) {
                //首先组装第一个节点
                result[p++] = node;
                //当前长度
                int thisSize = 0;
                //循环
                while (node.next != null && thisSize < normal) {
                    //+1
                    thisSize++;
                    //如果结束了
                    if (thisSize == normal) {
                        //如果有备货
                        if (node.next != null && other > 0) {
                            //下一个
                            node = node.next;
                            //减少
                            other--;
                        }
                        //下一个节点
                        ListNode nextNode = node.next;
                        //断开连接
                        node.next = null;
                        //下一个
                        node = nextNode;
                    } else {
                        //下一个
                        node = node.next;
                    }
                }
            }
        }
        //返回
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

        new Code2().splitListToParts(one, 2);
    }

}
