package easy9;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 安永亮
 * @Date 2021-06-16
 * @Description 1260. 二维网格迁移
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 * <p>
 * 每次「迁移」操作将会引发下述活动：
 * <p>
 * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[9,1,2],[3,4,5],[6,7,8]]
 * 示例 2：
 * <p>
 * 输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * 输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 * 示例 3：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * 输出：[[1,2,3],[4,5,6],[7,8,9]]
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 50
 * 1 <= n <= 50
 * -1000 <= grid[i][j] <= 1000
 * 0 <= k <= 100
 */
public class Code4 {

    public int[][] move(int[][] grid) {
        //新的
        int[][] newGrid = new int[grid.length][grid[0].length];
        //循环1
        for (int i = 0; i < grid[0].length - 1; i++) {
            //循环2
            for (int j = 0; j < grid.length; j++) {
                //向右移动
                newGrid[j][i + 1] = grid[j][i];
            }
        }
        //防止越界
        newGrid[0][0] = grid[grid.length - 1][grid[0].length - 1];
        //循环
        for (int i = 0; i < grid.length - 1; i++) {
            //移动到最左边并向下偏移
            newGrid[i + 1][0] = grid[i][grid[0].length - 1];
        }
        //返回
        return newGrid;
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        //不断移动
        while (k > 0) {
            //移动一次
            grid = move(grid);
            //递减
            k--;
        }
        //结果
        List<List<Integer>> result = new ArrayList<>(grid.length);
        //循环
        for (int[] ints : grid) {
            //子list
            List<Integer> list = new ArrayList<>(ints.length);
            //循环
            for (int anInt : ints) {
                //组装
                list.add(anInt);
            }
            //组装
            result.add(list);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (List<Integer> list : new Code4().shiftGrid(new int[][]{
                new int[]{3, 8, 1, 9},
                new int[]{19, 7, 2, 5},
                new int[]{4, 6, 11, 10},
                new int[]{12, 0, 21, 13}
        }, 4)) {
            for (Integer integer : list) {
                System.out.print(integer+",");
            }
            System.out.println();
        }
    }

}
