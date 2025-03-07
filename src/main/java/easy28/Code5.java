package easy28;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author ayl
 * @Date 2023-02-15
 * 1030. 距离顺序排列矩阵单元格
 * 给定四个整数 rows ,   cols ,  rCenter 和 cCenter 。有一个 rows x cols 的矩阵，你在单元格上的坐标是 (rCenter, cCenter) 。
 * <p>
 * 返回矩阵中的所有单元格的坐标，并按与 (rCenter, cCenter) 的 距离 从最小到最大的顺序排。你可以按 任何 满足此条件的顺序返回答案。
 * <p>
 * 单元格(r1, c1) 和 (r2, c2) 之间的距离为|r1 - r2| + |c1 - c2|。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：rows = 1, cols = 2, rCenter = 0, cCenter = 0
 * 输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 * 示例 2：
 * <p>
 * 输入：rows = 2, cols = 2, rCenter = 0, cCenter = 1
 * 输出：[[0,1],[0,0],[1,1],[1,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
 * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
 * 示例 3：
 * <p>
 * 输入：rows = 2, cols = 3, rCenter = 1, cCenter = 2
 * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
 * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= rows, cols <= 100
 * 0 <= rCenter < rows
 * 0 <= cCenter < cols
 */
public class Code5 {

    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        //初始化结果
        int[][] result = new int[rows * cols][2];
        //指针
        int p = 0;
        //循环1
        for (int i = 0; i < rows; i++) {
            //循环2
            for (int j = 0; j < cols; j++) {
                //记录结果
                result[p][0] = i;
                result[p++][1] = j;
            }
        }
        //给结果排序
        Arrays.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //计算二者到目标的距离
                int o1sum = Math.abs(o1[0] - rCenter) + Math.abs(o1[1] - cCenter);
                int o2sum = Math.abs(o2[0] - rCenter) + Math.abs(o2[1] - cCenter);
                //对比
                return o1sum - o2sum;
            }
        });
        //返回
        return result;
    }

    public static void main(String[] args) {
        new Code5().allCellsDistOrder(2, 3, 1, 2);
    }

}
