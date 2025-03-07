package normal39;

import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2025-01-20
 * 2762. 不间断子数组
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 。nums 的一个子数组如果满足以下条件，那么它是 不间断 的：
 * <p>
 * i，i + 1 ，...，j  表示子数组中的下标。对于所有满足 i <= i1, i2 <= j 的下标对，都有 0 <= |nums[i1] - nums[i2]| <= 2 。
 * 请你返回 不间断 子数组的总数目。
 * <p>
 * 子数组是一个数组中一段连续 非空 的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,4,2,4]
 * 输出：8
 * 解释：
 * 大小为 1 的不间断子数组：[5], [4], [2], [4] 。
 * 大小为 2 的不间断子数组：[5,4], [4,2], [2,4] 。
 * 大小为 3 的不间断子数组：[4,2,4] 。
 * 没有大小为 4 的不间断子数组。
 * 不间断子数组的总数目为 4 + 3 + 1 = 8 。
 * 除了这些以外，没有别的不间断子数组。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：6
 * 解释：
 * 大小为 1 的不间断子数组：[1], [2], [3] 。
 * 大小为 2 的不间断子数组：[1,2], [2,3] 。
 * 大小为 3 的不间断子数组：[1,2,3] 。
 * 不间断子数组的总数目为 3 + 2 + 1 = 6 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 */
public class Code10 {

    //区间
    private static final int range = 2;

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

    public long continuousSubarrays(int[] nums) {
        //结果
        long result = 0L;
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
                if (maxQueue.peek().num - minQueue.peek().num <= range) {
                    //跳出本次
                    break;
                }
                //收缩
                start++;
            }
            //计算本次
            result += end - start;
        }
        //返回结果
        return result;
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
        System.out.println(new Code10().continuousSubarrays(new int[]{5, 4, 2, 4}));
    }

}
