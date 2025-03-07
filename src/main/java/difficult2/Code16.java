package difficult2;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-07-26
 * 1289. 下降路径最小和 II
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。
 * <p>
 * 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：13
 * 解释：
 * 所有非零偏移下降路径包括：
 * [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 * [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 * [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 * 下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
 * 示例 2：
 * <p>
 * 输入：grid = [[7]]
 * 输出：7
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * -99 <= grid[i][j] <= 99
 */
public class Code16 {

    public int minFallingPathSum(int[][] grid) {
        //数组
        int[][] cacheArr = new int[grid.length][grid[0].length];
        //循环
        for (int j = 0; j < cacheArr[0].length; j++) {
            //初始化第一行
            cacheArr[0][j] = grid[0][j];
        }
        //循环1
        for (int i = 1; i < cacheArr.length; i++) {
            //循环2
            for (int j = 0; j < cacheArr[0].length; j++) {
                //最小可能
                int min = Integer.MAX_VALUE;
                //循环
                for (int k = 0; k < cacheArr[0].length; k++) {
                    //如果相同
                    if (k == j) {
                        //本轮过
                        continue;
                    }
                    //刷新最小情况
                    min = Math.min(min, cacheArr[i - 1][k]);
                }
                //记录
                cacheArr[i][j] = min + grid[i][j];
            }
        }
        //返回
        return Arrays.stream(cacheArr[cacheArr.length - 1]).min().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(new Code16().minFallingPathSum(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        }));
    }

}
