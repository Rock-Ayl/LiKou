package normal21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-06-18
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 * <p>
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回：
 * <p>
 * [3,9,20,15,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 */
public class Code5 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //缓存
    private Map<Integer, List<Integer>> map = new HashMap<>();

    //走下去
    public void next(TreeNode node, int deep) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //获取列表
        List<Integer> list = map.getOrDefault(deep, new ArrayList<>());
        //记录值
        list.add(node.val);
        //组装
        map.put(deep, list);
        //下一步
        next(node.left, deep + 1);
        next(node.right, deep + 1);
    }

    public int[] levelOrder(TreeNode root) {
        //从下去
        next(root, 0);
        //初始化结果
        List<Integer> result = new ArrayList<>();
        //指针
        int p = 0;
        //如果还有
        while (map.containsKey(p)) {
            //组装所有
            result.addAll(map.get(p++));
        }
        //返回结果
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

    }

}
