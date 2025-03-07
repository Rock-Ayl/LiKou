package normal25;

/**
 * @Author ayl
 * @Date 2023-11-09
 * 1277. 统计全为 1 的正方形子矩阵
 * 提示
 * 中等
 * 308
 * 相关企业
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix =
 * [
 * [0,1,1,1],
 * [1,1,1,1],
 * [0,1,1,1]
 * ]
 * 输出：15
 * 解释：
 * 边长为 1 的正方形有 10 个。
 * 边长为 2 的正方形有 4 个。
 * 边长为 3 的正方形有 1 个。
 * 正方形的总数 = 10 + 4 + 1 = 15.
 * 示例 2：
 * <p>
 * 输入：matrix =
 * [
 * [1,0,1],
 * [1,1,0],
 * [1,1,0]
 * ]
 * 输出：7
 * 解释：
 * 边长为 1 的正方形有 6 个。
 * 边长为 2 的正方形有 1 个。
 * 正方形的总数 = 6 + 1 = 7.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 300
 * 1 <= arr[0].length <= 300
 * 0 <= arr[i][j] <= 1
 */
public class Code22 {

    //数量
    private int count = 0;

    //递归
    private void next(int[][] matrix, int x, int y, int maxX, int maxY) {
        //如果越界
        if (maxX >= matrix.length || maxY >= matrix[0].length) {
            //过
            return;
        }
        //如果最后一个不是
        if (matrix[maxX][maxY] == 0) {
            //过
            return;
        }
        //循环1
        for (int i = y; i < maxY; i++) {
            //如果是0,说明不是正方形了
            if (matrix[maxX][i] == 0) {
                //本次不是
                return;
            }
        }
        //循环2
        for (int i = x; i < maxX; i++) {
            //如果是0,说明不是正方形了
            if (matrix[i][maxY] == 0) {
                //本次不是
                return;
            }
        }
        //记录本次的正方形数量
        this.count++;
        //尝试更大的正方形递归
        next(matrix, x, y, maxX + 1, maxY + 1);
    }

    public int countSquares(int[][] matrix) {
        //循环1
        for (int i = 0; i < matrix.length; i++) {
            //循环2
            for (int j = 0; j < matrix[0].length; j++) {
                //递归出正方形
                next(matrix, i, j, i, j);
            }
        }
        //返回
        return this.count;
    }

    //动态规划
    public int star(int[][] matrix) {
        //结果
        int res = 0;
        //循环1
        for (int i = 0; i < matrix.length; i++) {
            //循环2
            for (int j = 0; j < matrix[0].length; j++) {
                //如果满足
                if (i >= 1 && j >= 1 && matrix[i][j] == 1) {
                    matrix[i][j] += Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j - 1], matrix[i][j - 1]));
                }
                //记录结果
                res += matrix[i][j];
            }
        }
        print(matrix);
        //返回
        return res;
    }

    //打印
    private void print(int[][] cacheArr) {
        for (int[] booleans : cacheArr) {
            for (int aBoolean : booleans) {
                System.out.print((aBoolean + ","));
            }
            System.out.println();
        }
        System.out.println("##########");
    }

    public static void main(String[] args) {
        System.out.println(new Code22().star(new int[][]{
                new int[]{0, 1, 1, 1},
                new int[]{1, 1, 1, 1},
                new int[]{0, 1, 1, 1}
        }));
    }

}
