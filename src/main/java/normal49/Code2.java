package normal49;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2025-12-24
 * 3092. 最高频率的 ID
 * 算术评级: 5
 * 第 390 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1793
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 你需要在一个集合里动态记录 ID 的出现频率。给你两个长度都为 n 的整数数组 nums 和 freq ，nums 中每一个元素表示一个 ID ，对应的 freq 中的元素表示这个 ID 在集合中此次操作后需要增加或者减少的数目。
 * <p>
 * 增加 ID 的数目：如果 freq[i] 是正数，那么 freq[i] 个 ID 为 nums[i] 的元素在第 i 步操作后会添加到集合中。
 * 减少 ID 的数目：如果 freq[i] 是负数，那么 -freq[i] 个 ID 为 nums[i] 的元素在第 i 步操作后会从集合中删除。
 * 请你返回一个长度为 n 的数组 ans ，其中 ans[i] 表示第 i 步操作后出现频率最高的 ID 数目 ，如果在某次操作后集合为空，那么 ans[i] 为 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,2,1], freq = [3,2,-3,1]
 * <p>
 * 输出：[3,3,2,2]
 * <p>
 * 解释：
 * <p>
 * 第 0 步操作后，有 3 个 ID 为 2 的元素，所以 ans[0] = 3 。
 * 第 1 步操作后，有 3 个 ID 为 2 的元素和 2 个 ID 为 3 的元素，所以 ans[1] = 3 。
 * 第 2 步操作后，有 2 个 ID 为 3 的元素，所以 ans[2] = 2 。
 * 第 3 步操作后，有 2 个 ID 为 3 的元素和 1 个 ID 为 1 的元素，所以 ans[3] = 2 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [5,5,3], freq = [2,-2,1]
 * <p>
 * 输出：[2,0,1]
 * <p>
 * 解释：
 * <p>
 * 第 0 步操作后，有 2 个 ID 为 5 的元素，所以 ans[0] = 2 。
 * 第 1 步操作后，集合中没有任何元素，所以 ans[1] = 0 。
 * 第 2 步操作后，有 1 个 ID 为 3 的元素，所以 ans[2] = 1 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length == freq.length <= 105
 * 1 <= nums[i] <= 105
 * -105 <= freq[i] <= 105
 * freq[i] != 0
 * 输入保证任何操作后，集合中的元素出现次数不会为负数。
 */
public class Code2 {

    private static class Node {

        //id
        private int id;

        //数量
        private Long count;

        //是否在使用中
        private boolean using = true;

        //初始化
        public Node(int id, Long count) {
            this.id = id;
            this.count = count;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("id=%s,count=%s,using=%s", this.id, this.count, this.using);
        }

    }

    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        //长度
        int length = nums.length;
        //初始化结果
        long[] result = new long[length];
        //队列
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> b.count.compareTo(a.count));
        //缓存
        Map<Integer, Node> nodeMap = new HashMap<>();
        //循环
        for (int i = 0; i < length; i++) {

            /**
             * 加入本次节点
             */

            //获取id、数量
            int id = nums[i];
            long count = freq[i];
            //初始化当前节点
            Node node = new Node(id, count);
            //获取之前的节点
            Node last = nodeMap.get(id);
            //如果存在之前的节点
            if (last != null) {
                //叠加,最小为0
                node.count = Math.max(node.count + last.count, 0);
                //旧节点标记为不再使用
                last.using = false;
            }
            //覆盖新节点
            nodeMap.put(id, node);
            //组装到队列
            queue.add(node);

            /**
             * 获取当前最大
             */

            //如果最大的没有在用
            while (queue.peek().using == false) {
                //删除
                queue.poll();
            }
            //记录本次结果
            result[i] = queue.peek().count;

        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        long[] longs = new Code2().mostFrequentIDs(new int[]{2, 3, 2, 1}, new int[]{3, 2, -3, 1});
        System.out.println();
    }

}
