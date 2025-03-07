package normal37;

import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2024-11-22
 * 2497. 图中最大星和
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 n 个点的无向图，节点从 0 到 n - 1 编号。给你一个长度为 n 下标从 0 开始的整数数组 vals ，其中 vals[i] 表示第 i 个节点的值。
 * <p>
 * 同时给你一个二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示节点 ai 和 bi 之间有一条双向边。
 * <p>
 * 星图 是给定图中的一个子图，它包含一个中心节点和 0 个或更多个邻居。换言之，星图是给定图中一个边的子集，且这些边都有一个公共节点。
 * <p>
 * 下图分别展示了有 3 个和 4 个邻居的星图，蓝色节点为中心节点。
 * <p>
 * <p>
 * <p>
 * 星和 定义为星图中所有节点值的和。
 * <p>
 * 给你一个整数 k ，请你返回 至多 包含 k 条边的星图中的 最大星和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：vals = [1,2,3,4,10,-10,-20], edges = [[0,1],[1,2],[1,3],[3,4],[3,5],[3,6]], k = 2
 * 输出：16
 * 解释：上图展示了输入示例。
 * 最大星和对应的星图在上图中用蓝色标出。中心节点是 3 ，星图中还包含邻居 1 和 4 。
 * 无法得到一个和大于 16 且边数不超过 2 的星图。
 * 示例 2：
 * <p>
 * 输入：vals = [-5], edges = [], k = 0
 * 输出：-5
 * 解释：只有一个星图，就是节点 0 自己。
 * 所以我们返回 -5 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == vals.length
 * 1 <= n <= 105
 * -104 <= vals[i] <= 104
 * 0 <= edges.length <= min(n * (n - 1) / 2, 105)
 * edges[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * 0 <= k <= n - 1
 */
public class Code18 {

    public int maxStarSum(int[] vals, int[][] edges, int k) {
        //优先队列集合
        PriorityQueue<Integer>[] nodeSumArr = new PriorityQueue[vals.length];
        //循环
        for (int i = 0; i < vals.length; i++) {
            //初始化优先队列
            nodeSumArr[i] = new PriorityQueue<>((a, b) -> b - a);
        }
        //循环
        for (int[] edge : edges) {
            //叠加
            if (vals[edge[1]] > 0) {
                //记录
                nodeSumArr[edge[0]].add(vals[edge[1]]);
            }
            //叠加
            if (vals[edge[0]] > 0) {
                //记录
                nodeSumArr[edge[1]].add(vals[edge[0]]);
            }
        }
        //最大可能
        int maxSum = Integer.MIN_VALUE;
        //循环
        for (int i = 0; i < nodeSumArr.length; i++) {
            //对应优先队列队列
            PriorityQueue<Integer> queue = nodeSumArr[i];
            //初始化本次和，为当前节点值
            int sum = vals[i];
            //已使用节点数量
            int count = 0;
            //如果还可以加节点
            while (count++ < k && queue.isEmpty() == false) {
                //叠加本次
                sum += queue.poll();
            }
            //刷新最大结果
            maxSum = Math.max(maxSum, sum);
        }
        //返回
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new Code18().maxStarSum(new int[]{1, 2, 3, 4, 10, -10, -20}, new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{3, 4},
                new int[]{3, 5},
                new int[]{3, 6}
        }, 2));
    }


}
