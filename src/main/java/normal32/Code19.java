package normal32;

/**
 * @Author ayl
 * @Date 2024-06-14
 * 1975. 最大方阵和
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 n x n 的整数方阵 matrix 。你可以执行以下操作 任意次 ：
 * <p>
 * 选择 matrix 中 相邻 两个元素，并将它们都 乘以 -1 。
 * 如果两个元素有 公共边 ，那么它们就是 相邻 的。
 * <p>
 * 你的目的是 最大化 方阵元素的和。请你在执行以上操作之后，返回方阵的 最大 和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,-1],[-1,1]]
 * 输出：4
 * 解释：我们可以执行以下操作使和等于 4 ：
 * - 将第一行的 2 个元素乘以 -1 。
 * - 将第一列的 2 个元素乘以 -1 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
 * 输出：16
 * 解释：我们可以执行以下操作使和等于 16 ：
 * - 将第二行的最后 2 个元素乘以 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == matrix.length == matrix[i].length
 * 2 <= n <= 250
 * -105 <= matrix[i][j] <= 105
 */
public class Code19 {

    public long maxMatrixSum(int[][] matrix) {
        //负数的数量
        int count = 0;
        //正数最小值
        int min = Math.abs(matrix[0][0]);
        //和
        long sum = 0L;
        //循环1
        for (int[] arr : matrix) {
            //循环2
            for (int num : arr) {
                //绝对正数
                int abs = Math.abs(num);
                //叠加本次
                sum += abs;
                //如果是负数,记录数量
                count += num < 0 ? 1 : 0;
                //刷新正数最小值
                min = Math.min(min, abs);
            }
        }
        //如果是 负数的数量是奇数 and 不存在0
        if (count % 2 != 0 && min > 0) {
            //最小的正数改为负数,其他都是正数
            return sum - min * 2;
        }
        //默认所有都是正数
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code19().maxMatrixSum(new int[][]{
                new int[]{-1, 0, -1},
                new int[]{-2, 1, 3},
                new int[]{3, 2, 2}
        }));
    }

}
