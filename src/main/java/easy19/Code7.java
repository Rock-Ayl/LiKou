package easy19;

/**
 * @Author ayl
 * @Date 2022-05-23
 * 2133. 检查是否每一行每一列都包含全部整数
 * 对一个大小为 n x n 的矩阵而言，如果其每一行和每一列都包含从 1 到 n 的 全部 整数（含 1 和 n），则认为该矩阵是一个 有效 矩阵。
 * <p>
 * 给你一个大小为 n x n 的整数矩阵 matrix ，请你判断矩阵是否为一个有效矩阵：如果是，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[3,1,2],[2,3,1]]
 * 输出：true
 * 解释：在此例中，n = 3 ，每一行和每一列都包含数字 1、2、3 。
 * 因此，返回 true 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：matrix = [[1,1,1],[1,2,3],[1,2,3]]
 * 输出：false
 * 解释：在此例中，n = 3 ，但第一行和第一列不包含数字 2 和 3 。
 * 因此，返回 false 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * 1 <= matrix[i][j] <= n
 */
public class Code7 {

    public boolean checkValid(int[][] matrix) {
        //长宽
        int n = matrix.length;
        //预设宽度
        int size = n + 1;
        //横纵分别的缓存
        int[][] xArr = new int[size][size];
        int[][] yArr = new int[size][size];
        //循环1
        for (int i = 0; i < n; i++) {
            //循环2
            for (int j = 0; j < n; j++) {
                //当前
                int space = matrix[i][j];
                //如果之前有x或y了
                if (xArr[i][space]++ > 0 || yArr[j][space]++ > 0) {
                    //过
                    return false;
                }
            }
        }
        //默认
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().checkValid(new int[][]{
                new int[]{1, 2},
                new int[]{1, 2}
        }));
    }

}
