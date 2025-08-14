package difficult3;

import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2025-08-14
 * 2931. 购买物品的最大开销
 * 1822
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始大小为 m * n 的整数矩阵 values ，表示 m 个不同商店里 m * n 件不同的物品。每个商店有 n 件物品，第 i 个商店的第 j 件物品的价值为 values[i][j] 。除此以外，第 i 个商店的物品已经按照价值非递增排好序了，也就是说对于所有 0 <= j < n - 1 都有 values[i][j] >= values[i][j + 1] 。
 * <p>
 * 每一天，你可以在一个商店里购买一件物品。具体来说，在第 d 天，你可以：
 * <p>
 * 选择商店 i 。
 * 购买数组中最右边的物品 j ，开销为 values[i][j] * d 。换句话说，选择该商店中还没购买过的物品中最大的下标 j ，并且花费 values[i][j] * d 去购买。
 * 注意，所有物品都视为不同的物品。比方说如果你已经从商店 1 购买了物品 0 ，你还可以在别的商店里购买其他商店的物品 0 。
 * <p>
 * 请你返回购买所有 m * n 件物品需要的 最大开销 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：values = [[8,5,2],[6,4,1],[9,7,3]]
 * 输出：285
 * 解释：第一天，从商店 1 购买物品 2 ，开销为 values[1][2] * 1 = 1 。
 * 第二天，从商店 0 购买物品 2 ，开销为 values[0][2] * 2 = 4 。
 * 第三天，从商店 2 购买物品 2 ，开销为 values[2][2] * 3 = 9 。
 * 第四天，从商店 1 购买物品 1 ，开销为 values[1][1] * 4 = 16 。
 * 第五天，从商店 0 购买物品 1 ，开销为 values[0][1] * 5 = 25 。
 * 第六天，从商店 1 购买物品 0 ，开销为 values[1][0] * 6 = 36 。
 * 第七天，从商店 2 购买物品 1 ，开销为 values[2][1] * 7 = 49 。
 * 第八天，从商店 0 购买物品 0 ，开销为 values[0][0] * 8 = 64 。
 * 第九天，从商店 2 购买物品 0 ，开销为 values[2][0] * 9 = 81 。
 * 所以总开销为 285 。
 * 285 是购买所有 m * n 件物品的最大总开销。
 * 示例 2：
 * <p>
 * 输入：values = [[10,8,6,4,2],[9,7,5,3,2]]
 * 输出：386
 * 解释：第一天，从商店 0 购买物品 4 ，开销为 values[0][4] * 1 = 2 。
 * 第二天，从商店 1 购买物品 4 ，开销为 values[1][4] * 2 = 4 。
 * 第三天，从商店 1 购买物品 3 ，开销为 values[1][3] * 3 = 9 。
 * 第四天，从商店 0 购买物品 3 ，开销为 values[0][3] * 4 = 16 。
 * 第五天，从商店 1 购买物品 2 ，开销为 values[1][2] * 5 = 25 。
 * 第六天，从商店 0 购买物品 2 ，开销为 values[0][2] * 6 = 36 。
 * 第七天，从商店 1 购买物品 1 ，开销为 values[1][1] * 7 = 49 。
 * 第八天，从商店 0 购买物品 1 ，开销为 values[0][1] * 8 = 64 。
 * 第九天，从商店 1 购买物品 0 ，开销为 values[1][0] * 9 = 81 。
 * 第十天，从商店 0 购买物品 0 ，开销为 values[0][0] * 10 = 100 。
 * 所以总开销为 386 。
 * 386 是购买所有 m * n 件物品的最大总开销。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= m == values.length <= 10
 * 1 <= n == values[i].length <= 104
 * 1 <= values[i][j] <= 106
 * values[i] 按照非递增顺序排序。
 */
public class Code16 {

    private static class Node {

        //数字
        private int[] valueArr;

        //索引
        private int index;

        public Node(int[] valueArr) {
            this.valueArr = valueArr;
            this.index = valueArr.length - 1;
        }

        @Override
        public String toString() {
            return String.format("index=%s", this.index);
        }

    }

    public long maxSpending(int[][] values) {
        //优先队列
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.valueArr[a.index] - b.valueArr[b.index]);
        //循环
        for (int[] value : values) {
            //初始化节点并组装
            queue.add(new Node(value));
        }
        //结果
        long result = 0L;
        //天
        long day = 1L;
        //如果还有
        while (queue.isEmpty() == false) {
            //拉取
            Node poll = queue.poll();
            //叠加本次结果
            result += day++ * poll.valueArr[poll.index--];
            //如果还有
            if (poll.index >= 0) {
                //重新加入
                queue.add(poll);
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code16().maxSpending(new int[][]{
                new int[]{8, 5, 2},
                new int[]{6, 4, 1},
                new int[]{9, 7, 3}
        }));
    }

}
