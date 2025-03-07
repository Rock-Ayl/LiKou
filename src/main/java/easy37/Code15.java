package easy37;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author ayl
 * @Date 2024-06-25
 * 1637. 两点之间不包含任何点的最宽垂直区域
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你 n 个二维平面上的点 points ，其中 points[i] = [xi, yi] ，请你返回两点之间内部不包含任何点的 最宽垂直区域 的宽度。
 * <p>
 * 垂直区域 的定义是固定宽度，而 y 轴上无限延伸的一块区域（也就是高度为无穷大）。 最宽垂直区域 为宽度最大的一个垂直区域。
 * <p>
 * 请注意，垂直区域 边上 的点 不在 区域内。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * ​
 * 输入：points = [[8,7],[9,9],[7,4],[9,7]]
 * 输出：1
 * 解释：红色区域和蓝色区域都是最优区域。
 * 示例 2：
 * <p>
 * 输入：points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == points.length
 * 2 <= n <= 105
 * points[i].length == 2
 * 0 <= xi, yi <= 109
 */
public class Code15 {

    public int maxWidthOfVerticalArea(int[][] points) {
        //排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //判断用x、y排序
                if (o1[0] == o2[0]) {
                    //用y
                    return o1[1] - o2[1];
                } else {
                    //用x
                    return o1[0] - o2[0];
                }
            }
        });
        //最大情况
        int max = 0;
        //循环
        for (int i = 1; i < points.length; i++) {
            //刷新最大情况
            max = Math.max(max, points[i][0] - points[i - 1][0]);
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code15().maxWidthOfVerticalArea(new int[][]{
                new int[]{3, 1},
                new int[]{9, 0},
                new int[]{1, 0},
                new int[]{1, 4},
                new int[]{5, 3},
                new int[]{8, 8}
        }));
    }

}
