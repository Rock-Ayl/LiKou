package normal37;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2024-11-08
 * 1091. 二进制矩阵中的最短路径
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 * <p>
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
 * <p>
 * 路径途经的所有单元格的值都是 0 。
 * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 畅通路径的长度 是该路径途经的单元格总数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[0,1],[1,0]]
 * 输出：2
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] 为 0 或 1
 */
public class Code5 {

    //节点
    public static class Node {

        //坐标x
        private int x;

        //坐标y
        private int y;

        //初始化
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        //重写hash
        @Override
        public int hashCode() {
            return x * 1000 + y;
        }

        //重写比较
        @Override
        public boolean equals(Object obj) {
            //如果不是该对象
            if (obj instanceof Node == false) {
                //过
                return false;
            }
            //强转
            Node another = (Node) obj;
            //判断
            return this.x == another.x && this.y == another.y;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("%s,%s", this.x, this.y);
        }

    }

    //适配本次的获取数组内容
    private int get(int[][] arr, int x, int y) {
        //如果越界
        if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length) {
            //默认返回-1
            return -1;
        }
        //返回
        return arr[x][y];
    }

    //尝试寻找并走到下一个节点
    private void checkAndWalk(int[][] grid, int[][] result, Set<Node> nextNodeSet, int nextX, int nextY, int nodeCount) {
        //如果 可以移动到目标节点 and 之前没有移动过
        if (get(grid, nextX, nextY) == 0 && get(result, nextX, nextY) == 0) {
            //记录节点
            nextNodeSet.add(new Node(nextX, nextY));
            //记录已走过
            result[nextX][nextY] = nodeCount;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        //横纵长度
        int m = grid.length;
        int n = grid[0].length;
        //如果 开始节点 or 最后节点 不是可以移动的
        if (grid[m - 1][n - 1] != 0 || grid[0][0] != 0) {
            //默认
            return -1;
        }
        //如果只有一个点
        if (m == 1 && n == 1) {
            //返回
            return 1;
        }
        //初始化结果数组
        int[][] result = new int[m][n];
        //本次要使用的节点数量
        int nodeCount = 1;
        //初始化开始节点数量=1,并++
        result[0][0] = nodeCount++;
        //初始化本次可执行节点集合
        Set<Node> nodeSet = new HashSet<>();
        //默认开始节点
        nodeSet.add(new Node(0, 0));
        //如果还有
        while (nodeSet.isEmpty() == false) {
            //初始化下次可执行数组
            Set<Node> nextNodeSet = new HashSet<>();
            //循环
            for (Node node : nodeSet) {
                //获取当前坐标
                int x = node.x;
                int y = node.y;
                //尝试并走到下一个位置,一共8个方向
                checkAndWalk(grid, result, nextNodeSet, x + 1, y, nodeCount);
                checkAndWalk(grid, result, nextNodeSet, x - 1, y, nodeCount);
                checkAndWalk(grid, result, nextNodeSet, x, y + 1, nodeCount);
                checkAndWalk(grid, result, nextNodeSet, x, y - 1, nodeCount);
                checkAndWalk(grid, result, nextNodeSet, x + 1, y + 1, nodeCount);
                checkAndWalk(grid, result, nextNodeSet, x + 1, y - 1, nodeCount);
                checkAndWalk(grid, result, nextNodeSet, x - 1, y + 1, nodeCount);
                checkAndWalk(grid, result, nextNodeSet, x - 1, y - 1, nodeCount);
            }
            //如果走到了最终节点
            if (result[m - 1][n - 1] != 0) {
                //返回
                return nodeCount;
            }
            //下一次
            nodeSet = nextNodeSet;
            //+1
            nodeCount++;
        }
        //默认
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().shortestPathBinaryMatrix(new int[][]{
                new int[]{0, 0, 0},
                new int[]{1, 1, 0},
                new int[]{1, 1, 0}
        }));
    }

}
