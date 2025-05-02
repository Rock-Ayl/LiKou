package normal42;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-05-02
 * 3528. 单位转换 I
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 有 n 种单位，编号从 0 到 n - 1。给你一个二维整数数组 conversions，长度为 n - 1，其中 conversions[i] = [sourceUniti, targetUniti, conversionFactori] ，表示一个 sourceUniti 类型的单位等于 conversionFactori 个 targetUniti 类型的单位。
 * <p>
 * 请你返回一个长度为 n 的数组 baseUnitConversion，其中 baseUnitConversion[i] 表示 一个 0 类型单位等于多少个 i 类型单位。由于结果可能很大，请返回每个 baseUnitConversion[i] 对 109 + 7 取模后的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： conversions = [[0,1,2],[1,2,3]]
 * <p>
 * 输出： [1,2,6]
 * <p>
 * 解释：
 * <p>
 * 使用 conversions[0]：将一个 0 类型单位转换为 2 个 1 类型单位。
 * 使用 conversions[0] 和 conversions[1] 将一个 0 类型单位转换为 6 个 2 类型单位。
 * <p>
 * 示例 2：
 * <p>
 * 输入： conversions = [[0,1,2],[0,2,3],[1,3,4],[1,4,5],[2,5,2],[4,6,3],[5,7,4]]
 * <p>
 * 输出： [1,2,3,8,10,6,30,24]
 * <p>
 * 解释：
 * <p>
 * 使用 conversions[0] 将一个 0 类型单位转换为 2 个 1 类型单位。
 * 使用 conversions[1] 将一个 0 类型单位转换为 3 个 2 类型单位。
 * 使用 conversions[0] 和 conversions[2] 将一个 0 类型单位转换为 8 个 3 类型单位。
 * 使用 conversions[0] 和 conversions[3] 将一个 0 类型单位转换为 10 个 4 类型单位。
 * 使用 conversions[1] 和 conversions[4] 将一个 0 类型单位转换为 6 个 5 类型单位。
 * 使用 conversions[0]、conversions[3] 和 conversions[5] 将一个 0 类型单位转换为 30 个 6 类型单位。
 * 使用 conversions[1]、conversions[4] 和 conversions[6] 将一个 0 类型单位转换为 24 个 7 类型单位。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 105
 * conversions.length == n - 1
 * 0 <= sourceUniti, targetUniti < n
 * 1 <= conversionFactori <= 109
 * 保证单位 0 可以通过 唯一 的转换路径（不需要反向转换）转换为任何其他单位。
 */
public class Code13 {

    private static class Node {

        //索引
        private int index;

        //结果
        private long count = 0;

        //子节点<子节点,倍率>
        private Map<Node, Integer> childMap = new HashMap<>();

        //初始化1
        public Node(int index) {
            this.index = index;
        }

        //初始化2
        public Node(int index, int count) {
            this.index = index;
            this.count = count;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("index=%s", this.index);
        }

    }

    public int[] baseUnitConversions(int[][] conversions) {

        /**
         * 构建节点
         */

        //缓存
        Map<Integer, Node> nodeMap = new HashMap<>();
        //初始化root
        Node root = new Node(0, 1);
        //组装
        nodeMap.put(0, root);
        //循环
        for (int[] conversion : conversions) {
            //初始化
            nodeMap.putIfAbsent(conversion[0], new Node(conversion[0]));
            nodeMap.putIfAbsent(conversion[1], new Node(conversion[1]));
            //关联二者
            nodeMap.get(conversion[0]).childMap.put(nodeMap.get(conversion[1]), conversion[2]);
        }

        /**
         * 计算结果
         */

        //初始化结果
        int[] result = new int[nodeMap.size()];
        //默认第一个结果
        result[0] = 1;
        //循环
        for (Map.Entry<Node, Integer> entry : root.childMap.entrySet()) {
            //递归
            next(entry.getKey(), root, result);
        }
        //返回
        return result;
    }

    //递归
    private void next(Node node, Node father, int[] result) {
        //结果
        long count = father.count * father.childMap.get(node);
        //记录
        node.count = (int) (count % 1000000007L);
        //记录结果
        result[node.index] = (int) (count % 1000000007L);
        //循环
        for (Map.Entry<Node, Integer> entry : node.childMap.entrySet()) {
            //递归
            next(entry.getKey(), node, result);
        }
    }

    public static void main(String[] args) {
        int[] ints = new Code13().baseUnitConversions(new int[][]{
                new int[]{0, 1, 2},
                new int[]{0, 2, 3},
                new int[]{1, 3, 4},
                new int[]{1, 4, 5},
                new int[]{2, 5, 2},
                new int[]{4, 6, 3},
                new int[]{5, 7, 4}
        });
        System.out.println();
    }

}
