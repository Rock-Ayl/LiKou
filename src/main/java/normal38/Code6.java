package normal38;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2024-12-02
 * 1519. 子树中标签相同的节点数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一棵树（即，一个连通的无环无向图），这棵树由编号从 0  到 n - 1 的 n 个节点组成，且恰好有 n - 1 条 edges 。树的根节点为节点 0 ，树上的每一个节点都有一个标签，也就是字符串 labels 中的一个小写字符（编号为 i 的 节点的标签就是 labels[i] ）
 * <p>
 * 边数组 edges 以 edges[i] = [ai, bi] 的形式给出，该格式表示节点 ai 和 bi 之间存在一条边。
 * <p>
 * 返回一个大小为 n 的数组，其中 ans[i] 表示第 i 个节点的子树中与节点 i 标签相同的节点数。
 * <p>
 * 树 T 中的子树是由 T 中的某个节点及其所有后代节点组成的树。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], labels = "abaedcd"
 * 输出：[2,1,1,1,1,1,1]
 * 解释：节点 0 的标签为 'a' ，以 'a' 为根节点的子树中，节点 2 的标签也是 'a' ，因此答案为 2 。注意树中的每个节点都是这棵子树的一部分。
 * 节点 1 的标签为 'b' ，节点 1 的子树包含节点 1、4 和 5，但是节点 4、5 的标签与节点 1 不同，故而答案为 1（即，该节点本身）。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, edges = [[0,1],[1,2],[0,3]], labels = "bbbb"
 * 输出：[4,2,1,1]
 * 解释：节点 2 的子树中只有节点 2 ，所以答案为 1 。
 * 节点 3 的子树中只有节点 3 ，所以答案为 1 。
 * 节点 1 的子树中包含节点 1 和 2 ，标签都是 'b' ，因此答案为 2 。
 * 节点 0 的子树中包含节点 0、1、2 和 3，标签都是 'b'，因此答案为 4 。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：n = 5, edges = [[0,1],[0,2],[1,3],[0,4]], labels = "aabab"
 * 输出：[3,2,1,1,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^5
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * labels.length == n
 * labels 仅由小写英文字母组成
 */
public class Code6 {

    private static class Node {

        //索引
        private int index;

        //标签
        private char tag;

        //是否走过,默认未没走过
        private boolean walked = false;

        //子节点
        private Set<Node> childSet = new HashSet<>();

        //初始化1
        public Node(int index, char tag) {
            this.index = index;
            this.tag = tag;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("index=%s,tag=%s,childSize=%s", index, tag, childSet.size());
        }

    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {

        /**
         * step 1. 构建节点树
         */

        //初始化节点缓存
        Map<Integer, Node> nodeMap = new HashMap<>();
        //循环1
        for (int i = 0; i < n; i++) {
            //初始化节点
            nodeMap.put(i, new Node(i, labels.charAt(i)));
        }
        //循环2
        for (int i = 0; i < edges.length; i++) {
            //获取2个节点
            Node father = nodeMap.get(edges[i][0]);
            Node child = nodeMap.get(edges[i][1]);
            //关联
            father.childSet.add(child);
            child.childSet.add(father);
        }

        /**
         * step 4. 递归最终结果
         */

        //初始化目标结果
        int[] result = new int[n];
        //从root节点开始递归
        findAndSetSum(result, nodeMap.get(0));
        //返回结果
        return result;
    }

    //递归,并统计
    private Map<Character, Integer> findAndSetSum(int[] result, Node node) {
        //判空
        if (node == null) {
            //过
            return new HashMap<>();
        }
        //如果走过了
        if (node.walked == true) {
            //过
            return new HashMap<>();
        }
        //设置为走过
        node.walked = true;
        //初始化本次
        Map<Character, Integer> resultMap = new HashMap<>();
        //默认
        resultMap.put(node.tag, 1);
        //深度搜索
        for (Node child : node.childSet) {
            //递归并求和
            Map<Character, Integer> childResultMap = findAndSetSum(result, child);
            //循环
            for (Map.Entry<Character, Integer> entry : childResultMap.entrySet()) {
                //覆盖
                resultMap.put(entry.getKey(), resultMap.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }
        }
        //记录本次结果
        result[node.index] = resultMap.get(node.tag);
        //返回
        return resultMap;
    }

    public static void main(String[] args) {
        int[] ints = new Code6().countSubTrees(7, new int[][]{
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{1, 4},
                new int[]{1, 5},
                new int[]{2, 3},
                new int[]{2, 6}
        }, "abaedcd");
        System.out.println();
    }

}
