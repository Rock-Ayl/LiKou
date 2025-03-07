package normal33;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2024-07-24
 * 529. 扫雷游戏
 * 中等
 * 相关标签
 * 相关企业
 * 让我们一起来玩扫雷游戏！
 * <p>
 * 给你一个大小为 m x n 二维字符矩阵 board ，表示扫雷游戏的盘面，其中：
 * <p>
 * 'M' 代表一个 未挖出的 地雷，
 * 'E' 代表一个 未挖出的 空方块，
 * 'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的 已挖出的 空白方块，
 * 数字（'1' 到 '8'）表示有多少地雷与这块 已挖出的 方块相邻，
 * 'X' 则表示一个 已挖出的 地雷。
 * 给你一个整数数组 click ，其中 click = [clickr, clickc] 表示在所有 未挖出的 方块（'M' 或者 'E'）中的下一个点击位置（clickr 是行下标，clickc 是列下标）。
 * <p>
 * 根据以下规则，返回相应位置被点击后对应的盘面：
 * <p>
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X' 。
 * 如果一个 没有相邻地雷 的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的 未挖出 方块都应该被递归地揭露。
 * 如果一个 至少与一个地雷相邻 的空方块（'E'）被挖出，修改它为数字（'1' 到 '8' ），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回盘面。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["E","E","E","E","E"],["E","E","M","E","E"],["E","E","E","E","E"],["E","E","E","E","E"]], click = [3,0]
 * 输出：[["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]], click = [1,2]
 * 输出：[["B","1","E","1","B"],["B","1","X","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 50
 * board[i][j] 为 'M'、'E'、'B' 或数字 '1' 到 '8' 中的一个
 * click.length == 2
 * 0 <= clickr < m
 * 0 <= clickc < n
 * board[clickr][clickc] 为 'M' 或 'E'
 */
public class Code17 {

    //已经走过,无需继续再走的网格内容字符集合
    private static final Set<Character> WALKED_SET = new HashSet<>(Arrays.asList('B', 'X', '1', '2', '3', '4', '5', '6', '7', '8'));

    //获取单一位置是否为地雷
    private int getMCount(char[][] board, int x, int y) {
        //如果越界
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            //默认
            return 0;
        }
        //判断
        return (board[x][y] == 'M' || board[x][y] == 'X') ? 1 : 0;
    }

    //获取指定坐标周围地雷数量
    private int getAroundMCount(char[][] board, int x, int y) {
        return getMCount(board, x + 1, y)
                + getMCount(board, x - 1, y)
                + getMCount(board, x, y + 1)
                + getMCount(board, x, y - 1)
                + getMCount(board, x + 1, y + 1)
                + getMCount(board, x + 1, y - 1)
                + getMCount(board, x - 1, y - 1)
                + getMCount(board, x - 1, y + 1);
    }

    //递归实现
    private void next(char[][] board, int x, int y) {
        //如果越界
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            //跳过
            return;
        }
        //当前字符
        char letter = board[x][y];
        //如果走过了
        if (WALKED_SET.contains(letter)) {
            //跳过
            return;
        }
        //根据当前字符处理
        switch (letter) {
            //如果是空地
            case 'E':
                //计算器周围地雷数量
                int mCount = getAroundMCount(board, x, y);
                //判断周围是否有地雷
                if (mCount == 0) {
                    //没有地雷
                    board[x][y] = 'B';
                    //继续递归四个方向
                    next(board, x + 1, y);
                    next(board, x - 1, y);
                    next(board, x, y + 1);
                    next(board, x, y - 1);
                    next(board, x + 1, y + 1);
                    next(board, x + 1, y - 1);
                    next(board, x - 1, y - 1);
                    next(board, x - 1, y + 1);
                } else {
                    //有地雷,直接记录数字
                    board[x][y] = (char) (mCount + '0');
                }
                break;
            //如果是地雷
            case 'M':
                //直接挖地雷
                board[x][y] = 'X';
                break;
        }
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        //递归实现
        next(board, click[0], click[1]);
        //返回
        return board;
    }

    public static void main(String[] args) {
        char[][] result = new Code17().updateBoard(new char[][]{
                new char[]{'E', 'E', 'E', 'E', 'E'},
                new char[]{'E', 'E', 'M', 'E', 'E'},
                new char[]{'E', 'E', 'E', 'E', 'E'},
                new char[]{'E', 'E', 'E', 'E', 'E'}
        }, new int[]{3, 0});
        print(result);
    }

    private static void print(char[][] arr) {
        for (char[] chars : arr) {
            for (char aChar : chars) {
                System.out.print(aChar + ",");
            }
            System.out.println();
        }
    }

}
