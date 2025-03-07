package normal40;

import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2025-03-04
 * 3462. 提取至多 K 个元素的最大总和
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个大小为 n x m 的二维矩阵 grid ，以及一个长度为 n 的整数数组 limits ，和一个整数 k 。你的目标是从矩阵 grid 中提取出 至多 k 个元素，并计算这些元素的最大总和，提取时需满足以下限制：
 * <p>
 * 从 grid 的第 i 行提取的元素数量不超过 limits[i] 。
 * <p>
 * 返回最大总和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,2],[3,4]], limits = [1,2], k = 2
 * <p>
 * 输出：7
 * <p>
 * 解释：
 * <p>
 * 从第 2 行提取至多 2 个元素，取出 4 和 3 。
 * 至多提取 2 个元素时的最大总和 4 + 3 = 7 。
 * 示例 2：
 * <p>
 * 输入：grid = [[5,3,7],[8,2,6]], limits = [2,2], k = 3
 * <p>
 * 输出：21
 * <p>
 * 解释：
 * <p>
 * 从第 1 行提取至多 2 个元素，取出 7 。
 * 从第 2 行提取至多 2 个元素，取出 8 和 6 。
 * 至多提取 3 个元素时的最大总和 7 + 8 + 6 = 21 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length == limits.length
 * m == grid[i].length
 * 1 <= n, m <= 500
 * 0 <= grid[i][j] <= 105
 * 0 <= limits[i] <= m
 * 0 <= k <= min(n * m, sum(limits))
 */
public class Code20 {

    public long maxSum(int[][] grid, int[] limits, int k) {
        //所有优先队列
        PriorityQueue<Integer> allQueue = new PriorityQueue<>((a, b) -> b - a);
        //当前优先队列
        PriorityQueue<Integer> thisQueue = new PriorityQueue<>((a, b) -> b - a);
        //循环
        for (int i = 0; i < grid.length; i++) {
            //先清除原有队列
            thisQueue.clear();
            //循环元素数组
            for (int num : grid[i]) {
                //组装到当前优先队列
                thisQueue.add(num);
            }
            //获取所需数量
            int limit = limits[i];
            //循环,如果需要
            while (limit-- > 0 && thisQueue.isEmpty() == false) {
                //拉取、加入至所有队列
                allQueue.add(thisQueue.poll());
            }
        }
        //结果
        long result = 0L;
        //循环
        for (int i = 0; i < k; i++) {
            //叠加本次最大结果
            result += allQueue.poll();
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code20().maxSum(new int[][]{
                new int[]{5, 3, 7},
                new int[]{8, 2, 6}
        }, new int[]{2, 2}, 3));
    }

}
