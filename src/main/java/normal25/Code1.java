package normal25;

/**
 * @Author ayl
 * @Date 2023-10-11
 * 138. 随机链表的复制
 * 提示
 * 中等
 * 1.2K
 * 相关企业
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * <p>
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * <p>
 * 返回复制链表的头节点。
 * <p>
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * <p>
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
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
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 1000
 * -104 <= Node.val <= 104
 * Node.random 为 null 或指向链表中的节点。
 */
public class Code1 {

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

    //第一步,复制
    private void copy(Node node) {
        //循环
        while (node != null) {
            //复制新节点
            Node copyNode = new Node(node.val);
            //插入到当前节点和下一个节点中间
            copyNode.next = node.next;
            node.next = copyNode;
            //下一个非复制节点
            node = node.next.next;
        }
    }

    //第二步,连接随机节点
    private void linkRandom(Node node) {
        //循环
        while (node != null) {
            //如果有复制节点
            if (node.random != null) {
                //关联复制节点的随机节点
                node.next.random = node.random.next;
            }
            //下一个非复制节点
            node = node.next.next;
        }
    }

    //第三步,复制链与原链分离
    private Node move(Node node) {
        //获取复制节点中的第一个节点
        Node copyFirstNode = node.next;
        //加一个不存在的链
        Node copyNode = new Node(-1);
        //循环
        while (node != null) {
            //复制节点与复制节点关联
            copyNode.next = node.next;
            //复制节点换下一个
            copyNode = copyNode.next;
            //把主链中的该复制节点删除
            node.next = node.next.next;
            //下一个非复制节点
            node = node.next;
        }
        //返回结果
        return copyFirstNode;
    }

    public Node copyRandomList(Node head) {
        //判空
        if (head == null) {
            //过
            return null;
        }
        //第一步,先复制
        copy(head);
        //第二步,连接随机节点
        linkRandom(head);
        //第三步,分离,并返回结果
        return move(head);
    }

}
