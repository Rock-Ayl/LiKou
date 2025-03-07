package normal33;

/**
 * @Author ayl
 * @Date 2024-07-19
 * 3070. 元素和小于等于 k 的子矩阵的数目
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个下标从 0 开始的整数矩阵 grid 和一个整数 k。
 * <p>
 * 返回包含 grid 左上角元素、元素和小于或等于 k 的
 * 子矩阵
 * 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[7,6,3],[6,6,1]], k = 18
 * 输出：4
 * 解释：如上图所示，只有 4 个子矩阵满足：包含 grid 的左上角元素，并且元素和小于或等于 18 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[7,2,9],[1,5,0],[2,6,6]], k = 20
 * 输出：6
 * 解释：如上图所示，只有 6 个子矩阵满足：包含 grid 的左上角元素，并且元素和小于或等于 20 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= n, m <= 1000
 * 0 <= grid[i][j] <= 1000
 * 1 <= k <= 109
 */
public class Code13 {

    //获取数组内容
    private int get(int[][] arr, int x, int y) {
        //如果越界
        if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length) {
            //默认
            return 0;
        }
        //获取
        return arr[x][y];
    }

    public int countSubmatrices(int[][] grid, int k) {
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //计算当前网格和
                grid[i][j] = grid[i][j] + get(grid, i - 1, j) + get(grid, i, j - 1) - get(grid, i - 1, j - 1);
            }
        }
        //和
        int count = 0;
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //如果后面不会有了
                if (grid[i][j] > k) {
                    //跳出本次循环
                    break;
                }
                //+1
                ++count;
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().countSubmatrices(new int[][]{
                new int[]{7, 2, 9},
                new int[]{1, 5, 0},
                new int[]{2, 6, 6}
        }, 20));;
    }

}
