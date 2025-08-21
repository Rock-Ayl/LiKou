package difficult4;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-08-21
 * 924. 尽量减少恶意软件的传播
 * 算术评级: 7
 * 第 106 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 1869
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给出了一个由 n 个节点组成的网络，用 n × n 个邻接矩阵图 graph 表示。在节点网络中，当 graph[i][j] = 1 时，表示节点 i 能够直接连接到另一个节点 j。
 * <p>
 * 一些节点 initial 最初被恶意软件感染。只要两个节点直接连接，且其中至少一个节点受到恶意软件的感染，那么两个节点都将被恶意软件感染。这种恶意软件的传播将继续，直到没有更多的节点可以被这种方式感染。
 * <p>
 * 假设 M(initial) 是在恶意软件停止传播之后，整个网络中感染恶意软件的最终节点数。
 * <p>
 * 如果从 initial 中移除某一节点能够最小化 M(initial)， 返回该节点。如果有多个节点满足条件，就返回索引最小的节点。
 * <p>
 * 请注意，如果某个节点已从受感染节点的列表 initial 中删除，它以后仍有可能因恶意软件传播而受到感染。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1]
 * 输出：0
 * 示例 2：
 * <p>
 * 输入：graph = [[1,0,0],[0,1,0],[0,0,1]], initial = [0,2]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：graph = [[1,1,1],[1,1,1],[1,1,1]], initial = [1,2]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == graph.length
 * n == graph[i].length
 * 2 <= n <= 300
 * graph[i][j] == 0 或 1.
 * graph[i][j] == graph[j][i]
 * graph[i][i] == 1
 * 1 <= initial.length <= n
 * 0 <= initial[i] <= n - 1
 * initial 中所有整数均不重复
 */
public class Code1 {

    public int minMalwareSpread(int[][] graph, int[] initial) {

        /**
         * 构建并查集
         */

        //初始化并查集
        int[] groupArr = new int[graph.length];
        //循环
        for (int i = 0; i < groupArr.length; i++) {
            //默认分组
            groupArr[i] = i;
        }
        //循环
        for (int i = 0; i < graph.length; i++) {
            //循环2
            for (int j = 0; j < graph[0].length; j++) {
                //如果没有关系
                if (graph[i][j] == 0) {
                    //本轮过
                    continue;
                }
                //如果是自己
                if (i == j) {
                    //本轮过
                    continue;
                }
                //递归并查集
                findAndSet(groupArr, i, j);
            }
        }

        /**
         * 补完并查集
         */

        //循环
        for (int i = 0; i < groupArr.length; i++) {
            //如果是主节点
            if (groupArr[i] == i) {
                //本轮过
                continue;
            }
            //如果其主节点不是主节点
            if (groupArr[i] != groupArr[groupArr[i]]) {
                //递归并查集
                findAndSet(groupArr, groupArr[i], i);
            }
        }

        /**
         * 计算出 每个分组节点数量
         */

        //初始化 每个分组节点数量
        int[] nodeCountArr = new int[graph.length];
        //循环
        for (int i = 0; i < groupArr.length; i++) {
            //+1
            nodeCountArr[groupArr[i]]++;
        }

        /**
         * 计算出 每个分组感染数、每个分组的最小索引的感染节点
         */

        //初始化 每个分组感染数量数组
        int[] infectCountArr = new int[graph.length];
        //初始化 每个分组感染最小索引数组
        int[] infectIndexArr = new int[graph.length];
        //循环
        for (int i : initial) {
            //分组
            int group = groupArr[i];
            //该节点的主节点被感染了
            infectCountArr[group]++;
            //如果没有 or 更小
            if (infectIndexArr[group] == 0 || infectIndexArr[group] > i) {
                //记录
                infectIndexArr[group] = i;
            }
        }

        /**
         * 第一次寻找结果,如果分组越大,并且只有一个节点感染,说明其越是需要删除的目标
         */

        //只有一个感染的分组最大的节点数量
        int maxNodeCount = 0;
        //只有一个感染的分组最大的节点数量-对应分组主节点索引
        int maxNodeCountRootIndex = 0;
        //循环
        for (int i = 0; i < infectCountArr.length; i++) {
            //如果不是只有一个感染的分组
            if (infectCountArr[i] != 1) {
                //本轮过
                continue;
            }
            //获取该分组节点数量
            int nodeCount = nodeCountArr[groupArr[i]];
            //如果没有之前的多
            if (nodeCount < maxNodeCount) {
                //本轮过
                continue;
            }
            //如果相同
            if (nodeCount == maxNodeCount) {
                //如果新分组感染节点更小
                if (infectIndexArr[maxNodeCountRootIndex] > infectIndexArr[i]) {
                    //更新索引
                    maxNodeCountRootIndex = i;
                }
                //本轮过
                continue;
            }
            //更新结果
            maxNodeCount = nodeCount;
            maxNodeCountRootIndex = i;
        }
        //如果存在只有一个感染的、最大节点数量的分组
        if (maxNodeCount > 0) {
            //返回
            return infectIndexArr[maxNodeCountRootIndex];
        }

        /**
         * 第二次寻找结果,如果没有分组只有一个感染节点,那么就返回最小索引的
         */

        //排序
        Arrays.sort(initial);
        //返回
        return initial[0];
    }

    //递归并查集
    private int findAndSet(int[] groupArr, int left, int right) {
        //主节点
        int root;
        //如果其是主节点
        if (groupArr[left] == left) {
            //直接使用
            root = left;
        } else {
            //递归主节点
            root = findAndSet(groupArr, groupArr[left], left);
        }
        //如果右边有关系
        if (groupArr[right] != right) {
            //递归右边
            findAndSet(groupArr, root, groupArr[right]);
        }
        //记录
        groupArr[right] = root;
        //返回
        return root;
    }

    public static void main(String[] args) {

        /*

        System.out.println(new Code1().minMalwareSpread(new int[][]{
                new int[]{1, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 1}
        }, new int[]{0, 1}));

        */

        /*

        System.out.println(new Code1().minMalwareSpread(new int[][]{
                new int[]{1, 0, 0, 0},
                new int[]{0, 1, 0, 0},
                new int[]{0, 0, 1, 1},
                new int[]{0, 0, 1, 1}
        }, new int[]{3, 1}));

        */

        /*

        System.out.println(new Code1().minMalwareSpread(new int[][]{
                new int[]{1, 0, 0, 0, 0, 0},
                new int[]{0, 1, 1, 0, 0, 0},
                new int[]{0, 1, 1, 0, 0, 0},
                new int[]{0, 0, 0, 1, 1, 1},
                new int[]{0, 0, 0, 1, 1, 1},
                new int[]{0, 0, 0, 1, 1, 1}
        }, new int[]{2, 3}));

        */

        /*

        System.out.println(new Code1().minMalwareSpread(new int[][]{
                new int[]{1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                new int[]{0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                new int[]{0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
                new int[]{1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0},
                new int[]{0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                new int[]{0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0},
                new int[]{0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0},
                new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
        }, new int[]{7, 8, 6, 2, 3}));

        */

        /*

        System.out.println(new Code1().minMalwareSpread(new int[][]{
                new int[]{1, 0, 1, 0},
                new int[]{0, 1, 0, 1},
                new int[]{1, 0, 1, 0},
                new int[]{0, 1, 0, 1}
        }, new int[]{2, 1}));

        */

        System.out.println(new Code1().minMalwareSpread(new int[][]{
                new int[]{1, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 1}
        }, new int[]{0, 2}));
    }

}