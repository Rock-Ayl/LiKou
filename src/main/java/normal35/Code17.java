package normal35;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2024-09-30
 * 2593. 标记所有元素后数组的分数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个数组 nums ，它包含若干正整数。
 * <p>
 * 一开始分数 score = 0 ，请你按照下面算法求出最后分数：
 * <p>
 * 从数组中选择最小且没有被标记的整数。如果有相等元素，选择下标最小的一个。
 * 将选中的整数加到 score 中。
 * 标记 被选中元素，如果有相邻元素，则同时标记 与它相邻的两个元素 。
 * 重复此过程直到数组中所有元素都被标记。
 * 请你返回执行上述算法后最后的分数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,3,4,5,2]
 * 输出：7
 * 解释：我们按照如下步骤标记元素：
 * - 1 是最小未标记元素，所以标记它和相邻两个元素：[2,1,3,4,5,2] 。
 * - 2 是最小未标记元素，所以标记它和左边相邻元素：[2,1,3,4,5,2] 。
 * - 4 是仅剩唯一未标记的元素，所以我们标记它：[2,1,3,4,5,2] 。
 * 总得分为 1 + 2 + 4 = 7 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,5,1,3,2]
 * 输出：5
 * 解释：我们按照如下步骤标记元素：
 * - 1 是最小未标记元素，所以标记它和相邻两个元素：[2,3,5,1,3,2] 。
 * - 2 是最小未标记元素，由于有两个 2 ，我们选择最左边的一个 2 ，也就是下标为 0 处的 2 ，以及它右边相邻的元素：[2,3,5,1,3,2] 。
 * - 2 是仅剩唯一未标记的元素，所以我们标记它：[2,3,5,1,3,2] 。
 * 总得分为 1 + 2 + 2 = 5 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 */
public class Code17 {

    //节点
    private static class Node {

        //索引
        private int index;

        //数字
        private int num;

        //是否标记,默认否
        private boolean tag = false;

        public Node(int index, int num) {
            this.index = index;
            this.num = num;
        }

        //对比
        public int compareTo(Node another) {
            //如果数字不同
            if (this.num != another.num) {
                //对比数字
                return this.num - another.num;
            }
            //默认按照索引
            return this.index - another.index;
        }

    }

    public long findScore(int[] nums) {
        //优先队列缓存
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Node::compareTo);
        //索引缓存
        Map<Integer, Node> indexMap = new HashMap<>();
        //循环
        for (int i = 0; i < nums.length; i++) {
            //初始化节点
            Node node = new Node(i, nums[i]);
            //记录缓存
            priorityQueue.add(node);
            indexMap.put(i, node);
        }
        //结果
        long sum = 0L;
        //如果还有
        while (priorityQueue.isEmpty() == false) {
            //获取第一个节点
            Node first = priorityQueue.poll();
            //如果已经标记了 and 还有节点
            while (first.tag == true && priorityQueue.isEmpty() == false) {
                //重新获取节点
                first = priorityQueue.poll();
            }
            //如果没有了未标记节点
            if (first.tag == true) {
                //跳出
                break;
            }
            //叠加本次和
            sum += first.num;
            //获取该节点左右节点
            Node left = indexMap.get(first.index - 1);
            Node right = indexMap.get(first.index + 1);
            //如果存在左边节点
            if (left != null) {
                //强行标记
                left.tag = true;
            }
            //如果存在右边节点
            if (right != null) {
                //强行标记
                right.tag = true;
            }
        }
        //返回最终
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().findScore(new int[]{2, 1, 3, 4, 5, 2}));
    }

    private void print(PriorityQueue<Node> priorityQueue) {
        while (priorityQueue.isEmpty() == false) {
            System.out.println(priorityQueue.poll());
        }
    }

}
