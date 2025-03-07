package normal29;

/**
 * @Author ayl
 * @Date 2024-03-06
 * 2596. 检查骑士巡视方案
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 骑士在一张 n x n 的棋盘上巡视。在 有效 的巡视方案中，骑士会从棋盘的 左上角 出发，并且访问棋盘上的每个格子 恰好一次 。
 * <p>
 * 给你一个 n x n 的整数矩阵 grid ，由范围 [0, n * n - 1] 内的不同整数组成，其中 grid[row][col] 表示单元格 (row, col) 是骑士访问的第 grid[row][col] 个单元格。骑士的行动是从下标 0 开始的。
 * <p>
 * 如果 grid 表示了骑士的有效巡视方案，返回 true；否则返回 false。
 * <p>
 * 注意，骑士行动时可以垂直移动两个格子且水平移动一个格子，或水平移动两个格子且垂直移动一个格子。下图展示了骑士从某个格子出发可能的八种行动路线。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[0,11,16,5,20],[17,4,19,10,15],[12,1,8,21,6],[3,18,23,14,9],[24,13,2,7,22]]
 * 输出：true
 * 解释：grid 如上图所示，可以证明这是一个有效的巡视方案。
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[0,3,6],[5,8,1],[2,7,4]]
 * 输出：false
 * 解释：grid 如上图所示，考虑到骑士第 7 次行动后的位置，第 8 次行动是无效的。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 3 <= n <= 7
 * 0 <= grid[row][col] < n * n
 * grid 中的所有整数 互不相同
 */
public class Code16 {

    //递归
    private boolean next(int[][] grid, int x, int y, int lastNum) {
        //如果越界
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            //过
            return false;
        }
        //当前值
        int num = grid[x][y];
        //如果本值不是由上一个值跳过来的
        if (num != lastNum + 1) {
            //过
            return false;
        }
        //如果当前值是最终点
        if (num == grid.length * grid[0].length - 1) {
            //可行,返回最终结果
            return true;
        }
        //递归8种情况,如果任意一种满足,返回结果
        return next(grid, x + 1, y + 2, num) ||
                next(grid, x + 1, y - 2, num) ||
                next(grid, x - 1, y + 2, num) ||
                next(grid, x - 1, y - 2, num) ||
                next(grid, x + 2, y + 1, num) ||
                next(grid, x + 2, y - 1, num) ||
                next(grid, x - 2, y + 1, num) ||
                next(grid, x - 2, y - 1, num);
    }

    public boolean checkValidGrid(int[][] grid) {
        //实现
        return next(grid, 0, 0, -1);
    }

    public static void main(String[] args) {
        System.out.println(new Code16().checkValidGrid(new int[][]{
                new int[]{0, 11, 16, 5, 20},
                new int[]{17, 4, 19, 10, 15},
                new int[]{12, 1, 8, 21, 6},
                new int[]{3, 18, 23, 14, 9},
                new int[]{24, 13, 2, 7, 22}
        }));
    }

}
