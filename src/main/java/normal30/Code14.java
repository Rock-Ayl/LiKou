package normal30;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author ayl
 * @Date 2024-04-09
 * 452. 用最少数量的箭引爆气球
 * 中等
 * 相关标签
 * 相关企业
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 * <p>
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 * <p>
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * -在x = 6处射出箭，击破气球[2,8]和[1,6]。
 * -在x = 11处发射箭，击破气球[10,16]和[7,12]。
 * 示例 2：
 * <p>
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 解释：每个气球需要射出一支箭，总共需要4支箭。
 * 示例 3：
 * <p>
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * - 在x = 2处发射箭，击破气球[1,2]和[2,3]。
 * - 在x = 4处射出箭，击破气球[3,4]和[4,5]。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= points.length <= 105
 * points[i].length == 2
 * -231 <= xstart < xend <= 231 - 1
 */
public class Code14 {

    public int findMinArrowShots(int[][] points) {
        //排序
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        //结果
        int result = 0;
        //初始化索引
        int p = 0;
        //循环
        while (p < points.length) {
            //当前分组,第一个区间,p进位
            int[] firstArr = points[p++];
            //当前分组的区间,也就是说可以射箭的范围
            int left = firstArr[0];
            int right = firstArr[1];
            //如果进到这里,无论记下来几个,都是为新的一箭
            result++;
            //如果还可以继续一箭穿
            while (p < points.length && points[p][0] >= left && points[p][0] <= right) {
                //当前分组,新的区间,p进位
                int[] nextArr = points[p++];
                //缩小分组(本次射箭的)区间
                left = Math.max(left, nextArr[0]);
                right = Math.min(right, nextArr[1]);
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code14().findMinArrowShots(new int[][]{
                new int[]{10, 16},
                new int[]{2, 8},
                new int[]{1, 6},
                new int[]{7, 12}
        }));
    }

}
