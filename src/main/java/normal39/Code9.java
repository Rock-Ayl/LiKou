package normal39;

import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2025-01-19
 * 1438. 绝对差不超过限制的最长连续子数组
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * <p>
 * 如果不存在满足条件的子数组，则返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [10,1,2,4,7,2], limit = 5
 * 输出：4
 * 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
 * 示例 3：
 * <p>
 * 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 0 <= limit <= 10^9
 */
public class Code9 {

    private static class Node {

        //数字
        private int num;

        //索引
        private int index;

        //初始化
        public Node(int num, int index) {
            this.num = num;
            this.index = index;
        }

        //比较最大
        public int compareToMax(Node another) {
            //如果数字不同
            if (this.num != another.num) {
                //按照数字
                return another.num - this.num;
            }
            //默认按照索引
            return this.index - another.index;
        }

        //比较最小
        public int compareToMin(Node another) {
            //如果数字不同
            if (this.num != another.num) {
                //按照数字
                return this.num - another.num;
            }
            //默认按照索引
            return this.index - another.index;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("num=%s,index=%s", this.num, this.index);
        }

    }

    public int longestSubarray(int[] nums, int limit) {
        //最大结果
        int max = 0;
        //双指针
        int start = 0;
        int end = 0;
        //最大最小挤压队列
        PriorityQueue<Node> minQueue = new PriorityQueue<>(Node::compareToMin);
        PriorityQueue<Node> maxQueue = new PriorityQueue<>(Node::compareToMax);
        //循环
        while (end < nums.length) {
            //初始化当前节点
            Node node = new Node(nums[end], end++);
            //分别加入
            minQueue.add(node);
            maxQueue.add(node);
            //循环删除过期数据
            while (removeExpire(start, minQueue, maxQueue)) {
                //如果满足结果条件
                if (maxQueue.peek().num - minQueue.peek().num <= limit) {
                    //跳出本次
                    break;
                }
                //收缩
                start++;
            }
            //计算本次
            int length = end - start;
            //刷新本次结果
            max = Math.max(max, length);
        }
        //返回结果
        return max;
    }

    //删除过期数据
    private boolean removeExpire(int start, PriorityQueue<Node> minQueue, PriorityQueue<Node> maxQueue) {
        //如果最小的数据过期了
        while (minQueue.peek().index < start) {
            //惰性删除
            minQueue.poll();
        }
        //如果最大的数据过期了
        while (maxQueue.peek().index < start) {
            //惰性删除
            maxQueue.poll();
        }
        //返回
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().longestSubarray(new int[]{8, 2, 4, 7}, 4));
    }

    //打印
    private static void print(PriorityQueue<Node> queue) {
        //循环
        while (queue.isEmpty() == false) {
            //拉取并输出
            System.out.println(queue.poll());
        }
    }

}
