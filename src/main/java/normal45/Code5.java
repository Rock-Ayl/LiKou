package normal45;

/**
 * @Author ayl
 * @Date 2025-07-21
 * 3619. 总价值可以被 K 整除的岛屿数目
 * 中等
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 m x n 的矩阵 grid 和一个正整数 k。一个 岛屿 是由 正 整数（表示陆地）组成的，并且陆地间 四周 连通（水平或垂直）。
 * <p>
 * 一个岛屿的总价值是该岛屿中所有单元格的值之和。
 * <p>
 * 返回总价值可以被 k 整除 的岛屿数量。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: grid = [[0,2,1,0,0],[0,5,0,0,5],[0,0,1,0,0],[0,1,4,7,0],[0,2,0,0,8]], k = 5
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * <p>
 * 网格中包含四个岛屿。蓝色高亮显示的岛屿的总价值可以被 5 整除，而红色高亮显示的岛屿则不能。
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: grid = [[3,0,3,0], [0,3,0,3], [3,0,3,0]], k = 3
 * <p>
 * 输出: 6
 * <p>
 * 解释:
 * <p>
 * 网格中包含六个岛屿，每个岛屿的总价值都可以被 3 整除。
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 1000
 * 1 <= m * n <= 105
 * 0 <= grid[i][j] <= 106
 * 1 <= k < = 106
 */
public class Code5 {

    public int countIslands(int[][] grid, int k) {
        //次数
        int count = 0;
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //如果没有有岛屿
                if (grid[i][j] == 0) {
                    //本轮过
                    continue;
                }
                //发现岛屿、求和、并填充
                int sum = findAndSum(grid, i, j);
                //如果满足
                if (sum % k == 0) {
                    //+1
                    count++;
                }
            }
        }
        //返回结果
        return count;
    }

    //发现、求和、并填充
    private int findAndSum(int[][] grid, int x, int y) {
        //如果越界
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            //过
            return 0;
        }
        //如果是0
        if (grid[x][y] == 0) {
            //过
            return 0;
        }
        //当前陆地
        int sum = grid[x][y];
        //填充
        grid[x][y] = 0;
        //叠加上下左右
        sum += findAndSum(grid, x + 1, y);
        sum += findAndSum(grid, x - 1, y);
        sum += findAndSum(grid, x, y + 1);
        sum += findAndSum(grid, x, y - 1);
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().countIslands(new int[][]{
                new int[]{0, 2, 1, 0, 0},
                new int[]{0, 5, 0, 0, 5},
                new int[]{0, 0, 1, 0, 0},
                new int[]{0, 1, 4, 7, 0},
                new int[]{0, 2, 0, 0, 8}
        }, 5));
    }

}
