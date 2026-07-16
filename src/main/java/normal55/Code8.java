package normal55;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1477. 找两个和为目标值且不重叠的子数组
 * 算术评级: 6
 * 第 28 场双周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1851
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 arr 和一个整数值 target 。
 * <p>
 * 请你在 arr 中找 两个互不重叠的子数组 且它们的和都等于 target 。可能会有多种方案，请你返回满足要求的两个子数组长度和的 最小值 。
 * <p>
 * 请返回满足要求的最小长度和，如果无法找到这样的两个子数组，请返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,2,4,3], target = 3
 * 输出：2
 * 解释：只有两个子数组和为 3 （[3] 和 [3]）。它们的长度和为 2 。
 * 示例 2：
 * <p>
 * 输入：arr = [7,3,4,7], target = 7
 * 输出：2
 * 解释：尽管我们有 3 个互不重叠的子数组和为 7 （[7], [3,4] 和 [7]），但我们会选择第一个和第三个子数组，因为它们的长度和 2 是最小值。
 * 示例 3：
 * <p>
 * 输入：arr = [4,3,2,6,2,3,4], target = 6
 * 输出：-1
 * 解释：我们只有一个和为 6 的子数组。
 * 示例 4：
 * <p>
 * 输入：arr = [5,5,4,4,5], target = 3
 * 输出：-1
 * 解释：我们无法找到和为 3 的子数组。
 * 示例 5：
 * <p>
 * 输入：arr = [3,1,1,1,5,1,2,1], target = 3
 * 输出：3
 * 解释：注意子数组 [1,2] 和 [2,1] 不能成为一个方案因为它们重叠了。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 1000
 * 1 <= target <= 10^8
 */
public class Code8 {

    private static class Node {

        //开始
        private int start;

        //结束
        private int end;

        //长度
        private int length;

        //初始化
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
            //长度
            this.length = end - start + 1;
        }

        //方便调试
        @Override
        public String toString() {
            return "Node{" +
                    "start=" + start +
                    ", end=" + end +
                    ", length=" + length +
                    '}';
        }

    }

    public int minSumOfLengths(int[] arr, int target) {

        /**
         * 前缀和
         */

        //索引缓存
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        //和
        int sum = arr[0];
        //记录索引
        sumIndexMap.put(sum, 0);
        //循环
        for (int i = 1; i < arr.length; i++) {
            //叠加本次
            sum += arr[i];
            //记录索引
            sumIndexMap.put(sum, i);
        }

        /**
         * 统计出所有 和 的可能
         */

        //和
        int sum2 = 0;
        //初始化节点列表
        List<Node> nodeList = new ArrayList<>();
        //循环
        for (int i = 0; i < arr.length; i++) {
            //当前和
            sum2 += arr[i];
            //如果相同
            if (sum2 == target) {
                //记录
                nodeList.add(new Node(0, i));
                //本轮过
                continue;
            }
            //目标开始和
            int start = sum2 - target;
            //如果不存在
            if (sumIndexMap.containsKey(start) == false) {
                //本轮过
                continue;
            }
            //记录
            nodeList.add(new Node(sumIndexMap.get(start) + 1, i));
        }
        //如果不够
        if (nodeList.size() < 2) {
            //过
            return -1;
        }

        /**
         * 构建 每个位置对应的最小长度
         */

        //最小长度数组
        int[] nodeMinLengthArr = new int[nodeList.size()];
        //默认最后一个长度
        nodeMinLengthArr[nodeMinLengthArr.length - 1] = nodeList.get(nodeList.size() - 1).length;
        //循环
        for (int i = nodeMinLengthArr.length - 2; i >= 0; i--) {
            //当前最小长度
            nodeMinLengthArr[i] = Math.min(nodeList.get(i).length, nodeMinLengthArr[i + 1]);
        }

        /**
         * 结果
         */

        //最小长度
        int minLength = Integer.MAX_VALUE;
        //双指针
        int leftIndex = 0;
        int rightIndex = 1;
        //循环
        while (leftIndex < nodeList.size()) {
            //获取左节点
            Node leftNode = nodeList.get(leftIndex++);
            //如果有节点存在 and 和左节点重合
            while (rightIndex < nodeList.size() && nodeList.get(rightIndex).start <= leftNode.end) {
                //下一个
                rightIndex++;
            }
            //如果越界
            if (rightIndex >= nodeList.size()) {
                //跳出
                break;
            }
            //当前长度
            int length = leftNode.length + nodeMinLengthArr[rightIndex];
            //刷新最小
            minLength = Math.min(minLength, length);
        }
        //返回
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().minSumOfLengths(new int[]{3, 1, 1, 1, 5, 1, 2, 1}, 3));
    }

}
