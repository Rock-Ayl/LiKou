package normal49;

import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2025-12-31
 * 2462. 雇佣 K 位工人的总代价
 * 算术评级: 5
 * 第 318 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1764
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 costs ，其中 costs[i] 是雇佣第 i 位工人的代价。
 * <p>
 * 同时给你两个整数 k 和 candidates 。我们想根据以下规则恰好雇佣 k 位工人：
 * <p>
 * 总共进行 k 轮雇佣，且每一轮恰好雇佣一位工人。
 * 在每一轮雇佣中，从最前面 candidates 和最后面 candidates 人中选出代价最小的一位工人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
 * 比方说，costs = [3,2,7,7,1,2] 且 candidates = 2 ，第一轮雇佣中，我们选择第 4 位工人，因为他的代价最小 [3,2,7,7,1,2] 。
 * 第二轮雇佣，我们选择第 1 位工人，因为他们的代价与第 4 位工人一样都是最小代价，而且下标更小，[3,2,7,7,2] 。注意每一轮雇佣后，剩余工人的下标可能会发生变化。
 * 如果剩余员工数目不足 candidates 人，那么下一轮雇佣他们中代价最小的一人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
 * 一位工人只能被选择一次。
 * 返回雇佣恰好 k 位工人的总代价。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4
 * 输出：11
 * 解释：我们总共雇佣 3 位工人。总代价一开始为 0 。
 * - 第一轮雇佣，我们从 [17,12,10,2,7,2,11,20,8] 中选择。最小代价是 2 ，有两位工人，我们选择下标更小的一位工人，即第 3 位工人。总代价是 0 + 2 = 2 。
 * - 第二轮雇佣，我们从 [17,12,10,7,2,11,20,8] 中选择。最小代价是 2 ，下标为 4 ，总代价是 2 + 2 = 4 。
 * - 第三轮雇佣，我们从 [17,12,10,7,11,20,8] 中选择，最小代价是 7 ，下标为 3 ，总代价是 4 + 7 = 11 。注意下标为 3 的工人同时在最前面和最后面 4 位工人中。
 * 总雇佣代价是 11 。
 * 示例 2：
 * <p>
 * 输入：costs = [1,2,4,1], k = 3, candidates = 3
 * 输出：4
 * 解释：我们总共雇佣 3 位工人。总代价一开始为 0 。
 * - 第一轮雇佣，我们从 [1,2,4,1] 中选择。最小代价为 1 ，有两位工人，我们选择下标更小的一位工人，即第 0 位工人，总代价是 0 + 1 = 1 。注意，下标为 1 和 2 的工人同时在最前面和最后面 3 位工人中。
 * - 第二轮雇佣，我们从 [2,4,1] 中选择。最小代价为 1 ，下标为 2 ，总代价是 1 + 1 = 2 。
 * - 第三轮雇佣，少于 3 位工人，我们从剩余工人 [2,4] 中选择。最小代价是 2 ，下标为 0 。总代价为 2 + 2 = 4 。
 * 总雇佣代价是 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= costs.length <= 105
 * 1 <= costs[i] <= 105
 * 1 <= k, candidates <= costs.length
 */
public class Code8 {

    private static class Node {

        //索引
        private Integer index;

        //花费
        private Integer cost;

        //是否使用
        private boolean used = false;

        //初始化
        public Node(Integer index, Integer cost) {
            this.index = index;
            this.cost = cost;
        }

        //排序
        public int compareTo(Node another) {
            //对比
            int costCompare = this.cost.compareTo(another.cost);
            //如果不同
            if (costCompare != 0) {
                //返回
                return costCompare;
            }
            //默认按照索引
            return this.index.compareTo(another.index);
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("index=%s,cost=%s,used=%s", this.index, this.cost, this.used);
        }

    }

    public long totalCost(int[] costs, int k, int candidates) {
        //节点缓存
        Node[] nodeArr = new Node[costs.length];
        //循环
        for (int i = 0; i < costs.length; i++) {
            //初始化
            nodeArr[i] = new Node(i, costs[i]);
        }
        //左右队列
        PriorityQueue<Node> leftQueue = new PriorityQueue<>(Node::compareTo);
        PriorityQueue<Node> rightQueue = new PriorityQueue<>(Node::compareTo);
        //总最小花费
        long result = 0L;
        //左右索引
        int left = 0;
        int right = costs.length - 1;
        //循环
        while (k > 0) {
            //如果不满
            while (leftQueue.size() < candidates && left < costs.length) {
                //加入节点
                leftQueue.add(nodeArr[left++]);
            }
            //如果不满
            while (rightQueue.size() < candidates && right >= 0) {
                //加入节点
                rightQueue.add(nodeArr[right--]);
            }
            //目标节点
            Node target;
            //获取左右节点
            Node leftNode = leftQueue.peek();
            Node rightNode = rightQueue.peek();
            //判断使用那边
            if (rightNode.cost < leftNode.cost) {
                //拉取并叠加
                target = rightQueue.poll();
            } else {
                //拉取并叠加
                target = leftQueue.poll();
            }
            //如果已使用
            if (target.used == true) {
                //本轮过
                continue;
            }
            //叠加本次
            result += target.cost;
            //-1
            k--;
            //标记使用
            target.used = true;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().totalCost(
                new int[]{
                        31, 25, 72, 79, 74, 65, 84, 91, 18, 59, 27, 9, 81, 33, 17, 58
                }, 11, 2));
    }

}
