package easy44;

/**
 * 4024. 最近的可用无人机
 * 算术评级: 2
 * 第 515 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1184
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个二维整数数组 drones，其中 drones[i] = [xi, yi, rangei] 表示第 ith 架无人机的横坐标、纵坐标和飞行范围。
 * <p>
 * 另给你一个整数数组 target = [tx, ty]，表示目标的坐标。
 * <p>
 * 如果无人机 drones[i] 的坐标与目标坐标之间的曼哈顿距离小于或等于其 rangei，则该无人机能够到达目标。
 * <p>
 * 返回能够到达目标且与目标之间曼哈顿距离最小的无人机的下标。如果存在多个符合条件的无人机，则返回其中最小的下标。如果没有无人机能够到达目标，则返回 -1。
 * <p>
 * 两个坐标 (xi, yi) 和 (xj, yj) 之间的曼哈顿距离为 |xi - xj| + |yi - yj|。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： drones = [[0,0,8],[2,2,9]], target = [3,4]
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * drones[0] 与 target 之间的距离为 |0 - 3| + |0 - 4| = 7，没有超出其飞行范围 8。
 * drones[1] 与 target 之间的距离为 |2 - 3| + |2 - 4| = 3，没有超出其飞行范围 9。
 * 由于 drones[1] 是距离目标最近的无人机，因此答案为 1。
 * 示例 2：
 * <p>
 * 输入： drones = [[2,1,5],[4,4,5],[6,6,8]], target = [5,5]
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * drones[0] 与 target 之间的距离为 |2 - 5| + |1 - 5| = 7，大于其飞行范围 5。
 * drones[1] 与 target 之间的距离为 |4 - 5| + |4 - 5| = 2，没有超出其飞行范围 5。
 * drones[2] 与 target 之间的距离为 |6 - 5| + |6 - 5| = 2，没有超出其飞行范围 8。
 * drones[1] 和 drones[2] 都是距离目标最近的无人机。由于需要返回最小下标，因此答案为 1。
 * 示例 3：
 * <p>
 * 输入： drones = [[4,4,5]], target = [8,6]
 * <p>
 * 输出： -1
 * <p>
 * 解释：
 * <p>
 * drones[0] 与 target 之间的距离为 |4 - 8| + |4 - 6| = 6，大于其飞行范围 5。
 * 没有无人机能够到达目标，因此答案为 -1。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= drones.length <= 100
 * drones[i] = [xi, yi, rangei]
 * target = [tx, ty]
 * -25 <= xi, yi, tx, ty <= 25
 * 1 <= rangei <= 100
 *
 */
public class Code3 {

    public int nearestDrone(int[][] drones, int[] target) {
        //最小距离-索引
        int index = -1;
        //最小距离
        int minWay = Integer.MAX_VALUE;
        //循环
        for (int i = 0; i < drones.length; i++) {
            //计算距离
            int way = Math.abs(drones[i][0] - target[0]) + Math.abs(drones[i][1] - target[1]);
            //判断是否到达目标
            if (drones[i][2] < way) {
                //本轮过
                continue;
            }
            //更新最小距离
            if (way < minWay) {
                //刷新
                minWay = way;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().nearestDrone(
                new int[][]{
                        {0, 0, 8},
                        {2, 2, 9}
                },
                new int[]{3, 4}
        ));
    }

}
