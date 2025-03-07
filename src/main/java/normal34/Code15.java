package normal34;

/**
 * @Author ayl
 * @Date 2024-08-24
 * 3239. 最少翻转次数使二进制矩阵回文 I
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 m x n 的二进制矩阵 grid 。
 * <p>
 * 如果矩阵中一行或者一列从前往后与从后往前读是一样的，那么我们称这一行或者这一列是 回文 的。
 * <p>
 * 你可以将 grid 中任意格子的值 翻转 ，也就是将格子里的值从 0 变成 1 ，或者从 1 变成 0 。
 * <p>
 * 请你返回 最少 翻转次数，使得矩阵 要么 所有行是 回文的 ，要么所有列是 回文的 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,0,0],[0,0,0],[0,0,1]]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 将高亮的格子翻转，得到所有行都是回文的。
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [[0,1],[0,1],[0,0]]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 将高亮的格子翻转，得到所有列都是回文的。
 * <p>
 * 示例 3：
 * <p>
 * 输入：grid = [[1],[0]]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 所有行已经是回文的。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m * n <= 2 * 105
 * 0 <= grid[i][j] <= 1
 */
public class Code15 {

    //情况1
    private int change1(int[][] grid) {
        //操作次数
        int count = 0;
        //循环1
        for (int i = 0; i < grid.length / 2; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //如果列不同
                if (grid[i][j] != grid[grid.length - 1 - i][j]) {
                    //+1
                    count++;
                }
            }
        }
        //返回
        return count;
    }

    //情况2
    private int change2(int[][] grid) {
        //操作次数
        int count = 0;
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length / 2; j++) {
                //如果行不同
                if (grid[i][j] != grid[i][grid[0].length - 1 - j]) {
                    //+1
                    count++;
                }
            }
        }
        //返回
        return count;
    }

    public int minFlips(int[][] grid) {
        //两种情况判断
        return Math.min(change1(grid), change2(grid));
    }

    public static void main(String[] args) {
        System.out.println(new Code15().minFlips(new int[][]{
                new int[]{1, 0, 0},
                new int[]{0, 0, 0},
                new int[]{0, 0, 1}
        }));
    }

}
