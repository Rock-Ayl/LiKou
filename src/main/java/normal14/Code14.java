package normal14;

/**
 * @Author ayl
 * @Date 2022-06-30
 * 1905. 统计子岛屿
 * 给你两个 m x n 的二进制矩阵 grid1 和 grid2 ，它们只包含 0 （表示水域）和 1 （表示陆地）。一个 岛屿 是由 四个方向 （水平或者竖直）上相邻的 1 组成的区域。任何矩阵以外的区域都视为水域。
 * <p>
 * 如果 grid2 的一个岛屿，被 grid1 的一个岛屿 完全 包含，也就是说 grid2 中该岛屿的每一个格子都被 grid1 中同一个岛屿完全包含，那么我们称 grid2 中的这个岛屿为 子岛屿 。
 * <p>
 * 请你返回 grid2 中 子岛屿 的 数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
 * 输出：3
 * 解释：如上图所示，左边为 grid1 ，右边为 grid2 。
 * grid2 中标红的 1 区域是子岛屿，总共有 3 个子岛屿。
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]], grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
 * 输出：2
 * 解释：如上图所示，左边为 grid1 ，右边为 grid2 。
 * grid2 中标红的 1 区域是子岛屿，总共有 2 个子岛屿。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid1.length == grid2.length
 * n == grid1[i].length == grid2[i].length
 * 1 <= m, n <= 500
 * grid1[i][j] 和 grid2[i][j] 都要么是 0 要么是 1 。
 */
public class Code14 {


    //填海,判断是否满足
    public boolean setAndCheck(int x, int y, int[][] grid1, int[][] grid2) {
        //如果越界 或 grid2[x][y] != 1
        if (x < 0 || y < 0 || x >= grid2.length || y >= grid2[0].length || grid2[x][y] != 1) {
            //算是满足
            return true;
        }
        //当前区块填海,防止下次走
        grid2[x][y] = 0;
        //上下左右先完整走一遍
        boolean one = setAndCheck(x + 1, y, grid1, grid2);
        boolean two = setAndCheck(x - 1, y, grid1, grid2);
        boolean three = setAndCheck(x, y + 1, grid1, grid2);
        boolean four = setAndCheck(x, y - 1, grid1, grid2);
        //判断 另一个是否同样是 并且 上下左右是否都满足
        return grid1[x][y] == 1 && one && two && three && four;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        //结果
        int count = 0;
        //循环1
        for (int x = 0; x < grid2.length; x++) {
            //循环2
            for (int y = 0; y < grid2[0].length; y++) {
                //如果首先有第一块岛屿 并且 满足覆盖条件
                if (grid2[x][y] == 1 && setAndCheck(x, y, grid1, grid2) == true) {
                    //+1
                    count++;
                }
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code14().countSubIslands(new int[][]{
                new int[]{1, 1, 1, 0, 0},
                new int[]{0, 1, 1, 1, 1},
                new int[]{0, 0, 0, 0, 0},
                new int[]{1, 0, 0, 0, 0},
                new int[]{1, 1, 0, 1, 1},
        }, new int[][]{
                new int[]{1, 1, 1, 0, 0},
                new int[]{0, 0, 1, 1, 1},
                new int[]{0, 1, 0, 0, 0},
                new int[]{1, 0, 1, 1, 0},
                new int[]{0, 1, 0, 1, 0},
        }));
    }


}
