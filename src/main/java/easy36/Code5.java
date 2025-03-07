package easy36;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-02-13
 * 3033. 修改矩阵
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个下标从 0 开始、大小为 m x n 的整数矩阵 matrix ，新建一个下标从 0 开始、名为 answer 的矩阵。使 answer 与 matrix 相等，接着将其中每个值为 -1 的元素替换为所在列的 最大 元素。
 * <p>
 * 返回矩阵 answer 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,-1],[4,-1,6],[7,8,9]]
 * 输出：[[1,2,9],[4,8,6],[7,8,9]]
 * 解释：上图显示了发生替换的元素（蓝色区域）。
 * - 将单元格 [1][1] 中的值替换为列 1 中的最大值 8 。
 * - 将单元格 [0][2] 中的值替换为列 2 中的最大值 9 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[3,-1],[5,2]]
 * 输出：[[3,2],[5,2]]
 * 解释：上图显示了发生替换的元素（蓝色区域）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 2 <= m, n <= 50
 * -1 <= matrix[i][j] <= 100
 * 测试用例中生成的输入满足每列至少包含一个非负整数。
 */
public class Code5 {

    //替换实现
    private void cover(int[][] matrix, int x, int y) {
        //获取最大并覆盖
        matrix[x][y] = Arrays.stream(matrix).map(p -> p[y]).mapToInt(Integer::intValue).max().getAsInt();
    }

    public int[][] modifiedMatrix(int[][] matrix) {
        //循环
        for (int i = 0; i < matrix.length; i++) {
            //循环2
            for (int j = 0; j < matrix[0].length; j++) {
                //如果是-1
                if (matrix[i][j] == -1) {
                    //实现
                    cover(matrix, i, j);
                }
            }
        }
        //返回
        return matrix;
    }

    public static void main(String[] args) {
        int[][] ints = new Code5().modifiedMatrix(new int[][]{
                new int[]{1, 2, -1},
                new int[]{4, -1, 6},
                new int[]{7, 8, 9}
        });
        System.out.println();
    }

}
