package normal18;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2022-12-18
 * 2482. 行和列中一和零的差值
 * 给你一个下标从 0 开始的 m x n 二进制矩阵 grid 。
 * <p>
 * 我们按照如下过程，定义一个下标从 0 开始的 m x n 差值矩阵 diff ：
 * <p>
 * 令第 i 行一的数目为 onesRowi 。
 * 令第 j 列一的数目为 onesColj 。
 * 令第 i 行零的数目为 zerosRowi 。
 * 令第 j 列零的数目为 zerosColj 。
 * diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj
 * 请你返回差值矩阵 diff 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[0,1,1],[1,0,1],[0,0,1]]
 * 输出：[[0,0,4],[0,0,4],[-2,-2,2]]
 * 解释：
 * - diff[0][0] = onesRow0 + onesCol0 - zerosRow0 - zerosCol0 = 2 + 1 - 1 - 2 = 0
 * - diff[0][1] = onesRow0 + onesCol1 - zerosRow0 - zerosCol1 = 2 + 1 - 1 - 2 = 0
 * - diff[0][2] = onesRow0 + onesCol2 - zerosRow0 - zerosCol2 = 2 + 3 - 1 - 0 = 4
 * - diff[1][0] = onesRow1 + onesCol0 - zerosRow1 - zerosCol0 = 2 + 1 - 1 - 2 = 0
 * - diff[1][1] = onesRow1 + onesCol1 - zerosRow1 - zerosCol1 = 2 + 1 - 1 - 2 = 0
 * - diff[1][2] = onesRow1 + onesCol2 - zerosRow1 - zerosCol2 = 2 + 3 - 1 - 0 = 4
 * - diff[2][0] = onesRow2 + onesCol0 - zerosRow2 - zerosCol0 = 1 + 1 - 2 - 2 = -2
 * - diff[2][1] = onesRow2 + onesCol1 - zerosRow2 - zerosCol1 = 1 + 1 - 2 - 2 = -2
 * - diff[2][2] = onesRow2 + onesCol2 - zerosRow2 - zerosCol2 = 1 + 3 - 2 - 0 = 2
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,1,1],[1,1,1]]
 * 输出：[[5,5,5],[5,5,5]]
 * 解释：
 * - diff[0][0] = onesRow0 + onesCol0 - zerosRow0 - zerosCol0 = 3 + 2 - 0 - 0 = 5
 * - diff[0][1] = onesRow0 + onesCol1 - zerosRow0 - zerosCol1 = 3 + 2 - 0 - 0 = 5
 * - diff[0][2] = onesRow0 + onesCol2 - zerosRow0 - zerosCol2 = 3 + 2 - 0 - 0 = 5
 * - diff[1][0] = onesRow1 + onesCol0 - zerosRow1 - zerosCol0 = 3 + 2 - 0 - 0 = 5
 * - diff[1][1] = onesRow1 + onesCol1 - zerosRow1 - zerosCol1 = 3 + 2 - 0 - 0 = 5
 * - diff[1][2] = onesRow1 + onesCol2 - zerosRow1 - zerosCol2 = 3 + 2 - 0 - 0 = 5
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 105
 * 1 <= m * n <= 105
 * grid[i][j] 要么是 0 ，要么是 1 。
 */
public class Code2 {

    public int[][] onesMinusZeros(int[][] grid) {
        //结果
        int[][] result = new int[grid.length][grid[0].length];
        //缓存
        int[] link = new int[grid[0].length];
        int[] linkZero = new int[grid[0].length];
        int[] row = new int[grid.length];
        int[] rowZero = new int[grid.length];
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //计算1
            row[i] = Arrays.stream(grid[i]).sum();
            //计算0
            rowZero[i] = grid[0].length - row[i];
        }
        //循环1
        for (int i = 0; i < grid[0].length; i++) {
            //1的数量
            int count = 0;
            //循环2
            for (int j = 0; j < grid.length; j++) {
                //如果是
                if (grid[j][i] == 1) {
                    //叠加
                    count++;
                }
            }
            //计算1
            link[i] = count;
            //计算0
            linkZero[i] = grid.length - count;
        }
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //计算结果
                result[i][j] = link[j] + row[i] - linkZero[j] - rowZero[i];
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        new Code2().onesMinusZeros(new int[][]{
                new int[]{0, 1, 1},
                new int[]{1, 0, 1},
                new int[]{0, 0, 1}
        });
    }

}
