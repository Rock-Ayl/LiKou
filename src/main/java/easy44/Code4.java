package easy44;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 4038. 统计特殊整数个数
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。
 * <p>
 * 如果整数 x 在 nums 中的所有出现位置都位于同一个 连续 区间内，则称 x 为 特殊整数。
 * <p>
 * 返回 nums 中 不同 特殊整数的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,2,2,1]
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * 1 出现在下标 0 和 3，形成了两个分离的区间，因此它不是特殊整数。
 * 2 在下标 [1, 2] 处形成一个连续区间，因此它是特殊整数。
 * 因此，共有一个特殊整数。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [3,3,1,2,2,1]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 3 在下标 [0, 1] 处形成一个连续区间，因此它是特殊整数。
 * 1 出现在下标 2 和 5，形成了两个分离的区间，因此它不是特殊整数。
 * 2 在下标 [3, 4] 处形成一个连续区间，因此它是特殊整数。
 * 因此，共有两个特殊整数。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Code4 {

    private static class Node {

        //开始
        private int start;

        //结束
        private int end;

        //数字
        private int num;

        //初始化
        public Node(int start, int end, int num) {
            this.start = start;
            this.end = end;
            this.num = num;
        }

        //方便调试
        @Override
        public String toString() {
            return "Node{" +
                    "start=" + start +
                    ", end=" + end +
                    ", num=" + num +
                    '}';
        }

    }

    public int countSpecialIntegers(int[] nums) {

        /**
         * 构建节点列表
         */

        //初始化节点
        List<Node> nodeList = new ArrayList<>();
        //索引
        int index = 0;
        //循环
        while (index < nums.length) {
            //初始化节点
            Node node = new Node(index, index, nums[index++]);
            //组装
            nodeList.add(node);
            //循环
            while (index < nums.length && nums[index] == node.num) {
                //+1
                node.end++;
                index++;
            }
        }

        /**
         * 判断是否满足
         */

        return nodeList
                .stream()
                //按照数字分组
                .collect(Collectors.groupingBy((Node node) -> node.num))
                .values()
                .stream()
                //只需要出现过一次的
                .filter((List<Node> nodes) -> nodes.size() == 1)
                .collect(Collectors.toList())
                .size();
    }

    public static void main(String[] args) {
        System.out.println(new Code4().countSpecialIntegers(new int[]{1, 2, 2, 1}));
    }

}
