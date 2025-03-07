package normal29;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2024-03-09
 * 1926. 迷宫中离入口最近的出口
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 m x n 的迷宫矩阵 maze （下标从 0 开始），矩阵中有空格子（用 '.' 表示）和墙（用 '+' 表示）。同时给你迷宫的入口 entrance ，用 entrance = [entrancerow, entrancecol] 表示你一开始所在格子的行和列。
 * <p>
 * 每一步操作，你可以往 上，下，左 或者 右 移动一个格子。你不能进入墙所在的格子，你也不能离开迷宫。你的目标是找到离 entrance 最近 的出口。出口 的含义是 maze 边界 上的 空格子。entrance 格子 不算 出口。
 * <p>
 * 请你返回从 entrance 到最近出口的最短路径的 步数 ，如果不存在这样的路径，请你返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
 * 输出：1
 * 解释：总共有 3 个出口，分别位于 (1,0)，(0,2) 和 (2,3) 。
 * 一开始，你在入口格子 (1,2) 处。
 * - 你可以往左移动 2 步到达 (1,0) 。
 * - 你可以往上移动 1 步到达 (0,2) 。
 * 从入口处没法到达 (2,3) 。
 * 所以，最近的出口是 (0,2) ，距离为 1 步。
 * 示例 2：
 * <p>
 * <p>
 * 输入：maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
 * 输出：2
 * 解释：迷宫中只有 1 个出口，在 (1,2) 处。
 * (1,0) 不算出口，因为它是入口格子。
 * 初始时，你在入口与格子 (1,0) 处。
 * - 你可以往右移动 2 步到达 (1,2) 处。
 * 所以，最近的出口为 (1,2) ，距离为 2 步。
 * 示例 3：
 * <p>
 * <p>
 * 输入：maze = [[".","+"]], entrance = [0,0]
 * 输出：-1
 * 解释：这个迷宫中没有出口。
 * <p>
 * <p>
 * 提示：
 * <p>
 * maze.length == m
 * maze[i].length == n
 * 1 <= m, n <= 100
 * maze[i][j] 要么是 '.' ，要么是 '+' 。
 * entrance.length == 2
 * 0 <= entrancerow < m
 * 0 <= entrancecol < n
 * entrance 一定是空格子。
 */
public class Code19 {

    //节点
    private class Node {

        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }


    }

    /**
     * 递归不断寻找
     *
     * @param maze    地图
     * @param walked  走过的路
     * @param nodeSet 当前节点列表
     * @param move    走了几步
     * @return
     */
    private int exit(char[][] maze, int[][] walked, Set<Node> nodeSet, int move) {
        //下一次走过的路
        Set<Node> nextNodeSet = new HashSet<>();
        //循环本次所有可能
        for (Node node : nodeSet) {
            //坐标
            int x = node.x;
            int y = node.y;
            //如果是墙
            if (maze[x][y] == '+') {
                //本轮过
                continue;
            }
            //如果不是起始位置 and 是出口
            if (move != 0 && (x == 0 || y == 0 || x == maze.length - 1 || y == maze[0].length - 1)) {
                //返回最近的结果
                return move;
            }
            //上如果可以走 and 没走过 and 是可以走的路
            if (x > 0 && walked[x - 1][y]++ == 0 && maze[x - 1][y] == '.') {
                //记录
                nextNodeSet.add(new Node(x - 1, y));
            }
            //左如果可以走 and 没走过 and 是可以走的路
            if (y > 0 && walked[x][y - 1]++ == 0 && maze[x][y - 1] == '.') {
                //记录
                nextNodeSet.add(new Node(x, y - 1));
            }
            //下如果可以走 and 没走过 and 是可以走的路
            if (x < maze.length - 1 && walked[x + 1][y]++ == 0 && maze[x + 1][y] == '.') {
                //记录
                nextNodeSet.add(new Node(x + 1, y));
            }
            //右如果可以走 and 没走过 and 是可以走的路
            if (y < maze[0].length - 1 && walked[x][y + 1]++ == 0 && maze[x][y + 1] == '.') {
                //记录
                nextNodeSet.add(new Node(x, y + 1));
            }
        }
        //如果没有
        if (nextNodeSet.isEmpty()) {
            //不存在
            return -1;
        }
        //递归实现
        return exit(maze, walked, nextNodeSet, move + 1);
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        //走过的路
        int[][] walked = new int[maze.length][maze[0].length];
        //开始位置
        Node node = new Node(entrance[0], entrance[1]);
        //开始节点集合
        HashSet<Node> firstNodeSet = new HashSet<>();
        //加入
        firstNodeSet.add(node);
        //记录开始节点已经走过
        walked[node.x][node.y]++;
        //递归实现
        return exit(maze, walked, firstNodeSet, 0);
    }

    public static void main(String[] args) {
        System.out.println(new Code19().nearestExit(new char[][]{
                new char[]{'+', '+', '+'},
                new char[]{'.', '.', '.'},
                new char[]{'+', '+', '+'}
        }, new int[]{1, 0}));
    }

}
