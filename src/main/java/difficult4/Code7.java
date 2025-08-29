package difficult4;

/**
 * @Author ayl
 * @Date 2025-08-29
 * 2435. 矩阵中和能被 K 整除的路径
 * 算术评级: 6
 * 第 314 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 1952
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的 m x n 整数矩阵 grid 和一个整数 k 。你从起点 (0, 0) 出发，每一步只能往 下 或者往 右 ，你想要到达终点 (m - 1, n - 1) 。
 * <p>
 * 请你返回路径和能被 k 整除的路径数目，由于答案可能很大，返回答案对 109 + 7 取余 的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[5,2,4],[3,0,5],[0,7,2]], k = 3
 * 输出：2
 * 解释：有两条路径满足路径上元素的和能被 k 整除。
 * 第一条路径为上图中用红色标注的路径，和为 5 + 2 + 4 + 5 + 2 = 18 ，能被 3 整除。
 * 第二条路径为上图中用蓝色标注的路径，和为 5 + 3 + 0 + 5 + 2 = 15 ，能被 3 整除。
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[0,0]], k = 5
 * 输出：1
 * 解释：红色标注的路径和为 0 + 0 = 0 ，能被 5 整除。
 * 示例 3：
 * <p>
 * <p>
 * 输入：grid = [[7,3,4,9],[2,3,6,2],[2,3,7,0]], k = 1
 * 输出：10
 * 解释：每个数字都能被 1 整除，所以每一条路径的和都能被 k 整除。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 5 * 104
 * 1 <= m * n <= 5 * 104
 * 0 <= grid[i][j] <= 100
 * 1 <= k <= 50
 */
public class Code7 {

    public int numberOfPaths(int[][] grid, int k) {
        //初始化动态规划
        int[][][] arr = new int[grid.length][grid[0].length][k];
        //初始化第一个节点
        arr[0][0][grid[0][0] % k]++;
        //循环
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //如果是一个节点
                if (i == 0 && j == 0) {
                    //本轮过
                    continue;
                }
                //获取当前数字
                int num = grid[i][j];
                //分别获取左边、上边
                int[] upArr = getArr(arr, i - 1, j);
                int[] leftArr = getArr(arr, i, j - 1);
                //循环
                for (int sum = 0; sum < upArr.length; sum++) {
                    //获取次数
                    int count = upArr[sum];
                    //如果是0
                    if (count == 0) {
                        //本轮过
                        continue;
                    }
                    //下一个和
                    int nextSum = (sum + num) % k;
                    //叠加本次count
                    arr[i][j][nextSum] = ((arr[i][j][nextSum] % 1000000007) + count) % 1000000007;
                }
                //循环
                for (int sum = 0; sum < leftArr.length; sum++) {
                    //获取次数
                    int count = leftArr[sum];
                    //如果是0
                    if (count == 0) {
                        //本轮过
                        continue;
                    }
                    //下一个和
                    int nextSum = (sum + num) % k;
                    //叠加本次count
                    arr[i][j][nextSum] = ((arr[i][j][nextSum] % 1000000007) + count) % 1000000007;
                }
            }
        }
        //返回
        return arr[arr.length - 1][arr[0].length - 1][0];
    }

    //获取数组
    private int[] getArr(int[][][] arr, int x, int y) {
        //如果越界
        if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length) {
            //过
            return new int[]{};
        }
        //返回
        return arr[x][y];
    }

    public static void main(String[] args) {
        System.out.println(new Code7().numberOfPaths(new int[][]{
                new int[]{5, 2, 4},
                new int[]{3, 0, 5},
                new int[]{0, 7, 2}
        }, 3));
    }

}
