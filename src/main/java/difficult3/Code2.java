package difficult3;

/**
 * @Author ayl
 * @Date 2024-10-09
 * 1074. 元素和为目标值的子矩阵数量
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。
 * <p>
 * 子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。
 * <p>
 * 如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * 输出：4
 * 解释：四个只含 0 的 1x1 子矩阵。
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,-1],[-1,1]], target = 0
 * 输出：5
 * 解释：两个 1x2 子矩阵，加上两个 2x1 子矩阵，再加上一个 2x2 子矩阵。
 * 示例 3：
 * <p>
 * 输入：matrix = [[904]], target = 0
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= matrix.length <= 100
 * 1 <= matrix[0].length <= 100
 * -1000 <= matrix[i][j] <= 1000
 * -10^8 <= target <= 10^8
 */
public class Code2 {

    //获取数组内容
    private int getArr(int[][] arr, int x, int y) {
        //判断越界
        if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length) {
            //默认
            return 0;
        }
        //返回
        return arr[x][y];
    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {

        /**
         * step 1. 计算sum
         */

        //和数组
        int[][] sumArr = new int[matrix.length][matrix[0].length];
        //循环1
        for (int i = 0; i < matrix.length; i++) {
            //循环2
            for (int j = 0; j < matrix[0].length; j++) {
                //计算本位置
                sumArr[i][j] = matrix[i][j]
                        + getArr(sumArr, i - 1, j)
                        + getArr(sumArr, i, j - 1)
                        - getArr(sumArr, i - 1, j - 1);
            }
        }

        /**
         * step 2. 计算结果
         */

        //结果数量
        int count = 0;

        //循环1
        for (int i = 0; i < matrix.length; i++) {
            //循环2
            for (int j = 0; j < matrix[0].length; j++) {

                /**
                 * step 3. 计算本起始节点结果
                 */

                //循环3
                for (int x = i; x < matrix.length; x++) {
                    //循环4
                    for (int y = j; y < matrix[0].length; y++) {
                        //计算本开始、结束的节点的和
                        int sum = sumArr[x][y]
                                - getArr(sumArr, x, j - 1)
                                - getArr(sumArr, i - 1, y)
                                + getArr(sumArr, i - 1, j - 1);
                        //记录本次结果
                        count += sum == target ? 1 : 0;
                    }
                }

            }
        }

        //返回结果
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().numSubmatrixSumTarget(new int[][]{
                new int[]{0, 1, 0},
                new int[]{1, 1, 1},
                new int[]{0, 1, 0}
        }, 0));
    }

}
