package normal31;

/**
 * @Author ayl
 * @Date 2024-05-18
 * 1034. 边界着色
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色。
 * <p>
 * 如果两个方块在任意 4 个方向上相邻，则称它们 相邻 。
 * <p>
 * 如果两个方块具有相同的颜色且相邻，它们则属于同一个 连通分量 。
 * <p>
 * 连通分量的边界 是指连通分量中满足下述条件之一的所有网格块：
 * <p>
 * 在上、下、左、右任意一个方向上与不属于同一连通分量的网格块相邻
 * 在网格的边界上（第一行/列或最后一行/列）
 * 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色。
 * <p>
 * 并返回最终的网格 grid 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
 * 输出：[[3,3],[3,2]]
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
 * 输出：[[1,3,3],[2,3,3]]
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
 * 输出：[[2,2,2],[2,1,2],[2,2,2]]
 */
public class Code19 {

    //递归染色
    private void print(int[][] grid, int x, int y, int startColor, int[][] printed, int[][] targetPrint) {
        //如果越界
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            //过
            return;
        }
        //如果已经染色过了
        if (++printed[x][y] > 1) {
            //过
            return;
        }
        //如果当前位置不是与开始同一个颜色
        if (grid[x][y] != startColor) {
            //过
            return;
        }
        //该点属于目标点
        targetPrint[x][y] = 1;
        //递归四个方向
        print(grid, x + 1, y, startColor, printed, targetPrint);
        print(grid, x - 1, y, startColor, printed, targetPrint);
        print(grid, x, y + 1, startColor, printed, targetPrint);
        print(grid, x, y - 1, startColor, printed, targetPrint);
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        //初始化已尝试判定染色缓存
        int[][] printed = new int[grid.length][grid[0].length];
        //初始化目标颜色区域
        int[][] targetPrint = new int[grid.length][grid[0].length];
        //开始颜色
        int startColor = grid[row][col];
        //递归实现
        print(grid, row, col, startColor, printed, targetPrint);
        //循环1
        for (int i = 0; i < targetPrint.length; i++) {
            //循环2
            for (int j = 0; j < targetPrint[0].length; j++) {
                //如果不是需要染色的点
                if (targetPrint[i][j] == 0) {
                    //本轮过
                    continue;
                }
                //如果是边界
                if (i == 0 || j == 0 || i + 1 == grid.length || j + 1 == grid[0].length) {
                    //可以染色
                    grid[i][j] = color;
                    //本轮过
                    continue;
                }
                //如果上下左右均需要染色,则视为不为边界
                if (targetPrint[i + 1][j] == 1 && targetPrint[i - 1][j] == 1 && targetPrint[i][j + 1] == 1 && targetPrint[i][j - 1] == 1) {
                    //本轮过
                    continue;
                }
                //最终染色
                grid[i][j] = color;
            }
        }
        //返回结果
        return grid;
    }

    public static void main(String[] args) {
        int[][] ints = new Code19().colorBorder(new int[][]{
                new int[]{1, 2, 1, 2, 1, 2},
                new int[]{2, 2, 2, 2, 1, 2},
                new int[]{1, 2, 2, 2, 1, 2}
        }, 1, 3, 1);
        printArr(ints);
    }

    //[1,1,1,1,1,2],
    //[1,2,1,1,1,2],
    //[1,1,1,1,1,2]

    private static void printArr(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.println();
        }
    }

}
