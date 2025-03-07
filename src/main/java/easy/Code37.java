package easy;

/**
 * Created By Rock-Ayl on 2020-09-16
 * 1351. 统计有序矩阵中的负数
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
 * <p>
 * 请你统计并返回 grid 中 负数 的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 * 示例 2：
 * <p>
 * 输入：grid = [[3,2],[1,0]]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：grid = [[1,-1],[-1,-1]]
 * 输出：3
 * 示例 4：
 * <p>
 * 输入：grid = [[-1]]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 */
public class Code37 {

    public static int countNegatives(int[][] grid) {
        //初始化次数
        int num = 0;
        //循环
        for (int[] ints : grid) {
            //循环
            for (int anInt : ints) {
                //如果是负数
                if (anInt < 0) {
                    //记录
                    num++;
                }
            }
        }
        //返回
        return num;
    }

    public static void main(String[] args) {
        System.out.println(countNegatives(new int[][]{new int[]{1, -2, 3}, new int[]{-1, 2, 3}, new int[]{1, 2, 3}}));
    }
}
