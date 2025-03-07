package easy27;

/**
 * @Author ayl
 * @Date 2023-01-15
 * 566. 重塑矩阵
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 * <p>
 * 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 * <p>
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 * <p>
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：mat = [[1,2],[3,4]], r = 1, c = 4
 * 输出：[[1,2,3,4]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：mat = [[1,2],[3,4]], r = 2, c = 4
 * 输出：[[1,2],[3,4]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * -1000 <= mat[i][j] <= 1000
 * 1 <= r, c <= 300
 */
public class Code2 {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        //如果不合理
        if (mat.length * mat[0].length != r * c) {
            //返回原来的结果
            return mat;
        }
        //初始化列表
        int[][] result = new int[r][c];
        //指针
        int p = 0;
        int q = 0;
        //循环
        for (int i = 0; i < mat.length; i++) {
            //循环2
            for (int j = 0; j < mat[0].length; j++) {
                //先记录本次结果
                result[q][p++] = mat[i][j];
                //如果到头了
                if (p == c) {
                    //下一行
                    p = 0;
                    q++;
                }
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().matrixReshape(new int[][]{
                new int[]{1, 2, 3, 4}
        }, 2, 2));
    }

}
