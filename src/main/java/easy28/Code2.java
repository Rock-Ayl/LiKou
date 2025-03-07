package easy28;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2023-02-12
 * 1252. 奇数值单元格的数目
 * 给你一个 m x n 的矩阵，最开始的时候，每个单元格中的值都是 0。
 * <p>
 * 另有一个二维索引数组 indices，indices[i] = [ri, ci] 指向矩阵中的某个位置，其中 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 * <p>
 * 对 indices[i] 所指向的每个位置，应同时执行下述增量操作：
 * <p>
 * ri 行上的所有单元格，加 1 。
 * ci 列上的所有单元格，加 1 。
 * 给你 m、n 和 indices 。请你在执行完所有 indices 指定的增量操作后，返回矩阵中 奇数值单元格 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：m = 2, n = 3, indices = [[0,1],[1,1]]
 * 输出：6
 * 解释：最开始的矩阵是 [[0,0,0],[0,0,0]]。
 * 第一次增量操作后得到 [[1,2,1],[0,1,0]]。
 * 最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：m = 2, n = 2, indices = [[1,1],[0,0]]
 * 输出：0
 * 解释：最后的矩阵是 [[2,2],[2,2]]，里面没有奇数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 50
 * 1 <= indices.length <= 100
 * 0 <= ri < m
 * 0 <= ci < n
 */
public class Code2 {

    public int oddCells(int m, int n, int[][] indices) {
        //数组
        int[][] arr = new int[m][n];
        //循环
        for (int[] index : indices) {
            //坐标
            int x = index[0];
            int y = index[1];
            //循环
            for (int i = 0; i < arr.length; i++) {
                //计算
                arr[i][y]++;
            }
            //循环
            for (int i = 0; i < arr[0].length; i++) {
                //计算
                arr[x][i]++;
            }
        }
        //结果
        int count = 0;
        //循环1
        for (int[] ints : arr) {
            //循环2
            for (int anInt : ints) {
                //如果是基数
                if (anInt % 2 != 0) {
                    //记录
                    count++;
                }
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().oddCells(2, 3, new int[][]{
                new int[]{0, 1},
                new int[]{1, 1}
        }));
    }
}
