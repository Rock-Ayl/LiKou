package easy35;

/**
 * @Author ayl
 * @Date 2023-12-31
 * 2965. 找出缺失和重复的数字
 * 简单
 * 2
 * 相关企业
 * 给你一个下标从 0 开始的二维整数矩阵 grid，大小为 n * n ，其中的值在 [1, n2] 范围内。除了 a 出现 两次，b 缺失 之外，每个整数都 恰好出现一次 。
 * <p>
 * 任务是找出重复的数字a 和缺失的数字 b 。
 * <p>
 * 返回一个下标从 0 开始、长度为 2 的整数数组 ans ，其中 ans[0] 等于 a ，ans[1] 等于 b 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,3],[2,2]]
 * 输出：[2,4]
 * 解释：数字 2 重复，数字 4 缺失，所以答案是 [2,4] 。
 * 示例 2：
 * <p>
 * 输入：grid = [[9,1,7],[8,9,2],[3,4,6]]
 * 输出：[9,5]
 * 解释：数字 9 重复，数字 5 缺失，所以答案是 [9,5] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n == grid.length == grid[i].length <= 50
 * 1 <= grid[i][j] <= n * n
 * 对于所有满足1 <= x <= n * n 的 x ，恰好存在一个 x 与矩阵中的任何成员都不相等。
 * 对于所有满足1 <= x <= n * n 的 x ，恰好存在一个 x 与矩阵中的两个成员相等。
 * 除上述的两个之外，对于所有满足1 <= x <= n * n 的 x ，都恰好存在一对 i, j 满足 0 <= i, j <= n - 1 且 grid[i][j] == x 。
 */
public class Code13 {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        //和
        int sum = 0;
        //目标0
        int targetSum = 0;
        //目标和递增
        int p = 1;
        //重复字段
        int same = 0;
        //缓存
        int[] arr = new int[grid.length * grid[0].length + 1];
        //循环1
        for (int[] ints : grid) {
            //循环2
            for (int num : ints) {
                //叠加和
                sum += num;
                //叠加目标和
                targetSum += p++;
                //如果重复了
                if (arr[num]++ > 0) {
                    //记录重复字段
                    same = num;
                }
            }
        }
        //返回目标结果
        return new int[]{same, same - sum + targetSum};
    }

    public static void main(String[] args) {
        int[] arr = new Code13().findMissingAndRepeatedValues(new int[][]{
                new int[]{9, 1, 7},
                new int[]{8, 9, 2},
                new int[]{3, 4, 6}
        });
        System.out.println();
    }

}
