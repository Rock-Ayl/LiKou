package normal31;

import java.util.*;

/**
 * @Author ayl
 * @Date 2024-04-26
 * <p>
 * 代码
 * 测试用例
 * 测试结果
 * 测试结果
 * 2192. 有向无环图中一个节点的所有祖先
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个正整数 n ，它表示一个 有向无环图 中节点的数目，节点编号为 0 到 n - 1 （包括两者）。
 * <p>
 * 给你一个二维整数数组 edges ，其中 edges[i] = [fromi, toi] 表示图中一条从 fromi 到 toi 的单向边。
 * <p>
 * 请你返回一个数组 answer，其中 answer[i]是第 i 个节点的所有 祖先 ，这些祖先节点 升序 排序。
 * <p>
 * 如果 u 通过一系列边，能够到达 v ，那么我们称节点 u 是节点 v 的 祖先 节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 8, edgeList = [[0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]]
 * 输出：[[],[],[],[0,1],[0,2],[0,1,3],[0,1,2,3,4],[0,1,2,3]]
 * 解释：
 * 上图为输入所对应的图。
 * - 节点 0 ，1 和 2 没有任何祖先。
 * - 节点 3 有 2 个祖先 0 和 1 。
 * - 节点 4 有 2 个祖先 0 和 2 。
 * - 节点 5 有 3 个祖先 0 ，1 和 3 。
 * - 节点 6 有 5 个祖先 0 ，1 ，2 ，3 和 4 。
 * - 节点 7 有 4 个祖先 0 ，1 ，2 和 3 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 5, edgeList = [[0,1],[0,2],[0,3],[0,4],[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * 输出：[[],[0],[0,1],[0,1,2],[0,1,2,3]]
 * 解释：
 * 上图为输入所对应的图。
 * - 节点 0 没有任何祖先。
 * - 节点 1 有 1 个祖先 0 。
 * - 节点 2 有 2 个祖先 0 和 1 。
 * - 节点 3 有 3 个祖先 0 ，1 和 2 。
 * - 节点 4 有 4 个祖先 0 ，1 ，2 和 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * 0 <= edges.length <= min(2000, n * (n - 1) / 2)
 * edges[i].length == 2
 * 0 <= fromi, toi <= n - 1
 * fromi != toi
 * 图中不会有重边。
 * 图是 有向 且 无环 的。
 */
public class Code6 {

    //节点
    private static class Node {

        //本节点数字
        private Integer value;

        //上级节点集合
        private Set<Node> lastNodeSet = new HashSet<>();

        //下级节点集合
        private Set<Node> nextNodeSet = new HashSet<>();

        //所有父亲的集合
        private Set<Integer> allFatherSet = new HashSet<>();

        //出事还
        public Node(Integer value) {
            this.value = value;
        }

    }

    //递归结果
    private void next(Node node, Node lastNode) {
        //父级的父亲,就是孩子的父亲
        node.allFatherSet.addAll(lastNode.allFatherSet);
        //还有父亲本身
        node.allFatherSet.add(lastNode.value);
        //然后取消二者的关系
        node.lastNodeSet.remove(lastNode);
        //如果其还有父亲
        if (node.lastNodeSet.isEmpty() == false) {
            //先行跳过,等没有父亲了再走下去(这样就能保证树结构每个节点只走一次子节点)
            return;
        }
        //循环所有下一级
        for (Node nextNode : node.nextNodeSet) {
            //递归
            next(nextNode, node);
        }
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        //顶级节点集合
        Set<Node> firstNodeSet = new HashSet<>();
        //初始化节点数组
        Node[] nodeArr = new Node[n];
        //循环
        for (int i = 0; i < n; i++) {
            //初始化新节点
            Node node = new Node(i);
            //记录
            nodeArr[i] = node;
            //初始化为顶级节点
            firstNodeSet.add(node);
        }
        //循环
        for (int[] edge : edges) {
            //获取父亲、孩子
            Node father = nodeArr[edge[0]];
            Node child = nodeArr[edge[1]];
            //该节点无法做顶级节点了
            firstNodeSet.remove(child);
            //关联二者
            father.nextNodeSet.add(child);
            child.lastNodeSet.add(father);
        }
        //循环
        for (Node firstNode : firstNodeSet) {
            //循环2
            for (Node secondNode : firstNode.nextNodeSet) {
                //从第二级递归
                next(secondNode, firstNode);
            }
        }
        //初始化结果
        List<List<Integer>> result = new ArrayList<>();
        //循环
        for (int i = 0; i < n; i++) {
            //获取该节点的结果,转为列表
            List<Integer> allFatherList = new ArrayList<>(nodeArr[i].allFatherSet);
            //排序
            Collections.sort(allFatherList);
            //组装
            result.add(allFatherList);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> resultList = new Code6().getAncestors(
                8,
                new int[][]{
                        new int[]{0, 3},
                        new int[]{0, 4},
                        new int[]{1, 3},
                        new int[]{2, 4},
                        new int[]{2, 7},
                        new int[]{3, 5},
                        new int[]{3, 6},
                        new int[]{3, 7},
                        new int[]{4, 6}
                }
        );
        System.out.println();
    }

}
