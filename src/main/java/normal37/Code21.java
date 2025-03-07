package normal37;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2024-11-25
 * 2233. K 次增加后的最大乘积
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个非负整数数组 nums 和一个整数 k 。每次操作，你可以选择 nums 中 任一 元素并将它 增加 1 。
 * <p>
 * 请你返回 至多 k 次操作后，能得到的 nums的 最大乘积 。由于答案可能很大，请你将答案对 109 + 7 取余后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,4], k = 5
 * 输出：20
 * 解释：将第一个数增加 5 次。
 * 得到 nums = [5, 4] ，乘积为 5 * 4 = 20 。
 * 可以证明 20 是能得到的最大乘积，所以我们返回 20 。
 * 存在其他增加 nums 的方法，也能得到最大乘积。
 * 示例 2：
 * <p>
 * 输入：nums = [6,3,3,2], k = 2
 * 输出：216
 * 解释：将第二个数增加 1 次，将第四个数增加 1 次。
 * 得到 nums = [6, 4, 3, 3] ，乘积为 6 * 4 * 3 * 3 = 216 。
 * 可以证明 216 是能得到的最大乘积，所以我们返回 216 。
 * 存在其他增加 nums 的方法，也能得到最大乘积。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length, k <= 105
 * 0 <= nums[i] <= 106
 */
public class Code21 {

    private static class Node {

        //对应数字
        private int num;

        //对应count,默认0
        private int count = 0;

        //初始化
        public Node(int num) {
            this.num = num;
        }

        //比较
        public int compareTo(Node node) {
            //比较
            return this.num - node.num;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("num=%s,count=%s", num, count);
        }

    }

    public int maximumProduct(int[] nums, int k) {
        //节点缓存
        Map<Integer, Node> nodeMap = new HashMap<>();
        //循环
        for (int num : nums) {
            //如果不存在
            if (nodeMap.containsKey(num) == false) {
                //初始化
                nodeMap.put(num, new Node(num));
            }
            //+1数量
            nodeMap.get(num).count++;
        }
        //优先队列
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Node::compareTo);
        //加入队列
        priorityQueue.addAll(nodeMap.values());
        //循环
        while (k > 0) {
            //获取第一个
            Node poll = priorityQueue.poll();
            //如果下一个和当前相同
            while (priorityQueue.isEmpty() == false && priorityQueue.peek().num == poll.num) {
                //合并
                poll.count += priorityQueue.poll().count;
            }
            //如果本次全都覆盖
            if (poll.count <= k) {
                //统一+1
                poll.num++;
                //清算
                k -= poll.count;
                //存入新节点
                priorityQueue.add(poll);
            } else {
                //初始化新节点
                Node newNode = new Node(poll.num + 1);
                //新节点是k个
                newNode.count = k;
                //老节点清算
                poll.count -= k;
                //新老节点加入队列
                priorityQueue.add(poll);
                priorityQueue.add(newNode);
                //结束
                k = 0;
            }
        }
        //结果
        int result = 1;
        //循环
        for (Node node : priorityQueue) {
            //循环
            for (int i = 0; i < node.count; i++) {
                //乘法
                result = (int) ((long) result * (long) node.num % 1000000007L);
            }
        }
        //结果
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code21().maximumProduct(new int[]{24, 5, 64, 53, 26, 38}, 54));
    }

}
