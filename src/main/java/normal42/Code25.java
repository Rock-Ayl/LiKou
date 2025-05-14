package normal42;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2025-05-14
 * 624. 数组列表中的最大距离
 * 中等
 * 相关标签
 * 相关企业
 * 给定 m 个数组，每个数组都已经按照升序排好序了。
 * <p>
 * 现在你需要从两个不同的数组中选择两个整数（每个数组选一个）并且计算它们的距离。两个整数 a 和 b 之间的距离定义为它们差的绝对值 |a-b| 。
 * <p>
 * 返回最大距离。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[1,2,3],[4,5],[1,2,3]]
 * 输出：4
 * 解释：
 * 一种得到答案 4 的方法是从第一个数组或者第三个数组中选择 1，同时从第二个数组中选择 5 。
 * 示例 2：
 * <p>
 * 输入：arrays = [[1],[1]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == arrays.length
 * 2 <= m <= 105
 * 1 <= arrays[i].length <= 500
 * -104 <= arrays[i][j] <= 104
 * arrays[i] 以 升序 排序。
 * 所有数组中最多有 105 个整数。
 */
public class Code25 {

    //结果
    private static class Node {

        //最小
        private int min;

        //最大
        private int max;

        //初始化
        public Node(int min, int max) {
            this.min = min;
            this.max = max;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("min=%s,max=%s", this.min, this.max);
        }

    }

    public int maxDistance(List<List<Integer>> arrays) {
        //节点列表
        List<Node> nodeList = new ArrayList<>();
        //队列
        PriorityQueue<Node> minQueue = new PriorityQueue<>((a, b) -> a.min - b.min);
        PriorityQueue<Node> maxQueue = new PriorityQueue<>((a, b) -> b.max - a.max);
        //循环
        for (List<Integer> array : arrays) {
            //初始化节点
            Node node = new Node(array.get(0), array.get(array.size() - 1));
            //加入队列、列表
            minQueue.add(node);
            maxQueue.add(node);
            nodeList.add(node);
        }
        //如果最大最小不同
        if (minQueue.peek() != maxQueue.peek()) {
            //返回最小
            return maxQueue.peek().max - minQueue.peek().min;
        }
        //最大距离
        int maxAway = 0;
        //循环
        for (Node node : nodeList) {
            //如果最小的不是他
            if (minQueue.peek() != node) {
                //计算最大距离、并刷新
                maxAway = Math.max(maxAway, node.max - minQueue.peek().min);
            }
            //如果最大的不是他
            if (maxQueue.peek() != node) {
                //计算最大距离、并刷新
                maxAway = Math.max(maxAway, maxQueue.peek().max - node.min);
            }
        }
        //返回
        return maxAway;
    }

    public static void main(String[] args) {
        System.out.println(new Code25().maxDistance(Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(1, 2, 3)
        )));
    }

}
