package normal33;

/**
 * @Author ayl
 * @Date 2024-07-14
 * 3212. 统计 X 和 Y 频数相等的子矩阵数量
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个二维字符矩阵 grid，其中 grid[i][j] 可能是 'X'、'Y' 或 '.'，返回满足以下条件的
 * 子矩阵
 * 数量：
 * <p>
 * 包含 grid[0][0]
 * 'X' 和 'Y' 的频数相等。
 * 至少包含一个 'X'。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： grid = [["X","Y","."],["Y",".","."]]
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入： grid = [["X","X"],["X","Y"]]
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 不存在满足 'X' 和 'Y' 频数相等的子矩阵。
 * <p>
 * 示例 3：
 * <p>
 * 输入： grid = [[".","."],[".","."]]
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 不存在满足至少包含一个 'X' 的子矩阵。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length, grid[i].length <= 1000
 * grid[i][j] 可能是 'X'、'Y' 或 '.'.
 */
public class Code10 {

    //前缀和-寻找并填充字符在数组的数量
    private void findAndSetChar(char[][] grid, int[][] arr, char letter) {
        //初始化第一个
        arr[0][0] = grid[0][0] == letter ? 1 : 0;
        //循环
        for (int j = 1; j < grid[0].length; j++) {
            //计算第一行
            arr[0][j] = arr[0][j - 1] + (grid[0][j] == letter ? 1 : 0);
        }
        //循环
        for (int i = 1; i < grid.length; i++) {
            //计算第一列
            arr[i][0] = arr[i - 1][0] + (grid[i][0] == letter ? 1 : 0);
        }
        //循环1
        for (int i = 1; i < grid.length; i++) {
            //循环2
            for (int j = 1; j < grid[0].length; j++) {
                //计算该单元格
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] + (grid[i][j] == letter ? 1 : 0);
            }
        }
    }

    public int numberOfSubmatrices(char[][] grid) {
        //宽高
        int x = grid.length;
        int y = grid[0].length;
        //缓存矩阵
        int[][] xArr = new int[x][y];
        int[][] yArr = new int[x][y];
        //寻找并填充
        findAndSetChar(grid, xArr, 'X');
        findAndSetChar(grid, yArr, 'Y');
        //结果
        int count = 0;
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //计算该单元格
                if (xArr[i][j] > 0 && xArr[i][j] == yArr[i][j]) {
                    //+1
                    count++;
                }
            }
        }
        //返回结果
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code10().numberOfSubmatrices(new char[][]{
                new char[]{'X', 'Y', '.'},
                new char[]{'Y', '.', '.'}
        }));
    }

}
