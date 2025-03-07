package normal9;

/**
 * @Author ayl
 * @Date 2022-01-05
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 */
public class Code10 {

    public int minPathSum(int[][] grid) {
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //获取其左
                Integer left;
                //如果有
                if (j > 0) {
                    //获取
                    left = grid[i][j - 1];
                } else {
                    //默认
                    left = null;
                }
                //获取其上
                Integer up;
                //如果有
                if (i > 0) {
                    //获取
                    up = grid[i - 1][j];
                } else {
                    //默认
                    up = null;
                }
                //计算
                int sum;
                //判断
                if (left == null) {
                    //用上
                    sum = up == null ? 0 : up;
                } else if (up == null) {
                    //用左
                    sum = left;
                } else {
                    //对比最小的用
                    sum = Math.min(up, left);
                }
                //记录走到这里最小值
                grid[i][j] += sum;
            }
        }
        //返回
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Code10().minPathSum(new int[][]{
                new int[]{0, 2, 2, 6, 4, 1, 6, 2, 9, 9, 5, 8, 4, 4},
                new int[]{0, 3, 6, 4, 5, 5, 9, 7, 8, 3, 9, 9, 5, 4},
                new int[]{6, 9, 0, 7, 2, 2, 5, 6, 3, 1, 0, 4, 2, 5},
                new int[]{3, 8, 2, 3, 2, 8, 8, 7, 5, 9, 6, 3, 4, 5},
                new int[]{4, 0, 1, 3, 9, 2, 0, 1, 6, 7, 9, 2, 8, 9},
                new int[]{6, 2, 7, 9, 0, 9, 5, 2, 7, 5, 1, 4, 4, 7},
                new int[]{9, 8, 3, 3, 0, 6, 8, 0, 8, 8, 3, 5, 7, 3},
                new int[]{7, 7, 4, 5, 9, 1, 5, 0, 2, 2, 2, 1, 7, 4},
                new int[]{5, 1, 3, 4, 1, 6, 0, 4, 3, 8, 4, 3, 9, 9},
                new int[]{0, 6, 4, 9, 4, 1, 5, 5, 4, 2, 5, 7, 4, 0},
                new int[]{0, 1, 6, 6, 4, 9, 2, 7, 8, 2, 1, 3, 3, 7},
                new int[]{8, 4, 9, 9, 2, 3, 8, 6, 6, 5, 4, 1, 7, 9}
        }));
    }


}
