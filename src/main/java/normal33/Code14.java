package normal33;

import java.util.Arrays;
import java.util.List;

/**
 * @Author ayl
 * @Date 2024-07-20
 * 3148. 矩阵中的最大得分
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个由 正整数 组成、大小为 m x n 的矩阵 grid。你可以从矩阵中的任一单元格移动到另一个位于正下方或正右侧的任意单元格（不必相邻）。从值为 c1 的单元格移动到值为 c2 的单元格的得分为 c2 - c1 。
 * <p>
 * 你可以从 任一 单元格开始，并且必须至少移动一次。
 * <p>
 * 返回你能得到的 最大 总得分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[9,5,7,3],[8,9,6,1],[6,7,14,3],[2,5,3,1]]
 * <p>
 * 输出：9
 * <p>
 * 解释：从单元格 (0, 1) 开始，并执行以下移动：
 * - 从单元格 (0, 1) 移动到 (2, 1)，得分为 7 - 5 = 2 。
 * - 从单元格 (2, 1) 移动到 (2, 2)，得分为 14 - 7 = 7 。
 * 总得分为 2 + 7 = 9 。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[4,3,2],[3,2,1]]
 * <p>
 * 输出：-1
 * <p>
 * 解释：从单元格 (0, 0) 开始，执行一次移动：从 (0, 0) 到 (0, 1) 。得分为 3 - 4 = -1 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 1000
 * 4 <= m * n <= 105
 * 1 <= grid[i][j] <= 105
 */
public class Code14 {

    public int maxScore(List<List<Integer>> grid) {
        //长宽
        int m = grid.size();
        int n = grid.get(0).size();
        //初始化数组,该数组记录截止到目标单元格,最小的数字(不算该单元格)
        int[][] minArr = new int[m][n];
        //初始化开始节点
        minArr[1][0] = grid.get(0).get(0);
        minArr[0][1] = grid.get(0).get(0);
        //循环
        for (int i = 2; i < m; i++) {
            //计算第一列的最小
            minArr[i][0] = Math.min(grid.get(i - 1).get(0), minArr[i - 1][0]);
        }
        //循环
        for (int j = 2; j < n; j++) {
            //计算第一行的最小
            minArr[0][j] = Math.min(grid.get(0).get(j - 1), minArr[0][j - 1]);
        }
        //循环1
        for (int i = 1; i < m; i++) {
            //循环2
            for (int j = 1; j < n; j++) {
                //计算当前单元格最小值
                minArr[i][j] = Math.min(Math.min(minArr[i - 1][j], grid.get(i - 1).get(j)), Math.min(minArr[i][j - 1], grid.get(i).get(j - 1)));
            }
        }
        //最大结果
        int maxResult = Integer.MIN_VALUE;
        //循环1
        for (int i = 0; i < m; i++) {
            //循环2
            for (int j = 0; j < n; j++) {
                //计算
                int count = grid.get(i).get(j) - minArr[i][j];
                //如果第一个
                if (i == 0 && j == 0) {
                    //本轮过
                    continue;
                }
                //计算并刷新
                maxResult = Math.max(maxResult, count);
            }
        }
        //返回
        return maxResult;
    }

    public static void main(String[] args) {
        System.out.println(new Code14().maxScore(Arrays.asList(
                Arrays.asList(4, 3, 2),
                Arrays.asList(3, 2, 1)
        )));
    }

    //打印
    private void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.println();
        }
    }

}
