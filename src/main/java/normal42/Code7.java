package normal42;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-04-25
 * 2008. 出租车的最大盈利
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 你驾驶出租车行驶在一条有 n 个地点的路上。这 n 个地点从近到远编号为 1 到 n ，你想要从 1 开到 n ，通过接乘客订单盈利。你只能沿着编号递增的方向前进，不能改变方向。
 * <p>
 * 乘客信息用一个下标从 0 开始的二维数组 rides 表示，其中 rides[i] = [starti, endi, tipi] 表示第 i 位乘客需要从地点 starti 前往 endi ，愿意支付 tipi 元的小费。
 * <p>
 * 每一位 你选择接单的乘客 i ，你可以 盈利 endi - starti + tipi 元。你同时 最多 只能接一个订单。
 * <p>
 * 给你 n 和 rides ，请你返回在最优接单方案下，你能盈利 最多 多少元。
 * <p>
 * 注意：你可以在一个地点放下一位乘客，并在同一个地点接上另一位乘客。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, rides = [[2,5,4],[1,5,1]]
 * 输出：7
 * 解释：我们可以接乘客 0 的订单，获得 5 - 2 + 4 = 7 元。
 * 示例 2：
 * <p>
 * 输入：n = 20, rides = [[1,6,1],[3,10,2],[10,12,3],[11,12,2],[12,15,2],[13,18,1]]
 * 输出：20
 * 解释：我们可以接以下乘客的订单：
 * - 将乘客 1 从地点 3 送往地点 10 ，获得 10 - 3 + 2 = 9 元。
 * - 将乘客 2 从地点 10 送往地点 12 ，获得 12 - 10 + 3 = 5 元。
 * - 将乘客 5 从地点 13 送往地点 18 ，获得 18 - 13 + 1 = 6 元。
 * 我们总共获得 9 + 5 + 6 = 20 元。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * 1 <= rides.length <= 3 * 104
 * rides[i].length == 3
 * 1 <= starti < endi <= n
 * 1 <= tipi <= 105
 */
public class Code7 {

    private static class Node {

        //开始
        private int start;

        //结束
        private int end;

        //盈利
        private int sale;

        //初始化
        public Node(int start, int end, int sale) {
            this.start = start;
            this.end = end;
            this.sale = sale;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("start=%s,end=%s,sale=%s", this.start, this.end, this.sale);
        }

    }

    public long maxTaxiEarnings(int n, int[][] rides) {

        /**
         * 构建节点、排序
         */

        //节点数组
        Node[] nodeArr = new Node[rides.length];
        //索引
        int nodeIndex = 0;
        //循环
        for (int[] ride : rides) {
            //初始化并组装
            nodeArr[nodeIndex++] = new Node(ride[0], ride[1], ride[2] + ride[1] - ride[0]);
        }
        //排序
        Arrays.sort(nodeArr,(a, b) -> a.start - b.start);

        /**
         * 开始计算
         */

        //动态规划
        long[] arr = new long[n + 1];
        //索引
        int index = 0;
        //最大可能
        long max = 0L;
        //循环
        for (Node node : nodeArr) {

            /**
             * 填补已经结束的时间
             */

            //循环
            while (index + 1 <= node.start) {
                //刷新最大可能
                arr[index + 1] = Math.max(arr[index + 1], arr[index]);
                //+1
                index++;
            }

            /**
             * 计算当前
             */

            //更新本次最大可能
            arr[node.end] = Math.max(arr[node.end], arr[index] + node.sale);
            //刷新总最大可能
            max = Math.max(max, arr[node.end]);

        }
        //返回最大结果
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().maxTaxiEarnings(5, new int[][]{
                new int[]{1, 2, 4},
                new int[]{2, 3, 1}}
        ));
    }

}
