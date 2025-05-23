package easy15;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-11-29
 * 589. N 叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的 前序遍历 。
 * <p>
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 * <p>
 * <p>
 * 提示：
 * <p>
 * N 叉树的高度小于或等于 1000
 * 节点总数在范围 [0, 10^4] 内
 */
public class Code14 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        //结果
        List<Integer> result = new ArrayList<>();
        //判空
        if (root == null) {
            //直接返回
            return result;
        }
        //组装
        result.add(root.val);
        //子节点
        List<Node> children = root.children;
        //如果存在
        if (children != null && children.isEmpty() == false) {
            //循环
            for (Node child : children) {
                //结果
                List<Integer> list = preorder(child);
                //组装
                result.addAll(list);
            }
        }
        //返回
        return result;
    }

}
