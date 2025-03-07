package normal25;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2023-10-16
 * LCR 029. 循环有序列表的插入
 * 中等
 * 156
 * 相关企业
 * 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。
 * <p>
 * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 * <p>
 * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 * <p>
 * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：head = [3,4,1], insertVal = 2
 * 输出：[3,4,1,2]
 * 解释：在上图中，有一个包含三个元素的循环有序列表，你获得值为 3 的节点的指针，我们需要向表中插入元素 2 。新插入的节点应该在 1 和 3 之间，插入之后，整个列表如上图所示，最后返回节点 3 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [], insertVal = 1
 * 输出：[1]
 * 解释：列表为空（给定的节点是 null），创建一个循环有序列表并返回这个节点。
 * 示例 3：
 * <p>
 * 输入：head = [1], insertVal = 0
 * 输出：[1,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= Number of Nodes <= 5 * 10^4
 * -10^6 <= Node.val <= 10^6
 * -10^6 <= insertVal <= 10^6
 * <p>
 * <p>
 * 注意：本题与主站 708 题相同： https://leetcode-cn.com/problems/insert-into-a-sorted-circular-linked-list/
 */
public class Code5 {

    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    //走过的节点的缓存
    private Set<Node> set = new HashSet<>();

    //插入实现
    public void insertNode(Node node, Node insertNode) {
        //插入
        insertNode.next = node.next;
        node.next = insertNode;
    }

    //递归一轮,有几种情况
    public void next(Node node, Node insertNode) {
        //如果是标准情况,左边小右边大
        if (node.val <= insertNode.val && node.next.val >= insertNode.val) {
            //插入
            insertNode(node, insertNode);
            //过
            return;
        }
        //如果最大的点比插入节点还小
        if (node.val <= insertNode.val && node.next.val < node.val) {
            //插入
            insertNode(node, insertNode);
            //过
            return;
        }
        //如果最小的点插入节点还大
        if (node.next.val < node.val && node.next.val >= insertNode.val) {
            //插入
            insertNode(node, insertNode);
            //过
            return;
        }
        //如果轮了一轮,所有节点都走过了
        if (set.contains(node.next)) {
            //插入
            insertNode(node, insertNode);
            //过
            return;
        }
        //记录
        set.add(node);
        //递归
        next(node.next, insertNode);
    }

    public Node insert(Node head, int insertVal) {
        //初始化新节点
        Node node = new Node(insertVal);
        //判空
        if (head == null) {
            //无线循环
            node.next = node;
            //默认
            return node;
        }
        //递归实现
        next(head, node);
        //返回
        return head;
    }

}
