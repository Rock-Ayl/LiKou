package normal39;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2025-02-03
 * 1962. 移除石子使总数最小
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 piles ，数组 下标从 0 开始 ，其中 piles[i] 表示第 i 堆石子中的石子数量。另给你一个整数 k ，请你执行下述操作 恰好 k 次：
 * <p>
 * 选出任一石子堆 piles[i] ，并从中 移除 floor(piles[i] / 2) 颗石子。
 * 注意：你可以对 同一堆 石子多次执行此操作。
 * <p>
 * 返回执行 k 次操作后，剩下石子的 最小 总数。
 * <p>
 * floor(x) 为 小于 或 等于 x 的 最大 整数。（即，对 x 向下取整）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：piles = [5,4,9], k = 2
 * 输出：12
 * 解释：可能的执行情景如下：
 * - 对第 2 堆石子执行移除操作，石子分布情况变成 [5,4,5] 。
 * - 对第 0 堆石子执行移除操作，石子分布情况变成 [3,4,5] 。
 * 剩下石子的总数为 12 。
 * 示例 2：
 * <p>
 * 输入：piles = [4,3,6,7], k = 3
 * 输出：12
 * 解释：可能的执行情景如下：
 * - 对第 2 堆石子执行移除操作，石子分布情况变成 [4,3,3,7] 。
 * - 对第 3 堆石子执行移除操作，石子分布情况变成 [4,3,3,4] 。
 * - 对第 0 堆石子执行移除操作，石子分布情况变成 [2,3,3,4] 。
 * 剩下石子的总数为 12 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= piles.length <= 105
 * 1 <= piles[i] <= 104
 * 1 <= k <= 105
 */
public class Code23 {

    //节点
    private static class Node {

        //一堆石子数量
        private int pile;

        //有多少堆
        private int count;

        //初始化
        public Node(int pile, int count) {
            this.pile = pile;
            this.count = count;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("pile=%s,count=%s", this.pile, this.count);
        }

    }

    public int minStoneSum(int[] piles, int k) {

        /**
         * 构建节点、计算求和
         */

        //和
        int sum = 0;
        //节点缓存
        Map<Integer, Node> nodeMap = new HashMap<>();
        //循环
        for (int pile : piles) {
            //叠加本次
            sum += pile;
            //如果存在
            if (nodeMap.containsKey(pile)) {
                //+1
                nodeMap.get(pile).count++;
            }
            //如果不存在
            else {
                //初始化
                nodeMap.put(pile, new Node(pile, 1));
            }
        }

        /**
         * 构建优先队列
         */

        //优先队列
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> b.pile - a.pile);
        //所有节点加入优先队列
        queue.addAll(nodeMap.values());

        /**
         * 清算结果
         */

        //循环
        while (k > 0) {
            //拉取最大的节点
            Node bigNode = queue.poll();
            //计算本次要移除的堆石头数量
            int willRemove = bigNode.pile / 2;
            //如果没有可移除的了
            if (willRemove == 0) {
                //跳出
                break;
            }
            //移除后key
            int removedKey = bigNode.pile - willRemove;
            //如果本节点被移除能力完全覆盖
            if (bigNode.count <= k) {
                //减去要移除的总数量
                sum -= willRemove * bigNode.count;
                //减去操作次数
                k -= bigNode.count;
                //如果之前存在
                if (nodeMap.containsKey(removedKey)) {
                    //直接叠加即可
                    nodeMap.get(removedKey).count += bigNode.count;
                }
                //如果之前不存在
                else {
                    //初始化新节点
                    Node node = new Node(removedKey, bigNode.count);
                    //加入缓存
                    nodeMap.put(removedKey, node);
                    queue.add(node);
                }
            }
            //如果本节点无法被完全覆盖
            else {
                //减去要移除的总数量
                sum -= willRemove * k;
                //结束循环
                break;
            }
        }
        //返回结果
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code23().minStoneSum(new int[]{1}, 10000));
    }

}
