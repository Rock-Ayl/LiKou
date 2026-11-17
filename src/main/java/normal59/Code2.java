package normal59;

import java.util.Arrays;

/**
 * 3567. 子矩阵的最小绝对差
 * 算术评级: 4
 * 第 452 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1568
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 m x n 的整数矩阵 grid 和一个整数 k。
 * <p>
 * 对于矩阵 grid 中的每个连续的 k x k 子矩阵，计算其中任意两个 不同值 之间的 最小绝对差 。
 * <p>
 * 返回一个大小为 (m - k + 1) x (n - k + 1) 的二维数组 ans，其中 ans[i][j] 表示以 grid 中坐标 (i, j) 为左上角的子矩阵的最小绝对差。
 * <p>
 * 注意：如果子矩阵中的所有元素都相同，则答案为 0。
 * <p>
 * 子矩阵 (x1, y1, x2, y2) 是一个由选择矩阵中所有满足 x1 <= x <= x2 且 y1 <= y <= y2 的单元格 matrix[x][y] 组成的矩阵。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： grid = [[1,8],[3,-2]], k = 2
 * <p>
 * 输出： [[2]]
 * <p>
 * 解释：
 * <p>
 * 只有一个可能的 k x k 子矩阵：[[1, 8], [3, -2]]。
 * 子矩阵中的不同值为 [1, 8, 3, -2]。
 * 子矩阵中的最小绝对差为 |1 - 3| = 2。因此，答案为 [[2]]。
 * 示例 2：
 * <p>
 * 输入： grid = [[3,-1]], k = 1
 * <p>
 * 输出： [[0,0]]
 * <p>
 * 解释：
 * <p>
 * 每个 k x k 子矩阵中只有一个不同的元素。
 * 因此，答案为 [[0, 0]]。
 * 示例 3：
 * <p>
 * 输入： grid = [[1,-2,3],[2,3,5]], k = 2
 * <p>
 * 输出： [[1,2]]
 * <p>
 * 解释：
 * <p>
 * 有两个可能的 k × k 子矩阵：
 * 以 (0, 0) 为起点的子矩阵：[[1, -2], [2, 3]]。
 * 子矩阵中的不同值为 [1, -2, 2, 3]。
 * 子矩阵中的最小绝对差为 |1 - 2| = 1。
 * 以 (0, 1) 为起点的子矩阵：[[-2, 3], [3, 5]]。
 * 子矩阵中的不同值为 [-2, 3, 5]。
 * 子矩阵中的最小绝对差为 |3 - 5| = 2。
 * 因此，答案为 [[1, 2]]。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= m == grid.length <= 30
 * 1 <= n == grid[i].length <= 30
 * -105 <= grid[i][j] <= 105
 * 1 <= k <= min(m, n)
 */
public class Code2 {

    public int[][] minAbsDiff(int[][] grid, int k) {
        //结果
        int[][] result = new int[grid.length - k + 1][grid[0].length - k + 1];
        //循环1
        for (int i = 0; i < result.length; i++) {
            //循环
            for (int j = 0; j < result[0].length; j++) {
                //本次数组
                int[] arr = new int[k * k];
                //索引
                int index = 0;
                //循环3
                for (int l = i; l < i + k; l++) {
                    //循环4
                    for (int m = j; m < j + k; m++) {
                        //本次
                        arr[index++] = grid[l][m];
                    }
                }
                //排序
                Arrays.sort(arr);
                //最小绝对差
                int min = Integer.MAX_VALUE;
                //循环
                for (int c = 1; c < arr.length; c++) {
                    //本次差
                    int abs = arr[c] - arr[c - 1];
                    //如果相同的
                    if (abs == 0) {
                        //本轮过
                        continue;
                    }
                    //刷新
                    min = Math.min(min, abs);
                }
                //赋值
                result[i][j] = min == Integer.MAX_VALUE ? 0 : min;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[][] ints = new Code2().minAbsDiff(
                new int[][]{
                        {1, -2, 3},
                        {2, 3, 5}
                }, 2);
        System.out.println();
    }

}
