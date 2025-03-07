package normal16;

/**
 * @Author ayl
 * @Date 2022-10-03
 * 2428. 沙漏的最大总和
 * 给你一个大小为 m x n 的整数矩阵 grid 。
 * <p>
 * 按以下形式将矩阵的一部分定义为一个 沙漏 ：
 * <p>
 * <p>
 * 返回沙漏中元素的 最大 总和。
 * <p>
 * 注意：沙漏无法旋转且必须整个包含在矩阵中。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[6,2,1,3],[4,2,1,5],[9,2,8,7],[4,1,2,9]]
 * 输出：30
 * 解释：上图中的单元格表示元素总和最大的沙漏：6 + 2 + 1 + 2 + 9 + 2 + 8 = 30 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：35
 * 解释：上图中的单元格表示元素总和最大的沙漏：1 + 2 + 3 + 5 + 7 + 8 + 9 = 35 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 3 <= m, n <= 150
 * 0 <= grid[i][j] <= 106
 */
public class Code13 {

    public int maxSum(int[][] grid) {
        //最大
        int max = 0;
        //循环1
        for (int i = 1; i < grid.length - 1; i++) {
            //循环2
            for (int j = 1; j < grid[0].length - 1; j++) {
                //当前数字
                int num = grid[i][j];
                //上
                int up1 = grid[i - 1][j - 1];
                int up2 = grid[i - 1][j];
                int up3 = grid[i - 1][j + 1];
                //上和
                int up = up1 + up2 + up3;
                //下
                int down1 = grid[i + 1][j - 1];
                int down2 = grid[i + 1][j];
                int down3 = grid[i + 1][j + 1];
                //下和
                int down = down1 + down2 + down3;
                //当前沙漏
                int thisSum = num + up + down;
                //刷新最大
                max = Math.max(thisSum, max);
            }
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().maxSum(new int[][]{
                new int[]{6, 2, 1, 3},
                new int[]{4, 2, 1, 5},
                new int[]{9, 2, 8, 7},
                new int[]{4, 1, 2, 9},
        }));
    }
}
