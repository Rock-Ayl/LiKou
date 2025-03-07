package easy38;

import java.util.List;

/**
 * @Author ayl
 * @Date 2024-08-12
 * 3248. 矩阵中的蛇
 * 简单
 * 相关企业
 * 提示
 * 大小为 n x n 的矩阵 grid 中有一条蛇。蛇可以朝 四个可能的方向 移动。矩阵中的每个单元格都使用位置进行标识： grid[i][j] = (i * n) + j。
 * <p>
 * 蛇从单元格 0 开始，并遵循一系列命令移动。
 * <p>
 * 给你一个整数 n 表示 grid 的大小，另给你一个字符串数组 commands，其中包括 "UP"、"RIGHT"、"DOWN" 和 "LEFT"。题目测评数据保证蛇在整个移动过程中将始终位于 grid 边界内。
 * <p>
 * 返回执行 commands 后蛇所停留的最终单元格的位置。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2, commands = ["RIGHT","DOWN"]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 0	1
 * 2	3
 * 0	1
 * 2	3
 * 0	1
 * 2	3
 * 示例 2：
 * <p>
 * 输入：n = 3, commands = ["DOWN","RIGHT","UP"]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 0	1	2
 * 3	4	5
 * 6	7	8
 * 0	1	2
 * 3	4	5
 * 6	7	8
 * 0	1	2
 * 3	4	5
 * 6	7	8
 * 0	1	2
 * 3	4	5
 * 6	7	8
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 10
 * 1 <= commands.length <= 100
 * commands 仅由 "UP"、"RIGHT"、"DOWN" 和 "LEFT" 组成。
 * 生成的测评数据确保蛇不会移动到矩阵的边界外。
 */
public class Code3 {

    public int finalPositionOfSnake(int n, List<String> commands) {
        //蛇
        int snake = 0;
        //循环
        for (String command : commands) {
            //根据指令
            switch (command) {
                case "UP":
                    //计算
                    snake -= n;
                    break;
                case "RIGHT":
                    //计算
                    snake++;
                    break;
                case "DOWN":
                    //计算
                    snake += n;
                    break;
                case "LEFT":
                    //计算
                    snake--;
                    break;
            }
        }
        //返回
        return snake;
    }

    public static void main(String[] args) {

    }

}
