package normal53;

import java.util.ArrayList;
import java.util.List;

/**
 * 853. 车队
 * 算术评级: 7
 * 第 89 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1678
 * 相关标签
 * premium lock icon
 * 相关企业
 * 在一条单行道上，有 n 辆车开往同一目的地。目的地是几英里以外的 target 。
 * <p>
 * 给定两个整数数组 position 和 speed ，长度都是 n ，其中 position[i] 是第 i 辆车的位置， speed[i] 是第 i 辆车的速度(单位是英里/小时)。
 * <p>
 * 一辆车永远不会超过前面的另一辆车，但它可以追上去，并以较慢车的速度在另一辆车旁边行驶。
 * <p>
 * 车队 是指并排行驶的一辆或几辆汽车。车队的速度是车队中 最慢 的车的速度。
 * <p>
 * 即便一辆车在 target 才赶上了一个车队，它们仍然会被视作是同一个车队。
 * <p>
 * 返回到达目的地的车队数量 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 从 10（速度为 2）和 8（速度为 4）开始的车会组成一个车队，它们在 12 相遇。车队在 target 形成。
 * 从 0（速度为 1）开始的车不会追上其它任何车，所以它自己是一个车队。
 * 从 5（速度为 1） 和 3（速度为 3）开始的车组成一个车队，在 6 相遇。车队以速度 1 移动直到它到达 target。
 * 示例 2：
 * <p>
 * 输入：target = 10, position = [3], speed = [3]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 只有一辆车，因此只有一个车队。
 * 示例 3：
 * <p>
 * 输入：target = 100, position = [0,2,4], speed = [4,2,1]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 从 0（速度为 4） 和 2（速度为 2）开始的车组成一个车队，在 4 相遇。从 4 开始的车（速度为 1）移动到了 5。
 * 然后，在 4（速度为 2）的车队和在 5（速度为 1）的车成为一个车队，在 6 相遇。车队以速度 1 移动直到它到达 target。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == position.length == speed.length
 * 1 <= n <= 105
 * 0 < target <= 106
 * 0 <= position[i] < target
 * position 中每个值都 不同
 * 0 < speed[i] <= 106
 */
public class Code11 {

    /**
     * 车队的车
     */
    private static class CarLeader {

        //车队未知
        private int position;

        //车队速度(首位车速度)
        private int speed;

        //花费时间
        private double time;

        //初始化
        public CarLeader(int position, int speed, int target) {
            this.position = position;
            this.speed = speed;
            this.time = (double) (target - position) / speed;
        }

        //方便调试
        @Override
        public String toString() {
            return "CarLeader{" +
                    "position=" + position +
                    ", speed=" + speed +
                    ", time=" + time +
                    '}';
        }

    }

    public int carFleet(int target, int[] position, int[] speed) {

        /**
         * 构建车队
         */

        //初始化列表
        List<CarLeader> carList = new ArrayList<>();
        //循环
        for (int i = 0; i < position.length; i++) {
            //初始化
            carList.add(new CarLeader(position[i], speed[i], target));
        }
        //按照位置排序
        carList.sort((a, b) -> b.position - a.position);

        /**
         * 计算结果
         */

        //结果
        int result = 0;
        //挡路的车,默认第一台挡路,视为头车
        CarLeader start = carList.get(0);
        //循环
        for (int i = 1; i < carList.size(); i++) {
            //当前车队
            CarLeader end = carList.get(i);
            //如果能够合并
            if (merge(start, end) == true) {
                //本轮过
                continue;
            }
            //车队+1
            result++;
            //新的头车
            start = end;
        }
        //返回
        return result + 1;
    }

    //判断两个车队是否能合并
    private boolean merge(CarLeader start, CarLeader end) {
        //如果速度更小 or 相同
        if (end.speed <= start.speed) {
            //无法追上
            return false;
        }
        //返回
        return start.time >= end.time;
    }

    public static void main(String[] args) {
        //System.out.println(new Code11().carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}));
        //System.out.println(new Code11().carFleet(10, new int[]{0, 4, 2}, new int[]{2, 1, 3}));
        //System.out.println(new Code11().carFleet(10, new int[]{8, 3, 7, 4, 6, 5}, new int[]{4, 4, 4, 4, 4, 4}));
        System.out.println(new Code11().carFleet(31, new int[]{5, 26, 18, 25, 29, 21, 22, 12, 19, 6}, new int[]{7, 6, 6, 4, 3, 4, 9, 7, 6, 4}));
    }

}
