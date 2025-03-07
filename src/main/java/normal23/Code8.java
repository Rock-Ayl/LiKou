package normal23;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-08-18
 * 934. 最短的桥
 * 中等
 * 477
 * 相关企业
 * 给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。
 * <p>
 * 岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。
 * <p>
 * 你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。
 * <p>
 * 返回必须翻转的 0 的最小数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[0,1],[1,0]]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = [[0,1,0],[0,0,0],[0,0,1]]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 2 <= n <= 100
 * grid[i][j] 为 0 或 1
 * grid 中恰有两个岛
 */
public class Code8 {

    //找到所有指定岛屿,并填充
    private void linkIsLand(int[][] grid, int landSpace, int x, int y) {
        //如果越界了
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            //过
            return;
        }
        //如果不是岛屿
        if (grid[x][y] != 1) {
            //过
            return;
        }
        //记录该岛屿
        grid[x][y] = landSpace;
        //下一级
        linkIsLand(grid, landSpace, x + 1, y);
        linkIsLand(grid, landSpace, x - 1, y);
        linkIsLand(grid, landSpace, x, y + 1);
        linkIsLand(grid, landSpace, x, y - 1);
    }

    //填充上下左右为岛屿1,并判断是否找到岛屿2
    private boolean setOneLinkLand(int[][] grid, int x, int y, int space, int willFind) {
        //如果有上面
        if (x > 0) {
            //判断是否是目标
            if (grid[x - 1][y] == willFind) {
                //直接返回
                return true;
            }
            //记录节点
            grid[x - 1][y] = space;
        }
        //如果有下面
        if (x < grid.length - 1) {
            //判断是否是目标
            if (grid[x + 1][y] == willFind) {
                //直接返回
                return true;
            }
            //记录节点
            grid[x + 1][y] = space;
        }
        //如果有左边
        if (y > 0) {
            //判断是否是目标
            if (grid[x][y - 1] == willFind) {
                //直接返回
                return true;
            }
            //记录节点
            grid[x][y - 1] = space;
        }
        //如果有右边
        if (y < grid[0].length - 1) {
            //判断是否是目标
            if (grid[x][y + 1] == willFind) {
                //直接返回
                return true;
            }
            //记录节点
            grid[x][y + 1] = space;
        }
        //默认没找到
        return false;
    }

    public int shortestBridge(int[][] grid) {
        //岛屿1
        int landOne = 2;
        //岛屿2
        int landTwo = 3;
        //存在第一个岛屿
        boolean hadLandOne = false;
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //如果当前不是标准岛屿
                if (grid[i][j] != 1) {
                    //本轮过
                    continue;
                }
                //如果第一个岛不存在
                if (hadLandOne == false) {
                    //计算岛屿1
                    linkIsLand(grid, landOne, i, j);
                    //记录岛屿1已存在,下次找岛屿2
                    hadLandOne = true;
                } else {
                    //计算岛屿2
                    linkIsLand(grid, landTwo, i, j);
                    //跳出
                    break;
                }
            }
        }
        //结果次数
        int count = 0;
        //循环
        while (true) {
            //当前结果步数
            count++;
            //当前层级的所有岛屿1
            List<int[]> landList = new ArrayList<>();
            //循环1
            for (int i = 0; i < grid.length; i++) {
                //循环2
                for (int j = 0; j < grid[0].length; j++) {
                    //如果当前是岛屿1
                    if (grid[i][j] == landOne) {
                        //记录
                        landList.add(new int[]{i, j});
                    }
                }
            }
            //循环
            for (int[] ints : landList) {
                //填充周围岛屿为1,如果找到岛屿2,返回
                if (setOneLinkLand(grid, ints[0], ints[1], landOne, landTwo)) {
                    //返回结果
                    return count - 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code8().shortestBridge(new int[][]{
                new int[]{0, 1, 0},
                new int[]{0, 0, 0},
                new int[]{0, 0, 1}
        }));
    }
}
