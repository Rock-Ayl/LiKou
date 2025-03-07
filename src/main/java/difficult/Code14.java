package difficult;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2022-08-18
 * 987. 二叉树的垂序遍历
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 * <p>
 * 对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。
 * <p>
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 * <p>
 * 返回二叉树的 垂序遍历 序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[9],[3,15],[20],[7]]
 * 解释：
 * 列 -1 ：只有结点 9 在此列中。
 * 列  0 ：只有结点 3 和 15 在此列中，按从上到下顺序。
 * 列  1 ：只有结点 20 在此列中。
 * 列  2 ：只有结点 7 在此列中。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 列 -2 ：只有结点 4 在此列中。
 * 列 -1 ：只有结点 2 在此列中。
 * 列  0 ：结点 1 、5 和 6 都在此列中。
 * 1 在上面，所以它出现在前面。
 * 5 和 6 位置都是 (2, 0) ，所以按值从小到大排序，5 在 6 的前面。
 * 列  1 ：只有结点 3 在此列中。
 * 列  2 ：只有结点 7 在此列中。
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,6,5,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 这个示例实际上与示例 2 完全相同，只是结点 5 和 6 在树中的位置发生了交换。
 * 因为 5 和 6 的位置仍然相同，所以答案保持不变，仍然按值从小到大排序。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中结点数目总数在范围 [1, 1000] 内
 * 0 <= Node.val <= 1000
 */
public class Code14 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //缓存<x节点,坐标>
    Map<Integer, Integer> nodeXMap = new HashMap<>();
    //<y坐标,节点列表>
    Map<Integer, List<Integer>> yNodeListMap = new HashMap<>();

    //遍历
    public void next(TreeNode node, int x, int y) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //记录
        nodeXMap.put(node.val, x);
        //y坐标节点列表
        List<Integer> yNodeList;
        //如果有了
        if (yNodeListMap.containsKey(y)) {
            //获取已有
            yNodeList = yNodeListMap.get(y);
        } else {
            //初始化
            yNodeList = new ArrayList<>();
            //记录
            yNodeListMap.put(y, yNodeList);
        }
        //组装当前节点
        yNodeList.add(node.val);
        //下一级
        next(node.left, x + 1, y - 1);
        next(node.right, x + 1, y + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //遍历
        next(root, 0, 0);
        //初始化结果列表,长度固定
        List<List<Integer>> result = new ArrayList<>(yNodeListMap.size());
        //获取排序并排列
        List<Integer> yNodeKeySortList = yNodeListMap.keySet()
                .stream()
                .sorted()
                .collect(Collectors.toList());
        //循环
        for (Integer key : yNodeKeySortList) {
            //获取对应节点列表
            List<Integer> nodeList = yNodeListMap.get(key);
            //先排序
            nodeList.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    //获取对应x坐标
                    int o1X = nodeXMap.get(o1);
                    int o2X = nodeXMap.get(o2);
                    //如果x不一致
                    if (o1X != o2X) {
                        //直接对比
                        return o1X - o2X;
                    }
                    //值对比
                    return o1 - o2;
                }
            });
            //组装结果
            result.add(nodeList);
        }
        //返回
        return result;
    }

}
