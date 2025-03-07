package normal14;

/**
 * @Author ayl
 * @Date 2022-06-17
 * 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 示例 2：
 * <p>
 * <p>
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 */
public class Code7 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //初始化结果集合,里面记录到每个点的路径
        int[][] arr = new int[obstacleGrid.length][obstacleGrid[0].length];
        //循环1
        for (int i = 0; i < obstacleGrid.length; i++) {
            //如果是障碍物
            if (obstacleGrid[i][0] == 1) {
                //彻底结束,接下来的位置都走不到
                break;
            }
            //默认
            arr[i][0] = 1;
        }
        //循环2
        for (int j = 0; j < obstacleGrid[0].length; j++) {
            //如果是障碍物
            if (obstacleGrid[0][j] == 1) {
                //彻底结束,接下来的位置都走不到
                break;
            }
            //默认
            arr[0][j] = 1;
        }
        //循环3
        for (int i = 1; i < obstacleGrid.length; i++) {
            //循环4
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                //如果当前是障碍物
                if (obstacleGrid[i][j] == 1) {
                    //本轮过,只是这里走不过去而已
                    continue;
                }
                //当前位置的路径是左边+上面的总数
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
            }
        }
        //返回结果
        return arr[arr.length - 1][arr[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Code7().uniquePathsWithObstacles(new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 0}
        }));
    }

}
