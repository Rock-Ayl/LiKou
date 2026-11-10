package normal58;

import java.util.HashSet;
import java.util.Set;

/**
 * 2711. 对角线上不同值的数量差
 * 算术评级: 3
 * 第 347 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1429
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始、大小为 m x n 的二维矩阵 grid ，请你求解大小同样为 m x n 的答案矩阵 answer 。
 * <p>
 * 矩阵 answer 中每个单元格 (r, c) 的值可以按下述方式进行计算：
 * <p>
 * 令 topLeft[r][c] 为矩阵 grid 中单元格 (r, c) 左上角对角线上 不同值 的数量。
 * 令 bottomRight[r][c] 为矩阵 grid 中单元格 (r, c) 右下角对角线上 不同值 的数量。
 * 然后 answer[r][c] = |topLeft[r][c] - bottomRight[r][c]| 。
 * <p>
 * 返回矩阵 answer 。
 * <p>
 * 矩阵对角线 是从最顶行或最左列的某个单元格开始，向右下方向走到矩阵末尾的对角线。
 * <p>
 * 如果单元格 (r1, c1) 和单元格 (r, c) 属于同一条对角线且 r1 < r ，则单元格 (r1, c1) 属于单元格 (r, c) 的左上对角线。类似地，可以定义右下对角线。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[1,2,3],[3,1,5],[3,2,1]]
 * 输出：[[1,1,0],[1,0,1],[0,1,1]]
 * 解释：第 1 个图表示最初的矩阵 grid 。
 * 第 2 个图表示对单元格 (0,0) 计算，其中蓝色单元格是位于右下对角线的单元格。
 * 第 3 个图表示对单元格 (1,2) 计算，其中红色单元格是位于左上对角线的单元格。
 * 第 4 个图表示对单元格 (1,1) 计算，其中蓝色单元格是位于右下对角线的单元格，红色单元格是位于左上对角线的单元格。
 * - 单元格 (0,0) 的右下对角线包含 [1,1] ，而左上对角线包含 [] 。对应答案是 |1 - 0| = 1 。
 * - 单元格 (1,2) 的右下对角线包含 [] ，而左上对角线包含 [2] 。对应答案是 |0 - 1| = 1 。
 * - 单元格 (1,1) 的右下对角线包含 [1] ，而左上对角线包含 [1] 。对应答案是 |1 - 1| = 0 。
 * 其他单元格的对应答案也可以按照这样的流程进行计算。
 * 示例 2：
 * <p>
 * 输入：grid = [[1]]
 * 输出：[[0]]
 * 解释：- 单元格 (0,0) 的右下对角线包含 [] ，左上对角线包含 [] 。对应答案是 |0 - 0| = 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n, grid[i][j] <= 50
 */
public class Code19 {

    public int[][] differenceOfDistinctValues(int[][] grid) {
        //结果
        int[][] answer = new int[grid.length][grid[0].length];
        //循环
        for (int i = 0; i < answer.length; i++) {
            //循环2
            for (int j = 0; j < answer[0].length; j++) {
                //统计左上角对角线不同值的数量
                answer[i][j] = count(grid, i, j);
            }
        }
        //返回
        return answer;
    }

    //计算本次结果
    private int count(int[][] grid, int i, int j) {
        //左上角对角线不同值的数量
        Set<Integer> leftTopSet = new HashSet<>();
        //索引
        int leftTopI = i - 1;
        int leftTopJ = j - 1;
        //如果还有
        while (leftTopJ >= 0 && leftTopI >= 0) {
            //记录,并且下一个
            leftTopSet.add(grid[leftTopI--][leftTopJ--]);
        }
        //右下角对角线不同值的数量
        Set<Integer> rightBottomSet = new HashSet<>();
        //索引
        int rightBottomI = i + 1;
        int rightBottomJ = j + 1;
        //如果还有
        while (rightBottomJ < grid[0].length && rightBottomI < grid.length) {
            //记录,并且下一个
            rightBottomSet.add(grid[rightBottomI++][rightBottomJ++]);
        }
        //返回
        return Math.abs(leftTopSet.size() - rightBottomSet.size());
    }

    public static void main(String[] args) {
        int[][] ints = new Code19().differenceOfDistinctValues(new int[][]{{1, 2, 3}, {3, 1, 5}, {3, 2, 1}});
        System.out.println();
    }

}
