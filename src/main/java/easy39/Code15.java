package easy39;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-01-18
 * 3417. 跳过交替单元格的之字形遍历
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个 m x n 的二维数组 grid，数组由 正整数 组成。
 * <p>
 * 你的任务是以 之字形 遍历 grid，同时跳过每个 交替 的单元格。
 * <p>
 * 之字形遍历的定义如下：
 * <p>
 * 从左上角的单元格 (0, 0) 开始。
 * 在当前行中向 右 移动，直到到达该行的末尾。
 * 下移到下一行，然后在该行中向 左 移动，直到到达该行的开头。
 * 继续在行间交替向右和向左移动，直到所有行都被遍历完。
 * 注意：在遍历过程中，必须跳过每个 交替 的单元格。
 * <p>
 * 返回一个整数数组 result，其中包含按 顺序 记录的、且跳过交替单元格后的之字形遍历中访问到的单元格值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： grid = [[1,2],[3,4]]
 * <p>
 * 输出： [1,4]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入： grid = [[2,1],[2,1],[2,1]]
 * <p>
 * 输出： [2,1,2]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入： grid = [[1,2,3],[4,5,6],[7,8,9]]
 * <p>
 * 输出： [1,3,5,7,9]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n == grid.length <= 50
 * 2 <= m == grid[i].length <= 50
 * 1 <= grid[i][j] <= 2500
 */
public class Code15 {

    public List<Integer> zigzagTraversal(int[][] grid) {
        //初始化列表
        List<Integer> result = new ArrayList<>();
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //如果是偶数
            if (i % 2 == 0) {
                //循环2
                for (int j = 0; j < grid[0].length; j = j + 2) {
                    //计算
                    result.add(grid[i][j]);
                }
            } else {
                //循环2
                for (int j = grid[0].length % 2 == 0 ? grid[0].length - 1 : grid[0].length - 2; j >= 0; j = j - 2) {
                    //计算
                    result.add(grid[i][j]);
                }
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {

        //1,1,3,15,10,14

        List<Integer> integers = new Code15().zigzagTraversal(new int[][]{
                new int[]{1, 2, 1, 3},
                new int[]{5, 15, 7, 3},
                new int[]{10, 4, 14, 12}
        });
    }

}
