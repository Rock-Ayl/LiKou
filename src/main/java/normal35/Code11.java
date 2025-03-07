package normal35;

import java.util.*;

/**
 * @Author ayl
 * @Date 2024-09-24
 * 3080. 执行操作标记数组中的元素
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个长度为 n 下标从 0 开始的正整数数组 nums 。
 * <p>
 * 同时给你一个长度为 m 的二维操作数组 queries ，其中 queries[i] = [indexi, ki] 。
 * <p>
 * 一开始，数组中的所有元素都 未标记 。
 * <p>
 * 你需要依次对数组执行 m 次操作，第 i 次操作中，你需要执行：
 * <p>
 * 如果下标 indexi 对应的元素还没标记，那么标记这个元素。
 * 然后标记 ki 个数组中还没有标记的 最小 元素。如果有元素的值相等，那么优先标记它们中下标较小的。如果少于 ki 个未标记元素存在，那么将它们全部标记。
 * 请你返回一个长度为 m 的数组 answer ，其中 answer[i]是第 i 次操作后数组中还没标记元素的 和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,1,2,3,1], queries = [[1,2],[3,3],[4,2]]
 * <p>
 * 输出：[8,3,0]
 * <p>
 * 解释：
 * <p>
 * 我们依次对数组做以下操作：
 * <p>
 * 标记下标为 1 的元素，同时标记 2 个未标记的最小元素。标记完后数组为 nums = [1,2,2,1,2,3,1] 。未标记元素的和为 2 + 2 + 3 + 1 = 8 。
 * 标记下标为 3 的元素，由于它已经被标记过了，所以我们忽略这次标记，同时标记最靠前的 3 个未标记的最小元素。标记完后数组为 nums = [1,2,2,1,2,3,1] 。未标记元素的和为 3 。
 * 标记下标为 4 的元素，由于它已经被标记过了，所以我们忽略这次标记，同时标记最靠前的 2 个未标记的最小元素。标记完后数组为 nums = [1,2,2,1,2,3,1] 。未标记元素的和为 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,4,2,3], queries = [[0,1]]
 * <p>
 * 输出：[7]
 * <p>
 * 解释：我们执行一次操作，将下标为 0 处的元素标记，并且标记最靠前的 1 个未标记的最小元素。标记完后数组为 nums = [1,4,2,3] 。未标记元素的和为 4 + 3 = 7 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * m == queries.length
 * 1 <= m <= n <= 105
 * 1 <= nums[i] <= 105
 * queries[i].length == 2
 * 0 <= indexi, ki <= n - 1
 */
public class Code11 {

    //数字节点
    private static class Node {

        //索引
        private int index;

        //数字
        private long number;

        //是否标记,默认未标记
        private boolean tag = false;

        //初始化
        public Node(int index, int number) {
            this.index = index;
            this.number = number;
        }

        //节点之间的对比
        public int compareTo(Node node) {
            //如果数字相同
            if (this.number == node.number) {
                //对比下标
                return this.index - node.index;
            } else {
                //对比数字
                return (int) (this.number - node.number);
            }
        }

        //方便调试
        @Override
        public String toString() {
            return number + "," + index;
        }

    }

    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        //求和
        long sum = Arrays.stream(nums).mapToLong(p -> (long) p).sum();
        //结果
        List<Long> result = new ArrayList<>();
        //优先队列
        PriorityQueue<Node> queue = new PriorityQueue<>(Node::compareTo);
        //索引缓存
        Map<Integer, Node> nodeMap = new HashMap<>();
        //循环
        for (int i = 0; i < nums.length; i++) {
            //初始化节点
            Node node = new Node(i, nums[i]);
            //加入队列
            queue.add(node);
            //加入索引缓存
            nodeMap.put(i, node);
        }
        //循环
        for (int i = 0; i < queries.length; i++) {
            //获取要强行标记的节点
            Node node = nodeMap.get(queries[i][0]);
            //当前和
            long thisSum = node.tag == true ? 0L : node.number;
            //强行标记其
            node.tag = true;
            //获取接下来要标记的数量
            int count = queries[i][1];
            //如果还可以标记
            while (count > 0 && queue.isEmpty() == false) {
                //拉取一个标记节点
                Node poll = queue.poll();
                //如果已经标记了
                if (poll.tag == true) {
                    //本轮过
                    continue;
                }
                //标记
                poll.tag = true;
                //记录数量
                count--;
                //叠加本次和
                thisSum += poll.number;
            }
            //计算剩余
            sum = sum - thisSum;
            //记录本次结果
            result.add(sum);
        }
        //返回结果
        return result.stream().mapToLong(Long::longValue).toArray();
    }

    public static void main(String[] args) {
        long[] longs = new Code11().unmarkedSumArray(new int[]{1, 2, 2, 1, 2, 3, 1}, new int[][]{new int[]{1, 2}, new int[]{3, 3}, new int[]{4, 2}});
        System.out.println();
    }

    private void print(PriorityQueue<Node> queue) {
        while (queue.isEmpty() == false) {
            System.out.println(queue.poll().index);
        }
    }

}
