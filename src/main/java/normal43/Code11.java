package normal43;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-05-27
 * 3551. 数位和排序需要的最小交换次数
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个由 互不相同 的正整数组成的数组 nums，需要根据每个数字的数位和（即每一位数字相加求和）按 升序 对数组进行排序。如果两个数字的数位和相等，则较小的数字排在前面。
 * <p>
 * 返回将 nums 排列为上述排序顺序所需的 最小 交换次数。
 * <p>
 * 一次 交换 定义为交换数组中两个不同位置的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: nums = [37,100]
 * <p>
 * 输出: 1
 * <p>
 * 解释:
 * <p>
 * 计算每个整数的数位和：[3 + 7 = 10, 1 + 0 + 0 = 1] → [10, 1]
 * 根据数位和排序：[100, 37]。将 37 与 100 交换，得到排序后的数组。
 * 因此，将 nums 排列为排序顺序所需的最小交换次数为 1。
 * 示例 2：
 * <p>
 * 输入: nums = [22,14,33,7]
 * <p>
 * 输出: 0
 * <p>
 * 解释:
 * <p>
 * 计算每个整数的数位和：[2 + 2 = 4, 1 + 4 = 5, 3 + 3 = 6, 7 = 7] → [4, 5, 6, 7]
 * 根据数位和排序：[22, 14, 33, 7]。数组已经是排序好的。
 * 因此，将 nums 排列为排序顺序所需的最小交换次数为 0。
 * 示例 3：
 * <p>
 * 输入: nums = [18,43,34,16]
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * <p>
 * 计算每个整数的数位和：[1 + 8 = 9, 4 + 3 = 7, 3 + 4 = 7, 1 + 6 = 7] → [9, 7, 7, 7]
 * 根据数位和排序：[16, 34, 43, 18]。将 18 与 16 交换，再将 43 与 34 交换，得到排序后的数组。
 * 因此，将 nums 排列为排序顺序所需的最小交换次数为 2。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * nums 由 互不相同 的正整数组成。
 */
public class Code11 {

    //数字节点实体
    private static class Node {

        //真实数字
        private int num;

        //数位、排序分数,默认0
        private int rank = 0;

        //源索引(当前位置)
        private int index;

        //目标索引
        private int targetIndex = -1;

        //初始化
        public Node(int num, int index) {
            this.num = num;
            this.index = index;
            //循环
            while (num > 9) {
                //叠加
                this.rank += num % 10;
                //下一个
                num = num / 10;
            }
            //个位数收尾
            this.rank += num;
        }

        //自定义排序
        public int compareTo(Node node) {
            //如果分数不同
            if (this.rank != node.rank) {
                //按照分数排序
                return this.rank - node.rank;
            }
            //默认按照数字本身
            return this.num - node.num;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("num=%s,rank=%s,index=%s,targetIndex=%s", this.num, this.rank, this.index, this.targetIndex);
        }

    }

    public int minSwaps(int[] nums) {

        /**
         * 构造节点
         */

        //源排序数组
        Node[] sourceNodeArr = new Node[nums.length];
        //循环
        for (int i = 0; i < nums.length; i++) {
            //初始化节点、组装
            sourceNodeArr[i] = new Node(nums[i], i);
        }

        /**
         * 排序,计算新位置
         */

        //目标排序数组
        Node[] targetNodeArr = sourceNodeArr.clone();
        //排序
        Arrays.sort(targetNodeArr, Node::compareTo);
        //循环
        for (int i = 0; i < nums.length; i++) {
            //记录目标位置
            targetNodeArr[i].targetIndex = i;
        }

        /**
         * 计算最终结果
         */

        //交换次数
        int count = 0;
        //循环
        for (int i = 0; i < targetNodeArr.length; i++) {
            //当前节点
            Node node = targetNodeArr[i];
            //如果不需要排序
            if (node.index == node.targetIndex) {
                //本轮过
                continue;
            }
            //交换两个节点
            change(sourceNodeArr, node.index, node.targetIndex);
            //操作+1
            count++;
        }
        //返回
        return count;
    }

    //交换节点
    private void change(Node[] nodeArr, int left, int right) {

        /**
         * 数组内节点交换
         */

        //获取两个节点
        Node leftNode = nodeArr[left];
        Node rightNode = nodeArr[right];
        //交换节点
        nodeArr[left] = rightNode;
        nodeArr[right] = leftNode;

        /**
         * 对象内索引交换
         */

        //获取两个索引
        int leftIndex = leftNode.index;
        int rightIndex = rightNode.index;
        //交换索引
        leftNode.index = rightIndex;
        rightNode.index = leftIndex;

    }

    public static void main(String[] args) {
        System.out.println(new Code11().minSwaps(new int[]{18, 43, 34, 16}));
    }

}
