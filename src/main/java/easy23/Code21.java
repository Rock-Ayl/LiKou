package easy23;

/**
 * @Author ayl
 * @Date 2022-10-10
 * 1779. 找到最近的有相同 X 或 Y 坐标的点
 * 给你两个整数 x 和 y ，表示你在一个笛卡尔坐标系下的 (x, y) 处。同时，在同一个坐标系下给你一个数组 points ，其中 points[i] = [ai, bi] 表示在 (ai, bi) 处有一个点。当一个点与你所在的位置有相同的 x 坐标或者相同的 y 坐标时，我们称这个点是 有效的 。
 * <p>
 * 请返回距离你当前位置 曼哈顿距离 最近的 有效 点的下标（下标从 0 开始）。如果有多个最近的有效点，请返回下标 最小 的一个。如果没有有效点，请返回 -1 。
 * <p>
 * 两个点 (x1, y1) 和 (x2, y2) 之间的 曼哈顿距离 为 abs(x1 - x2) + abs(y1 - y2) 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 3, y = 4, points = [[1,2],[3,1],[2,4],[2,3],[4,4]]
 * 输出：2
 * 解释：所有点中，[3,1]，[2,4] 和 [4,4] 是有效点。有效点中，[2,4] 和 [4,4] 距离你当前位置的曼哈顿距离最小，都为 1 。[2,4] 的下标最小，所以返回 2 。
 * 示例 2：
 * <p>
 * 输入：x = 3, y = 4, points = [[3,4]]
 * 输出：0
 * 提示：答案可以与你当前所在位置坐标相同。
 * 示例 3：
 * <p>
 * 输入：x = 3, y = 4, points = [[2,3]]
 * 输出：-1
 * 解释：没有 有效点。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 104
 * points[i].length == 2
 * 1 <= x, y, ai, bi <= 104
 */
public class Code21 {

    public int nearestValidPoint(int x, int y, int[][] points) {
        //初始化最小结果
        int min = Integer.MAX_VALUE;
        //最小结果的指针,默认-1
        int minP = -1;
        //循环
        for (int i = 0; i < points.length; i++) {
            //当前节点
            int[] point = points[i];
            //如果是x相同
            if (point[0] == x) {
                //计算当前结果
                int thisMin = Math.abs(point[1] - y);
                //如果更小
                if (thisMin < min) {
                    //更新
                    min = thisMin;
                    minP = i;
                }
                //本轮结束
                continue;
            }
            //如果是y相同
            if (point[1] == y) {
                //计算当前结果
                int thisMin = Math.abs(point[0] - x);
                //如果更小
                if (thisMin < min) {
                    //更新
                    min = thisMin;
                    minP = i;
                }
                //本轮结束
                continue;
            }
            //其他情况不是目标节点
        }
        //返回结果
        return minP;
    }

    public static void main(String[] args) {
        System.out.println(new Code21().nearestValidPoint(3, 4, new int[][]{
                new int[]{1, 2},
                new int[]{3, 1},
                new int[]{2, 4},
                new int[]{2, 3},
                new int[]{4, 4}
        }));
    }

}
