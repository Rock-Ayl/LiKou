package normal13;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-03-26
 * 116. 填充每个节点的下一个右侧节点指针
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 * 示例 2:
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数量在 [0, 212 - 1] 范围内
 * -1000 <= node.val <= 1000
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class Code12 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    //缓存<深度,最近节点>
    Map<Integer, Node> map = new HashMap<>();

    public void next(Node root, int deep) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //如果有前一个节点
        if (map.containsKey(deep)) {
            //获取前一个节点
            Node last = map.get(deep);
            //连接它们
            last.next = root;
        }
        //覆盖当前节点为当前深度最近节点
        map.put(deep, root);
        //下一个深度
        int nextDeep = deep + 1;
        //下一级
        next(root.left, nextDeep);
        next(root.right, nextDeep);
    }

    public Node connect(Node root) {
        //开始遍历
        next(root, 1);
        //返回
        return root;
    }

}
