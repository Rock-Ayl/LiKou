package normal42;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-04-29
 * 2033. 获取单值网格的最小操作数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个大小为 m x n 的二维整数网格 grid 和一个整数 x 。每一次操作，你可以对 grid 中的任一元素 加 x 或 减 x 。
 * <p>
 * 单值网格 是全部元素都相等的网格。
 * <p>
 * 返回使网格化为单值网格所需的 最小 操作数。如果不能，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[2,4],[6,8]], x = 2
 * 输出：4
 * 解释：可以执行下述操作使所有元素都等于 4 ：
 * - 2 加 x 一次。
 * - 6 减 x 一次。
 * - 8 减 x 两次。
 * 共计 4 次操作。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,5],[2,3]], x = 1
 * 输出：5
 * 解释：可以使所有元素都等于 3 。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,2],[3,4]], x = 2
 * 输出：-1
 * 解释：无法使所有元素相等。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 105
 * 1 <= m * n <= 105
 * 1 <= x, grid[i][j] <= 104
 */
public class Code10 {

    //节点
    private static class Node {

        //数字
        private int number;

        //数量
        private int count = 0;

        //初始化
        public Node(int number) {
            this.number = number;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("number=%s,count=%s", this.number, this.count);
        }

    }

    public int minOperations(int[][] grid, int x) {

        /**
         * 构建节点
         */

        //节点缓存
        Map<Integer, Node> nodeMap = new HashMap<>(grid.length * grid[0].length);
        //循环1
        for (int[] ints : grid) {
            //循环2
            for (int number : ints) {
                //初始化
                nodeMap.putIfAbsent(number, new Node(number));
                //+1
                nodeMap.get(number).count++;
            }
        }
        //初始化列表
        List<Node> nodeList = new ArrayList<>(nodeMap.values());
        //排序
        nodeList.sort((a, b) -> a.number - b.number);

        /**
         * 开始不断收缩
         */

        //操作次数和
        int changeSum = 0;
        //双指针
        int leftIndex = 0;
        int rightIndex = nodeList.size() - 1;
        //循环
        while (leftIndex < rightIndex) {
            //获取左右节点
            Node leftNode = nodeList.get(leftIndex);
            Node rightNode = nodeList.get(rightIndex);
            //如果左边小
            if (leftNode.count <= rightNode.count) {
                //移动,并获取下一个节点
                Node nextNode = nodeList.get(++leftIndex);
                //移动距离
                int move = nextNode.number - leftNode.number;
                //如果不能移动至此
                if (move % x != 0) {
                    //无法产生结果
                    return -1;
                }
                //操作次数
                int change = move / x * leftNode.count;
                //叠加
                changeSum += change;
                nextNode.count += leftNode.count;
            } else {
                //移动,并获取下一个节点
                Node nextNode = nodeList.get(--rightIndex);
                //移动距离
                int move = rightNode.number - nextNode.number;
                //如果不能移动至此
                if (move % x != 0) {
                    //无法产生结果
                    return -1;
                }
                //操作次数
                int change = move / x * rightNode.count;
                //叠加
                changeSum += change;
                nextNode.count += rightNode.count;
            }

        }

        //返回结果
        return changeSum;
    }

    public static void main(String[] args) {
        System.out.println(new Code10().minOperations(new int[][]{
                new int[]{2, 4},
                new int[]{6, 8}
        }, 2));
    }

}
