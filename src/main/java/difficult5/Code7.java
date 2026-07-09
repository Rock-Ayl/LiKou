package difficult5;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 502. IPO
 * 算术评级: 7
 * 同步题目状态
 * <p>
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 假设 力扣（LeetCode）即将开始 IPO 。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
 * <p>
 * 给你 n 个项目。对于每个项目 i ，它都有一个纯利润 profits[i] ，和启动该项目需要的最小资本 capital[i] 。
 * <p>
 * 最初，你的资本为 w 。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
 * <p>
 * 总而言之，从给定项目中选择 最多 k 个不同项目的列表，以 最大化最终资本 ，并输出最终可获得的最多资本。
 * <p>
 * 答案保证在 32 位有符号整数范围内。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
 * 输出：4
 * 解释：
 * 由于你的初始资本为 0，你仅可以从 0 号项目开始。
 * 在完成后，你将获得 1 的利润，你的总资本将变为 1。
 * 此时你可以选择开始 1 号或 2 号项目。
 * 由于你最多可以选择两个项目，所以你需要完成 2 号项目以获得最大的资本。
 * 因此，输出最后最大化的资本，为 0 + 1 + 3 = 4。
 * 示例 2：
 * <p>
 * 输入：k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
 * 输出：6
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 105
 * 0 <= w <= 109
 * n == profits.length
 * n == capital.length
 * 1 <= n <= 105
 * 0 <= profits[i] <= 104
 * 0 <= capital[i] <= 109
 *
 */
public class Code7 {

    private static class Node {

        //利润
        private int profit;

        //初始资本
        private int capital;

        //初始化
        public Node(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }

        @Override
        public String toString() {
            return String.format("Node{profit=%d, capital=%d}", profit, capital);
        }

    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        /**
         * 构建节点
         */

        //节点数组
        Node[] nodeArr = new Node[profits.length];
        //循环
        for (int i = 0; i < nodeArr.length; i++) {
            //初始化
            nodeArr[i] = new Node(profits[i], capital[i]);
        }
        //按照初始资本要求排序
        Arrays.sort(nodeArr, (a, b) -> a.capital - b.capital);

        /**
         * 计算
         */

        //索引
        int index = 0;
        //按照利润排序
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> b.profit - a.profit);
        //循环
        while (k-- > 0) {

            /**
             * 加入新项目
             */

            //如果当前利润够启动这个项目
            while (index < nodeArr.length && nodeArr[index].capital <= w) {
                //入队
                queue.add(nodeArr[index]);
                //索引增加
                index++;
            }

            /**
             * 选择一个最优项目
             */

            //如果没有项目
            if (queue.isEmpty()) {
                //返回
                return w;
            }

            //出队
            Node node = queue.poll();
            //资本增加
            w += node.profit;
        }

        //返回
        return w;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().findMaximizedCapital(1, 2, new int[]{1, 2, 3}, new int[]{1, 1, 2}));
    }

}
