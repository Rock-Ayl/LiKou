package easy33;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-10-28
 * LCR 028. 扁平化多级双向链表
 * 中等
 * 81
 * 相关企业
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * <p>
 * 给定位于列表第一级的头节点，请扁平化列表，即将这样的多级双向链表展平成普通的双向链表，使所有结点出现在单级双链表中。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
 * 解释：
 * <p>
 * 输入的多级列表如下图所示：
 * <p>
 * <p>
 * <p>
 * 扁平化后的链表如下图：
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2,null,3]
 * 输出：[1,3,2]
 * 解释：
 * <p>
 * 输入的多级列表如下图所示：
 * <p>
 * 1---2---NULL
 * |
 * 3---NULL
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * 如何表示测试用例中的多级链表？
 * <p>
 * 以 示例 1 为例：
 * <p>
 * 1---2---3---4---5---6--NULL
 * |
 * 7---8---9---10--NULL
 * |
 * 11--12--NULL
 * 序列化其中的每一级之后：
 * <p>
 * [1,2,3,4,5,6,null]
 * [7,8,9,10,null]
 * [11,12,null]
 * 为了将每一级都序列化到一起，我们需要每一级中添加值为 null 的元素，以表示没有节点连接到上一级的上级节点。
 * <p>
 * [1,2,3,4,5,6,null]
 * [null,null,7,8,9,10,null]
 * [null,11,12,null]
 * 合并所有序列化结果，并去除末尾的 null 。
 * <p>
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点数目不超过 1000
 * 1 <= Node.val <= 10^5
 * <p>
 * <p>
 * 注意：本题与主站 430 题相同： https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/
 * <p>
 * 通过次数
 * 27.5K
 * 提交次数
 */
public class Code24 {

    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }
    }

    //缓存
    private List<Node> list = new ArrayList<>();

    //递归
    private void next(Node node) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //第一个是主节点
        list.add(node);
        //第二个是下层级节点
        next(node.child);
        //最后是下一级节点
        next(node.next);
        //取消关联
        node.next = null;
        node.prev = null;
        node.child = null;
    }

    public Node flatten(Node head) {
        //判空
        if (head == null) {
            //过
            return null;
        }
        //递归
        next(head);
        //获取
        Node node = list.get(0);
        //循环
        for (int i = 1; i < list.size(); i++) {
            //关联二者
            node.next = list.get(i);
            node.next.prev = node;
            //下一个节点
            node = node.next;
        }
        //返回
        return head;
    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        node2.prev = node1;
        node3.prev = node2;
        node4.prev = node3;
        node5.prev = node4;
        node6.prev = node5;

        Node flatten = new Code24().flatten(node1);
        System.out.println();
    }

}
