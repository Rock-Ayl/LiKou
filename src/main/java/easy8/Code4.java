package easy8;

import java.util.HashSet;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2021-05-31
 * 874. 模拟行走机器人
 * 机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
 * <p>
 * -2 ：向左转 90 度
 * -1 ：向右转 90 度
 * 1 <= x <= 9 ：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。
 * <p>
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
 * <p>
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）
 * <p>
 * <p>
 * 注意：
 * <p>
 * 北表示 +Y 方向。
 * 东表示 +X 方向。
 * 南表示 -Y 方向。
 * 西表示 -X 方向。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：commands = [4,-1,3], obstacles = []
 * 输出：25
 * 解释：
 * 机器人开始位于 (0, 0)：
 * 1. 向北移动 4 个单位，到达 (0, 4)
 * 2. 右转
 * 3. 向东移动 3 个单位，到达 (3, 4)
 * 距离原点最远的是 (3, 4) ，距离为 32 + 42 = 25
 * 示例 2：
 * <p>
 * 输入：commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出：65
 * 解释：机器人开始位于 (0, 0)：
 * 1. 向北移动 4 个单位，到达 (0, 4)
 * 2. 右转
 * 3. 向东移动 1 个单位，然后被位于 (2, 4) 的障碍物阻挡，机器人停在 (1, 4)
 * 4. 左转
 * 5. 向北走 4 个单位，到达 (1, 8)
 * 距离原点最远的是 (1, 8) ，距离为 12 + 82 = 65
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= commands.length <= 104
 * commands[i] is one of the values in the list [-2,-1,1,2,3,4,5,6,7,8,9].
 * 0 <= obstacles.length <= 104
 * -3 * 104 <= xi, yi <= 3 * 104
 * 答案保证小于 231
 */
public class Code4 {

    public int robotSim(int[] commands, int[][] obstacles) {
        //最大
        int max = 0;
        //障碍花村
        Set<String> set = new HashSet<>();
        //循环
        for (int[] obstacle : obstacles) {
            //组装
            set.add(obstacle[0] + "," + obstacle[1]);
        }
        //默认位置
        int x = 0, y = 0;
        //方向
        int direction = 0;
        //开始走
        io:
        for (int command : commands) {
            //根据数字操作
            switch (command) {
                case -2:
                    //如果方向绕回来了
                    if (direction == 0) {
                        //回归
                        direction = 3;
                    } else {
                        //递增
                        direction--;
                    }
                    break;
                case -1:
                    //如果方向绕回来了
                    if (direction == 3) {
                        //回归
                        direction = 0;
                    } else {
                        //递增
                        direction++;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    //根据方向操作
                    switch (direction) {
                        case 0:
                            //循环
                            while (command > 0) {
                                //计算
                                y++;
                                //如果是障碍物
                                if (set.contains(x + "," + y)) {
                                    //回滚
                                    y--;
                                    //终止本次
                                    continue io;
                                }
                                //刷新纪录
                                max = Math.max(x * x + y * y, max);
                                //继续
                                command--;
                            }
                            break;
                        case 1:
                            //循环
                            while (command > 0) {
                                //计算
                                x++;
                                //如果是障碍物
                                if (set.contains(x + "," + y)) {
                                    //回滚
                                    x--;
                                    //终止本次
                                    continue io;
                                }
                                //刷新纪录
                                max = Math.max(x * x + y * y, max);
                                //继续
                                command--;
                            }
                            break;
                        case 2:
                            //循环
                            while (command > 0) {
                                //计算
                                y--;
                                //如果是障碍物
                                if (set.contains(x + "," + y)) {
                                    //回滚
                                    y++;
                                    //终止本次
                                    continue io;
                                }
                                //刷新纪录
                                max = Math.max(x * x + y * y, max);
                                //继续
                                command--;
                            }
                            break;
                        case 3:
                            //循环
                            while (command > 0) {
                                //计算
                                x--;
                                //如果是障碍物
                                if (set.contains(x + "," + y)) {
                                    //回滚
                                    x++;
                                    //终止本次
                                    continue io;
                                }
                                //刷新纪录
                                max = Math.max(x * x + y * y, max);
                                //继续
                                command--;
                            }
                            break;
                    }
                    break;
            }
        }
        //结果
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{new int[]{2, 4}}));
    }

}
