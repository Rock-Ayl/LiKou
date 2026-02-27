package normal50;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2070. 每一个查询的最大美丽值
 * 算术评级: 5
 * 第 65 场双周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1724
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个二维整数数组 items ，其中 items[i] = [pricei, beautyi] 分别表示每一个物品的 价格 和 美丽值 。
 * <p>
 * 同时给你一个下标从 0 开始的整数数组 queries 。对于每个查询 queries[j] ，你想求出价格小于等于 queries[j] 的物品中，最大的美丽值 是多少。如果不存在符合条件的物品，那么查询的结果为 0 。
 * <p>
 * 请你返回一个长度与 queries 相同的数组 answer，其中 answer[j]是第 j 个查询的答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：items = [[1,2],[3,2],[2,4],[5,6],[3,5]], queries = [1,2,3,4,5,6]
 * 输出：[2,4,5,5,6,6]
 * 解释：
 * - queries[0]=1 ，[1,2] 是唯一价格 <= 1 的物品。所以这个查询的答案为 2 。
 * - queries[1]=2 ，符合条件的物品有 [1,2] 和 [2,4] 。
 * 它们中的最大美丽值为 4 。
 * - queries[2]=3 和 queries[3]=4 ，符合条件的物品都为 [1,2] ，[3,2] ，[2,4] 和 [3,5] 。
 * 它们中的最大美丽值为 5 。
 * - queries[4]=5 和 queries[5]=6 ，所有物品都符合条件。
 * 所以，答案为所有物品中的最大美丽值，为 6 。
 * 示例 2：
 * <p>
 * 输入：items = [[1,2],[1,2],[1,3],[1,4]], queries = [1]
 * 输出：[4]
 * 解释：
 * 每个物品的价格均为 1 ，所以我们选择最大美丽值 4 。
 * 注意，多个物品可能有相同的价格和美丽值。
 * 示例 3：
 * <p>
 * 输入：items = [[10,1000]], queries = [5]
 * 输出：[0]
 * 解释：
 * 没有物品的价格小于等于 5 ，所以没有物品可以选择。
 * 因此，查询的结果为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= items.length, queries.length <= 105
 * items[i].length == 2
 * 1 <= pricei, beautyi, queries[j] <= 109
 */
public class Code22 {

    private static class Node {

        //索引
        private int index;

        //查询价格
        private int query;

        //初始化
        public Node(int index, int query) {
            this.index = index;
            this.query = query;
        }

        //方便调试
        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", query=" + query +
                    '}';
        }

    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        //排序
        Arrays.sort(items, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        //节点数组
        Node[] nodeArr = new Node[queries.length];
        //循环
        for (int i = 0; i < nodeArr.length; i++) {
            //初始化
            nodeArr[i] = new Node(i, queries[i]);
        }
        //排序
        Arrays.sort(nodeArr, (a, b) -> a.query - b.query);
        //结果
        int[] result = new int[queries.length];
        //索引
        int itemIndex = 0;
        //最大值
        int maxValue = 0;
        //循环
        for (Node node : nodeArr) {
            //如果还有可选物品
            while (itemIndex < items.length && items[itemIndex][0] <= node.query) {
                //刷新最大美丽
                maxValue = Math.max(maxValue, items[itemIndex][1]);
                //下一个
                itemIndex++;
            }
            //记录本次最大值
            result[node.index] = maxValue;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new Code22().maximumBeauty(new int[][]{{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}}, new int[]{1, 2, 3, 4, 5, 6});
        System.out.println();
    }

}