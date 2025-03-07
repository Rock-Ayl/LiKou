package normal33;

/**
 * @Author ayl
 * @Date 2024-07-17
 * LCR 013. 二维区域和检索 - 矩阵不可变
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 * <p>
 * 计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 * 实现 NumMatrix 类：
 * <p>
 * NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2) 返回左上角 (row1, col1) 、右下角 (row2, col2) 的子矩阵的元素总和。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入:
 * ["NumMatrix","sumRegion","sumRegion","sumRegion"]
 * [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
 * 输出:
 * [null, 8, 11, 12]
 * <p>
 * 解释:
 * NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]]);
 * numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
 * numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
 * numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * -105 <= matrix[i][j] <= 105
 * 0 <= row1 <= row2 < m
 * 0 <= col1 <= col2 < n
 * 最多调用 104 次 sumRegion 方法
 * <p>
 * <p>
 * 注意：本题与主站 304 题相同： https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 */
public class Code12 {

    //缓存和数组
    private int[][] cacaeArr;

    public Code12(int[][] matrix) {
        //初始化
        this.cacaeArr = new int[matrix.length][matrix[0].length];
        //循环1
        for (int i = 0; i < matrix.length; i++) {
            //循环2
            for (int j = 0; j < matrix[0].length; j++) {
                //计算当前网格和
                this.cacaeArr[i][j] = matrix[i][j]
                        + getFromArr(this.cacaeArr, i - 1, j)
                        + getFromArr(this.cacaeArr, i, j - 1)
                        - getFromArr(this.cacaeArr, i - 1, j - 1);
            }
        }
    }

    //通用方法-根据坐标获取数组内容,防止越界
    private int getFromArr(int[][] arr, int x, int y) {
        //如果越界
        if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length) {
            //默认
            return 0;
        }
        //获取
        return arr[x][y];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        //如果从起始坐标开始
        if (row1 == 0 && col1 == 0) {
            //直接返回
            return this.cacaeArr[row2][col2];
        }
        //如果x轴开始为0
        if (row1 == 0) {
            //计算返回
            return this.cacaeArr[row2][col2] - getFromArr(this.cacaeArr, row2, col1 - 1);
        }
        //如果y轴开始为0
        if (col1 == 0) {
            //计算返回
            return this.cacaeArr[row2][col2] - getFromArr(this.cacaeArr, row1 - 1, col2);
        }
        int a = this.cacaeArr[row2][col2];
        int b = getFromArr(this.cacaeArr, row1 - 1, col2);
        int c = getFromArr(this.cacaeArr, row2, col1 - 1);
        int d = getFromArr(this.cacaeArr, row1 - 1, col1 - 1);
        //一般情况
        return a
                - b
                - c
                + d;
    }

    public static void main(String[] args) {
        Code12 code12 = new Code12(new int[][]{
                new int[]{3, 0, 1, 4, 2},
                new int[]{5, 6, 3, 2, 1},
                new int[]{1, 2, 0, 1, 5},
                new int[]{4, 1, 0, 1, 7},
                new int[]{1, 0, 3, 0, 5}
        });
        System.out.println(code12.sumRegion(2, 1, 4, 3));
        System.out.println(code12.sumRegion(1, 1, 2, 2));
        System.out.println(code12.sumRegion(1, 2, 2, 4));

    }

}
