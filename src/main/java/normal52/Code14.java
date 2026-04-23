package normal52;

import java.util.PriorityQueue;

/**
 * 1696. 跳跃游戏 VI
 * 尝试过
 * 算术评级: 7
 * 第 220 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1954
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * <p>
 * 一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, i + k)] 包含 两个端点的任意位置。
 * <p>
 * 你的目标是到达数组最后一个位置（下标为 n - 1 ），你的 得分 为经过的所有数字之和。
 * <p>
 * 请你返回你能得到的 最大得分 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,-1,-2,4,-7,3], k = 2
 * 输出：7
 * 解释：你可以选择子序列 [1,-1,4,3] （上面加粗的数字），和为 7 。
 * 示例 2：
 * <p>
 * 输入：nums = [10,-5,-2,4,0,3], k = 3
 * 输出：17
 * 解释：你可以选择子序列 [10,4,3] （上面加粗数字），和为 17 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length, k <= 105
 * -104 <= nums[i] <= 104
 *
 */
public class Code14 {

    private static class Node {

        //索引
        private int index;

        //分数
        private int rank;

        //初始化
        public Node(int index, int rank) {
            this.index = index;
            this.rank = rank;
        }

    }

    public int maxResult(int[] nums, int k) {
        //优先队列
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> b.rank - a.rank);
        //初始化第一个节点(作为最后一个节点)(从0出发)
        Node lastNode = new Node(0, nums[0]);
        //加入队列
        queue.add(lastNode);
        //循环
        for (int i = 1; i < nums.length; i++) {
            //如果最大分数的节点,不可以被使用
            while (queue.peek().index + k < i) {
                //删除之
                queue.poll();
            }
            //本次与前者最大值组合的分数,初始化节点
            Node node = new Node(i, queue.peek().rank + nums[i]);
            //加入队列
            queue.add(node);
            //记录最后一个节点
            lastNode = node;
        }
        //返回
        return lastNode.rank;
    }

    public static void main(String[] args) {
        Code14 code14 = new Code14();
        int[] nums = {1, -1, -2, 4, -7, 3};
        int k = 2;
        int maxResult = code14.maxResult(nums, k);
        System.out.println(maxResult);
    }

}
