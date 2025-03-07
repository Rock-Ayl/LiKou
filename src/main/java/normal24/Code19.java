package normal24;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-10-10
 * 灵动布局
 * Plus 会员
 * 0
 * <p>
 * avatar
 * LCR 154. 复杂链表的复制
 * 中等
 * 783
 * 相关企业
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 * <p>
 * <p>
 * 提示：
 * <p>
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 * <p>
 * <p>
 * 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 */
public class Code19 {

    public Node copyRandomList(Node head) {
        //判空
        if (head == null) {
            //过
            return null;
        }
        //初始化首节点
        Node newFirstNode = new Node(head.val);
        //从一开始
        Node newNode = newFirstNode;
        Node node = head.next;
        //节点缓存map
        Map<Node, Node> copyNodeMap = new HashMap<>();
        //第一个复制关系
        copyNodeMap.put(head, newFirstNode);
        //如果还存在
        while (node != null) {
            //初始化新节点
            Node nextNewNode = new Node(node.val);
            //记录复制关系
            copyNodeMap.put(node, nextNewNode);
            //关联
            newNode.next = nextNewNode;
            //下一个
            node = node.next;
            newNode = newNode.next;
        }
        //重新来
        newNode = newFirstNode;
        node = head;
        //如果还存在
        while (node != null) {
            //如果原始节点有随机节点
            if (node.random != null) {
                //获取对应复制节点并关联
                newNode.random = copyNodeMap.get(node.random);
            }
            //下一个
            node = node.next;
            newNode = newNode.next;
        }
        //返回
        return newFirstNode;
    }

    public static class Node {

        private int val;
        private Node next;
        private Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

    }

}
