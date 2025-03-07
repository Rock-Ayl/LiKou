package easy36;

/**
 * @Author ayl
 * @Date 2024-05-03
 * 3127. 构造相同颜色的正方形
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个二维 3 x 3 的矩阵 grid ，每个格子都是一个字符，要么是 'B' ，要么是 'W' 。字符 'W' 表示白色，字符 'B' 表示黑色。
 * <p>
 * 你的任务是改变 至多一个 格子的颜色，使得矩阵中存在一个 2 x 2 颜色完全相同的正方形。
 * <p>
 * 如果可以得到一个相同颜色的 2 x 2 正方形，那么返回 true ，否则返回 false 。
 * 示例 1：
 * 输入：grid = [["B","W","B"],["B","W","W"],["B","W","B"]]
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * 修改 grid[0][2] 的颜色，可以满足要求。
 * <p>
 * 示例 2：
 * 输入：grid = [["B","W","B"],["W","B","W"],["B","W","B"]]
 * <p>
 * 输出：false
 * <p>
 * 解释：
 * <p>
 * 只改变一个格子颜色无法满足要求。
 * <p>
 * 示例 3：
 * 输入：grid = [["B","W","B"],["B","W","W"],["B","W","W"]]
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * grid 已经包含一个 2 x 2 颜色相同的正方形了。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * grid.length == 3
 * grid[i].length == 3
 * grid[i][j] 要么是 'W' ，要么是 'B' 。
 */
public class Code25 {

    //获取内容
    private char get(char[][] grid, int x, int y) {
        //如果越界
        if (x < 0 || y < 0 || x > 2 || y > 2) {
            //过
            return '-';
        }
        //返回
        return grid[x][y];
    }

    private boolean find(char[][] grid, int x, int y) {
        //当前
        char letter = grid[x][y];
        //如果可以
        if (letter == get(grid, x - 1, y) && letter == get(grid, x, y - 1)) {
            //过
            return true;
        }
        //如果可以
        if (letter == get(grid, x - 1, y) && letter == get(grid, x, y + 1)) {
            //过
            return true;
        }
        //如果可以
        if (letter == get(grid, x + 1, y) && letter == get(grid, x, y + 1)) {
            //过
            return true;
        }
        //如果可以
        if (letter == get(grid, x + 1, y) && letter == get(grid, x, y - 1)) {
            //过
            return true;
        }
        //默认
        return false;
    }

    public boolean canMakeSquare(char[][] grid) {
        //循环1
        for (int i = 0; i < 3; i++) {
            //循环2
            for (int j = 0; j < 3; j++) {
                //如果当前可以
                if (find(grid, i, j)) {
                    //过
                    return true;
                }
            }
        }
        //默认不可以
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code25().canMakeSquare(new char[][]{
                new char[]{'B', 'W', 'B'},
                new char[]{'W', 'B', 'W'},
                new char[]{'B', 'W', 'B'}
        }));
    }

}
