package easy24;

/**
 * @Author ayl
 * @Date 2022-11-01
 * 867. 转置矩阵
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 * <p>
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 1 <= m * n <= 105
 * -109 <= matrix[i][j] <= 109
 */
public class Code12 {

    public int[][] transpose(int[][] matrix) {
        //初始化结果
        int[][] result = new int[matrix[0].length][matrix.length];
        //指针
        int x = 0;
        int y = 0;
        //循环1,按顺序遍历matrix
        for (int[] link : matrix) {
            //循环2
            for (int num : link) {
                //记录
                result[x++][y] = num;
                //如果到头了
                if (x == result.length) {
                    //换列
                    x = 0;
                    y++;
                }
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        new Code12().transpose(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6}
        });
    }

}
