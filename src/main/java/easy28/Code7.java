package easy28;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2023-02-17
 * 883. 三维形体投影面积
 * 在 n x n 的网格 grid 中，我们放置了一些与 x，y，z 三轴对齐的 1 x 1 x 1 立方体。
 * <p>
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
 * <p>
 * 现在，我们查看这些立方体在 xy 、yz 和 zx 平面上的投影。
 * <p>
 * 投影 就像影子，将 三维 形体映射到一个 二维 平面上。从顶部、前面和侧面看立方体时，我们会看到“影子”。
 * <p>
 * 返回 所有三个投影的总面积 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[[1,2],[3,4]]
 * 输出：17
 * 解释：这里有该形体在三个轴对齐平面上的三个投影(“阴影部分”)。
 * 示例 2:
 * <p>
 * 输入：grid = [[2]]
 * 输出：5
 * 示例 3：
 * <p>
 * 输入：[[1,0],[0,2]]
 * 输出：8
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 1 <= n <= 50
 * 0 <= grid[i][j] <= 50
 */
public class Code7 {

    public int projectionArea(int[][] grid) {
        //计算顶部
        int sum = Arrays.stream(grid)
                //计算出没行不是0的数
                .map(p -> Arrays.stream(p).filter(q -> q > 0).count())
                //计算和
                .mapToInt(Long::intValue).sum();
        //计算前面
        sum += Arrays.stream(grid)
                //计算每个数组的最大值
                .map(p -> Arrays.stream(p).max().getAsInt())
                //计算和
                .mapToInt(Integer::intValue).sum();
        //侧面最大情况数组
        int[] arr = new int[grid[0].length];
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //刷新最大
                arr[j] = Math.max(arr[j], grid[i][j]);
            }
        }
        //计算侧面
        sum += Arrays.stream(arr).sum();
        //返回结果
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().projectionArea(new int[][]{
                new int[]{1, 0},
                new int[]{0, 2}
        }));
    }

}
