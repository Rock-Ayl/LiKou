package easy39;

/**
 * @Author ayl
 * @Date 2024-12-29
 * 3402. 使每一列严格递增的最少操作次数
 * 简单
 * 相关企业
 * 提示
 * 给你一个由 非负 整数组成的 m x n 矩阵 grid。
 * <p>
 * 在一次操作中，你可以将任意元素 grid[i][j] 的值增加 1。
 * <p>
 * 返回使 grid 的所有列 严格递增 所需的 最少 操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: grid = [[3,2],[1,3],[3,4],[0,1]]
 * <p>
 * 输出: 15
 * <p>
 * 解释:
 * <p>
 * 为了让第 0 列严格递增，可以对 grid[1][0] 执行 3 次操作，对 grid[2][0] 执行 2 次操作，对 grid[3][0] 执行 6 次操作。
 * 为了让第 1 列严格递增，可以对 grid[3][1] 执行 4 次操作。
 * <p>
 * 示例 2：
 * <p>
 * 输入: grid = [[3,2,1],[2,1,0],[1,2,3]]
 * <p>
 * 输出: 12
 * <p>
 * 解释:
 * <p>
 * 为了让第 0 列严格递增，可以对 grid[1][0] 执行 2 次操作，对 grid[2][0] 执行 4 次操作。
 * 为了让第 1 列严格递增，可以对 grid[1][1] 执行 2 次操作，对 grid[2][1] 执行 2 次操作。
 * 为了让第 2 列严格递增，可以对 grid[1][2] 执行 2 次操作。
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 0 <= grid[i][j] < 2500
 */
public class Code9 {

    public int minimumOperations(int[][] grid) {
        //操作次数
        int count = 0;
        //循环
        for (int j = 0; j < grid[0].length; j++) {
            //循环
            for (int i = 1; i < grid.length; i++) {
                //如果是递增
                if (grid[i][j] > grid[i - 1][j]) {
                    //本轮过
                    continue;
                }
                //计算数量
                int add = grid[i - 1][j] + 1 - grid[i][j];
                //叠加
                grid[i][j] += add;
                //本次操作数量
                count += add;
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().minimumOperations(new int[][]{
                new int[]{3, 2},
                new int[]{1, 3},
                new int[]{3, 4},
                new int[]{0, 1}
        }));
    }

}
