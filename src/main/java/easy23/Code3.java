package easy23;

/**
 * @Author ayl
 * @Date 2022-09-17
 * 2319. 判断矩阵是否是一个 X 矩阵
 * 如果一个正方形矩阵满足下述 全部 条件，则称之为一个 X 矩阵 ：
 * <p>
 * 矩阵对角线上的所有元素都 不是 0
 * 矩阵中所有其他元素都是 0
 * 给你一个大小为 n x n 的二维整数数组 grid ，表示一个正方形矩阵。如果 grid 是一个 X 矩阵 ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]
 * 输出：true
 * 解释：矩阵如上图所示。
 * X 矩阵应该满足：绿色元素（对角线上）都不是 0 ，红色元素都是 0 。
 * 因此，grid 是一个 X 矩阵。
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[5,7,0],[0,3,1],[0,5,0]]
 * 输出：false
 * 解释：矩阵如上图所示。
 * X 矩阵应该满足：绿色元素（对角线上）都不是 0 ，红色元素都是 0 。
 * 因此，grid 不是一个 X 矩阵。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 3 <= n <= 100
 * 0 <= grid[i][j] <= 105
 */
public class Code3 {

    public boolean checkXMatrix(int[][] grid) {
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //当前
                int num = grid[i][j];
                //如果是对角线
                if (i == j || (i + j == grid.length - 1)) {
                    //如果不是
                    if (num == 0) {
                        //不是
                        return false;
                    }
                } else {
                    //如果是
                    if (num != 0) {
                        //不是
                        return false;
                    }
                }
            }
        }
        //默认是
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().checkXMatrix(new int[][]{
                new int[]{2, 0, 0, 1},
                new int[]{0, 3, 1, 0},
                new int[]{0, 5, 2, 0},
                new int[]{4, 0, 0, 2},
        }));
    }

}
