package normal41;

/**
 * @Author ayl
 * @Date 2025-03-09
 * 1828. 统计一个圆中点的数目
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个数组 points ，其中 points[i] = [xi, yi] ，表示第 i 个点在二维平面上的坐标。多个点可能会有 相同 的坐标。
 * <p>
 * 同时给你一个数组 queries ，其中 queries[j] = [xj, yj, rj] ，表示一个圆心在 (xj, yj) 且半径为 rj 的圆。
 * <p>
 * 对于每一个查询 queries[j] ，计算在第 j 个圆 内 点的数目。如果一个点在圆的 边界上 ，我们同样认为它在圆 内 。
 * <p>
 * 请你返回一个数组 answer ，其中 answer[j]是第 j 个查询的答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
 * 输出：[3,2,2]
 * 解释：所有的点和圆如上图所示。
 * queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆。
 * 示例 2：
 * <p>
 * <p>
 * 输入：points = [[1,1],[2,2],[3,3],[4,4],[5,5]], queries = [[1,2,2],[2,2,2],[4,3,2],[4,3,3]]
 * 输出：[2,3,2,4]
 * 解释：所有的点和圆如上图所示。
 * queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆，queries[3] 是紫色的圆。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 500
 * points[i].length == 2
 * 0 <= x​​​​​​i, y​​​​​​i <= 500
 * 1 <= queries.length <= 500
 * queries[j].length == 3
 * 0 <= xj, yj <= 500
 * 1 <= rj <= 500
 * 所有的坐标都是整数。
 */
public class Code2 {

    public int[] countPoints(int[][] points, int[][] queries) {
        //结果
        int[] result = new int[queries.length];
        //循环
        for (int i = 0; i < queries.length; i++) {
            //圆
            int[] query = queries[i];
            //圆内点数量
            int count = 0;
            //循环
            for (int[] point : points) {
                //计算并叠加
                count += count(query, point);
            }
            //记录本次结果
            result[i] = count;
        }
        //返回
        return result;
    }

    //用直角三角形求边方式,判断距离是否在圆心
    private int count(int[] query, int[] point) {
        //计算距离
        int a = point[0] - query[0];
        int b = point[1] - query[1];
        int c = a * a + b * b;
        int d = query[2] * query[2];
        //返回
        return c <= d ? 1 : 0;
    }

    public static void main(String[] args) {
        int[] ints = new Code2().countPoints(
                new int[][]{
                        new int[]{1, 3},
                        new int[]{3, 3},
                        new int[]{5, 3},
                        new int[]{2, 2}
                },
                new int[][]{
                        new int[]{2, 3, 1},
                        new int[]{4, 3, 1},
                        new int[]{1, 1, 2}
                });
        System.out.println();
    }

}
