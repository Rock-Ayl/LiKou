package normal33;

/**
 * @Author ayl
 * @Date 2024-07-16
 * 1314. 矩阵区域和
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和：
 * <p>
 * i - k <= r <= i + k,
 * j - k <= c <= j + k 且
 * (r, c) 在矩阵内。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[12,21,16],[27,45,33],[24,39,28]]
 * 示例 2：
 * <p>
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
 * 输出：[[45,45,45],[45,45,45],[45,45,45]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n, k <= 100
 * 1 <= mat[i][j] <= 100
 */
public class Code11 {

    public int[][] matrixBlockSum(int[][] mat, int k) {
        //缓存数组
        int[][] sumCacheArr = new int[mat.length][mat[0].length];
        //初始化第一个节点
        sumCacheArr[0][0] = mat[0][0];
        //循环
        for (int i = 1; i < mat.length; i++) {
            //叠加第一列
            sumCacheArr[i][0] = sumCacheArr[i - 1][0] + mat[i][0];
        }
        //循环
        for (int j = 1; j < mat[0].length; j++) {
            //叠加第一行
            sumCacheArr[0][j] = sumCacheArr[0][j - 1] + mat[0][j];
        }
        //循环
        for (int i = 1; i < mat.length; i++) {
            //循环
            for (int j = 1; j < mat[0].length; j++) {
                //计算当前节点和
                sumCacheArr[i][j] = mat[i][j] + sumCacheArr[i - 1][j] + sumCacheArr[i][j - 1] - sumCacheArr[i - 1][j - 1];
            }
        }
        //结果数组
        int[][] resultArr = new int[mat.length][mat[0].length];
        //循环1
        for (int i = 0; i < resultArr.length; i++) {
            //循环2
            for (int j = 0; j < resultArr[0].length; j++) {
                //计算目标区域坐标
                int startX = Math.max(0, i - k);
                int startY = Math.max(0, j - k);
                int endX = Math.min(mat.length - 1, i + k);
                int endY = Math.min(mat[0].length - 1, j + k);
                //如果不需要做任何处理
                if (startX == 0 && startY == 0) {
                    //直接赋予和
                    resultArr[i][j] = sumCacheArr[endX][endY];
                    //本轮过
                    continue;
                }
                //如果x坐标为0
                if (startX == 0) {
                    //计算
                    resultArr[i][j] = sumCacheArr[endX][endY] - sumCacheArr[endX][startY - 1];
                    //本轮过
                    continue;
                }
                //如果y坐标为0
                if (startY == 0) {
                    //计算
                    resultArr[i][j] = sumCacheArr[endX][endY] - sumCacheArr[startX - 1][endY];
                    //本轮过
                    continue;
                }
                //一般情况,计算
                resultArr[i][j] = sumCacheArr[endX][endY]
                        - sumCacheArr[startX - 1][endY]
                        - sumCacheArr[endX][startY - 1]
                        + sumCacheArr[startX - 1][startY - 1];
            }
        }
        //返回
        return resultArr;
    }

    public static void main(String[] args) {
        new Code11().matrixBlockSum(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        }, 1);
    }

}
