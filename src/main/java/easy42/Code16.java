package easy42;

/**
 * 812. 最大三角形面积
 * 尝试过
 * 算术评级: 4
 * 第 79 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1543
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个由 X-Y 平面上的点组成的数组 points ，其中 points[i] = [xi, yi] 。从其中取任意三个不同的点组成三角形，返回能组成的最大三角形的面积。与真实值误差在 10-5 内的答案将会视为正确答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * 输出：2.00000
 * 解释：输入中的 5 个点如上图所示，红色的三角形面积最大。
 * 示例 2：
 * <p>
 * 输入：points = [[1,0],[0,0],[0,1]]
 * 输出：0.50000
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= points.length <= 50
 * -50 <= xi, yi <= 50
 * 给出的所有点 互不相同
 */
public class Code16 {

    public double largestTriangleArea(int[][] points) {
        //最大面积
        double max = 0;
        //循环
        for (int i = 0; i < points.length; i++) {
            //获取
            int[] a = points[i];
            //循环2
            for (int j = i + 1; j < points.length; j++) {
                //获取
                int[] b = points[j];
                //循环3
                for (int k = j + 1; k < points.length; k++) {
                    //获取
                    int[] c = points[k];
                    //计算面积
                    double area = 0.5D * (a[0] * b[1] + b[0] * c[1] + c[0] * a[1] - a[1] * b[0] - b[1] * c[0] - c[1] * a[0]);
                    //刷新最大
                    max = Math.max(max, Math.abs(area));
                }
            }
        }
        //发那会
        return max;
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}};
        System.out.println("最大三角形面积:" + new Code16().largestTriangleArea(points));
        ;
    }

}
