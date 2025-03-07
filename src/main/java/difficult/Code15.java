package difficult;

/**
 * @Author ayl
 * @Date 2022-08-19
 * 剑指 Offer II 112. 最长递增路径
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * 输出：4
 * 解释：最长递增路径为 [1, 2, 6, 9]。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * 输出：4
 * 解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * 示例 3：
 * <p>
 * 输入：matrix = [[1]]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * 0 <= matrix[i][j] <= 231 - 1
 * <p>
 * <p>
 * 注意：本题与主站 329 题相同： https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/
 */
public class Code15 {

    //缓存,记录每个坐标能走的长度
    private int[][] maxLinkArr;

    //不断的走下去
    public int next(int[][] matrix, int x, int y) {
        //如果有缓存
        if (maxLinkArr[x][y] > 0) {
            //直接返回即可
            return maxLinkArr[x][y];
        }
        //当前数字
        int thisNum = matrix[x][y];
        //默认接下来可以走的长度
        int nextTimes = 0;
        //如果可以走
        if (x > 0) {
            //下一个可能
            int nextNum = matrix[x - 1][y];
            //如果更大
            if (nextNum > thisNum) {
                //继续走,记录
                nextTimes = Math.max(nextTimes, next(matrix, x - 1, y));
            }
        }
        //如果可以走
        if (y > 0) {
            //下一个可能
            int nextNum = matrix[x][y - 1];
            //如果更大
            if (nextNum > thisNum) {
                //继续走
                nextTimes = Math.max(nextTimes, next(matrix, x, y - 1));
            }
        }
        //如果可以走
        if (y < matrix[0].length - 1) {
            //下一个可能
            int nextNum = matrix[x][y + 1];
            //如果更大
            if (nextNum > thisNum) {
                //继续走
                nextTimes = Math.max(nextTimes, next(matrix, x, y + 1));
            }
        }
        //如果可以走
        if (x < matrix.length - 1) {
            //下一个可能
            int nextNum = matrix[x + 1][y];
            //如果更大
            if (nextNum > thisNum) {
                //继续走
                nextTimes = Math.max(nextTimes, next(matrix, x + 1, y));
            }
        }
        //将当前的叠加起来
        nextTimes += 1;
        //记录缓存
        maxLinkArr[x][y] = nextTimes;
        //返回
        return nextTimes;
    }

    public int longestIncreasingPath(int[][] matrix) {
        //初始化
        this.maxLinkArr = new int[matrix.length][matrix[0].length];
        //默认最大结果
        int result = 0;
        //循环1
        for (int i = 0; i < matrix.length; i++) {
            //循环2
            for (int j = 0; j < matrix[0].length; j++) {
                //从0开始走,每次记录最大结果
                result = Math.max(result, next(matrix, i, j));
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        Code15 object = new Code15();
        System.out.println(object.longestIncreasingPath(new int[][]{
                new int[]{9, 9, 4},
                new int[]{6, 6, 8},
                new int[]{2, 1, 1},
        }));
        System.out.println();
    }

}
