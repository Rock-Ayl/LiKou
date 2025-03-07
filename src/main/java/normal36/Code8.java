package normal36;

/**
 * @Author ayl
 * @Date 2024-10-18
 * 1292. 元素和小于等于阈值的正方形的最大边长
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。
 * <p>
 * 请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
 * 输出：2
 * 解释：总和小于或等于 4 的正方形的最大边长为 2，如图所示。
 * 示例 2：
 * <p>
 * 输入：mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 300
 * 0 <= mat[i][j] <= 104
 * 0 <= threshold <= 105
 */
public class Code8 {

    //获取数组值
    private int get(int[][] arr, int x, int y) {
        //如果越界
        if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length) {
            //默认
            return 0;
        }
        //返回值
        return arr[x][y];
    }

    public int maxSideLength(int[][] mat, int threshold) {
        //前缀和数组
        int[][] sumArr = new int[mat.length][mat[0].length];
        //循环1
        for (int i = 0; i < sumArr.length; i++) {
            //循环2
            for (int j = 0; j < sumArr[0].length; j++) {
                //计算当前
                sumArr[i][j] = mat[i][j]
                        + get(sumArr, i - 1, j)
                        + get(sumArr, i, j - 1)
                        - get(sumArr, i - 1, j - 1);
            }
        }
        //正方形的长度,默认取最大
        int length = Math.min(mat.length, mat[0].length);
        //循环
        while (length > 0) {
            //循环1
            for (int i = length - 1; i < mat.length; i++) {
                //循环2
                for (int j = length - 1; j < mat[0].length; j++) {
                    //开始节点
                    int startX = i - length;
                    int startY = j - length;
                    //计算出当前正方形和
                    int sum = sumArr[i][j]
                            - get(sumArr, startX, j)
                            - get(sumArr, i, startY)
                            + get(sumArr, startX, startY);
                    //如果是目标
                    if (sum <= threshold) {
                        //返回结果
                        return length;
                    }
                }
            }
            //预期正方形长度减少
            length--;
        }
        //默认返回
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().maxSideLength(new int[][]{
                new int[]{1, 1, 3, 2, 4, 3, 2},
                new int[]{1, 1, 3, 2, 4, 3, 2},
                new int[]{1, 1, 3, 2, 4, 3, 2}
        }, 4));
    }

}
