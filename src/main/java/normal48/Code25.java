package normal48;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-12-16
 * 2001. 可互换矩形的组数
 * 算术评级: 4
 * 第 258 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1436
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 用一个下标从 0 开始的二维整数数组 rectangles 来表示 n 个矩形，其中 rectangles[i] = [widthi, heighti] 表示第 i 个矩形的宽度和高度。
 * <p>
 * 如果两个矩形 i 和 j（i < j）的宽高比相同，则认为这两个矩形 可互换 。更规范的说法是，两个矩形满足 widthi/heighti == widthj/heightj（使用实数除法而非整数除法），则认为这两个矩形 可互换 。
 * <p>
 * 计算并返回 rectangles 中有多少对 可互换 矩形。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：rectangles = [[4,8],[3,6],[10,20],[15,30]]
 * 输出：6
 * 解释：下面按下标（从 0 开始）列出可互换矩形的配对情况：
 * - 矩形 0 和矩形 1 ：4/8 == 3/6
 * - 矩形 0 和矩形 2 ：4/8 == 10/20
 * - 矩形 0 和矩形 3 ：4/8 == 15/30
 * - 矩形 1 和矩形 2 ：3/6 == 10/20
 * - 矩形 1 和矩形 3 ：3/6 == 15/30
 * - 矩形 2 和矩形 3 ：10/20 == 15/30
 * 示例 2：
 * <p>
 * 输入：rectangles = [[4,5],[7,8]]
 * 输出：0
 * 解释：不存在成对的可互换矩形。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == rectangles.length
 * 1 <= n <= 105
 * rectangles[i].length == 2
 * 1 <= widthi, heighti <= 105
 */
public class Code25 {

    public long interchangeableRectangles(int[][] rectangles) {
        //缓存
        Map<Double, Integer> cacheMap = new HashMap<>();
        //循环
        for (int[] rectangle : rectangles) {
            //计算key
            Double key = (double) rectangle[0] / (double) rectangle[1];
            //+1
            cacheMap.put(key, cacheMap.getOrDefault(key, 0) + 1);
        }
        //结果
        long result = 0L;
        //循环
        for (Integer value : cacheMap.values()) {
            //叠加本次
            result += count(value);
        }
        //返回
        return result;
    }

    //根据数量计算组合,高斯算法
    private long count(long value) {
        //特殊情况
        if (value == 1) {
            //返回
            return 0;
        }
        //边界
        long left = 1L;
        long right = value - 1L;
        //返回
        return (right + left) * (right / 2L) + (right % 2L == 0 ? 0 : (right + left) / 2);
    }

    public static void main(String[] args) {
        /*long result = new Code25().interchangeableRectangles(new int[][]{
                new int[]{4, 8},
                new int[]{3, 6},
                new int[]{10, 20},
                new int[]{15, 30}
        });*/

        long result = new Code25().interchangeableRectangles(new int[][]{
                new int[]{4, 5},
                new int[]{7, 8}
        });
        System.out.println(result);
    }

}
