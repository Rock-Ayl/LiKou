package normal25;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2023-11-14
 * 2684. 矩阵中移动的最大次数
 * 提示
 * 中等
 * 10
 * 相关企业
 * 给你一个下标从 0 开始、大小为 m x n 的矩阵 grid ，矩阵由若干 正 整数组成。
 * <p>
 * 你可以从矩阵第一列中的 任一 单元格出发，按以下方式遍历 grid ：
 * <p>
 * 从单元格 (row, col) 可以移动到 (row - 1, col + 1)、(row, col + 1) 和 (row + 1, col + 1) 三个单元格中任一满足值 严格 大于当前单元格的单元格。
 * 返回你在矩阵中能够 移动 的 最大 次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
 * 输出：3
 * 解释：可以从单元格 (0, 0) 开始并且按下面的路径移动：
 * - (0, 0) -> (0, 1).
 * - (0, 1) -> (1, 2).
 * - (1, 2) -> (2, 3).
 * 可以证明这是能够移动的最大次数。
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[3,2,4],[2,1,9],[1,1,7]]
 * 输出：0
 * 解释：从第一列的任一单元格开始都无法移动。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 1000
 * 4 <= m * n <= 105
 * 1 <= grid[i][j] <= 106
 */
public class Code25 {

    public int maxMoves(int[][] grid) {
        //初始化
        int[][] arr = new int[grid.length][grid[0].length];
        //默认
        for (int i = 0; i < grid.length; i++) {
            //从这里出发
            arr[i][0] = 1;
        }
        //循环1
        for (int j = 1; j < grid[0].length; j++) {
            //循环
            for (int i = 0; i < grid.length; i++) {
                //上 如果未越界 and 有路线 and 可以走到这里
                if (i - 1 >= 0 && arr[i - 1][j - 1] > 0 && grid[i - 1][j - 1] < grid[i][j]) {
                    //走
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                }
                //中 有路线 and 可以走到这里
                if (arr[i][j - 1] > 0 && grid[i][j - 1] < grid[i][j]) {
                    //走、找最大路线
                    arr[i][j] = Math.max(arr[i][j - 1] + 1, arr[i][j]);
                }
                //下 如果未越界 and 有路线 and 可以走到这里
                if (i + 1 < grid.length && arr[i + 1][j - 1] > 0 && grid[i + 1][j - 1] < grid[i][j]) {
                    //走
                    arr[i][j] = arr[i + 1][j - 1] + 1;
                }
            }
        }
        //最大情况
        return Arrays.stream(arr).map(p -> Arrays.stream(p).max().getAsInt()).mapToInt(Integer::intValue).max().getAsInt() - 1;
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
        System.out.println(new Code25().maxMoves(new int[][]{
                new int[]{2, 4, 3, 5},
                new int[]{5, 4, 9, 3},
                new int[]{3, 4, 2, 11},
                new int[]{10, 9, 13, 15}
        }));
    }

}
