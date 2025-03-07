package normal14;

/**
 * @Author ayl
 * @Date 2022-06-18
 * 剑指 Offer 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 */
public class Code8 {

    public int maxValue(int[][] grid) {
        //循环1
        for (int i = 1; i < grid.length; i++) {
            //叠加
            grid[i][0] += grid[i - 1][0];
        }
        //循环2
        for (int j = 1; j < grid[0].length; j++) {
            //叠加
            grid[0][j] += grid[0][j - 1];
        }
        //循环3
        for (int i = 1; i < grid.length; i++) {
            //循环4
            for (int j = 1; j < grid[0].length; j++) {
                //找到最优解,叠加
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        //返回结果
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Code8().maxValue(new int[][]{
                new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1}
        }));
    }

}
