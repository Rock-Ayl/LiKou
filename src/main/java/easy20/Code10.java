package easy20;

/**
 * @Author ayl
 * @Date 2022-06-20
 * 463. 岛屿的周长
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 * <p>
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * <p>
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * 输出：16
 * 解释：它的周长是上面图片中的 16 个黄色的边
 * 示例 2：
 * <p>
 * 输入：grid = [[1]]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：grid = [[1,0]]
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * row == grid.length
 * col == grid[i].length
 * 1 <= row, col <= 100
 * grid[i][j] 为 0 或 1
 */
public class Code10 {

    //计算当前的周长
    public int count(int[][] grid, int x, int y) {
        //默认周长是4
        int count = 4;
        //如果不是头
        if (x > 0) {
            //如果是岛屿
            if (grid[x - 1][y] == 1) {
                //少一个
                count--;
            }
        }
        //如果不是头
        if (y > 0) {
            //如果是岛屿
            if (grid[x][y - 1] == 1) {
                //少一个
                count--;
            }
        }
        //如果不是尾
        if (x < grid.length - 1) {
            //如果是岛屿
            if (grid[x + 1][y] == 1) {
                //少一个
                count--;
            }
        }
        //如果不是尾
        if (y < grid[0].length - 1) {
            //如果是岛屿
            if (grid[x][y + 1] == 1) {
                //少一个
                count--;
            }
        }
        //初始化
        return count;
    }

    public int islandPerimeter(int[][] grid) {
        //结果o
        int sum = 0;
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //如果当前是岛屿
                if (grid[i][j] == 1) {
                    //叠加
                    sum += count(grid, i, j);
                }
            }
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code10().islandPerimeter(new int[][]{
                new int[]{0, 1, 0, 0},
                new int[]{1, 1, 1, 0},
                new int[]{0, 1, 0, 0},
                new int[]{1, 1, 0, 0},
        }));
    }

}
