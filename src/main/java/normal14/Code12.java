package normal14;

/**
 * @Author ayl
 * @Date 2022-06-24
 * 剑指 Offer II 105. 岛屿的最大面积
 * 给定一个由 0 和 1 组成的非空二维数组 grid ，用来表示海洋岛屿地图。
 * <p>
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * <p>
 * 找到给定的二维数组中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 输出: 6
 * 解释: 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 * 示例 2:
 * <p>
 * 输入: grid = [[0,0,0,0,0,0,0,0]]
 * 输出: 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1
 * <p>
 * <p>
 * 注意：本题与主站 695 题相同： https://leetcode-cn.com/problems/max-area-of-island/
 */
public class Code12 {

    //不断将岛屿填充为水并返回count
    public int fill(int[][] grid, int x, int y) {
        //如果越界 或 当前是水
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
            //过
            return 0;
        }
        //填海
        grid[x][y] = 0;
        //当前是岛屿+上下左右,返回结果
        return 1 + fill(grid, x + 1, y) + fill(grid, x - 1, y) + fill(grid, x, y + 1) + fill(grid, x, y - 1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        //最大结果
        int max = 0;
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //如果是岛屿的一部分
                if (grid[i][j] == 1) {
                    //填海,计算当前并刷新最大
                    max = Math.max(max, fill(grid, i, j));
                }
            }
        }
        //返回
        return max;
    }

    public static void main(String[] args) {

    }

}
