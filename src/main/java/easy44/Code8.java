package easy44;

/**
 * 4052. 行列循环移位
 * 算术评级: 3
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n、一个大小为 n x n 的二维整数数组 grid，以及两个长度均为 n 的整数数组 rowShift 和 colShift，其中：
 * <p>
 * rowShift[i] 表示将 grid 的第 i 行向左 循环移位 的位数。
 * colShift[j] 表示将 grid 的第 j 列向上 循环移位 的位数。
 * 首先按照 rowShift 对每一行进行循环移位，然后按照 colShift 对每一列进行循环移位。
 * <p>
 * 返回完成所有移位操作后的网格。
 * <p>
 * 将第 i 行向左 循环移位 k 位时，只移动该行。原本位于第 j 列的元素会移动到第 (j - k + n) % n 列，其余各行保持不变。
 * <p>
 * 将第 j 列向上 循环移位 k 位时，只移动该列。原本位于第 i 行的元素会移动到第 (i - k + n) % n 行，其余各列保持不变。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 2, grid = [[1,2],[3,4]], rowShift = [1,0], colShift = [0,1]
 * <p>
 * 输出： [[2,4],[3,1]]
 * <p>
 * 解释：
 * <p>
 * grid 的变化过程如下：
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 3, grid = [[1,2,3],[4,5,6],[7,8,9]], rowShift = [1,2,0], colShift = [2,2,1]
 * <p>
 * 输出： [[7,8,5],[2,3,9],[6,4,1]]
 * <p>
 * 解释：
 * <p>
 * grid 的变化过程如下：
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == grid.length == grid[i].length <= 10
 * 1 <= grid[i][j] <= 100
 * rowShift.length == colShift.length == n
 * 0 <= rowShift[i], colShift[i] < n
 */
public class Code8 {

    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        //循环
        for (int i = 0; i < rowShift.length; i++) {
            //移动
            row(n, grid, i, rowShift[i]);
        }
        //循环
        for (int i = 0; i < colShift.length; i++) {
            //移动
            col(n, grid, i, colShift[i]);
        }
        //返回
        return grid;
    }

    //移动一次
    private void row(int n, int[][] grid, int index, int k) {
        //临时数组
        int[] cloneArr = grid[index].clone();
        //循环
        for (int j = 0; j < n; j++) {
            grid[index][j] = cloneArr[(j + k) % n];
        }
    }

    //移动一次
    private void col(int n, int[][] grid, int index, int k) {
        //临时数组
        int[] cloneArr = new int[n];
        //循环
        for (int i = 0; i < n; i++) {
            //复制
            cloneArr[i] = grid[i][index];
        }
        //循环
        for (int i = 0; i < n; i++) {
            //赋值
            grid[i][index] = cloneArr[(i + k) % n];
        }
    }

    public static void main(String[] args) {
        //int[][] ints = new Code8().cyclicShift(2, new int[][]{{1, 2}, {3, 4}}, new int[]{1, 0}, new int[]{0, 1});

        // n = 3, grid = [[1,2,3],[4,5,6],[7,8,9]], rowShift = [1,2,0], colShift = [2,2,1]
        int[][] ints2 = new Code8().cyclicShift(3, new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                new int[]{
                        1, 2, 0
                },
                new int[]{
                        2, 2, 1
                });

        System.out.println();
    }

}
