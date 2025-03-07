package normal40;

/**
 * @Author ayl
 * @Date 2025-02-25
 * 2374. 边积分最高的节点
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个有向图，图中有 n 个节点，节点编号从 0 到 n - 1 ，其中每个节点都 恰有一条 出边。
 * <p>
 * 图由一个下标从 0 开始、长度为 n 的整数数组 edges 表示，其中 edges[i] 表示存在一条从节点 i 到节点 edges[i] 的 有向 边。
 * <p>
 * 节点 i 的 边积分 定义为：所有存在一条指向节点 i 的边的节点的 编号 总和。
 * <p>
 * 返回 边积分 最高的节点。如果多个节点的 边积分 相同，返回编号 最小 的那个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：edges = [1,0,0,0,0,7,7,5]
 * 输出：7
 * 解释：
 * - 节点 1、2、3 和 4 都有指向节点 0 的边，节点 0 的边积分等于 1 + 2 + 3 + 4 = 10 。
 * - 节点 0 有一条指向节点 1 的边，节点 1 的边积分等于 0 。
 * - 节点 7 有一条指向节点 5 的边，节点 5 的边积分等于 7 。
 * - 节点 5 和 6 都有指向节点 7 的边，节点 7 的边积分等于 5 + 6 = 11 。
 * 节点 7 的边积分最高，所以返回 7 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：edges = [2,0,0,2]
 * 输出：0
 * 解释：
 * - 节点 1 和 2 都有指向节点 0 的边，节点 0 的边积分等于 1 + 2 = 3 。
 * - 节点 0 和 3 都有指向节点 2 的边，节点 2 的边积分等于 0 + 3 = 3 。
 * 节点 0 和 2 的边积分都是 3 。由于节点 0 的编号更小，返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == edges.length
 * 2 <= n <= 105
 * 0 <= edges[i] < n
 * edges[i] != i
 */
public class Code13 {

    public int edgeScore(int[] edges) {
        //分数缓存
        long[] rankArr = new long[edges.length];
        //最大结果、最大结果的索引
        long max = -1;
        int maxIndex = -1;
        //循环
        for (int i = 0; i < edges.length; i++) {
            //叠加分数
            rankArr[edges[i]] += i;
            //如果更大
            if (rankArr[edges[i]] > max) {
                //更新更大
                max = rankArr[edges[i]];
                maxIndex = edges[i];
            }
            //如果相同
            else if (rankArr[edges[i]] == max) {
                //刷新更小
                maxIndex = Math.min(edges[i], maxIndex);
            }
        }
        //返回最大
        return maxIndex;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().edgeScore(new int[]{1, 0, 0, 0, 0, 7, 7, 5}));
    }

}
