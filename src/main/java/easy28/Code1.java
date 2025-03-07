package easy28;

/**
 * @Author ayl
 * @Date 2023-02-10
 * 2373. 矩阵中的局部最大值
 * 给你一个大小为 n x n 的整数矩阵 grid 。
 * <p>
 * 生成一个大小为 (n - 2) x (n - 2) 的整数矩阵  maxLocal ，并满足：
 * <p>
 * maxLocal[i][j] 等于 grid 中以 i + 1 行和 j + 1 列为中心的 3 x 3 矩阵中的 最大值 。
 * 换句话说，我们希望找出 grid 中每个 3 x 3 矩阵中的最大值。
 * <p>
 * 返回生成的矩阵。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
 * 输出：[[9,9],[8,6]]
 * 解释：原矩阵和生成的矩阵如上图所示。
 * 注意，生成的矩阵中，每个值都对应 grid 中一个相接的 3 x 3 矩阵的最大值。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
 * 输出：[[2,2,2],[2,2,2],[2,2,2]]
 * 解释：注意，2 包含在 grid 中每个 3 x 3 的矩阵中。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 3 <= n <= 100
 * 1 <= grid[i][j] <= 100
 */
public class Code1 {

    public int[][] largestLocal(int[][] grid) {
        //结果
        int[][] result = new int[grid.length - 2][grid[0].length - 2];
        //循环1
        for (int i = 0; i < result.length; i++) {
            //循环2
            for (int j = 0; j < result.length; j++) {
                //计算并叠加
                result[i][j] = count(grid, i + 1, j + 1);
            }
        }
        //返回
        return result;
    }

    //计算
    private int count(int[][] grid, int x, int y) {
        //返回
        return Math.max(grid[x][y], Math.max(Math.max(Math.max(grid[x][y + 1], grid[x + 1][y]), Math.max(grid[x - 1][y], grid[x][y - 1])), Math.max(Math.max(grid[x - 1][y + 1], grid[x + 1][y - 1]), Math.max(grid[x + 1][y + 1], grid[x - 1][y - 1]))));
    }

    public static void main(String[] args) {
        new Code1().largestLocal(new int[][]{
                new int[]{9, 9, 8, 1},
                new int[]{5, 6, 2, 6},
                new int[]{8, 2, 6, 4},
                new int[]{6, 2, 2, 2}
        });
    }

}
