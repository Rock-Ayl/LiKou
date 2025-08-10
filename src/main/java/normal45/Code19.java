package normal45;

/**
 * @Author ayl
 * @Date 2025-08-10
 * 3643. 垂直翻转子矩阵
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 m x n 的整数矩阵 grid，以及三个整数 x、y 和 k。
 * <p>
 * 整数 x 和 y 表示一个 正方形子矩阵 的左上角下标，整数 k 表示该正方形子矩阵的边长。
 * <p>
 * 你的任务是垂直翻转子矩阵的行顺序。
 * <p>
 * 返回更新后的矩阵。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入： grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], x = 1, y = 0, k = 3
 * <p>
 * 输出： [[1,2,3,4],[13,14,15,8],[9,10,11,12],[5,6,7,16]]
 * <p>
 * 解释：
 * <p>
 * 上图展示了矩阵在变换前后的样子。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入： grid = [[3,4,2,3],[2,3,4,2]], x = 0, y = 2, k = 2
 * <p>
 * 输出： [[3,4,4,2],[2,3,2,3]]
 * <p>
 * 解释：
 * <p>
 * 上图展示了矩阵在变换前后的样子。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 1 <= grid[i][j] <= 100
 * 0 <= x < m
 * 0 <= y < n
 * 1 <= k <= min(m - x, n - y)
 */
public class Code19 {

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        //实现
        changeAll(grid, x, y, x + k - 1, y + k - 1);
        //返回结果
        return grid;
    }

    //交换实现
    private void changeAll(int[][] grid, int startX, int startY, int endX, int endY) {
        //计算需要交换的水平坐标
        int midX = startX + ((endX - startX) / 2);
        //循环
        for (int x = startX; x <= midX; x++) {
            //循环2
            for (int y = startY; y <= endY; y++) {
                //距离
                int away = x - startX;
                //计算出另一个x
                int otherX = endX - away;
                //交换
                int num1 = grid[x][y];
                grid[x][y] = grid[otherX][y];
                grid[otherX][y] = num1;
            }
        }
    }

    public static void main(String[] args) {

        /*int[][] ints = new Code19().reverseSubmatrix(new int[][]{
                new int[]{6, 16, 14},
                new int[]{1, 2, 19},
                new int[]{14, 17, 15},
                new int[]{18, 7, 6},
                new int[]{14, 12, 5}
        }, 2, 1, 2);*/

        int[][] ints = new Code19().reverseSubmatrix(new int[][]{
                new int[]{14, 3, 18, 16},
                new int[]{2, 14, 11, 20},
                new int[]{19, 19, 4, 15},
                new int[]{11, 15, 18, 6}
        }, 0, 0, 4);

        print(ints);
        System.out.println();
    }

    private static void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.println();
        }
    }

}
