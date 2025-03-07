package easy23;

/**
 * @Author ayl
 * @Date 2022-09-29
 * 1572. 矩阵对角线元素的和
 * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
 * <p>
 * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 * <p>
 * <p>
 * <p>
 * 示例  1：
 * <p>
 * <p>
 * <p>
 * 输入：mat = [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * 输出：25
 * 解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
 * 请注意，元素 mat[1][1] = 5 只会被计算一次。
 * 示例  2：
 * <p>
 * 输入：mat = [[1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1]]
 * 输出：8
 * 示例 3：
 * <p>
 * 输入：mat = [[5]]
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == mat.length == mat[i].length
 * 1 <= n <= 100
 * 1 <= mat[i][j] <= 1001572. 矩阵对角线元素的和
 * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
 * <p>
 * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 * <p>
 * <p>
 * <p>
 * 示例  1：
 * <p>
 * <p>
 * <p>
 * 输入：mat = [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * 输出：25
 * 解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
 * 请注意，元素 mat[1][1] = 5 只会被计算一次。
 * 示例  2：
 * <p>
 * 输入：mat = [[1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1]]
 * 输出：8
 * 示例 3：
 * <p>
 * 输入：mat = [[5]]
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == mat.length == mat[i].length
 * 1 <= n <= 100
 * 1 <= mat[i][j] <= 100
 */
public class Code15 {

    public int diagonalSum(int[][] mat) {
        //初始化和
        int sum = 0;
        //循环
        for (int i = 0; i < mat.length; i++) {
            //叠加
            sum += mat[i][i];
        }
        //初始化
        int x = 0;
        int y = mat.length - 1;
        //循环
        while (y >= 0) {
            //叠加
            sum += mat[x++][y--];
        }
        //如果是单
        if (mat.length % 2 != 0) {
            //减去中心的
            return sum - mat[mat.length / 2][mat[0].length / 2];
        } else {
            //正常
            return sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code15().diagonalSum(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        }));
    }

}
