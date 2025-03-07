package easy38;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2024-08-06
 * 3242. 设计相邻元素求和服务
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 n x n 的二维数组 grid，它包含范围 [0, n2 - 1] 内的不重复元素。
 * <p>
 * 实现 neighborSum 类：
 * <p>
 * neighborSum(int [][]grid) 初始化对象。
 * int adjacentSum(int value) 返回在 grid 中与 value 相邻的元素之和，相邻指的是与 value 在上、左、右或下的元素。
 * int diagonalSum(int value) 返回在 grid 中与 value 对角线相邻的元素之和，对角线相邻指的是与 value 在左上、右上、左下或右下的元素。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * <p>
 * ["neighborSum", "adjacentSum", "adjacentSum", "diagonalSum", "diagonalSum"]
 * <p>
 * [[[[0, 1, 2], [3, 4, 5], [6, 7, 8]]], [1], [4], [4], [8]]
 * <p>
 * 输出： [null, 6, 16, 16, 4]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 1 的相邻元素是 0、2 和 4。
 * 4 的相邻元素是 1、3、5 和 7。
 * 4 的对角线相邻元素是 0、2、6 和 8。
 * 8 的对角线相邻元素是 4。
 * 示例 2：
 * <p>
 * 输入：
 * <p>
 * ["neighborSum", "adjacentSum", "diagonalSum"]
 * <p>
 * [[[[1, 2, 0, 3], [4, 7, 15, 6], [8, 9, 10, 11], [12, 13, 14, 5]]], [15], [9]]
 * <p>
 * 输出： [null, 23, 45]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 15 的相邻元素是 0、10、7 和 6。
 * 9 的对角线相邻元素是 4、12、14 和 15。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= n == grid.length == grid[0].length <= 10
 * 0 <= grid[i][j] <= n2 - 1
 * 所有 grid[i][j] 值均不重复。
 * adjacentSum 和 diagonalSum 中的 value 均在范围 [0, n2 - 1] 内。
 * 最多会调用 adjacentSum 和 diagonalSum 总共 2 * n2 次。
 */
public class Code2 {

    //矩阵缓存
    private int[][] grid;
    //矩阵值坐标缓存
    private Map<Integer, int[]> map;

    public Code2(int[][] grid) {
        //初始化缓存
        this.grid = grid;
        this.map = new HashMap<>();
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //记录值坐标
                this.map.put(grid[i][j], new int[]{i, j});
            }
        }
    }

    public int adjacentSum(int value) {
        //获取坐标数组
        int[] indexArr = this.map.get(value);
        //坐标
        int x = indexArr[0];
        int y = indexArr[1];
        //返回
        return getGridValue(x + 1, y)
                + getGridValue(x - 1, y)
                + getGridValue(x, y + 1)
                + getGridValue(x, y - 1);
    }

    public int diagonalSum(int value) {
        //获取坐标数组
        int[] indexArr = this.map.get(value);
        //坐标
        int x = indexArr[0];
        int y = indexArr[1];
        //返回
        return getGridValue(x + 1, y + 1)
                + getGridValue(x + 1, y - 1)
                + getGridValue(x - 1, y + 1)
                + getGridValue(x - 1, y - 1);
    }

    //获取数组的和
    private int getGridValue(int x, int y) {
        //如果越界
        if (x < 0 || y < 0 || x >= this.grid.length || y >= this.grid[0].length) {
            //过
            return 0;
        }
        //实现
        return this.grid[x][y];
    }

}
