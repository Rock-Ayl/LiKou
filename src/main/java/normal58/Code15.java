package normal58;

import java.util.HashMap;
import java.util.Map;

/**
 * 447. 回旋镖的数量
 * 算术评级: 4
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的欧式距离和 i 和 k 之间的欧式距离相等（需要考虑元组的顺序）。
 * <p>
 * 返回平面上所有回旋镖的数量。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * 示例 2：
 * <p>
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：points = [[1,1]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == points.length
 * 1 <= n <= 500
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * 所有点都 互不相同
 */
public class Code15 {

    public int numberOfBoomerangs(int[][] points) {
        //距离缓存列表
        Map<Double, Integer>[] walkMapList = new HashMap[points.length];
        //循环
        for (int i = 0; i < points.length; i++) {
            //初始化
            walkMapList[i] = new HashMap<>();
        }
        //循环
        for (int i = 0; i < points.length; i++) {
            //获取第一个
            Map<Double, Integer> oneMap = walkMapList[i];
            //循环其他点
            for (int j = i + 1; j < points.length; j++) {
                //获取第二个
                Map<Double, Integer> twoMap = walkMapList[j];
                //计算两个点之间的距离
                Double distance = getDistance(points[i], points[j]);
                //缓存距离+1
                oneMap.put(distance, oneMap.getOrDefault(distance, 0) + 1);
                twoMap.put(distance, twoMap.getOrDefault(distance, 0) + 1);
            }
        }
        //结果
        int result = 0;
        //循环
        for (int i = 0; i < points.length; i++) {
            //获取
            Map<Double, Integer> oneMap = walkMapList[i];
            //循环
            for (Integer count : oneMap.values()) {
                //高斯数学
                result += count * (count - 1);
            }
        }
        //返回
        return result;
    }

    //计算两个点之间的距离
    private double getDistance(int[] p1, int[] p2) {
        //如果x坐标相同
        if (p1[0] == p2[0]) {
            //返回y坐标差的绝对值
            return Math.abs(p1[1] - p2[1]);
        }
        //如果y坐标相同
        if (p1[1] == p2[1]) {
            //返回x坐标差的绝对值
            return Math.abs(p1[0] - p2[0]);
        }
        //斜线
        double dx = p1[0] - p2[0];
        double dy = p1[1] - p2[1];
        //x方+y方=z方 开方
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) {
        System.out.println(new Code15().numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
    }

}
