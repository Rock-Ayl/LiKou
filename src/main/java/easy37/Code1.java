package easy37;

/**
 * @Author ayl
 * @Date 2024-05-19
 * 3142. 判断矩阵是否满足条件
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个大小为 m x n 的二维矩阵 grid 。你需要判断每一个格子 grid[i][j] 是否满足：
 * <p>
 * 如果它下面的格子存在，那么它需要等于它下面的格子，也就是 grid[i][j] == grid[i + 1][j] 。
 * 如果它右边的格子存在，那么它需要不等于它右边的格子，也就是 grid[i][j] != grid[i][j + 1] 。
 * 如果 所有 格子都满足以上条件，那么返回 true ，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,0,2],[1,0,2]]
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 网格图中所有格子都符合条件。
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [[1,1,1],[0,0,0]]
 * <p>
 * 输出：false
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 同一行中的格子值都相等。
 * <p>
 * 示例 3：
 * <p>
 * 输入：grid = [[1],[2],[3]]
 * <p>
 * 输出：false
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 同一列中的格子值不相等。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n, m <= 10
 * 0 <= grid[i][j] <= 9
 */
public class Code1 {

    public boolean satisfiesConditions(int[][] grid) {
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //如果不满足1
                if (j + 1 < grid[0].length && grid[i][j] == grid[i][j + 1]) {
                    //过
                    return false;
                }
                //如果不满足2
                if (i + 1 < grid.length && grid[i][j] != grid[i + 1][j]) {
                    //过
                    return false;
                }
            }
        }
        //默认是
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code1().satisfiesConditions(new int[][]{
                new int[]{1, 0, 2},
                new int[]{1, 0, 2}
        }));
    }

}
