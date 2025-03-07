package easy36;

/**
 * @Author ayl
 * @Date 2024-03-30
 * 892. 三维形体的表面积
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个 n * n 的网格 grid ，上面放置着一些 1 x 1 x 1 的正方体。每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * <p>
 * 放置好正方体后，任何直接相邻的正方体都会互相粘在一起，形成一些不规则的三维形体。
 * <p>
 * 请你返回最终这些形体的总表面积。
 * <p>
 * 注意：每个形体的底面也需要计入表面积中。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[1,2],[3,4]]
 * 输出：34
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 示例 3：
 * <p>
 * <p>
 * 输入：grid = [[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 50
 * 0 <= grid[i][j] <= 50
 */
public class Code18 {

    //获取节点值,设置最大值
    private int get(int[][] grid, int x, int y, int max) {
        //如果越界
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            //过
            return 0;
        }
        //返回
        return Math.min(grid[x][y], max);
    }

    private int count(int[][] grid, int x, int y) {
        //当前
        int space = grid[x][y];
        //如果没有
        if (space == 0) {
            //过
            return 0;
        }
        //本节点理论上最大面积
        int count = space * 4 + 2;
        //减去四个方向
        count -= get(grid, x + 1, y, space) +
                get(grid, x - 1, y, space) +
                get(grid, x, y + 1, space) +
                get(grid, x, y - 1, space);
        //返回
        return count;
    }

    public int surfaceArea(int[][] grid) {
        //结果
        int count = 0;
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //计算本节点面积
                count += count(grid, i, j);
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code18().surfaceArea(new int[][]{
                new int[]{1, 2},
                new int[]{3, 4}
        }));
    }

}
