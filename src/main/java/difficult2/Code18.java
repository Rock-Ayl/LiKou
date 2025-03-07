package difficult2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2024-08-05
 * 1368. 使网格图至少有一条有效路径的最小代价
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 m x n 的网格图 grid 。 grid 中每个格子都有一个数字，对应着从该格子出发下一步走的方向。 grid[i][j] 中的数字可能为以下几种情况：
 * <p>
 * 1 ，下一步往右走，也就是你会从 grid[i][j] 走到 grid[i][j + 1]
 * 2 ，下一步往左走，也就是你会从 grid[i][j] 走到 grid[i][j - 1]
 * 3 ，下一步往下走，也就是你会从 grid[i][j] 走到 grid[i + 1][j]
 * 4 ，下一步往上走，也就是你会从 grid[i][j] 走到 grid[i - 1][j]
 * 注意网格图中可能会有 无效数字 ，因为它们可能指向 grid 以外的区域。
 * <p>
 * 一开始，你会从最左上角的格子 (0,0) 出发。我们定义一条 有效路径 为从格子 (0,0) 出发，每一步都顺着数字对应方向走，最终在最右下角的格子 (m - 1, n - 1) 结束的路径。有效路径 不需要是最短路径 。
 * <p>
 * 你可以花费 cost = 1 的代价修改一个格子中的数字，但每个格子中的数字 只能修改一次 。
 * <p>
 * 请你返回让网格图至少有一条有效路径的最小代价。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]
 * 输出：3
 * 解释：你将从点 (0, 0) 出发。
 * 到达 (3, 3) 的路径为： (0, 0) --> (0, 1) --> (0, 2) --> (0, 3) 花费代价 cost = 1 使方向向下 --> (1, 3) --> (1, 2) --> (1, 1) --> (1, 0) 花费代价 cost = 1 使方向向下 --> (2, 0) --> (2, 1) --> (2, 2) --> (2, 3) 花费代价 cost = 1 使方向向下 --> (3, 3)
 * 总花费为 cost = 3.
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,1,3],[3,2,2],[1,1,4]]
 * 输出：0
 * 解释：不修改任何数字你就可以从 (0, 0) 到达 (2, 2) 。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,2],[4,3]]
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：grid = [[2,2,2],[2,2,2]]
 * 输出：3
 * 示例 5：
 * <p>
 * 输入：grid = [[4]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 */
public class Code18 {

    //递归走下去,并记录走过的路径
    private void move(int[][] grid, int[][] cacheArr, List<int[]> nextList, int x, int y, int changeCount) {
        //如果越界
        if (x < 0 || y < 0 || x >= cacheArr.length | y >= cacheArr[0].length) {
            //过
            return;
        }
        //如果已经走过了
        if (cacheArr[x][y] != 0) {
            //过
            return;
        }
        //覆盖修改次数
        cacheArr[x][y] = changeCount;
        //记录下一步尝试走的节点
        nextList.add(new int[]{x + 1, y});
        nextList.add(new int[]{x - 1, y});
        nextList.add(new int[]{x, y + 1});
        nextList.add(new int[]{x, y - 1});
        //根据当前方向,继续走
        switch (grid[x][y]) {
            case 1:
                //尝试递归走下去
                move(grid, cacheArr, nextList, x, y + 1, changeCount);
                break;
            case 2:
                //尝试递归走下去
                move(grid, cacheArr, nextList, x, y - 1, changeCount);
                break;
            case 3:
                //尝试递归走下去
                move(grid, cacheArr, nextList, x + 1, y, changeCount);
                break;
            case 4:
                //尝试递归走下去
                move(grid, cacheArr, nextList, x - 1, y, changeCount);
                break;
        }
    }

    public int minCost(int[][] grid) {
        //矩阵宽高
        int m = grid.length;
        int n = grid[0].length;
        //初始化开始节点列表
        List<int[]> startList = new ArrayList<>();
        //默认从0,0出发
        startList.add(new int[]{0, 0});
        //修改次数从1开始数
        int changeCount = 1;
        //初始化矩阵缓存
        int[][] cacheArr = new int[m][n];
        //如果还没有走到目标
        while (cacheArr[m - 1][n - 1] == 0) {
            //初始化本次走过的节点列表
            List<int[]> endList = new ArrayList<>();
            //循环所有开始节点
            for (int[] startArr : startList) {
                //递归走下去,并记录走过的路径
                move(grid, cacheArr, endList, startArr[0], startArr[1], changeCount);
            }
            //下一级
            startList = endList;
            ++changeCount;
        }
        //返回结果
        return cacheArr[m - 1][n - 1] - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Code18().minCost(new int[][]{
                new int[]{1, 1, 1, 1},
                new int[]{2, 2, 2, 2},
                new int[]{1, 1, 1, 1},
                new int[]{2, 2, 2, 2}
        }));
    }

}
