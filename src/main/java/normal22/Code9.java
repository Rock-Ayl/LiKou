package normal22;

/**
 * @Author ayl
 * @Date 2023-07-24
 * 剑指 Offer II 099. 最小路径之和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：一个机器人每次只能向下或者向右移动一步。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 * <p>
 * <p>
 * 注意：本题与主站 64 题相同： https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class Code9 {

    public int minPathSum(int[][] grid) {
        //循环
        for (int i = 1; i < grid.length; i++) {
            //叠加
            grid[i][0] += grid[i - 1][0];
        }
        //循环
        for (int i = 1; i < grid[0].length; i++) {
            //叠加
            grid[0][i] += grid[0][i - 1];
        }
        //循环1
        for (int i = 1; i < grid.length; i++) {
            //循环2
            for (int j = 1; j < grid[0].length; j++) {
                //叠加最小路径和
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        //返回结果
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Code9().minPathSum(new int[][]{
                new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1}
        }));
    }

}
