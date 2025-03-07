package normal13;

/**
 * @Author ayl
 * @Date 2022-03-20
 * 931. 下降路径最小和
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * <p>
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * 输出：13
 * 解释：如图所示，为和最小的两条下降路径
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：matrix = [[-19,57],[-40,-5]]
 * 输出：-59
 * 解释：如图所示，为和最小的下降路径
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 */
public class Code10 {

    public int minFallingPathSum(int[][] matrix) {
        //宽高
        int height = matrix.length;
        int wide = matrix[0].length;
        //边界
        int right = wide - 1;
        //初始化结果矩阵
        int[][] arr = new int[height][wide];
        //循环,初始化第一行
        for (int i = 0; i < wide; i++) {
            //第一行
            arr[0][i] = matrix[0][i];
        }
        //循环1
        for (int i = 1; i < height; i++) {
            //循环2
            for (int j = 0; j < wide; j++) {
                //花销,默认为当前花销
                int sum = matrix[i][j];
                //根据j的位置,计算最小值
                if (j == 0) {
                    //找到上一步能到这里的最小路径
                    int min = Math.min(arr[i - 1][j], arr[i - 1][j + 1]);
                    //叠加
                    sum += min;
                } else if (j == right) {
                    //找到上一步能到这里的最小路径
                    int min = Math.min(arr[i - 1][j], arr[i - 1][j - 1]);
                    //叠加
                    sum += min;
                } else {
                    //找到上一步能到这里的最小路径
                    int min = Math.min(arr[i - 1][j + 1], Math.min(arr[i - 1][j], arr[i - 1][j - 1]));
                    //叠加
                    sum += min;
                }
                //记录
                arr[i][j] = sum;
            }
        }
        //最小结果
        int min = arr[height - 1][0];
        //循环,寻找最小
        for (int i = 1; i < wide; i++) {
            //刷新最小
            min = Math.min(min, arr[height - 1][i]);
        }
        //默认
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Code10().minFallingPathSum(new int[][]{
                new int[]{2, 1, 3},
                new int[]{6, 5, 4},
                new int[]{7, 8, 9},
                new int[]{4, 3, 6}
        }));
    }

}
