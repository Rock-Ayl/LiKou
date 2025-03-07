package normal28;

/**
 * @Author ayl
 * @Date 2024-01-30
 * 1391. 检查网格中是否存在有效路径
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 m x n 的网格 grid。网格里的每个单元都代表一条街道。grid[i][j] 的街道可以是：
 * <p>
 * 1 表示连接左单元格和右单元格的街道。
 * 2 表示连接上单元格和下单元格的街道。
 * 3 表示连接左单元格和下单元格的街道。
 * 4 表示连接右单元格和下单元格的街道。
 * 5 表示连接左单元格和上单元格的街道。
 * 6 表示连接右单元格和上单元格的街道。
 * <p>
 * <p>
 * 你最开始从左上角的单元格 (0,0) 开始出发，网格中的「有效路径」是指从左上方的单元格 (0,0) 开始、一直到右下方的 (m-1,n-1) 结束的路径。该路径必须只沿着街道走。
 * <p>
 * 注意：你 不能 变更街道。
 * <p>
 * 如果网格中存在有效的路径，则返回 true，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[2,4,3],[6,5,2]]
 * 输出：true
 * 解释：如图所示，你可以从 (0, 0) 开始，访问网格中的所有单元格并到达 (m - 1, n - 1) 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,2,1],[1,2,1]]
 * 输出：false
 * 解释：如图所示，单元格 (0, 0) 上的街道没有与任何其他单元格上的街道相连，你只会停在 (0, 0) 处。
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,2]]
 * 输出：false
 * 解释：你会停在 (0, 1)，而且无法到达 (0, 2) 。
 * 示例 4：
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,3]]
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：grid = [[2],[2],[2],[2],[2],[2],[6]]
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * 1 <= grid[i][j] <= 6
 */
public class Code13 {

    /**
     * 递归实现
     *
     * @param grid      网格
     * @param walked    网格是否走过
     * @param x         当前要走的坐标
     * @param y         当前要走的坐标
     * @param direction 来时的方向 1=从东来 2=从南来 3=从西来 4=从北来 -1等于起始地点
     * @return
     */
    private boolean next(int[][] grid, boolean[][] walked, int x, int y, int direction) {

        /**
         * 判断当前的坐标是否越界
         */

        //如果越界
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            //不成立
            return false;
        }

        /**
         * 判断来时方向与当前地图块比,是否合法
         */

        //当前地图块
        int type = grid[x][y];
        //根据类型,判断来时的放下是否合法
        switch (type) {
            case 1:
                //如果从南北来
                if (direction == 4 || direction == 2) {
                    //不能成立
                    return false;
                }
                break;
            case 2:
                //如果从东西来
                if (direction == 1 || direction == 3) {
                    //不能成立
                    return false;
                }
                break;
            case 3:
                //如果从东北来
                if (direction == 1 || direction == 4) {
                    //不能成立
                    return false;
                }
                break;
            case 4:
                //如果从西北来
                if (direction == 3 || direction == 4) {
                    //不能成立
                    return false;
                }
                break;
            case 5:
                //如果从东南来
                if (direction == 2 || direction == 1) {
                    //不能成立
                    return false;
                }
                break;
            case 6:
                //如果从西南来
                if (direction == 2 || direction == 3) {
                    //不能成立
                    return false;
                }
                break;
            //默认
            default:
                //不合法
                return false;
        }

        /**
         * 判断是否走过该路径,走过则跳过,没走过则记录走过
         */

        //如果走过了
        if (walked[x][y]) {
            //不成立
            return false;
        }
        //记录已经走过
        walked[x][y] = true;

        /**
         * 判断当前是否已经到结果了,如果是,直接返回
         */

        //如果到达目标
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            //结果成立
            return true;
        }

        /**
         * 计算出下一步的 坐标 and 方向
         */

        //下一步地图块坐标、方向,一共两种情况
        int oneX = x;
        int oneY = y;
        int oneDirection;
        int twoX = x;
        int twoY = y;
        int twoDirection;
        //根据类型,计算下一步坐标,以及来时的方向
        switch (type) {
            case 1:
                oneY++;
                oneDirection = 3;
                twoY--;
                twoDirection = 1;
                break;
            case 2:
                oneX++;
                oneDirection = 4;
                twoX--;
                twoDirection = 2;
                break;
            case 3:
                oneX++;
                oneDirection = 4;
                twoY--;
                twoDirection = 1;
                break;
            case 4:
                oneX++;
                oneDirection = 4;
                twoY++;
                twoDirection = 3;
                break;
            case 5:
                oneX--;
                oneDirection = 2;
                twoY--;
                twoDirection = 1;
                break;
            case 6:
                oneX--;
                oneDirection = 2;
                twoY++;
                twoDirection = 3;
                break;
            //默认
            default:
                //不成立
                return false;
        }

        /**
         * 执行递归下一步,如果有成功结果,优先返回
         */

        //如果这么走可以
        if (next(grid, walked, oneX, oneY, oneDirection) == true) {
            //结果成立
            return true;
        }
        //如果这么走可以
        if (next(grid, walked, twoX, twoY, twoDirection) == true) {
            //结果成立
            return true;
        }
        //默认不成立
        return false;
    }

    public boolean hasValidPath(int[][] grid) {
        //递归实现
        return next(grid, new boolean[grid.length][grid[0].length], 0, 0, -1);
    }

    public static void main(String[] args) {
        System.out.println(new Code13().hasValidPath(new int[][]{
                new int[]{2, 4, 3},
                new int[]{6, 5, 2}
        }));
    }

}
