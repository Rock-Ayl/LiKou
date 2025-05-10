package normal42;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-05-10
 * 3397. 执行操作后不同元素的最大数量
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k。
 * <p>
 * 你可以对数组中的每个元素 最多 执行 一次 以下操作：
 * <p>
 * 将一个在范围 [-k, k] 内的整数加到该元素上。
 * 返回执行这些操作后，nums 中可能拥有的不同元素的 最大 数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,2,2,3,3,4], k = 2
 * <p>
 * 输出： 6
 * <p>
 * 解释：
 * <p>
 * 对前四个元素执行操作，nums 变为 [-1, 0, 1, 2, 3, 4]，可以获得 6 个不同的元素。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [4,4,4,4], k = 1
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 对 nums[0] 加 -1，以及对 nums[1] 加 1，nums 变为 [3, 5, 4, 4]，可以获得 3 个不同的元素。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 0 <= k <= 109
 */
public class Code21 {

    //节点
    private static class Node {

        //数字
        private int number;

        //数量
        private int count;

        //初始化
        public Node(int number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return String.format("number=%s,count=%s", this.number, this.count);
        }

    }

    public int maxDistinctElements(int[] nums, int k) {

        /**
         * 构建节点
         */

        //缓存
        Map<Integer, Node> nodeMap = new HashMap<>();
        //循环
        for (int num : nums) {
            //初始化
            nodeMap.putIfAbsent(num, new Node(num));
            //+1
            nodeMap.get(num).count++;
        }
        //初始化列表
        List<Node> nodeList = new ArrayList<>(nodeMap.values());
        //排序
        nodeList.sort((a, b) -> a.number - b.number);

        /**
         * 计算结果
         */

        //结果
        int result = 0;
        //已经出现过的,最大的数字
        int max = Integer.MIN_VALUE;
        //循环
        for (Node node : nodeList) {
            //区间
            int start = node.number - k;
            int end = node.number + k;
            //第一个数字
            int first = Math.max(max + 1, start);
            //最后一个数字
            int last = Math.min(end, first + node.count - 1);
            //叠加本次结果
            result += last - first + 1;
            //更新最大
            max = last;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code21().maxDistinctElements(new int[]{1, 1, 1, 2, 2, 2, 4, 4, 4, 4}, 2));
    }

}
