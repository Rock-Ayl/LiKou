package normal54;

import java.util.PriorityQueue;

/**
 * 1673. 找出最具竞争力的子序列
 * 算术评级: 6
 * 第 217 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1802
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。
 * <p>
 * 数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。
 * <p>
 * 在子序列 a 和子序列 b 第一个不相同的位置上，如果 a 中的数字小于 b 中对应的数字，那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力 。 例如，[1,3,4] 比 [1,3,5] 更具竞争力，在第一个不相同的位置，也就是最后一个位置上， 4 小于 5 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,5,2,6], k = 2
 * 输出：[2,6]
 * 解释：在所有可能的子序列集合 {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} 中，[2,6] 最具竞争力。
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,3,3,5,4,9,6], k = 4
 * 输出：[2,3,3,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 1 <= k <= nums.length
 */
public class Code7 {

    private static class Node {

        //索引
        private int index;

        //数字
        private int num;

        //初始化
        public Node(int index, int num) {
            this.index = index;
            this.num = num;
        }

        //方便调试
        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", num=" + num +
                    '}';
        }

    }

    public int[] mostCompetitive(int[] nums, int k) {
        //数组
        Node[] nodeArr = new Node[nums.length];
        //循环
        for (int i = 0; i < nums.length; i++) {
            //初始化
            nodeArr[i] = new Node(i, nums[i]);
        }
        //结果
        int[] resultArr = new int[k];
        //结果索引
        int resultIndex = 0;
        //寻找最小数字区间
        int start = 0;
        int end = nums.length - k;
        //优先队列
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((a, b) -> a.num != b.num ? a.num - b.num : a.index - b.index);
        //索引
        int queueIndex = 0;
        //循环
        while (resultIndex < resultArr.length) {
            //如果可以右滑
            while (queueIndex <= end) {
                //入队、+1
                priorityQueue.add(nodeArr[queueIndex++]);
            }
            //如果最小的那个不是最小数字区间的
            while (priorityQueue.peek().index < start) {
                //删除
                priorityQueue.poll();
            }
            //拉取一个最符合的
            Node minNode = priorityQueue.poll();
            //记录本次结果
            resultArr[resultIndex++] = minNode.num;
            //区间更新
            start = minNode.index + 1;
            end++;
        }
        //返回
        return resultArr;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4));
    }

}
