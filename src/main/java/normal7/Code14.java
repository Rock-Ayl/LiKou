package normal7;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @Author ayl
 * @Date 2021-09-12
 * 1254. 统计封闭岛屿的数目
 * 有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
 * <p>
 * 我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
 * <p>
 * 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
 * <p>
 * 请返回封闭岛屿的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * 输出：2
 * 解释：
 * 灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,1],
 * [1,0,0,0,0,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,1,0,1,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,0,0,0,0,1],
 * [1,1,1,1,1,1,1]]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 */
public class Code14 {

    int[][] grid;

    //记录走过的路
    Set<String> set = new HashSet<>();

    private boolean move(int x, int y) {
        //是否为岛屿
        boolean isLand;
        //如果是边界
        if (x == 0 || y == 0 || x == grid.length - 1 || y == grid[0].length - 1) {
            //不是岛屿了
            isLand = false;
        } else {
            //是岛屿
            isLand = true;
        }
        //当前陆地变海洋
        this.grid[x][y] = 1;
        //记录走过了
        set.add(x + "," + y);
        //如果可以移动
        if (x > 0) {
            //如果没走过
            if (!set.contains((x - 1) + "," + y)) {
                //如果是陆地
                if (this.grid[x - 1][y] == 0) {
                    //下一步
                    if (move(x - 1, y) == false) {
                        //肯定不是岛屿了
                        isLand = false;
                    }
                }
            }
        }
        //如果可以移动
        if (y > 0) {
            //如果没走过
            if (!set.contains(x + "," + (y - 1))) {
                //如果是陆地
                if (this.grid[x][y - 1] == 0) {
                    //下一步
                    if (move(x, y - 1) == false) {
                        //肯定不是岛屿了
                        isLand = false;
                    }
                }
            }
        }
        //如果可以移动
        if (x < grid.length - 1) {
            //如果没走过
            if (!set.contains((x + 1) + "," + y)) {
                //如果是陆地
                if (this.grid[x + 1][y] == 0) {
                    //下一步
                    if (move(x + 1, y) == false) {
                        //肯定不是岛屿了
                        isLand = false;
                    }
                }
            }
        }
        //如果可以移动
        if (y < grid[0].length - 1) {
            //如果没走过
            if (!set.contains(x + "," + (y + 1))) {
                //如果是陆地
                if (this.grid[x][y + 1] == 0) {
                    //下一步
                    if (move(x, y + 1) == false) {
                        //肯定不是岛屿了
                        isLand = false;
                    }
                }
            }
        }
        //返回
        return isLand;
    }

    public int closedIsland(int[][] grid) {
        //全局
        this.grid = grid;
        //总数
        int size = 0;
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //当前
                int space = grid[i][j];
                //如果是陆地
                if (space == 0) {
                    //删除当前连接陆地
                    boolean isLand = move(i, j);
                    //如果是岛屿
                    if (isLand) {
                        //+1
                        size++;
                    }
                }
            }
        }
        //返回结果
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new Code14().closedIsland(new int[][]{
                new int[]{1, 1, 1, 1, 1, 1, 1, 0},
                new int[]{1, 0, 0, 0, 0, 1, 1, 0},
                new int[]{1, 0, 1, 0, 1, 1, 1, 0},
                new int[]{1, 0, 0, 0, 0, 1, 0, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1, 0}
        }));
    }

}
