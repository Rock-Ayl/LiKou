package normal41;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2025-04-14
 * 2555. 两个线段获得的最多奖品
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 在 X轴 上有一些奖品。给你一个整数数组 prizePositions ，它按照 非递减 顺序排列，其中 prizePositions[i] 是第 i 件奖品的位置。数轴上一个位置可能会有多件奖品。再给你一个整数 k 。
 * <p>
 * 你可以同时选择两个端点为整数的线段。每个线段的长度都必须是 k 。你可以获得位置在任一线段上的所有奖品（包括线段的两个端点）。注意，两个线段可能会有相交。
 * <p>
 * 比方说 k = 2 ，你可以选择线段 [1, 3] 和 [2, 4] ，你可以获得满足 1 <= prizePositions[i] <= 3 或者 2 <= prizePositions[i] <= 4 的所有奖品 i 。
 * 请你返回在选择两个最优线段的前提下，可以获得的 最多 奖品数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：prizePositions = [1,1,2,2,3,3,5], k = 2
 * 输出：7
 * 解释：这个例子中，你可以选择线段 [1, 3] 和 [3, 5] ，获得 7 个奖品。
 * 示例 2：
 * <p>
 * 输入：prizePositions = [1,2,3,4], k = 0
 * 输出：2
 * 解释：这个例子中，一个选择是选择线段 [3, 3] 和 [4, 4] ，获得 2 个奖品。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= prizePositions.length <= 105
 * 1 <= prizePositions[i] <= 109
 * 0 <= k <= 109
 * prizePositions 有序非递减。
 */
public class Code22 {

    //节点
    private static class Node {

        //数字
        private int number;

        //数量
        private int count = 1;

        //从该节点开始,获得的奖品数量
        private int giftSum = 0;

        //是否可以使用,默认可以
        private boolean can = true;

        //初始化
        public Node(int number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return String.format("number=%s,count=%s", this.number, this.count);
        }

    }

    public int maximizeWin(int[] prizePositions, int k) {

        /**
         * 构建节点列表
         */

        //初始化节点列表
        List<Node> nodeList = new ArrayList<>();
        //初始化第一个节点
        nodeList.add(new Node(prizePositions[0]));
        //循环
        for (int i = 1; i < prizePositions.length; i++) {
            //上一个节点
            Node lastNode = nodeList.get(nodeList.size() - 1);
            //如果相同
            if (prizePositions[i] == lastNode.number) {
                //+1
                lastNode.count++;
            } else {
                //初始化
                nodeList.add(new Node(prizePositions[i]));
            }
        }

        /**
         * 构建 从每个节点开始,可以获得多少奖品,并记录优先队列
         */

        //优先队列,按照礼物数量排序
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((a, b) -> b.giftSum - a.giftSum);
        //隔离作用域
        if (true) {
            //双指针
            int left = 0;
            int right = 0;
            //奖品和
            int sum = 0;
            //循环
            while (left < nodeList.size()) {
                //如果有左边删除的
                if (left > 0) {
                    //删除已经过去的奖品
                    sum -= nodeList.get(left - 1).count;
                }
                //开始位置
                int start = nodeList.get(left).number;
                //计算出结束位置
                int end = start + k;
                //如果够得到
                while (right < nodeList.size() && nodeList.get(right).number <= end) {
                    //获得该奖品
                    sum += nodeList.get(right++).count;
                }
                //获取节点、并+1
                Node node = nodeList.get(left++);
                //记录其可以获得的奖品数量
                node.giftSum = sum;
                //记录到队列
                priorityQueue.add(node);
            }
        }

        /**
         * 按照规则,推算2个线段情况下的最大情况
         */

        //最大结果
        int maxSum = 0;
        //双指针
        int left = 0;
        int right = 0;
        //循环
        while (left < nodeList.size()) {
            //开始位置
            int start = nodeList.get(left).number;
            //计算出结束位置
            int end = start + k;
            //如果够得到
            while (right < nodeList.size() && nodeList.get(right).number <= end) {
                //由于被覆盖,不会被使用,标记懒删除
                nodeList.get(right++).can = false;
            }
            //如果已经被标记无法使用了
            while (priorityQueue.isEmpty() == false && priorityQueue.peek().can == false) {
                //删除之
                priorityQueue.poll();
            }
            //本次最大结果
            int sum = nodeList.get(left++).giftSum + (priorityQueue.isEmpty() ? 0 : priorityQueue.peek().giftSum);
            //刷新
            maxSum = Math.max(maxSum, sum);
        }
        //返回最大结果
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new Code22().maximizeWin(new int[]{1, 1, 2, 2, 3, 3, 5}, 2));
    }

}
