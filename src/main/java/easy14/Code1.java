package easy14;

import java.util.List;

/**
 * @Author ayl
 * @Date 2021-10-31
 * 559. N 叉树的最大深度
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树的深度不会超过 1000 。
 * 树的节点数目位于 [0, 104] 之间。
 */
public class Code1 {

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


    public int next(Node root, int size) {
        //判空
        if (root == null) {
            //返回
            return size;
        }
        //子级
        List<Node> children = root.children;
        //如果存在子级
        if (children != null && children.isEmpty() == false) {
            //记录
            int num = size;
            //循环
            for (Node child : children) {
                //深度
                int thisDeep = next(child, size + 1);
                //如果超过
                if (thisDeep > num) {
                    //记录
                    num = thisDeep;
                }
            }
            //如果深度有更新
            if (num > size) {
                //刷新
                size = num;
            }
        }
        //返回
        return size;
    }

    public int maxDepth(Node root) {
        //判空
        if (root == null) {
            //默认
            return 0;
        }
        //下一级
        return next(root, 1);
    }

}
