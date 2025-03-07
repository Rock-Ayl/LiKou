package normal20;

/**
 * @Author ayl
 * @Date 2023-05-19
 * 2658. 网格图中鱼的最大数目
 * 给你一个下标从 0 开始大小为 m x n 的二维整数数组 grid ，其中下标在 (r, c) 处的整数表示：
 * <p>
 * 如果 grid[r][c] = 0 ，那么它是一块 陆地 。
 * 如果 grid[r][c] > 0 ，那么它是一块 水域 ，且包含 grid[r][c] 条鱼。
 * 一位渔夫可以从任意 水域 格子 (r, c) 出发，然后执行以下操作任意次：
 * <p>
 * 捕捞格子 (r, c) 处所有的鱼，或者
 * 移动到相邻的 水域 格子。
 * 请你返回渔夫最优策略下， 最多 可以捕捞多少条鱼。如果没有水域格子，请你返回 0 。
 * <p>
 * 格子 (r, c) 相邻 的格子为 (r, c + 1) ，(r, c - 1) ，(r + 1, c) 和 (r - 1, c) ，前提是相邻格子在网格图内。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]]
 * 输出：7
 * 解释：渔夫可以从格子 (1,3) 出发，捕捞 3 条鱼，然后移动到格子 (2,3) ，捕捞 4 条鱼。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,1]]
 * 输出：1
 * 解释：渔夫可以从格子 (0,0) 或者 (3,3) ，捕捞 1 条鱼。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * 0 <= grid[i][j] <= 10
 */
public class Code15 {

    //抓鱼
    public int catchFish(int x, int y, int[][] grid) {
        //如果越界
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            //过
            return 0;
        }
        //当前鱼
        int fish = grid[x][y];
        //如果没有鱼
        if (fish < 1) {
            //过
            return 0;
        }
        //先记录该点没有鱼了
        grid[x][y] = 0;
        //再尝试去周围抓鱼
        fish += catchFish(x + 1, y, grid);
        fish += catchFish(x, y + 1, grid);
        fish += catchFish(x - 1, y, grid);
        fish += catchFish(x, y - 1, grid);
        //返回最终结果
        return fish;
    }

    public int findMaxFish(int[][] grid) {
        //最大抓鱼
        int maxCatch = 0;
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //如果有鱼
                if (grid[i][j] > 0) {
                    //抓鱼并记录最大
                    maxCatch = Math.max(maxCatch, catchFish(i, j, grid));
                }
            }
        }
        //返回
        return maxCatch;
    }

    public static void main(String[] args) {
        System.out.println(new Code15().findMaxFish(new int[][]{
                new int[]{0, 2, 1, 0},
                new int[]{4, 0, 0, 3},
                new int[]{1, 0, 0, 4},
                new int[]{0, 3, 2, 0},
        }));
    }

}
