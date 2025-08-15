package difficult3;

/**
 * @Author ayl
 * @Date 2025-08-15
 * 780. 到达终点
 * 尝试过
 * 1897
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定四个整数 sx , sy ，tx 和 ty，如果通过一系列的转换可以从起点 (sx, sy) 到达终点 (tx, ty)，则返回 true，否则返回 false。
 * <p>
 * 从点 (x, y) 可以转换到 (x, x+y)  或者 (x+y, y)。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: sx = 1, sy = 1, tx = 3, ty = 5
 * 输出: true
 * 解释:
 * 可以通过以下一系列转换从起点转换到终点：
 * (1, 1) -> (1, 2)
 * (1, 2) -> (3, 2)
 * (3, 2) -> (3, 5)
 * 示例 2:
 * <p>
 * 输入: sx = 1, sy = 1, tx = 2, ty = 2
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: sx = 1, sy = 1, tx = 1, ty = 1
 * 输出: true
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= sx, sy, tx, ty <= 109
 */
public class Code17 {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        //如果不够
        if (tx < sx || ty < sy) {
            //过
            return false;
        }
        //如果是结果
        if (sx == tx && sy == ty) {
            //是
            return true;
        }
        //如果左边相同
        if (sx == tx) {
            //返回
            return (ty - sy) % tx == 0;
        }
        //如果右边相同
        if (sy == ty) {
            //返回
            return (tx - sx) % ty == 0;
        }
        //如果相等
        if (tx == ty) {
            //左右
            return reachingPoints(sx, sy, 0, ty) || reachingPoints(sx, sy, tx, 0);
        }
        //如果左边大
        if (tx > ty) {
            //最多允许tx减少
            int other = tx - sx;
            //可以减少的次数,最少一次
            int count = Math.max(other / ty, 1);
            //继续
            return reachingPoints(sx, sy, tx - ty * count, ty);
        }
        //如果右边大
        else {
            //最多允许ty减少
            int other = ty - sy;
            //可以减少的次数,最少一次
            int count = Math.max(other / tx, 1);
            //继续
            return reachingPoints(sx, sy, tx, ty - tx * count);
        }
    }

    public static void main(String[] args) {
        //System.out.println(new Code17().reachingPoints(2, 2, 1000000000, 4));
        System.out.println(new Code17().reachingPoints(9, 5, 12, 8));
    }

}
