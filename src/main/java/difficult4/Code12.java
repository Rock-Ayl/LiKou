package difficult4;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-09-28
 * 1340. 跳跃游戏 V
 * 算术评级: 8
 * 第 174 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 1866
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 arr 和一个整数 d 。每一步你可以从下标 i 跳到：
 * <p>
 * i + x ，其中 i + x < arr.length 且 0 < x <= d 。
 * i - x ，其中 i - x >= 0 且 0 < x <= d 。
 * 除此以外，你从下标 i 跳到下标 j 需要满足：arr[i] > arr[j] 且 arr[i] > arr[k] ，其中下标 k 是所有 i 到 j 之间的数字（更正式的，min(i, j) < k < max(i, j)）。
 * <p>
 * 你可以选择数组的任意下标开始跳跃。请你返回你 最多 可以访问多少个下标。
 * <p>
 * 请注意，任何时刻你都不能跳到数组的外面。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：arr = [6,4,14,6,8,13,9,7,10,6,12], d = 2
 * 输出：4
 * 解释：你可以从下标 10 出发，然后如上图依次经过 10 --> 8 --> 6 --> 7 。
 * 注意，如果你从下标 6 开始，你只能跳到下标 7 处。你不能跳到下标 5 处因为 13 > 9 。你也不能跳到下标 4 处，因为下标 5 在下标 4 和 6 之间且 13 > 9 。
 * 类似的，你不能从下标 3 处跳到下标 2 或者下标 1 处。
 * 示例 2：
 * <p>
 * 输入：arr = [3,3,3,3,3], d = 3
 * 输出：1
 * 解释：你可以从任意下标处开始且你永远无法跳到任何其他坐标。
 * 示例 3：
 * <p>
 * 输入：arr = [7,6,5,4,3,2,1], d = 1
 * 输出：7
 * 解释：从下标 0 处开始，你可以按照数值从大到小，访问所有的下标。
 * 示例 4：
 * <p>
 * 输入：arr = [7,1,7,1,7,1], d = 2
 * 输出：2
 * 示例 5：
 * <p>
 * 输入：arr = [66], d = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 10^5
 * 1 <= d <= arr.length
 */
public class Code12 {

    private static class Node {

        //索引
        private int index;

        //数字
        private int number;

        //路径数量
        private int count;

        //初始化
        public Node(int index, int number) {
            this.index = index;
            this.number = number;
            this.count = 1;
        }

        //调试
        @Override
        public String toString() {
            return String.format("index=%s,number=%s,count=%s", this.index, this.number, this.count);
        }

    }

    public int maxJumps(int[] arr, int d) {

        /**
         * 初始化节点
         */

        //数组
        Node[] nodeArr = new Node[arr.length];
        //循环
        for (int i = 0; i < nodeArr.length; i++) {
            //初始化
            nodeArr[i] = new Node(i, arr[i]);
        }

        /**
         * 排序
         */

        //克隆
        Node[] sortArr = nodeArr.clone();
        //排序
        Arrays.sort(sortArr, (a, b) -> b.number - a.number);

        /**
         * 按照排序做动态规划
         */

        //最大结果
        int max = 1;
        //循环
        for (int i = 0; i < sortArr.length; i++) {
            //中心节点
            Node midNode = sortArr[i];
            //路径数量
            int count = midNode.count + 1;
            //循环左边
            for (int left = midNode.index - 1; left >= Math.max(0, midNode.index - d); left--) {
                //获取节点
                Node leftNode = nodeArr[left];
                //如果是阻挡
                if (leftNode.number >= midNode.number) {
                    //跳出
                    break;
                }
                //刷新节点最大结果
                leftNode.count = Math.max(count, leftNode.count);
                //刷新最大结果
                max = Math.max(max, leftNode.count);
            }
            //循环右边
            for (int right = midNode.index + 1; right <= Math.min(nodeArr.length - 1, midNode.index + d); right++) {
                //获取节点
                Node rightNode = nodeArr[right];
                //如果是阻挡
                if (rightNode.number >= midNode.number) {
                    //跳出
                    break;
                }
                //刷新节点最大结果
                rightNode.count = Math.max(count, rightNode.count);
                //刷新最大结果
                max = Math.max(max, rightNode.count);
            }
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().maxJumps(new int[]{6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12}, 2));
    }

}