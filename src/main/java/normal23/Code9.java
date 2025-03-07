package normal23;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2023-08-19
 * 2257. 统计网格图中没有被保卫的格子数
 * 提示
 * 中等
 * 18
 * 相关企业
 * 给你两个整数 m 和 n 表示一个下标从 0 开始的 m x n 网格图。同时给你两个二维整数数组 guards 和 walls ，其中 guards[i] = [rowi, coli] 且 walls[j] = [rowj, colj] ，分别表示第 i 个警卫和第 j 座墙所在的位置。
 * <p>
 * 一个警卫能看到 4 个坐标轴方向（即东、南、西、北）的 所有 格子，除非他们被一座墙或者另外一个警卫 挡住 了视线。如果一个格子能被 至少 一个警卫看到，那么我们说这个格子被 保卫 了。
 * <p>
 * 请你返回空格子中，有多少个格子是 没被保卫 的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
 * 输出：7
 * 解释：上图中，被保卫和没有被保卫的格子分别用红色和绿色表示。
 * 总共有 7 个没有被保卫的格子，所以我们返回 7 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
 * 输出：4
 * 解释：上图中，没有被保卫的格子用绿色表示。
 * 总共有 4 个没有被保卫的格子，所以我们返回 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 105
 * 2 <= m * n <= 105
 * 1 <= guards.length, walls.length <= 5 * 104
 * 2 <= guards.length + walls.length <= m * n
 * guards[i].length == walls[j].length == 2
 * 0 <= rowi, rowj < m
 * 0 <= coli, colj < n
 * guards 和 walls 中所有位置 互不相同 。
 */
public class Code9 {

    //一直看上边
    private void up(int[][] arr, int x, int y) {
        //如果越界
        if (x < 0) {
            //过
            return;
        }
        //如果是墙、守卫
        if (arr[x][y] == 1 || arr[x][y] == 2) {
            //过
            return;
        }
        //记录为被守卫的区域
        arr[x][y] = 3;
        //继续看
        up(arr, x - 1, y);
    }

    //一直看下边
    private void down(int[][] arr, int x, int y) {
        //如果越界
        if (x == arr.length) {
            //过
            return;
        }
        //如果是墙、守卫
        if (arr[x][y] == 1 || arr[x][y] == 2) {
            //过
            return;
        }
        //记录为被守卫的区域
        arr[x][y] = 3;
        //继续看
        down(arr, x + 1, y);
    }

    //一直看左边
    private void left(int[][] arr, int x, int y) {
        //如果越界
        if (y < 0) {
            //过
            return;
        }
        //如果是墙、守卫
        if (arr[x][y] == 1 || arr[x][y] == 2) {
            //过
            return;
        }
        //记录为被守卫的区域
        arr[x][y] = 3;
        //继续看
        left(arr, x, y - 1);
    }

    //一直看右边
    private void right(int[][] arr, int x, int y) {
        //如果越界
        if (y == arr[0].length) {
            //过
            return;
        }
        //如果是墙、守卫
        if (arr[x][y] == 1 || arr[x][y] == 2) {
            //过
            return;
        }
        //记录为被守卫的区域
        arr[x][y] = 3;
        //继续看
        right(arr, x, y + 1);
    }

    //开始递归守卫
    private void guard(int[][] arr, int x, int y) {
        //上下左右分别看
        up(arr, x - 1, y);
        down(arr, x + 1, y);
        left(arr, x, y - 1);
        right(arr, x, y + 1);
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        //初始化数组
        int[][] arr = new int[m][n];
        //循环警卫
        for (int[] guard : guards) {
            //安插警卫
            arr[guard[0]][guard[1]] = 1;
        }
        //循环墙
        for (int[] wall : walls) {
            //设置墙
            arr[wall[0]][wall[1]] = 2;
        }
        //循环警卫
        for (int[] guard : guards) {
            //开始守卫
            guard(arr, guard[0], guard[1]);
        }
        //返回未被守护区域的数量
        return Arrays
                .stream(arr)
                .map(p -> Arrays
                        .stream(p)
                        .filter(q -> q == 0)
                        .count()
                )
                .reduce((a, b) -> a + b)
                .orElse(0L)
                .intValue();
    }

    public static void main(String[] args) {
        System.out.println(new Code9().countUnguarded(5, 5, new int[][]{
                new int[]{1, 4},
                new int[]{4, 1},
                new int[]{0, 3}
        }, new int[][]{
                new int[]{3, 2}
        }));
    }

}
