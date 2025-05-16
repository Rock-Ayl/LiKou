package normal43;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-05-16
 * 3393. 统计异或值为给定值的路径数目
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个大小为 m x n 的二维整数数组 grid 和一个整数 k 。
 * <p>
 * 你的任务是统计满足以下 条件 且从左上格子 (0, 0) 出发到达右下格子 (m - 1, n - 1) 的路径数目：
 * <p>
 * 每一步你可以向右或者向下走，也就是如果格子存在的话，可以从格子 (i, j) 走到格子 (i, j + 1) 或者格子 (i + 1, j) 。
 * 路径上经过的所有数字 XOR 异或值必须 等于 k 。
 * 请你返回满足上述条件的路径总数。
 * <p>
 * 由于答案可能很大，请你将答案对 109 + 7 取余 后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[2, 1, 5], [7, 10, 0], [12, 6, 4]], k = 11
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 3 条路径分别为：
 * <p>
 * (0, 0) → (1, 0) → (2, 0) → (2, 1) → (2, 2)
 * (0, 0) → (1, 0) → (1, 1) → (1, 2) → (2, 2)
 * (0, 0) → (0, 1) → (1, 1) → (2, 1) → (2, 2)
 * 示例 2：
 * <p>
 * 输入：grid = [[1, 3, 3, 3], [0, 3, 3, 2], [3, 0, 1, 1]], k = 2
 * <p>
 * 输出：5
 * <p>
 * 解释：
 * <p>
 * 5 条路径分别为：
 * <p>
 * (0, 0) → (1, 0) → (2, 0) → (2, 1) → (2, 2) → (2, 3)
 * (0, 0) → (1, 0) → (1, 1) → (2, 1) → (2, 2) → (2, 3)
 * (0, 0) → (1, 0) → (1, 1) → (1, 2) → (1, 3) → (2, 3)
 * (0, 0) → (0, 1) → (1, 1) → (1, 2) → (2, 2) → (2, 3)
 * (0, 0) → (0, 1) → (0, 2) → (1, 2) → (2, 2) → (2, 3)
 * 示例 3：
 * <p>
 * 输入：grid = [[1, 1, 1, 2], [3, 0, 3, 2], [3, 0, 2, 2]], k = 10
 * <p>
 * 输出：0
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= m == grid.length <= 300
 * 1 <= n == grid[r].length <= 300
 * 0 <= grid[r][c] < 16
 * 0 <= k < 16
 */
public class Code1 {

    //节点
    private static class Node {

        //节点不同路径的map
        private Map<Integer, Long> walkCountMap = new HashMap<>();

        @Override
        public String toString() {
            //组装str
            StringBuilder str = new StringBuilder();
            //循环
            for (Map.Entry<Integer, Long> entry : walkCountMap.entrySet()) {
                //组装
                str.append(String.format("[%s->%s]", entry.getKey(), entry.getValue()));
            }
            //返回
            return str.toString();
        }

    }

    public int countPathsWithXorValue(int[][] grid, int k) {

        /**
         * 动态规划数组
         */

        //初始化缓存
        Node[][] arr = new Node[grid.length][grid[0].length];

        /**
         * 初始化 第一个节点
         */

        //第一个节点
        Node firstNode = new Node();
        //第一个节点的路径
        firstNode.walkCountMap.put(grid[0][0], 1L);
        //记录
        arr[0][0] = firstNode;

        /**
         * 初始化 第一行列
         */

        //循环
        for (int i = 1; i < arr.length; i++) {

            //初始化当前节点
            Node node = new Node();
            //记录
            arr[i][0] = node;
            //获取上一个节点
            Node lastNode = arr[i - 1][0];

            //循环
            for (Map.Entry<Integer, Long> entry : lastNode.walkCountMap.entrySet()) {
                //计算路径
                node.walkCountMap.put(entry.getKey() ^ grid[i][0], entry.getValue());
            }

        }

        //循环2
        for (int i = 1; i < arr[0].length; i++) {

            //初始化当前节点
            Node node = new Node();
            //记录
            arr[0][i] = node;
            //获取上一个节点
            Node lastNode = arr[0][i - 1];

            //循环
            for (Map.Entry<Integer, Long> entry : lastNode.walkCountMap.entrySet()) {
                //计算路径
                node.walkCountMap.put(entry.getKey() ^ grid[0][i], entry.getValue());
            }

        }

        /**
         * 计算剩余动态规划
         */

        //循环1
        for (int i = 1; i < arr.length; i++) {
            //循环2
            for (int j = 1; j < arr[0].length; j++) {

                //初始化当前节点
                Node node = new Node();
                //记录
                arr[i][j] = node;

                //获取上二个节点
                Node lastNode1 = arr[i][j - 1];
                Node lastNode2 = arr[i - 1][j];

                //循环
                for (Map.Entry<Integer, Long> entry : lastNode1.walkCountMap.entrySet()) {
                    //计算key
                    int key = entry.getKey() ^ grid[i][j];
                    //叠加路径
                    node.walkCountMap.put(key, (node.walkCountMap.getOrDefault(key, 0L) + entry.getValue() % 1000000007L));
                }

                //循环
                for (Map.Entry<Integer, Long> entry : lastNode2.walkCountMap.entrySet()) {
                    //计算key
                    int key = entry.getKey() ^ grid[i][j];
                    //叠加路径
                    node.walkCountMap.put(key, (node.walkCountMap.getOrDefault(key, 0L) + entry.getValue() % 1000000007L));
                }

            }
        }

        //返回结果
        return (int) (arr[arr.length - 1][arr[0].length - 1].walkCountMap.getOrDefault(k, 0L) % 1000000007L);
    }

    public static void main(String[] args) {

        System.out.println(new Code1().countPathsWithXorValue(new int[][]{
                new int[]{2, 1, 5},
                new int[]{7, 10, 0},
                new int[]{12, 6, 4}
        }, 11));
    }

}
