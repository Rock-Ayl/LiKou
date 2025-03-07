package easy38;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2024-10-13
 * 3318. 计算子数组的 x-sum I
 * 简单
 * 相关企业
 * 提示
 * 给你一个由 n 个整数组成的数组 nums，以及两个整数 k 和 x。
 * <p>
 * 数组的 x-sum 计算按照以下步骤进行：
 * <p>
 * 统计数组中所有元素的出现次数。
 * 仅保留出现次数最多的前 x 个元素的每次出现。如果两个元素的出现次数相同，则数值 较大 的元素被认为出现次数更多。
 * 计算结果数组的和。
 * 注意，如果数组中的不同元素少于 x 个，则其 x-sum 是数组的元素总和。
 * <p>
 * 返回一个长度为 n - k + 1 的整数数组 answer，其中 answer[i] 是
 * 子数组
 * nums[i..i + k - 1] 的 x-sum。
 * <p>
 * 子数组 是数组内的一个连续 非空 的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2,2,3,4,2,3], k = 6, x = 2
 * <p>
 * 输出：[6,10,12]
 * <p>
 * 解释：
 * <p>
 * 对于子数组 [1, 1, 2, 2, 3, 4]，只保留元素 1 和 2。因此，answer[0] = 1 + 1 + 2 + 2。
 * 对于子数组 [1, 2, 2, 3, 4, 2]，只保留元素 2 和 4。因此，answer[1] = 2 + 2 + 2 + 4。注意 4 被保留是因为其数值大于出现其他出现次数相同的元素（3 和 1）。
 * 对于子数组 [2, 2, 3, 4, 2, 3]，只保留元素 2 和 3。因此，answer[2] = 2 + 2 + 2 + 3 + 3。
 * 示例 2：
 * <p>
 * 输入：nums = [3,8,7,8,7,5], k = 2, x = 2
 * <p>
 * 输出：[11,15,15,15,12]
 * <p>
 * 解释：
 * <p>
 * 由于 k == x，answer[i] 等于子数组 nums[i..i + k - 1] 的总和。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == nums.length <= 50
 * 1 <= nums[i] <= 50
 * 1 <= x <= k <= nums.length
 */
public class Code18 {

    private static class Node {

        //节点对应数字
        private int number;

        //出现次数,默认0
        private int count = 0;

        //初始化
        public Node(int number) {
            this.number = number;
        }

        //对比
        public int compareTo(Node another) {
            //如果数量不同
            if (this.count != another.count) {
                //对比数量
                return another.count - this.count;
            } else {
                //对比数字
                return another.number - this.number;
            }
        }

        //方便调试
        @Override
        public String toString() {
            return this.number + ",count=" + this.count;
        }

    }

    public int[] findXSum(int[] nums, int k, int x) {
        //初始化结果数组
        int[] result = new int[nums.length - k + 1];
        //循环1
        for (int i = 0; i < result.length; i++) {
            //结束索引
            int end = i + k - 1;
            //缓存
            Map<Integer, Node> nodeMap = new HashMap<>();
            //循环2
            for (int j = i; j <= end; j++) {
                //当前数字
                int num = nums[j];
                //如果不存在
                if (nodeMap.containsKey(num) == false) {
                    //初始化
                    nodeMap.put(num, new Node(num));
                }
                //+1
                nodeMap.get(num).count++;
            }
            //优先队列
            PriorityQueue<Node> queue = new PriorityQueue<>(Node::compareTo);
            //加入队列
            queue.addAll(nodeMap.values());
            //求和
            int sum = 0;
            //使用的节点次数
            int use = 0;
            //循环
            while (++use <= x && queue.isEmpty() == false) {
                //获取优先级最高的
                Node poll = queue.poll();
                //本次和
                sum += poll.count * poll.number;
            }
            //记录本次结果
            result[i] = sum;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[] xSum = new Code18().findXSum(new int[]{9, 2, 2}, 3, 3);
        System.out.println();
    }

}
