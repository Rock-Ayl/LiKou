package normal27;

/**
 * @Author ayl
 * @Date 2023-12-13
 * LCR 155. 将二叉搜索树转化为排序的双向链表
 * 中等
 * 737
 * 相关企业
 * 将一个 二叉搜索树 就地转化为一个 已排序的双向循环链表 。
 * <p>
 * 对于双向循环列表，你可以将左右孩子指针作为双向循环链表的前驱和后继指针，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 * <p>
 * 特别地，我们希望可以 就地 完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中最小元素的指针。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,5,1,3]
 * <p>
 * <p>
 * 输出：[1,2,3,4,5]
 * <p>
 * 解释：下图显示了转化后的二叉搜索树，实线表示后继关系，虚线表示前驱关系。
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [2,1,3]
 * 输出：[1,2,3]
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 解释：输入是空树，所以输出也是空链表。
 * 示例 4：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * -1000 <= Node.val <= 1000
 * Node.left.val < Node.val < Node.right.val
 * Node.val 的所有值都是独一无二的
 * 0 <= Number of Nodes <= 2000
 * 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 */
public class Code1 {

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    //递归
    private Node[] next(Node node) {
        //判空
        if (node == null) {
            //过
            return null;
        }
        //初始化返回对象
        Node[] result = new Node[2];
        //记录左右节点
        Node leftNode = node.left;
        Node rightNode = node.right;
        //取消当前节点的关联关系
        node.left = null;
        node.right = null;
        //先递归子节点
        Node[] leftNext = next(leftNode);
        Node[] rightNext = next(rightNode);
        //如果有左边
        if (leftNext != null) {
            //关联当前节点
            node.left = leftNext[1];
            leftNext[1].right = node;
            //记录最小结果
            result[0] = leftNext[0];
        } else {
            //记录最小结果
            result[0] = node;
        }
        //如果有右边
        if (rightNext != null) {
            //关联当前节点
            node.right = rightNext[0];
            rightNext[0].left = node;
            //记录最大结果
            result[1] = rightNext[1];
        } else {
            //记录最大结果
            result[1] = node;
        }
        //返回结果
        return result;
    }

    public Node treeToDoublyList(Node root) {
        //判空
        if (root == null) {
            //过
            return null;
        }
        //递归
        Node[] nodeArr = next(root);
        //关联两边节点
        nodeArr[1].right = nodeArr[0];
        nodeArr[0].left = nodeArr[1];
        //返回结果
        return nodeArr[0];
    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node4.right = node5;

        node4.left = node2;

        node2.left = node1;
        node2.right = node3;

        Node node = new Code1().treeToDoublyList(node4);
        System.out.println();
    }

}
