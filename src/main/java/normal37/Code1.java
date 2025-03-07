package normal37;

import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2024-11-03
 * 3275. 第 K 近障碍物查询
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 有一个无限大的二维平面。
 * <p>
 * 给你一个正整数 k ，同时给你一个二维数组 queries ，包含一系列查询：
 * <p>
 * queries[i] = [x, y] ：在平面上坐标 (x, y) 处建一个障碍物，数据保证之前的查询 不会 在这个坐标处建立任何障碍物。
 * 每次查询后，你需要找到离原点第 k 近 障碍物到原点的 距离 。
 * <p>
 * 请你返回一个整数数组 results ，其中 results[i] 表示建立第 i 个障碍物以后，离原地第 k 近障碍物距离原点的距离。如果少于 k 个障碍物，results[i] == -1 。
 * <p>
 * 注意，一开始 没有 任何障碍物。
 * <p>
 * 坐标在 (x, y) 处的点距离原点的距离定义为 |x| + |y| 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：queries = [[1,2],[3,4],[2,3],[-3,0]], k = 2
 * <p>
 * 输出：[-1,7,5,3]
 * <p>
 * 解释：
 * <p>
 * 最初，不存在障碍物。
 * <p>
 * queries[0] 之后，少于 2 个障碍物。
 * queries[1] 之后， 两个障碍物距离原点的距离分别为 3 和 7 。
 * queries[2] 之后，障碍物距离原点的距离分别为 3 ，5 和 7 。
 * queries[3] 之后，障碍物距离原点的距离分别为 3，3，5 和 7 。
 * 示例 2：
 * <p>
 * 输入：queries = [[5,5],[4,4],[3,3]], k = 1
 * <p>
 * 输出：[10,8,6]
 * <p>
 * 解释：
 * <p>
 * queries[0] 之后，只有一个障碍物，距离原点距离为 10 。
 * queries[1] 之后，障碍物距离原点距离分别为 8 和 10 。
 * queries[2] 之后，障碍物距离原点的距离分别为 6， 8 和10 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= queries.length <= 2 * 105
 * 所有 queries[i] 互不相同。
 * -109 <= queries[i][0], queries[i][1] <= 109
 * 1 <= k <= 105
 */
public class Code1 {

    public int[] resultsArray(int[][] queries, int k) {
        //优先队列
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        //初始化结果
        int[] result = new int[queries.length];
        //循环
        for (int i = 0; i < result.length; i++) {
            //获取对应障碍物
            int[] query = queries[i];
            //求和
            int sum = Math.abs(query[0]) + Math.abs(query[1]);
            //装载本次数字
            queue.add(sum);
            //如果满了
            if (queue.size() > k) {
                //弹出一个最大的
                queue.poll();
            }
            //记录本次结果
            result[i] = queue.size() == k ? queue.peek() : -1;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        new Code1().resultsArray(new int[][]{
                new int[]{1, 2},
                new int[]{3, 4},
                new int[]{2, 3},
                new int[]{-3, 0}
        }, 2);
    }

}
