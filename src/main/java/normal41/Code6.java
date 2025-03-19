package normal41;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2025-03-19
 * 1042. 不邻接植花
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 有 n 个花园，按从 1 到 n 标记。另有数组 paths ，其中 paths[i] = [xi, yi] 描述了花园 xi 到花园 yi 的双向路径。在每个花园中，你打算种下四种花之一。
 * <p>
 * 另外，所有花园 最多 有 3 条路径可以进入或离开.
 * <p>
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 * <p>
 * 以数组形式返回 任一 可行的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1、2、3、4 表示。保证存在答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, paths = [[1,2],[2,3],[3,1]]
 * 输出：[1,2,3]
 * 解释：
 * 花园 1 和 2 花的种类不同。
 * 花园 2 和 3 花的种类不同。
 * 花园 3 和 1 花的种类不同。
 * 因此，[1,2,3] 是一个满足题意的答案。其他满足题意的答案有 [1,2,4]、[1,4,2] 和 [3,2,1]
 * 示例 2：
 * <p>
 * 输入：n = 4, paths = [[1,2],[3,4]]
 * 输出：[1,2,1,2]
 * 示例 3：
 * <p>
 * 输入：n = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * 输出：[1,2,3,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 104
 * 0 <= paths.length <= 2 * 104
 * paths[i].length == 2
 * 1 <= xi, yi <= n
 * xi != yi
 * 每个花园 最多 有 3 条路径可以进入或离开
 */
public class Code6 {

    /**
     * 花园实体
     */
    private static class Node {

        //数字
        private int num;

        //关联节点
        private Set<Node> linkSet = new HashSet<>(3);

        //初始化
        public Node(int num) {
            this.num = num;
        }

        /**
         * 关联两个节点
         */
        public static void link(Node a, Node b) {
            //关联
            a.linkSet.add(b);
            b.linkSet.add(a);
        }

        /**
         * 方便调试
         */
        @Override
        public String toString() {
            return Integer.valueOf(this.num).toString();
        }

    }

    public int[] gardenNoAdj(int n, int[][] paths) {
        //结果
        int[] result = new int[n];
        //结果
        Node[] nodeArr = new Node[n];
        //循环
        for (int i = 0; i < n; i++) {
            //初始化
            nodeArr[i] = new Node(i);
        }
        //循环
        for (int[] path : paths) {
            //关联
            Node.link(nodeArr[path[0] - 1], nodeArr[path[1] - 1]);
        }
        //循环
        for (int i = 0; i < nodeArr.length; i++) {
            //获取当前颜色
            Node node = nodeArr[i];
            //如果当前染色了
            if (result[node.num] != 0) {
                //本轮过
                continue;
            }
            //构建所有可选项
            Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4));
            //循环
            for (Node otherNode : node.linkSet) {
                //删除已使用颜色
                set.remove(result[otherNode.num]);
            }
            //随机使用一个颜色
            result[node.num] = set.stream().findFirst().get();
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new Code6().gardenNoAdj(3, new int[][]{
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{3, 1}
        });
        System.out.println();
    }

}
