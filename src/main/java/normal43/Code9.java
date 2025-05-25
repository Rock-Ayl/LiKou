package normal43;

/**
 * @Author ayl
 * @Date 2025-05-25
 * 3546. 等和矩阵分割 I
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个由正整数组成的 m x n 矩阵 grid。你的任务是判断是否可以通过 一条水平或一条垂直分割线 将矩阵分割成两部分，使得：
 * <p>
 * 分割后形成的每个部分都是 非空 的。
 * 两个部分中所有元素的和 相等 。
 * 如果存在这样的分割，返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： grid = [[1,4],[2,3]]
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 在第 0 行和第 1 行之间进行水平分割，得到两个非空部分，每部分的元素之和为 5。因此，答案是 true。
 * <p>
 * 示例 2：
 * <p>
 * 输入： grid = [[1,3],[2,4]]
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * <p>
 * 无论是水平分割还是垂直分割，都无法使两个非空部分的元素之和相等。因此，答案是 false。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= m == grid.length <= 105
 * 1 <= n == grid[i].length <= 105
 * 2 <= m * n <= 105
 * 1 <= grid[i][j] <= 105
 */
public class Code9 {

    public boolean canPartitionGrid(int[][] grid) {

        /**
         * 二维前缀和
         */

        //二维前缀和
        long[][] arr = new long[grid.length][grid[0].length];
        //第一个节点
        arr[0][0] = grid[0][0];

        //循环
        for (int i = 1; i < arr.length; i++) {
            //叠加
            arr[i][0] = arr[i - 1][0] + grid[i][0];
        }
        //循环
        for (int j = 1; j < arr[0].length; j++) {
            //叠加
            arr[0][j] = arr[0][j - 1] + grid[0][j];
        }

        //循环1
        for (int i = 1; i < arr.length; i++) {
            //循环2
            for (int j = 1; j < arr[0].length; j++) {
                //叠加
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j] - arr[i - 1][j - 1] + grid[i][j];
            }
        }

        /**
         * 计算结果
         */

        //循环
        for (int i = 0; i < arr.length - 1; i++) {
            //上面
            int oneStartX = 0;
            int oneStartY = 0;
            int oneEndX = i;
            int oneEndY = arr[0].length - 1;
            //下面
            int twoStartX = i + 1;
            int twoStartY = 0;
            int twoEndX = arr.length - 1;
            int twoEndY = arr[0].length - 1;
            //分别计算和
            long count1 = count(arr, oneStartX, oneStartY, oneEndX, oneEndY);
            long count2 = count(arr, twoStartX, twoStartY, twoEndX, twoEndY);
            //如果是结果
            if (count1 == count2) {
                //是
                return true;
            }
        }

        //循环
        for (int j = 0; j < arr[0].length; j++) {
            //左面
            int oneStartX = 0;
            int oneStartY = 0;
            int oneEndX = arr.length - 1;
            int oneEndY = j;
            //右面
            int twoStartX = 0;
            int twoStartY = j + 1;
            int twoEndX = arr.length - 1;
            int twoEndY = arr[0].length - 1;
            //分别计算和
            long count1 = count(arr, oneStartX, oneStartY, oneEndX, oneEndY);
            long count2 = count(arr, twoStartX, twoStartY, twoEndX, twoEndY);
            //如果是结果
            if (count1 == count2) {
                //是
                return true;
            }
        }

        //默认
        return false;
    }

    //计算
    private long count(long[][] arr, int startX, int startY, int endX, int endY) {
        //先算最大可能
        long sum = arr[endX][endY];
        //如果上面有缺失
        if (startX > 0) {
            //减去
            sum -= arr[startX - 1][endY];
        }
        //如果左面有缺失
        else if (startY > 0) {
            //减去
            sum -= arr[endX][startY - 1];
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().canPartitionGrid(new int[][]{
                new int[]{1, 4},
                new int[]{2, 3}
        }));
    }

}
