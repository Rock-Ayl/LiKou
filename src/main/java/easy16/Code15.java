package easy16;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-12-17
 * 590. N 叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的 后序遍历 。
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
 * 输出：[5,6,3,2,4,1]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * N 叉树的高度小于或等于 1000
 * 节点总数在范围 [0, 10^4] 内
 */
public class Code15 {

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

    public List<Integer> postorder(Node root) {
        //初始化
        List<Integer> result = new ArrayList<>();
        //判空
        if (root == null) {
            //返回
            return result;
        }
        //孩子列表
        List<Node> children = root.children;
        //如果存在孩子
        if (children != null && children.size() > 0) {
            //循环
            for (Node child : children) {
                //组装结果
                result.addAll(postorder(child));
            }
        }
        //组装本身
        result.add(root.val);
        //返回
        return result;
    }


}
