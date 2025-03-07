package normal14;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-05-13
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
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
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数小于 6000
 * -100 <= node.val <= 100
 */
public class Code3 {

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

    //缓存,记录上一个当前深度节点
    Map<Integer, Node> map = new HashMap<>();

    public void next(Node node, int deep) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //如果有之前节点
        if (map.containsKey(deep)) {
            //上一个连接当前
            map.get(deep).next = node;
        }
        //记录当前
        map.put(deep, node);
        //下一级的深度
        int nextDeep = deep + 1;
        //下一级
        next(node.left, nextDeep);
        next(node.right, nextDeep);
    }

    public Node connect(Node root) {
        //当前
        next(root, 1);
        //返回
        return root;
    }

}
