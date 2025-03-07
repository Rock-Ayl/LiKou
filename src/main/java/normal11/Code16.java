package normal11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-02-13
 * 429. N 叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * <p>
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 */
public class Code16 {

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

    //结果集
    Map<Integer, List<Integer>> map = new HashMap<>();

    public void next(Node root, int deep) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //获取当前层级列表
        List<Integer> list = map.getOrDefault(deep, new ArrayList<>());
        //组装新的
        list.add(root.val);
        //组装回去
        map.put(deep, list);
        //获取孩子
        List<Node> children = root.children;
        //如果有值
        if (children != null && children.size() > 0) {
            //下一级深度
            int nextDeep = deep + 1;
            //循环
            for (Node child : children) {
                //下一级
                next(child, nextDeep);
            }
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        //初始化结果
        List<List<Integer>> result = new ArrayList<>();
        //开始计算
        next(root, 0);
        //指针
        int p = 0;
        //如果未越界
        while (p < map.size()) {
            //获取并组装
            result.add(map.get(p++));
        }
        //返回
        return result;
    }

}
