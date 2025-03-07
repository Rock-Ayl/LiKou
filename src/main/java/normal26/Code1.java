package normal26;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2023-11-15
 * 2304. 网格中的最小路径代价
 * 提示
 * 中等
 * 19
 * 相关企业
 * 给你一个下标从 0 开始的整数矩阵 grid ，矩阵大小为 m x n ，由从 0 到 m * n - 1 的不同整数组成。你可以在此矩阵中，从一个单元格移动到 下一行 的任何其他单元格。如果你位于单元格 (x, y) ，且满足 x < m - 1 ，你可以移动到 (x + 1, 0), (x + 1, 1), ..., (x + 1, n - 1) 中的任何一个单元格。注意： 在最后一行中的单元格不能触发移动。
 * <p>
 * 每次可能的移动都需要付出对应的代价，代价用一个下标从 0 开始的二维数组 moveCost 表示，该数组大小为 (m * n) x n ，其中 moveCost[i][j] 是从值为 i 的单元格移动到下一行第 j 列单元格的代价。从 grid 最后一行的单元格移动的代价可以忽略。
 * <p>
 * grid 一条路径的代价是：所有路径经过的单元格的 值之和 加上 所有移动的 代价之和 。从 第一行 任意单元格出发，返回到达 最后一行 任意单元格的最小路径代价。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[5,3],[4,0],[2,1]], moveCost = [[9,8],[1,5],[10,12],[18,6],[2,4],[14,3]]
 * 输出：17
 * 解释：最小代价的路径是 5 -> 0 -> 1 。
 * - 路径途经单元格值之和 5 + 0 + 1 = 6 。
 * - 从 5 移动到 0 的代价为 3 。
 * - 从 0 移动到 1 的代价为 8 。
 * 路径总代价为 6 + 3 + 8 = 17 。
 * 示例 2：
 * <p>
 * 输入：grid = [[5,1,2],[4,0,3]], moveCost = [[12,10,15],[20,23,8],[21,7,1],[8,1,13],[9,10,25],[5,3,2]]
 * 输出：6
 * 解释：
 * 最小代价的路径是 2 -> 3 。
 * - 路径途经单元格值之和 2 + 3 = 5 。
 * - 从 2 移动到 3 的代价为 1 。
 * 路径总代价为 5 + 1 = 6 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 50
 * grid 由从 0 到 m * n - 1 的不同整数组成
 * moveCost.length == m * n
 * moveCost[i].length == n
 * 1 <= moveCost[i][j] <= 100
 */
public class Code1 {

    public int minPathCost(int[][] grid, int[][] moveCost) {
        //初始化结果
        int[][] result = new int[grid.length][grid[0].length];
        //循环
        for (int j = 0; j < grid[0].length; j++) {
            //记录默认起始消费
            result[0][j] = grid[0][j];
        }
        //循环1
        for (int i = 1; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //最小路径
                int minLink = Integer.MAX_VALUE;
                //循环3
                for (int k = 0; k < grid[0].length; k++) {
                    //当前路径和的三个值
                    int a = result[i - 1][k];
                    int b = moveCost[grid[i - 1][k]][j];
                    int c = grid[i][j];
                    //计算和,就是到这里的消费
                    int thisLink = a + b + c;
                    //刷新最小情况
                    minLink = Math.min(minLink, thisLink);
                }
                //记录
                result[i][j] = minLink;
            }
        }
        //返回最后一行最小的
        return Arrays.stream(result[result.length - 1]).min().getAsInt();
    }

    private void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.println();
        }
        System.out.println("#############");
    }

    public static void main(String[] args) {
        System.out.println(new Code1().minPathCost(new int[][]{
                new int[]{5, 3},
                new int[]{4, 0},
                new int[]{2, 1}
        }, new int[][]{
                new int[]{9, 8},
                new int[]{1, 5},
                new int[]{10, 12},
                new int[]{18, 6},
                new int[]{2, 4},
                new int[]{14, 3}
        }));
    }

}
