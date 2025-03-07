package normal27;

/**
 * @Author ayl
 * @Date 2024-01-03
 * 430. 扁平化多级双向链表
 * 中等
 * 420
 * 相关企业
 * 你会得到一个双链表，其中包含的节点有一个下一个指针、一个前一个指针和一个额外的 子指针 。这个子指针可能指向一个单独的双向链表，也包含这些特殊的节点。这些子列表可以有一个或多个自己的子列表，以此类推，以生成如下面的示例所示的 多层数据结构 。
 * <p>
 * 给定链表的头节点 head ，将链表 扁平化 ，以便所有节点都出现在单层双链表中。让 curr 是一个带有子列表的节点。子列表中的节点应该出现在扁平化列表中的 curr 之后 和 curr.next 之前 。
 * <p>
 * 返回 扁平列表的 head 。列表中的节点必须将其 所有 子指针设置为 null 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
 * 解释：输入的多级列表如上图所示。
 * 扁平化后的链表如下图：
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,null,3]
 * 输出：[1,3,2]
 * 解释：输入的多级列表如上图所示。
 * 扁平化后的链表如下图：
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 说明：输入中可能存在空列表。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点数目不超过 1000
 * 1 <= Node.val <= 105
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
 */
public class Code15 {

    // Definition for a Node.
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    //递归节点,返回左右边界节点
    private Node[] next(Node node) {

        /**
         * step 1. 判空,先获取所需节点
         */

        //初始化结果
        Node[] result = new Node[]{node, node};
        //获取其子节点、下一级节点
        Node childNode = node.child;
        Node nextNode = node.next;

        /**
         * step 2. 节点之间脱离原有关系
         */

        //脱离关系
        node.child = null;
        node.next = null;
        //如果有下一节点
        if (nextNode != null) {
            //脱离上一级关系
            nextNode.prev = null;
        }

        /**
         * step 3. 按照优先级,递归子节点
         */

        //如果有子节点
        if (childNode != null) {
            //递归、并合并到结果
            merge(result, next(childNode));
        }
        //如果有下一级节点
        if (nextNode != null) {
            //递归、并合并到结果
            merge(result, next(nextNode));
        }
        //返回结果
        return result;
    }

    //合并两个边界节点结果集 eg: [1,2,3][4,5,6]=[1,2,3,4,5,6]
    private void merge(Node[] left, Node[] right) {
        //合并左右
        left[1].next = right[0];
        right[0].prev = left[1];
        //替换左边结果的最后一级节点
        left[1] = right[1];
    }

    public Node flatten(Node head) {
        //判空
        if (head == null) {
            //过
            return null;
        }
        //实现,返回首节点
        return next(head)[0];
    }

}
