package normal40;

import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2025-03-06
 * 2909. 元素和最小的山形三元组 II
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 。
 * <p>
 * 如果下标三元组 (i, j, k) 满足下述全部条件，则认为它是一个 山形三元组 ：
 * <p>
 * i < j < k
 * nums[i] < nums[j] 且 nums[k] < nums[j]
 * 请你找出 nums 中 元素和最小 的山形三元组，并返回其 元素和 。如果不存在满足条件的三元组，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [8,6,1,5,3]
 * 输出：9
 * 解释：三元组 (2, 3, 4) 是一个元素和等于 9 的山形三元组，因为：
 * - 2 < 3 < 4
 * - nums[2] < nums[3] 且 nums[4] < nums[3]
 * 这个三元组的元素和等于 nums[2] + nums[3] + nums[4] = 9 。可以证明不存在元素和小于 9 的山形三元组。
 * 示例 2：
 * <p>
 * 输入：nums = [5,4,8,7,10,2]
 * 输出：13
 * 解释：三元组 (1, 3, 5) 是一个元素和等于 13 的山形三元组，因为：
 * - 1 < 3 < 5
 * - nums[1] < nums[3] 且 nums[5] < nums[3]
 * 这个三元组的元素和等于 nums[1] + nums[3] + nums[5] = 13 。可以证明不存在元素和小于 13 的山形三元组。
 * 示例 3：
 * <p>
 * 输入：nums = [6,5,4,3,4,5]
 * 输出：-1
 * 解释：可以证明 nums 中不存在山形三元组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 105
 * 1 <= nums[i] <= 108
 */
public class Code21 {

    //优先队列节点
    private static class Node {

        //数字
        private int num;

        //是否属于右边,默认是
        private boolean right = true;

        //初始化节点
        public Node(int num) {
            this.num = num;
        }

    }

    public int minimumSum(int[] nums) {
        //优先队列
        PriorityQueue<Node> rightQueue = new PriorityQueue<>((a, b) -> a.num - b.num);
        //节点数组
        Node[] nodeArr = new Node[nums.length];
        //循环
        for (int i = 0; i < nums.length; i++) {
            //构建节点
            Node node = new Node(nums[i]);
            //加入队列
            rightQueue.add(node);
            //记录节点
            nodeArr[i] = node;
        }
        //第一个节点移动到左边
        nodeArr[0].right = false;
        //左边最小结果
        int leftMin = nodeArr[0].num;
        //第二个节点不属于右边
        nodeArr[1].right = false;
        //最小和
        int minSum = Integer.MAX_VALUE;
        //循环
        for (int i = 1; i < nums.length - 1; i++) {
            //当前节点
            Node node = nodeArr[i];
            //左边最小
            int left = leftMin;
            //当前节点移动到左边
            node.right = false;
            //刷新最小左边
            leftMin = Math.min(leftMin, node.num);
            //如果左边更大
            if (left >= node.num) {
                //本轮过
                continue;
            }
            //如果不属于右边了
            while (rightQueue.peek().right == false) {
                //删除之
                rightQueue.poll();
            }
            //右边最小
            int right = rightQueue.peek().num;
            //如果右边更大
            if (right >= node.num) {
                //本轮过
                continue;
            }
            //刷新最小情况
            minSum = Math.min(minSum, left + node.num + right);
        }
        //返回
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }

    public static void main(String[] args) {
        System.out.println(new Code21().minimumSum(new int[]{5, 4, 8, 7, 10, 2}));
    }

}
