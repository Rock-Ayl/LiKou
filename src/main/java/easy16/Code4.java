package easy16;

/**
 * @Author ayl
 * @Date 2021-12-06
 * 1184. 公交站间的距离
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 * <p>
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 * <p>
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：distance = [1,2,3,4], start = 0, destination = 1
 * 输出：1
 * 解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：distance = [1,2,3,4], start = 0, destination = 2
 * 输出：3
 * 解释：公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：distance = [1,2,3,4], start = 0, destination = 3
 * 输出：4
 * 解释：公交站 0 和 3 之间的距离是 6 或 4，最小值是 4。
 */
public class Code4 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        //对比大小
        int small = Math.min(start, destination);
        int big = Math.max(start, destination);
        //和
        int sum = 0;
        //正
        int just = 0;
        //循环
        for (int i = 0; i < distance.length; i++) {
            //组装和
            sum += distance[i];
            //如果是正的范围
            if (i >= small && i < big) {
                //组装
                just += distance[i];
            }
        }
        //返回最小
        return Math.min(sum - just, just);
    }

    public static void main(String[] args) {

    }

}
