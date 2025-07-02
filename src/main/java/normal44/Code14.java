package normal44;

import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2025-07-02
 * 334. 递增的三元子序列
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：任何 i < j < k 的三元组都满足题意
 * 示例 2：
 * <p>
 * 输入：nums = [5,4,3,2,1]
 * 输出：false
 * 解释：不存在满足题意的三元组
 * 示例 3：
 * <p>
 * 输入：nums = [2,1,5,0,4,6]
 * 输出：true
 * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * <p>
 * 进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？
 */
public class Code14 {

    private static class Node {

        //数字
        private int num;

        //是否可以使用,默认是
        private boolean use = true;

        //初始化
        public Node(int num) {
            this.num = num;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("num=%s", this.num);
        }

    }

    public boolean increasingTriplet(int[] nums) {
        //优先队列
        PriorityQueue<Node> rightQueue = new PriorityQueue<>((a, b) -> b.num - a.num);
        //缓存
        Node[] nodeArr = new Node[nums.length];
        //循环
        for (int i = 0; i < nums.length; i++) {
            //初始化节点
            Node node = new Node(nums[i]);
            //记录节点
            nodeArr[i] = node;
            //新加入到队列
            rightQueue.add(node);
        }
        //默认
        int min = nodeArr[0].num;
        nodeArr[0].use = false;
        //循环
        for (int i = 1; i < nums.length - 1; i++) {
            //获取当前节点
            Node node = nodeArr[i];
            //获取当前节点数字
            int num = node.num;
            //该节点本身无法使用了
            node.use = false;
            //如果右边无法使用
            while (rightQueue.peek().use == false) {
                //删除
                rightQueue.poll();
            }
            //如果满足结果
            if (min < num && rightQueue.peek().num > num) {
                //返回
                return true;
            }
            //加入左边
            min = Math.min(min, node.num);
        }
        //默认没有
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code14().increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
    }

}
