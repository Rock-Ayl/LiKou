package normal49;

import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2025-12-27
 * 2874. 有序三元组中的最大值 II
 * 算术评级: 4
 * 第 365 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1583
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 。
 * <p>
 * 请你从所有满足 i < j < k 的下标三元组 (i, j, k) 中，找出并返回下标三元组的最大值。如果所有满足条件的三元组的值都是负数，则返回 0 。
 * <p>
 * 下标三元组 (i, j, k) 的值等于 (nums[i] - nums[j]) * nums[k] 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [12,6,1,2,7]
 * 输出：77
 * 解释：下标三元组 (0, 2, 4) 的值是 (nums[0] - nums[2]) * nums[4] = 77 。
 * 可以证明不存在值大于 77 的有序下标三元组。
 * 示例 2：
 * <p>
 * 输入：nums = [1,10,3,4,19]
 * 输出：133
 * 解释：下标三元组 (1, 2, 4) 的值是 (nums[1] - nums[2]) * nums[4] = 133 。
 * 可以证明不存在值大于 133 的有序下标三元组。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：0
 * 解释：唯一的下标三元组 (0, 1, 2) 的值是一个负数，(nums[0] - nums[1]) * nums[2] = -3 。因此，答案是 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 */
public class Code5 {

    private static class Node {

        //数字
        private int num;

        //是否允许使用
        private boolean using = true;

        //初始化
        public Node(int num) {
            this.num = num;
        }

        //调试
        @Override
        public String toString() {
            return String.format("num=%s,using=%s", this.num, this.using);
        }

    }

    public long maximumTripletValue(int[] nums) {
        //右边最大优先队列
        PriorityQueue<Node> rightQueue = new PriorityQueue<>((a, b) -> b.num - a.num);
        //节点缓存
        Node[] nodeArr = new Node[nums.length];
        //循环
        for (int i = 1; i < nodeArr.length; i++) {
            //初始化节点,加入队列
            rightQueue.add(nodeArr[i] = new Node(nums[i]));
        }
        //左边最大结果
        long maxLeft = nums[0];
        //最大结果
        long result = 0L;
        //索引
        int index = 1;
        //循环
        while (index < nodeArr.length - 1) {
            //其无法使用
            nodeArr[index].using = false;
            //如果没有在使用
            while (rightQueue.peek().using == false) {
                //删除
                rightQueue.poll();
            }
            //计算本次
            long count = (maxLeft - nums[index]) * rightQueue.peek().num;
            //刷新最大
            result = Math.max(count, result);
            //刷新左边最大、下一个
            maxLeft = Math.max(maxLeft, nums[index++]);
        }
        //返回最大结果
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().maximumTripletValue(new int[]{6, 11, 12, 12, 7, 9, 2, 11, 12, 4, 19, 14, 16, 8, 16}));
    }

}
